package com.xiaomi.mistatistic.sdk.network;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.mistatistic.sdk.network.a */
public class C0610a {
    private static int f4847a;
    private static int f4848b;
    private static int f4849c;
    private static BlockingQueue<Runnable> f4850d;
    private static ThreadPoolExecutor f4851e;

    static {
        f4847a = 2;
        f4848b = 2;
        f4849c = 2;
        f4850d = new LinkedBlockingQueue();
        f4851e = new ThreadPoolExecutor(f4847a, f4848b, (long) f4849c, TimeUnit.SECONDS, f4850d);
    }

    public static ThreadPoolExecutor m6580a() {
        return f4851e;
    }
}
