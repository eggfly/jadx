package com.aide.appwizard;

import com.aide.appwizard.runtime.a.c;
import com.aide.appwizard.runtime.a.d;
import com.aide.appwizard.runtime.a.e;
import com.aide.common.m;
import com.aide.common.q;
import com.aide.common.q.a;
import com.aide.common.y;
import com.aide.ui.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b {
    private c DW;
    private AppWizardDesignActivity j6;

    class 10 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ c j6;

        10(b bVar, c cVar) {
            this.DW = bVar;
            this.j6 = cVar;
        }

        public void j6() {
            this.DW.DW = this.j6;
            this.DW.j6();
        }

        public String DW() {
            return "Fragment &quot;<b>" + this.j6.Hw() + "</b>&quot;";
        }

        public int FH() {
            return R.a.icon_goto;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 11 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        11(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6() {
            this.DW.DW = this.j6.EQ();
            this.DW.j6();
        }

        public String DW() {
            return "Add Fragment";
        }

        public int FH() {
            return R.a.icon_add;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 12 implements y<String> {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        12(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6(String str) {
            this.j6.j6(str);
        }
    }

    class 13 implements y<Boolean> {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        13(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6(Boolean bool) {
            this.j6.j6(bool);
        }
    }

    class 14 implements y<Boolean> {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        14(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6(Boolean bool) {
            this.j6.DW(bool);
        }
    }

    class 1 implements a {
        final /* synthetic */ b j6;

        1(b bVar) {
            this.j6 = bVar;
        }

        public void j6() {
            this.j6.DW = null;
            this.j6.j6();
        }

        public String DW() {
            return "Activity";
        }

        public int FH() {
            return R.a.icon_goto;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 2 implements y<Boolean> {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        2(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6(Boolean bool) {
            this.j6.FH(bool);
        }
    }

    class 3 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        class 1 implements y<String> {
            final /* synthetic */ 3 j6;

            1(3 3) {
                this.j6 = 3;
            }

            public void j6(String str) {
                this.j6.j6.j6(d.j6(str));
            }
        }

        3(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6() {
            m.j6(this.DW.j6, "Navigation", d.FH(), new 1(this));
        }

        public String DW() {
            return this.DW.DW("Navigation", this.j6.DW().u7);
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 4 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ com.aide.appwizard.runtime.a.b j6;

        class 1 implements y<String> {
            final /* synthetic */ 4 j6;

            1(4 4) {
                this.j6 = 4;
            }

            public void j6(String str) {
                this.j6.j6.j6(e.j6(str));
            }
        }

        4(b bVar, com.aide.appwizard.runtime.a.b bVar2) {
            this.DW = bVar;
            this.j6 = bVar2;
        }

        public void j6() {
            m.j6(this.DW.j6, "Theme", e.j6(), new 1(this));
        }

        public String DW() {
            return this.DW.DW("Theme", this.j6.j6().gn);
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 5 implements a {
        final /* synthetic */ String DW;
        final /* synthetic */ y FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements y<String> {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public void j6(String str) {
                this.j6.FH.j6(str);
            }
        }

        5(b bVar, String str, String str2, y yVar) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = yVar;
        }

        public void j6() {
            m.j6(this.Hw.j6, this.j6, null, this.DW, new 1(this));
        }

        public String DW() {
            return this.Hw.j6(this.j6, this.DW);
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 6 implements a {
        final /* synthetic */ y DW;
        final /* synthetic */ Boolean FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements y<String> {
            final /* synthetic */ 6 j6;

            class 1 implements y<String> {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void j6(String str) {
                    if ("none".equals(str)) {
                        this.j6.j6.DW.j6(null);
                    } else if ("true".equals(str)) {
                        this.j6.j6.DW.j6(Boolean.valueOf(true));
                    } else {
                        this.j6.j6.DW.j6(Boolean.valueOf(false));
                    }
                }
            }

            1(6 6) {
                this.j6 = 6;
            }

            public void j6(String str) {
                new 1(this).j6(str);
            }
        }

        6(b bVar, String str, y yVar, Boolean bool) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = yVar;
            this.FH = bool;
        }

        public void j6() {
            m.j6(this.Hw.j6, this.j6, Arrays.asList(new String[]{"true", "false", "none"}), new 1(this));
        }

        public String DW() {
            return this.Hw.DW(this.j6, this.FH == null ? null : Boolean.toString(this.FH.booleanValue()));
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 7 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ c j6;

        7(b bVar, c cVar) {
            this.DW = bVar;
            this.j6 = cVar;
        }

        public void j6() {
            this.j6.v5();
            this.DW.DW = null;
            this.DW.j6();
        }

        public String DW() {
            return "Delete";
        }

        public int FH() {
            return R.a.icon_delete;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    class 8 implements y<String> {
        final /* synthetic */ b DW;
        final /* synthetic */ c j6;

        8(b bVar, c cVar) {
            this.DW = bVar;
            this.j6 = cVar;
        }

        public void j6(String str) {
            this.j6.DW(str);
        }
    }

    class 9 implements a {
        final /* synthetic */ b DW;
        final /* synthetic */ c j6;

        9(b bVar, c cVar) {
            this.DW = bVar;
            this.j6 = cVar;
        }

        public void j6() {
        }

        public String DW() {
            return this.DW.DW("Layout", this.j6.DW());
        }

        public int FH() {
            return R.a.icon_manage;
        }

        public String Hw() {
            return null;
        }

        public boolean v5() {
            return true;
        }
    }

    public b(AppWizardDesignActivity appWizardDesignActivity) {
        this.j6 = appWizardDesignActivity;
    }

    public void j6() {
        if (this.DW != null) {
            m.j6(this.j6, new q("Activity \"" + this.j6.Ws().DW().FH() + "\" > Fragment \"" + this.DW.Hw() + "\"", j6(this.DW)));
        } else {
            m.j6(this.j6, new q("Activity \"" + this.j6.Ws().DW().FH() + "\"", j6(this.j6.Ws().DW())));
        }
    }

    private List<? extends a> j6(c cVar) {
        List arrayList = new ArrayList();
        arrayList.add(new 1(this));
        if (cVar.FH().tp().size() > 1) {
            arrayList.add(new 7(this, cVar));
        }
        j6(arrayList, "Title", cVar.Hw(), new 8(this, cVar));
        arrayList.add(new 9(this, cVar));
        return arrayList;
    }

    private List<? extends a> j6(com.aide.appwizard.runtime.a.b bVar) {
        List arrayList = new ArrayList();
        for (c 10 : bVar.tp()) {
            arrayList.add(new 10(this, 10));
        }
        arrayList.add(new 11(this, bVar));
        j6(arrayList, "Title", bVar.FH(), new 12(this, bVar));
        j6(arrayList, bVar);
        DW(arrayList, bVar);
        j6(arrayList, "Show Title", bVar.v5(), new 13(this, bVar));
        j6(arrayList, "Show Action Bar", bVar.VH(), new 14(this, bVar));
        j6(arrayList, "Fullscreen", bVar.u7(), new 2(this, bVar));
        return arrayList;
    }

    private void j6(List<a> list, com.aide.appwizard.runtime.a.b bVar) {
        list.add(new 3(this, bVar));
    }

    private void DW(List<a> list, com.aide.appwizard.runtime.a.b bVar) {
        list.add(new 4(this, bVar));
    }

    private void j6(List<a> list, String str, String str2, y<String> yVar) {
        list.add(new 5(this, str, str2, yVar));
    }

    private void j6(List<a> list, String str, Boolean bool, y<Boolean> yVar) {
        list.add(new 6(this, str, yVar, bool));
    }

    private String j6(String str, String str2) {
        return str2 == null ? str : str + " = <b>&quot;" + str2 + "&quot;</b>";
    }

    private String DW(String str, String str2) {
        return str2 == null ? str : str + " = <b>" + str2 + "</b>";
    }
}
