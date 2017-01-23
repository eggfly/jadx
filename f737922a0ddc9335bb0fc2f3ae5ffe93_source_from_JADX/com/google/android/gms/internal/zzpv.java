package com.google.android.gms.internal;

import agb;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public class zzpv {
    protected final Context j6;

    public zzpv(Context context) {
        this.j6 = context;
    }

    public PackageInfo DW(String str, int i) {
        return this.j6.getPackageManager().getPackageInfo(str, i);
    }

    public ApplicationInfo j6(String str, int i) {
        return this.j6.getPackageManager().getApplicationInfo(str, i);
    }

    @TargetApi(19)
    public boolean j6(int i, String str) {
        if (agb.VH()) {
            try {
                ((AppOpsManager) this.j6.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.j6.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
