package com.miui.support.core;

import com.miui.support.module.Dependency;
import com.miui.support.module.Module;
import java.util.LinkedHashMap;
import java.util.Map;

public class Manifest {
    private Module f1947a;
    private Dependency f1948b;
    private Map<String, Dependency> f1949c;

    public Manifest() {
        this.f1949c = new LinkedHashMap();
    }

    public Module m3333a() {
        return this.f1947a;
    }

    public void m3335a(Module module) {
        this.f1947a = module;
    }

    public Dependency m3337b() {
        return this.f1948b;
    }

    public void m3334a(Dependency dependency) {
        this.f1948b = dependency;
    }

    public Map<String, Dependency> m3338c() {
        return this.f1949c;
    }

    public Dependency m3332a(String str) {
        return (Dependency) this.f1949c.get(str);
    }

    public void m3336a(String str, Dependency dependency) {
        this.f1949c.put(str, dependency);
    }
}
