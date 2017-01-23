package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class hc {
    private static final ExecutorService j6;

    static {
        j6 = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new hj("GAC_Transform"));
    }

    public static ExecutorService j6() {
        return j6;
    }
}
