package com.miui.support.internal.hybrid;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Security f2423a;
    private String f2424b;
    private String f2425c;
    private Map<String, Feature> f2426d;
    private Map<String, String> f2427e;
    private Map<String, Permission> f2428f;

    public Config() {
        this.f2426d = new HashMap();
        this.f2427e = new HashMap();
        this.f2428f = new HashMap();
    }

    public Security m3994a() {
        return this.f2423a;
    }

    public void m3997a(Security security) {
        this.f2423a = security;
    }

    public String m4000b() {
        return this.f2424b;
    }

    public void m3998a(String str) {
        this.f2424b = str;
    }

    public String m4003c() {
        return this.f2425c;
    }

    public void m4001b(String str) {
        this.f2425c = str;
    }

    public Map<String, Feature> m4005d() {
        return this.f2426d;
    }

    public Feature m4002c(String str) {
        return (Feature) this.f2426d.get(str);
    }

    public void m3995a(Feature feature) {
        this.f2426d.put(feature.m4014a(), feature);
    }

    public void m3999a(String str, String str2) {
        this.f2427e.put(str, str2);
    }

    public Map<String, Permission> m4006e() {
        return this.f2428f;
    }

    public Permission m4004d(String str) {
        return (Permission) this.f2428f.get(str);
    }

    public void m3996a(Permission permission) {
        this.f2428f.put(permission.m4065a(), permission);
    }
}
