package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class hq {
    public static boolean DW;
    public static String j6;

    static class a {
        public static final boolean j6;
        private final List<a> DW;
        private boolean FH;

        private static class a {
            public final long DW;
            public final long FH;
            public final String j6;

            public a(String str, long j, long j2) {
                this.j6 = str;
                this.DW = j;
                this.FH = j2;
            }
        }

        static {
            j6 = hq.DW;
        }

        a() {
            this.DW = new ArrayList();
            this.FH = false;
        }

        private long j6() {
            if (this.DW.size() == 0) {
                return 0;
            }
            return ((a) this.DW.get(this.DW.size() - 1)).FH - ((a) this.DW.get(0)).FH;
        }

        protected void finalize() {
            if (!this.FH) {
                j6("Request on the loose");
                hq.FH("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void j6(String str) {
            this.FH = true;
            if (j6() > 0) {
                long j = ((a) this.DW.get(0)).FH;
                hq.DW("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (a aVar : this.DW) {
                    hq.DW("(+%-4d) [%2d] %s", Long.valueOf(aVar.FH - j2), Long.valueOf(aVar.DW), aVar.j6);
                    j2 = aVar.FH;
                }
            }
        }

        public synchronized void j6(String str, long j) {
            if (this.FH) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.DW.add(new a(str, j, SystemClock.elapsedRealtime()));
        }
    }

    static {
        j6 = "Volley";
        DW = Log.isLoggable(j6, 2);
    }

    public static void DW(String str, Object... objArr) {
        Log.d(j6, Hw(str, objArr));
    }

    public static void FH(String str, Object... objArr) {
        Log.e(j6, Hw(str, objArr));
    }

    private static String Hw(String str, Object... objArr) {
        String valueOf;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(hq.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                valueOf = String.valueOf(stackTrace[i].getMethodName());
                valueOf = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append(".").append(valueOf).toString();
                break;
            }
        }
        valueOf = str2;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), valueOf, str});
    }

    public static void j6(String str, Object... objArr) {
        if (DW) {
            Log.v(j6, Hw(str, objArr));
        }
    }

    public static void j6(Throwable th, String str, Object... objArr) {
        Log.e(j6, Hw(str, objArr), th);
    }
}
