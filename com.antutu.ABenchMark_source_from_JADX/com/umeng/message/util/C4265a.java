package com.umeng.message.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/* renamed from: com.umeng.message.util.a */
public class C4265a {
    private final Properties f14585a;

    private C4265a() {
        this.f14585a = new Properties();
        this.f14585a.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    public static C4265a m17534g() {
        return new C4265a();
    }

    public String m17535a(String str) {
        return this.f14585a.getProperty(str);
    }

    public String m17536a(String str, String str2) {
        return this.f14585a.getProperty(str, str2);
    }

    public Set<Entry<Object, Object>> m17537a() {
        return this.f14585a.entrySet();
    }

    public boolean m17538a(Object obj) {
        return this.f14585a.containsKey(obj);
    }

    public boolean m17539b() {
        return this.f14585a.isEmpty();
    }

    public boolean m17540b(Object obj) {
        return this.f14585a.containsValue(obj);
    }

    public Enumeration<Object> m17541c() {
        return this.f14585a.keys();
    }

    public Set<Object> m17542d() {
        return this.f14585a.keySet();
    }

    public int m17543e() {
        return this.f14585a.size();
    }

    public Collection<Object> m17544f() {
        return this.f14585a.values();
    }
}
