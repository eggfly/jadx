package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4312f;
import com.xiaomi.push.providers.C4381a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.j */
public class C4500j {
    private static C4312f f15474a;
    private static int f15475b;
    private static final Object f15476c;
    private static List<C4499a> f15477d;
    private static String f15478e;
    private static C4381a f15479f;

    /* renamed from: com.xiaomi.smack.util.j.a */
    static class C4499a {
        public String f15468a;
        public long f15469b;
        public int f15470c;
        public int f15471d;
        public String f15472e;
        public long f15473f;

        public C4499a(String str, long j, int i, int i2, String str2, long j2) {
            this.f15468a = BuildConfig.FLAVOR;
            this.f15469b = 0;
            this.f15470c = -1;
            this.f15471d = -1;
            this.f15472e = BuildConfig.FLAVOR;
            this.f15473f = 0;
            this.f15468a = str;
            this.f15469b = j;
            this.f15470c = i;
            this.f15471d = i2;
            this.f15472e = str2;
            this.f15473f = j2;
        }

        public boolean m18657a(C4499a c4499a) {
            return TextUtils.equals(c4499a.f15468a, this.f15468a) && TextUtils.equals(c4499a.f15472e, this.f15472e) && c4499a.f15470c == this.f15470c && c4499a.f15471d == this.f15471d && Math.abs(c4499a.f15469b - this.f15469b) <= 5000;
        }
    }

    static {
        f15474a = new C4312f(true);
        f15475b = -1;
        f15476c = new Object();
        f15477d = Collections.synchronizedList(new ArrayList());
        f15478e = BuildConfig.FLAVOR;
        f15479f = null;
    }

    private static int m18658a(Context context) {
        if (f15475b == -1) {
            f15475b = C4500j.m18665b(context);
        }
        return f15475b;
    }

    public static int m18659a(String str) {
        try {
            return str.getBytes(HttpRequest.f14548a).length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    private static long m18660a(int i, long j) {
        return (((long) (i == 0 ? 13 : 11)) * j) / 10;
    }

    public static void m18663a(XMPushService xMPushService, String str, long j, boolean z, long j2) {
        if (xMPushService != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(xMPushService.getPackageName()) && !"com.xiaomi.xmsf".equals(str)) {
            int a = C4500j.m18658a((Context) xMPushService);
            if (-1 != a) {
                boolean isEmpty;
                synchronized (f15476c) {
                    isEmpty = f15477d.isEmpty();
                    C4500j.m18664a(new C4499a(str, j2, a, z ? 1 : 0, a == 0 ? C4500j.m18668c(xMPushService) : BuildConfig.FLAVOR, C4500j.m18660a(a, j)));
                }
                if (isEmpty) {
                    f15474a.m17687a(new C4501k(xMPushService), 5000);
                }
            }
        }
    }

    private static void m18664a(C4499a c4499a) {
        for (C4499a c4499a2 : f15477d) {
            if (c4499a2.m18657a(c4499a)) {
                c4499a2.f15473f += c4499a.f15473f;
                return;
            }
        }
        f15477d.add(c4499a);
    }

    private static int m18665b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    private static void m18667b(Context context, List<C4499a> list) {
        try {
            synchronized (C4381a.f14927a) {
                SQLiteDatabase writableDatabase = C4500j.m18669d(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (C4499a c4499a : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", c4499a.f15468a);
                        contentValues.put("message_ts", Long.valueOf(c4499a.f15469b));
                        contentValues.put("network_type", Integer.valueOf(c4499a.f15470c));
                        contentValues.put("bytes", Long.valueOf(c4499a.f15473f));
                        contentValues.put("rcv", Integer.valueOf(c4499a.f15471d));
                        contentValues.put(Constants.KEY_IMSI, c4499a.f15472e);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
    }

    private static synchronized String m18668c(Context context) {
        String str;
        synchronized (C4500j.class) {
            if (TextUtils.isEmpty(f15478e)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f15478e = telephonyManager.getSubscriberId();
                    }
                } catch (Exception e) {
                }
                str = f15478e;
            } else {
                str = f15478e;
            }
        }
        return str;
    }

    private static C4381a m18669d(Context context) {
        if (f15479f != null) {
            return f15479f;
        }
        f15479f = new C4381a(context);
        return f15479f;
    }
}
