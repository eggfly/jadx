package com.miui.support.internal.component.module;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.os.FileUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ModuleUtils {
    private ModuleUtils() {
    }

    public static File m3907a(String str) {
        return new File(new File(str).getParent(), FileUtils.m5179a(str) + ".lib");
    }

    public static boolean m3908b(String str) {
        Context context = PackageConstants.f2564a;
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 64);
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageArchiveInfo == null || r1 == null || m3906a(packageArchiveInfo.signatures, r1.signatures) != 0) {
            return false;
        }
        return true;
    }

    private static int m3906a(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null) {
            return -3;
        }
        Set hashSet = new HashSet();
        for (Object add : signatureArr) {
            hashSet.add(add);
        }
        Set hashSet2 = new HashSet();
        for (Object add2 : signatureArr2) {
            hashSet2.add(add2);
        }
        if (hashSet.equals(hashSet2)) {
            return 0;
        }
        return -3;
    }
}
