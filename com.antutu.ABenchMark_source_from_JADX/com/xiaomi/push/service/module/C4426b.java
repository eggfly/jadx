package com.xiaomi.push.service.module;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.service.module.b */
public class C4426b {
    private String f15105a;
    private String f15106b;
    private String f15107c;
    private int f15108d;
    private ClassLoader f15109e;
    private Object f15110f;

    public C4426b(String str, String str2, ClassLoader classLoader, String str3, int i) {
        this.f15108d = 0;
        this.f15105a = str;
        this.f15106b = str2;
        this.f15109e = classLoader;
        this.f15108d = i;
        this.f15107c = str3;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f15110f = this.f15109e.loadClass(str3).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClassLoader m18302a() {
        return this.f15109e;
    }

    public void m18303a(Context context) {
        if (this.f15110f != null) {
            try {
                this.f15109e.loadClass(this.f15107c).getMethod("onCreate", new Class[]{Context.class, String.class}).invoke(this.f15110f, new Object[]{context, this.f15106b});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
