package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class r extends b {
    private String DW;
    private Boolean FH;
    private long j6;

    r(ai aiVar) {
        super(aiVar);
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

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    public String VH() {
        FH();
        return VERSION.RELEASE;
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public String Zo() {
        FH();
        return Build.MODEL;
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public String gW() {
        FH();
        return this.DW;
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    public boolean j6(Context context) {
        if (this.FH == null) {
            if (er().ef()) {
                this.FH = Boolean.valueOf(true);
            } else {
                this.FH = Boolean.valueOf(false);
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        packageManager.getPackageInfo("com.google.android.gms", 128);
                        this.FH = Boolean.valueOf(true);
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return this.FH.booleanValue();
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
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
        Calendar instance = Calendar.getInstance();
        this.j6 = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String valueOf2 = String.valueOf(locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.DW = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("-").append(valueOf2).toString();
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    public long yS() {
        FH();
        return this.j6;
    }
}
