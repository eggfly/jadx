package com.xiaomi.stats;

import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.C4450y.C4448b.C4405a;
import com.xiaomi.push.service.C4450y.C4449c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.push.thrift.C4455b;
import com.xiaomi.smack.C4461a;
import com.xiaomi.stats.C4506d.C4505a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.stats.a */
class C4502a implements C4405a {
    private XMPushService f15481a;
    private C4448b f15482b;
    private C4461a f15483c;
    private C4449c f15484d;
    private int f15485e;
    private boolean f15486f;

    C4502a(XMPushService xMPushService, C4448b c4448b) {
        this.f15486f = false;
        this.f15481a = xMPushService;
        this.f15484d = C4449c.binding;
        this.f15482b = c4448b;
    }

    private void m18672b() {
        this.f15482b.m18389b((C4405a) this);
    }

    private void m18673c() {
        m18672b();
        if (this.f15486f && this.f15485e != 11) {
            C4455b f = C4509f.m18692a().m18703f();
            switch (C4504c.f15488a[this.f15484d.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (this.f15485e != 17) {
                        if (this.f15485e != 21) {
                            try {
                                C4505a c = C4506d.m18680c(C4509f.m18694b().m18685a());
                                f.f15273b = c.f15489a.m18407a();
                                f.m18425c(c.f15490b);
                                break;
                            } catch (NullPointerException e) {
                                f = null;
                                break;
                            }
                        }
                        f.f15273b = C4452a.BIND_TIMEOUT.m18407a();
                        break;
                    }
                    f.f15273b = C4452a.BIND_TCP_READ_TIMEOUT.m18407a();
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    f.f15273b = C4452a.BIND_SUCCESS.m18407a();
                    break;
            }
            if (f != null) {
                f.m18420b(this.f15483c.m18470c());
                f.m18429d(this.f15482b.f15170b);
                f.f15274c = 1;
                try {
                    f.m18411a((byte) Integer.parseInt(this.f15482b.f15176h));
                } catch (NumberFormatException e2) {
                }
                C4509f.m18692a().m18699a(f);
            }
        }
    }

    void m18674a() {
        this.f15482b.m18387a((C4405a) this);
        this.f15483c = this.f15481a.m18103g();
    }

    public void m18675a(C4449c c4449c, C4449c c4449c2, int i) {
        if (!this.f15486f && c4449c == C4449c.binding) {
            this.f15484d = c4449c2;
            this.f15485e = i;
            this.f15486f = true;
        }
        this.f15481a.m18080a(new C4503b(this, 4));
    }
}
