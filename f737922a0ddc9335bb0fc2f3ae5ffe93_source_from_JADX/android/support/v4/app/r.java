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

class r {

    public interface b {
        View j6();
    }

    static class 1 extends EpicenterCallback {
        final /* synthetic */ Rect j6;

        1(Rect rect) {
            this.j6 = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.j6;
        }
    }

    static class 2 implements OnPreDrawListener {
        final /* synthetic */ Transition DW;
        final /* synthetic */ View FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ ArrayList VH;
        final /* synthetic */ Map Zo;
        final /* synthetic */ View j6;
        final /* synthetic */ Map v5;

        2(View view, Transition transition, View view2, b bVar, Map map, Map map2, ArrayList arrayList) {
            this.j6 = view;
            this.DW = transition;
            this.FH = view2;
            this.Hw = bVar;
            this.v5 = map;
            this.Zo = map2;
            this.VH = arrayList;
        }

        public boolean onPreDraw() {
            this.j6.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.DW != null) {
                this.DW.removeTarget(this.FH);
            }
            View j6 = this.Hw.j6();
            if (j6 != null) {
                if (!this.v5.isEmpty()) {
                    r.j6(this.Zo, j6);
                    this.Zo.keySet().retainAll(this.v5.values());
                    for (Entry entry : this.v5.entrySet()) {
                        View view = (View) this.Zo.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.DW != null) {
                    r.DW(this.VH, j6);
                    this.VH.removeAll(this.Zo.values());
                    this.VH.add(this.FH);
                    r.DW(this.DW, this.VH);
                }
            }
            return true;
        }
    }

    static class 3 extends EpicenterCallback {
        private Rect DW;
        final /* synthetic */ a j6;

        3(a aVar) {
            this.j6 = aVar;
        }

        public Rect onGetEpicenter(Transition transition) {
            if (this.DW == null && this.j6.j6 != null) {
                this.DW = r.FH(this.j6.j6);
            }
            return this.DW;
        }
    }

    static class 4 implements OnPreDrawListener {
        final /* synthetic */ Transition DW;
        final /* synthetic */ View EQ;
        final /* synthetic */ ArrayList FH;
        final /* synthetic */ Transition Hw;
        final /* synthetic */ ArrayList VH;
        final /* synthetic */ Transition Zo;
        final /* synthetic */ Map gn;
        final /* synthetic */ View j6;
        final /* synthetic */ Transition tp;
        final /* synthetic */ ArrayList u7;
        final /* synthetic */ ArrayList v5;

        4(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.j6 = view;
            this.DW = transition;
            this.FH = arrayList;
            this.Hw = transition2;
            this.v5 = arrayList2;
            this.Zo = transition3;
            this.VH = arrayList3;
            this.gn = map;
            this.u7 = arrayList4;
            this.tp = transition4;
            this.EQ = view2;
        }

        public boolean onPreDraw() {
            this.j6.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.DW != null) {
                r.j6(this.DW, this.FH);
            }
            if (this.Hw != null) {
                r.j6(this.Hw, this.v5);
            }
            if (this.Zo != null) {
                r.j6(this.Zo, this.VH);
            }
            for (Entry entry : this.gn.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.u7.size();
            for (int i = 0; i < size; i++) {
                this.tp.excludeTarget((View) this.u7.get(i), false);
            }
            this.tp.excludeTarget(this.EQ, false);
            return true;
        }
    }

    public static class a {
        public View j6;
    }

    public static String j6(View view) {
        return view.getTransitionName();
    }

    public static Object j6(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object j6(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        DW((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        DW((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static void j6(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void j6(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void j6(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new 1(FH(view)));
    }

    public static Object DW(Object obj) {
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

    public static void j6(Object obj, Object obj2, View view, b bVar, View view2, a aVar, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                j6(obj2, view2, (Map) map2, (ArrayList) arrayList2);
            }
            if (bVar != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new 2(view, transition, view2, bVar, map, map3, arrayList));
            }
            j6(transition, aVar);
        }
    }

    public static Object j6(Object obj, Object obj2, Object obj3, boolean z) {
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

    public static void j6(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            j6(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        DW(obj, (ArrayList) arrayList);
    }

    private static void j6(List<View> list, View view) {
        int size = list.size();
        if (!j6((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!j6((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean j6(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    private static void j6(Transition transition, a aVar) {
        if (transition != null) {
            transition.setEpicenterCallback(new 3(aVar));
        }
    }

    private static Rect FH(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    private static void DW(ArrayList<View> arrayList, View view) {
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
                DW((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void j6(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    j6((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void j6(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new 4(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
        }
    }

    public static void j6(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                j6(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!j6(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void DW(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                DW(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!j6(transition) && j6(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean j6(Transition transition) {
        return (j6(transition.getTargetIds()) && j6(transition.getTargetNames()) && j6(transition.getTargetTypes())) ? false : true;
    }

    private static boolean j6(List list) {
        return list == null || list.isEmpty();
    }
}
