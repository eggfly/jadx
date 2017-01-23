package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ad {
    private static ad j6;
    private volatile a DW;
    private volatile String FH;
    private volatile String Hw;
    private volatile String v5;

    enum a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    ad() {
        v5();
    }

    private String DW(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static ad j6() {
        ad adVar;
        synchronized (ad.class) {
            if (j6 == null) {
                j6 = new ad();
            }
            adVar = j6;
        }
        return adVar;
    }

    private String j6(String str) {
        return str.split("&")[0].split("=")[1];
    }

    a DW() {
        return this.DW;
    }

    String FH() {
        return this.Hw;
    }

    String Hw() {
        return this.FH;
    }

    synchronized boolean j6(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                String str;
                String valueOf;
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    str = "Container preview url: ";
                    valueOf = String.valueOf(decode);
                    r.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.DW = a.CONTAINER_DEBUG;
                    } else {
                        this.DW = a.CONTAINER;
                    }
                    this.v5 = DW(uri);
                    if (this.DW == a.CONTAINER || this.DW == a.CONTAINER_DEBUG) {
                        decode = String.valueOf("/r?");
                        valueOf = String.valueOf(this.v5);
                        this.Hw = valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode);
                    }
                    this.FH = j6(this.v5);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    str = "Invalid preview uri: ";
                    String valueOf2 = String.valueOf(decode);
                    r.DW(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    z = false;
                } else if (j6(uri.getQuery()).equals(this.FH)) {
                    decode = "Exit preview mode for container: ";
                    valueOf = String.valueOf(this.FH);
                    r.Hw(valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode));
                    this.DW = a.NONE;
                    this.Hw = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    void v5() {
        this.DW = a.NONE;
        this.Hw = null;
        this.FH = null;
        this.v5 = null;
    }
}
