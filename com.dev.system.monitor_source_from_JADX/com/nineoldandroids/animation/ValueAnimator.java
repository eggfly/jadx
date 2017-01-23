package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class ValueAnimator extends Animator {
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private static ThreadLocal<AnimationHandler> sAnimationHandler;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations;
    private static final Interpolator sDefaultInterpolator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims;
    private static final TypeEvaluator sFloatEvaluator;
    private static long sFrameDelay;
    private static final TypeEvaluator sIntEvaluator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims;
    private float mCurrentFraction;
    private int mCurrentIteration;
    private long mDelayStartTime;
    private long mDuration;
    boolean mInitialized;
    private Interpolator mInterpolator;
    private boolean mPlayingBackwards;
    int mPlayingState;
    private int mRepeatCount;
    private int mRepeatMode;
    private boolean mRunning;
    long mSeekTime;
    private long mStartDelay;
    long mStartTime;
    private boolean mStarted;
    private boolean mStartedDelay;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.1 */
    static class C01651 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C01651() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.2 */
    static class C01662 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C01662() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.3 */
    static class C01673 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C01673() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.4 */
    static class C01684 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C01684() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.5 */
    static class C01695 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C01695() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    private static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message msg) {
            int i;
            ValueAnimator anim;
            boolean callAgain = true;
            ArrayList<ValueAnimator> animations = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList<ValueAnimator> delayedAnims = (ArrayList) ValueAnimator.sDelayedAnims.get();
            switch (msg.what) {
                case ValueAnimator.ANIMATION_START /*0*/:
                    ArrayList<ValueAnimator> pendingAnimations = (ArrayList) ValueAnimator.sPendingAnimations.get();
                    if (animations.size() > 0 || delayedAnims.size() > 0) {
                        callAgain = false;
                    }
                    while (pendingAnimations.size() > 0) {
                        ArrayList<ValueAnimator> pendingCopy = (ArrayList) pendingAnimations.clone();
                        pendingAnimations.clear();
                        int count = pendingCopy.size();
                        for (i = ValueAnimator.ANIMATION_START; i < count; i += ValueAnimator.RUNNING) {
                            anim = (ValueAnimator) pendingCopy.get(i);
                            if (anim.mStartDelay == 0) {
                                anim.startAnimation();
                            } else {
                                delayedAnims.add(anim);
                            }
                        }
                    }
                    break;
                case ValueAnimator.RUNNING /*1*/:
                    break;
                default:
                    return;
            }
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            ArrayList<ValueAnimator> readyAnims = (ArrayList) ValueAnimator.sReadyAnims.get();
            ArrayList<ValueAnimator> endingAnims = (ArrayList) ValueAnimator.sEndingAnims.get();
            int numDelayedAnims = delayedAnims.size();
            for (i = ValueAnimator.ANIMATION_START; i < numDelayedAnims; i += ValueAnimator.RUNNING) {
                anim = (ValueAnimator) delayedAnims.get(i);
                if (anim.delayedAnimationFrame(currentTime)) {
                    readyAnims.add(anim);
                }
            }
            int numReadyAnims = readyAnims.size();
            if (numReadyAnims > 0) {
                for (i = ValueAnimator.ANIMATION_START; i < numReadyAnims; i += ValueAnimator.RUNNING) {
                    anim = (ValueAnimator) readyAnims.get(i);
                    anim.startAnimation();
                    anim.mRunning = true;
                    delayedAnims.remove(anim);
                }
                readyAnims.clear();
            }
            int numAnims = animations.size();
            i = ValueAnimator.ANIMATION_START;
            while (i < numAnims) {
                anim = (ValueAnimator) animations.get(i);
                if (anim.animationFrame(currentTime)) {
                    endingAnims.add(anim);
                }
                if (animations.size() == numAnims) {
                    i += ValueAnimator.RUNNING;
                } else {
                    numAnims += ValueAnimator.INFINITE;
                    endingAnims.remove(anim);
                }
            }
            if (endingAnims.size() > 0) {
                for (i = ValueAnimator.ANIMATION_START; i < endingAnims.size(); i += ValueAnimator.RUNNING) {
                    ((ValueAnimator) endingAnims.get(i)).endAnimation();
                }
                endingAnims.clear();
            }
            if (!callAgain) {
                return;
            }
            if (!animations.isEmpty() || !delayedAnims.isEmpty()) {
                sendEmptyMessageDelayed(ValueAnimator.RUNNING, Math.max(0, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    static {
        sAnimationHandler = new ThreadLocal();
        sAnimations = new C01651();
        sPendingAnimations = new C01662();
        sDelayedAnims = new C01673();
        sEndingAnims = new C01684();
        sReadyAnims = new C01695();
        sDefaultInterpolator = new AccelerateDecelerateInterpolator();
        sIntEvaluator = new IntEvaluator();
        sFloatEvaluator = new FloatEvaluator();
        sFrameDelay = DEFAULT_FRAME_DELAY;
    }

    public ValueAnimator() {
        this.mSeekTime = -1;
        this.mPlayingBackwards = false;
        this.mCurrentIteration = ANIMATION_START;
        this.mCurrentFraction = 0.0f;
        this.mStartedDelay = false;
        this.mPlayingState = ANIMATION_START;
        this.mRunning = false;
        this.mStarted = false;
        this.mInitialized = false;
        this.mDuration = 300;
        this.mStartDelay = 0;
        this.mRepeatCount = ANIMATION_START;
        this.mRepeatMode = RUNNING;
        this.mInterpolator = sDefaultInterpolator;
        this.mUpdateListeners = null;
    }

    public static ValueAnimator ofInt(int... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(values);
        return anim;
    }

    public static ValueAnimator ofFloat(float... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setFloatValues(values);
        return anim;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setValues(values);
        return anim;
    }

    public static ValueAnimator ofObject(TypeEvaluator evaluator, Object... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    public void setIntValues(int... values) {
        if (values != null && values.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofInt(BuildConfig.VERSION_NAME, values);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setIntValues(values);
            }
            this.mInitialized = false;
        }
    }

    public void setFloatValues(float... values) {
        if (values != null && values.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofFloat(BuildConfig.VERSION_NAME, values);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setFloatValues(values);
            }
            this.mInitialized = false;
        }
    }

    public void setObjectValues(Object... values) {
        if (values != null && values.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofObject(BuildConfig.VERSION_NAME, (TypeEvaluator) null, values);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setObjectValues(values);
            }
            this.mInitialized = false;
        }
    }

    public void setValues(PropertyValuesHolder... values) {
        int numValues = values.length;
        this.mValues = values;
        this.mValuesMap = new HashMap(numValues);
        for (int i = ANIMATION_START; i < numValues; i += RUNNING) {
            PropertyValuesHolder valuesHolder = values[i];
            this.mValuesMap.put(valuesHolder.getPropertyName(), valuesHolder);
        }
        this.mInitialized = false;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    void initAnimation() {
        if (!this.mInitialized) {
            int numValues = this.mValues.length;
            for (int i = ANIMATION_START; i < numValues; i += RUNNING) {
                this.mValues[i].init();
            }
            this.mInitialized = true;
        }
    }

    public ValueAnimator setDuration(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + duration);
        }
        this.mDuration = duration;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public void setCurrentPlayTime(long playTime) {
        initAnimation();
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != RUNNING) {
            this.mSeekTime = playTime;
            this.mPlayingState = SEEKED;
        }
        this.mStartTime = currentTime - playTime;
        animationFrame(currentTime);
    }

    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public void setStartDelay(long startDelay) {
        this.mStartDelay = startDelay;
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    public Object getAnimatedValue() {
        if (this.mValues == null || this.mValues.length <= 0) {
            return null;
        }
        return this.mValues[ANIMATION_START].getAnimatedValue();
    }

    public Object getAnimatedValue(String propertyName) {
        PropertyValuesHolder valuesHolder = (PropertyValuesHolder) this.mValuesMap.get(propertyName);
        if (valuesHolder != null) {
            return valuesHolder.getAnimatedValue();
        }
        return null;
    }

    public void setRepeatCount(int value) {
        this.mRepeatCount = value;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatMode(int value) {
        this.mRepeatMode = value;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void addUpdateListener(AnimatorUpdateListener listener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList();
        }
        this.mUpdateListeners.add(listener);
    }

    public void removeAllUpdateListeners() {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener listener) {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.remove(listener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void setInterpolator(Interpolator value) {
        if (value != null) {
            this.mInterpolator = value;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setEvaluator(TypeEvaluator value) {
        if (value != null && this.mValues != null && this.mValues.length > 0) {
            this.mValues[ANIMATION_START].setEvaluator(value);
        }
    }

    private void start(boolean playBackwards) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mPlayingBackwards = playBackwards;
        this.mCurrentIteration = ANIMATION_START;
        this.mPlayingState = ANIMATION_START;
        this.mStarted = true;
        this.mStartedDelay = false;
        ((ArrayList) sPendingAnimations.get()).add(this);
        if (this.mStartDelay == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.mPlayingState = ANIMATION_START;
            this.mRunning = true;
            if (this.mListeners != null) {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList) this.mListeners.clone();
                int numListeners = tmpListeners.size();
                for (int i = ANIMATION_START; i < numListeners; i += RUNNING) {
                    ((AnimatorListener) tmpListeners.get(i)).onAnimationStart(this);
                }
            }
        }
        AnimationHandler animationHandler = (AnimationHandler) sAnimationHandler.get();
        if (animationHandler == null) {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        }
        animationHandler.sendEmptyMessage(ANIMATION_START);
    }

    public void start() {
        start(false);
    }

    public void cancel() {
        if (this.mPlayingState != 0 || ((ArrayList) sPendingAnimations.get()).contains(this) || ((ArrayList) sDelayedAnims.get()).contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                Iterator i$ = ((ArrayList) this.mListeners.clone()).iterator();
                while (i$.hasNext()) {
                    ((AnimatorListener) i$.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public void end() {
        if (!((ArrayList) sAnimations.get()).contains(this) && !((ArrayList) sPendingAnimations.get()).contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        if (this.mRepeatCount <= 0 || (this.mRepeatCount & RUNNING) != RUNNING) {
            animateValue(1.0f);
        } else {
            animateValue(0.0f);
        }
        endAnimation();
    }

    public boolean isRunning() {
        return this.mPlayingState == RUNNING || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == RUNNING) {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentTime - (this.mDuration - (currentTime - this.mStartTime));
            return;
        }
        start(true);
    }

    private void endAnimation() {
        ((ArrayList) sAnimations.get()).remove(this);
        ((ArrayList) sPendingAnimations.get()).remove(this);
        ((ArrayList) sDelayedAnims.get()).remove(this);
        this.mPlayingState = ANIMATION_START;
        if (this.mRunning && this.mListeners != null) {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList) this.mListeners.clone();
            int numListeners = tmpListeners.size();
            for (int i = ANIMATION_START; i < numListeners; i += RUNNING) {
                ((AnimatorListener) tmpListeners.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    private void startAnimation() {
        initAnimation();
        ((ArrayList) sAnimations.get()).add(this);
        if (this.mStartDelay > 0 && this.mListeners != null) {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList) this.mListeners.clone();
            int numListeners = tmpListeners.size();
            for (int i = ANIMATION_START; i < numListeners; i += RUNNING) {
                ((AnimatorListener) tmpListeners.get(i)).onAnimationStart(this);
            }
        }
    }

    private boolean delayedAnimationFrame(long currentTime) {
        if (this.mStartedDelay) {
            long deltaTime = currentTime - this.mDelayStartTime;
            if (deltaTime > this.mStartDelay) {
                this.mStartTime = currentTime - (deltaTime - this.mStartDelay);
                this.mPlayingState = RUNNING;
                return true;
            }
        }
        this.mStartedDelay = true;
        this.mDelayStartTime = currentTime;
        return false;
    }

    boolean animationFrame(long currentTime) {
        boolean done = false;
        if (this.mPlayingState == 0) {
            this.mPlayingState = RUNNING;
            if (this.mSeekTime < 0) {
                this.mStartTime = currentTime;
            } else {
                this.mStartTime = currentTime - this.mSeekTime;
                this.mSeekTime = -1;
            }
        }
        switch (this.mPlayingState) {
            case RUNNING /*1*/:
            case SEEKED /*2*/:
                float fraction;
                if (this.mDuration > 0) {
                    fraction = ((float) (currentTime - this.mStartTime)) / ((float) this.mDuration);
                } else {
                    fraction = 1.0f;
                }
                if (fraction >= 1.0f) {
                    if (this.mCurrentIteration < this.mRepeatCount || this.mRepeatCount == INFINITE) {
                        if (this.mListeners != null) {
                            int numListeners = this.mListeners.size();
                            for (int i = ANIMATION_START; i < numListeners; i += RUNNING) {
                                ((AnimatorListener) this.mListeners.get(i)).onAnimationRepeat(this);
                            }
                        }
                        if (this.mRepeatMode == SEEKED) {
                            this.mPlayingBackwards = !this.mPlayingBackwards;
                        }
                        this.mCurrentIteration += (int) fraction;
                        fraction %= 1.0f;
                        this.mStartTime += this.mDuration;
                    } else {
                        done = true;
                        fraction = Math.min(fraction, 1.0f);
                    }
                }
                if (this.mPlayingBackwards) {
                    fraction = 1.0f - fraction;
                }
                animateValue(fraction);
                break;
        }
        return done;
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    void animateValue(float fraction) {
        int i;
        fraction = this.mInterpolator.getInterpolation(fraction);
        this.mCurrentFraction = fraction;
        int numValues = this.mValues.length;
        for (i = ANIMATION_START; i < numValues; i += RUNNING) {
            this.mValues[i].calculateValue(fraction);
        }
        if (this.mUpdateListeners != null) {
            int numListeners = this.mUpdateListeners.size();
            for (i = ANIMATION_START; i < numListeners; i += RUNNING) {
                ((AnimatorUpdateListener) this.mUpdateListeners.get(i)).onAnimationUpdate(this);
            }
        }
    }

    public ValueAnimator clone() {
        int i;
        ValueAnimator anim = (ValueAnimator) super.clone();
        if (this.mUpdateListeners != null) {
            ArrayList<AnimatorUpdateListener> oldListeners = this.mUpdateListeners;
            anim.mUpdateListeners = new ArrayList();
            int numListeners = oldListeners.size();
            for (i = ANIMATION_START; i < numListeners; i += RUNNING) {
                anim.mUpdateListeners.add(oldListeners.get(i));
            }
        }
        anim.mSeekTime = -1;
        anim.mPlayingBackwards = false;
        anim.mCurrentIteration = ANIMATION_START;
        anim.mInitialized = false;
        anim.mPlayingState = ANIMATION_START;
        anim.mStartedDelay = false;
        PropertyValuesHolder[] oldValues = this.mValues;
        if (oldValues != null) {
            int numValues = oldValues.length;
            anim.mValues = new PropertyValuesHolder[numValues];
            anim.mValuesMap = new HashMap(numValues);
            for (i = ANIMATION_START; i < numValues; i += RUNNING) {
                PropertyValuesHolder newValuesHolder = oldValues[i].clone();
                anim.mValues[i] = newValuesHolder;
                anim.mValuesMap.put(newValuesHolder.getPropertyName(), newValuesHolder);
            }
        }
        return anim;
    }

    public static int getCurrentAnimationsCount() {
        return ((ArrayList) sAnimations.get()).size();
    }

    public static void clearAllAnimations() {
        ((ArrayList) sAnimations.get()).clear();
        ((ArrayList) sPendingAnimations.get()).clear();
        ((ArrayList) sDelayedAnims.get()).clear();
    }

    public String toString() {
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.mValues != null) {
            for (int i = ANIMATION_START; i < this.mValues.length; i += RUNNING) {
                returnVal = returnVal + "\n    " + this.mValues[i].toString();
            }
        }
        return returnVal;
    }
}
