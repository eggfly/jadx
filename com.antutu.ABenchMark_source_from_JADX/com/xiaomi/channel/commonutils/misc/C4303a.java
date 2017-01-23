package com.xiaomi.channel.commonutils.misc;

/* renamed from: com.xiaomi.channel.commonutils.misc.a */
public class C4303a {
    public static final boolean f14724a;
    public static final boolean f14725b;
    public static final boolean f14726c;
    public static final boolean f14727d;
    public static boolean f14728e;
    public static final boolean f14729f;
    public static final boolean f14730g;
    private static int f14731h;

    static {
        boolean z = false;
        f14724a = "@SHIP.TO.2A2FE0D7@".contains("2A2FE0D7");
        boolean z2 = f14724a || "DEBUG".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@");
        f14725b = z2;
        f14726c = "LOGABLE".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@");
        f14727d = "@SHIP.TO.2A2FE0D7@".contains("YY");
        f14728e = "@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("TEST");
        f14729f = "BETA".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@");
        if ("@SHIP.TO.2A2FE0D7@" != null && "@SHIP.TO.2A2FE0D7@".startsWith("RC")) {
            z = true;
        }
        f14730g = z;
        f14731h = 1;
        if ("@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("SANDBOX")) {
            f14731h = 2;
        } else if ("@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("ONEBOX")) {
            f14731h = 3;
        } else {
            f14731h = 1;
        }
    }

    public static void m17656a(int i) {
        f14731h = i;
    }

    public static boolean m17657a() {
        return f14731h == 2;
    }

    public static boolean m17658b() {
        return f14731h == 3;
    }

    public static int m17659c() {
        return f14731h;
    }
}
