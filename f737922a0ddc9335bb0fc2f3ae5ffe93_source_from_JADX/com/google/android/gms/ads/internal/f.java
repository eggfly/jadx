package com.google.android.gms.ads.internal;

import afq;
import afs;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.overlay.n;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.ads.internal.purchase.b;
import com.google.android.gms.ads.internal.request.a;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.ao;
import com.google.android.gms.internal.ap;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.ch;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.el;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import com.google.android.gms.internal.ev;
import com.google.android.gms.internal.ew;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fl;

@eh
public class f {
    private static f DW;
    private static final Object j6;
    private final afq EQ;
    private final a FH;
    private final com.google.android.gms.ads.internal.overlay.a Hw;
    private final ei J0;
    private final ao J8;
    private final n Mr;
    private final ap QX;
    private final o U2;
    private final et VH;
    private final an Ws;
    private final b XL;
    private final ee Zo;
    private final co a8;
    private final cm aM;
    private final d er;
    private final fd gW;
    private final fl gn;
    private final ev j3;
    private final ew lg;
    private final b rN;
    private final el tp;
    private final eu u7;
    private final d v5;
    private final as we;
    private final ch yS;

    static {
        j6 = new Object();
        j6(new f());
    }

    protected f() {
        this.FH = new a();
        this.Hw = new com.google.android.gms.ads.internal.overlay.a();
        this.v5 = new d();
        this.Zo = new ee();
        this.VH = new et();
        this.gn = new fl();
        this.u7 = eu.j6(VERSION.SDK_INT);
        this.tp = new el(this.VH);
        this.EQ = new afs();
        this.we = new as();
        this.J0 = new ei();
        this.J8 = new ao();
        this.Ws = new an();
        this.QX = new ap();
        this.XL = new b();
        this.aM = new cm();
        this.j3 = new ev();
        this.Mr = new n();
        this.U2 = new o();
        this.a8 = new co();
        this.lg = new ew();
        this.rN = new b();
        this.er = new d();
        this.yS = new ch();
        this.gW = new fd();
    }

    public static d DW() {
        return J0().v5;
    }

    public static ch EQ() {
        return J0().yS;
    }

    public static et FH() {
        return J0().VH;
    }

    public static fl Hw() {
        return J0().gn;
    }

    private static f J0() {
        f fVar;
        synchronized (j6) {
            fVar = DW;
        }
        return fVar;
    }

    public static afq VH() {
        return J0().EQ;
    }

    public static el Zo() {
        return J0().tp;
    }

    public static an gn() {
        return J0().Ws;
    }

    public static com.google.android.gms.ads.internal.overlay.a j6() {
        return J0().Hw;
    }

    protected static void j6(f fVar) {
        synchronized (j6) {
            DW = fVar;
        }
    }

    public static ew tp() {
        return J0().lg;
    }

    public static ap u7() {
        return J0().QX;
    }

    public static eu v5() {
        return J0().u7;
    }

    public static fd we() {
        return J0().gW;
    }
}
