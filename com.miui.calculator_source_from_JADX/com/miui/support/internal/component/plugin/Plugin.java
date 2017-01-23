package com.miui.support.internal.component.plugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Plugin {
    private File f2327a;
    private String f2328b;
    private String f2329c;
    private int f2330d;
    private String f2331e;
    private int f2332f;
    private int f2333g;
    private AccessPermission f2334h;
    private Map<String, Dependency> f2335i;
    private Map<String, Extension> f2336j;
    private Map<String, Outlet> f2337k;

    public Plugin() {
        this.f2335i = new HashMap();
        this.f2336j = new HashMap();
        this.f2337k = new HashMap();
    }

    public void m3928a(File file) {
        this.f2327a = file;
    }

    public String m3922a() {
        return this.f2328b;
    }

    public void m3929a(String str) {
        this.f2328b = str;
    }

    public void m3932b(String str) {
        this.f2329c = str;
    }

    public int m3930b() {
        return this.f2330d;
    }

    public void m3923a(int i) {
        this.f2330d = i;
    }

    public void m3935c(String str) {
        this.f2331e = str;
    }

    public int m3933c() {
        return this.f2332f;
    }

    public void m3931b(int i) {
        this.f2332f = i;
    }

    public void m3934c(int i) {
        this.f2333g = i;
    }

    public void m3924a(AccessPermission accessPermission) {
        this.f2334h = accessPermission;
    }

    public void m3925a(Dependency dependency) {
        this.f2335i.put(dependency.m3910a(), dependency);
    }

    public Map<String, Extension> m3936d() {
        return this.f2336j;
    }

    public void m3926a(Extension extension) {
        this.f2336j.put(extension.m3916a(), extension);
    }

    public void m3927a(Outlet outlet) {
        this.f2337k.put(outlet.m3919a(), outlet);
    }
}
