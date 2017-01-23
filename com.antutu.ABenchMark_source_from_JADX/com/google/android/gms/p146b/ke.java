package com.google.android.gms.p146b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.b.ke */
public class ke {
    public static String f11608a;
    public static boolean f11609b;

    /* renamed from: com.google.android.gms.b.ke.a */
    static class C3334a {
        public static final boolean f11605a;
        private final List<C3333a> f11606b;
        private boolean f11607c;

        /* renamed from: com.google.android.gms.b.ke.a.a */
        private static class C3333a {
            public final String f11602a;
            public final long f11603b;
            public final long f11604c;

            public C3333a(String str, long j, long j2) {
                this.f11602a = str;
                this.f11603b = j;
                this.f11604c = j2;
            }
        }

        static {
            f11605a = ke.f11609b;
        }

        C3334a() {
            this.f11606b = new ArrayList();
            this.f11607c = false;
        }

        private long m13610a() {
            if (this.f11606b.size() == 0) {
                return 0;
            }
            return ((C3333a) this.f11606b.get(this.f11606b.size() - 1)).f11604c - ((C3333a) this.f11606b.get(0)).f11604c;
        }

        public synchronized void m13611a(String str) {
            this.f11607c = true;
            if (m13610a() > 0) {
                long j = ((C3333a) this.f11606b.get(0)).f11604c;
                ke.m13615b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C3333a c3333a : this.f11606b) {
                    ke.m13615b("(+%-4d) [%2d] %s", Long.valueOf(c3333a.f11604c - j2), Long.valueOf(c3333a.f11603b), c3333a.f11602a);
                    j2 = c3333a.f11604c;
                }
            }
        }

        public synchronized void m13612a(String str, long j) {
            if (this.f11607c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f11606b.add(new C3333a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f11607c) {
                m13611a("Request on the loose");
                ke.m13616c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    static {
        f11608a = "Volley";
        f11609b = Log.isLoggable(f11608a, 2);
    }

    public static void m13613a(String str, Object... objArr) {
        if (f11609b) {
            Log.v(f11608a, ke.m13617d(str, objArr));
        }
    }

    public static void m13614a(Throwable th, String str, Object... objArr) {
        Log.e(f11608a, ke.m13617d(str, objArr), th);
    }

    public static void m13615b(String str, Object... objArr) {
        Log.d(f11608a, ke.m13617d(str, objArr));
    }

    public static void m13616c(String str, Object... objArr) {
        Log.e(f11608a, ke.m13617d(str, objArr));
    }

    private static String m13617d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(ke.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
