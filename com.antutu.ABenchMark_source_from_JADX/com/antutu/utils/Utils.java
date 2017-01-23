package com.antutu.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.model.C1534l;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.handmark.pulltorefresh.library.C3628R;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

public class Utils {
    public static int DATA_FAILED;
    public static int DATA_SUC;
    public static int NO_NETWORK;
    public static int TIMEOUT_LOADDATA;
    public static int TIMEOUT_TIME;
    private static String macAddress;

    static {
        TIMEOUT_TIME = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
        TIMEOUT_LOADDATA = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
        NO_NETWORK = 4;
        DATA_SUC = 1;
        DATA_FAILED = 2;
        macAddress = null;
    }

    public static boolean Assets2File(Context context, String str, String str2) {
        return Assets2File(context, str, str2, true);
    }

    public static boolean Assets2File(Context context, String str, String str2, boolean z) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                if (!z) {
                    return true;
                }
                if (!file.delete()) {
                    return false;
                }
            }
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String SHA1(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("utf-8"), 0, str.length());
            return convertToHex(instance.digest());
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static byte[] bmpToByteArray2(Bitmap bitmap, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
        }
        return toByteArray;
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        String str = BuildConfig.FLAVOR;
        StringBuffer stringBuffer2 = stringBuffer;
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & MotionEventCompat.ACTION_MASK);
            stringBuffer2 = toHexString.length() == 1 ? stringBuffer2.append(MessageService.MSG_DB_READY_REPORT).append(toHexString) : stringBuffer2.append(toHexString);
        }
        return String.valueOf(stringBuffer2);
    }

    public static boolean checkPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    private static String convertToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = (b >>> 4) & 15;
            int i2 = 0;
            while (true) {
                char c = (i < 0 || i > 9) ? (char) ((i - 10) + 97) : (char) (i + 48);
                stringBuilder.append(c);
                int i3 = b & 15;
                i = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i;
                i = i3;
            }
        }
        return stringBuilder.toString();
    }

    public static String decode(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        try {
            return jni.getStringSafe(str2.substring(0, str2.length() - 8), (str2.substring(str2.length() - 8, str2.length()) + str).substring(4, 12));
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static float dpToPx(Context context, float f) {
        return context == null ? -1.0f : context.getResources().getDisplayMetrics().density * f;
    }

    public static int dpToPxInt(Context context, float f) {
        return (int) (dpToPx(context, f) + 0.5f);
    }

    @TargetApi(11)
    public static void enableStrictMode() {
        if (hasGingerbread()) {
            Builder penaltyLog = new Builder().detectAll().penaltyLog();
            VmPolicy.Builder penaltyLog2 = new VmPolicy.Builder().detectAll().penaltyLog();
            if (hasHoneycomb()) {
                penaltyLog.penaltyFlashScreen();
            }
            StrictMode.setThreadPolicy(penaltyLog.build());
            StrictMode.setVmPolicy(penaltyLog2.build());
        }
    }

    private static String encode(String str) {
        return str == null ? null : URLEncoder.encode(str);
    }

    public static int getAdVersion(Context context) {
        int i = 6;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode / 1000000;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static int getAvatarid(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return C1082R.drawable.pic_1;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C1082R.drawable.pic_2;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return C1082R.drawable.pic_3;
            case SpdyProtocol.QUIC /*4*/:
                return C1082R.drawable.pic_4;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return C1082R.drawable.pic_5;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return C1082R.drawable.pic_6;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return C1082R.drawable.pic_7;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return C1082R.drawable.pic_8;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return C1082R.drawable.pic_9;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return C1082R.drawable.pic_10;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return C1082R.drawable.pic_11;
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return C1082R.drawable.pic_12;
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return C1082R.drawable.pic_13;
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return C1082R.drawable.pic_14;
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return C1082R.drawable.pic_15;
            default:
                return -1;
        }
    }

    public static byte[] getBitmapBytes(Bitmap bitmap, boolean z) {
        int width;
        int width2;
        byte[] toByteArray;
        Bitmap createBitmap = Bitmap.createBitmap(80, 80, Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        if (bitmap.getHeight() >= bitmap.getWidth()) {
            width = bitmap.getWidth();
            width2 = bitmap.getWidth();
        } else {
            width = bitmap.getHeight();
            width2 = bitmap.getHeight();
        }
        while (true) {
            canvas.drawBitmap(bitmap, new Rect(0, 0, width, width2), new Rect(0, 0, 80, 80), null);
            if (z) {
                bitmap.recycle();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            createBitmap.recycle();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                break;
            } catch (Exception e) {
                System.out.print(e);
                width = bitmap.getHeight();
                width2 = bitmap.getHeight();
            }
        }
        return toByteArray;
    }

    private static long getCPUFreq(int i, boolean z) {
        String[] split;
        long parseLong;
        String str = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
        String str2 = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq";
        String str3 = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_max_freq";
        String str4 = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_min_freq";
        String str5 = BuildConfig.FLAVOR;
        str5 = BuildConfig.FLAVOR;
        if (z) {
            str4 = str;
        } else {
            str3 = str4;
            str4 = str2;
        }
        try {
            str3 = readFully(new ProcessBuilder(new String[]{"/system/bin/cat", str3}).start().getInputStream());
            long readSystemFileAsInt;
            if (BuildConfig.FLAVOR.equals(str3)) {
                readSystemFileAsInt = (long) readSystemFileAsInt(str4);
                if (readSystemFileAsInt > 0) {
                    return readSystemFileAsInt;
                }
                try {
                    split = readFully(new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_available_frequencies"}).start().getInputStream()).split(" ");
                    return z ? Long.parseLong(split[split.length - 1]) : Long.parseLong(split[0]);
                } catch (Exception e) {
                    split = readFully2(new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpufreq/stats/cpu" + i + "/time_in_state"}).start().getInputStream()).split("\n");
                    return Long.parseLong((z ? split[split.length - 1] : split[0]).split(" ")[0]);
                }
            }
            try {
                parseLong = Long.parseLong(str3);
            } catch (Exception e2) {
                parseLong = 0;
            }
            try {
                split = readFully(new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_available_frequencies"}).start().getInputStream()).split(" ");
                if (split.length <= 1) {
                    return parseLong;
                }
                long parseLong2 = Long.parseLong(split[0]);
                readSystemFileAsInt = Long.parseLong(split[split.length - 1]);
                return z ? readSystemFileAsInt <= 0 ? parseLong : readSystemFileAsInt : parseLong2 > 0 ? parseLong2 : parseLong;
            } catch (Exception e3) {
                return parseLong;
            }
        } catch (Exception e4) {
            return 0;
        }
    }

    public static long getCPUFreqMTK(boolean z, boolean z2) {
        int i;
        try {
            String str = "/proc/cpufreq/MT_CPU_DVFS_BIG/cpufreq_oppidx";
            if (!z2) {
                str = "/proc/cpufreq/MT_CPU_DVFS_LITTLE/cpufreq_oppidx";
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
            List arrayList = new ArrayList();
            Pattern compile = Pattern.compile("^\\s+OP\\((\\d+),\\s+\\d+\\)");
            for (i = 1; i < 100; i++) {
                CharSequence readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                Matcher matcher = compile.matcher(readLine);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(1);
                        if (!(group == null || group.isEmpty())) {
                            int intValue = Integer.valueOf(group).intValue();
                            if (intValue > 100) {
                                arrayList.add(Integer.valueOf(intValue));
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
            lineNumberReader.close();
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
                i = z ? ((Integer) arrayList.get(arrayList.size() - 1)).intValue() : ((Integer) arrayList.get(0)).intValue();
            } else {
                i = 0;
            }
        } catch (Exception e2) {
            i = 0;
        }
        return (long) i;
    }

    public static long getCPUFrequency(boolean z) {
        long cPUFreqMTK = getCPUFreqMTK(z, true);
        if (cPUFreqMTK <= 0) {
            cPUFreqMTK = getCPUFreq(0, z);
            if (cPUFreqMTK > 0) {
                try {
                    int cpuCount = jni.getCpuCount();
                    int i = 1;
                    while (i < cpuCount) {
                        long cPUFreq = getCPUFreq(i, z);
                        if ((cPUFreq <= cPUFreqMTK || !z) && (cPUFreq <= 0 || cPUFreq >= cPUFreqMTK || z)) {
                            cPUFreq = cPUFreqMTK;
                        }
                        i++;
                        cPUFreqMTK = cPUFreq;
                    }
                } catch (Exception e) {
                }
            }
        }
        return cPUFreqMTK;
    }

    public static String getCPUSerial() {
        String strCpuId = getStrCpuId();
        return strCpuId == null ? "0000000000000000" : strCpuId;
    }

    public static int getCpuNum() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String getDevHardSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) ABenchmarkApplication.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return String.valueOf(new BigDecimal(Math.sqrt(Math.pow((double) displayMetrics.widthPixels, 2.0d) + Math.pow((double) displayMetrics.heightPixels, 2.0d)) / ((double) displayMetrics.ydpi)).setScale(2, 4).doubleValue());
    }

    public static String getDevHardSize(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) ABenchmarkApplication.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return String.valueOf(new BigDecimal(Math.sqrt(Math.pow((double) displayMetrics.widthPixels, 2.0d) + Math.pow((double) displayMetrics.heightPixels, 2.0d)) / ((double) displayMetrics.ydpi)).setScale(i, 4).doubleValue());
    }

    public static final String getEightKey() {
        char[] cArr = new char[8];
        for (int i = 0; i < 8; i++) {
            cArr[i] = (char) (((int) (Math.random() * 26.0d)) + 97);
        }
        return String.valueOf(cArr);
    }

    public static String getImeiCode(Context context) {
        return C1503b.m5915c().m5925a(context, false);
    }

    public static String getImeiText(Context context) {
        return C1503b.m5915c().m5925a(context, true);
    }

    public static String getLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        if (locale != null) {
            str = locale.getLanguage();
            str2 = locale.getCountry();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            if (str2 == null) {
                str = BuildConfig.FLAVOR;
            }
        }
        return str2.length() < 2 ? str : str2;
    }

    public static int getLanguageID(Context context) {
        try {
            String language = context.getResources().getConfiguration().locale.getLanguage();
            String country = context.getResources().getConfiguration().locale.getCountry();
            return (language == null || !language.contains("zh")) ? 0 : (country == null || country.contains("CN")) ? 1 : 2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            MLog.m6868e("WifiPreference IpAddress", e.toString());
        }
        return null;
    }

    public static String getLocalLanguage(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        return (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "CN" : "TW";
    }

    public static String getLocalLanguageInt(Context context) {
        String str = MessageService.MSG_DB_NOTIFY_CLICK;
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        if (language == null || !language.contains("zh")) {
            return str;
        }
        if (country == null || country.contains("CN")) {
            str = "CN";
        } else {
            str = "TW";
        }
        return MessageService.MSG_DB_NOTIFY_REACHED;
    }

    public static String getLocalLanguageIntZero(Context context) {
        String str = MessageService.MSG_DB_NOTIFY_REACHED;
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        if (language == null || !language.contains("zh")) {
            return str;
        }
        if (country == null || country.contains("CN")) {
            str = "CN";
        } else {
            str = "TW";
        }
        return MessageService.MSG_DB_READY_REPORT;
    }

    public static String getLocalLanguageLower(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        return (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "cn" : "tw";
    }

    public static String getLocalMacAddressFromIp(Context context) {
        String str;
        synchronized (Utils.class) {
            if (macAddress != null) {
                str = macAddress;
            } else {
                str = BuildConfig.FLAVOR;
                try {
                    str = byte2hex(NetworkInterface.getByInetAddress(InetAddress.getByName(getLocalIpAddress())).getHardwareAddress());
                } catch (Exception e) {
                }
                macAddress = str;
            }
        }
        return str;
    }

    public static void getPermission(Activity activity, String str) {
        if (!checkPermission(activity, str) && !ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            ActivityCompat.requestPermissions(activity, new String[]{str}, 0);
        }
    }

    public static void getPermissions(Activity activity, String[] strArr) {
        List arrayList = new ArrayList();
        for (String str : strArr) {
            if (!checkPermission(activity, str) && ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 0);
        }
    }

    public static int getScreenBrightness(Activity activity) {
        try {
            return System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (SettingNotFoundException e) {
            return -1;
        }
    }

    public static final int getScreenHeight(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static final int getScreenWidth(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static String getScretKey(String str, C1534l c1534l) {
        return (str + c1534l.f5342b).substring(4, 12);
    }

    public static String getStrCpuHW() {
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            int i = 1;
            while (i < 100) {
                String readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains("Hardware")) {
                        if (readLine.contains("vendor_id")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (str2.equals("GenuineIntel") && readLine.contains("model name")) {
                            str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            break;
                        }
                        i++;
                    } else {
                        str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        break;
                    }
                }
                break;
            }
            lineNumberReader.close();
        } catch (Exception e) {
        }
        return str;
    }

    public static String getStrCpuId() {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            String str4 = BuildConfig.FLAVOR;
            String str5 = BuildConfig.FLAVOR;
            String str6 = str4;
            str4 = str3;
            str3 = str2;
            str2 = str;
            for (int i = 1; i < 100; i++) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("CPU implementer")) {
                    str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("CPU architecture")) {
                    str3 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("CPU variant")) {
                    str4 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("CPU part")) {
                    str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
                if (readLine.contains("CPU revision")) {
                    str5 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                }
            }
            str5 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
            try {
                lineNumberReader.close();
                return str5;
            } catch (Exception e) {
                return str5;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String getUserInfoEncode(String str, String str2, String str3, int i, String str4, String str5, String str6) {
        return String.format("oldpw=%s&newpw=%s&nickname=%s&gender=%s&imei=%s&mac=%s&token=%s", new Object[]{encode(str), encode(str2), encode(str3), encode(String.valueOf(i)), encode(str4), encode(str5), encode(str6)});
    }

    public static int getVersionCode(String str) {
        try {
            PackageInfo packageInfo = ABenchmarkApplication.getContext().getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionCode : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getVersionCode() {
        try {
            return ABenchmarkApplication.getContext().getPackageManager().getPackageInfo(ABenchmarkApplication.getContext().getPackageName(), 0).versionCode + BuildConfig.FLAVOR;
        } catch (NameNotFoundException e) {
            return MessageService.MSG_DB_READY_REPORT;
        }
    }

    public static boolean hasFroyo() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean hasGingerbread() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean hasJellyBean() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean hasKitKat() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean hasMarket(Context context, Intent intent) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        return queryIntentActivities == null || queryIntentActivities.size() <= 0;
    }

    private boolean isActivityIn(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "MainActivity.class");
        return context.getPackageManager().resolveActivity(intent, 0) == null;
    }

    public static boolean isCn(Context context) {
        return getLocalLanguage(context).equals("CN");
    }

    public static boolean isEmail(String str) {
        String str2 = "^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.compile("^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).find();
    }

    private boolean isFileExist(Context context) {
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? false : activeNetworkInfo.isConnected();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean isPushable(Context context) {
        return Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, true);
    }

    public static boolean isUpdateApp(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            MLog.m6865d("hch", "firstInstallTime:" + packageInfo.firstInstallTime);
            MLog.m6865d("hch", "lastUpdateTime:" + packageInfo.lastUpdateTime);
            MLog.m6865d("hch", "isupdate:" + (packageInfo.firstInstallTime != packageInfo.lastUpdateTime));
            return packageInfo.firstInstallTime != packageInfo.lastUpdateTime;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static float pxToDp(Context context, float f) {
        return context == null ? -1.0f : f / context.getResources().getDisplayMetrics().density;
    }

    public static int pxToDpCeilInt(Context context, float f) {
        return (int) (pxToDp(context, f) + 0.5f);
    }

    public static float pxToSp(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static String readFully(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    public static String readFully2(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            stringBuilder.append("\n" + scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    public static String readStringFromFile(String str) {
        String str2 = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
            String readLine;
            do {
                readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    str2 = str2 + readLine;
                    continue;
                }
            } while (readLine != null);
            lineNumberReader.close();
        } catch (Exception e) {
        }
        return str2;
    }

    public static int readSystemFileAsInt(String str) {
        try {
            return Integer.parseInt(readFully(new ProcessBuilder(new String[]{"/system/bin/cat", str}).start().getInputStream()));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView != null) {
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                int i = 0;
                for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                    View view = adapter.getView(i2, null, listView);
                    view.measure(0, 0);
                    i += view.getMeasuredHeight();
                }
                LayoutParams layoutParams = listView.getLayoutParams();
                layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
                listView.setLayoutParams(layoutParams);
            }
        }
    }

    public static void setScreenBrightness(Activity activity, int i) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = ((float) i) / 255.0f;
        activity.getWindow().setAttributes(attributes);
    }

    @SuppressLint({"NewApi"})
    public static final void setScreenPix(DisplayMetrics displayMetrics, Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        C1516b.m6018b(displayMetrics.densityDpi + BuildConfig.FLAVOR);
        C1516b.m6011a(displayMetrics.ydpi + BuildConfig.FLAVOR);
        C1516b.m6021c(point.x + " x " + point.y);
        C1516b.m6008a(point.x);
        C1516b.m6016b(point.y);
    }

    public static void show(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static int writeStringToFile(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            byte[] bytes = str.getBytes();
            OutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(bytes, 0, bytes.length);
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
}
