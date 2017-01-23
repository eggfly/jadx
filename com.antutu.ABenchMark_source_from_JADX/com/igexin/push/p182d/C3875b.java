package com.igexin.push.p182d;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.p169f.p170b.C3919e;
import com.igexin.push.util.C3922a;
import com.taobao.accs.common.Constants;

/* renamed from: com.igexin.push.d.b */
public class C3875b {
    private int f13025a;
    private int f13026b;
    private boolean f13027c;
    private int f13028d;
    private long f13029e;
    private int f13030f;
    private long f13031g;
    private C3894d f13032h;
    private C3896i f13033i;

    private C3875b() {
        this.f13025a = C3754m.f12654H;
        this.f13026b = C3754m.f12656J;
        this.f13033i = new C3897f();
        this.f13032h = C3922a.m16148d() ? C3894d.WIFI : C3894d.MOBILE;
    }

    public static C3875b m15932a() {
        return C3895e.f13127a;
    }

    private void m15933a(int i) {
        if (C3855g.f12969g != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.igexin.sdk.action.polling");
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.KEY_HTTP_CODE, i);
                intent.putExtras(bundle);
                if (C3922a.m16149e()) {
                    LocalBroadcastManager.getInstance(C3855g.f12969g.getApplicationContext()).sendBroadcast(intent);
                } else {
                    C3855g.f12969g.sendBroadcast(intent);
                }
            } catch (Throwable th) {
            }
        }
    }

    private void m15934h() {
        C3688a.m15097b("ConnectModelCoordinator|reset current model = normal");
        if (!(this.f13033i == null || (this.f13033i instanceof C3897f))) {
            this.f13033i = new C3897f();
        }
        C3919e.m16125g().m16129i();
        this.f13030f = 0;
        this.f13028d = 0;
        this.f13027c = false;
        C3799f.m15623a().m15653b(this.f13027c);
    }

    private void m15935i() {
        m15933a(0);
    }

    private void m15936j() {
        m15933a(1);
    }

    public void m15937a(boolean z) {
        this.f13027c = z;
        C3688a.m15097b("ConnectModelCoordinator|init, current is polling model = " + z);
        if (z) {
            C3919e.m16125g().m16128h();
        }
    }

    public synchronized void m15938b() {
        C3894d c3894d = C3922a.m16148d() ? C3894d.WIFI : C3894d.MOBILE;
        if (c3894d != this.f13032h) {
            C3688a.m15097b("ConnectModelCoordinator|net type changed " + this.f13032h + "->" + c3894d);
            m15934h();
            this.f13032h = c3894d;
        }
    }

    public C3896i m15939c() {
        return this.f13033i;
    }

    public synchronized void m15940d() {
        if (!this.f13027c) {
            long currentTimeMillis = System.currentTimeMillis() - this.f13029e;
            if (currentTimeMillis > 20000 && currentTimeMillis < 200000) {
                this.f13028d++;
                C3688a.m15097b("ConnectModelCoordinator|read len = -1, interval = " + currentTimeMillis + ", disconnect =" + this.f13028d);
                if (this.f13028d >= this.f13025a) {
                    C3688a.m15097b("ConnectModelCoordinator|enter polling mode ####");
                    m15935i();
                    this.f13027c = true;
                    this.f13033i = new C3898g();
                    C3919e.m16125g().m16128h();
                    C3799f.m15623a().m15653b(this.f13027c);
                }
            }
        }
    }

    public synchronized void m15941e() {
        if (this.f13027c) {
            if (System.currentTimeMillis() - this.f13031g >= 120000) {
                this.f13030f++;
                C3688a.m15097b("ConnectModelCoordinator|polling mode, cur hearbeat =" + this.f13030f);
                if (this.f13030f >= this.f13026b) {
                    C3688a.m15097b("ConnectModelCoordinator|enter normal mode ####");
                    m15936j();
                    C3855g.f12941E = 0;
                    m15934h();
                }
            }
            this.f13031g = System.currentTimeMillis();
        }
    }

    public void m15942f() {
        this.f13029e = System.currentTimeMillis();
        if (this.f13027c) {
            this.f13033i = new C3898g();
            C3919e.m16125g().m16128h();
            this.f13030f = 0;
        }
    }

    public void m15943g() {
        if (this.f13027c && this.f13033i != null && !(this.f13033i instanceof C3897f)) {
            this.f13033i = new C3897f();
        }
    }
}
