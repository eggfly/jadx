package com.miui.support.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import com.miui.support.C0234R;
import com.miui.support.internal.util.ResourcesUtils;
import com.miui.support.module.Dependency;
import com.miui.support.module.Dependency.Level;
import com.miui.support.module.Module;
import java.util.HashMap;
import java.util.Map;

public class ManifestParser {
    private static final Map<String, String> f1950a;
    private Resources f1951b;
    private XmlResourceParser f1952c;

    static {
        f1950a = new HashMap(3);
        f1950a.put("com.miui.core", "miui");
        f1950a.put("com.miui.system", "com.miui.support.system");
        f1950a.put("com.miui.rom", "android.miui");
    }

    private ManifestParser(Resources resources, XmlResourceParser xmlResourceParser) {
        this.f1951b = resources;
        this.f1952c = xmlResourceParser;
    }

    public static ManifestParser m3340a(Context context) {
        Bundle bundle = null;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return m3343a(context.getResources(), context.getPackageName(), bundle);
    }

    public static ManifestParser m3341a(PackageManager packageManager, String str) {
        ApplicationInfo applicationInfo = packageManager.getPackageArchiveInfo(str, 128).applicationInfo;
        return m3343a(ResourcesUtils.m4242a(str), applicationInfo.packageName, applicationInfo.metaData);
    }

    public static ManifestParser m3347b(PackageManager packageManager, String str) {
        try {
            return m3343a(ResourcesUtils.m4242a(packageManager.getApplicationInfo(str, 128).sourceDir), str, packageManager.getApplicationInfo(str, 128).metaData);
        } catch (NameNotFoundException e) {
            Log.w("miuisdk", "cannot find package " + str);
            return m3342a(null, null);
        }
    }

    public static ManifestParser m3343a(Resources resources, String str, Bundle bundle) {
        int i = 0;
        if (bundle != null) {
            i = bundle.getInt("com.miui.sdk.manifest");
        }
        if (i == 0) {
            String str2 = (String) f1950a.get(str);
            if (str2 != null) {
                str = str2;
            }
            i = resources.getIdentifier("miui_manifest", "xml", str);
        }
        return m3342a(resources, i == 0 ? null : resources.getXml(i));
    }

    public static ManifestParser m3342a(Resources resources, XmlResourceParser xmlResourceParser) {
        return new ManifestParser(resources, xmlResourceParser);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.miui.support.core.Manifest m3355a(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0007;
    L_0x0002:
        r0 = new java.util.HashMap;
        r0.<init>();
    L_0x0007:
        r1 = new com.miui.support.core.Manifest;
        r1.<init>();
        r0 = r5.f1952c;
        if (r0 == 0) goto L_0x0032;
    L_0x0010:
        r0 = r5.f1951b;	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
        r2 = r5.f1952c;	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
    L_0x0014:
        r3 = r2.next();	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
        r4 = 2;
        if (r3 == r4) goto L_0x001e;
    L_0x001b:
        r4 = 1;
        if (r3 != r4) goto L_0x0014;
    L_0x001e:
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
        r4 = "manifest";
        r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
        if (r3 == 0) goto L_0x002d;
    L_0x002a:
        r5.m3345a(r1, r0, r2);	 Catch:{ XmlPullParserException -> 0x0037, IOException -> 0x0041 }
    L_0x002d:
        r0 = r5.f1952c;
        r0.close();
    L_0x0032:
        r0 = r5.m3339a(r1);
        return r0;
    L_0x0037:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x004b }
        r0 = r5.f1952c;
        r0.close();
        goto L_0x0032;
    L_0x0041:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x004b }
        r0 = r5.f1952c;
        r0.close();
        goto L_0x0032;
    L_0x004b:
        r0 = move-exception;
        r1 = r5.f1952c;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.core.ManifestParser.a(java.util.Map):com.miui.support.core.Manifest");
    }

    private void m3345a(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(xmlResourceParser, C0234R.styleable.MiuiManifest);
        Module module = new Module();
        module.m5063a(obtainAttributes.getString(C0234R.styleable.MiuiManifest_name));
        module.m5062a(obtainAttributes.getInteger(C0234R.styleable.MiuiManifest_level, 0));
        module.m5065b(obtainAttributes.getInteger(C0234R.styleable.MiuiManifest_moduleContent, 0));
        manifest.m3335a(module);
        obtainAttributes.recycle();
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (!(next == 3 || next == 4)) {
                String name = xmlResourceParser.getName();
                if ("uses-sdk".equals(name)) {
                    m3348b(manifest, resources, xmlResourceParser);
                } else if ("modules".equals(name)) {
                    m3350c(manifest, resources, xmlResourceParser);
                } else if ("dependencies".equals(name)) {
                    m3353e(manifest, resources, xmlResourceParser);
                }
            }
        }
    }

    private void m3348b(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(xmlResourceParser, C0234R.styleable.MiuiManifestUsesSdk);
        Level level = new Level();
        level.m5051a(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestUsesSdk_minLevel, m3346b(level)));
        level.m5053b(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestUsesSdk_targetLevel, m3349c(level)));
        level.m5054c(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestUsesSdk_maxLevel, m3351d(level)));
        manifest.m3334a(m3344a(level));
        obtainAttributes.recycle();
    }

    private void m3350c(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (!(next == 3 || next == 4)) {
                if ("module".equals(xmlResourceParser.getName())) {
                    m3352d(manifest, resources, xmlResourceParser);
                }
            }
        }
    }

    private void m3352d(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(xmlResourceParser, C0234R.styleable.MiuiManifestModule);
        String string = obtainAttributes.getString(C0234R.styleable.MiuiManifestModule_name);
        Dependency dependency = new Dependency();
        dependency.m5058a(string);
        dependency.m5056a(obtainAttributes.getInt(C0234R.styleable.MiuiManifestModule_dependencyType, 0));
        Level level = new Level();
        level.m5051a(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_minLevel, m3346b(level)));
        level.m5053b(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_targetLevel, m3349c(level)));
        level.m5054c(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_maxLevel, m3351d(level)));
        dependency.m5057a(level);
        manifest.m3336a(string, dependency);
        obtainAttributes.recycle();
    }

    private void m3353e(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (!(next == 3 || next == 4)) {
                if ("dependency".equals(xmlResourceParser.getName())) {
                    m3354f(manifest, resources, xmlResourceParser);
                }
            }
        }
    }

    private void m3354f(Manifest manifest, Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(xmlResourceParser, C0234R.styleable.MiuiManifestModule);
        String string = obtainAttributes.getString(C0234R.styleable.MiuiManifestModule_name);
        Dependency dependency = new Dependency();
        dependency.m5058a(string);
        dependency.m5056a(2);
        Level level = new Level();
        level.m5051a(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_minLevel, m3346b(level)));
        level.m5053b(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_targetLevel, m3349c(level)));
        level.m5054c(obtainAttributes.getInteger(C0234R.styleable.MiuiManifestModule_maxLevel, m3351d(level)));
        dependency.m5057a(level);
        manifest.m3336a(string, dependency);
        obtainAttributes.recycle();
    }

    private Manifest m3339a(Manifest manifest) {
        if (manifest.m3333a() == null) {
            manifest.m3335a(new Module());
        }
        if (manifest.m3337b() == null) {
            Level level = new Level();
            level.m5051a(m3346b(level));
            level.m5053b(m3349c(level));
            level.m5054c(m3351d(level));
            manifest.m3334a(m3344a(level));
        }
        return manifest;
    }

    private Dependency m3344a(Level level) {
        Dependency dependency = new Dependency();
        dependency.m5058a("com.miui.core");
        dependency.m5056a(2);
        dependency.m5057a(level);
        return dependency;
    }

    private int m3346b(Level level) {
        return 1;
    }

    private int m3349c(Level level) {
        return level.m5050a();
    }

    private int m3351d(Level level) {
        return Integer.MAX_VALUE;
    }
}
