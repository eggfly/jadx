package com.igexin.push.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.sdk.PushBuildConfig;
import com.umeng.analytics.C4156a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.util.b */
public class C3923b {
    public static void m16150a(C3925d c3925d, Context context) {
        new Thread(new C3924c(context, c3925d)).start();
    }

    private static boolean m16153c(Context context) {
        try {
            byte[] a = C3926e.m16162a(context.getFilesDir().getPath() + "/" + "init_er.pid");
            if (a == null || System.currentTimeMillis() - Long.valueOf(new String(a)).longValue() > C4156a.f13948j) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static String m16154d(Context context) {
        String packageName = context.getPackageName();
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, SpdyProtocol.SLIGHTSSLV2);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                str = applicationInfo.metaData.getString("PUSH_APPID");
            }
        } catch (Exception e) {
        }
        String str2 = Build.MODEL;
        String str3 = VERSION.SDK;
        String str4 = VERSION.RELEASE;
        File file = new File(context.getApplicationInfo().nativeLibraryDir + File.separator + "libgetuiext2.so");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date()));
        stringBuilder.append("|");
        stringBuilder.append(str);
        stringBuilder.append("|");
        stringBuilder.append(PushBuildConfig.sdk_conf_version);
        stringBuilder.append("|");
        stringBuilder.append(file.exists());
        stringBuilder.append("|");
        stringBuilder.append(C3933l.m16184a(context));
        stringBuilder.append("|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        stringBuilder.append("|");
        stringBuilder.append(str4);
        stringBuilder.append("|");
        stringBuilder.append(C3933l.m16185b(context));
        stringBuilder.append("|");
        stringBuilder.append(C3933l.m16183a());
        stringBuilder.append("|");
        stringBuilder.append(packageName);
        if (EncryptUtils.errorMsg != null) {
            stringBuilder.append("|");
            stringBuilder.append(EncryptUtils.errorMsg);
        }
        C3688a.m15097b("ErrorReport|" + stringBuilder.toString());
        return stringBuilder.toString();
    }
}
