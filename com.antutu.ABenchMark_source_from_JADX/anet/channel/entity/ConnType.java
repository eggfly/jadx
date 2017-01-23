package anet.channel.entity;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.strategy.C0731k.C0728a;
import anet.channel.util.HttpConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

public class ConnType implements Serializable {
    public static ConnType ACCS_0RTT = null;
    public static ConnType ACCS_1RTT = null;
    public static final String ACS = "acs";
    public static final String CDN = "cdn";
    public static ConnType H2_ACCS_0RTT = null;
    public static ConnType H2_ACCS_1RTT = null;
    public static ConnType HTTP = null;
    public static final String HTTP2 = "http2";
    public static ConnType HTTPS = null;
    public static final String RTT_0 = "0rtt";
    public static final String RTT_1 = "1rtt";
    public static ConnType SPDY = null;
    public static final String SPDY_STR = "spdy";
    private static Map<String, ConnType> connTypeMap = null;
    private static final long serialVersionUID = 4362386279661117076L;
    private String name;
    private String publicKey;
    private int spdyProtocol;

    public enum TypeLevel {
        SPDY,
        HTTP
    }

    static {
        HTTP = new ConnType(HttpConstant.HTTP);
        HTTPS = new ConnType(HttpConstant.HTTPS);
        ACCS_0RTT = new ConnType("spdy_0rtt_acs", SpdyProtocol.SSSL_0RTT_SPDY, ACS);
        ACCS_1RTT = new ConnType("spdy_1rtt_acs", SpdyProtocol.SSSL_1RTT_SPDY, ACS);
        H2_ACCS_0RTT = new ConnType("http2_0rtt_acs", SpdyProtocol.SSSL_0RTT_HTTP2, ACS);
        H2_ACCS_1RTT = new ConnType("http2_1rtt_acs", SpdyProtocol.SSSL_1RTT_HTTP2, ACS);
        SPDY = new ConnType(SPDY_STR, 2, null);
        connTypeMap = new HashMap();
        connTypeMap.put("spdy_0rtt_acs", ACCS_0RTT);
        connTypeMap.put("spdy_1rtt_acs", ACCS_1RTT);
        connTypeMap.put("http2_0rtt_acs", H2_ACCS_0RTT);
        connTypeMap.put("http2_1rtt_acs", H2_ACCS_1RTT);
        connTypeMap.put(SPDY_STR, SPDY);
    }

    private ConnType(String str) {
        this.name = BuildConfig.FLAVOR;
        this.name = str;
    }

    private ConnType(String str, int i, String str2) {
        this.name = BuildConfig.FLAVOR;
        this.spdyProtocol = i;
        this.publicKey = str2;
        this.name = str;
    }

    private static String buildKey(C0728a c0728a) {
        if (TextUtils.isEmpty(c0728a.f2388j)) {
            return c0728a.f2380b;
        }
        StringBuilder stringBuilder = new StringBuilder(18);
        stringBuilder.append(c0728a.f2380b);
        if (TextUtils.isEmpty(c0728a.f2385g)) {
            stringBuilder.append("_0rtt");
        } else {
            stringBuilder.append("_").append(c0728a.f2385g);
        }
        stringBuilder.append("_");
        stringBuilder.append(c0728a.f2388j);
        if (c0728a.f2387i) {
            stringBuilder.append("_l7");
        }
        return stringBuilder.toString();
    }

    public static int compare(ConnType connType, ConnType connType2) {
        return connType.getPriority() - connType2.getPriority();
    }

    private int getPriority() {
        return isHttpType() ? 1 : (this.spdyProtocol & 8) == 0 ? 0 : -1;
    }

    public static ConnType valueOf(C0728a c0728a) {
        if (TextUtils.isEmpty(c0728a.f2380b) || HttpConstant.HTTP.equals(c0728a.f2380b)) {
            return HTTP;
        }
        if (HttpConstant.HTTPS.equals(c0728a.f2380b)) {
            return HTTPS;
        }
        String buildKey = buildKey(c0728a);
        synchronized (connTypeMap) {
            if (connTypeMap.containsKey(buildKey)) {
                ConnType connType = (ConnType) connTypeMap.get(buildKey);
                return connType;
            }
            connType = new ConnType(buildKey);
            connType.publicKey = c0728a.f2388j;
            if (HTTP2.equals(c0728a.f2380b)) {
                connType.spdyProtocol |= 8;
            } else if (SPDY_STR.equals(c0728a.f2380b)) {
                connType.spdyProtocol |= 2;
            }
            if (connType.spdyProtocol == 0) {
                return null;
            }
            if (!TextUtils.isEmpty(c0728a.f2388j)) {
                connType.spdyProtocol |= SpdyProtocol.SLIGHTSSLV2;
                if (RTT_1.equals(c0728a.f2385g)) {
                    connType.spdyProtocol |= SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
                } else {
                    connType.spdyProtocol |= SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
                }
                if (c0728a.f2387i) {
                    connType.spdyProtocol |= SpdyProtocol.SLIGHTSSL_L7E;
                }
            }
            connTypeMap.put(buildKey, connType);
            return connType;
        }
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof ConnType)) ? false : this == obj || this.name.equals(((ConnType) obj).name);
    }

    public int getTnetConType() {
        return this.spdyProtocol;
    }

    public int getTnetPublicKey() {
        boolean z = SessionCenter.SECURITYGUARD_OFF;
        return GlobalAppRuntimeInfo.getEnv() == ENV.TEST ? CDN.equals(this.publicKey) ? z ? 1 : 1 : z ? 0 : 0 : CDN.equals(this.publicKey) ? z ? 1 : 1 : GlobalAppRuntimeInfo.tnetPubkey > 0 ? GlobalAppRuntimeInfo.tnetPubkey : z ? 4 : 3;
    }

    public TypeLevel getTypeLevel() {
        return isHttpType() ? TypeLevel.HTTP : TypeLevel.SPDY;
    }

    public boolean isCdn() {
        return CDN.equals(this.publicKey);
    }

    public boolean isHttpType() {
        return equals(HTTP) || equals(HTTPS);
    }

    public boolean isSSL() {
        return equals(HTTPS) || (this.spdyProtocol & SpdyProtocol.SLIGHTSSLV2) != 0;
    }

    public String toProtocol() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
