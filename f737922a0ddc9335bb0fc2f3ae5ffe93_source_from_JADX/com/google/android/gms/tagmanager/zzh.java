package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzh extends i {
    private static final String j6;
    private final Context DW;

    static {
        j6 = f.APP_VERSION.toString();
    }

    public zzh(Context context) {
        super(j6, new String[0]);
        this.DW = context;
    }

    public a j6(Map<String, a> map) {
        try {
            return as.FH(Integer.valueOf(this.DW.getPackageManager().getPackageInfo(this.DW.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(this.DW.getPackageName());
            String valueOf2 = String.valueOf(e.getMessage());
            r.j6(new StringBuilder((String.valueOf(valueOf).length() + 25) + String.valueOf(valueOf2).length()).append("Package name ").append(valueOf).append(" not found. ").append(valueOf2).toString());
            return as.j6();
        }
    }

    public boolean j6() {
        return true;
    }
}
