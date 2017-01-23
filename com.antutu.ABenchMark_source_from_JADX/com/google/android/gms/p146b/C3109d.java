package com.google.android.gms.p146b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

/* renamed from: com.google.android.gms.b.d */
public class C3109d {
    public static iv m12199a(Context context) {
        return C3109d.m12200a(context, null);
    }

    public static iv m12200a(Context context, kw kwVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (kwVar == null) {
            kwVar = VERSION.SDK_INT >= 9 ? new kx() : new ku(AndroidHttpClient.newInstance(str));
        }
        iv ivVar = new iv(new kt(file), new kr(kwVar));
        ivVar.m13429a();
        return ivVar;
    }
}
