package p023b.p024a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C4156a;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.am */
public class am {
    protected static final String f2678a;

    static {
        f2678a = am.class.getName();
    }

    private static String m3328A(Context context) {
        String str = BuildConfig.FLAVOR;
        Object string;
        if (VERSION.SDK_INT < 23) {
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3367y(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3343d();
            return TextUtils.isEmpty(string) ? am.m3329B(context) : string;
        } else if (VERSION.SDK_INT == 23) {
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3338b();
            if (TextUtils.isEmpty(string)) {
                string = C4156a.f13943e ? am.m3341c() : am.m3367y(context);
            }
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3343d();
            return TextUtils.isEmpty(string) ? am.m3329B(context) : string;
        } else {
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3343d();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3329B(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = am.m3338b();
            return TextUtils.isEmpty(string) ? am.m3367y(context) : string;
        }
    }

    private static String m3329B(Context context) {
        String str = BuildConfig.FLAVOR;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return str;
        }
        try {
            return am.m3336a(context, MsgConstant.PERMISSION_READ_PHONE_STATE) ? telephonyManager.getDeviceId() : str;
        } catch (Throwable th) {
            return str;
        }
    }

    private static int m3330a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static String m3331a() {
        Throwable th;
        String str;
        Throwable th2;
        String str2 = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, IXAdIOUtils.BUFFER_SIZE);
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Throwable th3) {
                    try {
                        ap.m3392d(f2678a, "Could not read from file /proc/cpuinfo", th3);
                    } catch (Throwable th32) {
                        th = th32;
                        str = str2;
                        th2 = th;
                        ap.m3392d(f2678a, "Could not open file /proc/cpuinfo", th2);
                        str2 = str;
                        return str2 != null ? BuildConfig.FLAVOR : str2.substring(str2.indexOf(58) + 1).trim();
                    }
                }
            }
        } catch (Throwable th322) {
            th = th322;
            str = str2;
            th2 = th;
            ap.m3392d(f2678a, "Could not open file /proc/cpuinfo", th2);
            str2 = str;
            if (str2 != null) {
            }
        }
        if (str2 != null) {
        }
    }

    public static String m3332a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return BuildConfig.FLAVOR;
        }
    }

    private static String m3333a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            Reader fileReader = new FileReader(str);
            if (fileReader != null) {
                try {
                    bufferedReader = new BufferedReader(fileReader, IXAdIOUtils.BUFFER_SIZE);
                    try {
                        str2 = bufferedReader.readLine();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th5) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = str2;
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
        }
        return str2;
    }

    private static String m3334a(Properties properties) {
        Object property = properties.getProperty("ro.yunos.version");
        return !TextUtils.isEmpty(property) ? property : null;
    }

    private static String m3335a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i]);
            int length = toHexString.length();
            if (length == 1) {
                toHexString = MessageService.MSG_DB_READY_REPORT + toHexString;
            }
            if (length > 2) {
                toHexString = toHexString.substring(length - 2, length);
            }
            stringBuilder.append(toHexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    public static boolean m3336a(Context context, String str) {
        if (VERSION.SDK_INT < 23) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            try {
                return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0;
            } catch (Throwable th) {
                return false;
            }
        }
    }

    public static String[] m3337a(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Throwable th) {
            return new String[0];
        }
    }

    private static String m3338b() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (!"wlan0".equals(networkInterface.getName())) {
                    if ("eth0".equals(networkInterface.getName())) {
                    }
                }
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress == null || hardwareAddress.length == 0) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i = 0; i < length; i++) {
                    stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString().toLowerCase(Locale.getDefault());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String m3339b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return BuildConfig.FLAVOR;
        }
    }

    private static String m3340b(Properties properties) {
        try {
            String toLowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (toLowerCase.contains("flyme os")) {
                return toLowerCase.split(" ")[2];
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static String m3341c() {
        try {
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            int i = 0;
            while (i < strArr.length) {
                try {
                    String a = am.m3333a(strArr[i]);
                    if (a != null) {
                        return a;
                    }
                    i++;
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        return null;
    }

    public static String m3342c(Context context) {
        return (EScenarioType.E_UM_ANALYTICS_OEM.toValue() == AnalyticsConfig.getVerticalType(context) || EScenarioType.E_UM_GAME_OEM.toValue() == AnalyticsConfig.getVerticalType(context)) ? am.m3328A(context) : am.m3368z(context);
    }

    private static String m3343d() {
        return VERSION.SDK_INT >= 9 ? Build.SERIAL : BuildConfig.FLAVOR;
    }

    public static String m3344d(Context context) {
        return an.m3375b(am.m3342c(context));
    }

    public static String m3345e(Context context) {
        if (am.m3347f(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i == 0) {
            return null;
        }
        String valueOf = String.valueOf(i2);
        if (i2 < 10) {
            valueOf = String.format("%02d", new Object[]{Integer.valueOf(i2)});
        }
        return new StringBuffer().append(String.valueOf(i)).append(valueOf).toString();
    }

    private static Properties m3346e() {
        FileInputStream fileInputStream;
        Throwable th;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream2 = fileInputStream;
                th = th4;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return properties;
    }

    public static String m3347f(Context context) {
        return am.m3336a(context, MsgConstant.PERMISSION_READ_PHONE_STATE) ? ((TelephonyManager) context.getSystemService("phone")).getSubscriberId() : null;
    }

    private static boolean m3348f() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String m3349g(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (am.m3336a(context, MsgConstant.PERMISSION_READ_PHONE_STATE) && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable th) {
        }
        return BuildConfig.FLAVOR;
    }

    public static String[] m3350h(Context context) {
        String[] strArr = new String[]{BuildConfig.FLAVOR, BuildConfig.FLAVOR};
        try {
            if (am.m3336a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = BuildConfig.FLAVOR;
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                        strArr[0] = "2G/3G";
                        strArr[1] = networkInfo2.getSubtypeName();
                        return strArr;
                    }
                    return strArr;
                }
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            strArr[0] = BuildConfig.FLAVOR;
            return strArr;
        } catch (Throwable th) {
        }
    }

    public static boolean m3351i(Context context) {
        return "Wi-Fi".equals(am.m3350h(context)[0]);
    }

    public static boolean m3352j(Context context) {
        try {
            if (am.m3336a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnectedOrConnecting();
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static int m3353k(Context context) {
        try {
            Calendar instance = Calendar.getInstance(am.m3366x(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            ap.m3387b(f2678a, "error in getTimeZone", th);
        }
        return 8;
    }

    public static boolean m3354l(Context context) {
        Object b = ct.m3820a(context).m3828b().m3813b(BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(b)) {
            return b.equals("cn");
        } else {
            if (am.m3347f(context) == null) {
                b = am.m3355m(context)[0];
                if (!TextUtils.isEmpty(b) && b.equalsIgnoreCase("cn")) {
                    return true;
                }
            }
            int i = context.getResources().getConfiguration().mcc;
            if (i == 460 || i == 461) {
                return true;
            }
            if (i == 0) {
                b = am.m3355m(context)[0];
                if (!TextUtils.isEmpty(b) && b.equalsIgnoreCase("cn")) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String[] m3355m(Context context) {
        String[] strArr = new String[2];
        try {
            Locale x = am.m3366x(context);
            if (x != null) {
                strArr[0] = x.getCountry();
                strArr[1] = x.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Throwable th) {
            ap.m3392d(f2678a, "error in getLocaleInfo", th);
        }
        return strArr;
    }

    public static String m3356n(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                ap.m3384a(f2678a, "getAppkey failed. the applicationinfo is null!");
            }
        } catch (Throwable th) {
            ap.m3392d(f2678a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", th);
        }
        return null;
    }

    public static String m3357o(Context context) {
        String str = BuildConfig.FLAVOR;
        if (VERSION.SDK_INT < 23) {
            return am.m3367y(context);
        }
        Object b;
        if (VERSION.SDK_INT == 23) {
            b = am.m3338b();
            return TextUtils.isEmpty(b) ? C4156a.f13943e ? am.m3341c() : am.m3367y(context) : b;
        } else {
            b = am.m3338b();
            return TextUtils.isEmpty(b) ? am.m3367y(context) : b;
        }
    }

    public static int[] m3358p(Context context) {
        try {
            int a;
            int a2;
            int i;
            Object displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) == 0) {
                a = am.m3330a(displayMetrics, "noncompatWidthPixels");
                a2 = am.m3330a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = -1;
                a = -1;
            }
            if (a == -1 || a2 == -1) {
                i = displayMetrics.widthPixels;
                a = displayMetrics.heightPixels;
            } else {
                i = a;
                a = a2;
            }
            int[] iArr = new int[2];
            if (i > a) {
                iArr[0] = a;
                iArr[1] = i;
                return iArr;
            }
            iArr[0] = i;
            iArr[1] = a;
            return iArr;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m3359q(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    public static String m3360r(Context context) {
        return context.getPackageName();
    }

    public static String m3361s(Context context) {
        try {
            return am.m3335a(MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5).digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(am.m3360r(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m3362t(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String m3363u(Context context) {
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        return str;
    }

    public static String m3364v(Context context) {
        Properties e = am.m3346e();
        try {
            Object property = e.getProperty("ro.miui.ui.version.name");
            return TextUtils.isEmpty(property) ? am.m3348f() ? "Flyme" : !TextUtils.isEmpty(am.m3334a(e)) ? "YunOS" : property : "MIUI";
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m3365w(Context context) {
        Properties e = am.m3346e();
        try {
            String property = e.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            if (am.m3348f()) {
                try {
                    return am.m3340b(e);
                } catch (Throwable th) {
                    return property;
                }
            }
            try {
                return am.m3334a(e);
            } catch (Throwable th2) {
                return property;
            }
        } catch (Throwable th3) {
            return null;
        }
    }

    private static Locale m3366x(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Throwable th) {
            ap.m3384a(f2678a, "fail to read user config locale");
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    private static String m3367y(Context context) {
        try {
            return am.m3336a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) ? ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress() : BuildConfig.FLAVOR;
        } catch (Throwable th) {
            return BuildConfig.FLAVOR;
        }
    }

    private static String m3368z(Context context) {
        String str = BuildConfig.FLAVOR;
        Object B;
        if (VERSION.SDK_INT < 23) {
            B = am.m3329B(context);
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = am.m3367y(context);
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(B) ? am.m3343d() : B;
        } else if (VERSION.SDK_INT == 23) {
            B = am.m3329B(context);
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = am.m3338b();
            if (TextUtils.isEmpty(B)) {
                B = C4156a.f13943e ? am.m3341c() : am.m3367y(context);
            }
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(B) ? am.m3343d() : B;
        } else {
            B = am.m3329B(context);
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = am.m3343d();
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(B)) {
                return B;
            }
            B = am.m3338b();
            return TextUtils.isEmpty(B) ? am.m3367y(context) : B;
        }
    }
}
