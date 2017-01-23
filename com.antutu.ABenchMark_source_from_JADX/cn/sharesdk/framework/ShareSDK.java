package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;

public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_INT = 68;
    private static C0970f f3171a;
    private static boolean f3172b;

    static {
        f3172b = true;
    }

    static String m4072a(int i, String str) {
        m4081b();
        return f3171a.m4323a(i, str);
    }

    static String m4073a(Bitmap bitmap) {
        m4081b();
        return f3171a.m4324a(bitmap);
    }

    static String m4074a(String str) {
        m4081b();
        return f3171a.m4345c(str);
    }

    static String m4075a(String str, boolean z, int i, String str2) {
        m4081b();
        return f3171a.m4325a(str, z, i, str2);
    }

    static void m4076a(int i, int i2) {
        m4081b();
        f3171a.m4327a(i, i2);
    }

    static void m4077a(String str, String str2) {
        m4081b();
        f3171a.m4331a(str, str2);
    }

    static boolean m4078a() {
        m4081b();
        return f3171a.m4348d();
    }

    static boolean m4079a(HashMap<String, Object> hashMap) {
        m4081b();
        return f3171a.m4334a((HashMap) hashMap);
    }

    static String m4080b(String str, String str2) {
        m4081b();
        return f3171a.m4338b(str, str2);
    }

    private static void m4081b() {
        if (f3171a == null) {
            throw new RuntimeException("Please call ShareSDK.initSDK(Context) in the main process before any action.");
        }
    }

    static boolean m4082b(HashMap<String, Object> hashMap) {
        m4081b();
        return f3171a.m4342b((HashMap) hashMap);
    }

    public static void closeDebug() {
        f3172b = false;
    }

    public static void deleteCache() {
        m4081b();
        f3171a.m4349e();
    }

    @Deprecated
    public static Platform getPlatform(Context context, String str) {
        m4081b();
        return f3171a.m4322a(str);
    }

    public static Platform getPlatform(String str) {
        m4081b();
        return f3171a.m4322a(str);
    }

    public static synchronized Platform[] getPlatformList() {
        Platform[] a;
        synchronized (ShareSDK.class) {
            m4081b();
            a = f3171a.m4335a();
        }
        return a;
    }

    @Deprecated
    public static synchronized Platform[] getPlatformList(Context context) {
        Platform[] platformList;
        synchronized (ShareSDK.class) {
            platformList = getPlatformList();
        }
        return platformList;
    }

    public static int getSDKVersionCode() {
        return SDK_VERSION_INT;
    }

    public static String getSDKVersionName() {
        m4081b();
        return f3171a.m4337b();
    }

    public static <T extends Service> T getService(Class<T> cls) {
        m4081b();
        return f3171a.m4343c((Class) cls);
    }

    public static void initSDK(Context context) {
        initSDK(context, null, true);
    }

    public static void initSDK(Context context, String str) {
        initSDK(context, str, true);
    }

    public static void initSDK(Context context, String str, boolean z) {
        if (DeviceHelper.getInstance(context) == null) {
            throw new RuntimeException("The param of context is null which in ShareSDK.initSDK(context)!");
        } else if (f3171a == null) {
            C0970f c0970f = new C0970f(context, str);
            c0970f.m4333a(z);
            c0970f.startThread();
            f3171a = c0970f;
        }
    }

    public static void initSDK(Context context, boolean z) {
        initSDK(context, null, z);
    }

    public static boolean isDebug() {
        return f3172b;
    }

    public static boolean isRemoveCookieOnAuthorize() {
        m4081b();
        return f3171a.m4346c();
    }

    public static void logApiEvent(String str, int i) {
        m4081b();
        f3171a.m4330a(str, i);
    }

    public static void logDemoEvent(int i, Platform platform) {
        m4081b();
        f3171a.m4328a(i, platform);
    }

    public static String platformIdToName(int i) {
        m4081b();
        return f3171a.m4344c(i);
    }

    public static int platformNameToId(String str) {
        m4081b();
        return f3171a.m4336b(str);
    }

    public static void registerPlatform(Class<? extends CustomPlatform> cls) {
        m4081b();
        f3171a.m4347d(cls);
    }

    public static void registerService(Class<? extends Service> cls) {
        m4081b();
        f3171a.m4329a((Class) cls);
    }

    public static void removeCookieOnAuthorize(boolean z) {
        m4081b();
        f3171a.m4341b(z);
    }

    public static void setConnTimeout(int i) {
        m4081b();
        f3171a.m4326a(i);
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> hashMap) {
        m4081b();
        f3171a.m4332a(str, (HashMap) hashMap);
    }

    public static void setReadTimeout(int i) {
        m4081b();
        f3171a.m4339b(i);
    }

    public static void stopSDK() {
    }

    public static void stopSDK(Context context) {
        stopSDK();
    }

    public static void unregisterPlatform(Class<? extends CustomPlatform> cls) {
        m4081b();
        f3171a.m4350e(cls);
    }

    public static void unregisterService(Class<? extends Service> cls) {
        m4081b();
        f3171a.m4340b((Class) cls);
    }
}
