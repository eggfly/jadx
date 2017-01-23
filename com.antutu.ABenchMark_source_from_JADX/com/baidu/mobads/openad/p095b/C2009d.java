package com.baidu.mobads.openad.p095b;

import java.util.HashMap;

/* renamed from: com.baidu.mobads.openad.b.d */
public class C2009d implements C2006a {
    public static String f6989a;
    private HashMap<String, String> f6990b;

    static {
        f6989a = "_uid=b000_5511089179943706094;expires=Dec, 21 Aug 2014 06:40:41 GMT;domain=.youku.com;path=/;";
    }

    public C2009d() {
        this.f6990b = new HashMap();
    }

    public String m7490a(String str) {
        return (String) this.f6990b.get(str);
    }

    public void m7491a() {
        m7493b();
    }

    public void m7492a(String str, String str2) {
        this.f6990b.put(str, str2);
    }

    public void m7493b() {
        for (String remove : this.f6990b.keySet()) {
            this.f6990b.remove(remove);
        }
    }
}
