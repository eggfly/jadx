package anetwork.channel.p022b;

import anet.channel.util.StringUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import org.android.spdy.SpdyProtocol;

/* renamed from: anetwork.channel.b.a */
public class C0765a implements Serializable, Cloneable {
    @Deprecated
    public long f2477A;
    public long f2478B;
    @Deprecated
    public String f2479C;
    public int f2480D;
    public String f2481E;
    public String f2482a;
    public boolean f2483b;
    public int f2484c;
    public String f2485d;
    @Deprecated
    public String f2486e;
    public String f2487f;
    @Deprecated
    public boolean f2488g;
    public boolean f2489h;
    @Deprecated
    public int f2490i;
    @Deprecated
    public int f2491j;
    @Deprecated
    public long f2492k;
    @Deprecated
    public long f2493l;
    public long f2494m;
    @Deprecated
    public long f2495n;
    @Deprecated
    public long f2496o;
    public long f2497p;
    @Deprecated
    public long f2498q;
    public long f2499r;
    public long f2500s;
    public long f2501t;
    @Deprecated
    public long f2502u;
    public long f2503v;
    public long f2504w;
    @Deprecated
    public long f2505x;
    public long f2506y;
    public long f2507z;

    public C0765a() {
        this.f2482a = BuildConfig.FLAVOR;
        this.f2483b = false;
        this.f2484c = 0;
        this.f2485d = BuildConfig.FLAVOR;
        this.f2486e = BuildConfig.FLAVOR;
        this.f2487f = BuildConfig.FLAVOR;
        this.f2488g = false;
        this.f2489h = false;
        this.f2490i = 0;
        this.f2491j = 0;
        this.f2492k = 0;
        this.f2493l = 0;
        this.f2494m = 0;
        this.f2495n = 0;
        this.f2496o = 0;
        this.f2497p = 0;
        this.f2498q = 0;
        this.f2499r = 0;
        this.f2500s = 0;
        this.f2501t = 0;
        this.f2502u = 0;
        this.f2503v = 0;
        this.f2504w = 0;
        this.f2505x = 0;
        this.f2506y = 0;
        this.f2507z = 0;
        this.f2477A = 0;
        this.f2478B = 0;
        this.f2479C = BuildConfig.FLAVOR;
    }

    public String m3034a() {
        StringBuilder stringBuilder = new StringBuilder(SpdyProtocol.SLIGHTSSLV2);
        stringBuilder.append("isRequestSuccess=").append(this.f2483b);
        stringBuilder.append(",host=").append(this.f2485d);
        stringBuilder.append(",ip_port=").append(this.f2487f);
        stringBuilder.append(",isSSL=").append(this.f2489h);
        stringBuilder.append(",connType=").append(this.f2482a);
        stringBuilder.append(",oneWayTime_ANet=").append(this.f2494m);
        stringBuilder.append(",postBodyTime=").append(this.f2497p);
        stringBuilder.append(",firstDataTime=").append(this.f2500s);
        stringBuilder.append(",recDataTime=").append(this.f2501t);
        stringBuilder.append(",serverRT=").append(this.f2503v);
        stringBuilder.append(",rtt=").append(this.f2504w);
        stringBuilder.append(",sendSize=").append(this.f2506y);
        stringBuilder.append(",totalSize=").append(this.f2507z);
        stringBuilder.append(",dataSpeed=").append(this.f2478B);
        stringBuilder.append(",retryTime=").append(this.f2480D);
        return stringBuilder.toString();
    }

    public String toString() {
        if (StringUtils.isBlank(this.f2481E)) {
            this.f2481E = m3034a();
        }
        StringBuilder stringBuilder = new StringBuilder("StatisticData [");
        stringBuilder.append(this.f2481E);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
