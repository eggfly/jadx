package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Future;

@eh
public class el {
    private final String DW;
    private Context EQ;
    private final em FH;
    private BigInteger Hw;
    private ar J0;
    private boolean J8;
    private boolean Mr;
    private ag QX;
    private boolean U2;
    private boolean VH;
    private af Ws;
    private ae XL;
    private final HashMap<String, Object> Zo;
    private boolean a8;
    private Boolean aM;
    private long er;
    private boolean gn;
    private String j3;
    private final Object j6;
    private boolean lg;
    private String rN;
    private boolean tp;
    private int u7;
    private final HashSet<Object> v5;
    private VersionInfoParcel we;

    public el(et etVar) {
        this.j6 = new Object();
        this.Hw = BigInteger.ONE;
        this.v5 = new HashSet();
        this.Zo = new HashMap();
        this.VH = false;
        this.gn = true;
        this.u7 = 0;
        this.tp = false;
        this.J0 = null;
        this.J8 = true;
        this.Ws = null;
        this.QX = null;
        this.XL = null;
        this.aM = null;
        this.Mr = false;
        this.U2 = false;
        this.a8 = false;
        this.lg = false;
        this.rN = "";
        this.er = 0;
        this.DW = etVar.DW();
        this.FH = new em(this.DW);
    }

    public String DW() {
        String str;
        synchronized (this.j6) {
            str = this.j3;
        }
        return str;
    }

    public Boolean FH() {
        Boolean bool;
        synchronized (this.j6) {
            bool = this.aM;
        }
        return bool;
    }

    public Resources Hw() {
        if (this.we.v5) {
            return this.EQ.getResources();
        }
        try {
            hn j6 = hn.j6(this.EQ, hn.j6, "com.google.android.gms.ads.dynamite");
            return j6 != null ? j6.j6().getResources() : null;
        } catch (Throwable e) {
            b.FH("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public ar j6() {
        ar arVar;
        synchronized (this.j6) {
            arVar = this.J0;
        }
        return arVar;
    }

    public Future j6(Context context, String str) {
        Future j6;
        this.er = f.VH().j6();
        synchronized (this.j6) {
            if (str != null) {
                if (!str.equals(this.rN)) {
                    this.rN = str;
                    j6 = eq.j6(context, str, this.er);
                }
            }
            j6 = null;
        }
        return j6;
    }

    public void j6(Boolean bool) {
        synchronized (this.j6) {
            this.aM = bool;
        }
    }

    public void j6(Throwable th, boolean z) {
        new eg(this.EQ, this.we, null, null).j6(th, z);
    }
}
