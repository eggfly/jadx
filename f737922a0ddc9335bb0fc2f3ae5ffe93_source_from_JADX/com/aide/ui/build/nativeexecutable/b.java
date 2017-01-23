package com.aide.ui.build.nativeexecutable;

import android.os.Build;
import com.aide.engine.SyntaxError;
import com.aide.ui.build.android.g;
import com.aide.ui.build.d;
import com.aide.ui.e;
import com.aide.ui.h;
import java.io.File;
import java.util.List;
import java.util.Map;
import qh;

public class b implements com.aide.ui.build.b {
    private c DW;
    private boolean FH;
    private String Hw;
    private d j6;

    class 1 implements g {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.DW("NDK build was interrupted!");
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 1 j6;

            2(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.DW("NDK build failed!");
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 1 j6;

            3(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.VH();
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ Map j6;

            4(1 1, Map map) {
                this.DW = 1;
                this.j6 = map;
            }

            public void run() {
                this.DW.j6.j6("NDK", this.j6);
                this.DW.j6.u7();
            }
        }

        1(b bVar) {
            this.j6 = bVar;
        }

        public void j6() {
            e.j6(new 1(this));
        }

        public void DW() {
            e.j6(new 2(this));
        }

        public void j6(boolean z) {
            e.j6(new 3(this));
        }

        public void j6(Map<String, List<SyntaxError>> map) {
            e.j6(new 4(this, map));
        }
    }

    class 2 implements a {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void run() {
                this.j6.j6.DW("Executable installation was interrupted!");
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ Throwable j6;

            2(2 2, Throwable th) {
                this.DW = 2;
                this.j6 = th;
            }

            public void run() {
                this.DW.j6.DW("Executable installation failed: " + this.j6.getMessage());
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 2 j6;

            3(2 2) {
                this.j6 = 2;
            }

            public void run() {
                this.j6.j6.j6(null, 0);
                this.j6.j6.j6();
            }
        }

        2(b bVar) {
            this.j6 = bVar;
        }

        public void DW() {
            e.j6(new 1(this));
        }

        public void j6(Throwable th) {
            e.j6(new 2(this, th));
        }

        public void j6() {
            e.j6(new 3(this));
        }
    }

    public void j6(boolean z) {
    }

    public void j6(String str) {
    }

    public void Zo() {
    }

    public void FH() {
        this.j6 = new d();
        this.j6.j6(new 1(this));
        this.DW = new c();
        this.DW.j6(new 2(this));
    }

    public void DW(boolean z) {
        e.u7().sh().QX();
        e.j3().j6(false, false);
        this.FH = z;
        e.aM().u7();
        e.U2().j6(this, false);
        j6("Building...", 0);
        DW();
    }

    private void j6() {
        if (this.Hw != null) {
            RunNativeExecutableActivity.j6(e.u7(), h.cn(), this.Hw, 15);
        }
    }

    private void DW() {
        j6("Building native code...", 0);
        this.j6.j6(this.FH);
    }

    private void VH() {
        String str;
        String str2;
        List QX;
        j6("Installing native executable...", 90);
        String str3 = e.a8().u7() + "/libs/";
        if (qh.EQ(str3 + gn())) {
            try {
                List QX2 = qh.QX(str3 + gn());
                if (QX2.size() == 1 && qh.J8((String) QX2.get(0))) {
                    str = (String) QX2.get(0);
                } else {
                    str = null;
                }
                str2 = str;
            } catch (Throwable e) {
                com.aide.common.e.j6(e);
            }
            if (str2 == null && qh.EQ(str3 + Build.CPU_ABI2)) {
                QX = qh.QX(str3 + Build.CPU_ABI2);
                if (QX.size() == 1 || !qh.J8((String) QX.get(0))) {
                    str = str2;
                } else {
                    str = (String) QX.get(0);
                }
                str2 = str;
            }
            if (str2 == null) {
                str = e.u7().getCacheDir() + "/exe";
                this.DW.j6(str2, str);
                this.Hw = str + "/" + new File(str2).getName();
            }
            this.Hw = null;
            j6(null, 0);
            return;
        }
        str2 = null;
        try {
            QX = qh.QX(str3 + Build.CPU_ABI2);
            if (QX.size() == 1) {
            }
            str = str2;
            str2 = str;
        } catch (Throwable e2) {
            com.aide.common.e.j6(e2);
        }
        if (str2 == null) {
            this.Hw = null;
            j6(null, 0);
            return;
        }
        str = e.u7().getCacheDir() + "/exe";
        this.DW.j6(str2, str);
        this.Hw = str + "/" + new File(str2).getName();
    }

    private String gn() {
        return e.ef() ? "x86" : "armeabi-v7a";
    }

    private void j6(String str, Map<String, List<SyntaxError>> map) {
        e.aM().j6(str, (Map) map);
        e.u7().g3();
    }

    private void u7() {
        DW("Your project contains errors. Please fix them before running the app.");
    }

    private void DW(String str) {
        e.U2().j6(str);
    }

    private void j6(String str, int i) {
        e.U2().j6(e.a8().u7(), str, i, i);
    }

    public void Hw() {
    }

    public void v5() {
    }
}
