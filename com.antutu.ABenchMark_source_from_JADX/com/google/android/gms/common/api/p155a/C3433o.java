package com.google.android.gms.common.api.p155a;

import com.google.android.gms.p146b.js;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a.o */
public abstract class C3433o {
    private static final ExecutorService f11945a;

    static {
        f11945a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new js("GAC_Transform"));
    }

    public static ExecutorService m14195a() {
        return f11945a;
    }
}
