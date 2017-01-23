package com.baidu.mobads.p080j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.facebook.ads.AdError;
import com.igexin.sdk.PushBuildConfig;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;

/* renamed from: com.baidu.mobads.j.n */
public class C1992n implements IXAdSystemUtils {
    private static String f6955b;
    public JSONArray f6956a;
    private String f6957c;
    private String f6958d;
    private String f6959e;
    private String f6960f;
    private String f6961g;
    private int f6962h;
    private String f6963i;
    private String f6964j;
    private String f6965k;
    private String f6966l;

    public C1992n() {
        this.f6956a = new JSONArray();
        this.f6962h = -1;
    }

    @TargetApi(18)
    private long m7469a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (VERSION.SDK_INT >= 18) {
                return ((statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return (long) (((statFs.getBlockSize() * statFs.getBlockCount()) / IXAdIOUtils.BUFFER_SIZE) / IXAdIOUtils.BUFFER_SIZE);
        } catch (Exception e) {
            return -1;
        }
    }

    private Boolean m7470a(Context context, int i) {
        try {
            String str = MsgConstant.PERMISSION_ACCESS_NETWORK_STATE;
            if (context.checkCallingOrSelfPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) != 0) {
                C1991m.m7449a().m7457f().m7400e("Utils", "no permission android.permission.ACCESS_NETWORK_STATE");
                return Boolean.valueOf(false);
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.getType() == i && activeNetworkInfo.isConnected();
            return Boolean.valueOf(z);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    @TargetApi(18)
    private long m7471b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return (long) (((statFs.getBlockSize() * statFs.getAvailableBlocks()) / IXAdIOUtils.BUFFER_SIZE) / IXAdIOUtils.BUFFER_SIZE);
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean canSupportSdcardStroage(Context context) {
        try {
            return C1991m.m7449a().m7464m().hasPermission(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) || !isUseOldStoragePath();
        } catch (Exception e) {
            return false;
        }
    }

    public long getAllExternalMemorySize() {
        long j = -1;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                j = m7469a(Environment.getExternalStorageDirectory());
            }
        } catch (Exception e) {
        }
        return j;
    }

    public long getAllInternalMemorySize() {
        try {
            return m7469a(Environment.getDataDirectory());
        } catch (Exception e) {
            return -1;
        }
    }

    public String getAndroidId(Context context) {
        try {
            if (TextUtils.isEmpty(this.f6960f)) {
                this.f6960f = C1991m.m7449a().m7464m().m7422b(Secure.getString(context.getContentResolver(), "android_id"));
            }
            return this.f6960f;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public String getAppSDC() {
        try {
            Object a = C1991m.m7449a().m7464m().m7417a("sysSdc");
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "0,0";
        }
        String str = BuildConfig.FLAVOR;
        try {
            long availableExternalMemorySize = getAvailableExternalMemorySize();
            str = availableExternalMemorySize + Constants.ACCEPT_TIME_SEPARATOR_SP + getAllExternalMemorySize();
            C1991m.m7449a().m7464m().m7421a("sysSdc", (Object) str);
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public long getAvailableExternalMemorySize() {
        long j = -1;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                j = m7471b(Environment.getExternalStorageDirectory());
            }
        } catch (Exception e) {
        }
        return j;
    }

    public long getAvailableInternalMemorySize() {
        try {
            return m7471b(Environment.getDataDirectory());
        } catch (Exception e) {
            return -1;
        }
    }

    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger f = C1991m.m7449a().m7457f();
        String[] supportedBrowsers = C1991m.m7449a().m7467p().getSupportedBrowsers();
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (!(packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) == null || packageManager.getApplicationInfo(runningAppProcessInfo.processName, SpdyProtocol.SLIGHTSSLV2) == null)) {
                    for (Object equals : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(equals)) {
                            this.f6956a.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            f.m7395d(e);
        }
        f.m7392d("bgBrowsers:" + this.f6956a);
        return this.f6956a;
    }

    public String getCUID(Context context) {
        try {
            if (TextUtils.isEmpty(f6955b)) {
                String string = System.getString(context.getContentResolver(), "com.baidu.deviceid");
                if (!(string == null || string.equals(BuildConfig.FLAVOR))) {
                    String string2 = System.getString(context.getContentResolver(), "bd_setting_i");
                    if (TextUtils.isEmpty(string2)) {
                        string2 = MessageService.MSG_DB_READY_REPORT;
                    }
                    f6955b = string + "|" + new StringBuffer(string2).reverse().toString();
                }
            }
            return C1991m.m7449a().m7464m().m7422b(f6955b);
        } catch (Exception e) {
            return C1991m.m7449a().m7464m().m7422b(f6955b);
        }
    }

    public List<String[]> getCell(Context context) {
        try {
            Object a = C1991m.m7449a().m7464m().m7417a("cell");
            if (a != null) {
                return (List) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        List<String[]> arrayList = new ArrayList();
        try {
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation != null) {
                Object obj = new String[3];
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    obj[0] = gsmCellLocation.getCid() + BuildConfig.FLAVOR;
                    obj[1] = gsmCellLocation.getLac() + BuildConfig.FLAVOR;
                    obj[2] = MessageService.MSG_DB_READY_REPORT;
                } else {
                    String[] split = cellLocation.toString().replace("[", BuildConfig.FLAVOR).replace("]", BuildConfig.FLAVOR).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    obj[0] = split[0];
                    obj[1] = split[3];
                    obj[2] = split[4];
                }
                arrayList.add(obj);
            }
            C1991m.m7449a().m7464m().m7421a("cell", (Object) arrayList);
        } catch (Exception e2) {
        }
        return arrayList;
    }

    public int getCurrentProcessId(Context context) {
        try {
            return Process.myPid();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getCurrentProcessName(Context context) {
        try {
            if (this.f6966l == null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.pid == myPid) {
                                this.f6966l = runningAppProcessInfo.processName;
                            }
                        }
                    }
                }
            }
            return this.f6966l;
        } catch (Exception e) {
            return this.f6966l;
        }
    }

    public String getDeviceId(Context context) {
        return getIMEI(context);
    }

    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.f6965k)) {
                this.f6965k = C1991m.m7449a().m7456e().encode(getSn(context));
            }
            return this.f6965k;
        } catch (Exception e) {
            return this.f6965k;
        }
    }

    public double[] getGPS(Context context) {
        Object a;
        try {
            a = C1991m.m7449a().m7464m().m7417a("SYSGPS");
            if (a != null) {
                return (double[]) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        if (C1991m.m7449a().m7464m().hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                Location lastKnownLocation = ((LocationManager) context.getSystemService(MsgConstant.KEY_LOCATION_PARAMS)).getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    a = new double[3];
                    try {
                        a[0] = (double) lastKnownLocation.getTime();
                        a[1] = lastKnownLocation.getLongitude();
                        a[2] = lastKnownLocation.getLatitude();
                    } catch (SecurityException e2) {
                    }
                    C1991m.m7449a().m7464m().m7421a("SYSGPS", a);
                    return a;
                }
            } catch (SecurityException e3) {
                a = null;
            }
        }
        a = null;
        C1991m.m7449a().m7464m().m7421a("SYSGPS", a);
        return a;
    }

    public String getGUID(Context context) {
        try {
            if (this.f6959e != null || context == null) {
                return this.f6959e;
            }
            IXAdCommonUtils m = C1991m.m7449a().m7464m();
            this.f6959e = context.getSharedPreferences("__x_adsdk_agent_header__", 0).getString("guid", BuildConfig.FLAVOR);
            if (this.f6959e == null || this.f6959e.length() <= 0) {
                this.f6959e = m.md5(getMacAddress(context) + "&" + getIMEI(context) + "&" + "&");
                if (this.f6959e == null || this.f6959e.length() <= 0) {
                    return BuildConfig.FLAVOR;
                }
                context.getSharedPreferences("__x_adsdk_agent_header__", 0).edit().putString("guid", this.f6959e).commit();
            }
            return this.f6959e;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public HttpURLConnection getHttpConnection(Context context, String str, int i, int i2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public String getIMEI(Context context) {
        if (TextUtils.isEmpty(this.f6957c) && context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
            Object string = sharedPreferences.getString(com.taobao.accs.common.Constants.KEY_IMEI, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(string)) {
                try {
                    String deviceId = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getDeviceId();
                    if (!TextUtils.isEmpty(deviceId)) {
                        new Thread(new C1993o(this, sharedPreferences, deviceId)).start();
                        this.f6957c = deviceId;
                    }
                } catch (Throwable e) {
                    C1989j.m7430a().m7435d(e);
                }
            } else {
                this.f6957c = string;
            }
        }
        return C1991m.m7449a().m7464m().m7422b(this.f6957c);
    }

    @TargetApi(3)
    public String getIp(Context context) {
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            charSequence = Formatter.formatIpAddress(((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getIpAddress());
            if (!TextUtils.isEmpty(charSequence)) {
                return "0.0.0.0".equals(charSequence) ? BuildConfig.FLAVOR : charSequence;
            } else {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
                return charSequence;
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
    }

    public String getMacAddress(Context context) {
        if (TextUtils.isEmpty(this.f6961g)) {
            IXAdLogger f = C1991m.m7449a().m7457f();
            IXAdCommonUtils m = C1991m.m7449a().m7464m();
            try {
                String str = MsgConstant.PERMISSION_ACCESS_WIFI_STATE;
                WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
                if (m.hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                    this.f6961g = C1991m.m7449a().m7464m().m7422b(wifiManager.getConnectionInfo().getMacAddress());
                } else {
                    f.m7400e(BuildConfig.FLAVOR, "Could not get mac address. no android.permission.ACCESS_WIFI_STATE");
                }
            } catch (Exception e) {
                f.m7400e(BuildConfig.FLAVOR, "Could not get mac address." + e.toString());
            }
        }
        return this.f6961g;
    }

    public String getMaxCpuFreq() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable e;
        IXAdLogger f;
        FileReader fileReader2 = null;
        if (this.f6962h < 0) {
            String str = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    fileReader2 = fileReader;
                    try {
                        C1991m.m7449a().m7457f().m7395d(e);
                        try {
                            fileReader2.close();
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e = e3;
                            f = C1991m.m7449a().m7457f();
                            f.m7395d(e);
                            return this.f6962h + BuildConfig.FLAVOR;
                        }
                        return this.f6962h + BuildConfig.FLAVOR;
                    } catch (Throwable th) {
                        e = th;
                        fileReader = fileReader2;
                        try {
                            fileReader.close();
                            bufferedReader.close();
                        } catch (Throwable e4) {
                            C1991m.m7449a().m7457f().m7395d(e4);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    fileReader.close();
                    bufferedReader.close();
                    throw e;
                }
                try {
                    this.f6962h = Integer.parseInt(bufferedReader.readLine().trim()) / AdError.NETWORK_ERROR_CODE;
                    try {
                        fileReader.close();
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e = e5;
                        f = C1991m.m7449a().m7457f();
                        f.m7395d(e);
                        return this.f6962h + BuildConfig.FLAVOR;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileReader2 = fileReader;
                    C1991m.m7449a().m7457f().m7395d(e);
                    fileReader2.close();
                    bufferedReader.close();
                    return this.f6962h + BuildConfig.FLAVOR;
                } catch (Throwable th3) {
                    e = th3;
                    fileReader.close();
                    bufferedReader.close();
                    throw e;
                }
            } catch (Exception e7) {
                e = e7;
                bufferedReader = null;
                C1991m.m7449a().m7457f().m7395d(e);
                fileReader2.close();
                bufferedReader.close();
                return this.f6962h + BuildConfig.FLAVOR;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                fileReader = null;
                fileReader.close();
                bufferedReader.close();
                throw e;
            }
        }
        return this.f6962h + BuildConfig.FLAVOR;
    }

    public String getMem() {
        try {
            Object a = C1991m.m7449a().m7464m().m7417a("sysMem");
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        String str = BuildConfig.FLAVOR;
        try {
            long availableInternalMemorySize = getAvailableInternalMemorySize();
            str = availableInternalMemorySize + Constants.ACCEPT_TIME_SEPARATOR_SP + getAllInternalMemorySize();
            C1991m.m7449a().m7464m().m7421a("sysMem", (Object) str);
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public String getNetType(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            str = "_" + ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            return (networkInfo == null || !networkInfo.isAvailable()) ? (networkInfo2 == null || !networkInfo2.isAvailable()) ? str : UtilityImpl.NET_TYPE_WIFI + str : networkInfo.getExtraInfo() + str;
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = str;
            C1989j.m7430a().m7439e(th);
            return str2;
        }
    }

    public int getNetworkCatagory(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return 100;
                }
                if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                            return 1;
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        case SpdyProtocol.QUIC /*4*/:
                        case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                        case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                            return 2;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                        case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                        case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                            return 3;
                        default:
                            return (subtypeName == null || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getNetworkOperator(Context context) {
        try {
            if (TextUtils.isEmpty(this.f6964j)) {
                this.f6964j = C1991m.m7449a().m7464m().m7422b(((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            }
            return this.f6964j;
        } catch (Exception e) {
            return this.f6964j;
        }
    }

    public String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(this.f6963i)) {
            try {
                IXAdCommonUtils m = C1991m.m7449a().m7464m();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Object simOperatorName = telephonyManager.getSimOperatorName();
                StringBuilder stringBuilder = new StringBuilder();
                if (TextUtils.isEmpty(simOperatorName)) {
                    simOperatorName = telephonyManager.getNetworkOperatorName();
                    if (TextUtils.isEmpty(simOperatorName)) {
                        return BuildConfig.FLAVOR;
                    }
                    stringBuilder.append(simOperatorName);
                } else {
                    stringBuilder.append(simOperatorName);
                }
                stringBuilder.append("_");
                Object simOperator = telephonyManager.getSimOperator();
                if (!TextUtils.isEmpty(simOperator)) {
                    stringBuilder.append(simOperator);
                }
                if (stringBuilder.length() > 1) {
                    this.f6963i = m.getTextEncoder(stringBuilder.toString());
                }
            } catch (Exception e) {
                C1991m.m7449a().m7457f().m7400e("Get operator failed", BuildConfig.FLAVOR);
            }
        }
        return this.f6963i;
    }

    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public String getNetworkType(Context context) {
        Exception e;
        String str = PushBuildConfig.sdk_conf_debug_level;
        String str2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return str;
            }
            if (activeNetworkInfo.getType() == 1) {
                return UtilityImpl.NET_TYPE_WIFI;
            }
            str2 = UtilityImpl.NET_TYPE_UNKNOWN;
            try {
                return activeNetworkInfo.getSubtypeName() != null ? activeNetworkInfo.getSubtypeName().toLowerCase() : str2;
            } catch (Exception e2) {
                e = e2;
                C1991m.m7449a().m7457f().m7404i(e);
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str;
            e = exception;
            C1991m.m7449a().m7457f().m7404i(e);
            return str2;
        }
    }

    public String getPhoneOSBrand() {
        return C1991m.m7449a().m7464m().m7422b(Build.BRAND);
    }

    public String getPhoneOSBuildVersionSdk() {
        return C1991m.m7449a().m7464m().m7422b(VERSION.SDK);
    }

    public String getSn(Context context) {
        try {
            if (TextUtils.isEmpty(this.f6958d)) {
                String imei = getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = getMacAddress(context);
                }
                this.f6958d = C1991m.m7449a().m7464m().m7422b(imei);
            }
            return this.f6958d;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public List<String[]> getWIFI(Context context) {
        int i = 0;
        IXAdCommonUtils m = C1991m.m7449a().m7464m();
        try {
            Object a = ((C1982d) m).m7417a(UtilityImpl.NET_TYPE_WIFI);
            if (a != null) {
                return (List) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        List<String[]> arrayList = new ArrayList();
        try {
            if (m.hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
                if (wifiManager.isWifiEnabled()) {
                    List scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new C1994p(this));
                    while (i < scanResults.size() && i < 5) {
                        String toLowerCase = ((ScanResult) scanResults.get(i)).BSSID.replace(":", BuildConfig.FLAVOR).toLowerCase(Locale.getDefault());
                        arrayList.add(new String[]{toLowerCase, Math.abs(r1.level) + BuildConfig.FLAVOR});
                        i++;
                    }
                }
            }
        } catch (Throwable e2) {
            C1989j.m7430a().m7439e(e2);
        }
        ((C1982d) m).m7421a(UtilityImpl.NET_TYPE_WIFI, (Object) arrayList);
        return arrayList;
    }

    public String getWifiConnected(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            if (C1991m.m7449a().m7464m().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
                String ssid = connectionInfo.getSSID();
                if (ssid == null) {
                    ssid = BuildConfig.FLAVOR;
                } else if (ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                    ssid = ssid.substring(1, ssid.length() - 1);
                }
                return connectionInfo.getBSSID() + "|" + C1991m.m7449a().m7456e().encode(ssid);
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
        return str;
    }

    public JSONArray getWifiScans(Context context) {
        try {
            Object a = C1991m.m7449a().m7464m().m7417a("wifiScans");
            if (a != null) {
                return (JSONArray) a;
            }
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (C1991m.m7449a().m7464m().hasPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
                if (wifiManager.isWifiEnabled()) {
                    List scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new C1995q(this));
                    int i = 0;
                    while (i < scanResults.size() && i < 50) {
                        ScanResult scanResult = (ScanResult) scanResults.get(i);
                        jSONArray.put(scanResult.BSSID + "|" + C1991m.m7449a().m7456e().encode(scanResult.SSID));
                        i++;
                    }
                }
            }
        } catch (Throwable e2) {
            C1991m.m7449a().m7457f().m7395d(e2);
        }
        C1991m.m7449a().m7464m().m7421a("wifiScans", (Object) jSONArray);
        return jSONArray;
    }

    public Boolean is3GConnected(Context context) {
        return m7470a(context, 0);
    }

    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7394d("isCurrentNetworkAvailable", e);
            return false;
        }
    }

    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean isUseOldStoragePath() {
        return VERSION.SDK_INT < 23;
    }

    public Boolean isWifiConnected(Context context) {
        return m7470a(context, 1);
    }
}
