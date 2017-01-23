package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.misc.C4303a;
import java.util.Map;

/* renamed from: com.xiaomi.smack.b */
public class C4403b implements Cloneable {
    public static String f15031b;
    public static String f15032c;
    private String f15033a;
    private String f15034d;
    private int f15035e;
    private boolean f15036f;
    private boolean f15037g;
    private String f15038h;
    private C4463e f15039i;

    static {
        f15031b = "wcc-ml-test10.bj";
        f15032c = null;
    }

    public C4403b(Map<String, Integer> map, int i, String str, C4463e c4463e) {
        this.f15036f = C4461a.f15300a;
        this.f15037g = true;
        m18155a(map, i, str, c4463e);
    }

    private void m18155a(Map<String, Integer> map, int i, String str, C4463e c4463e) {
        this.f15034d = C4403b.m18156b();
        this.f15035e = i;
        this.f15033a = str;
        this.f15039i = c4463e;
    }

    public static final String m18156b() {
        return f15032c != null ? f15032c : C4303a.m17657a() ? "sandbox.xmpush.xiaomi.com" : C4303a.m17658b() ? "10.237.14.141" : "app.chat.xiaomi.net";
    }

    public void m18157a(String str) {
        this.f15033a = str;
    }

    public void m18158a(boolean z) {
        this.f15036f = z;
    }

    public byte[] m18159a() {
        return null;
    }

    public void m18160b(String str) {
        this.f15038h = str;
    }

    public String m18161c() {
        return this.f15033a;
    }

    public void m18162c(String str) {
        this.f15034d = str;
    }

    public String m18163d() {
        return this.f15038h;
    }

    public int m18164e() {
        return this.f15035e;
    }

    public String m18165f() {
        return this.f15034d;
    }

    public boolean m18166g() {
        return this.f15036f;
    }
}
