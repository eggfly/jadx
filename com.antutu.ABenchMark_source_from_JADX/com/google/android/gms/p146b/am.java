package com.google.android.gms.p146b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.am */
public abstract class am<T> {
    private final int f10249a;
    private final String f10250b;
    private final T f10251c;

    /* renamed from: com.google.android.gms.b.am.1 */
    static class C30261 extends am<Boolean> {
        C30261(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object m11795a(SharedPreferences sharedPreferences) {
            return m11796b(sharedPreferences);
        }

        public Boolean m11796b(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(m11792a(), ((Boolean) m11793b()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.b.am.2 */
    static class C30272 extends am<Integer> {
        C30272(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object m11797a(SharedPreferences sharedPreferences) {
            return m11798b(sharedPreferences);
        }

        public Integer m11798b(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(m11792a(), ((Integer) m11793b()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.b.am.3 */
    static class C30283 extends am<Long> {
        C30283(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object m11799a(SharedPreferences sharedPreferences) {
            return m11800b(sharedPreferences);
        }

        public Long m11800b(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(m11792a(), ((Long) m11793b()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.b.am.4 */
    static class C30294 extends am<String> {
        C30294(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object m11801a(SharedPreferences sharedPreferences) {
            return m11802b(sharedPreferences);
        }

        public String m11802b(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(m11792a(), (String) m11793b());
        }
    }

    private am(int i, String str, T t) {
        this.f10249a = i;
        this.f10250b = str;
        this.f10251c = t;
        C2968s.m11533m().m11804a(this);
    }

    public static am<String> m11785a(int i, String str) {
        am<String> a = am.m11789a(i, str, (String) null);
        C2968s.m11533m().m11806b(a);
        return a;
    }

    public static am<Integer> m11786a(int i, String str, int i2) {
        return new C30272(i, str, Integer.valueOf(i2));
    }

    public static am<Long> m11787a(int i, String str, long j) {
        return new C30283(i, str, Long.valueOf(j));
    }

    public static am<Boolean> m11788a(int i, String str, Boolean bool) {
        return new C30261(i, str, bool);
    }

    public static am<String> m11789a(int i, String str, String str2) {
        return new C30294(i, str, str2);
    }

    public static am<String> m11790b(int i, String str) {
        am<String> a = am.m11789a(i, str, (String) null);
        C2968s.m11533m().m11807c(a);
        return a;
    }

    protected abstract T m11791a(SharedPreferences sharedPreferences);

    public String m11792a() {
        return this.f10250b;
    }

    public T m11793b() {
        return this.f10251c;
    }

    public T m11794c() {
        return C2968s.m11534n().m11810a(this);
    }
}
