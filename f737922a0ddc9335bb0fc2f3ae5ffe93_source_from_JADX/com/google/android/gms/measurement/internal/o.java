package com.google.android.gms.measurement.internal;

import afq;
import agc;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.gw;
import com.google.android.gms.measurement.internal.w.a;

public class o extends ak {
    static final String j6;
    private Boolean DW;

    static {
        j6 = String.valueOf(i.DW / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    }

    o(ai aiVar) {
        super(aiVar);
    }

    private Boolean VH(String str) {
        Boolean bool = null;
        b.j6(str);
        try {
            PackageManager packageManager = XL().getPackageManager();
            if (packageManager == null) {
                lg().Zo().j6("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(XL().getPackageName(), 128);
                if (applicationInfo == null) {
                    lg().Zo().j6("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    lg().Zo().j6("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            lg().Zo().j6("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    int BT() {
        return 500;
    }

    public int DW() {
        return 25;
    }

    public int DW(String str, a<Integer> aVar) {
        if (str == null) {
            return ((Integer) aVar.DW()).intValue();
        }
        Object j6 = Mr().j6(str, aVar.j6());
        if (TextUtils.isEmpty(j6)) {
            return ((Integer) aVar.DW()).intValue();
        }
        try {
            return ((Integer) aVar.j6(Integer.valueOf(Integer.valueOf(j6).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) aVar.DW()).intValue();
        }
    }

    long DW(String str) {
        return j6(str, w.Hw);
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public int FH() {
        return 32;
    }

    int FH(String str) {
        return DW(str, w.yS);
    }

    public int Hw() {
        return 24;
    }

    public int Hw(String str) {
        return DW(str, w.u7);
    }

    public long I() {
        return ((Long) w.er.DW()).longValue();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    long KD() {
        return 3600000;
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public boolean Mz() {
        return gw.DW();
    }

    public long OW() {
        return ((Long) w.Zo.DW()).longValue();
    }

    public long P8() {
        return (long) ((Integer) w.J8.DW()).intValue();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public long Qq() {
        return Math.max(0, ((Long) w.v5.DW()).longValue());
    }

    int SI() {
        return 50;
    }

    public boolean Sf() {
        if (this.DW == null) {
            synchronized (this) {
                if (this.DW == null) {
                    ApplicationInfo applicationInfo = XL().getApplicationInfo();
                    String DW = agc.DW();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(DW);
                        this.DW = Boolean.valueOf(z);
                    }
                    if (this.DW == null) {
                        this.DW = Boolean.TRUE;
                        lg().Zo().j6("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.DW.booleanValue();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    int VH() {
        return 256;
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public long XG() {
        return Math.max(0, ((Long) w.lg.DW()).longValue());
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public long XX() {
        return Math.max(0, ((Long) w.Mr.DW()).longValue());
    }

    int Zo() {
        return 36;
    }

    public int Zo(String str) {
        return Math.max(0, Math.min(1000000, DW(str, w.QX)));
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public int aj() {
        return Math.max(1, ((Integer) w.we.DW()).intValue());
    }

    public long br() {
        return Math.max(0, ((Long) w.aM.DW()).longValue());
    }

    public long ca() {
        return ((Long) w.U2.DW()).longValue();
    }

    public String cb() {
        return "google_app_measurement.db";
    }

    long cn() {
        return 61000;
    }

    public String dx() {
        return "google_app_measurement2.db";
    }

    public boolean ef() {
        return false;
    }

    public long ei() {
        return 1000;
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public Boolean g3() {
        return ef() ? null : VH("firebase_analytics_collection_enabled");
    }

    public int gW() {
        return 2048;
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    public int j6(String str) {
        return DW(str, w.Ws);
    }

    public long j6(String str, a<Long> aVar) {
        if (str == null) {
            return ((Long) aVar.DW()).longValue();
        }
        Object j6 = Mr().j6(str, aVar.j6());
        if (TextUtils.isEmpty(j6)) {
            return ((Long) aVar.DW()).longValue();
        }
        try {
            return ((Long) aVar.j6(Long.valueOf(Long.valueOf(j6).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) aVar.DW()).longValue();
        }
    }

    String j6() {
        return (String) w.FH.DW();
    }

    public String j6(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) w.VH.DW()).encodedAuthority((String) w.gn.DW());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(sG()));
        return builder.build().toString();
    }

    public int jJ() {
        return Math.min(20, Math.max(0, ((Integer) w.rN.DW()).intValue()));
    }

    public long kQ() {
        return ((Long) w.j3.DW()).longValue();
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public String lp() {
        return (String) w.XL.DW();
    }

    int nw() {
        return 25;
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    long ro() {
        return 60000;
    }

    public long sG() {
        return 9080;
    }

    long sh() {
        return ((Long) w.gW.DW()).longValue();
    }

    public int sy() {
        return Math.max(0, ((Integer) w.EQ.DW()).intValue());
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    int v5() {
        return 24;
    }

    public int v5(String str) {
        return Math.max(0, DW(str, w.tp));
    }

    public boolean vJ() {
        if (ef()) {
            return false;
        }
        Boolean VH = VH("firebase_analytics_collection_deactivated");
        return (VH == null || VH.booleanValue()) ? false : true;
    }

    public long vy() {
        return (long) ((Integer) w.J0.DW()).intValue();
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    public long x9() {
        return 1000;
    }

    public long yO() {
        return Math.max(0, ((Long) w.a8.DW()).longValue());
    }

    public int yS() {
        return 36;
    }
}
