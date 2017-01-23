package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4304b;
import com.xiaomi.channel.commonutils.reflect.C4323a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.channel.commonutils.android.b */
public class C4290b {

    /* renamed from: com.xiaomi.channel.commonutils.android.b.a */
    public enum C4289a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        
        private final int f14710d;

        private C4289a(int i) {
            this.f14710d = i;
        }

        public int m17596a() {
            return this.f14710d;
        }
    }

    public static String m17597a(Context context) {
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            return (C4304b.m17660a(runningTasks) || runningTasks.get(0) == null || ((RunningTaskInfo) runningTasks.get(0)).topActivity == null) ? null : ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m17598a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, SpdyProtocol.SLIGHTSSL_L7E);
        } catch (Throwable e) {
            C4302b.m17651a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : BuildConfig.VERSION_NAME;
    }

    public static int m17599b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, SpdyProtocol.SLIGHTSSL_L7E);
        } catch (Throwable e) {
            C4302b.m17651a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionCode : 0;
    }

    public static boolean m17600b(Context context) {
        return TextUtils.equals(context.getPackageName(), C4290b.m17597a(context));
    }

    public static int m17601c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    @TargetApi(19)
    public static C4289a m17602d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || VERSION.SDK_INT < 19) {
            return C4289a.UNKNOWN;
        }
        try {
            if (((Integer) C4323a.m17714a(AppOpsManager.class, "OP_POST_NOTIFICATION")) == null) {
                return C4289a.UNKNOWN;
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            Integer num = (Integer) C4323a.m17717a((AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            return (num == null || num.intValue() != 0) ? C4289a.NOT_ALLOWED : C4289a.ALLOWED;
        } catch (Throwable th) {
            return C4289a.UNKNOWN;
        }
    }

    public static Signature[] m17603e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 64).signatures;
        } catch (Exception e) {
            return null;
        }
    }
}
