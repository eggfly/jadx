package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;
import com.antutu.utils.HttpUtil;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/* renamed from: anet.channel.entity.a */
public class C0666a {
    public final IConnStrategy f2212a;
    public int f2213b;
    public int f2214c;
    private String f2215d;
    private String f2216e;

    public C0666a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f2213b = 0;
        this.f2214c = 0;
        this.f2212a = iConnStrategy;
        this.f2215d = str;
        this.f2216e = str2;
    }

    public String m2797a() {
        return this.f2212a != null ? this.f2212a.getIp() : null;
    }

    public int m2798b() {
        return this.f2212a != null ? this.f2212a.getPort() : 0;
    }

    public ConnType m2799c() {
        return this.f2212a != null ? this.f2212a.getConnType() : ConnType.HTTP;
    }

    public int m2800d() {
        return (this.f2212a == null || this.f2212a.getConnectionTimeout() == 0) ? BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT : this.f2212a.getConnectionTimeout();
    }

    public int m2801e() {
        return (this.f2212a == null || this.f2212a.getReadTimeout() == 0) ? BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT : this.f2212a.getReadTimeout();
    }

    public boolean m2802f() {
        return this.f2212a != null ? this.f2212a.isNeedAuth() : false;
    }

    public String m2803g() {
        return this.f2215d;
    }

    public int m2804h() {
        return this.f2212a != null ? this.f2212a.getHeartbeat() : HttpUtil.SOCKET_TIMEOUT;
    }

    public String m2805i() {
        return this.f2216e;
    }

    public String toString() {
        return "ConnInfo [ip=" + m2797a() + ",port=" + m2798b() + ",type=" + m2799c() + ",hb" + m2804h() + "]";
    }
}
