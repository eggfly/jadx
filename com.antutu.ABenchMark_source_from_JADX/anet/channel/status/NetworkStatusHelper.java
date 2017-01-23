package anet.channel.status;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Pair;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.p019c.C0660c;
import anet.channel.util.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.concurrent.CopyOnWriteArraySet;
import org.android.spdy.SpdyProtocol;

public class NetworkStatusHelper {
    private static CopyOnWriteArraySet<INetworkStatusChangeListener> f2290a;

    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI;

        public String getType() {
            return this == G2 ? "2G" : this == G3 ? "3G" : this == G4 ? "4G" : toString();
        }

        public boolean isMobile() {
            return this == G2 || this == G3 || this == G4;
        }

        public boolean isWifi() {
            return this == WIFI;
        }
    }

    static {
        f2290a = new CopyOnWriteArraySet();
    }

    public static NetworkStatus m2839a() {
        return C0701b.f2293b;
    }

    public static synchronized void m2840a(Context context) {
        synchronized (NetworkStatusHelper.class) {
            C0701b.f2292a = context;
            C0701b.m2854a();
        }
    }

    public static void m2841a(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        f2290a.add(iNetworkStatusChangeListener);
    }

    static void m2842a(NetworkStatus networkStatus) {
        C0660c.m2783a(new C0700a(networkStatus));
    }

    public static String m2843b() {
        return C0701b.f2294c;
    }

    public static String m2844c() {
        return C0701b.f2295d;
    }

    public static String m2845d() {
        return C0701b.f2297f;
    }

    public static boolean m2846e() {
        if (C0701b.f2293b != NetworkStatus.NO) {
            return true;
        }
        NetworkInfo b = C0701b.m2856b();
        return b != null && b.isConnected();
    }

    public static boolean m2847f() {
        NetworkStatus networkStatus = C0701b.f2293b;
        return (networkStatus == NetworkStatus.WIFI && C0701b.f2298g != null) || (networkStatus.isMobile() && (C0701b.f2295d.contains("wap") || GlobalAppRuntimeInfo.getProxySetting() != null));
    }

    public static String m2848g() {
        NetworkStatus networkStatus = C0701b.f2293b;
        return (networkStatus != NetworkStatus.WIFI || C0701b.f2298g == null) ? (networkStatus.isMobile() && C0701b.f2295d.contains("wap")) ? "wap" : (!networkStatus.isMobile() || GlobalAppRuntimeInfo.getProxySetting() == null) ? BuildConfig.FLAVOR : BaseMonitor.ALARM_POINT_AUTH : "proxy";
    }

    public static Pair<String, Integer> m2849h() {
        return C0701b.f2298g;
    }

    public static void m2850i() {
        try {
            NetworkStatus networkStatus = C0701b.f2293b;
            StringBuilder stringBuilder = new StringBuilder(SpdyProtocol.SLIGHTSSLV2);
            stringBuilder.append("\n\nNetwork detail***********************\n");
            stringBuilder.append("status: ").append(networkStatus.getType()).append('\n');
            if (networkStatus.isMobile()) {
                stringBuilder.append(" apn: ").append(C0701b.f2295d).append('\n');
            } else {
                stringBuilder.append(" BSSID: ").append(C0701b.f2297f).append('\n');
                stringBuilder.append(" SSID: ").append(C0701b.f2296e).append('\n');
            }
            if (m2847f()) {
                stringBuilder.append(" proxy: ").append(m2848g()).append('\n');
                Pair pair = C0701b.f2298g;
                if (pair != null) {
                    stringBuilder.append(" proxyHost: ").append((String) pair.first).append('\n');
                    stringBuilder.append(" proxyPort: ").append(pair.second).append('\n');
                }
            }
            stringBuilder.append("******************************************");
            ALog.m2963i("awcn.NetworkStatusHelper", stringBuilder.toString(), null, new Object[0]);
        } catch (Exception e) {
        }
    }
}
