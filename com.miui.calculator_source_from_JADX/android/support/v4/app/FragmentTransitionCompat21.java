package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class FragmentTransitionCompat21 {

    public interface ViewRetriever {
        View m84a();
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.1 */
    final class C00241 extends EpicenterCallback {
        final /* synthetic */ Rect f268a;

        C00241(Rect rect) {
            this.f268a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f268a;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.2 */
    final class C00252 implements OnPreDrawListener {
        final /* synthetic */ View f269a;
        final /* synthetic */ Transition f270b;
        final /* synthetic */ View f271c;
        final /* synthetic */ ViewRetriever f272d;
        final /* synthetic */ Map f273e;
        final /* synthetic */ Map f274f;
        final /* synthetic */ ArrayList f275g;

        C00252(View view, Transition transition, View view2, ViewRetriever viewRetriever, Map map, Map map2, ArrayList arrayList) {
            this.f269a = view;
            this.f270b = transition;
            this.f271c = view2;
            this.f272d = viewRetriever;
            this.f273e = map;
            this.f274f = map2;
            this.f275g = arrayList;
        }

        public boolean onPreDraw() {
            this.f269a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f270b != null) {
                this.f270b.removeTarget(this.f271c);
            }
            View a = this.f272d.m84a();
            if (a != null) {
                if (!this.f273e.isEmpty()) {
                    FragmentTransitionCompat21.m405a(this.f274f, a);
                    this.f274f.keySet().retainAll(this.f273e.values());
                    for (Entry entry : this.f273e.entrySet()) {
                        View view = (View) this.f274f.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f270b != null) {
                    FragmentTransitionCompat21.m412b(this.f275g, a);
                    this.f275g.removeAll(this.f274f.values());
                    this.f275g.add(this.f271c);
                    FragmentTransitionCompat21.m411b(this.f270b, this.f275g);
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.3 */
    final class C00263 extends EpicenterCallback {
        final /* synthetic */ EpicenterView f276a;
        private Rect f277b;

        C00263(EpicenterView epicenterView) {
            this.f276a = epicenterView;
        }

        public Rect onGetEpicenter(Transition transition) {
            if (this.f277b == null && this.f276a.f289a != null) {
                this.f277b = FragmentTransitionCompat21.m413c(this.f276a.f289a);
            }
            return this.f277b;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21.4 */
    final class C00274 implements OnPreDrawListener {
        final /* synthetic */ View f278a;
        final /* synthetic */ Transition f279b;
        final /* synthetic */ ArrayList f280c;
        final /* synthetic */ Transition f281d;
        final /* synthetic */ ArrayList f282e;
        final /* synthetic */ Transition f283f;
        final /* synthetic */ ArrayList f284g;
        final /* synthetic */ Map f285h;
        final /* synthetic */ ArrayList f286i;
        final /* synthetic */ Transition f287j;
        final /* synthetic */ View f288k;

        C00274(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.f278a = view;
            this.f279b = transition;
            this.f280c = arrayList;
            this.f281d = transition2;
            this.f282e = arrayList2;
            this.f283f = transition3;
            this.f284g = arrayList3;
            this.f285h = map;
            this.f286i = arrayList4;
            this.f287j = transition4;
            this.f288k = view2;
        }

        public boolean onPreDraw() {
            this.f278a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f279b != null) {
                FragmentTransitionCompat21.m402a(this.f279b, this.f280c);
            }
            if (this.f281d != null) {
                FragmentTransitionCompat21.m402a(this.f281d, this.f282e);
            }
            if (this.f283f != null) {
                FragmentTransitionCompat21.m402a(this.f283f, this.f284g);
            }
            for (Entry entry : this.f285h.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.f286i.size();
            for (int i = 0; i < size; i++) {
                this.f287j.excludeTarget((View) this.f286i.get(i), false);
            }
            this.f287j.excludeTarget(this.f288k, false);
            return true;
        }
    }

    public static class EpicenterView {
        public View f289a;
    }

    FragmentTransitionCompat21() {
    }

    public static String m394a(View view) {
        return view.getTransitionName();
    }

    public static Object m391a(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object m392a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        m412b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        m411b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static void m400a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m397a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void m398a(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new C00241(m413c(view)));
    }

    public static Object m410b(Object obj) {
        if (obj == null) {
            return null;
        }
        Transition transition = (Transition) obj;
        if (transition == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    public static void m401a(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                m399a(obj2, view2, (Map) map2, (ArrayList) arrayList2);
            }
            if (viewRetriever != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new C00252(view, transition, view2, viewRetriever, map, map3, arrayList));
            }
            m395a(transition, epicenterView);
        }
    }

    public static Object m393a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        Object transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static void m399a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m404a(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        m411b(obj, (ArrayList) arrayList);
    }

    private static void m404a(List<View> list, View view) {
        int size = list.size();
        if (!m408a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m408a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean m408a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    private static void m395a(Transition transition, EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new C00263(epicenterView));
        }
    }

    private static Rect m413c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    private static void m412b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m412b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void m405a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m405a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m396a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C00274(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
        }
    }

    public static void m402a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                m402a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!m406a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void m411b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                m411b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!m406a(transition) && m407a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean m406a(Transition transition) {
        return (m407a(transition.getTargetIds()) && m407a(transition.getTargetNames()) && m407a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m407a(List list) {
        return list == null || list.isEmpty();
    }
}
