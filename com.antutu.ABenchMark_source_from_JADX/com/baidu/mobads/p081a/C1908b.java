package com.baidu.mobads.p081a;

/* renamed from: com.baidu.mobads.a.b */
public class C1908b {
    public static final Boolean f6664a;
    public static final Boolean f6665b;

    static {
        f6664a = Boolean.valueOf(false);
        f6665b = Boolean.valueOf(false);
    }

    public static double m7197a() {
        try {
            return Double.parseDouble("8.8");
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int m7198b() {
        int i = 0;
        try {
            i = Integer.valueOf("8.8".split("\\.")[0]).intValue();
        } catch (Exception e) {
        }
        return i;
    }
}
