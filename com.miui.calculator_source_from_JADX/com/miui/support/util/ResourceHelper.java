package com.miui.support.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class ResourceHelper {
    private static final String[] f3710a;

    private ResourceHelper() {
    }

    static {
        f3710a = new String[0];
    }

    public static XmlResourceParser m5438a(Context context, String str, String str2, String... strArr) {
        int b = m5440b(context, str, str2, strArr);
        if (b > 0) {
            return context.getResources().getXml(b);
        }
        Log.i("ResourceHelper", "Fail to load config for resource id is " + b);
        return null;
    }

    private static int m5440b(Context context, String str, String str2, String... strArr) {
        int i;
        Bundle a = m5439a(context);
        if (a == null) {
            Log.w("ResourceHelper", "Fail to load meta data");
        } else {
            i = a.getInt(str);
            if (i > 0) {
                return i;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            i = context.getResources().getIdentifier(str2, "xml", context.getPackageName());
            if (i > 0) {
                return i;
            }
            for (String identifier : strArr) {
                i = context.getResources().getIdentifier(str2, "xml", identifier);
                if (i > 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Bundle m5439a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo.metaData == null) {
            try {
                applicationInfo.metaData = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (Throwable e) {
                Log.e("ResourceHelper", "Fail to load config for application not found", e);
            }
        }
        return applicationInfo.metaData;
    }
}
