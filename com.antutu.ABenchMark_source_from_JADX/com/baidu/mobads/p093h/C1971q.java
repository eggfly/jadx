package com.baidu.mobads.p093h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p099b.C2033a;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.baidu.mobads.h.q */
public class C1971q implements UncaughtExceptionHandler {
    private static UncaughtExceptionHandler f6862a;
    private static volatile C1971q f6863b;
    private Context f6864c;
    private C1963a f6865d;

    /* renamed from: com.baidu.mobads.h.q.a */
    interface C1963a {
        void m7356a(String str);
    }

    private C1971q(Context context) {
        this.f6864c = context.getApplicationContext();
        f6862a = Thread.getDefaultUncaughtExceptionHandler();
        new Thread(new C1972r(this)).start();
    }

    public static C1971q m7360a(Context context) {
        if (f6863b == null) {
            synchronized (C1971q.class) {
                if (f6863b == null) {
                    f6863b = new C1971q(context);
                }
            }
        }
        return f6863b;
    }

    private String m7362a(String str) {
        return m7366b().getString(str, BuildConfig.FLAVOR);
    }

    private String m7363a(Throwable th) {
        th.printStackTrace();
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement className : stackTrace) {
                String className2 = className.getClassName();
                if (className2.startsWith("junit.framework")) {
                    return null;
                }
                if (className2.startsWith("com.baidu.mobads.container")) {
                    return "remote";
                }
                if (className2.startsWith("com.baidu.mobads.loader")) {
                    return "loader";
                }
                if (className2.startsWith("com.baidu.mobads")) {
                    return "proxy";
                }
            }
        }
        return null;
    }

    private void m7365a(String str, String str2) {
        Editor c = m7367c();
        c.putString("key_crash_source", str);
        c.putString("key_crash_trace", str2);
        c.putString("key_crash_ad", C2033a.f7121w);
        if (VERSION.SDK_INT >= 9) {
            c.apply();
        } else {
            c.commit();
        }
    }

    private SharedPreferences m7366b() {
        return this.f6864c.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private Editor m7367c() {
        return m7366b().edit();
    }

    private void m7368d() {
        Editor c = m7367c();
        c.clear();
        if (VERSION.SDK_INT >= 9) {
            c.apply();
        } else {
            c.commit();
        }
    }

    public void m7369a() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof C1971q)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void m7370a(C1963a c1963a) {
        this.f6865d = c1963a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a = m7363a(th);
            if (a != null) {
                m7365a(a, Log.getStackTraceString(th));
                th.printStackTrace();
                if (this.f6865d != null) {
                    this.f6865d.m7356a(a);
                }
            }
            if (f6862a != null) {
                f6862a.uncaughtException(thread, th);
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7399e(e);
        }
    }
}
