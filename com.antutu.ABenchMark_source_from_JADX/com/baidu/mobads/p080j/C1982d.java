package com.baidu.mobads.p080j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.security.ISecurity;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p094i.C1977a;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.j.d */
public class C1982d implements IXAdCommonUtils {
    private static String f6916a;
    private static String f6917b;
    private static String f6918c;
    private static String f6919d;
    private final String f6920e;
    private final AtomicLong f6921f;
    private Method f6922g;
    private String f6923h;
    private HashMap<String, Object> f6924i;

    public C1982d() {
        this.f6920e = "_cpr";
        this.f6921f = new AtomicLong(1);
        this.f6922g = null;
        this.f6923h = null;
        this.f6924i = new HashMap();
    }

    private String m7412a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String file = context.getFilesDir().toString();
            stringBuilder.append(file.toString().substring(0, file.toString().lastIndexOf(File.separator)));
        } catch (Exception e) {
        }
        stringBuilder.append(File.separator);
        stringBuilder.append("bddownload");
        return stringBuilder.toString();
    }

    private String m7413a(Context context, String str) {
        String str2 = C4233j.f14375B;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2).metaData.get(str) + BuildConfig.FLAVOR;
            if (str2.trim().equals(BuildConfig.FLAVOR)) {
                throw new Exception();
            }
        } catch (Exception e) {
            String.format("Could not read %s meta-data from AndroidManifest.xml", new Object[]{str});
        }
        return str2;
    }

    @TargetApi(4)
    private void m7414a(Context context, Intent intent) {
        try {
            if (VERSION.SDK_INT < 19) {
                context.startActivity(intent);
            } else {
                new Handler(context.getMainLooper()).post(new C1983e(this, context, intent));
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    @TargetApi(3)
    private static String m7415b(Context context) {
        String[] supportedBrowsers = C1991m.m7449a().m7467p().getSupportedBrowsers();
        try {
            int i;
            int i2;
            PackageManager packageManager = context.getPackageManager();
            List arrayList = new ArrayList();
            List<ComponentName> arrayList2 = new ArrayList();
            packageManager.getPreferredActivities(arrayList, arrayList2, null);
            for (ComponentName componentName : arrayList2) {
                for (String str : supportedBrowsers) {
                    if (str.equals(componentName.getPackageName())) {
                        C1991m.m7449a().m7457f().m7393d(str, "\u89c4\u52191 hit!");
                        return str;
                    }
                }
            }
            try {
                i2 = -1;
                for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    try {
                        if (!(packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) == null || packageManager.getApplicationInfo(runningAppProcessInfo.processName, SpdyProtocol.SLIGHTSSLV2) == null)) {
                            for (i = 0; i < supportedBrowsers.length; i++) {
                                if (runningAppProcessInfo.processName.equals(supportedBrowsers[i])) {
                                    if (i2 == -1) {
                                        i2 = i;
                                    } else if (i < i2) {
                                        i2 = i;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                i2 = -1;
            }
            if (i2 != -1) {
                return supportedBrowsers[i2];
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://m.baidu.com"));
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
            if (queryIntentActivities != null) {
                for (String str2 : supportedBrowsers) {
                    for (i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                        String str3 = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo.packageName;
                        if (str2.equals(str3)) {
                            C1991m.m7449a().m7457f().m7393d(str2, "\u89c4\u52192 hit!");
                            return str2;
                        }
                    }
                }
            }
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() > 0) {
                    return ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception e3) {
        }
    }

    private String m7416c(String str) {
        return getMD5(str);
    }

    public Object m7417a(String str) {
        try {
            Object obj = this.f6924i.get(str + "_E");
            if (obj != null) {
                if (System.currentTimeMillis() < ((Long) obj).longValue()) {
                    return this.f6924i.get(str + "_V");
                }
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        return null;
    }

    public String m7418a() {
        return "android_8.8_4.0.0";
    }

    public void m7419a(Context context, String[] strArr, int i) {
        try {
            Activity.class.getMethod("requestPermissions", new Class[]{String[].class, Integer.TYPE}).invoke(context, new Object[]{strArr, Integer.valueOf(i)});
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    public void m7420a(Runnable runnable) {
        if (runnable != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(new C1984f(this, runnable));
                }
            } catch (Throwable e) {
                C1991m.m7449a().m7457f().m7395d(e);
            }
        }
    }

    public void m7421a(String str, Object obj) {
        this.f6924i.put(str + "_E", Long.valueOf(System.currentTimeMillis() + 5000));
        this.f6924i.put(str + "_V", obj);
    }

    public JSONArray array2Json(double[] dArr) {
        Throwable e;
        if (dArr == null) {
            return null;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray();
            int i = 0;
            while (i < dArr.length) {
                try {
                    jSONArray.put(dArr[i]);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return jSONArray;
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONArray = null;
            e = th;
            C1991m.m7449a().m7457f().m7395d(e);
            return jSONArray;
        }
    }

    public String m7422b(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public String base64Encode(String str) {
        return C1991m.m7449a().m7456e().encode(str);
    }

    public boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    @TargetApi(3)
    public void browserOutside(Context context, String str) {
        if (str.startsWith("wtai://wp/mc;")) {
            str = "tel:" + str.substring("wtai://wp/mc;".length());
        }
        Intent intent;
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String str2;
            if (C1991m.m7449a().m7460i().isHttpProtocol(str).booleanValue()) {
                str2 = BuildConfig.FLAVOR;
                str2 = C1982d.m7415b(context);
                C1991m.m7449a().m7457f().m7393d("Utils", "AdUtil.browserOutside pkgOfBrowser=" + str2);
                if (str2.equals(BuildConfig.FLAVOR)) {
                    intent = intent2;
                } else {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str2);
                    intent.setData(Uri.parse(str));
                    intent.setAction("android.intent.action.VIEW");
                }
                intent2 = intent;
            } else if (((C1996r) C1991m.m7449a().m7460i()).m7476a(str).booleanValue()) {
                intent2.setType("vnd.android-dir/mms-sms");
                String substring = str.substring(4, str.indexOf(63) > 0 ? str.indexOf(63) : str.length());
                intent2.putExtra("address", substring);
                str2 = "body=";
                int length = "body=".length() + str.indexOf("body=");
                str2 = BuildConfig.FLAVOR;
                if (length > "body=".length()) {
                    int indexOf = str.indexOf(38, length);
                    if (indexOf <= 0) {
                        indexOf = str.length();
                    }
                    str2 = str.substring(length, indexOf);
                    intent2.putExtra("sms_body", Uri.decode(str2));
                }
                C1991m.m7449a().m7457f().m7393d(substring, str2);
            }
            if (context.getPackageManager().resolveActivity(intent2, AccessibilityNodeInfoCompat.ACTION_CUT) != null) {
                context.startActivity(intent2);
            }
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7396d("XAdCommonUtils.browserOutside 1", str, e);
            try {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e2) {
                C1991m.m7449a().m7457f().m7396d("XAdCommonUtils.browserOutside 2", str, e2);
            }
        }
    }

    public boolean checkSelfPermission(Context context, String str) {
        try {
            return ((Integer) Context.class.getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0;
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
            return true;
        }
    }

    public String createRequestId(Context context, String str) {
        return getMD5(C1991m.m7449a().m7465n().getIMEI(context) + getAppId(context) + str + System.currentTimeMillis());
    }

    public String decodeURIComponent(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, HttpRequest.f14548a);
        } catch (Exception e) {
            return str;
        }
    }

    public String encodeURIComponent(String str) {
        try {
            str = URLEncoder.encode(str, HttpRequest.f14548a).replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", C4233j.f14396s).replaceAll("\\%29", C4233j.f14397t).replaceAll("\\%7E", "~");
        } catch (Exception e) {
        }
        return str;
    }

    public long generateUniqueId() {
        long j;
        long j2;
        do {
            j = this.f6921f.get();
            j2 = j + 1;
            if (j2 > 9223372036854775806L) {
                j2 = 1;
            }
        } while (!this.f6921f.compareAndSet(j, j2));
        return j;
    }

    public int getApkDownloadStatus(Context context, String str, String str2) {
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            return -1;
        }
        try {
            JSONObject optJSONObject = new JSONObject(context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_ACTIVATION, 0).getString(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, "{}")).optJSONObject(str);
            if (optJSONObject != null && optJSONObject.optBoolean("a", false)) {
                return 100;
            }
        } catch (Exception e) {
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0);
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString(str + "#$#" + C1924a.m7248b(), "{}"));
            if (jSONObject == null) {
                return -1;
            }
            int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            String optString = jSONObject.optString("name", null);
            if (optString == null) {
                return i;
            }
            File file = new File(C1991m.m7449a().m7462k().getStoreagePath(context) + optString);
            if (i != 3) {
                return i;
            }
            Object obj = null;
            if (!file.exists() || file.length() == 0) {
                obj = 1;
            } else {
                long optLong = jSONObject.optLong("contentLength", -1);
                if (optLong != -1 && Math.abs(optLong - file.length()) >= 2) {
                    obj = 1;
                }
            }
            if (obj == null) {
                return i;
            }
            jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 5);
            Editor edit = sharedPreferences.edit();
            edit.putString(str, jSONObject.toString());
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
                return 5;
            }
            edit.commit();
            return 5;
        } catch (Exception e2) {
            return -1;
        }
    }

    public String getApkFileLocalPath(Context context, String str) {
        try {
            Object string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + C1924a.m7248b(), BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                string = jSONObject.optString("folder");
                Object optString = jSONObject.optString("filename");
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(optString))) {
                    return string + optString;
                }
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
        return BuildConfig.FLAVOR;
    }

    public String getAppId(Context context) {
        try {
            if (f6916a == null) {
                f6916a = m7413a(context, IXAdCommonUtils.APPSID);
            }
            return f6916a;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public String getAppPackage(Context context) {
        return context.getPackageName();
    }

    public String getAppSec(Context context) {
        if (f6918c == null || f6918c.length() == 0 || f6918c.startsWith("null")) {
            setAppSec(getAppId(context));
        }
        return f6918c;
    }

    public String getBaiduMapsInfo(Context context) {
        Object a = m7417a("mapinfo");
        if (a != null) {
            return String.valueOf(a);
        }
        a = BuildConfig.FLAVOR;
        try {
            a = new C1977a(context).m7391a();
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        m7421a("mapinfo", a);
        return a;
    }

    public String getChannelId() {
        return f6919d;
    }

    public String getDebugToken(Context context) {
        try {
            if (f6917b == null) {
                f6917b = m7413a(context, IXAdCommonUtils.DEBUG_TOKEN);
            }
            return f6917b;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    @TargetApi(17)
    public DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public String getFileLocalFullPath(Context context, String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(m7412a(context));
            stringBuilder.append(File.separator);
            stringBuilder.append(m7416c(str));
            return stringBuilder.toString();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public String getLocationInfo(Context context) {
        return getBaiduMapsInfo(context);
    }

    public int getLogicalPixel(Context context, int i) {
        try {
            return (int) (((float) i) / getScreenDensity(context));
        } catch (Exception e) {
            return i;
        }
    }

    public String getMD5(String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(bytes);
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (NoSuchAlgorithmException e) {
            C1991m.m7449a().m7457f().m7400e("AdUtil.getMD5", BuildConfig.FLAVOR, e);
            return null;
        }
    }

    public int getPixel(Context context, int i) {
        try {
            return (int) (((float) i) * getScreenDensity(context));
        } catch (Exception e) {
            return i;
        }
    }

    @TargetApi(4)
    public float getScreenDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    @TargetApi(17)
    public Rect getScreenRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        try {
            return displayMetrics.widthPixels > displayMetrics.heightPixels ? new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels) : new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception e) {
            return null;
        }
    }

    public int getStatusBarHeight(Activity activity) {
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getStatusStr(Context context, String str, String str2) {
        try {
            int apkDownloadStatus = getApkDownloadStatus(context, str, str2);
            boolean isInstalled = C1991m.m7449a().m7463l().isInstalled(context, str);
            switch (apkDownloadStatus) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "DOWNLOADING";
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                case SpdyProtocol.QUIC /*4*/:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "DOWNLOAD_FAILED";
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return isInstalled ? "INSTALLED" : "DOWNLOADED";
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    return isInstalled ? "DONE" : "NONE";
                case Constants.COMMAND_SEND_DATA /*100*/:
                    return "DONE";
                default:
                    return isInstalled ? "INSTALLED_BY_OTHER" : "NONE";
            }
        } catch (Exception e) {
            return "NONE";
        }
    }

    public String getSubscriberId(Context context) {
        if (this.f6923h == null) {
            try {
                if (hasPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                    this.f6923h = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception e) {
            }
        }
        return m7422b(this.f6923h);
    }

    public String getTextEncoder(String str) {
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            return BuildConfig.FLAVOR;
        }
        try {
            return URLEncoder.encode(str, HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            return str;
        } catch (NullPointerException e2) {
            return str;
        }
    }

    public Rect getWindowRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public boolean hasPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
            return false;
        }
    }

    public boolean hasSupportedApps(Context context, int i) {
        try {
            Intent intent;
            IXAdSystemUtils n = C1991m.m7449a().m7465n();
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("mailto:baidumobadstest@baidu.com"));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("sms:12345678"));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    boolean z = C1991m.m7449a().m7464m().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) && C1991m.m7449a().m7464m().hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
                    return z;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return n.canSupportSdcardStroage(context);
                case SpdyProtocol.QUIC /*4*/:
                    intent = new Intent("android.intent.action.EDIT");
                    intent.setType("vnd.android.cursor.item/event");
                    break;
                default:
                    return false;
            }
            ArrayList arrayList = new ArrayList();
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            return (queryIntentActivities == null || queryIntentActivities.size() <= 0 || ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName.equals("com.android.fallback")) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public void installApp(Context context, String str, File file, boolean z) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
            if (!z || str != null) {
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    public boolean isOldPermissionModel() {
        return VERSION.SDK_INT < 23;
    }

    public boolean isStringAvailable(String str) {
        return str != null && str.length() > 0;
    }

    public JSONArray list2Json(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (i < list.size()) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (Object put : (String[]) list.get(i)) {
                    jSONArray2.put(put);
                }
                jSONArray.put(jSONArray2);
                i++;
            } catch (Throwable e) {
                C1991m.m7449a().m7457f().m7395d(e);
            }
        }
        return jSONArray;
    }

    public void makeCall(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse(("tel:" + str).toString()));
                intent.addFlags(268435456);
                m7414a(context, intent);
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    public String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & MotionEventCompat.ACTION_MASK);
                while (toHexString.length() < 2) {
                    toHexString = MessageService.MSG_DB_READY_REPORT + toHexString;
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return BuildConfig.FLAVOR;
        }
    }

    public void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str);
            intent.putExtra("sms_body", str2);
            intent.setType("vnd.android-dir/mms-sms");
            intent.addFlags(268435456);
            m7414a(context, intent);
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    public void setAppId(String str) {
        f6916a = str;
    }

    public void setAppSec(String str) {
        f6918c = str + "_cpr";
    }

    public void setChannelId(String str) {
        f6919d = str;
    }

    public String vdUrl(String str, int i) {
        Iterator keys;
        String str2;
        C1991m.m7449a().m7460i();
        JSONObject jSONObject = new JSONObject();
        String[] split = str.substring(str.indexOf("?") + 1).split("&");
        for (String split2 : split) {
            try {
                String[] split3 = split2.split("=");
                if (split3.length > 1 && !split3[0].equals(C4233j.f14402y)) {
                    jSONObject.putOpt(split3[0], split3[1]);
                }
            } catch (Exception e) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder("type=" + i + "&");
        Map treeMap = new TreeMap();
        StringBuilder stringBuilder2 = new StringBuilder();
        try {
            keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    str2 = (String) keys.next();
                    if (!(str2 == null || str2.equals(BuildConfig.FLAVOR))) {
                        treeMap.put(str2, jSONObject.optString(str2));
                    }
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
        treeMap.put(MsgConstant.KEY_TS, System.currentTimeMillis() + BuildConfig.FLAVOR);
        for (String str22 : treeMap.keySet()) {
            String str3 = (String) treeMap.get(str22);
            if (!(str22 == null || str3 == null)) {
                if (!str22.equals("targetscheme")) {
                    str22 = encodeURIComponent(str22);
                    str3 = encodeURIComponent(str3);
                }
                stringBuilder.append(str22 + "=" + str3 + "&");
                stringBuilder2.append(str3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuilder2.append("mobads,");
        stringBuilder.append("vd=" + getMD5(stringBuilder2.toString()) + "&");
        return "http://mobads-logs.baidu.com/dz.zb?" + stringBuilder.toString();
    }
}
