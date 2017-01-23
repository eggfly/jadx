package com.miui.support.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import com.android.server.pm.PackageManagerService;
import com.miui.support.internal.util.UrlResolverHelper;
import java.lang.reflect.Method;
import java.util.List;

public class UrlResolver {
    private static Method f3716a;

    static {
        f3716a = null;
    }

    private UrlResolver() {
    }

    public static ResolveInfo m5446a(Context context, PackageManager packageManager, Intent intent) {
        return m5447a(context, true, packageManager, null, intent, null, 0, null, 0);
    }

    private static ResolveInfo m5447a(Context context, boolean z, PackageManager packageManager, PackageManagerService packageManagerService, Intent intent, String str, int i, List<ResolveInfo> list, int i2) {
        if (z) {
            list = packageManager.queryIntentActivities(intent, 0);
        }
        int i3 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ResolveInfo resolveInfo = (ResolveInfo) list.get(i4);
            if (resolveInfo.activityInfo.packageName.equals("com.android.browser")) {
                i3 = i4;
            } else if (UrlResolverHelper.m4261c(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            } else {
                try {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0);
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    if (!(packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 0)) {
                        return resolveInfo;
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        Uri data = intent.getData();
        if (data == null) {
            return null;
        }
        String host = data.getHost();
        if (host == null) {
            return null;
        }
        if (!UrlResolverHelper.m4260b(host)) {
            return null;
        }
        String a = UrlResolverHelper.m4257a(data);
        if (a != null) {
            Uri parse = Uri.parse(a);
            Object obj = null;
            if (UrlResolverHelper.m4262d(parse.getScheme())) {
                obj = 1;
                parse = UrlResolverHelper.m4263e(a);
            }
            intent.setData(parse);
            if (z) {
                if (obj == null) {
                    return m5446a(context, packageManager, intent);
                }
                context.startActivity(intent);
                return new ResolveInfo();
            } else if (VERSION.SDK_INT <= 20) {
                return packageManagerService.resolveIntent(intent, str, i, i2);
            } else {
                try {
                    if (f3716a == null) {
                        f3716a = context.getClassLoader().loadClass("com.android.server.pm.PackageManagerService").getDeclaredMethod("resolveIntent", new Class[]{Intent.class, String.class, Integer.TYPE, Integer.TYPE});
                    }
                    return (ResolveInfo) f3716a.invoke(packageManagerService, new Object[]{intent, str, Integer.valueOf(i), Integer.valueOf(i2)});
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        } else if (i3 == -1 || z) {
            return null;
        } else {
            return (ResolveInfo) list.get(i3);
        }
    }
}
