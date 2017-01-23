package com.miui.support.internal.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.miui.support.core.Manifest;
import com.miui.support.core.ManifestParser;
import com.miui.support.util.AppConstants;
import java.io.File;

public class PackageConstants extends AppConstants {
    public static Application f2564a;
    public static int f2565b;
    public static final String f2566c;
    public static final int f2567d;

    private PackageConstants() {
    }

    static {
        f2565b = 0;
        f2566c = PackageHelper.m4231a(null, "com.miui.core", "miui");
        f2567d = m4229b();
    }

    private static int m4229b() {
        int i = 0;
        if (!PackageHelper.m4239b()) {
            Manifest a = ManifestParser.m3343a(ResourcesUtils.m4242a(f2566c), "miui", null).m3355a(null);
            if (a != null) {
                i = a.m3333a().m5064b();
                Log.d("miuisdk", "current sdk level is " + i);
            }
            if (i == 0) {
                throw new IllegalStateException("cannot retrieve sdk level");
            }
        }
        return i;
    }

    public static File m4228a(Context context) {
        return new File(context.getFilesDir(), "miuisdk");
    }
}
