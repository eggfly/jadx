package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;
import com.antutu.utils.HttpUtil;
import com.handmark.pulltorefresh.library.C3628R;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.utl.UtilityImpl;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

/* renamed from: anet.channel.status.b */
class C0701b {
    static Context f2292a;
    static volatile NetworkStatus f2293b;
    static volatile String f2294c;
    static volatile String f2295d;
    static volatile String f2296e;
    static volatile String f2297f;
    static volatile Pair<String, Integer> f2298g;
    private static volatile boolean f2299h;
    private static ConnectivityManager f2300i;
    private static WifiManager f2301j;
    private static BroadcastReceiver f2302k;

    static {
        f2292a = null;
        f2293b = NetworkStatus.NONE;
        f2294c = UtilityImpl.NET_TYPE_UNKNOWN;
        f2295d = UtilityImpl.NET_TYPE_UNKNOWN;
        f2296e = BuildConfig.FLAVOR;
        f2297f = BuildConfig.FLAVOR;
        f2298g = null;
        f2299h = false;
        f2300i = null;
        f2301j = null;
        f2302k = new NetworkStatusMonitor$1();
    }

    C0701b() {
    }

    private static NetworkStatus m2852a(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return NetworkStatus.G2;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return NetworkStatus.G3;
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return NetworkStatus.G4;
            default:
                return NetworkStatus.NONE;
        }
    }

    private static String m2853a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UtilityImpl.NET_TYPE_UNKNOWN;
        }
        String toLowerCase = str.toLowerCase(Locale.US);
        return toLowerCase.contains(HttpUtil.APN_CMWAP) ? HttpUtil.APN_CMWAP : toLowerCase.contains(HttpUtil.APN_UNIWAP) ? HttpUtil.APN_UNIWAP : toLowerCase.contains(HttpUtil.APN_3GWAP) ? HttpUtil.APN_3GWAP : toLowerCase.contains(HttpUtil.APN_CTWAP) ? HttpUtil.APN_CTWAP : toLowerCase.contains("cmnet") ? "cmnet" : toLowerCase.contains("uninet") ? "uninet" : toLowerCase.contains("3gnet") ? "3gnet" : toLowerCase.contains("ctnet") ? "ctnet" : UtilityImpl.NET_TYPE_UNKNOWN;
    }

    static void m2854a() {
        if (!f2299h && f2292a != null) {
            synchronized (f2292a) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                try {
                    f2292a.registerReceiver(f2302k, intentFilter);
                } catch (Exception e) {
                    ALog.m2962e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
                }
            }
            C0701b.m2857b(f2292a);
        }
    }

    static NetworkInfo m2856b() {
        try {
            if (f2300i == null) {
                f2300i = (ConnectivityManager) f2292a.getSystemService("connectivity");
            }
            return f2300i.getActiveNetworkInfo();
        } catch (Throwable th) {
            ALog.m2961e("awcn.NetworkStatusMonitor", "getNetworkInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static void m2857b(Context context) {
        ALog.m2960d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatus networkStatus = f2293b;
        String str = f2295d;
        if (context != null) {
            try {
                NetworkInfo b = C0701b.m2856b();
                if (b == null || !b.isConnected()) {
                    f2293b = NetworkStatus.NO;
                    f2294c = UtilityImpl.NET_TYPE_UNKNOWN;
                    ALog.m2963i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "NO NETWORK");
                } else {
                    ALog.m2963i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(b.isConnected()), "info.isAvailable", Boolean.valueOf(b.isAvailable()));
                    if (b.getType() == 0) {
                        f2293b = C0701b.m2852a(b.getSubtype());
                        f2294c = b.getSubtypeName();
                        if (!TextUtils.isEmpty(f2294c)) {
                            f2294c = f2294c.replace(" ", BuildConfig.FLAVOR);
                        }
                        f2295d = C0701b.m2853a(b.getExtraInfo());
                    } else if (b.getType() == 1) {
                        f2293b = NetworkStatus.WIFI;
                        f2294c = UtilityImpl.NET_TYPE_WIFI;
                        WifiInfo c = C0701b.m2858c();
                        if (c != null) {
                            f2297f = c.getBSSID();
                            f2296e = c.getSSID();
                        }
                        f2298g = C0701b.m2859d();
                    }
                }
                if (f2293b != networkStatus || (f2295d != null && !f2295d.equalsIgnoreCase(str))) {
                    if (ALog.isPrintLog(2)) {
                        ALog.m2963i("awcn.NetworkStatusMonitor", "Network Status Change", null, networkStatus + " ===>>> " + f2293b);
                    }
                    NetworkStatusHelper.m2842a(f2293b);
                }
            } catch (Throwable e) {
                ALog.m2961e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e, new Object[0]);
            }
        }
    }

    private static WifiInfo m2858c() {
        try {
            if (f2301j == null) {
                f2301j = (WifiManager) f2292a.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            }
            return f2301j.getConnectionInfo();
        } catch (Throwable th) {
            ALog.m2961e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> m2859d() {
        try {
            CharSequence property = System.getProperty("http.proxyHost");
            if (!TextUtils.isEmpty(property)) {
                return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
            }
        } catch (NumberFormatException e) {
        }
        return null;
    }
}
