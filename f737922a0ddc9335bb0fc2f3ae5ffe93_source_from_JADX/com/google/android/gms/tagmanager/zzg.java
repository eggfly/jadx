package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzg extends i {
    private static final String j6;
    private final Context DW;

    static {
        j6 = f.APP_NAME.toString();
    }

    public zzg(Context context) {
        super(j6, new String[0]);
        this.DW = context;
    }

    public a j6(Map<String, a> map) {
        try {
            PackageManager packageManager = this.DW.getPackageManager();
            return as.FH(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.DW.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            r.j6("App name is not found.", e);
            return as.j6();
        }
    }

    public boolean j6() {
        return true;
    }
}
