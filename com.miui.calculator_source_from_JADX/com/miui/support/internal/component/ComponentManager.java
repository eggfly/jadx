package com.miui.support.internal.component;

import android.content.Context;
import android.content.res.AssetManager;
import com.miui.support.core.Manifest;
import com.miui.support.internal.component.plugin.PluginClassLoader;
import com.miui.support.internal.component.plugin.PluginContext;
import com.miui.support.internal.component.plugin.PluginLoader;
import com.miui.support.internal.component.plugin.PluginResourceLoader;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.module.ModuleManager;
import com.miui.support.os.FileUtils;
import com.miui.support.util.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ComponentManager {
    private Manifest f2297a;

    public ComponentManager(Manifest manifest) {
        this.f2297a = manifest;
    }

    public void m3872a() {
        m3869a(PackageConstants.f2564a, this.f2297a);
        m3871b(PackageConstants.f2564a, this.f2297a);
    }

    private void m3869a(Context context, Manifest manifest) {
        ModuleManager.m5070a().m5080a((String[]) manifest.m3338c().keySet().toArray(new String[0]));
    }

    private void m3871b(Context context, Manifest manifest) {
        PluginContext.m3937a().m3938a(context);
        File a = m3868a(context);
        if (!a.exists()) {
            m3870a(context, "plugins", a);
        }
        PluginLoader pluginLoader = new PluginLoader(a);
        PluginContext.m3937a().m3940a(pluginLoader);
        PluginContext.m3937a().m3939a(new PluginClassLoader(pluginLoader));
        PluginContext.m3937a().m3941a(new PluginResourceLoader(pluginLoader));
    }

    private File m3868a(Context context) {
        return new File(PackageConstants.m4228a(context), "plugins");
    }

    private void m3870a(Context context, String str, File file) {
        try {
            file.mkdirs();
            AssetManager assets = context.getAssets();
            for (String str2 : assets.list(str)) {
                File file2 = new File(file, str2);
                file2.getParentFile().mkdirs();
                InputStream open = assets.open(str + "/" + str2);
                FileUtils.m5181a(open, file2);
                IOUtils.m5387a(open);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
