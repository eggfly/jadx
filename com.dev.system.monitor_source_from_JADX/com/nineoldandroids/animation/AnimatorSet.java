package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator {
    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap<Animator, Node> mNodeMap;
    private ArrayList<Node> mNodes;
    private ArrayList<Animator> mPlayingSet;
    private AnimatorSetListener mSetListener;
    private ArrayList<Node> mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;

    public class Builder {
        private Node mCurrentNode;

        Builder(Animator anim) {
            this.mCurrentNode = (Node) AnimatorSet.this.mNodeMap.get(anim);
            if (this.mCurrentNode == null) {
                this.mCurrentNode = new Node(anim);
                AnimatorSet.this.mNodeMap.put(anim, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder with(Animator anim) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                AnimatorSet.this.mNodeMap.put(anim, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }

        public Builder before(Animator anim) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                AnimatorSet.this.mNodeMap.put(anim, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder after(Animator anim) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(anim);
            if (node == null) {
                node = new Node(anim);
                AnimatorSet.this.mNodeMap.put(anim, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }

        public Builder after(long delay) {
            Animator anim = ValueAnimator.ofFloat(0.0f, 1.0f);
            anim.setDuration(delay);
            after(anim);
            return this;
        }
    }

    private static class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;

        public Dependency(Node node, int rule) {
            this.node = node;
            this.rule = rule;
        }
    }

    private static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies;
        public boolean done;
        public ArrayList<Node> nodeDependencies;
        public ArrayList<Node> nodeDependents;
        public ArrayList<Dependency> tmpDependencies;

        public Node(Animator animation) {
            this.dependencies = null;
            this.tmpDependencies = null;
            this.nodeDependencies = null;
            this.nodeDependents = null;
            this.done = false;
            this.animation = animation;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList();
                this.nodeDependencies = new ArrayList();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node dependencyNode = dependency.node;
            if (dependencyNode.nodeDependents == null) {
                dependencyNode.nodeDependents = new ArrayList();
            }
            dependencyNode.nodeDependents.add(this);
        }

        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.clone();
                return node;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    private class AnimatorSetListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        public void onAnimationCancel(Animator animation) {
            if (!AnimatorSet.this.mTerminated && AnimatorSet.this.mPlayingSet.size() == 0 && AnimatorSet.this.mListeners != null) {
                int numListeners = AnimatorSet.this.mListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    ((AnimatorListener) AnimatorSet.this.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }

        public void onAnimationEnd(Animator animation) {
            animation.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animation);
            ((Node) this.mAnimatorSet.mNodeMap.get(animation)).done = true;
            if (!AnimatorSet.this.mTerminated) {
                int i;
                ArrayList<Node> sortedNodes = this.mAnimatorSet.mSortedNodes;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
                for (i = 0; i < numSortedNodes; i++) {
                    if (!((Node) sortedNodes.get(i)).done) {
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    if (AnimatorSet.this.mListeners != null) {
                        ArrayList<AnimatorListener> tmpListeners = (ArrayList) AnimatorSet.this.mListeners.clone();
                        int numListeners = tmpListeners.size();
                        for (i = 0; i < numListeners; i++) {
                            ((AnimatorListener) tmpListeners.get(i)).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    this.mAnimatorSet.mStarted = false;
                }
            }
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationStart(Animator animation) {
        }
    }

    private static class DependencyListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = rule;
        }

        public void onAnimationCancel(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            if (this.mRule == 1) {
                startIfReady(animation);
            }
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationStart(Animator animation) {
            if (this.mRule == 0) {
                startIfReady(animation);
            }
        }

        private void startIfReady(Animator dependencyAnimation) {
            if (!this.mAnimatorSet.mTerminated) {
                Dependency dependencyToRemove = null;
                int numDependencies = this.mNode.tmpDependencies.size();
                for (int i = 0; i < numDependencies; i++) {
                    Dependency dependency = (Dependency) this.mNode.tmpDependencies.get(i);
                    if (dependency.rule == this.mRule && dependency.node.animation == dependencyAnimation) {
                        dependencyToRemove = dependency;
                        dependencyAnimation.removeListener(this);
                        break;
                    }
                }
                this.mNode.tmpDependencies.remove(dependencyToRemove);
                if (this.mNode.tmpDependencies.size() == 0) {
                    this.mNode.animation.start();
                    this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                }
            }
        }
    }

    /* renamed from: com.nineoldandroids.animation.AnimatorSet.1 */
    class C02581 extends AnimatorListenerAdapter {
        boolean canceled;
        final /* synthetic */ ArrayList val$nodesToStart;

        C02581(ArrayList arrayList) {
            this.val$nodesToStart = arrayList;
            this.canceled = false;
        }

        public void onAnimationCancel(Animator anim) {
            this.canceled = true;
        }

        public void onAnimationEnd(Animator anim) {
            if (!this.canceled) {
                int numNodes = this.val$nodesToStart.size();
                for (int i = 0; i < numNodes; i++) {
                    Node node = (Node) this.val$nodesToStart.get(i);
                    node.animation.start();
                    AnimatorSet.this.mPlayingSet.add(node.animation);
                }
            }
        }
    }

    public AnimatorSet() {
        this.mPlayingSet = new ArrayList();
        this.mNodeMap = new HashMap();
        this.mNodes = new ArrayList();
        this.mSortedNodes = new ArrayList();
        this.mNeedsSort = true;
        this.mSetListener = null;
        this.mTerminated = false;
        this.mStarted = false;
        this.mStartDelay = 0;
        this.mDelayAnim = null;
        this.mDuration = -1;
    }

    public void playTogether(Animator... items) {
        if (items != null) {
            this.mNeedsSort = true;
            Builder builder = play(items[0]);
            for (int i = 1; i < items.length; i++) {
                builder.with(items[i]);
            }
        }
    }

    public void playTogether(Collection<Animator> items) {
        if (items != null && items.size() > 0) {
            this.mNeedsSort = true;
            Builder builder = null;
            for (Animator anim : items) {
                if (builder == null) {
                    builder = play(anim);
                } else {
                    builder.with(anim);
                }
            }
        }
    }

    public void playSequentially(Animator... items) {
        if (items != null) {
            this.mNeedsSort = true;
            if (items.length == 1) {
                play(items[0]);
                return;
            }
            for (int i = 0; i < items.length - 1; i++) {
                play(items[i]).before(items[i + 1]);
            }
        }
    }

    public void playSequentially(List<Animator> items) {
        if (items != null && items.size() > 0) {
            this.mNeedsSort = true;
            if (items.size() == 1) {
                play((Animator) items.get(0));
                return;
            }
            for (int i = 0; i < items.size() - 1; i++) {
                play((Animator) items.get(i)).before((Animator) items.get(i + 1));
            }
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> childList = new ArrayList();
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            childList.add(((Node) i$.next()).animation);
        }
        return childList;
    }

    public void setTarget(Object target) {
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            Animator animation = ((Node) i$.next()).animation;
            if (animation instanceof AnimatorSet) {
                ((AnimatorSet) animation).setTarget(target);
            } else if (animation instanceof ObjectAnimator) {
                ((ObjectAnimator) animation).setTarget(target);
            }
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            ((Node) i$.next()).animation.setInterpolator(interpolator);
        }
    }

    public Builder play(Animator anim) {
        if (anim == null) {
            return null;
        }
        this.mNeedsSort = true;
        return new Builder(anim);
    }

    public void cancel() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator i$;
            ArrayList<AnimatorListener> tmpListeners = null;
            if (this.mListeners != null) {
                tmpListeners = (ArrayList) this.mListeners.clone();
                i$ = tmpListeners.iterator();
                while (i$.hasNext()) {
                    ((AnimatorListener) i$.next()).onAnimationCancel(this);
                }
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                i$ = this.mSortedNodes.iterator();
                while (i$.hasNext()) {
                    ((Node) i$.next()).animation.cancel();
                }
            }
            if (tmpListeners != null) {
                i$ = tmpListeners.iterator();
                while (i$.hasNext()) {
                    ((AnimatorListener) i$.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator i$;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                i$ = this.mSortedNodes.iterator();
                while (i$.hasNext()) {
                    Node node = (Node) i$.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    node.animation.addListener(this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                i$ = this.mSortedNodes.iterator();
                while (i$.hasNext()) {
                    ((Node) i$.next()).animation.end();
                }
            }
            if (this.mListeners != null) {
                i$ = ((ArrayList) this.mListeners.clone()).iterator();
                while (i$.hasNext()) {
                    ((AnimatorListener) i$.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public boolean isRunning() {
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            if (((Node) i$.next()).animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public void setStartDelay(long startDelay) {
        this.mStartDelay = startDelay;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public AnimatorSet setDuration(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            ((Node) i$.next()).animation.setDuration(duration);
        }
        this.mDuration = duration;
        return this;
    }

    public void setupStartValues() {
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            ((Node) i$.next()).animation.setupStartValues();
        }
    }

    public void setupEndValues() {
        Iterator i$ = this.mNodes.iterator();
        while (i$.hasNext()) {
            ((Node) i$.next()).animation.setupEndValues();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r22 = this;
        r17 = 0;
        r0 = r17;
        r1 = r22;
        r1.mTerminated = r0;
        r17 = 1;
        r0 = r17;
        r1 = r22;
        r1.mStarted = r0;
        r22.sortNodes();
        r0 = r22;
        r0 = r0.mSortedNodes;
        r17 = r0;
        r14 = r17.size();
        r6 = 0;
    L_0x001e:
        if (r6 >= r14) goto L_0x006c;
    L_0x0020:
        r0 = r22;
        r0 = r0.mSortedNodes;
        r17 = r0;
        r0 = r17;
        r10 = r0.get(r6);
        r10 = (com.nineoldandroids.animation.AnimatorSet.Node) r10;
        r0 = r10.animation;
        r17 = r0;
        r15 = r17.getListeners();
        if (r15 == 0) goto L_0x0069;
    L_0x0038:
        r17 = r15.size();
        if (r17 <= 0) goto L_0x0069;
    L_0x003e:
        r4 = new java.util.ArrayList;
        r4.<init>(r15);
        r7 = r4.iterator();
    L_0x0047:
        r17 = r7.hasNext();
        if (r17 == 0) goto L_0x0069;
    L_0x004d:
        r9 = r7.next();
        r9 = (com.nineoldandroids.animation.Animator.AnimatorListener) r9;
        r0 = r9 instanceof com.nineoldandroids.animation.AnimatorSet.DependencyListener;
        r17 = r0;
        if (r17 != 0) goto L_0x005f;
    L_0x0059:
        r0 = r9 instanceof com.nineoldandroids.animation.AnimatorSet.AnimatorSetListener;
        r17 = r0;
        if (r17 == 0) goto L_0x0047;
    L_0x005f:
        r0 = r10.animation;
        r17 = r0;
        r0 = r17;
        r0.removeListener(r9);
        goto L_0x0047;
    L_0x0069:
        r6 = r6 + 1;
        goto L_0x001e;
    L_0x006c:
        r11 = new java.util.ArrayList;
        r11.<init>();
        r6 = 0;
    L_0x0072:
        if (r6 >= r14) goto L_0x0103;
    L_0x0074:
        r0 = r22;
        r0 = r0.mSortedNodes;
        r17 = r0;
        r0 = r17;
        r10 = r0.get(r6);
        r10 = (com.nineoldandroids.animation.AnimatorSet.Node) r10;
        r0 = r22;
        r0 = r0.mSetListener;
        r17 = r0;
        if (r17 != 0) goto L_0x009b;
    L_0x008a:
        r17 = new com.nineoldandroids.animation.AnimatorSet$AnimatorSetListener;
        r0 = r17;
        r1 = r22;
        r2 = r22;
        r0.<init>(r2);
        r0 = r17;
        r1 = r22;
        r1.mSetListener = r0;
    L_0x009b:
        r0 = r10.dependencies;
        r17 = r0;
        if (r17 == 0) goto L_0x00ab;
    L_0x00a1:
        r0 = r10.dependencies;
        r17 = r0;
        r17 = r17.size();
        if (r17 != 0) goto L_0x00be;
    L_0x00ab:
        r11.add(r10);
    L_0x00ae:
        r0 = r10.animation;
        r17 = r0;
        r0 = r22;
        r0 = r0.mSetListener;
        r18 = r0;
        r17.addListener(r18);
        r6 = r6 + 1;
        goto L_0x0072;
    L_0x00be:
        r0 = r10.dependencies;
        r17 = r0;
        r12 = r17.size();
        r8 = 0;
    L_0x00c7:
        if (r8 >= r12) goto L_0x00f4;
    L_0x00c9:
        r0 = r10.dependencies;
        r17 = r0;
        r0 = r17;
        r5 = r0.get(r8);
        r5 = (com.nineoldandroids.animation.AnimatorSet.Dependency) r5;
        r0 = r5.node;
        r17 = r0;
        r0 = r17;
        r0 = r0.animation;
        r17 = r0;
        r18 = new com.nineoldandroids.animation.AnimatorSet$DependencyListener;
        r0 = r5.rule;
        r19 = r0;
        r0 = r18;
        r1 = r22;
        r2 = r19;
        r0.<init>(r1, r10, r2);
        r17.addListener(r18);
        r8 = r8 + 1;
        goto L_0x00c7;
    L_0x00f4:
        r0 = r10.dependencies;
        r17 = r0;
        r17 = r17.clone();
        r17 = (java.util.ArrayList) r17;
        r0 = r17;
        r10.tmpDependencies = r0;
        goto L_0x00ae;
    L_0x0103:
        r0 = r22;
        r0 = r0.mStartDelay;
        r18 = r0;
        r20 = 0;
        r17 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
        if (r17 > 0) goto L_0x0134;
    L_0x010f:
        r7 = r11.iterator();
    L_0x0113:
        r17 = r7.hasNext();
        if (r17 == 0) goto L_0x0173;
    L_0x0119:
        r10 = r7.next();
        r10 = (com.nineoldandroids.animation.AnimatorSet.Node) r10;
        r0 = r10.animation;
        r17 = r0;
        r17.start();
        r0 = r22;
        r0 = r0.mPlayingSet;
        r17 = r0;
        r0 = r10.animation;
        r18 = r0;
        r17.add(r18);
        goto L_0x0113;
    L_0x0134:
        r17 = 2;
        r0 = r17;
        r0 = new float[r0];
        r17 = r0;
        r17 = {0, 1065353216};
        r17 = com.nineoldandroids.animation.ValueAnimator.ofFloat(r17);
        r0 = r17;
        r1 = r22;
        r1.mDelayAnim = r0;
        r0 = r22;
        r0 = r0.mDelayAnim;
        r17 = r0;
        r0 = r22;
        r0 = r0.mStartDelay;
        r18 = r0;
        r17.setDuration(r18);
        r0 = r22;
        r0 = r0.mDelayAnim;
        r17 = r0;
        r18 = new com.nineoldandroids.animation.AnimatorSet$1;
        r0 = r18;
        r1 = r22;
        r0.<init>(r11);
        r17.addListener(r18);
        r0 = r22;
        r0 = r0.mDelayAnim;
        r17 = r0;
        r17.start();
    L_0x0173:
        r0 = r22;
        r0 = r0.mListeners;
        r17 = r0;
        if (r17 == 0) goto L_0x01a0;
    L_0x017b:
        r0 = r22;
        r0 = r0.mListeners;
        r17 = r0;
        r16 = r17.clone();
        r16 = (java.util.ArrayList) r16;
        r13 = r16.size();
        r6 = 0;
    L_0x018c:
        if (r6 >= r13) goto L_0x01a0;
    L_0x018e:
        r0 = r16;
        r17 = r0.get(r6);
        r17 = (com.nineoldandroids.animation.Animator.AnimatorListener) r17;
        r0 = r17;
        r1 = r22;
        r0.onAnimationStart(r1);
        r6 = r6 + 1;
        goto L_0x018c;
    L_0x01a0:
        r0 = r22;
        r0 = r0.mNodes;
        r17 = r0;
        r17 = r17.size();
        if (r17 != 0) goto L_0x01ed;
    L_0x01ac:
        r0 = r22;
        r0 = r0.mStartDelay;
        r18 = r0;
        r20 = 0;
        r17 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
        if (r17 != 0) goto L_0x01ed;
    L_0x01b8:
        r17 = 0;
        r0 = r17;
        r1 = r22;
        r1.mStarted = r0;
        r0 = r22;
        r0 = r0.mListeners;
        r17 = r0;
        if (r17 == 0) goto L_0x01ed;
    L_0x01c8:
        r0 = r22;
        r0 = r0.mListeners;
        r17 = r0;
        r16 = r17.clone();
        r16 = (java.util.ArrayList) r16;
        r13 = r16.size();
        r6 = 0;
    L_0x01d9:
        if (r6 >= r13) goto L_0x01ed;
    L_0x01db:
        r0 = r16;
        r17 = r0.get(r6);
        r17 = (com.nineoldandroids.animation.Animator.AnimatorListener) r17;
        r0 = r17;
        r1 = r22;
        r0.onAnimationEnd(r1);
        r6 = r6 + 1;
        goto L_0x01d9;
    L_0x01ed:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.AnimatorSet.start():void");
    }

    public AnimatorSet clone() {
        Iterator i$;
        AnimatorSet anim = (AnimatorSet) super.clone();
        anim.mNeedsSort = true;
        anim.mTerminated = false;
        anim.mStarted = false;
        anim.mPlayingSet = new ArrayList();
        anim.mNodeMap = new HashMap();
        anim.mNodes = new ArrayList();
        anim.mSortedNodes = new ArrayList();
        HashMap<Node, Node> nodeCloneMap = new HashMap();
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            Node node = (Node) it.next();
            Node nodeClone = node.clone();
            nodeCloneMap.put(node, nodeClone);
            anim.mNodes.add(nodeClone);
            anim.mNodeMap.put(nodeClone.animation, nodeClone);
            nodeClone.dependencies = null;
            nodeClone.tmpDependencies = null;
            nodeClone.nodeDependents = null;
            nodeClone.nodeDependencies = null;
            ArrayList<AnimatorListener> cloneListeners = nodeClone.animation.getListeners();
            if (cloneListeners != null) {
                ArrayList<AnimatorListener> listenersToRemove = null;
                i$ = cloneListeners.iterator();
                while (i$.hasNext()) {
                    AnimatorListener listener = (AnimatorListener) i$.next();
                    if (listener instanceof AnimatorSetListener) {
                        if (listenersToRemove == null) {
                            listenersToRemove = new ArrayList();
                        }
                        listenersToRemove.add(listener);
                    }
                }
                if (listenersToRemove != null) {
                    i$ = listenersToRemove.iterator();
                    while (i$.hasNext()) {
                        cloneListeners.remove((AnimatorListener) i$.next());
                    }
                }
            }
        }
        it = this.mNodes.iterator();
        while (it.hasNext()) {
            node = (Node) it.next();
            nodeClone = (Node) nodeCloneMap.get(node);
            if (node.dependencies != null) {
                i$ = node.dependencies.iterator();
                while (i$.hasNext()) {
                    Dependency dependency = (Dependency) i$.next();
                    nodeClone.addDependency(new Dependency((Node) nodeCloneMap.get(dependency.node), dependency.rule));
                }
            }
        }
        return anim;
    }

    private void sortNodes() {
        int numNodes;
        int i;
        Node node;
        int j;
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            ArrayList<Node> roots = new ArrayList();
            numNodes = this.mNodes.size();
            for (i = 0; i < numNodes; i++) {
                node = (Node) this.mNodes.get(i);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    roots.add(node);
                }
            }
            ArrayList<Node> tmpRoots = new ArrayList();
            while (roots.size() > 0) {
                int numRoots = roots.size();
                for (i = 0; i < numRoots; i++) {
                    Node root = (Node) roots.get(i);
                    this.mSortedNodes.add(root);
                    if (root.nodeDependents != null) {
                        int numDependents = root.nodeDependents.size();
                        for (j = 0; j < numDependents; j++) {
                            node = (Node) root.nodeDependents.get(j);
                            node.nodeDependencies.remove(root);
                            if (node.nodeDependencies.size() == 0) {
                                tmpRoots.add(node);
                            }
                        }
                    }
                }
                roots.clear();
                roots.addAll(tmpRoots);
                tmpRoots.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        numNodes = this.mNodes.size();
        for (i = 0; i < numNodes; i++) {
            node = (Node) this.mNodes.get(i);
            if (node.dependencies != null && node.dependencies.size() > 0) {
                int numDependencies = node.dependencies.size();
                for (j = 0; j < numDependencies; j++) {
                    Dependency dependency = (Dependency) node.dependencies.get(j);
                    if (node.nodeDependencies == null) {
                        node.nodeDependencies = new ArrayList();
                    }
                    if (!node.nodeDependencies.contains(dependency.node)) {
                        node.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node.done = false;
        }
    }
}
