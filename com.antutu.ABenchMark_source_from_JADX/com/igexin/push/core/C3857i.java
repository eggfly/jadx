package com.igexin.push.core;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.ads.AdError;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.umeng.analytics.C4156a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.core.i */
public class C3857i {
    private static C3857i f12989e;
    public long f12990a;
    private C3860l f12991b;
    private long f12992c;
    private ConnectivityManager f12993d;

    private C3857i() {
        this.f12990a = 240000;
        this.f12991b = C3860l.DETECT;
        this.f12992c = 0;
        this.f12993d = C3854f.m15859a().m15880j();
    }

    public static C3857i m15894a() {
        if (f12989e == null) {
            f12989e = new C3857i();
        }
        return f12989e;
    }

    private void m15895b(C3859k c3859k) {
        switch (C3858j.f12995b[c3859k.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m15898a(Math.min(this.f12990a + 60000, 420000));
                m15900a(C3860l.DETECT);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.f12992c++;
                if (this.f12992c >= 2) {
                    m15898a(Math.max(this.f12990a - 60000, 240000));
                    m15900a(C3860l.STABLE);
                }
            case SpdyProtocol.QUIC /*4*/:
                m15898a(240000);
                m15900a(C3860l.DETECT);
            default:
        }
    }

    private void m15896c(C3859k c3859k) {
        switch (C3858j.f12995b[c3859k.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m15900a(C3860l.STABLE);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m15898a(Math.max(this.f12990a - 60000, 240000));
                this.f12992c++;
                if (this.f12992c >= 2) {
                    m15898a(240000);
                    m15900a(C3860l.PENDING);
                }
            case SpdyProtocol.QUIC /*4*/:
                m15898a(240000);
                m15900a(C3860l.DETECT);
            default:
        }
    }

    private void m15897d(C3859k c3859k) {
        switch (C3858j.f12995b[c3859k.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m15898a(240000);
                m15900a(C3860l.DETECT);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m15900a(C3860l.PENDING);
            case SpdyProtocol.QUIC /*4*/:
                m15898a(240000);
                m15900a(C3860l.DETECT);
            default:
        }
    }

    public void m15898a(long j) {
        this.f12990a = j;
    }

    public void m15899a(C3859k c3859k) {
        switch (C3858j.f12994a[this.f12991b.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m15895b(c3859k);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m15896c(c3859k);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m15897d(c3859k);
            default:
        }
    }

    public void m15900a(C3860l c3860l) {
        this.f12991b = c3860l;
        this.f12992c = 0;
    }

    public long m15901b() {
        long j = this.f12990a;
        if (C3754m.f12660d > 0) {
            j = (long) (C3754m.f12660d * AdError.NETWORK_ERROR_CODE);
        }
        NetworkInfo activeNetworkInfo = this.f12993d.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            j = C4156a.f13949k;
        } else if (!C3855g.f12976n) {
            j = C4156a.f13949k;
        } else if (!C3854f.m15859a().m15877g().m16062a()) {
            j = C4156a.f13949k;
        }
        C3688a.m15097b("HeartBeatIntervalGenerator|getHeartbeatInterval final interval = " + j);
        return j;
    }
}
