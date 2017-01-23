package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;
import anet.channel.util.HttpConstant;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.handmark.pulltorefresh.library.C3628R;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.SECURITY_TYPE;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog.Level;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.android.agoo.common.C4575b;
import org.android.spdy.SpdyProtocol;

public class UtilityImpl {
    public static String BACK_APP_KEY = null;
    public static String BACK_TTID = null;
    private static String DEVICETOKEN = null;
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    private static final String SSL_TIKET_KEY = "accs_ssl_ticket_key";
    private static final String TAG = "UtilityImpl";
    public static final int TNET_FILE_NUM = 5;
    public static final int TNET_FILE_SIZE = 5242880;

    static {
        BACK_APP_KEY = BuildConfig.FLAVOR;
        BACK_TTID = BuildConfig.FLAVOR;
        DEVICETOKEN = BuildConfig.FLAVOR;
    }

    public static int String2Int(String str) {
        int i = 0;
        try {
            i = Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            ALog.m16902e(TAG, "String2Int", e, new Object[i]);
        }
        return i;
    }

    public static long String2Time(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).parse(str).getTime();
        } catch (Throwable th) {
            return 0;
        }
    }

    public static boolean appVersionChanged(Context context) {
        int i;
        int i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.KEY_APP_VERSION_CODE, -1);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            i = 0;
        }
        if (i2 == i) {
            return false;
        }
        saveAppVersionCode(context);
        return true;
    }

    public static boolean channelServiceExist(Context context, String str) {
        boolean z = false;
        try {
            z = context.getPackageManager().getServiceInfo(new ComponentName(str, C4135a.channelService), 0).isEnabled();
        } catch (Exception e) {
        }
        return z;
    }

    public static void clearCookie(Context context) {
        try {
            GlobalClientInfo.f13606a = null;
            Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable th) {
            ALog.m16902e(TAG, "clearCookie fail", th, new Object[0]);
        }
    }

    public static void clearSharePreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
        Object string = sharedPreferences.getString(C4209a.f14204g, BACK_APP_KEY);
        Object string2 = sharedPreferences.getString(Constants.SP_APP_SECRET, BuildConfig.FLAVOR);
        Object string3 = sharedPreferences.getString(C4575b.PROPERTY_TT_ID, BuildConfig.FLAVOR);
        Object string4 = sharedPreferences.getString(Constants.KEY_PROXY_HOST, null);
        int i = sharedPreferences.getInt(Constants.KEY_PROXY_PORT, -1);
        int i2 = sharedPreferences.getInt(Constants.SP_KEY_VERSION, -1);
        int i3 = sharedPreferences.getInt(Constants.SP_KEY_DEBUG_MODE, 0);
        Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.clear();
        if (!TextUtils.isEmpty(string)) {
            edit.putString(C4209a.f14204g, string);
        }
        if (!TextUtils.isEmpty(string2)) {
            edit.putString(Constants.SP_APP_SECRET, string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            edit.putString(C4575b.PROPERTY_TT_ID, string3);
        }
        if (!TextUtils.isEmpty(string4)) {
            edit.putString(Constants.KEY_PROXY_HOST, string4);
        }
        if (i > 0) {
            edit.putInt(Constants.KEY_PROXY_PORT, i);
        }
        if (i2 > 0) {
            edit.putInt(Constants.SP_KEY_VERSION, i2);
        }
        if (i3 == 2 || i3 == 1) {
            edit.putInt(Constants.SP_KEY_DEBUG_MODE, i3);
        }
        edit.commit();
    }

    public static String convertHost(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("//")) {
                return "https:" + str;
            }
            int indexOf = str.indexOf(HttpConstant.SCHEME_SPLIT);
            if (indexOf == -1) {
                return "https://" + str;
            }
            Object substring = str.substring(indexOf + 3);
            return !TextUtils.isEmpty(substring) ? "https://" + substring : null;
        } catch (Throwable th) {
            ALog.m16902e(TAG, "convertHost", th, new Object[0]);
            return null;
        }
    }

    public static void disableService(Context context) {
        ComponentName componentName = new ComponentName(context, C4135a.channelService);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.m16901d(TAG, "disableService,comptName=" + componentName.toString(), new Object[0]);
            if (packageManager.getServiceInfo(componentName, SpdyProtocol.SLIGHTSSLV2).enabled) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                killService(context);
            }
        } catch (NameNotFoundException e) {
        }
    }

    public static void enableService(Context context) {
        ComponentName componentName = new ComponentName(context, C4135a.channelService);
        ALog.m16901d(TAG, "enableService,comptName=" + componentName.toString(), new Object[0]);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Exception e) {
        }
    }

    public static void focusDisableService(Context context) {
        Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putBoolean(Constants.KEY_FOUCE_DISABLE, true);
        edit.commit();
        disableService(context);
    }

    public static void focusEnableService(Context context) {
        Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putBoolean(Constants.KEY_FOUCE_DISABLE, false);
        edit.commit();
        enableService(context);
    }

    public static String formatDay(long j) {
        String str = BuildConfig.FLAVOR;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j));
        } catch (Throwable th) {
            ALog.m16902e(TAG, "formatDay", th, new Object[0]);
        }
        return str;
    }

    public static String formatTime(long j) {
        String str = BuildConfig.FLAVOR;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date(j));
        } catch (Throwable th) {
            ALog.m16902e(TAG, "formatTime", th, new Object[0]);
        }
        return str;
    }

    public static boolean getAgooServiceEnabled(Context context) {
        ComponentName componentName = new ComponentName(context, C4085a.m16663b(context.getPackageName()));
        PackageManager packageManager = context.getPackageManager();
        try {
            if (!componentName.getPackageName().equals("!")) {
                return packageManager.getServiceInfo(componentName, SpdyProtocol.SLIGHTSSLV2).enabled;
            } else {
                ALog.m16903e(TAG, "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String getAppSecret(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            str = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.SP_APP_SECRET, BuildConfig.FLAVOR);
        } catch (Throwable th) {
        }
        return str;
    }

    public static String getAppVersion(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getAppkey(Context context) {
        Object d = C4135a.m16914d(context);
        return TextUtils.isEmpty(d) ? BACK_APP_KEY : d;
    }

    public static String getAppsign(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            ALog.m16903e(TAG, "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (AccsConfig.mSecurityType != SECURITY_TYPE.SECURITY_OFF) {
                SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
                if (instance != null) {
                    ALog.m16901d(TAG, "SecurityGuardManager not null!", new Object[0]);
                    ISecureSignatureComponent secureSignatureComp = instance.getSecureSignatureComp();
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str;
                    securityGuardParamContext.paramMap.put("INPUT", str2 + str);
                    securityGuardParamContext.requestType = 3;
                    return secureSignatureComp.signRequest(securityGuardParamContext, C4085a.f13622c);
                }
                ALog.m16901d(TAG, "SecurityGuardManager is null", new Object[0]);
                return null;
            } else if (!TextUtils.isEmpty(GlobalClientInfo.getInstance(context).getAppSecret())) {
                return HMacUtil.hmacSha1Hex(GlobalClientInfo.getInstance(context).getAppSecret().getBytes(), (str + str2).getBytes());
            } else {
                ALog.m16903e(TAG, "getAppsign secret null", new Object[0]);
                return null;
            }
        } catch (Throwable th) {
            ALog.m16902e(TAG, "getAppsign", th, new Object[0]);
            return null;
        }
    }

    public static int getByteLen(String str) {
        int i = 0;
        if (str != null) {
            try {
                i = str.getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static File getCacheFilesDir(Context context) {
        return context.getExternalCacheDir();
    }

    public static String getDeviceId(Context context) {
        return C4135a.m16912b(context);
    }

    public static String getDeviceToken(Context context) {
        String str = DEVICETOKEN;
        try {
            str = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.KEY_DEVICE_TOKEN, DEVICETOKEN);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.m16904i(TAG, "getDeviceToken", com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, str);
        return str;
    }

    public static File getExternalFilesDir(Context context) {
        return context.getExternalFilesDir(null);
    }

    public static boolean getFocusDisableStatus(Context context) {
        boolean z = false;
        if (context != null) {
            try {
                z = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.KEY_FOUCE_DISABLE, false);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            return null;
        }
    }

    public static int getMode(Context context) {
        int i = 0;
        try {
            i = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "getMode", th, new Object[i]);
        }
        return i;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NET_TYPE_UNKNOWN;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NET_TYPE_WIFI;
        }
        Object subtypeName = activeNetworkInfo.getSubtypeName();
        return !TextUtils.isEmpty(subtypeName) ? subtypeName.replaceAll(" ", BuildConfig.FLAVOR) : BuildConfig.FLAVOR;
    }

    public static String getNetworkTypeExt(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return NET_TYPE_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                return NET_TYPE_WIFI;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                case SpdyProtocol.QUIC /*4*/:
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    return NET_TYPE_2G;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                case TNET_FILE_NUM /*5*/:
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    return NET_TYPE_3G;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    return NET_TYPE_4G;
                default:
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    return TextUtils.isEmpty(subtypeName) ? NET_TYPE_UNKNOWN : (subtypeName.equalsIgnoreCase("td-scdma") || subtypeName.equalsIgnoreCase("td_scdma") || subtypeName.equalsIgnoreCase("tds_hsdpa")) ? NET_TYPE_3G : NET_TYPE_UNKNOWN;
            }
            ALog.m16902e(TAG, "getNetworkTypeExt", e, new Object[0]);
            return null;
        } catch (Throwable e) {
            ALog.m16902e(TAG, "getNetworkTypeExt", e, new Object[0]);
            return null;
        }
    }

    public static String getProcessName(Context context, int i) {
        return C4135a.m16908a(context, i);
    }

    public static String getProxy() {
        String str = getProxyIp() + ":" + getProxyPort();
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d(TAG, "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    public static String getProxyHost(Context context) {
        Object string = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        string = getProxyIp();
        return TextUtils.isEmpty(string) ? null : string;
    }

    public static String getProxyIp() {
        return VERSION.SDK_INT < 11 ? Proxy.getDefaultHost() : System.getProperty("http.proxyHost");
    }

    public static int getProxyPort() {
        if (VERSION.SDK_INT < 11) {
            return Proxy.getDefaultPort();
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int getProxyPort(Context context) {
        int i = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i > 0) {
            return i;
        }
        if (getProxyHost(context) == null) {
            return -1;
        }
        try {
            return getProxyPort();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long getServiceAliveTime(Context context) {
        long j;
        Throwable th;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            j = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0);
            j = j > 0 ? sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0) - j : 0;
            try {
                Editor edit = sharedPreferences.edit();
                edit.putLong(Constants.SP_KEY_SERVICE_START, 0);
                edit.putLong(Constants.SP_KEY_SERVICE_END, 0);
                edit.commit();
            } catch (Throwable th2) {
                th = th2;
                ALog.m16902e(TAG, "getServiceAliveTime:", th, new Object[0]);
                return j;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            j = 0;
            th = th4;
            ALog.m16902e(TAG, "getServiceAliveTime:", th, new Object[0]);
            return j;
        }
        return j;
    }

    public static boolean getServiceEnabled(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, C4135a.channelService), SpdyProtocol.SLIGHTSSLV2).enabled;
        } catch (Throwable e) {
            e.printStackTrace();
            ALog.m16903e(TAG, getStackMsg(e), new Object[0]);
            return false;
        }
    }

    public static String getStackMsg(Throwable th) {
        return C4135a.m16909a(th);
    }

    public static String getTnetLogFilePath(Context context, String str) {
        String str2 = null;
        try {
            Object externalFilesDir = context.getExternalFilesDir("tnetlogs");
            if (!(externalFilesDir != null && externalFilesDir.exists() && externalFilesDir.canWrite())) {
                externalFilesDir = context.getDir("logs", 0);
            }
            ALog.m16901d(TAG, "getTnetLogFilePath :" + externalFilesDir, new Object[0]);
            str2 = externalFilesDir + "/" + str.toLowerCase();
        } catch (Throwable th) {
            ALog.m16902e(TAG, "getTnetLogFilePath", th, new Object[0]);
        }
        return str2;
    }

    public static String getTtId(Context context) {
        String str = BACK_TTID;
        try {
            str = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(C4575b.PROPERTY_TT_ID, BuildConfig.FLAVOR);
        } catch (Throwable th) {
        }
        return str;
    }

    public static long getUsableSpace() {
        return C4135a.m16907a();
    }

    public static String int2String(int i) {
        String str = null;
        try {
            str = String.valueOf(i);
        } catch (Throwable e) {
            ALog.m16902e(TAG, "int2String", e, new Object[0]);
        }
        return str;
    }

    public static boolean isAccsStatisticsOff(Context context) {
        return true;
    }

    public static boolean isChannelProcess(Context context) {
        return false;
    }

    public static boolean isDebugMode(Context context) {
        return getMode(context) == 2;
    }

    public static boolean isFirstStart(Context context) {
        return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_VERSION, -1) != Constants.SDK_VERSION_CODE;
    }

    public static boolean isForeground(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object packageName = ((RunningTaskInfo) GlobalClientInfo.getInstance(context).getActivityManager().getRunningTasks(1).get(0)).topActivity.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.equals(context.getPackageName())) {
                return true;
            }
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d(TAG, "isForeground time " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            }
            return false;
        } catch (Throwable th) {
            ALog.m16902e(TAG, "isForeground error ", th, new Object[0]);
        }
    }

    public static boolean isMainProcess(Context context) {
        return C4135a.m16910a(context);
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean isPreviewMode(Context context) {
        return getMode(context) == 1;
    }

    public static boolean isReleaseMode(Context context) {
        return getMode(context) == 0;
    }

    public static boolean isServiceRunning(Context context, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(30)) {
            if (runningServiceInfo.service.getPackageName().equals(str) && runningServiceInfo.service.getClassName().equals(C4135a.channelService)) {
                return true;
            }
        }
        return false;
    }

    public static void killService(Context context) {
        int myUid = Process.myUid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.uid == myUid) {
                    if (!TextUtils.isEmpty(C4085a.f13624e) && C4085a.f13624e.equals(runningAppProcessInfo.processName)) {
                        ALog.m16903e(TAG, "kill1 " + runningAppProcessInfo.processName, new Object[0]);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    } else if (runningAppProcessInfo.processName.endsWith(":channel")) {
                        ALog.m16903e(TAG, "kill " + runningAppProcessInfo.processName, new Object[0]);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    }
                }
            }
            ALog.m16903e(TAG, "kill nothing", new Object[0]);
        }
    }

    public static boolean packageExist(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            ALog.m16903e(TAG, "package not exist", Constants.KEY_ELECTION_PKG, str);
            return false;
        }
    }

    public static int praseInt(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static String restoreCookie(Context context) {
        String str = null;
        try {
            str = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Throwable e) {
            ALog.m16902e(TAG, "reStoreCookie fail", e, new Object[0]);
        }
        return str;
    }

    public static void saveAppVersionCode(Context context) {
        try {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            edit.apply();
        } catch (NameNotFoundException e) {
        }
    }

    public static void saveAppkey(Context context, String str) {
        BACK_APP_KEY = str;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            if (!sharedPreferences.getString(C4209a.f14204g, BuildConfig.FLAVOR).equals(str)) {
                Editor edit = sharedPreferences.edit();
                if (!TextUtils.isEmpty(str)) {
                    edit.putString(C4209a.f14204g, str);
                }
                edit.commit();
                ALog.m16901d(TAG, "saveAppkey APPKEY:" + str, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUtdid(Context context) {
        try {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putString(MsgConstant.KEY_UTDID, getDeviceId(context));
            edit.apply();
        } catch (Throwable th) {
            ALog.m16902e(TAG, "saveUtdid", th, new Object[0]);
        }
    }

    public static void setAppInfo(Context context, String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                BACK_APP_KEY = str;
            }
            if (!TextUtils.isEmpty(str3)) {
                BACK_TTID = str3;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(C4209a.f14204g, BuildConfig.FLAVOR);
            String string2 = sharedPreferences.getString(C4575b.PROPERTY_TT_ID, BuildConfig.FLAVOR);
            if (!string.equals(str) || !string2.equals(str3)) {
                Editor edit = sharedPreferences.edit();
                if (!TextUtils.isEmpty(str)) {
                    edit.putString(C4209a.f14204g, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    edit.putString(Constants.SP_APP_SECRET, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    edit.putString(C4575b.PROPERTY_TT_ID, str3);
                }
                edit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDeviceToken(Context context, String str) {
        ALog.m16904i(TAG, "setDeviceToken", com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, str);
        if (!TextUtils.isEmpty(str)) {
            DEVICETOKEN = str;
            try {
                Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putString(Constants.KEY_DEVICE_TOKEN, str);
                edit.apply();
            } catch (Throwable th) {
                ALog.m16902e(TAG, "setDeviceToken", th, new Object[0]);
            }
        }
    }

    public static void setMode(Context context, int i) {
        Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putInt(Constants.SP_KEY_DEBUG_MODE, i);
        edit.commit();
        ALog.m16901d(TAG, "setMode:" + i, new Object[0]);
    }

    public static void setSdkStart(Context context) {
        try {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.SP_KEY_VERSION, Constants.SDK_VERSION_CODE);
            edit.apply();
            ALog.m16904i(TAG, "setSdkStart isFirstStart:" + isFirstStart(context), new Object[0]);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "setSdkStart", th, new Object[0]);
        }
    }

    public static void setServiceTime(Context context, String str, long j) {
        try {
            Editor edit = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            edit.putLong(str, j);
            edit.commit();
            ALog.m16901d(TAG, "setServiceTime:" + j, new Object[0]);
        } catch (Throwable th) {
            ALog.m16902e(TAG, "setServiceTime:", th, new Object[0]);
        }
    }

    public static void storeCookie(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                GlobalClientInfo.f13606a = str;
                Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
                edit.putString(Constants.SP_KEY_COOKIE_SEC, str);
                edit.apply();
            }
        } catch (Throwable e) {
            ALog.m16902e(TAG, "storeCookie fail", e, new Object[0]);
        }
    }

    public static boolean utdidChanged() {
        return false;
    }
}
