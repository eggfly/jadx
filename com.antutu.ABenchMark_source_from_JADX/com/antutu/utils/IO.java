package com.antutu.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import com.antutu.benchmark.C1372c;
import com.antutu.benchmark.C1372c.C1343a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.message.MessageService;

public class IO {
    private static final int testDataNumber = 300;

    private static class DiskInfo {
        private String path;

        private DiskInfo() {
        }

        public boolean hasDisk(String str) {
            try {
                if (this.path.equals(str)) {
                    return true;
                }
            } catch (Exception e) {
            }
            return false;
        }

        public void setInfo(String str) {
            this.path = str;
        }
    }

    public static double GetSDCardAvailableSize() {
        return getAvaliableSize(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public static double GetSDCardExAvailableSize() {
        List p = C1503b.m5915c().m5963p();
        return p.size() > 1 ? getAvaliableSize((String) p.get(1)) : 0.0d;
    }

    public static double GetSDCardExTotalSize() {
        return getTotalSize(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public static double GetSDCardTotalSize() {
        return getTotalSize(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    private static double getAvaliableSize(String str) {
        StatFs statFs = new StatFs(str);
        return ((double) ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 1024.0d;
    }

    public static String getCPURev() {
        String str = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/sys/devices/soc0/revision")));
            String readLine = lineNumberReader.readLine();
            lineNumberReader.close();
            String trim = readLine.trim();
            if (!trim.isEmpty()) {
                str = "#$" + trim + "$#";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private static List<DiskInfo> getDisksSize(Context context) {
        List<DiskInfo> arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            dataOutputStream.writeBytes("df\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            dataOutputStream.close();
            exec.waitFor();
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            String readLine;
            do {
                readLine = dataInputStream.readLine();
                if (readLine != null && readLine.length() > 10) {
                    DiskInfo diskInfo;
                    if (readLine.startsWith("/mnt/")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf < 0) {
                            indexOf = readLine.indexOf("   ");
                        }
                        if (indexOf > 0) {
                            String substring = readLine.substring(0, indexOf);
                            diskInfo = new DiskInfo();
                            diskInfo.setInfo(substring);
                            arrayList.add(diskInfo);
                            continue;
                        } else {
                            continue;
                        }
                    } else {
                        String[] split = readLine.trim().split("\\s+");
                        if (split.length == 5) {
                            diskInfo = new DiskInfo();
                            diskInfo.setInfo(split[4]);
                            arrayList.add(diskInfo);
                            continue;
                        } else if (split.length == 6) {
                            diskInfo = new DiskInfo();
                            diskInfo.setInfo(split[5]);
                            arrayList.add(diskInfo);
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            } while (readLine != null);
        } catch (Exception e) {
        }
        return arrayList;
    }

    public static String getJaonStr(Context context) {
        return getJaonStr(context, false);
    }

    public static String getJaonStr(Context context, boolean z) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String readLine;
        String str8 = BuildConfig.FLAVOR;
        String str9 = BuildConfig.FLAVOR;
        try {
            C1372c.m5438a(context);
            C1343a a = C1372c.m5437a();
            if (a.m5407c() > 0) {
                str8 = a.m5402a() + "x" + a.m5405b();
            }
            a = C1372c.m5439b();
            if (a.m5407c() > 0) {
                str9 = a.m5402a() + "x" + a.m5405b();
            }
            str = str8;
            str8 = str9;
        } catch (Exception e) {
            str = str8;
            str8 = str9;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        double d = 0.0d;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            i2 = (int) ((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) >> 10);
            statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            i4 = (int) ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) >> 10);
            i3 = getRamTotalSize();
            d = GetSDCardTotalSize();
            i = i2;
            i2 = i3;
            i3 = i4;
        } catch (Exception e2) {
            i = i2;
            i2 = i3;
            i3 = i4;
        }
        int minSet = jni.getMinSet();
        i4 = jni.getMaxSet();
        int minDef = minSet == 0 ? jni.getMinDef() : minSet;
        minSet = i4 == 0 ? jni.getMaxDef() : i4;
        String str10 = BuildConfig.FLAVOR;
        String str11 = BuildConfig.FLAVOR;
        try {
            str9 = BuildConfig.FLAVOR;
            str2 = BuildConfig.FLAVOR;
            str3 = BuildConfig.FLAVOR;
            str4 = BuildConfig.FLAVOR;
            str5 = BuildConfig.FLAVOR;
            str6 = BuildConfig.FLAVOR;
            str7 = BuildConfig.FLAVOR;
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            str9 = str7;
            str7 = str6;
            str6 = str5;
            str5 = str4;
            str4 = str3;
            str3 = str2;
            for (int i5 = 1; i5 < 100; i5++) {
                readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.indexOf("Hardware") > -1) {
                    str11 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    break;
                }
                if (readLine.indexOf("vendor_id") > -1) {
                    str3 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (str3.equals("GenuineIntel")) {
                    if (readLine.indexOf("model name") > -1) {
                        str11 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        break;
                    }
                }
                if (readLine.indexOf("CPU implementer") > -1) {
                    str4 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.indexOf("CPU architecture") > -1) {
                    str5 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.indexOf("CPU variant") > -1) {
                    str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.indexOf("CPU part") > -1) {
                    str7 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.indexOf("CPU revision") > -1) {
                    str9 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
            }
            str10 = str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str7 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str9;
        } catch (Exception e3) {
            str11 = str11;
        }
        String cPURev = getCPURev();
        str9 = BuildConfig.FLAVOR;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str9 = defaultAdapter.getAddress();
            }
            str7 = str9;
        } catch (Exception e4) {
            str7 = str9;
        }
        str6 = BuildConfig.FLAVOR;
        try {
            str6 = ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress();
        } catch (Exception e5) {
        }
        str4 = BuildConfig.FLAVOR;
        str5 = BuildConfig.FLAVOR;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                str4 = activeNetworkInfo.getTypeName();
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            str9 = (networkInfo == null || !networkInfo.isAvailable()) ? str5 : networkInfo.getSubtypeName();
            str5 = str9;
        } catch (Exception e6) {
            str4 = str4;
        }
        str3 = BuildConfig.FLAVOR;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str3 = telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperatorName() : str3;
        } catch (Exception e7) {
        }
        str2 = BuildConfig.FLAVOR;
        try {
            List sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1);
            int i6 = 0;
            while (i6 < sensorList.size()) {
                str9 = str2 + ((Sensor) sensorList.get(i6)).getName();
                try {
                    if (i6 < sensorList.size() - 1) {
                        str9 = str9 + "||";
                    }
                    i6++;
                    str2 = str9;
                } catch (Exception e8) {
                }
            }
            str9 = str2;
        } catch (Exception e9) {
            str9 = str2;
        }
        readLine = BuildConfig.FLAVOR;
        try {
            str2 = context.getResources().getConfiguration().locale.getLanguage();
            readLine = context.getResources().getConfiguration().locale.getCountry();
            if (readLine.length() >= 2) {
                str2 = readLine;
            }
        } catch (Exception e10) {
            str2 = readLine;
        }
        C1503b c = C1503b.m5915c();
        String str12 = "\"lang\":\"";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\",";
        str12 = "\"backcamera\":\"";
        str8 = (((((((((((((((((((((((((((((((((((BuildConfig.FLAVOR + "\"version_app\":\"" + c.m5958m() + "\",") + "\"brand\":\"" + Build.BRAND + "\",") + "\"model\":\"" + Build.MODEL + "\",") + "\"device\":\"" + Build.DEVICE + "\",") + "\"cpuid\":\"" + str10 + "\",") + "\"cpuCount\":\"" + jni.getCpuCount() + "\",") + r24 + str2 + str2) + "\"oemid\":\"" + c.m5954k() + str2) + "\"duid\":\"" + c.m5962o() + str2) + "\"imei\":\"" + c.m5925a(context, false) + str2) + "\"glVendor\":\"" + C1516b.m6035i() + str2) + "\"glRenderer\":\"" + C1516b.m6036j() + str2) + "\"glVersion\":\"" + C1516b.m6037k() + str2) + "\"glType\":\"" + C1516b.m6031g() + str2) + "\"dpi\":\"" + C1516b.m6029f() + str2) + "\"str1\":\"" + C1516b.m6020c() + str2) + "\"str3\":\"" + c.m5949h() + str2) + "\"resolution\":\"" + C1516b.m6034h() + str2) + "\"product\":\"" + Build.PRODUCT + str2) + "\"manufacturer\":\"" + Build.MANUFACTURER + str2) + "\"androidver\":\"" + VERSION.RELEASE + str2) + str2 + str + "\",") + "\"frontcamera\":\"" + str8 + "\",") + "\"cpuHW\":\"" + str11 + cPURev + "\",") + "\"memory\":\"" + i2 + "\",") + "\"phonememory\":\"" + i + "\",") + "\"internalsdcard\":\"" + d + "\",") + "\"romSize\":\"" + i3 + "\",") + "\"cpuMin\":\"" + minDef + "\",") + "\"cpuMax\":\"" + minSet + "\",") + "\"sp\":\"" + str3 + "\",") + "\"mode\":\"" + str5 + "\",") + "\"network\":\"" + str4 + "\",") + "\"wlanmac\":\"" + str6 + "\",") + "\"bluetoothmac\":\"" + str7 + "\",") + "\"sys64bit\":\"" + c.m5948g() + "\",";
        if (z) {
            return str8;
        }
        return ((str8 + "\"rom\":\"" + Build.DISPLAY + "\",") + "\"fingerprint\":\"" + Build.FINGERPRINT + "\",") + "\"sensors\":\"" + str9 + "\",";
    }

    public static int getRamTotalSize() {
        int i = 0;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/meminfo")));
            int i2 = 1;
            while (i2 < 10) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.indexOf("MemTotal") > -1) {
                    String trim = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    i = Integer.valueOf(trim.substring(0, trim.indexOf(" ")).trim()).intValue();
                    break;
                } else {
                    i2++;
                }
            }
            lineNumberReader.close();
        } catch (Exception e) {
        }
        return i;
    }

    public static List<String> getSDPaths(Context context) {
        File file;
        List<String> arrayList = new ArrayList();
        try {
            file = new File(IXAdIOUtils.DEFAULT_SD_CARD_PATH);
            if (file.isDirectory() && file.exists()) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception e) {
        }
        try {
            List<DiskInfo> disksSize = getDisksSize(context);
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/etc/vold.fstab")));
                for (int i = 1; i < 100; i++) {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    try {
                        readLine = readLine.trim();
                        if (readLine.startsWith("dev_mount")) {
                            String[] split = readLine.split(" ");
                            if (split.length > 3 && !arrayList.contains(split[2])) {
                                File file2 = new File(split[2]);
                                if (file2.isDirectory() && file2.exists()) {
                                    String absolutePath = file2.getAbsolutePath();
                                    StatFs statFs = new StatFs(absolutePath);
                                    if (statFs != null && statFs.getBlockCount() > 0) {
                                        for (DiskInfo hasDisk : disksSize) {
                                            if (hasDisk.hasDisk(absolutePath)) {
                                                arrayList.add(absolutePath);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
                lineNumberReader.close();
            } catch (Exception e3) {
            }
            file = new File("/Removable/MicroSD");
            if (file.isDirectory() && file.exists()) {
                arrayList.remove("/Removable/MicroSD");
                arrayList.add("/Removable/MicroSD");
            }
            if (arrayList.size() < 1) {
                arrayList.add(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
        } catch (Exception e4) {
        }
        return arrayList;
    }

    public static String getString(Context context, String str, String str2) {
        String str3 = BuildConfig.FLAVOR;
        String str4 = BuildConfig.FLAVOR;
        String str5 = BuildConfig.FLAVOR;
        String str6 = BuildConfig.FLAVOR;
        String str7 = BuildConfig.FLAVOR;
        String str8 = BuildConfig.FLAVOR;
        String str9 = BuildConfig.FLAVOR;
        String str10 = BuildConfig.FLAVOR;
        String str11 = BuildConfig.FLAVOR;
        String str12 = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            str5 = str12;
            str12 = str11;
            str11 = str10;
            str10 = str9;
            str9 = str8;
            str8 = str7;
            int i = 1;
            while (i < 100) {
                String readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    if (readLine.indexOf("Hardware") <= -1) {
                        if (readLine.indexOf("vendor_id") > -1) {
                            str8 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (str8.equals("GenuineIntel") && readLine.indexOf("model name") > -1) {
                            str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            break;
                        }
                        if (readLine.indexOf("CPU implementer") > -1) {
                            str9 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (readLine.indexOf("CPU architecture") > -1) {
                            str10 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (readLine.indexOf("CPU variant") > -1) {
                            str11 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (readLine.indexOf("CPU part") > -1) {
                            str12 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (readLine.indexOf("CPU revision") > -1) {
                            str5 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        i++;
                    } else {
                        str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        break;
                    }
                }
                break;
            }
            str5 = str9 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str10 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str11 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str12 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
            str10 = str6;
            str9 = str5;
        } catch (Exception e) {
            str10 = str6;
            str9 = str3;
        }
        try {
            C1343a a = C1372c.m5437a();
            str5 = a.m5402a() + "x" + a.m5405b();
        } catch (Exception e2) {
            str5 = str4;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            i2 = (int) ((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) >> 10);
            statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            i4 = (int) ((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) >> 10);
            i3 = getRamTotalSize();
        } catch (Exception e3) {
        }
        str8 = getCPURev();
        int minSet = jni.getMinSet();
        int maxSet = jni.getMaxSet();
        if (minSet == 0) {
            minSet = jni.getMinDef();
        }
        if (maxSet == 0) {
            maxSet = jni.getMaxDef();
        }
        StringBuilder append = new StringBuilder().append("&model=");
        if (str.length() <= 1) {
            str = Build.MODEL;
        }
        append = new StringBuilder().append(append.append(str).toString()).append("&brand=");
        if (str2.length() <= 1) {
            str2 = Build.BRAND;
        }
        str6 = (((((((((append.append(str2).toString() + "&product=" + Build.PRODUCT) + "&device=" + Build.DEVICE) + "&manufacturer=" + Build.MANUFACTURER) + "&version=" + VERSION.RELEASE) + "&resolution=" + C1516b.m6034h()) + "&ramsize=" + i3) + "&memsize=" + i2) + "&int6=" + i4) + "&cpuMin=" + minSet) + "&cpuMax=" + maxSet;
        i4 = 0;
        try {
            i4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode / 10;
        } catch (Exception e4) {
        }
        str5 = ((((("v=" + i4) + "&str1=" + str9) + "&camera=" + str5) + "&cpuhw=" + str10 + str8) + "&rom=" + Build.DISPLAY) + "&fingerprint=" + Build.FINGERPRINT;
        try {
            str5 = str5 + "&int2=" + isSystemAPK(context);
        } catch (Exception e5) {
        }
        str6 = str5 + str6;
        str5 = context.getResources().getConfiguration().locale.getLanguage();
        str4 = context.getResources().getConfiguration().locale.getCountry();
        if (str4.length() >= 2) {
            str5 = str4;
        }
        return (str6 + "&lang=" + str5) + "&imei=" + ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    private static double getTotalSize(String str) {
        StatFs statFs = new StatFs(str);
        return ((double) ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 1024.0d;
    }

    public static String isSystemAPK(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & 1) != 0 && packageInfo.packageName.equals("com.antutu.ABenchMark")) {
                return MessageService.MSG_DB_NOTIFY_REACHED;
            }
        }
        return MessageService.MSG_DB_READY_REPORT;
    }

    public static String readLine(String str) {
        String str2 = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
            str2 = lineNumberReader.readLine();
            lineNumberReader.close();
            return str2;
        } catch (IOException e) {
            return MessageService.MSG_DB_READY_REPORT;
        }
    }
}
