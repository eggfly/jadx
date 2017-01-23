package com.google.android.gms.analytics.internal;

import afq;
import afs;
import android.content.Context;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.p;
import com.google.android.gms.common.internal.b;
import java.lang.Thread.UncaughtExceptionHandler;

public class v {
    private static v j6;
    private final Context DW;
    private final j EQ;
    private final Context FH;
    private final afq Hw;
    private final ac J0;
    private final a J8;
    private final aj QX;
    private final p VH;
    private final z Ws;
    private final g Zo;
    private final r gn;
    private final q tp;
    private final ak u7;
    private final ag v5;
    private final c we;

    class 1 implements UncaughtExceptionHandler {
        final /* synthetic */ v j6;

        1(v vVar) {
            this.j6 = vVar;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            g VH = this.j6.VH();
            if (VH != null) {
                VH.v5("Job execution failed", th);
            }
        }
    }

    protected v(zzg com_google_android_gms_analytics_internal_zzg) {
        Context j6 = com_google_android_gms_analytics_internal_zzg.j6();
        b.j6((Object) j6, (Object) "Application context can't be null");
        Object DW = com_google_android_gms_analytics_internal_zzg.DW();
        b.j6(DW);
        this.DW = j6;
        this.FH = DW;
        this.Hw = com_google_android_gms_analytics_internal_zzg.gn(this);
        this.v5 = com_google_android_gms_analytics_internal_zzg.VH(this);
        g Zo = com_google_android_gms_analytics_internal_zzg.Zo(this);
        Zo.ei();
        this.Zo = Zo;
        String str;
        if (v5().j6()) {
            Zo = Zo();
            str = u.j6;
            Zo.Hw(new StringBuilder(String.valueOf(str).length() + 33).append("Google Analytics ").append(str).append(" is starting up.").toString());
        } else {
            Zo = Zo();
            str = u.j6;
            Zo.Hw(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        }
        j XL = com_google_android_gms_analytics_internal_zzg.XL(this);
        XL.ei();
        this.EQ = XL;
        q v5 = com_google_android_gms_analytics_internal_zzg.v5(this);
        v5.ei();
        this.tp = v5;
        r we = com_google_android_gms_analytics_internal_zzg.we(this);
        ac Hw = com_google_android_gms_analytics_internal_zzg.Hw(this);
        a FH = com_google_android_gms_analytics_internal_zzg.FH(this);
        z DW2 = com_google_android_gms_analytics_internal_zzg.DW(this);
        aj j62 = com_google_android_gms_analytics_internal_zzg.j6(this);
        p j63 = com_google_android_gms_analytics_internal_zzg.j6(j6);
        j63.j6(j6());
        this.VH = j63;
        c u7 = com_google_android_gms_analytics_internal_zzg.u7(this);
        Hw.ei();
        this.J0 = Hw;
        FH.ei();
        this.J8 = FH;
        DW2.ei();
        this.Ws = DW2;
        j62.ei();
        this.QX = j62;
        ak QX = com_google_android_gms_analytics_internal_zzg.QX(this);
        QX.ei();
        this.u7 = QX;
        we.ei();
        this.gn = we;
        if (v5().j6()) {
            Zo().DW("Device AnalyticsService version", u.j6);
        }
        u7.j6();
        this.we = u7;
        we.DW();
    }

    public static v j6(Context context) {
        b.j6((Object) context);
        if (j6 == null) {
            synchronized (v.class) {
                if (j6 == null) {
                    afq Hw = afs.Hw();
                    long DW = Hw.DW();
                    v vVar = new v(new zzg(context));
                    j6 = vVar;
                    c.Hw();
                    DW = Hw.DW() - DW;
                    long longValue = ((Long) an.vJ.j6()).longValue();
                    if (DW > longValue) {
                        vVar.Zo().FH("Slow initialization (ms)", Long.valueOf(DW), Long.valueOf(longValue));
                    }
                }
            }
        }
        return j6;
    }

    private void j6(t tVar) {
        b.j6((Object) tVar, (Object) "Analytics service not created/initialized");
        b.DW(tVar.vy(), "Analytics service not initialized");
    }

    public Context DW() {
        return this.DW;
    }

    public c EQ() {
        b.j6(this.we);
        b.DW(this.we.FH(), "Analytics instance not initialized");
        return this.we;
    }

    public Context FH() {
        return this.FH;
    }

    public afq Hw() {
        return this.Hw;
    }

    public j J0() {
        j6(this.EQ);
        return this.EQ;
    }

    public j J8() {
        return (this.EQ == null || !this.EQ.vy()) ? null : this.EQ;
    }

    public ac QX() {
        j6(this.J0);
        return this.J0;
    }

    public g VH() {
        return this.Zo;
    }

    public a Ws() {
        j6(this.J8);
        return this.J8;
    }

    public z XL() {
        j6(this.Ws);
        return this.Ws;
    }

    public g Zo() {
        j6(this.Zo);
        return this.Zo;
    }

    public aj aM() {
        return this.QX;
    }

    public p gn() {
        b.j6(this.VH);
        return this.VH;
    }

    public void j3() {
        p.Hw();
    }

    protected UncaughtExceptionHandler j6() {
        return new 1(this);
    }

    public ak tp() {
        j6(this.u7);
        return this.u7;
    }

    public r u7() {
        j6(this.gn);
        return this.gn;
    }

    public ag v5() {
        return this.v5;
    }

    public q we() {
        j6(this.tp);
        return this.tp;
    }
}
