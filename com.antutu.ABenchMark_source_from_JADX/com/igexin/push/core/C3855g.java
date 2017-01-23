package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.C3758q;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.bean.C3827g;
import com.igexin.push.p169f.p170b.C3732h;
import com.igexin.sdk.p186a.C3941c;
import com.igexin.sdk.p186a.C3942d;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.core.g */
public class C3855g {
    public static String f12937A;
    public static String f12938B;
    public static String f12939C;
    public static String f12940D;
    public static long f12941E;
    public static long f12942F;
    public static long f12943G;
    public static long f12944H;
    public static long f12945I;
    public static long f12946J;
    public static long f12947K;
    public static long f12948L;
    public static long f12949M;
    public static String f12950N;
    public static boolean f12951O;
    public static long f12952P;
    public static long f12953Q;
    public static String f12954R;
    public static long f12955S;
    public static int f12956T;
    public static long f12957U;
    public static String f12958V;
    public static String f12959W;
    public static String f12960X;
    public static String f12961Y;
    public static String f12962Z;
    public static String f12963a;
    public static volatile boolean aA;
    private static HashMap aB;
    private static Map aC;
    public static String aa;
    public static String ab;
    public static String ac;
    public static byte[] ad;
    public static boolean ae;
    public static boolean af;
    public static boolean ag;
    public static Map ah;
    public static Map ai;
    public static HashMap aj;
    public static HashMap ak;
    public static HashMap al;
    public static int am;
    public static Map an;
    public static int ao;
    public static int ap;
    public static int aq;
    public static C3827g ar;
    public static boolean as;
    public static String at;
    public static C3732h au;
    public static long av;
    public static String aw;
    public static String ax;
    public static String ay;
    public static String az;
    public static String f12964b;
    public static String f12965c;
    public static String f12966d;
    public static String f12967e;
    public static boolean f12968f;
    public static Context f12969g;
    public static AtomicBoolean f12970h;
    public static boolean f12971i;
    public static volatile boolean f12972j;
    public static volatile boolean f12973k;
    public static boolean f12974l;
    public static final List f12975m;
    public static boolean f12976n;
    public static boolean f12977o;
    public static boolean f12978p;
    public static int f12979q;
    public static int f12980r;
    public static long f12981s;
    public static String f12982t;
    public static String f12983u;
    public static String f12984v;
    public static String f12985w;
    public static String f12986x;
    public static String f12987y;
    public static String f12988z;

    static {
        f12963a = BuildConfig.FLAVOR;
        f12964b = BuildConfig.FLAVOR;
        f12965c = BuildConfig.FLAVOR;
        f12966d = BuildConfig.FLAVOR;
        f12967e = BuildConfig.FLAVOR;
        f12968f = false;
        f12970h = new AtomicBoolean(false);
        f12971i = true;
        f12972j = false;
        f12973k = false;
        f12974l = true;
        f12975m = new ArrayList();
        f12976n = false;
        f12977o = false;
        f12978p = true;
        f12979q = 0;
        f12980r = 0;
        f12981s = 0;
        f12940D = BuildConfig.FLAVOR;
        f12941E = -1;
        f12942F = -1;
        f12943G = 0;
        f12944H = 0;
        f12945I = 0;
        f12946J = 0;
        f12947K = 0;
        f12948L = 0;
        f12949M = 0;
        f12950N = null;
        f12951O = C3758q.f12684a.equals("debug");
        f12952P = 0;
        f12953Q = 0;
        f12955S = 0;
        f12956T = 0;
        am = 0;
        ao = 0;
        ap = 0;
        aq = 0;
        as = false;
        aB = new HashMap();
    }

    public static int m15887a(String str, boolean z) {
        int intValue;
        synchronized (aC) {
            if (aC.get(str) == null) {
                aC.put(str, Integer.valueOf(0));
            }
            intValue = ((Integer) aC.get(str)).intValue();
            if (z) {
                intValue--;
                aC.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    aC.remove(str);
                }
            }
        }
        return intValue;
    }

    public static String m15888a() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    public static void m15889a(long j) {
        f12981s = j;
        f12982t = C3700a.m15132a(String.valueOf(f12981s));
    }

    public static boolean m15890a(Context context) {
        boolean z = false;
        f12969g = context;
        f12967e = context.getPackageName();
        String str = BuildConfig.FLAVOR;
        str = BuildConfig.FLAVOR;
        str = BuildConfig.FLAVOR;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(f12967e, SpdyProtocol.SLIGHTSSLV2);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return false;
            }
            String string = applicationInfo.metaData.getString("PUSH_APPID");
            String string2 = applicationInfo.metaData.getString("PUSH_APPSECRET");
            str = applicationInfo.metaData.getString("PUSH_APPKEY");
            if (string != null) {
                string = string.trim();
            }
            if (string2 != null) {
                string2 = string2.trim();
            }
            if (str != null) {
                str = str.trim();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(str)) {
                return false;
            }
            f12963a = string;
            f12964b = str;
            f12965c = string2;
            f12966d = SDKUrlConfig.getLocation();
            ad = C3700a.m15132a(string + string2 + str + context.getPackageName()).getBytes();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f12967e, SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                if (packageInfo == null || packageInfo.requestedPermissions == null) {
                    return false;
                }
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals("android.permission.CALL_PHONE")) {
                        f12968f = true;
                        break;
                    }
                }
                context.getFilesDir();
                File file = new File("/sdcard/libs");
                if (file.exists() && file.isFile()) {
                    C3688a.m15097b("CoreRuntimeInfo|libs is file not directory, delete libs file ++++");
                    file.delete();
                }
                if (!(file.exists() || file.mkdir())) {
                    C3688a.m15097b("CoreRuntimeInfo|create libs directory failed ++++++");
                }
                file = new File(Environment.getExternalStorageDirectory().getPath() + "/system/tmp/local");
                if (!file.exists()) {
                    file.mkdirs();
                }
                ab = file.getAbsolutePath();
                ac = context.getFilesDir().getPath();
                f12960X = "/sdcard/libs/" + f12967e + ".db";
                f12961Y = "/sdcard/libs/com.igexin.sdk.deviceId.db";
                f12962Z = "/sdcard/libs/app.db";
                aa = "/sdcard/libs/imsi.db";
                f12959W = "/sdcard/libs/" + f12967e + ".properties";
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    f12984v = telephonyManager.getDeviceId();
                    f12985w = telephonyManager.getSubscriberId();
                    if (TextUtils.isEmpty(f12988z)) {
                        if (C3754m.f12663g) {
                            HashMap b = C3855g.m15892b();
                            if (!(b == null || TextUtils.isEmpty(f12985w))) {
                                f12988z = (String) b.get(f12985w);
                            }
                            if (f12988z == null || !f12988z.equals(BuildConfig.FLAVOR)) {
                                f12988z = null;
                            }
                        } else {
                            f12988z = null;
                        }
                    }
                    f12986x = Build.MODEL;
                    ConnectivityManager j = C3854f.m15859a().m15880j();
                    if (j != null) {
                        NetworkInfo activeNetworkInfo = j.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            z = true;
                        }
                        f12971i = z;
                    } else {
                        f12971i = false;
                    }
                } catch (Throwable th) {
                }
                ah = new HashMap();
                ai = new HashMap();
                aj = new HashMap();
                ak = new HashMap();
                al = new HashMap();
                an = new HashMap();
                f12957U = System.currentTimeMillis();
                f12958V = "com.igexin.sdk.action.snlresponse." + f12967e;
                f12972j = new C3942d(context).m16228c();
                f12973k = new C3941c(context).m16225c();
                aC = new HashMap();
                aA = true;
                C3688a.m15098b("CoreRuntimeInfo", "getui sdk init success");
                C3688a.m15097b("CoreRuntimeInfo|getui sdk init success ##########");
                return true;
            } catch (Exception e) {
                C3688a.m15097b("CoreRuntimeInfo | init exception : " + e.toString());
                return false;
            }
        } catch (Exception e2) {
            C3688a.m15097b("CoreRuntimeInfo|get ApplicationInfo meta data exception :" + e2.toString());
            return false;
        }
    }

    public static boolean m15891a(String str, Integer num, boolean z) {
        boolean z2;
        synchronized (aC) {
            int intValue = num.intValue();
            if (z && aC.get(str) != null) {
                intValue = ((Integer) aC.get(str)).intValue() + num.intValue();
                if (intValue == 0) {
                    aC.remove(str);
                    z2 = false;
                }
            }
            aC.put(str, Integer.valueOf(intValue));
            z2 = true;
        }
        return z2;
    }

    public static HashMap m15892b() {
        if (!new File(aa).exists()) {
            return null;
        }
        try {
            ObjectInput objectInputStream = new ObjectInputStream(new FileInputStream(aa));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            try {
                objectInputStream.close();
                return hashMap;
            } catch (Exception e) {
                return hashMap;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static HashMap m15893c() {
        return aB;
    }
}
