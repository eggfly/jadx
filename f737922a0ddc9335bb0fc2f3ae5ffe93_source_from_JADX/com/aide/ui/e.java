package com.aide.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.aide.engine.service.Native;
import com.aide.ui.build.a;
import com.aide.ui.build.android.k;
import com.aide.ui.build.android.m;
import com.aide.ui.debugger.Debugger;
import com.aide.ui.trainer.b;
import iq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nz;
import og;
import ok;
import oo;
import oq;
import os;
import ou;
import ox;
import oy;
import oz;
import pa;
import pb;
import pc;
import pd;
import pe;
import pf;
import pg;
import ph;
import pi;
import pj;
import pk;
import pl;
import pm;
import pn;
import po;
import pp;
import pq;
import pr;
import ps;
import pt;
import pu;

public class e {
    public static e DW;
    private static MainActivity FH;
    private static List<Activity> Hw;
    private static Boolean VH;
    private static Context Zo;
    private static b gn;
    public static String j6;
    private static boolean u7;
    private static Handler v5;
    private pi BT;
    private pc EQ;
    private a J0;
    private po J8;
    private pt KD;
    private pq Mr;
    private m P8;
    private pu QX;
    private ps SI;
    private ph U2;
    private pa Ws;
    private pg XL;
    private pn a8;
    private pe aM;
    private iq cb;
    private pp cn;
    private pf ei;
    private nz er;
    private oz gW;
    private pr j3;
    private pj lg;
    private pm nw;
    private com.aide.ui.scm.b rN;
    private oy ro;
    private pk sh;
    private pb tp;
    private pd vy;
    private pl we;
    private k yS;

    static class 1 implements Runnable {
        final /* synthetic */ Runnable j6;

        1(Runnable runnable) {
            this.j6 = runnable;
        }

        public void run() {
            if (!e.J0()) {
                try {
                    this.j6.run();
                } catch (Throwable th) {
                    com.aide.common.e.j6(th);
                }
            }
        }
    }

    static class 2 implements Runnable {
        final /* synthetic */ ProgressDialog DW;
        final /* synthetic */ Runnable FH;
        final /* synthetic */ Runnable j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void run() {
                this.j6.DW.dismiss();
                if (this.j6.FH != null) {
                    this.j6.FH.run();
                }
            }
        }

        2(Runnable runnable, ProgressDialog progressDialog, Runnable runnable2) {
            this.j6 = runnable;
            this.DW = progressDialog;
            this.FH = runnable2;
        }

        public void run() {
            try {
                this.j6.run();
            } finally {
                e.j6(new 1(this));
            }
        }
    }

    public e() {
        this.tp = new pb();
        this.EQ = new pc();
        this.we = new pl();
        this.J0 = new a();
        this.J8 = new po();
        this.Ws = new pa();
        this.QX = new pu();
        this.XL = new pg();
        this.aM = new pe();
        this.j3 = new pr();
        this.Mr = new pq();
        this.U2 = new ph();
        this.a8 = new pn();
        this.lg = new pj();
        this.rN = new com.aide.ui.scm.b();
        this.er = new nz();
        this.yS = new k();
        this.gW = new oz();
        this.BT = new pi();
        this.vy = new pd();
        this.P8 = new m();
        this.ei = new pf();
        this.nw = new pm();
        this.SI = new ps();
        this.KD = new pt();
        this.ro = new oy();
        this.cn = new pp();
        this.sh = new pk();
        this.cb = new iq();
    }

    static {
        j6 = "";
        Hw = new ArrayList();
        u7 = Native.j6.isX86();
    }

    public static og[] j6() {
        return new og[]{new ok(), new ox(), new ou(), new oo(), new os(), new oq()};
    }

    public static List<String> DW() {
        if (Hw() || j6.endsWith("com.aide.phonegap") || j6.equals("com.aide.web")) {
            return Arrays.asList(new String[]{"Java", "Java Binary", "XML", "HTML", "Css", "JavaScript", "DTD", "C++", "AIDL"});
        }
        return Arrays.asList(new String[]{"Java", "Java Binary", "XML", "C++", "AIDL"});
    }

    public static boolean FH() {
        return false;
    }

    public static boolean Hw() {
        return false;
    }

    public static boolean v5() {
        return j6.startsWith("com.aide.trainer.");
    }

    public static boolean Zo() {
        if (VH() || gn().getSharedPreferences("TrainerMode", 0).getBoolean("ModeDecided", false)) {
            return true;
        }
        return false;
    }

    public static boolean VH() {
        if (v5()) {
            return true;
        }
        if (VH == null) {
            VH = Boolean.valueOf(gn().getSharedPreferences("TrainerMode", 0).getBoolean("Mode", false));
        }
        return VH.booleanValue();
    }

    public static void j6(boolean z) {
        Editor edit = gn().getSharedPreferences("TrainerMode", 0).edit();
        edit.putBoolean("Mode", z);
        edit.putBoolean("ModeDecided", true);
        edit.commit();
        VH = Boolean.valueOf(z);
    }

    public static String j6(int i, Object... objArr) {
        return gn().getResources().getString(i, objArr);
    }

    public static Context gn() {
        return Zo;
    }

    public static MainActivity u7() {
        return FH;
    }

    public static Activity tp() {
        return Hw.isEmpty() ? FH : (Activity) Hw.get(Hw.size() - 1);
    }

    public static void j6(Activity activity) {
        int indexOf = Hw.indexOf(activity);
        if (indexOf != -1) {
            Hw.remove(indexOf);
        }
        Hw.add(activity);
    }

    public static void DW(Activity activity) {
        Hw.remove(activity);
    }

    public static boolean j6(Runnable runnable) {
        return v5.post(new 1(runnable));
    }

    public static void j6(Activity activity, String str, Runnable runnable, Runnable runnable2) {
        ProgressDialog show = ProgressDialog.show(activity, null, str, true, false);
        show.getWindow().addFlags(128);
        show.getWindow().clearFlags(2);
        new Thread(new 2(runnable, show, runnable2)).start();
    }

    public static b EQ() {
        if (gn == null) {
            gn = new b();
        }
        return gn;
    }

    public static void j6(String str) {
        if (str.endsWith(".exp")) {
            str = str.substring(0, str.length() - ".exp".length());
        }
        j6 = str;
    }

    public static void j6(Context context) {
        Zo = context;
        if (u7) {
            com.aide.common.e.j6("Using x86 binaries");
        }
    }

    public static void j6(MainActivity mainActivity, String str) {
        FH = mainActivity;
        v5 = new Handler();
        DW(str);
        DW.tp.DW();
    }

    private static e g3() {
        return DW;
    }

    private static void DW(String str) {
        if (DW == null) {
            com.aide.common.e.DW("ServiceContainer.init");
            DW = new e();
            DW.J0.Zo();
            DW.rN.j6();
            DW.we.j6();
            DW.ro.j6();
            DW.J8.j6(str);
            DW.Ws.DW();
            DW.QX.j6();
            DW.U2.j6();
            DW.er.v5();
            DW.BT.DW();
            DW.lg.FH();
            DW.ei.j6();
            DW.nw.j6();
            DW.SI.j6();
            DW.KD.j6();
            DW.cb.DW();
        }
    }

    public static void we() {
        if (DW != null) {
            com.aide.common.e.DW("ServiceContainer.shutdown");
            DW.tp.v5();
            DW.tp.j6();
            DW.EQ.VH();
            DW.Ws.FH();
            DW.lg.j6();
            DW.er.DW();
            DW.BT.j6();
            DW.ei.DW();
            DW.nw.DW();
            DW.SI.DW();
            FH = null;
            DW = null;
        }
    }

    public static boolean J0() {
        return DW == null;
    }

    public static pp J8() {
        return g3().cn;
    }

    public static oy Ws() {
        return g3().ro;
    }

    public static pt QX() {
        return g3().KD;
    }

    public static pb XL() {
        return g3().tp;
    }

    public static pc aM() {
        return g3().EQ;
    }

    public static pl j3() {
        return g3().we;
    }

    public static pi Mr() {
        return g3().BT;
    }

    public static a U2() {
        return g3().J0;
    }

    public static po a8() {
        return g3().J8;
    }

    public static pu lg() {
        return g3().QX;
    }

    public static pg rN() {
        return g3().XL;
    }

    public static pe er() {
        return g3().aM;
    }

    public static pr yS() {
        return g3().j3;
    }

    public static pq gW() {
        return g3().Mr;
    }

    public static ph BT() {
        return g3().U2;
    }

    public static pn vy() {
        return g3().a8;
    }

    public static pj P8() {
        return g3().lg;
    }

    public static com.aide.ui.scm.b ei() {
        return g3().rN;
    }

    public static nz nw() {
        return g3().er;
    }

    public static k SI() {
        return g3().yS;
    }

    public static oz KD() {
        return g3().gW;
    }

    public static pd ro() {
        return g3().vy;
    }

    public static pf cn() {
        return g3().ei;
    }

    public static pm sh() {
        return g3().nw;
    }

    public static ps cb() {
        return g3().SI;
    }

    public static pk dx() {
        return g3().sh;
    }

    public static iq sG() {
        return g3().cb;
    }

    public static boolean ef() {
        return u7;
    }

    public static Debugger Sf() {
        return Debugger.j6(gn());
    }

    public static String vJ() {
        return h.ro();
    }
}
