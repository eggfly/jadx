package com.miui.support.internal.component.plugin;

import android.content.Context;

public class PluginContext {
    private static volatile PluginContext f2339a;
    private Context f2340b;
    private PluginLoader f2341c;
    private PluginClassLoader f2342d;
    private PluginResourceLoader f2343e;

    public static PluginContext m3937a() {
        if (f2339a == null) {
            synchronized (PluginContext.class) {
                if (f2339a == null) {
                    f2339a = new PluginContext();
                }
            }
        }
        return f2339a;
    }

    private PluginContext() {
    }

    public Context m3942b() {
        return this.f2340b;
    }

    public void m3938a(Context context) {
        this.f2340b = context;
    }

    public void m3940a(PluginLoader pluginLoader) {
        this.f2341c = pluginLoader;
    }

    public void m3939a(PluginClassLoader pluginClassLoader) {
        this.f2342d = pluginClassLoader;
    }

    public void m3941a(PluginResourceLoader pluginResourceLoader) {
        this.f2343e = pluginResourceLoader;
    }
}
