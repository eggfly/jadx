package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.C2845a;
import com.google.android.gms.ads.internal.overlay.C2865e;
import com.google.android.gms.ads.internal.purchase.C2893i;
import com.google.android.gms.ads.internal.request.C2906a;
import com.google.android.gms.p146b.an;
import com.google.android.gms.p146b.ao;
import com.google.android.gms.p146b.ap;
import com.google.android.gms.p146b.at;
import com.google.android.gms.p146b.cm;
import com.google.android.gms.p146b.cu;
import com.google.android.gms.p146b.dq;
import com.google.android.gms.p146b.fq;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gk;
import com.google.android.gms.p146b.gz;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.hk;
import com.google.android.gms.p146b.hp;
import com.google.android.gms.p146b.ik;
import com.google.android.gms.p146b.jg;
import com.google.android.gms.p146b.ji;

@gb
/* renamed from: com.google.android.gms.ads.internal.s */
public class C2968s {
    private static final Object f10016a;
    private static C2968s f10017b;
    private final C2906a f10018c;
    private final C2845a f10019d;
    private final C2865e f10020e;
    private final fq f10021f;
    private final hj f10022g;
    private final ik f10023h;
    private final hk f10024i;
    private final gz f10025j;
    private final jg f10026k;
    private final at f10027l;
    private final gk f10028m;
    private final ao f10029n;
    private final an f10030o;
    private final ap f10031p;
    private final C2893i f10032q;
    private final cu f10033r;
    private final hp f10034s;
    private final dq f10035t;
    private final C2878p f10036u;
    private final cm f10037v;

    static {
        f10016a = new Object();
        C2968s.m11521a(new C2968s());
    }

    protected C2968s() {
        this.f10018c = new C2906a();
        this.f10019d = new C2845a();
        this.f10020e = new C2865e();
        this.f10021f = new fq();
        this.f10022g = new hj();
        this.f10023h = new ik();
        this.f10024i = hk.m13074a(VERSION.SDK_INT);
        this.f10025j = new gz(this.f10022g);
        this.f10026k = new ji();
        this.f10027l = new at();
        this.f10028m = new gk();
        this.f10029n = new ao();
        this.f10030o = new an();
        this.f10031p = new ap();
        this.f10032q = new C2893i();
        this.f10033r = new cu();
        this.f10034s = new hp();
        this.f10035t = new dq();
        this.f10036u = new C2878p();
        this.f10037v = new cm();
    }

    public static C2906a m11520a() {
        return C2968s.m11541u().f10018c;
    }

    protected static void m11521a(C2968s c2968s) {
        synchronized (f10016a) {
            f10017b = c2968s;
        }
    }

    public static C2845a m11522b() {
        return C2968s.m11541u().f10019d;
    }

    public static C2865e m11523c() {
        return C2968s.m11541u().f10020e;
    }

    public static fq m11524d() {
        return C2968s.m11541u().f10021f;
    }

    public static hj m11525e() {
        return C2968s.m11541u().f10022g;
    }

    public static ik m11526f() {
        return C2968s.m11541u().f10023h;
    }

    public static hk m11527g() {
        return C2968s.m11541u().f10024i;
    }

    public static gz m11528h() {
        return C2968s.m11541u().f10025j;
    }

    public static jg m11529i() {
        return C2968s.m11541u().f10026k;
    }

    public static at m11530j() {
        return C2968s.m11541u().f10027l;
    }

    public static gk m11531k() {
        return C2968s.m11541u().f10028m;
    }

    public static ao m11532l() {
        return C2968s.m11541u().f10029n;
    }

    public static an m11533m() {
        return C2968s.m11541u().f10030o;
    }

    public static ap m11534n() {
        return C2968s.m11541u().f10031p;
    }

    public static C2893i m11535o() {
        return C2968s.m11541u().f10032q;
    }

    public static cu m11536p() {
        return C2968s.m11541u().f10033r;
    }

    public static hp m11537q() {
        return C2968s.m11541u().f10034s;
    }

    public static dq m11538r() {
        return C2968s.m11541u().f10035t;
    }

    public static C2878p m11539s() {
        return C2968s.m11541u().f10036u;
    }

    public static cm m11540t() {
        return C2968s.m11541u().f10037v;
    }

    private static C2968s m11541u() {
        C2968s c2968s;
        synchronized (f10016a) {
            c2968s = f10017b;
        }
        return c2968s;
    }
}
