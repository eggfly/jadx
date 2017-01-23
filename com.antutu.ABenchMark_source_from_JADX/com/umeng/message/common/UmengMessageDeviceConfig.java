package com.umeng.message.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
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
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.p105c.p106a.p111c.C2101a;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4230g;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.microedition.khronos.opengles.GL10;
import org.android.spdy.SpdyProtocol;

public class UmengMessageDeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    protected static final String f14194a;
    protected static final String f14195b = "Unknown";
    private static final String f14196c = "2G/3G";
    private static final String f14197d = "Wi-Fi";

    static {
        f14194a = UmengMessageDeviceConfig.class.getName();
    }

    private static int m17146a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.getInt(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static Locale m17147a(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Exception e) {
            UmLog.m17138e(f14194a, "fail to read user config locale");
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static boolean checkPermission(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String getAndroidId(Context context) {
        String string = System.getString(context.getContentResolver(), "android_id");
        return string == null ? BuildConfig.FLAVOR : string;
    }

    public static String getAppLabel(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : BuildConfig.FLAVOR);
    }

    public static String getAppVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return f14195b;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return f14195b;
        }
    }

    public static String getAppkey(Context context) {
        return getMetaData(context, "UMENG_APPKEY");
    }

    public static String getApplicationLable(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String getCPU() {
        Exception exception;
        String str;
        Exception exception2;
        String str2 = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, IXAdIOUtils.BUFFER_SIZE);
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e) {
                    try {
                        UmLog.m17139e(f14194a, "Could not read from file /proc/cpuinfo", e);
                    } catch (Exception e2) {
                        exception = e2;
                        str = str2;
                        exception2 = exception;
                        UmLog.m17139e(f14194a, "Could not open file /proc/cpuinfo", exception2);
                        str2 = str;
                        return str2 != null ? str2.substring(str2.indexOf(58) + 1).trim() : str2;
                    }
                }
            }
        } catch (Exception e22) {
            exception = e22;
            str = str2;
            exception2 = exception;
            UmLog.m17139e(f14194a, "Could not open file /proc/cpuinfo", exception2);
            str2 = str;
            if (str2 != null) {
            }
        }
        if (str2 != null) {
        }
    }

    public static String getChannel(Context context) {
        String str = f14195b;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                    UmLog.m17140i(f14194a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                }
            }
        } catch (Exception e) {
            UmLog.m17140i(f14194a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
        }
        return str;
    }

    public static boolean getDataData(String str) {
        boolean exists = new File("/data/app/" + str + "-1.apk").exists();
        if (!exists) {
            exists = new File("/data/app/" + str + "-2.apk").exists();
        }
        if (!exists) {
            exists = new File("/data/app/" + str + ".apk").exists();
        }
        if (!exists) {
            exists = new File("/data/app/" + str + "-1").exists();
        }
        return !exists ? new File("/data/app/" + str + "-2").exists() : exists;
    }

    public static String getDeviceId(Context context) {
        Object deviceId;
        String serial_number;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            UmLog.m17144w(f14194a, "No IMEI.");
        }
        String str = BuildConfig.FLAVOR;
        try {
            if (checkPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                deviceId = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                UmLog.m17144w(f14194a, "No IMEI.");
                deviceId = getMac(context);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                UmLog.m17144w(f14194a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                deviceId = Secure.getString(context.getContentResolver(), "android_id");
                UmLog.m17140i(f14194a, "getDeviceId: Secure.ANDROID_ID: " + deviceId);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                UmLog.m17144w(f14194a, "Failed to take Secure.ANDROID_ID as IMEI. Try to use Serial_number instead.");
                serial_number = getSerial_number();
                UmLog.m17140i(f14194a, "getDeviceId: Serial_number: " + serial_number);
                return serial_number;
            }
        } catch (Exception e) {
            UmLog.m17145w(f14194a, "No IMEI.", e);
        }
        serial_number = str;
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        UmLog.m17144w(f14194a, "No IMEI.");
        deviceId = getMac(context);
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        UmLog.m17144w(f14194a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
        deviceId = Secure.getString(context.getContentResolver(), "android_id");
        UmLog.m17140i(f14194a, "getDeviceId: Secure.ANDROID_ID: " + deviceId);
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        UmLog.m17144w(f14194a, "Failed to take Secure.ANDROID_ID as IMEI. Try to use Serial_number instead.");
        serial_number = getSerial_number();
        UmLog.m17140i(f14194a, "getDeviceId: Serial_number: " + serial_number);
        return serial_number;
    }

    public static String getDeviceIdMD5(Context context) {
        return C4230g.m17261a(getDeviceId(context));
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return C4230g.m17272b(getDeviceId(context));
    }

    public static String getDisplayResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
        } catch (Exception e) {
            e.printStackTrace();
            return f14195b;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Exception e) {
            UmLog.m17139e(f14194a, "Could not read gpu infor:", e);
            return new String[0];
        }
    }

    public static int getIntervalSeconds(Date date, Date date2) {
        if (!date.after(date2)) {
            Date date3 = date2;
            date2 = date;
            date = date3;
        }
        return (int) ((date.getTime() - date2.getTime()) / 1000);
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = new String[2];
        try {
            Locale a = m17147a(context);
            if (a != null) {
                strArr[0] = a.getCountry();
                strArr[1] = a.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = f14195b;
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = f14195b;
            }
        } catch (Exception e) {
            UmLog.m17139e(f14194a, "error in getLocaleInfo", e);
        }
        return strArr;
    }

    public static Location getLocation(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(MsgConstant.KEY_LOCATION_PARAMS);
            if (checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    UmLog.m17136d(f14194a, "get location from gps:" + lastKnownLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + lastKnownLocation.getLongitude());
                    return lastKnownLocation;
                }
            }
            if (checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation2 != null) {
                    UmLog.m17136d(f14194a, "get location from network:" + lastKnownLocation2.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + lastKnownLocation2.getLongitude());
                    return lastKnownLocation2;
                }
            }
            UmLog.m17136d(f14194a, "Could not get location from GPS or Cell-id, lack ACCESS_COARSE_LOCATION or ACCESS_COARSE_LOCATION permission?");
            return null;
        } catch (Exception e) {
            UmLog.m17138e(f14194a, e.getMessage());
            return null;
        }
    }

    public static String getMac(Context context) {
        if (VERSION.SDK_INT <= 22) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
                if (checkPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                    return wifiManager.getConnectionInfo().getMacAddress();
                }
                UmLog.m17144w(f14194a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            } catch (Exception e) {
                UmLog.m17144w(f14194a, "Could not get mac address." + e.toString());
            }
        } else {
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
                while (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        str2 = str.trim();
                        break;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!BuildConfig.FLAVOR.equals(str2)) {
                return str2;
            }
            try {
                File file = new File("/sys/class/net/eth0/address");
                if (file.isFile() && file.exists()) {
                    return C4230g.m17271b(file).substring(0, 17);
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static String getMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(str);
                if (string != null) {
                    return string.trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UmLog.m17138e(f14194a, String.format("Could not read meta-data %s from AndroidManifest.xml.", new Object[]{str}));
        return null;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = new String[]{f14195b, f14195b};
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    strArr[0] = f14196c;
                    strArr[1] = networkInfo2.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = f14197d;
            return strArr;
        } catch (Exception e) {
        }
    }

    public static String getNetworkOperatorName(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? f14195b : telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            e.printStackTrace();
            return f14195b;
        }
    }

    public static String getOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            UmLog.m17141i(f14194a, "read carrier fail", e);
            return f14195b;
        }
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static String getResolution(Context context) {
        try {
            int a;
            int a2;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) == 0) {
                a = m17146a(displayMetrics, "noncompatWidthPixels");
                a2 = m17146a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = -1;
                a = -1;
            }
            if (a == -1 || r0 == -1) {
                a = displayMetrics.widthPixels;
                a2 = displayMetrics.heightPixels;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a);
            stringBuffer.append("*");
            stringBuffer.append(a2);
            return stringBuffer.toString();
        } catch (Exception e) {
            UmLog.m17139e(f14194a, "read resolution fail", e);
            return f14195b;
        }
    }

    public static String getSerial_number() {
        String str = Build.SERIAL;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public static String getTimeString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    public static int getTimeZone(Context context) {
        try {
            Calendar instance = Calendar.getInstance(m17147a(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Exception e) {
            UmLog.m17141i(f14194a, "error in getTimeZone", e);
        }
        return DEFAULT_TIMEZONE;
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static String getUtdid(Context context) {
        try {
            return C2101a.m7882a(context);
        } catch (Throwable th) {
            UmLog.m17138e(f14194a, "fail to get utdid. " + th.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static boolean isAppInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isChinese(Context context) {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    public static boolean isDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isScreenPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static boolean isSdCardWrittenable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isServiceWork(Context context, String str) {
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        return f14197d.equals(getNetworkAccessMode(context)[0]);
    }

    public static Date toTime(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (Exception e) {
            return null;
        }
    }
}
