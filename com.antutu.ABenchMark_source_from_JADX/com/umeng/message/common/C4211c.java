package com.umeng.message.common;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.proguard.C4233j;

/* renamed from: com.umeng.message.common.c */
public class C4211c {
    private static final String f14270a;
    private static C4211c f14271b;
    private static Class f14272e;
    private static Class f14273f;
    private static Class f14274g;
    private static Class f14275h;
    private static Class f14276i;
    private static Class f14277j;
    private static Class f14278k;
    private static Class f14279l;
    private Context f14280c;
    private String f14281d;

    static {
        f14270a = C4211c.class.getName();
        f14272e = null;
        f14273f = null;
        f14274g = null;
        f14275h = null;
        f14276i = null;
        f14277j = null;
        f14278k = null;
        f14279l = null;
    }

    private C4211c(Context context) {
        this.f14280c = context.getApplicationContext();
        UmLog.m17136d(f14270a, "packageName=" + this.f14280c.getPackageName());
        try {
            f14273f = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$drawable");
        } catch (ClassNotFoundException e) {
            UmLog.m17138e(f14270a, e.getMessage());
        }
        try {
            f14274g = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$layout");
        } catch (ClassNotFoundException e2) {
            UmLog.m17138e(f14270a, e2.getMessage());
        }
        try {
            f14272e = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$id");
        } catch (ClassNotFoundException e22) {
            UmLog.m17138e(f14270a, e22.getMessage());
        }
        try {
            f14275h = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$anim");
        } catch (ClassNotFoundException e222) {
            UmLog.m17138e(f14270a, e222.getMessage());
        }
        try {
            f14276i = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$style");
        } catch (ClassNotFoundException e2222) {
            UmLog.m17138e(f14270a, e2222.getMessage());
        }
        try {
            f14277j = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$string");
        } catch (ClassNotFoundException e22222) {
            UmLog.m17138e(f14270a, e22222.getMessage());
        }
        try {
            f14278k = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$array");
        } catch (ClassNotFoundException e222222) {
            UmLog.m17138e(f14270a, e222222.getMessage());
        }
        try {
            f14279l = Class.forName((!TextUtils.isEmpty(PushAgent.getInstance(this.f14280c).getResourcePackageName()) ? PushAgent.getInstance(this.f14280c).getResourcePackageName() : this.f14280c.getPackageName()) + ".R$raw");
        } catch (ClassNotFoundException e2222222) {
            UmLog.m17138e(f14270a, e2222222.getMessage());
        }
    }

    private int m17178a(Class<?> cls, String str) {
        if (cls == null) {
            UmLog.m17138e(f14270a, "getRes(null," + str + C4233j.f14397t);
            throw new IllegalArgumentException("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have " + this.f14280c.getPackageName() + ".R$* configured in obfuscation. field=" + str);
        }
        try {
            return cls.getField(str).getInt(str);
        } catch (Exception e) {
            UmLog.m17138e(f14270a, "getRes(" + cls.getName() + ", " + str + C4233j.f14397t);
            UmLog.m17138e(f14270a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
            UmLog.m17138e(f14270a, e.getMessage());
            return -1;
        }
    }

    public static C4211c m17179a(Context context) {
        if (f14271b == null) {
            f14271b = new C4211c(context);
        }
        return f14271b;
    }

    public int m17180a(String str) {
        return m17178a(f14275h, str);
    }

    public String m17181a() {
        return TextUtils.isEmpty(this.f14281d) ? this.f14280c.getPackageName() : this.f14281d;
    }

    public int m17182b(String str) {
        return m17178a(f14272e, str);
    }

    public int m17183c(String str) {
        return m17178a(f14273f, str);
    }

    public int m17184d(String str) {
        return m17178a(f14274g, str);
    }

    public int m17185e(String str) {
        return m17178a(f14276i, str);
    }

    public int m17186f(String str) {
        return m17178a(f14277j, str);
    }

    public int m17187g(String str) {
        return m17178a(f14278k, str);
    }

    public int m17188h(String str) {
        return m17178a(f14279l, str);
    }

    public void m17189i(String str) {
        this.f14281d = str;
    }
}
