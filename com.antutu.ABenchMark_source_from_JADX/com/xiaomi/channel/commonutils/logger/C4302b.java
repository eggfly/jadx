package com.xiaomi.channel.commonutils.logger;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.channel.commonutils.logger.b */
public abstract class C4302b {
    private static int f14718a;
    private static LoggerInterface f14719b;
    private static final HashMap<Integer, Long> f14720c;
    private static final HashMap<Integer, String> f14721d;
    private static final Integer f14722e;
    private static AtomicInteger f14723f;

    static {
        f14718a = 2;
        f14719b = new C4301a();
        f14720c = new HashMap();
        f14721d = new HashMap();
        f14722e = Integer.valueOf(-1);
        f14723f = new AtomicInteger(1);
    }

    public static int m17643a() {
        return f14718a;
    }

    public static void m17644a(int i, String str) {
        if (i >= f14718a) {
            f14719b.log(str);
        }
    }

    public static void m17645a(int i, String str, Throwable th) {
        if (i >= f14718a) {
            f14719b.log(str, th);
        }
    }

    public static void m17646a(int i, Throwable th) {
        if (i >= f14718a) {
            f14719b.log(BuildConfig.FLAVOR, th);
        }
    }

    public static void m17647a(LoggerInterface loggerInterface) {
        f14719b = loggerInterface;
    }

    public static void m17648a(Integer num) {
        if (f14718a <= 1 && f14720c.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) f14720c.remove(num)).longValue();
            f14719b.log(((String) f14721d.remove(num)) + " ends in " + currentTimeMillis + " ms");
        }
    }

    public static void m17649a(String str) {
        C4302b.m17644a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void m17650a(String str, Throwable th) {
        C4302b.m17645a(4, str, th);
    }

    public static void m17651a(Throwable th) {
        C4302b.m17646a(4, th);
    }

    public static void m17652b(String str) {
        C4302b.m17644a(0, str);
    }

    public static void m17653c(String str) {
        C4302b.m17644a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void m17654d(String str) {
        C4302b.m17644a(4, str);
    }

    public static Integer m17655e(String str) {
        if (f14718a > 1) {
            return f14722e;
        }
        Integer valueOf = Integer.valueOf(f14723f.incrementAndGet());
        f14720c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f14721d.put(valueOf, str);
        f14719b.log(str + " starts");
        return valueOf;
    }
}
