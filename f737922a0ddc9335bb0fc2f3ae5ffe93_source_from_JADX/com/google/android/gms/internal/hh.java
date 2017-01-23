package com.google.android.gms.internal;

public abstract class hh<T> {
    private static final Object FH;
    private static a Hw;
    private static String Zo;
    private static int v5;
    protected final T DW;
    private T VH;
    protected final String j6;

    class 1 extends hh<Boolean> {
        1(String str, Boolean bool) {
            super(str, bool);
        }

        protected Boolean DW(String str) {
            return null.j6(this.j6, (Boolean) this.DW);
        }

        protected /* synthetic */ Object j6(String str) {
            return DW(str);
        }
    }

    class 2 extends hh<Long> {
        2(String str, Long l) {
            super(str, l);
        }

        protected Long DW(String str) {
            return null.j6(this.j6, (Long) this.DW);
        }

        protected /* synthetic */ Object j6(String str) {
            return DW(str);
        }
    }

    class 3 extends hh<Integer> {
        3(String str, Integer num) {
            super(str, num);
        }

        protected Integer DW(String str) {
            return null.j6(this.j6, (Integer) this.DW);
        }

        protected /* synthetic */ Object j6(String str) {
            return DW(str);
        }
    }

    class 4 extends hh<Float> {
        4(String str, Float f) {
            super(str, f);
        }

        protected Float DW(String str) {
            return null.j6(this.j6, (Float) this.DW);
        }

        protected /* synthetic */ Object j6(String str) {
            return DW(str);
        }
    }

    class 5 extends hh<String> {
        5(String str, String str2) {
            super(str, str2);
        }

        protected String DW(String str) {
            return null.j6(this.j6, (String) this.DW);
        }

        protected /* synthetic */ Object j6(String str) {
            return DW(str);
        }
    }

    private interface a {
        Boolean j6(String str, Boolean bool);

        Float j6(String str, Float f);

        Integer j6(String str, Integer num);

        Long j6(String str, Long l);

        String j6(String str, String str2);
    }

    static {
        FH = new Object();
        Hw = null;
        v5 = 0;
        Zo = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected hh(String str, T t) {
        this.VH = null;
        this.j6 = str;
        this.DW = t;
    }

    public static hh<Float> j6(String str, Float f) {
        return new 4(str, f);
    }

    public static hh<Integer> j6(String str, Integer num) {
        return new 3(str, num);
    }

    public static hh<Long> j6(String str, Long l) {
        return new 2(str, l);
    }

    public static hh<String> j6(String str, String str2) {
        return new 5(str, str2);
    }

    public static hh<Boolean> j6(String str, boolean z) {
        return new 1(str, Boolean.valueOf(z));
    }

    public final T j6() {
        return j6(this.j6);
    }

    protected abstract T j6(String str);
}
