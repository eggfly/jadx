package com.aide.ui.build.android;

import android.os.Handler;
import com.aide.common.m;
import com.aide.engine.SyntaxError;
import com.aide.ui.build.d;
import com.aide.ui.build.packagingservice.b.a;
import com.aide.ui.e;
import com.aide.ui.h;
import it;
import it$a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ok;
import pc$a;
import qh;

public class b implements com.aide.ui.build.b, it {
    private a DW;
    private boolean EQ;
    private d FH;
    private n Hw;
    private String J0;
    private String J8;
    private List<String> Mr;
    private String QX;
    private boolean U2;
    private String VH;
    private String Ws;
    private String XL;
    private boolean Zo;
    private String aM;
    private int gn;
    private String j3;
    private AaptService j6;
    private boolean tp;
    private int u7;
    private String v5;
    private boolean we;

    class 1 implements pc$a {
        final /* synthetic */ b j6;

        1(b bVar) {
            this.j6 = bVar;
        }

        public void Mr() {
            if (this.j6.Zo) {
                this.j6.U2();
            }
        }

        public void DW(String str) {
            if (this.j6.Zo) {
                this.j6.U2();
            }
        }
    }

    class 2 extends a {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ boolean j6;

            class 1 implements Runnable {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void run() {
                    if (!e.u7().j6()) {
                        m.j6(e.u7(), "Export APK", "APK file " + this.j6.DW.j6.Ws + " has been exported and can be published.\n\nThe APK has been signed with your key in " + this.j6.DW.j6.QX + ". Make sure to keep this file for future updates.", null);
                    }
                }
            }

            1(2 2, boolean z) {
                this.DW = 2;
                this.j6 = z;
            }

            public void run() {
                this.DW.j6.v5 = this.DW.j6.EQ();
                if (this.DW.j6.v5 != null) {
                    if (this.j6) {
                        this.DW.j6.U2 = false;
                    }
                    this.DW.j6.gn();
                    return;
                }
                this.DW.j6.j6(null, 0, false);
                this.DW.j6.U2 = true;
                if (this.DW.j6.we) {
                    Runnable 1 = new 1(this);
                    if (this.DW.j6.J8()) {
                        m.j6(e.tp(), "Warning", "Your app supports only ARM. It may work with reduced performance on Intel Architecture based devices.", 1);
                        return;
                    } else {
                        1.run();
                        return;
                    }
                }
                this.DW.j6.we();
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

        2(b bVar) {
            this.j6 = bVar;
        }

        public void j6(boolean z) {
            e.j6(new 1(this, z));
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

    class 3 implements e {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 3 j6;

            1(3 3) {
                this.j6 = 3;
            }

            public void run() {
                this.j6.j6.FH("aapt was interrupted!");
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 3 j6;

            2(3 3) {
                this.j6 = 3;
            }

            public void run() {
                this.j6.j6.FH("aapt failed!");
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 3 DW;
            final /* synthetic */ boolean j6;

            3(3 3, boolean z) {
                this.DW = 3;
                this.j6 = z;
            }

            public void run() {
                if (this.j6) {
                    this.DW.j6.U2 = false;
                }
                if (!this.DW.j6.tp) {
                    this.DW.j6.QX();
                } else if (this.DW.j6.Mr == null || !this.DW.j6.Mr.isEmpty()) {
                    this.DW.j6.j6("Running aidl...", 10, false);
                    this.DW.j6.DW.j6(this.DW.j6.Mr);
                } else {
                    e.u7().g3();
                    this.DW.j6.j3();
                    this.DW.j6.j6(null, 0, false);
                }
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 3 DW;
            final /* synthetic */ Map j6;

            4(3 3, Map map) {
                this.DW = 3;
                this.j6 = map;
            }

            public void run() {
                this.DW.j6.j6("aapt", this.j6);
                this.DW.j6.Mr();
            }
        }

        3(b bVar) {
            this.j6 = bVar;
        }

        public void j6() {
            e.j6(new 1(this));
        }

        public void DW() {
            e.j6(new 2(this));
        }

        public void j6(boolean z) {
            e.j6(new 3(this, z));
        }

        public void j6(Map<String, List<SyntaxError>> map) {
            e.j6(new 4(this, map));
        }
    }

    class 4 implements f {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 4 j6;

            1(4 4) {
                this.j6 = 4;
            }

            public void run() {
                this.j6.j6.FH("aidl was interrupted!");
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 4 j6;

            2(4 4) {
                this.j6 = 4;
            }

            public void run() {
                this.j6.j6.FH("aidl failed!");
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 4 j6;

            3(4 4) {
                this.j6 = 4;
            }

            public void run() {
                e.u7().g3();
                if (this.j6.j6.tp) {
                    this.j6.j6.j3();
                    this.j6.j6.j6(null, 0, false);
                    return;
                }
                this.j6.j6.aM();
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 4 DW;
            final /* synthetic */ Map j6;

            4(4 4, Map map) {
                this.DW = 4;
                this.j6 = map;
            }

            public void run() {
                this.DW.j6.j6("aidl", this.j6);
                this.DW.j6.Mr();
            }
        }

        4(b bVar) {
            this.j6 = bVar;
        }

        public void j6() {
            e.j6(new 1(this));
        }

        public void DW() {
            e.j6(new 2(this));
        }

        public void FH() {
            e.j6(new 3(this));
        }

        public void j6(Map<String, List<SyntaxError>> map) {
            e.j6(new 4(this, map));
        }
    }

    class 5 implements g {
        final /* synthetic */ b j6;

        class 1 implements Runnable {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public void run() {
                this.j6.j6.FH("NDK build was interrupted!");
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 5 j6;

            2(5 5) {
                this.j6 = 5;
            }

            public void run() {
                this.j6.j6.FH("NDK build failed!");
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 5 DW;
            final /* synthetic */ boolean j6;

            3(5 5, boolean z) {
                this.DW = 5;
                this.j6 = z;
            }

            public void run() {
                if (this.j6) {
                    this.DW.j6.U2 = false;
                }
                this.DW.j6.j6(this.DW.j6.v5, this.DW.j6.J0);
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 5 DW;
            final /* synthetic */ Map j6;

            4(5 5, Map map) {
                this.DW = 5;
                this.j6 = map;
            }

            public void run() {
                this.DW.j6.j6("NDK", this.j6);
                this.DW.j6.Mr();
            }
        }

        5(b bVar) {
            this.j6 = bVar;
        }

        public void j6() {
            e.j6(new 1(this));
        }

        public void DW() {
            e.j6(new 2(this));
        }

        public void j6(boolean z) {
            e.j6(new 3(this, z));
        }

        public void j6(Map<String, List<SyntaxError>> map) {
            e.j6(new 4(this, map));
        }
    }

    class 6 implements k.a {
        final /* synthetic */ String DW;
        final /* synthetic */ b FH;
        final /* synthetic */ String j6;

        6(b bVar, String str, String str2) {
            this.FH = bVar;
            this.j6 = str;
            this.DW = str2;
        }

        public void j6(String str, String str2, String str3, String str4) {
            this.FH.j6(this.j6, this.DW, str, str2, str3, str4);
        }
    }

    class 7 implements k.a {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ boolean j6;

        7(b bVar, boolean z, String str, String str2) {
            this.Hw = bVar;
            this.j6 = z;
            this.DW = str;
            this.FH = str2;
        }

        public void j6(String str, String str2, String str3, String str4) {
            this.Hw.j6(this.j6, this.DW, this.FH, str, str2, str3, str4);
        }
    }

    class 8 implements Runnable {
        final /* synthetic */ b j6;

        8(b bVar) {
            this.j6 = bVar;
        }

        public void run() {
            this.j6.gn();
        }
    }

    class 9 implements Runnable {
        final /* synthetic */ b DW;
        final /* synthetic */ String j6;

        9(b bVar, String str) {
            this.DW = bVar;
            this.j6 = str;
        }

        public void run() {
            e.u7().j6(this.DW.Ws, this.j6);
        }
    }

    public b() {
        this.Ws = "";
        this.QX = "";
        this.XL = "";
        this.aM = "";
        this.j3 = "";
    }

    public void j6(boolean z) {
        if (z) {
            this.U2 = false;
        }
        j3();
        if (e.aM().Hw(".java")) {
            Mr();
        } else {
            XL();
        }
    }

    public void j6(String str) {
        FH("Compilation failed: " + str);
    }

    public void Zo() {
        if (this.Zo) {
            aM();
        }
    }

    public void Hw() {
        this.U2 = false;
    }

    public void v5() {
        this.U2 = false;
        this.j6.j6(e.a8().v5());
    }

    public void FH() {
        e.aM().j6(new 1(this));
        this.Hw = new n();
        this.Hw.j6(new 2(this));
        this.j6 = new AaptService(e.gn());
        this.j6.j6(new 3(this));
        this.DW = new a();
        this.DW.j6(new 4(this));
        this.FH = new d();
        this.FH.j6(new 5(this));
    }

    public void j6(String str, String str2, String str3) {
        e.SI().j6(str3, ok.DW(e.a8().u7(), "release", str), new 6(this, str, str2));
    }

    private void j6(String str, String str2, String str3, String str4, String str5, String str6) {
        this.EQ = false;
        this.we = true;
        this.U2 = false;
        this.J8 = "release";
        this.J0 = str;
        this.Ws = str2;
        this.j6.j6(str);
        j6(str3, str4, str5, str6);
    }

    public void j6(boolean z, String str, String str2) {
        e.j3().j6(false, false);
        if (ok.QX()) {
            j6(z, str, str2, e.Ws().DW(), "xxxxxx", "weardebug", "xxxxxx");
        } else if (e.VH() || (ok.DW(e.a8().u7(), null) != null && ok.DW(e.a8().u7(), null).startsWith("com.aide.trainer."))) {
            j6(z, "debug", null, "", "", "", "");
        } else {
            e.SI().j6(h.Mr(), ok.DW(e.a8().u7(), str, str2), new 7(this, z, str, str2));
        }
    }

    private void j6(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        this.EQ = z;
        this.we = false;
        this.J8 = str;
        this.J0 = str2;
        if (z) {
            this.U2 = false;
        }
        this.Ws = ok.er(e.a8().u7());
        j6(str3, str4, str5, str6);
    }

    private void j6(String str, String str2, String str3, String str4) {
        e.aM().u7();
        ok.Ws();
        this.tp = false;
        this.Mr = null;
        this.QX = str;
        this.XL = str2;
        this.aM = str3;
        this.j3 = str4;
        this.v5 = u7();
        j6("Building...", 0, false);
        e.sG().j6((it) this);
        e.U2().j6(this, e.sG().j6());
        new Handler().postDelayed(new 8(this), 100);
    }

    private void gn() {
        j6("Building...", 0, false);
        Ws();
    }

    public void j6(boolean z, List<String> list) {
        if (this.VH != null) {
            return;
        }
        if (z || list == null || !list.isEmpty()) {
            e.aM().u7();
            ok.Ws();
            this.v5 = null;
            e.U2().j6(this, true);
            this.Mr = list;
            this.EQ = false;
            this.tp = true;
            this.J0 = e.a8().v5();
            if (z) {
                j6("Running aapt...", 10, false);
                this.j6.DW(this.J0);
            } else if (list != null && !list.isEmpty()) {
                j6("Running aidl...", 10, false);
                this.DW.j6((List) list);
            }
        }
    }

    private String u7() {
        List tp = e.a8().tp();
        return (String) tp.get(tp.size() - 1);
    }

    private boolean tp() {
        return u7().equals(this.v5);
    }

    private String EQ() {
        List tp = e.a8().tp();
        int indexOf = tp.indexOf(this.v5);
        if (indexOf > 0) {
            return (String) tp.get(indexOf - 1);
        }
        return null;
    }

    private void j6(String str, Map<String, List<SyntaxError>> map) {
        e.aM().j6(str, (Map) map);
        e.u7().g3();
    }

    private void j6(String str, String str2) {
        if (this.U2) {
            this.Hw.j6();
            return;
        }
        Map EQ = e.a8().EQ(str);
        String er = ok.er(str);
        String j6 = ok.j6(str, "debug-aide".equals(this.J8));
        String gW = ok.gW(str);
        String yS = ok.yS(str);
        String rN = ok.rN(str);
        String[] j62 = ok.j6(EQ, "debug-aide".equals(this.J8));
        String[] j63 = ok.j6(EQ, this.J8, str2);
        String[] j64 = ok.j6(EQ, str2);
        String[] j65 = ok.j6(EQ);
        boolean v5 = ok.v5(str, str2);
        if (str.equals(e.a8().u7())) {
            er = this.Ws;
        }
        this.Hw.j6(j6, j62, j64, j65, gW, yS, rN, j63, er, this.QX, this.XL, this.aM, this.j3, this.EQ, h.v5(), v5);
        this.Hw.DW();
    }

    public it$a DW() {
        return it$a.ANDROID;
    }

    public void VH() {
        e.u7().dx();
        we();
    }

    public int j6() {
        return 17;
    }

    private void we() {
        if (this.VH == null && !e.sG().v5() && !e.sG().FH()) {
            J0();
        }
    }

    private void J0() {
        if (!this.EQ) {
            String u7 = e.a8().u7();
            String DW = ok.DW(u7, e.a8().v5());
            if (e.VH()) {
                e.QX().j6(this.Ws, DW);
            } else if (h.Hw(u7) || !J8()) {
                e.u7().j6(this.Ws, DW);
            } else {
                h.v5(u7);
                m.j6(e.tp(), "Warning", "Your app supports only ARM. It may work with reduced performance on Intel Architecture based devices.", new 9(this, DW));
            }
        }
    }

    private boolean J8() {
        for (String str : ok.j6(e.a8().EQ(e.a8().u7()), null, e.a8().v5())) {
            boolean z = DW(new StringBuilder().append(str).append("/armeabi").toString()) || DW(str + "/armeabi-v7a");
            if (z && !DW(str + "/x86")) {
                return true;
            }
        }
        return false;
    }

    private boolean DW(String str) {
        if (qh.VH(str)) {
            try {
                for (String endsWith : qh.QX(str)) {
                    if (endsWith.endsWith(".so")) {
                        return true;
                    }
                }
            } catch (IOException e) {
            }
        }
        return false;
    }

    private void Ws() {
        j6("Running aapt...", 10, false);
        String BT = ok.BT(this.v5);
        if (new File(BT).exists() || new File(BT).mkdirs()) {
            if (this.EQ) {
                for (String BT2 : ok.FH(e.a8().EQ(this.v5), this.J0).keySet()) {
                    try {
                        qh.j3(BT2);
                    } catch (IOException e) {
                        FH("Deleting gen dir '" + BT2 + "' failed.");
                    }
                }
            }
            this.j6.j6(this.v5, this.J8, this.J0, this.EQ, "release".equals(this.J8), tp());
            return;
        }
        FH("Could not create target dir " + BT2);
    }

    private void QX() {
        j6("Running aidl...", 10, false);
        this.DW.j6(this.v5, this.EQ, tp());
    }

    private void XL() {
        j6("Building native code...", 80, false);
        this.FH.j6(this.EQ);
    }

    private void aM() {
        j6("Compiling...", 20, true);
        String j6 = ok.j6(this.v5, "debug-aide".equals(this.J8));
        if (!new File(j6).exists() && !new File(j6).mkdirs()) {
            FH("Could not create destination dir " + j6);
        } else if (this.EQ) {
            e.XL().we();
        } else {
            e.XL().EQ();
        }
    }

    private void j3() {
        e.nw().DW(new ArrayList(ok.gn(e.a8().EQ(), null).keySet()));
    }

    private void Mr() {
        FH("Your project contains errors. Please fix them before running the app.");
    }

    private void FH(String str) {
        this.VH = null;
        e.U2().j6(str);
    }

    private void U2() {
        int Zo = e.aM().Zo();
        this.u7 = Zo == 0 ? 100 : (e.aM().v5() * 100) / Zo;
        e.U2().j6(this.v5, this.VH, this.gn, this.u7);
    }

    private void j6(String str, int i, boolean z) {
        this.VH = str;
        this.gn = i;
        this.u7 = 0;
        this.Zo = z;
        e.U2().j6(this.v5, str, i, this.u7);
    }
}
