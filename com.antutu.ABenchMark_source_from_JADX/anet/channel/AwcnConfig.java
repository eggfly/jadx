package anet.channel;

import android.text.TextUtils;
import anet.channel.AccsSessionManager.Callback;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeatFactory;
import anet.channel.security.C0683b;
import anet.channel.security.C0684c;
import anet.channel.strategy.C0734n;
import anet.channel.util.ALog;

public class AwcnConfig {
    public static final String TAG = "AwcnConfig";
    private static boolean isAccsSessionAutoRecreate;
    private static boolean isSSLEnabled;

    static {
        isAccsSessionAutoRecreate = true;
        isSSLEnabled = true;
    }

    public static boolean isAccsSessionAutoRecreate() {
        return isAccsSessionAutoRecreate;
    }

    public static boolean isSSLEnabled() {
        return isSSLEnabled;
    }

    public static void setAccsCenterHosts(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            ALog.m2962e(TAG, "setAccsCenterHost null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setAccsCenterHosts", "releaseHost", str, "prepareHost", str2, "dailyHost", str3);
        C0734n.f2415a = new String[]{str, str2, str3};
    }

    public static void setAccsCenterIps(String[] strArr, String[] strArr2, String[] strArr3) {
        if (strArr == null || strArr2 == null || strArr3 == null) {
            ALog.m2962e(TAG, "setAccsCenterIps null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setAccsCenterIps", null, "releaseIp", strArr, "prepareIp", strArr2, "dailyIp", strArr3);
        C0734n.f2416b = new String[][]{strArr, strArr2, strArr3};
    }

    public static void setAccsSessionAutoRecreate(boolean z) {
        isAccsSessionAutoRecreate = z;
    }

    public static void setAccsSessionCb(Callback callback) {
        AccsSessionManager.getInstance().setCallback(callback);
    }

    @Deprecated
    public static void setCallback(Callback callback) {
        AccsSessionManager.getInstance().setCallback(callback);
    }

    public static void setHeartbeatFactory(IHeartbeatFactory iHeartbeatFactory) {
        HeartbeatManager.setHeartbeatFactory(iHeartbeatFactory);
    }

    public static void setSSLEnabled(boolean z) {
        isSSLEnabled = z;
    }

    public static void setSecurityGuardOff(boolean z) {
        ALog.m2963i(TAG, "setSecurityGuardOff", null, "off", Boolean.valueOf(z));
        SessionCenter.SECURITYGUARD_OFF = z;
        if (z) {
            C0684c.m2819a(new C0683b());
        } else {
            C0684c.m2819a(null);
        }
    }

    @Deprecated
    public static void setSessionAutoRecreate(boolean z) {
        isAccsSessionAutoRecreate = z;
    }

    public static void setTnetPublicKey(int i) {
        ALog.m2963i(TAG, "setTnetPublicKey", null, "pubkey", Integer.valueOf(i));
        if (i > 0) {
            GlobalAppRuntimeInfo.tnetPubkey = i;
        }
    }

    public static void setUnitHost(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m2962e(TAG, "setUnitHost null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setUnitHost", null, "unitHost", str);
        C0734n.f2417c = str;
    }

    public static void setUnitIp(String[] strArr) {
        if (strArr == null) {
            ALog.m2962e(TAG, "setUnitIp null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setUnitIp", null, "ips", strArr);
        C0734n.f2418d = strArr;
    }

    public static void setUnszHost(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m2962e(TAG, "setUnszHost null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setUnszHost", null, "unszHost", str);
        C0734n.f2419e = str;
    }

    public static void setUnszIp(String[] strArr) {
        if (strArr == null) {
            ALog.m2962e(TAG, "setUnszIp null", null, new Object[0]);
            return;
        }
        ALog.m2963i(TAG, "setUnszIp", null, "setUnszIp", strArr);
        C0734n.f2420f = strArr;
    }
}
