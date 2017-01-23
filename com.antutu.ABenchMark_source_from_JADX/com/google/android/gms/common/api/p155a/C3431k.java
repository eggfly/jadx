package com.google.android.gms.common.api.p155a;

import com.google.android.gms.p146b.js;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.common.api.a.k */
public abstract class C3431k {
    private static final ExecutorService f11943a;

    static {
        f11943a = Executors.newFixedThreadPool(2, new js("GAC_Executor"));
    }

    public static ExecutorService m14193a() {
        return f11943a;
    }
}
