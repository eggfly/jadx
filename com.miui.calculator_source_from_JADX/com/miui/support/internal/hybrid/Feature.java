package com.miui.support.internal.hybrid;

import java.util.HashMap;
import java.util.Map;

public class Feature {
    private String f2429a;
    private Map<String, String> f2430b;

    public Feature() {
        this.f2430b = new HashMap();
    }

    public String m4014a() {
        return this.f2429a;
    }

    public void m4015a(String str) {
        this.f2429a = str;
    }

    public Map<String, String> m4018b() {
        return this.f2430b;
    }

    public String m4017b(String str) {
        return (String) this.f2430b.get(str);
    }

    public void m4016a(String str, String str2) {
        this.f2430b.put(str, str2);
    }
}
