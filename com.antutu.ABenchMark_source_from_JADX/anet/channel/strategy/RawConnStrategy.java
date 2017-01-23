package anet.channel.strategy;

import anet.channel.entity.C0667d;
import anet.channel.entity.C0668b;
import anet.channel.entity.C0670e;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.strategy.C0731k.C0728a;
import com.antutu.utils.HttpUtil;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Comparator;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

class RawConnStrategy implements Serializable, Comparable<RawConnStrategy> {
    static Comparator<RawConnStrategy> f2308a;
    private int f2309b;
    private long f2310c;
    public final ConnType connType;
    public final int cto;
    public final int heartbeat;
    public final boolean isAuth;
    public transient boolean isToRemove;
    public final int port;
    public final int retry;
    public final int rto;

    /* renamed from: anet.channel.strategy.RawConnStrategy.1 */
    static /* synthetic */ class C07071 {
        static final /* synthetic */ int[] f2307a;

        static {
            f2307a = new int[EventType.values().length];
            try {
                f2307a[EventType.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2307a[EventType.CONNECT_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2307a[EventType.AUTH_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2307a[EventType.AUTH_SUCC.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2307a[EventType.HORSE_RIDE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: anet.channel.strategy.RawConnStrategy.a */
    static class C0708a {
        C0708a() {
        }

        static RawConnStrategy m2868a() {
            return new RawConnStrategy(Constants.PORT, ConnType.H2_ACCS_0RTT, 0, 0, 1, HttpUtil.SOCKET_TIMEOUT, true);
        }

        static RawConnStrategy m2869a(int i, ConnType connType) {
            return new RawConnStrategy(i, connType, 0, 0, 1, HttpUtil.SOCKET_TIMEOUT, false);
        }

        static RawConnStrategy m2870a(C0728a c0728a) {
            ConnType valueOf = ConnType.valueOf(c0728a);
            return valueOf == null ? null : new RawConnStrategy(c0728a.f2379a, valueOf, c0728a.f2381c, c0728a.f2382d, c0728a.f2383e, c0728a.f2384f, c0728a.f2386h);
        }
    }

    static {
        f2308a = new C0722e();
    }

    protected RawConnStrategy(int i, ConnType connType, int i2, int i3, int i4, int i5, boolean z) {
        this.f2309b = 2;
        this.f2310c = 2147483647L;
        this.port = i;
        this.connType = connType;
        this.cto = i2;
        this.rto = i3;
        this.retry = i4;
        this.heartbeat = i5;
        this.isAuth = z;
    }

    private char m2871a() {
        switch (this.f2309b) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return 'A';
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return 'C';
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return 'N';
            default:
                return 'U';
        }
    }

    public int compareTo(RawConnStrategy rawConnStrategy) {
        return f2308a.compare(this, rawConnStrategy);
    }

    public boolean isAvailable() {
        return this.f2309b != 3;
    }

    public void notifyEvent(EventType eventType, C0667d c0667d) {
        switch (C07071.f2307a[eventType.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f2309b = 1;
                if (c0667d instanceof C0668b) {
                    this.f2310c = ((C0668b) c0667d).f2220a;
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.f2309b = 3;
            case SpdyProtocol.QUIC /*4*/:
                this.f2309b = 0;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                if (c0667d instanceof C0670e) {
                    C0670e c0670e = (C0670e) c0667d;
                    if (c0670e.f2223a) {
                        this.f2309b = 0;
                        this.f2310c = c0670e.f2224b;
                        return;
                    }
                    this.f2309b = 3;
                }
            default:
        }
    }

    public void resetConnStatus() {
        if (this.f2309b == 3) {
            this.f2309b = 2;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('{').append(this.port).append(' ').append(this.connType).append(' ').append(m2871a()).append('}');
        return stringBuilder.toString();
    }
}
