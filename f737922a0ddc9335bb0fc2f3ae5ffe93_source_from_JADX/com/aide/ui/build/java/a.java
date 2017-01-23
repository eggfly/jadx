package com.aide.ui.build.java;

import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.build.android.n;
import com.aide.ui.build.b;
import com.aide.ui.e;
import com.aide.ui.h;
import it;
import it$a;
import java.io.File;
import java.util.List;
import oo;
import pc$a;

public class a implements b, it {
    private boolean DW;
    private String FH;
    private int Hw;
    private boolean VH;
    private boolean Zo;
    private n j6;
    private int v5;

    class 1 implements pc$a {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public void Mr() {
            if (this.j6.DW) {
                this.j6.J0();
            }
        }

        public void DW(String str) {
            if (this.j6.DW) {
                this.j6.J0();
            }
        }
    }

    class 2 extends com.aide.ui.build.packagingservice.b.a {
        final /* synthetic */ a j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void run() {
                this.j6.j6.j6(null, 0, false);
                this.j6.j6.gn();
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ String j6;

            2(2 2, String str) {
                this.DW = 2;
                this.j6 = str;
            }

            public void run() {
                this.DW.j6.FH(this.j6);
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 2 j6;

            3(2 2) {
                this.j6 = 2;
            }

            public void run() {
                this.j6.j6.FH("Packaging was interrupted!");
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ int DW;
            final /* synthetic */ 2 FH;
            final /* synthetic */ String j6;

            4(2 2, String str, int i) {
                this.FH = 2;
                this.j6 = str;
                this.DW = i;
            }

            public void run() {
                this.FH.j6.j6(this.j6, this.DW, false);
            }
        }

        2(a aVar) {
            this.j6 = aVar;
        }

        public void j6(boolean z) {
            e.j6(new 1(this));
        }

        public void j6(String str) {
            e.j6(new 2(this, str));
        }

        public void j6() {
            e.j6(new 3(this));
        }

        public void j6(String str, int i) {
            e.j6(new 4(this, str, i));
        }
    }

    class 3 implements y<String> {
        final /* synthetic */ a j6;

        3(a aVar) {
            this.j6 = aVar;
        }

        public void j6(String str) {
            this.j6.DW(str);
        }
    }

    public void j6(boolean z, String str) {
        e.j3().j6(false, false);
        e.u7().sh().QX();
        this.Zo = z;
        this.VH = "debug-aide".equals(str);
        e.aM().u7();
        e.U2().j6(this, e.sG().j6());
        j6("Building...", 0, false);
        EQ();
        e.sG().j6((it) this);
    }

    public void j6(boolean z) {
        if (e.aM().Hw(".java")) {
            we();
        } else {
            u7();
        }
    }

    public void j6(String str) {
        FH("Compilation failed: " + str);
    }

    public void Zo() {
        if (this.DW) {
            EQ();
        }
    }

    public void FH() {
        e.aM().j6(new 1(this));
        this.j6 = new n();
        this.j6.j6(new 2(this));
    }

    public it$a DW() {
        return it$a.JAVA;
    }

    public void VH() {
        e.u7().dx();
        gn();
    }

    public int j6() {
        return 18;
    }

    private void gn() {
        if (this.FH == null && !e.sG().v5() && !e.sG().FH()) {
            tp();
        }
    }

    private void u7() {
        String u7 = e.a8().u7();
        String[] strArr = new String[]{oo.j6(u7, this.VH)};
        String DW = oo.DW(u7, this.VH);
        String Hw = oo.Hw(u7, this.VH);
        this.j6.j6(r2, strArr, null, oo.U2(u7), DW, Hw, null, null, oo.FH(u7, this.VH), null, null, null, null, this.Zo, h.v5(), false);
        this.j6.DW();
    }

    private void tp() {
        j6(null, 0, false);
        if (!this.Zo) {
            List tp = e.aM().tp();
            if (e.VH() && tp.size() != 1) {
                e.QX().v5();
            } else if (tp.size() == 0) {
                m.j6(e.u7(), "Run", "There's no main method to run in this project!");
            } else if (tp.size() == 1) {
                DW((String) tp.get(0));
            } else {
                m.j6(e.u7(), "Run", tp, new 3(this));
            }
        }
    }

    private void DW(String str) {
        String FH = oo.FH(e.a8().u7(), this.VH);
        if (e.VH()) {
            e.u7().v5(false);
            RunTrainerJavaActivity.j6(e.u7(), h.cn(), FH, str, this.VH, 15);
            return;
        }
        RunJavaActivity.j6(e.u7(), h.cn(), FH, str, this.VH);
    }

    private void EQ() {
        j6("Compiling...", 10, true);
        String j6 = oo.j6(e.a8().u7(), this.VH);
        if (!new File(j6).exists() && !new File(j6).mkdirs()) {
            FH("Could not create destination dir " + j6);
        } else if (this.Zo) {
            e.XL().we();
        } else {
            e.XL().EQ();
        }
    }

    private void we() {
        FH("Your project contains errors. Please fix them before running the app.");
    }

    private void FH(String str) {
        this.FH = null;
        e.U2().j6(str);
    }

    private void J0() {
        int Zo = e.aM().Zo();
        this.v5 = Zo == 0 ? 100 : (e.aM().v5() * 100) / Zo;
        e.U2().j6(e.a8().u7(), this.FH, this.Hw, this.v5);
    }

    private void j6(String str, int i, boolean z) {
        this.FH = str;
        this.Hw = i;
        this.v5 = 0;
        this.DW = z;
        e.U2().j6(e.a8().u7(), str, i, this.v5);
    }

    public void Hw() {
    }

    public void v5() {
    }
}
