package com.miui.support.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.module.Dependency;
import com.miui.support.module.Dependency.Level;

public class CompatibleManager {
    private Context f1944a;
    private Manifest f1945b;
    private String f1946c;

    public CompatibleManager(Context context, Manifest manifest) {
        this.f1944a = context;
        this.f1945b = manifest;
        this.f1946c = manifest.m3333a().m5061a();
    }

    public boolean m3331a() {
        if (m3330a(this.f1945b.m3337b().m5060c(), PackageConstants.f2567d)) {
            PackageManager packageManager = this.f1944a.getPackageManager();
            if (packageManager == null) {
                Log.w("miuisdk", "package manager is not ready yet");
                return true;
            }
            for (String str : this.f1945b.m3338c().keySet()) {
                Dependency a = this.f1945b.m3332a(str);
                if ((a.m5059b() & 2) != 0) {
                    Manifest a2 = m3329a(packageManager, str);
                    if (a2 == null || !m3330a(a.m5060c(), a2.m3333a().m5064b())) {
                        Log.w("miuisdk", this.f1946c + " is not compatible with module " + str);
                        return false;
                    }
                }
            }
            return true;
        }
        Log.w("miuisdk", this.f1946c + " is not compatible with sdk");
        return false;
    }

    private boolean m3330a(Level level, int i) {
        boolean z = level.m5050a() <= i && i <= level.m5052b();
        if (!z) {
            Log.w("miuisdk", "current is " + i + " but needs [" + level.m5050a() + "-" + level.m5052b() + "]");
        }
        return z;
    }

    private Manifest m3329a(PackageManager packageManager, String str) {
        return ManifestParser.m3347b(packageManager, str).m3355a(null);
    }
}
