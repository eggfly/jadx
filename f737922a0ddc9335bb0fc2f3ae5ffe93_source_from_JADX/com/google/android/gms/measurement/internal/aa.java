package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.measurement.AppMeasurement;

public class aa extends b {
    private final char DW;
    private final a EQ;
    private final long FH;
    private final a Hw;
    private final a VH;
    private final a Zo;
    private final a gn;
    private final String j6;
    private final a tp;
    private final a u7;
    private final a v5;
    private final a we;

    class 1 implements Runnable {
        final /* synthetic */ aa DW;
        final /* synthetic */ String j6;

        1(aa aaVar, String str) {
            this.DW = aaVar;
            this.j6 = str;
        }

        public void run() {
            ae v5 = this.DW.J8.v5();
            if (!v5.j6() || v5.DW()) {
                this.DW.j6(6, "Persisted config not initialized . Not logging error/warn.");
            } else {
                v5.DW.j6(this.j6);
            }
        }
    }

    public class a {
        private final int DW;
        private final boolean FH;
        private final boolean Hw;
        final /* synthetic */ aa j6;

        a(aa aaVar, int i, boolean z, boolean z2) {
            this.j6 = aaVar;
            this.DW = i;
            this.FH = z;
            this.Hw = z2;
        }

        public void j6(String str) {
            this.j6.j6(this.DW, this.FH, this.Hw, str, null, null, null);
        }

        public void j6(String str, Object obj) {
            this.j6.j6(this.DW, this.FH, this.Hw, str, obj, null, null);
        }

        public void j6(String str, Object obj, Object obj2) {
            this.j6.j6(this.DW, this.FH, this.Hw, str, obj, obj2, null);
        }

        public void j6(String str, Object obj, Object obj2, Object obj3) {
            this.j6.j6(this.DW, this.FH, this.Hw, str, obj, obj2, obj3);
        }
    }

    aa(ai aiVar) {
        super(aiVar);
        this.j6 = er().j6();
        this.FH = er().sG();
        if (er().Sf()) {
            this.DW = er().ef() ? 'P' : 'C';
        } else {
            this.DW = er().ef() ? 'p' : 'c';
        }
        this.Hw = new a(this, 6, false, false);
        this.v5 = new a(this, 6, true, false);
        this.Zo = new a(this, 6, false, true);
        this.VH = new a(this, 5, false, false);
        this.gn = new a(this, 5, true, false);
        this.u7 = new a(this, 5, false, true);
        this.tp = new a(this, 4, false, false);
        this.EQ = new a(this, 3, false, false);
        this.we = new a(this, 2, false, false);
    }

    private static String j6(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String j6(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String j6 = j6(AppMeasurement.class.getCanonicalName());
                String j62 = j6(ai.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = j6(className);
                            if (className.equals(j6) || className.equals(j62)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String j6(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object j6 = j6(z, obj);
        Object j62 = j6(z, obj2);
        Object j63 = j6(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(j6)) {
            stringBuilder.append(str2);
            stringBuilder.append(j6);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(j62)) {
            stringBuilder.append(str2);
            stringBuilder.append(j62);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(j63)) {
            stringBuilder.append(str2);
            stringBuilder.append(j63);
        }
        return stringBuilder.toString();
    }

    public a BT() {
        return this.u7;
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public a P8() {
        return this.EQ;
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    public a VH() {
        return this.v5;
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public a Zo() {
        return this.Hw;
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public a ei() {
        return this.we;
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public a gW() {
        return this.gn;
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    protected void j6(int i, String str) {
        Log.println(i, this.j6, str);
    }

    public void j6(int i, String str, Object obj, Object obj2, Object obj3) {
        b.j6((Object) str);
        ah EQ = this.J8.EQ();
        if (EQ == null) {
            j6(6, "Scheduler not set. Not logging error/warn.");
        } else if (!EQ.j6()) {
            j6(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (EQ.DW()) {
            j6(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.DW;
            long j = this.FH;
            String valueOf2 = String.valueOf(j6(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            EQ.j6(new 1(this, valueOf));
        }
    }

    protected void j6(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && j6(i)) {
            j6(i, j6(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            j6(i, str, obj, obj2, obj3);
        }
    }

    protected boolean j6(int i) {
        return Log.isLoggable(this.j6, i);
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public String nw() {
        Pair j6 = rN().DW.j6();
        if (j6 == null || j6 == ae.j6) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(j6.second));
        String str = (String) j6.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    protected void v5() {
    }

    public a vy() {
        return this.tp;
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    public a yS() {
        return this.VH;
    }
}
