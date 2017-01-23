package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class e {
    public static fi j6(Context context) {
        return j6(context, null);
    }

    public static fi j6(Context context, id idVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (idVar == null) {
            idVar = VERSION.SDK_INT >= 9 ? new ie() : new ib(AndroidHttpClient.newInstance(str));
        }
        fi fiVar = new fi(new ia(file), new hu(idVar));
        fiVar.j6();
        return fiVar;
    }
}
