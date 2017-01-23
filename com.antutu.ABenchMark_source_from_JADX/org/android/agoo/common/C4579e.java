package org.android.agoo.common;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: org.android.agoo.common.e */
public final class C4579e {
    public static final String TAG = "ThreadUtil";

    /* renamed from: org.android.agoo.common.e.a */
    private static class C4578a {
        private static final ScheduledThreadPoolExecutor f16404a;

        static {
            f16404a = new ScheduledThreadPoolExecutor(1);
        }

        private C4578a() {
        }
    }

    private C4579e() {
        if (C4578a.f16404a != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }
}
