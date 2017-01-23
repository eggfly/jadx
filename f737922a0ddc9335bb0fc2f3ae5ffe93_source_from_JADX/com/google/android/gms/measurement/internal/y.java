package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gw;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class y extends b {
    private static final X500Principal j6;
    private String DW;
    private String FH;
    private int Hw;
    private long VH;
    private String Zo;
    private String gn;
    private String v5;

    static {
        j6 = new X500Principal("CN=Android Debug,O=Android,C=US");
    }

    y(ai aiVar) {
        super(aiVar);
    }

    String BT() {
        FH();
        return this.v5;
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

    long P8() {
        FH();
        return this.VH;
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    String VH() {
        FH();
        return this.gn;
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    String Zo() {
        FH();
        return this.DW;
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    boolean ei() {
        try {
            PackageInfo packageInfo = XL().getPackageManager().getPackageInfo(XL().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(j6);
            }
        } catch (CertificateException e) {
            lg().Zo().j6("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            lg().Zo().j6("Package name not found", e2);
        }
        return true;
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    int gW() {
        FH();
        return this.Hw;
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    AppMetadata j6(String str) {
        return new AppMetadata(Zo(), VH(), yS(), (long) gW(), BT(), vy(), P8(), str, this.J8.P8(), !rN().J0, rN().VH());
    }

    protected void j6(Status status) {
        if (status == null) {
            lg().Zo().j6("GoogleService failed to initialize (no status)");
        } else {
            lg().Zo().j6("GoogleService failed to initialize, status", Integer.valueOf(status.Zo()), status.FH());
        }
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
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String str2 = "Unknown";
        PackageManager packageManager = XL().getPackageManager();
        String packageName = XL().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(XL().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            lg().Zo().j6("Error retrieving package info: appName", str2);
        }
        this.DW = packageName;
        this.v5 = installerPackageName;
        this.FH = str;
        this.Hw = i;
        this.Zo = str2;
        MessageDigest gn = l.gn("MD5");
        if (gn == null) {
            lg().Zo().j6("Could not get MD5 instance");
            this.VH = -1;
        } else {
            this.VH = 0;
            try {
                if (!ei()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(XL().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.VH = l.FH(gn.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                lg().Zo().j6("Package name not found", e2);
            }
        }
        Status j6 = er().ef() ? gw.j6(XL(), "-", true) : gw.j6(XL());
        boolean z = j6 != null && j6.v5();
        if (!z) {
            j6(j6);
        }
        if (z) {
            Boolean g3 = er().g3();
            if (er().vJ()) {
                lg().vy().j6("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (g3 != null && !g3.booleanValue()) {
                lg().vy().j6("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (g3 == null && er().Mz()) {
                lg().vy().j6("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                lg().ei().j6("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.gn = "";
        if (!er().ef()) {
            try {
                String j62 = gw.j6();
                if (TextUtils.isEmpty(j62)) {
                    j62 = "";
                }
                this.gn = j62;
                if (z) {
                    lg().ei().j6("App package, google app id", this.DW, this.gn);
                }
            } catch (IllegalStateException e3) {
                lg().Zo().j6("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    long vy() {
        return er().sG();
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    String yS() {
        FH();
        return this.FH;
    }
}
