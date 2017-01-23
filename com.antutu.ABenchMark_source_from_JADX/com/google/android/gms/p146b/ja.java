package com.google.android.gms.p146b;

/* renamed from: com.google.android.gms.b.ja */
public abstract class ja<T> {
    private static final Object f11550c;
    private static C3323a f11551d;
    private static int f11552e;
    private static String f11553f;
    protected final String f11554a;
    protected final T f11555b;
    private T f11556g;

    /* renamed from: com.google.android.gms.b.ja.1 */
    static class C33201 extends ja<Long> {
        C33201(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object m13519a(String str) {
            return m13520b(str);
        }

        protected Long m13520b(String str) {
            return ja.f11551d.m13526a(this.a, (Long) this.b);
        }
    }

    /* renamed from: com.google.android.gms.b.ja.2 */
    static class C33212 extends ja<Integer> {
        C33212(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object m13521a(String str) {
            return m13522b(str);
        }

        protected Integer m13522b(String str) {
            return ja.f11551d.m13525a(this.a, (Integer) this.b);
        }
    }

    /* renamed from: com.google.android.gms.b.ja.3 */
    static class C33223 extends ja<String> {
        C33223(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object m13523a(String str) {
            return m13524b(str);
        }

        protected String m13524b(String str) {
            return ja.f11551d.m13527a(this.a, (String) this.b);
        }
    }

    /* renamed from: com.google.android.gms.b.ja.a */
    private interface C3323a {
        Integer m13525a(String str, Integer num);

        Long m13526a(String str, Long l);

        String m13527a(String str, String str2);
    }

    static {
        f11550c = new Object();
        f11551d = null;
        f11552e = 0;
        f11553f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected ja(String str, T t) {
        this.f11556g = null;
        this.f11554a = str;
        this.f11555b = t;
    }

    public static int m13511a() {
        return f11552e;
    }

    public static ja<Integer> m13512a(String str, Integer num) {
        return new C33212(str, num);
    }

    public static ja<Long> m13513a(String str, Long l) {
        return new C33201(str, l);
    }

    public static ja<String> m13514a(String str, String str2) {
        return new C33223(str, str2);
    }

    public static boolean m13515b() {
        return f11551d != null;
    }

    protected abstract T m13517a(String str);

    public final T m13518c() {
        return this.f11556g != null ? this.f11556g : m13517a(this.f11554a);
    }
}
