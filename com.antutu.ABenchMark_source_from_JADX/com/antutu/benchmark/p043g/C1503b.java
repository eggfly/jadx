package com.antutu.benchmark.p043g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import anet.channel.util.HttpConstant;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.C1372c;
import com.antutu.benchmark.C1372c.C1343a;
import com.antutu.benchmark.p044h.C1510b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.platform.C1545a;
import com.antutu.redacc.C1692R;
import com.antutu.utils.IO;
import com.antutu.utils.Methods;
import com.antutu.utils.SPConstants;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.facebook.ads.AdError;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.g.b */
public class C1503b {
    public static int f5113a;
    private static final C1503b ao;
    public static String f5114b;
    public static boolean f5115c;
    public static boolean f5116d;
    public static boolean f5117e;
    private String f5118A;
    private String f5119B;
    private String f5120C;
    private String f5121D;
    private String f5122E;
    private String f5123F;
    private String f5124G;
    private int f5125H;
    private int f5126I;
    private int f5127J;
    private int f5128K;
    private int f5129L;
    private int f5130M;
    private String f5131N;
    private String f5132O;
    private String f5133P;
    private String f5134Q;
    private String f5135R;
    private String f5136S;
    private String f5137T;
    private List<String> f5138U;
    private String f5139V;
    private String f5140W;
    private String f5141X;
    private String f5142Y;
    private String f5143Z;
    private String aa;
    private String ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private Thread ai;
    private boolean[] aj;
    private boolean ak;
    private int al;
    private boolean am;
    private String an;
    public int f5144f;
    public int f5145g;
    public String f5146h;
    public String f5147i;
    public String f5148j;
    private int f5149k;
    private int f5150l;
    private int f5151m;
    private String f5152n;
    private final String f5153o;
    private int f5154p;
    private int f5155q;
    private String f5156r;
    private String f5157s;
    private String f5158t;
    private String f5159u;
    private int f5160v;
    private int f5161w;
    private String f5162x;
    private String f5163y;
    private String f5164z;

    static {
        f5113a = 31;
        f5114b = "6.0";
        f5115c = false;
        f5116d = false;
        f5117e = true;
        ao = new C1503b();
    }

    private C1503b() {
        this.f5149k = 0;
        this.f5150l = 0;
        this.f5151m = 0;
        this.f5152n = "6000000";
        this.f5153o = "64bit ";
        this.f5144f = 0;
        this.f5145g = 0;
        this.f5154p = 0;
        this.f5155q = 0;
        this.f5160v = 0;
        this.f5161w = 0;
        this.f5146h = BuildConfig.FLAVOR;
        this.f5147i = BuildConfig.FLAVOR;
        this.f5148j = BuildConfig.FLAVOR;
        this.f5162x = BuildConfig.FLAVOR;
        this.f5163y = BuildConfig.FLAVOR;
        this.f5164z = BuildConfig.FLAVOR;
        this.f5118A = BuildConfig.FLAVOR;
        this.f5119B = BuildConfig.FLAVOR;
        this.f5120C = BuildConfig.FLAVOR;
        this.f5121D = BuildConfig.FLAVOR;
        this.f5122E = BuildConfig.FLAVOR;
        this.f5123F = BuildConfig.FLAVOR;
        this.f5124G = BuildConfig.FLAVOR;
        this.f5125H = 0;
        this.f5126I = 0;
        this.f5127J = 0;
        this.f5128K = 0;
        this.f5129L = 1;
        this.f5130M = 0;
        this.f5131N = BuildConfig.FLAVOR;
        this.f5132O = BuildConfig.FLAVOR;
        this.f5133P = BuildConfig.FLAVOR;
        this.f5134Q = BuildConfig.FLAVOR;
        this.f5135R = BuildConfig.FLAVOR;
        this.f5136S = BuildConfig.FLAVOR;
        this.f5137T = BuildConfig.FLAVOR;
        this.f5139V = BuildConfig.FLAVOR;
        this.f5140W = BuildConfig.FLAVOR;
        this.f5141X = BuildConfig.FLAVOR;
        this.f5142Y = BuildConfig.FLAVOR;
        this.f5143Z = BuildConfig.FLAVOR;
        this.aa = BuildConfig.FLAVOR;
        this.ab = BuildConfig.FLAVOR;
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = null;
        this.aj = new boolean[41];
        this.ak = false;
        this.al = 0;
        this.am = false;
    }

    private String m5913a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String str3 = (str.contains(str2) || str.toUpperCase().contains(str2.toUpperCase())) ? str : (str2.contains(str) || str2.toUpperCase().contains(str.toUpperCase())) ? str2 : str2;
        return str.equals("Xiaomi") ? (str2.equals("2013022") || str2.equals("2013023")) ? str + " HongMi" : str3 : str3;
    }

    private static String m5914b(int i) {
        double d = ((double) i) / 1000.0d;
        if (d <= 1.0d) {
            return BuildConfig.FLAVOR;
        }
        try {
            return ((int) d) + " MHz";
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static C1503b m5915c() {
        return ao;
    }

    private String m5916f(String str) {
        try {
            if (str.contains("+") || str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) || str.contains("#")) {
                str = URLEncoder.encode(str, HttpRequest.f14548a);
            }
        } catch (Exception e) {
        }
        return str;
    }

    private void m5917g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("isdata") == 1) {
                String string = jSONObject.getJSONObject(com.taobao.accs.common.Constants.KEY_DATA).getString("url");
                if (string.startsWith(HttpConstant.HTTP)) {
                    this.f5158t = string;
                }
            }
        } catch (Exception e) {
        }
    }

    private void m5918h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("isdata") == 1) {
                this.f5159u = jSONObject.getJSONObject(com.taobao.accs.common.Constants.KEY_DATA).getString(AgooConstants.MESSAGE_ID);
            }
        } catch (Exception e) {
        }
    }

    public static boolean m5919h(Context context) {
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            int i = defaultSharedPreferences.getInt("lastVersionCode", 0);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (i >= 5000000) {
                return false;
            }
            Editor edit = defaultSharedPreferences.edit();
            edit.putInt("lastVersionCode", packageInfo.versionCode);
            edit.apply();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void m5920o(Context context) {
        for (int i = 0; i < 41; i++) {
            this.aj[i] = false;
        }
        try {
            int benchmarkTest2 = jni.benchmarkTest2(context, context.getAssets());
            for (int i2 = 30; i2 < 41; i2++) {
                this.aj[i2] = ((1 << (i2 + -30)) & benchmarkTest2) != 0;
            }
        } catch (Exception e) {
        }
    }

    private void m5921p(Context context) {
        String language;
        String str = ((((((((("&os=android" + "&score=" + m5967t()) + "&softversion=" + m5958m()) + "&oemid=" + m5954k()) + "&model=" + Build.MODEL) + "&brand=" + Build.BRAND) + "&product=" + Build.PRODUCT) + "&device=" + Build.DEVICE) + "&manufacturer=" + Build.MANUFACTURER) + "&glVendor=" + C1516b.m6035i()) + "&glRenderer=" + C1516b.m6036j();
        String str2 = BuildConfig.FLAVOR;
        try {
            language = context.getResources().getConfiguration().locale.getLanguage();
            str2 = context.getResources().getConfiguration().locale.getCountry();
            if (str2.length() >= 2) {
                language = str2;
            }
        } catch (Exception e) {
            language = str2;
        }
        this.f5123F = language.toLowerCase();
        this.f5122E = jni.getDataSafe(str + "&lang=" + Utils.getLocalLanguage(context).toLowerCase(), BuildConfig.FLAVOR);
    }

    private void m5922q(Context context) {
        m5921p(context);
        this.f5124G = Build.MODEL;
        this.f5119B = "&model=" + m5916f(Build.MODEL);
        this.f5119B += "&brand=" + m5916f(Build.BRAND);
        this.f5119B += "&product=" + m5916f(Build.PRODUCT);
        this.f5119B += "&device=" + m5916f(Build.DEVICE);
        this.f5119B += "&manufacturer=" + m5916f(Build.MANUFACTURER);
        this.f5119B += "&version=" + m5916f(VERSION.RELEASE);
        this.f5119B += "&int6=" + this.f5125H;
        this.f5119B += "&oemid=" + this.f5150l;
        this.f5119B += "&ramsize=" + this.f5126I;
        this.f5119B += "&memsize=" + this.f5127J;
        this.f5119B += "&int2=" + C1516b.m6029f();
        this.f5119B += "&int3=" + C1516b.m6020c();
        this.f5119B += "&resolution=" + C1516b.m6034h();
        this.f5119B += "&glVendor=" + C1516b.m6035i();
        this.f5119B += "&glRenderer=" + C1516b.m6036j();
        this.f5119B += "&glVersion=" + C1516b.m6037k();
        this.f5119B += "&gpufrequency=" + C1516b.m6031g();
        try {
            this.f5119B += "&hardsize=" + Utils.getDevHardSize();
        } catch (Exception e) {
        }
    }

    public String m5923a() {
        return this.an;
    }

    public String m5924a(int i) {
        return i > 1 ? " (x" + i + C4233j.f14397t : BuildConfig.FLAVOR;
    }

    public String m5925a(Context context, boolean z) {
        try {
            this.f5137T = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
        }
        if (this.f5137T == null) {
            this.f5137T = BuildConfig.FLAVOR;
        }
        if (z) {
            return this.f5137T;
        }
        try {
            if (this.f5137T.startsWith("000000") || this.f5137T.startsWith("123456")) {
                this.f5137T = BuildConfig.FLAVOR;
            }
            if (this.f5137T.length() < 14) {
                this.f5137T = Build.MODEL + Build.DEVICE + Build.MANUFACTURER + this.f5136S;
                try {
                    MessageDigest instance = MessageDigest.getInstance("sha-1");
                    instance.update(this.f5137T.getBytes());
                    byte[] digest = instance.digest();
                    String str = BuildConfig.FLAVOR;
                    for (int i = 0; i < digest.length; i++) {
                        str = str + String.format("%02X", new Object[]{Integer.valueOf(digest[i] & MotionEventCompat.ACTION_MASK)});
                    }
                    if (str.length() > 30) {
                        this.f5137T = str;
                    }
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
        return this.f5137T;
    }

    public void m5926a(Context context) {
        jni.getLastScore();
        m5920o(context);
    }

    void m5927a(Context context, SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            String externalStorageState;
            this.f5163y = sharedPreferences.getString("faceImg", BuildConfig.FLAVOR);
            this.f5139V = sharedPreferences.getString("test_sdcard_path", BuildConfig.FLAVOR);
            this.f5141X = sharedPreferences.getString("checksum", BuildConfig.FLAVOR);
            this.f5142Y = sharedPreferences.getString("StabilityScores", BuildConfig.FLAVOR);
            this.f5124G = sharedPreferences.getString(com.taobao.accs.common.Constants.KEY_MODEL, BuildConfig.FLAVOR);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                f5114b = packageInfo.versionName;
                this.f5152n = Integer.toString(packageInfo.versionCode);
            } catch (Exception e) {
            }
            File file = new File("data/data/" + context.getPackageName() + "/shared_prefs");
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                file = context.getDatabasePath("dbs");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e2) {
            }
            try {
                externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equalsIgnoreCase("mounted")) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.antutu/");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(C1510b.f5183a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                }
            } catch (Exception e3) {
            }
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                this.f5127J = (int) ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) >> 10);
                statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
                this.f5125H = (int) ((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) >> 10);
                this.f5126I = IO.getRamTotalSize();
            } catch (Exception e4) {
            }
            file = context.getFilesDir();
            if (!file.exists()) {
                file.mkdirs();
            }
            jni.getLastScore();
            m5920o(context);
            m5957l(context);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("LastScore", 0);
            this.f5118A = sharedPreferences2.getString("sIMEI", BuildConfig.FLAVOR);
            try {
                this.f5119B = URLDecoder.decode(sharedPreferences2.getString("sExtra", BuildConfig.FLAVOR), HttpRequest.f14548a);
            } catch (Exception e5) {
            }
            int i = sharedPreferences2.getInt("score_type", 31);
            this.f5145g = i;
            this.f5144f = i;
            i = sharedPreferences2.getInt("score_fast", 0);
            this.f5161w = i;
            this.f5160v = i;
            this.f5155q = sharedPreferences2.getInt("policy_verify_flag", 0);
            this.f5154p = sharedPreferences2.getInt("policy_verify_score", 0);
            this.f5156r = sharedPreferences2.getString("policy_message", BuildConfig.FLAVOR);
            this.f5157s = sharedPreferences2.getString("policy_tips", BuildConfig.FLAVOR);
            this.f5128K = sharedPreferences2.getInt("CPUMIN", 0);
            this.f5130M = sharedPreferences2.getInt("CPUMAX", 0);
            this.f5129L = sharedPreferences2.getInt("CPUCORE", 1);
            this.f5162x = C1503b.m5914b(this.f5130M) + m5924a(this.f5129L);
            this.f5164z = sharedPreferences2.getString("TIME", context.getString(C1082R.string.Untested));
            this.f5136S = sharedPreferences2.getString("SGID", BuildConfig.FLAVOR);
            if (this.f5136S.length() < 2) {
                try {
                    Class cls = Class.forName("android.os.SystemProperties");
                    externalStorageState = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
                } catch (Exception e6) {
                    externalStorageState = null;
                }
                if (externalStorageState != null) {
                    try {
                        if (externalStorageState.length() > 10) {
                            this.f5136S = externalStorageState;
                        }
                    } catch (Exception e7) {
                    }
                }
                this.f5136S = System.getString(context.getContentResolver(), "android_id");
            }
            if (this.f5136S == null || this.f5136S.length() < 5) {
                try {
                    this.f5136S = UUID.randomUUID().toString();
                } catch (Exception e8) {
                }
            }
            if (this.f5148j == null || this.f5148j.length() < 5) {
                this.f5148j = this.f5136S;
            }
            if (!this.f5118A.endsWith(m5925a(context, false))) {
                this.f5141X = BuildConfig.FLAVOR;
            }
            this.f5131N = sharedPreferences2.getString("CPUID", BuildConfig.FLAVOR);
            this.f5134Q = sharedPreferences2.getString("CPUNOW", BuildConfig.FLAVOR);
            this.f5135R = sharedPreferences2.getString("RAMNOW", BuildConfig.FLAVOR);
            this.f5122E = sharedPreferences2.getString("lastData", BuildConfig.FLAVOR);
            this.f5123F = sharedPreferences2.getString("lastDataLang", BuildConfig.FLAVOR);
            this.f5146h = this.f5162x;
            this.f5147i = this.f5164z;
            this.f5144f = this.f5145g;
            this.f5160v = this.f5161w;
            try {
                XmlResourceParser xml = context.getResources().getXml(C1692R.xml.default_settings);
                while (true) {
                    i = xml.next();
                    if (i == 2) {
                        if (xml.getName().equals("setting")) {
                            int attributeCount = xml.getAttributeCount();
                            for (i = 0; i < attributeCount; i++) {
                                String attributeName = xml.getAttributeName(i);
                                String attributeValue = xml.getAttributeValue(i);
                                if (attributeName.equals("oemid")) {
                                    this.f5150l = Integer.valueOf(attributeValue).intValue();
                                } else if (attributeName.equals("softid")) {
                                    this.f5151m = Integer.valueOf(attributeValue).intValue();
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } else if (i == 1) {
                        break;
                    }
                }
            } catch (Exception e9) {
            }
            if (this.f5118A.length() < 10) {
                this.f5118A = m5925a(context, false);
            }
            if (this.f5119B.length() < 10) {
                m5922q(context);
            }
            this.f5140W = context.getResources().getConfiguration().locale.getLanguage();
            externalStorageState = context.getResources().getConfiguration().locale.getCountry();
            if (this.f5140W == null || !this.f5140W.contains("zh")) {
                if (this.f5140W == null) {
                    this.f5140W = "en";
                }
                this.f5149k = 0;
            } else if (externalStorageState.contains("CN")) {
                this.f5140W = "zh_CN";
                this.f5149k = 1;
            } else {
                this.f5140W = "zh";
                this.f5149k = 2;
            }
            jni.setHostID(this.f5149k, this.f5150l);
            i = jni.getCPUType();
            if (i == 3 || i == 5 || i == 7) {
                this.ag = true;
            } else {
                this.ag = false;
            }
            m5952j();
            this.f5121D = jni.getKernelInfo().trim();
            C1372c.m5438a(context);
            m5941d(context);
        }
    }

    public void m5928a(Context context, String str) {
        try {
            m5917g(jni.getStringSafe(str, BuildConfig.FLAVOR));
            m5918h(jni.getStringSafe(str, BuildConfig.FLAVOR));
            File file = new File(context.getFilesDir() + "/last_res.xml.gz");
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            }
        } catch (Exception e) {
        }
    }

    public void m5929a(String str) {
        this.an = str;
    }

    public void m5930a(boolean z) {
        this.am = z;
    }

    public boolean m5931a(Context context, int i) {
        try {
            if (!((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected()) {
                return false;
            }
            Random random = new Random();
            String str = BuildConfig.FLAVOR;
            do {
                str = str + random.nextInt(9999) + BuildConfig.FLAVOR;
            } while (str.length() < 16);
            str = str.substring(2, 12);
            jni.checkTimer(context, i, Methods.httpPost("http://certtime.antutu.net/i/api/sdk/times", "uid=" + str, AdError.NETWORK_ERROR_CODE), str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int m5932b(Context context) {
        return jni.benchmarkScore(context, 31) + (jni.benchmarkScore(context, 32) + jni.benchmarkScore(context, 33));
    }

    public String m5933b(boolean z) {
        int cpuCount = jni.getCpuCount();
        if (z) {
            this.f5129L = cpuCount;
        }
        return m5924a(cpuCount);
    }

    public void m5934b(String str) {
        this.ab = str;
    }

    public boolean m5935b() {
        return this.am;
    }

    public int m5936c(Context context) {
        return jni.benchmarkScore(context, 39) + jni.benchmarkScore(context, 40);
    }

    public void m5937c(String str) {
        if (str != null && str.length() >= 2) {
            String stringSafe = jni.getStringSafe(str, "74Sd42l35nH");
            if (stringSafe != null && stringSafe.equals("74Sd42l35nH")) {
                this.af = true;
            }
        }
    }

    public void m5938c(boolean z) {
        this.ak = z;
    }

    public int m5939d() {
        return this.f5149k;
    }

    public String m5940d(String str) {
        String sharedPreferencesString = Methods.getSharedPreferencesString("pre_dev_model", str);
        return (sharedPreferencesString.contains(C4233j.f14396s) && sharedPreferencesString.contains(C4233j.f14397t)) ? sharedPreferencesString.substring(0, sharedPreferencesString.indexOf(C4233j.f14396s)).trim() : sharedPreferencesString;
    }

    public void m5941d(Context context) {
        this.f5138U = IO.getSDPaths(context);
    }

    public String m5942e() {
        return this.f5140W;
    }

    public String m5943e(String str) {
        return Methods.getSharedPreferencesString("pre_dev_brand", str);
    }

    public void m5944e(Context context) {
        this.f5128K = jni.getMinSet();
        this.f5130M = jni.getMaxSet();
        if (this.f5128K == 0) {
            this.f5128K = jni.getMinDef();
        }
        if (this.f5130M == 0) {
            this.f5130M = jni.getMaxDef();
        }
        this.f5146h = C1503b.m5914b(this.f5130M) + m5933b(true);
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new MemoryInfo());
        this.f5135R = String.format("%.02f", new Object[]{Double.valueOf(((double) (r2.availMem >> 10)) / 1024.0d)});
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
        int i = true;
        while (i < 100) {
            String readLine = lineNumberReader.readLine();
            if (readLine == null) {
                break;
            }
            try {
                if (readLine.contains("Hardware")) {
                    i = (int) Utils.getCPUFreqMTK(true, true);
                    if (i > this.f5130M) {
                        this.f5130M = i;
                        this.f5146h = C1503b.m5914b(this.f5130M) + m5933b(true);
                    } else if (i <= 0) {
                        i = jni.getCpuCount();
                        if (i > 3) {
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + (i / 2) + "/cpufreq/cpuinfo_max_freq"));
                                str = bufferedReader.readLine();
                                bufferedReader.close();
                                i = Integer.valueOf(str.trim()).intValue();
                                if (i > this.f5130M) {
                                    this.f5130M = i;
                                    this.f5146h = C1503b.m5914b(this.f5130M) + m5933b(true);
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else {
                    if (readLine.contains("BogoMIPS")) {
                        this.f5134Q = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    } else if (readLine.contains("CPU implementer")) {
                        str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    } else if (readLine.contains("CPU variant")) {
                        str4 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    } else if (readLine.contains("CPU part")) {
                        str6 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    } else if (readLine.contains("CPU revision")) {
                        str5 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    } else if (readLine.contains("CPU architecture")) {
                        str3 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    }
                    i++;
                }
            } catch (Exception e2) {
            }
        }
        this.f5131N = str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str6 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
        lineNumberReader.close();
        if (this.ag) {
            this.f5146h = "64bit " + this.f5146h;
        }
    }

    public String m5945f(Context context) {
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        try {
            str = context.getResources().getConfiguration().locale.getLanguage();
            str2 = context.getResources().getConfiguration().locale.getCountry();
            if (str2.length() >= 2) {
                str = str2;
            }
        } catch (Exception e) {
            str = str2;
        }
        str = "?lang=" + str.toLowerCase();
        int t = m5967t();
        if (t <= 0) {
            return str;
        }
        str2 = str + "&score=" + t;
        str = context.getResources().getString(C1082R.string.my_device);
        try {
            str = URLEncoder.encode(str + " " + m5940d(Build.MODEL), HttpRequest.f14548a).replace("+", "%20");
        } catch (Exception e2) {
        }
        return str2 + "&name=" + str;
    }

    public boolean m5946f() {
        return this.ag;
    }

    public String m5947g(Context context) {
        String language;
        String str = BuildConfig.FLAVOR;
        try {
            language = context.getResources().getConfiguration().locale.getLanguage();
            str = context.getResources().getConfiguration().locale.getCountry();
            if (str.length() >= 2) {
                language = str;
            }
        } catch (Exception e) {
            language = str;
        }
        if (!language.toLowerCase().equals(this.f5123F) || this.f5122E.length() < 5) {
            m5921p(context);
            Editor edit = context.getSharedPreferences("LastScore", 0).edit();
            edit.putString("lastData", this.f5122E);
            edit.putString("lastDataLang", this.f5123F);
            edit.apply();
        }
        return this.f5122E;
    }

    public boolean m5948g() {
        return this.ag;
    }

    public String m5949h() {
        return this.ab;
    }

    public String m5950i() {
        return this.f5121D;
    }

    public void m5951i(Context context) {
        jni.initPaths(context.getFilesDir().getAbsolutePath());
        try {
            this.f5148j = jni.getUUID(context);
        } catch (Exception e) {
        }
        C1545a.m6117a().m6120a(context);
    }

    public String m5952j() {
        if (this.ah) {
            return this.f5143Z;
        }
        this.f5143Z = jni.getCpuInfo();
        this.ah = true;
        return this.f5143Z;
    }

    public String m5953j(Context context) {
        String str;
        String str2 = BuildConfig.FLAVOR;
        String str3 = BuildConfig.FLAVOR;
        String str4 = BuildConfig.FLAVOR;
        String str5 = BuildConfig.FLAVOR;
        String str6 = BuildConfig.FLAVOR;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            str = str5;
            int i = 1;
            while (i < 100) {
                String readLine = lineNumberReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains("Hardware")) {
                        if (readLine.contains("vendor_id")) {
                            str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        }
                        if (str.equals("GenuineIntel") && readLine.contains("model name")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            break;
                        }
                        if (readLine.contains("CPU part")) {
                            readLine = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            if ("0xc0f".equals(readLine)) {
                                str6 = "ARM Cortex-A15";
                            } else if ("0xc09".equals(readLine)) {
                                str6 = "ARM Cortex-A9";
                            } else if ("0xc08".equals(readLine)) {
                                str6 = "ARM Cortex-A8";
                            } else if ("0xc07".equals(readLine)) {
                                str6 = "ARM Cortex-A7";
                            } else if ("0xc05".equals(readLine)) {
                                str6 = "ARM Cortex-A5";
                            } else if ("0x06f".equals(readLine)) {
                                str6 = "Krait";
                            } else if ("0x04d".equals(readLine)) {
                                str6 = "Scorpion";
                            }
                        }
                        i++;
                    } else {
                        str2 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        break;
                    }
                }
                break;
            }
            lineNumberReader.close();
            C1343a a = C1372c.m5437a();
            if (a != null) {
                str3 = a.m5402a() + "x" + a.m5405b();
            }
            a = C1372c.m5439b();
            if (a != null) {
                str4 = a.m5402a() + "x" + a.m5405b();
            }
        } catch (Exception e) {
        }
        str6 = (((((((("v=" + this.f5152n) + "&cpuMin=" + this.f5128K) + "&cpuMax=" + this.f5130M) + "&cpuNow=" + this.f5134Q) + "&ramNow=" + this.f5135R) + "&int4=" + this.f5160v) + "&str1=" + this.f5131N) + "&cpuPart=" + str6) + "&str3=" + this.f5133P;
        str = C1516b.m6031g();
        if (str != null) {
            str6 = str6 + "&str8=" + str;
        }
        str = str6 + "&str10=" + Utils.getLocalMacAddressFromIp(context);
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str6 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.board.platform"});
            str6 = str6 != null ? str + "&str6=" + str6 : str;
        } catch (Exception e2) {
            str6 = str;
        }
        try {
            str6 = ((((((str6 + "&camera=" + str3) + "&str4=" + str4) + "&cpuhw=" + m5916f(str2)) + "&rom=" + m5916f(Build.DISPLAY)) + "&fingerprint=" + m5916f(Build.FINGERPRINT)) + "&token=") + this.f5119B;
            str4 = context.getResources().getConfiguration().locale.getLanguage();
            str3 = context.getResources().getConfiguration().locale.getCountry();
            if (str4 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            if (str3 == null) {
                str4 = BuildConfig.FLAVOR;
            }
            if (!str4.contains("zh")) {
                this.f5149k = 0;
            } else if (str3.contains("CN")) {
                this.f5149k = 1;
            } else {
                this.f5149k = 2;
            }
            jni.setHostID(this.f5149k, this.f5150l);
            this.f5120C = str3;
            if (this.f5120C.length() < 2) {
                this.f5120C = str4;
            }
            str6 = str6 + "&lang=" + this.f5120C;
        } catch (Exception e3) {
        }
        str6 = str6 + "&imei=" + this.f5118A;
        try {
            str6 = str6 + "&duid=" + m5962o();
        } catch (Exception e4) {
        }
        return this.ae ? str6 + "&gni=2" : str6;
    }

    public int m5954k() {
        return this.f5150l;
    }

    public void m5955k(Context context) {
        try {
            this.f5158t = null;
            File file = new File(context.getFilesDir() + "/last_res.xml.gz");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    public int m5956l() {
        return this.f5151m;
    }

    public void m5957l(Context context) {
        try {
            File file = new File(context.getFilesDir() + "/last_res.xml.gz");
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                fileInputStream.close();
                m5917g(jni.getStringSafe(str, BuildConfig.FLAVOR));
                m5918h(jni.getStringSafe(str, BuildConfig.FLAVOR));
            }
        } catch (Exception e) {
        }
    }

    public String m5958m() {
        return this.f5152n;
    }

    public void m5959m(Context context) {
        m5920o(context);
        this.f5145g = this.f5144f;
        this.f5161w = this.f5160v;
        this.f5118A = m5925a(context, false);
        try {
            if (this.f5134Q.length() <= 0 && this.f5135R.length() <= 0) {
                m5944e(context);
            }
        } catch (Exception e) {
        }
        m5922q(context);
        this.ae = false;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        this.f5164z = format;
        this.f5147i = format;
        format = C1503b.m5914b(this.f5130M) + m5924a(this.f5129L);
        this.f5162x = format;
        this.f5146h = format;
        if (this.ag) {
            this.f5146h = "64bit " + this.f5146h;
            this.f5162x = this.f5146h;
        }
        Editor edit = context.getSharedPreferences("LastScore", 0).edit();
        edit.putString("sIMEI", this.f5118A);
        try {
            edit.putString("sExtra", URLEncoder.encode(this.f5119B, HttpRequest.f14548a));
        } catch (Exception e2) {
        }
        edit.putString("score", jni.getScore());
        edit.putInt("score_type", this.f5144f);
        edit.putInt("score_fast", this.f5160v);
        edit.putInt("CPUMIN", this.f5128K);
        edit.putInt("CPUMAX", this.f5130M);
        edit.putInt("CPUCORE", this.f5129L);
        edit.putString("TIME", this.f5164z);
        edit.putString("SGID", this.f5136S);
        edit.putString("CPUID", this.f5131N);
        edit.putString("CPUNOW", this.f5134Q);
        edit.putString("RAMNOW", this.f5135R);
        edit.putString("lastData", this.f5122E);
        edit.putString("lastDataLang", this.f5123F);
        edit.apply();
        m5955k(context);
    }

    public long m5960n(Context context) {
        return Methods.getSharedPreferencesLong(SPConstants.SHARE_PREF_KEY_MODEL_ID, -1);
    }

    public String m5961n() {
        return this.f5131N;
    }

    public String m5962o() {
        return this.f5148j;
    }

    public List<String> m5963p() {
        return this.f5138U;
    }

    public boolean m5964q() {
        return this.f5138U.size() > 1;
    }

    public boolean[] m5965r() {
        return this.aj;
    }

    public boolean m5966s() {
        int i = 0;
        boolean z = false;
        while (i < 41) {
            z |= this.aj[i];
            i++;
        }
        return z;
    }

    public int m5967t() {
        return jni.benchmarkScore(ABenchmarkApplication.getContext(), 41);
    }

    public boolean m5968u() {
        return m5967t() > 0;
    }

    public boolean m5969v() {
        boolean z = this.af;
        this.af = false;
        return z;
    }

    public String m5970w() {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        String a = m5913a(str, str2);
        str = m5943e(str);
        str2 = m5940d(str2);
        if (str != null) {
            try {
                if (!(BuildConfig.FLAVOR.equals(str) || str2 == null || BuildConfig.FLAVOR.equals(str))) {
                    a = m5913a(str, str2);
                }
            } catch (Exception e) {
            }
        }
        return a;
    }

    public String m5971x() {
        return this.f5159u;
    }

    public boolean m5972y() {
        return m5967t() > 0;
    }

    public long m5973z() {
        return Methods.getSharedPreferencesLong(SPConstants.SHARE_PREF_KEY_UID, -1);
    }
}
