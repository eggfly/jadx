package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p161b.p162a.p163a.p164a.C3662d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.p174c.C3730i;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.igexin.b.a.b.a.a.c */
public final class C3670c extends C3668a {
    private static final String f12366i;
    private Socket f12367L;
    private C3662d f12368j;

    static {
        f12366i = C3670c.class.getName();
    }

    public C3670c(C3662d c3662d) {
        super(TnetStatusCode.EASY_REASON_INVALID_DATA, null, null);
        this.f12368j = c3662d;
    }

    public void a_() {
        super.a_();
        C3730i.m15273a().m15277e().m15257a();
        String cmAddress = SDKUrlConfig.getCmAddress();
        try {
            String[] a = C3687f.m15083a(cmAddress);
            String str = a[1];
            int parseInt = Integer.parseInt(a[2]);
            C3688a.m15097b(f12366i + "|start connect :  " + cmAddress + " *********");
            if (this.f12368j != null) {
                this.f12368j.m14945a(cmAddress);
            }
            this.f12367L = new Socket();
            try {
                this.f12367L.connect(new InetSocketAddress(str, parseInt), 10000);
                C3688a.m15097b(f12366i + "|connected :  " + cmAddress);
                if (this.f != C3669b.INTERRUPT) {
                    this.f = C3669b.NORMAL;
                }
            } catch (Exception e) {
                if (this.f != C3669b.INTERRUPT) {
                    this.f = C3669b.EXCEPTION;
                    this.g = e.toString();
                }
            }
            this.e = true;
        } catch (Exception e2) {
            C3688a.m15097b(f12366i + "|ips invalid, " + e2.toString());
            throw e2;
        }
    }

    public final int m14978b() {
        return TnetStatusCode.EASY_REASON_INVALID_DATA;
    }

    public void m14979f() {
        super.m14974f();
        C3688a.m15097b(f12366i + "|dispose");
        if (this.f12368j != null) {
            if (this.f == C3669b.INTERRUPT) {
                this.f12368j.m14939a(this);
            } else if (this.f == C3669b.EXCEPTION) {
                if (!TextUtils.isEmpty(this.g)) {
                    this.f12368j.m14944a(new Exception(this.g));
                }
            } else if (this.f == C3669b.NORMAL && this.f12367L != null) {
                this.f12368j.m14946a(this.f12367L);
            }
        }
        this.f12368j = null;
    }

    public void m14980h() {
        this.f = C3669b.INTERRUPT;
        try {
            if (this.f12367L != null && !this.e) {
                this.f12367L.notifyAll();
            }
        } catch (Exception e) {
        }
    }
}
