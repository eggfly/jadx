package com.miui.support.internal.component.plugin;

import android.content.Context;
import android.content.res.Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PluginLoader {
    private static Map<String, Plugin> f2344a;
    private static Map<String, List<Plugin>> f2345b;
    private static Map<String, ClassLoader> f2346c;
    private static Map<String, Resources> f2347d;
    private File f2348e;
    private File f2349f;

    static {
        f2344a = new HashMap();
        f2345b = new HashMap();
        f2346c = new HashMap();
        f2347d = new HashMap();
    }

    public PluginLoader(File file) {
        this.f2348e = file;
        this.f2349f = new File(this.f2348e.getParentFile(), "plugins-opt");
        this.f2348e.mkdirs();
        this.f2349f.mkdirs();
        m3945a();
        m3947c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3945a() {
        /*
        r8 = this;
        r8.m3946b();
        r0 = r8.f2348e;
        r4 = r0.listFiles();
        if (r4 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r5 = r4.length;
        r0 = 0;
        r3 = r0;
    L_0x000f:
        if (r3 >= r5) goto L_0x000b;
    L_0x0011:
        r0 = r4[r3];
        r1 = r0.getName();
        r2 = ".apk";
        r1 = r1.endsWith(r2);
        if (r1 == 0) goto L_0x006d;
    L_0x001f:
        r6 = new java.io.File;
        r1 = r8.f2348e;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r7 = r0.getPath();
        r7 = com.miui.support.os.FileUtils.m5179a(r7);
        r2 = r2.append(r7);
        r7 = ".xml";
        r2 = r2.append(r7);
        r2 = r2.toString();
        r6.<init>(r1, r2);
        r2 = 0;
        r1 = r6.exists();	 Catch:{ IOException -> 0x0076, PluginParseException -> 0x0086, all -> 0x0096 }
        if (r1 != 0) goto L_0x00a9;
    L_0x0048:
        r1 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0076, PluginParseException -> 0x0086, all -> 0x0096 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0076, PluginParseException -> 0x0086, all -> 0x0096 }
        r2 = new java.util.zip.ZipEntry;	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        r7 = "assets/PluginManifest.xml";
        r2.<init>(r7);	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        r2 = r1.getInputStream(r2);	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        com.miui.support.os.FileUtils.m5181a(r2, r6);	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
    L_0x005b:
        r0 = r8.m3943a(r6, r0);	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        r2 = f2344a;	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        r6 = r0.m3922a();	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        r2.put(r6, r0);	 Catch:{ IOException -> 0x00a7, PluginParseException -> 0x00a5 }
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ IOException -> 0x0071 }
    L_0x006d:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x000f;
    L_0x0071:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x006d;
    L_0x0076:
        r0 = move-exception;
        r1 = r2;
    L_0x0078:
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x006d;
    L_0x007d:
        r1.close();	 Catch:{ IOException -> 0x0081 }
        goto L_0x006d;
    L_0x0081:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x006d;
    L_0x0086:
        r0 = move-exception;
        r1 = r2;
    L_0x0088:
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x006d;
    L_0x008d:
        r1.close();	 Catch:{ IOException -> 0x0091 }
        goto L_0x006d;
    L_0x0091:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x006d;
    L_0x0096:
        r0 = move-exception;
        r1 = r2;
    L_0x0098:
        if (r1 == 0) goto L_0x009d;
    L_0x009a:
        r1.close();	 Catch:{ IOException -> 0x009e }
    L_0x009d:
        throw r0;
    L_0x009e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x009d;
    L_0x00a3:
        r0 = move-exception;
        goto L_0x0098;
    L_0x00a5:
        r0 = move-exception;
        goto L_0x0088;
    L_0x00a7:
        r0 = move-exception;
        goto L_0x0078;
    L_0x00a9:
        r1 = r2;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.component.plugin.PluginLoader.a():void");
    }

    private void m3946b() {
        Plugin plugin = null;
        Context b = PluginContext.m3937a().m3942b();
        try {
            String packageResourcePath = b.getPackageResourcePath();
            if (packageResourcePath != null) {
                plugin = m3944a(b.getAssets().open("PluginManifest.xml"), new File(packageResourcePath));
            }
        } catch (IOException e) {
        } catch (PluginParseException e2) {
            e2.printStackTrace();
        }
        if (plugin == null) {
            plugin = new Plugin();
            plugin.m3929a(b.getPackageName());
            plugin.m3932b(b.getPackageName());
            plugin.m3924a(AccessPermission.PRIVATE);
        }
        f2344a.put(plugin.m3922a(), plugin);
        f2346c.put(plugin.m3922a(), getClass().getClassLoader());
        f2347d.put(plugin.m3922a(), b.getResources());
    }

    private Plugin m3943a(File file, File file2) {
        return m3944a(new FileInputStream(file), file2);
    }

    private Plugin m3944a(InputStream inputStream, File file) {
        Plugin a = new PluginManifestParser().m3959a(inputStream);
        a.m3928a(file);
        return a;
    }

    private void m3947c() {
        for (String str : f2344a.keySet()) {
            Plugin plugin = (Plugin) f2344a.get(str);
            for (String str2 : plugin.m3936d().keySet()) {
                List list = (List) f2345b.get(str2);
                if (list == null) {
                    list = new ArrayList();
                    f2345b.put(str2, list);
                }
                list.add(plugin);
            }
        }
    }
}
