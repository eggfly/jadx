package com.aide.uidesigner;

import android.app.Activity;
import com.aide.common.m;
import com.aide.common.q;
import com.aide.common.q.a;
import com.aide.common.y;
import com.aide.ui.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g {

    static class 10 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<b> {
            final /* synthetic */ 10 j6;

            1(10 10) {
                this.j6 = 10;
            }

            public void j6(b bVar) {
                this.j6.j6.Hw(bVar);
            }
        }

        10(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Add before...";
        }

        public boolean v5() {
            return this.j6.u7();
        }

        public void j6() {
            k.FH(this.DW, "Add before " + this.j6.getNodeName() + "...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    static class 11 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<b> {
            final /* synthetic */ 11 j6;

            1(11 11) {
                this.j6 = 11;
            }

            public void j6(b bVar) {
                this.j6.j6.FH(bVar);
            }
        }

        11(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Add behind...";
        }

        public boolean v5() {
            return this.j6.tp();
        }

        public void j6() {
            k.FH(this.DW, "Add behind " + this.j6.getNodeName() + "...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    static class 12 implements a {
        final /* synthetic */ f DW;
        final /* synthetic */ Activity j6;

        class 1 implements y<b> {
            final /* synthetic */ 12 j6;

            1(12 12) {
                this.j6 = 12;
            }

            public void j6(b bVar) {
                this.j6.DW.DW(bVar);
            }
        }

        12(Activity activity, f fVar) {
            this.j6 = activity;
            this.DW = fVar;
        }

        public String DW() {
            return "Surround with...";
        }

        public boolean v5() {
            return true;
        }

        public void j6() {
            k.DW(this.j6, "Surround " + this.DW.getNodeName() + " with...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    static class 1 implements a {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ Activity j6;

        1(Activity activity, f fVar, a aVar, String str) {
            this.j6 = activity;
            this.DW = fVar;
            this.FH = aVar;
            this.Hw = str;
        }

        public void j6() {
            i.j6(this.j6, this.DW, this.FH);
        }

        public String DW() {
            return this.Hw;
        }

        public boolean v5() {
            return true;
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return "android/R.attr.html#" + this.Hw;
        }
    }

    static class 2 implements a {
        final /* synthetic */ f j6;

        2(f fVar) {
            this.j6 = fVar;
        }

        public String DW() {
            return "Delete";
        }

        public boolean v5() {
            return true;
        }

        public void j6() {
            this.j6.EQ();
        }

        public int FH() {
            return R.a.icon_delete;
        }

        public String Hw() {
            return null;
        }
    }

    static class 3 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        3(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            if (this.j6.getViewID() == null) {
                return "ID";
            }
            return "ID = <b>" + this.j6.getViewID() + "</b>";
        }

        public boolean v5() {
            return true;
        }

        public void j6() {
            i.DW(this.DW, this.j6);
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }
    }

    static class 4 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        4(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            if (this.j6.getStyle() == null) {
                return "Style";
            }
            return "Style = <b>" + a.j6(this.j6.getStyle()) + "</b>";
        }

        public boolean v5() {
            return true;
        }

        public void j6() {
            i.j6(this.DW, this.j6);
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }
    }

    static class 5 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        5(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Parent View...";
        }

        public boolean v5() {
            return this.j6.getParentView() != null;
        }

        public void j6() {
            g.j6(this.DW, this.j6.getParentView());
        }

        public int FH() {
            return R.a.icon_goto;
        }

        public String Hw() {
            return null;
        }
    }

    static class 6 implements a {
        final /* synthetic */ f DW;
        final /* synthetic */ Activity j6;

        6(Activity activity, f fVar) {
            this.j6 = activity;
            this.DW = fVar;
        }

        public String DW() {
            return "Source code...";
        }

        public boolean v5() {
            return this.j6 instanceof XmlLayoutDesignActivity;
        }

        public void j6() {
            if (this.j6 instanceof XmlLayoutDesignActivity) {
                this.DW.j6((XmlLayoutDesignActivity) this.j6);
            }
        }

        public int FH() {
            return R.a.icon_goto;
        }

        public String Hw() {
            return null;
        }
    }

    static class 7 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<b> {
            final /* synthetic */ 7 j6;

            1(7 7) {
                this.j6 = 7;
            }

            public void j6(b bVar) {
                this.j6.j6.j6(bVar);
            }
        }

        7(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Add inside...";
        }

        public boolean v5() {
            return this.j6.Hw();
        }

        public void j6() {
            k.FH(this.DW, "Add inside " + this.j6.getNodeName() + "...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    static class 8 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<b> {
            final /* synthetic */ 8 j6;

            1(8 8) {
                this.j6 = 8;
            }

            public void j6(b bVar) {
                this.j6.j6.v5(bVar);
            }
        }

        8(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Add above...";
        }

        public boolean v5() {
            return this.j6.VH();
        }

        public void j6() {
            k.FH(this.DW, "Add above " + this.j6.getNodeName() + "...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    static class 9 implements a {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<b> {
            final /* synthetic */ 9 j6;

            1(9 9) {
                this.j6 = 9;
            }

            public void j6(b bVar) {
                this.j6.j6.Zo(bVar);
            }
        }

        9(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public String DW() {
            return "Add below...";
        }

        public boolean v5() {
            return this.j6.gn();
        }

        public void j6() {
            k.FH(this.DW, "Add below " + this.j6.getNodeName() + "...", new 1(this));
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }
    }

    public static void j6(Activity activity, f fVar) {
        m.j6(activity, new q(fVar.getPath(), DW(activity, fVar)));
    }

    private static List<a> DW(Activity activity, f fVar) {
        List<a> arrayList = new ArrayList();
        arrayList.addAll(Hw(activity, fVar));
        arrayList.addAll(FH(activity, fVar));
        return arrayList;
    }

    private static List<a> FH(Activity activity, f fVar) {
        List<a> arrayList = new ArrayList();
        for (a aVar : fVar.getAttributes()) {
            String str;
            if (aVar.FH()) {
                str = aVar.j6.j6() + " styled <b>" + aVar.j6() + "</b>";
            } else if (aVar.DW()) {
                str = aVar.j6.j6() + " = <b>" + aVar.j6() + "</b>";
            } else {
                str = aVar.j6.j6();
            }
            arrayList.add(new 1(activity, fVar, aVar, str));
        }
        return arrayList;
    }

    private static List<a> Hw(Activity activity, f fVar) {
        return Arrays.asList(new a[]{new 5(fVar, activity), new 6(activity, fVar), new 7(fVar, activity), new 8(fVar, activity), new 9(fVar, activity), new 10(fVar, activity), new 11(fVar, activity), new 12(activity, fVar), new 2(fVar), new 3(fVar, activity), new 4(fVar, activity)});
    }
}
