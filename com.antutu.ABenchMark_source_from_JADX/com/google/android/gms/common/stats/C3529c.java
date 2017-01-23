package com.google.android.gms.common.stats;

import com.google.android.gms.p146b.ja;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.google.android.gms.common.stats.c */
public final class C3529c {
    public static ja<Integer> f12200a;
    public static ja<Integer> f12201b;

    /* renamed from: com.google.android.gms.common.stats.c.a */
    public static final class C3528a {
        public static ja<Integer> f12194a;
        public static ja<String> f12195b;
        public static ja<String> f12196c;
        public static ja<String> f12197d;
        public static ja<String> f12198e;
        public static ja<Long> f12199f;

        static {
            f12194a = ja.m13512a("gms:common:stats:connections:level", Integer.valueOf(C3530d.f12203b));
            f12195b = ja.m13514a("gms:common:stats:connections:ignored_calling_processes", BuildConfig.FLAVOR);
            f12196c = ja.m13514a("gms:common:stats:connections:ignored_calling_services", BuildConfig.FLAVOR);
            f12197d = ja.m13514a("gms:common:stats:connections:ignored_target_processes", BuildConfig.FLAVOR);
            f12198e = ja.m13514a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
            f12199f = ja.m13513a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
        }
    }

    static {
        f12200a = ja.m13512a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
        f12201b = ja.m13512a("gms:common:stats:max_chunk_size", Integer.valueOf(100));
    }
}
