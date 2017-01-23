package com.antutu.benchmark.p047k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.antutu.ABenchMark.C1082R;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.jni;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.k.b */
public class C1516b {
    public static String f5191a;
    private static String f5192b;
    private static String f5193c;
    private static String f5194d;
    private static String f5195e;
    private static String f5196f;
    private static String f5197g;
    private static String f5198h;
    private static boolean f5199i;
    private static boolean f5200j;
    private static int f5201k;
    private static int f5202l;

    static {
        f5191a = BuildConfig.FLAVOR;
        f5192b = null;
        f5193c = null;
        f5194d = null;
        f5195e = null;
        f5196f = null;
        f5197g = null;
        f5198h = null;
        f5199i = true;
        f5200j = false;
    }

    private static long m6007a(String[] strArr) {
        long parseLong = Long.parseLong(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            long parseLong2 = Long.parseLong(strArr[i]);
            if (parseLong2 > parseLong) {
                parseLong = parseLong2;
            }
        }
        return parseLong;
    }

    public static void m6008a(int i) {
        f5201k = i;
    }

    public static void m6009a(Context context) {
        try {
            String b = C1516b.m6015b(context);
            f5191a = b;
            File file = new File(Environment.getExternalStorageDirectory() + "/.antutu/benchmark/");
            if (!file.exists()) {
                file.mkdirs();
            }
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setUrl(b);
            downloadInfos.setCancelDialogStyle(1);
            downloadInfos.setCancelDialogContent(context.getString(C1082R.string.cancel_download_canot_test));
            DownloadsService.startDownload(context, downloadInfos);
        } catch (Exception e) {
        }
    }

    public static void m6010a(Context context, int i) {
        try {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putInt("hide_icon", i);
            edit.apply();
        } catch (Exception e) {
        }
    }

    public static void m6011a(String str) {
        f5197g = str;
    }

    public static void m6012a(boolean z) {
        f5199i = z;
    }

    public static boolean m6013a() {
        return f5192b == null && f5193c == null;
    }

    private static long m6014b(String[] strArr) {
        long parseLong = Long.parseLong(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            long parseLong2 = Long.parseLong(strArr[i]);
            if (parseLong2 < parseLong) {
                parseLong = parseLong2;
            }
        }
        return parseLong;
    }

    public static String m6015b(Context context) {
        Throwable th;
        String str = null;
        LineNumberReader lineNumberReader;
        try {
            lineNumberReader = new LineNumberReader(new InputStreamReader(context.getAssets().open("resuri")));
            try {
                str = lineNumberReader.readLine();
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            lineNumberReader = str;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            lineNumberReader = str;
            th = th4;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            throw th;
        }
        return str;
    }

    public static void m6016b(int i) {
        f5202l = i;
    }

    public static void m6017b(Context context, int i) {
        try {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putInt("load_type_3d", i);
            edit.apply();
        } catch (Exception e) {
        }
    }

    public static void m6018b(String str) {
        f5196f = str;
    }

    public static boolean m6019b() {
        return f5195e == null;
    }

    public static String m6020c() {
        return f5197g;
    }

    public static void m6021c(String str) {
        f5195e = str;
    }

    public static boolean m6022c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getApplicationInfo("com.antutu.benchmark.full", SpdyProtocol.SLIGHTSSLV2) == null) {
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo("com.antutu.benchmark.full", 64);
            return packageInfo.versionCode >= 6000400 && jni.checkPackage(packageInfo.signatures[0].toCharsString()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static int m6023d() {
        return f5201k;
    }

    public static int m6024d(Context context) {
        int i = 0;
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            i = defaultSharedPreferences.getInt("hide_icon", 0);
            Editor edit = defaultSharedPreferences.edit();
            edit.putInt("hide_icon", 0);
            edit.apply();
            return i;
        } catch (Exception e) {
            return i;
        }
    }

    public static void m6025d(String str) {
        f5192b = str;
    }

    public static int m6026e() {
        return f5202l;
    }

    public static int m6027e(Context context) {
        int i = 0;
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            i = defaultSharedPreferences.getInt("load_type_3d", 0);
            Editor edit = defaultSharedPreferences.edit();
            edit.putInt("load_type_3d", 0);
            edit.apply();
            return i;
        } catch (Exception e) {
            return i;
        }
    }

    public static void m6028e(String str) {
        f5193c = str;
    }

    public static String m6029f() {
        return f5196f;
    }

    public static void m6030f(String str) {
        f5194d = str;
        f5200j = false;
        try {
            if (str.trim().toLowerCase().startsWith("opengl es 3.0")) {
                f5200j = true;
            }
        } catch (Exception e) {
        }
    }

    public static String m6031g() {
        return f5198h;
    }

    public static boolean m6032g(String str) {
        return str.equals("com.antutu.benchmark.full");
    }

    private static LineNumberReader m6033h(String str) {
        try {
            return new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
        } catch (Exception e) {
            return null;
        }
    }

    public static String m6034h() {
        return f5195e;
    }

    public static String m6035i() {
        return f5192b;
    }

    public static String m6036j() {
        return f5193c;
    }

    public static String m6037k() {
        return f5194d;
    }

    public static void m6038l() {
        try {
            String[] strArr;
            Object valueOf;
            LineNumberReader h = C1516b.m6033h("/sys/devices/virtual/kgsl/kgsl/subsystem/kgsl-3d0/max_gpuclk");
            String[] strArr2 = null;
            for (int i = 1; i < 10; i++) {
                strArr2 = h.readLine().split(" ");
                if (Long.parseLong(strArr2[0]) > 1) {
                    strArr = strArr2;
                    break;
                }
            }
            strArr = strArr2;
            String str = BuildConfig.FLAVOR;
            h = C1516b.m6033h("/sys/devices/virtual/kgsl/kgsl/subsystem/kgsl-3d0/gpu_available_frequencies");
            String[] strArr3 = null;
            for (int i2 = 0; i2 < 10; i2++) {
                strArr3 = h.readLine().split(" ");
                if (Long.parseLong(strArr3[0]) > 1) {
                    break;
                }
            }
            long b = (C1516b.m6014b(strArr) / 1000) / 1000;
            long a = (C1516b.m6007a(strArr) / 1000) / 1000;
            long b2 = (C1516b.m6014b(strArr3) / 1000) / 1000;
            long a2 = (C1516b.m6007a(strArr3) / 1000) / 1000;
            if (b < b2) {
                valueOf = String.valueOf(b);
            } else {
                str = String.valueOf(b2);
            }
            String valueOf2 = a < a2 ? String.valueOf(a2) : String.valueOf(a);
            f5198h = String.format("%sMHz~%sMHz", new Object[]{valueOf, valueOf2});
        } catch (FileNotFoundException e) {
            f5198h = null;
        } catch (Exception e2) {
            f5198h = null;
        }
    }
}
