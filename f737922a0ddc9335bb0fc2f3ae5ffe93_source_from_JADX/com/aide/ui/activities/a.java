package com.aide.ui.activities;

import com.aide.ui.e;
import com.aide.ui.h;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import qh;

public enum a {
    ANDROID_API("Android API", false, "http://developer.android.com/reference/", "packages.html", "http://dl-ssl.google.com/android/repository/docs-24_r01.zip", "docs/reference/", true),
    JAVA_API("Java API", false, "http://docs.oracle.com/javase/7/docs/api/", "overview-summary.html", null, null, true),
    PHONEGAP_API("PhoneGap API", true, "http://docs.phonegap.com/en/3.0.0/index.html", "", "https://github.com/phonegap/phonegap/archive/2.9.0.zip", "phonegap-2.9.0/doc/index.html", true),
    JQUERY_API("jQuery API", true, "http://jqapi.com/", "", "http://jqapi.com/jqapi.zip", "index.html", true);
    
    private boolean EQ;
    private String VH;
    private String Zo;
    private String gn;
    private boolean tp;
    private String u7;
    private String v5;

    private a(String str, boolean z, String str2, String str3, String str4, String str5, boolean z2) {
        this.v5 = str;
        this.Zo = str2;
        this.tp = z;
        this.VH = str5;
        this.gn = str3;
        this.u7 = str4;
        this.EQ = z2;
    }

    public String j6() {
        return this.v5;
    }

    public String DW() {
        return j6(this.gn);
    }

    public boolean FH() {
        return this.EQ;
    }

    public String j6(String str) {
        if (str == null) {
            str = "";
        }
        if (!(v5() == null || h.DW() == null)) {
            String str2 = h.DW() + "/" + v5();
            if (qh.VH(str2)) {
                return "file://" + str2 + "/" + this.VH + str;
            }
        }
        return this.Zo + str;
    }

    public boolean Hw() {
        return this.tp;
    }

    public String v5() {
        try {
            if (this.u7 != null) {
                return new File(new URL(this.u7).getFile()).getName();
            }
        } catch (MalformedURLException e) {
        }
        return null;
    }

    public String Zo() {
        return this.u7;
    }

    public int VH() {
        a[] gn = gn();
        for (int i = 0; i < gn.length; i++) {
            if (gn[i].equals(this)) {
                return i;
            }
        }
        return -1;
    }

    public static a[] gn() {
        if (e.Hw()) {
            return values();
        }
        if (e.j6.equals("com.aide.ui")) {
            return new a[]{ANDROID_API, JAVA_API};
        }
        return new a[]{PHONEGAP_API, JQUERY_API, ANDROID_API};
    }

    public static long u7() {
        return 800000000;
    }

    public static a tp() {
        return ANDROID_API;
    }

    public static a EQ() {
        return ANDROID_API;
    }
}
