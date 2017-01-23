package com.xiaomi.mistatistic.sdk.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.n */
public class C0584n {
    public static final ExecutorService f4779a;
    public static final ExecutorService f4780b;

    static {
        f4779a = Executors.newSingleThreadExecutor();
        f4780b = Executors.newCachedThreadPool();
    }
}
