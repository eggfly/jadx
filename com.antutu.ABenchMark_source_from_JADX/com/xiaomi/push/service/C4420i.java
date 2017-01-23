package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.C4450y.C4449c;
import com.xiaomi.push.service.XMPushService.C4385g;
import com.xiaomi.push.service.XMPushService.C4386a;
import java.util.Collection;

/* renamed from: com.xiaomi.push.service.i */
public class C4420i extends C4385g {
    private XMPushService f15086b;
    private byte[] f15087c;
    private String f15088d;
    private String f15089e;
    private String f15090f;

    public C4420i(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f15086b = xMPushService;
        this.f15088d = str;
        this.f15087c = bArr;
        this.f15089e = str2;
        this.f15090f = str3;
    }

    public void m18243a() {
        C4416f a;
        Collection c;
        C4448b c4448b;
        C4416f a2 = C4418g.m18232a(this.f15086b);
        if (a2 == null) {
            try {
                a = C4418g.m18233a(this.f15086b, this.f15088d, this.f15089e, this.f15090f);
            } catch (Throwable e) {
                C4302b.m17651a(e);
                a = a2;
            } catch (Throwable e2) {
                C4302b.m17651a(e2);
            }
            if (a != null) {
                C4302b.m17654d("no account for mipush");
                C4421j.m18245a(this.f15086b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            }
            c = C4450y.m18390a().m18402c("5");
            if (c.isEmpty()) {
                c4448b = (C4448b) c.iterator().next();
            } else {
                c4448b = a.m18229a(this.f15086b);
                this.f15086b.m18082a(c4448b);
                C4450y.m18390a().m18395a(c4448b);
            }
            if (this.f15086b.m18101e()) {
                this.f15086b.m18090a(true);
                return;
            }
            try {
                if (c4448b.f15181m == C4449c.binded) {
                    this.f15086b.m18089a(this.f15088d, this.f15087c);
                    return;
                } else if (c4448b.f15181m == C4449c.unbind) {
                    XMPushService xMPushService = this.f15086b;
                    XMPushService xMPushService2 = this.f15086b;
                    xMPushService2.getClass();
                    xMPushService.m18080a(new C4386a(xMPushService2, c4448b));
                    return;
                } else {
                    return;
                }
            } catch (Exception e3) {
                C4302b.m17651a((Throwable) e3);
                this.f15086b.m18079a(10, e3);
                return;
            }
        }
        a = a2;
        if (a != null) {
            c = C4450y.m18390a().m18402c("5");
            if (c.isEmpty()) {
                c4448b = (C4448b) c.iterator().next();
            } else {
                c4448b = a.m18229a(this.f15086b);
                this.f15086b.m18082a(c4448b);
                C4450y.m18390a().m18395a(c4448b);
            }
            if (this.f15086b.m18101e()) {
                this.f15086b.m18090a(true);
                return;
            } else if (c4448b.f15181m == C4449c.binded) {
                this.f15086b.m18089a(this.f15088d, this.f15087c);
                return;
            } else if (c4448b.f15181m == C4449c.unbind) {
                XMPushService xMPushService3 = this.f15086b;
                XMPushService xMPushService22 = this.f15086b;
                xMPushService22.getClass();
                xMPushService3.m18080a(new C4386a(xMPushService22, c4448b));
                return;
            } else {
                return;
            }
        }
        C4302b.m17654d("no account for mipush");
        C4421j.m18245a(this.f15086b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
    }

    public String m18244b() {
        return "register app";
    }
}
