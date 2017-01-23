package com.baidu.mobads.p080j;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.openad.p096e.C2024d;
import com.baidu.mobads.p081a.C1907a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.baidu.mobads.j.k */
public class C1990k implements IXAdPackageUtils {
    public int getAppVersion(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSL_L7E).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    public Intent getInstallIntent(String str) {
        try {
            Uri fromFile = Uri.fromFile(new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public ApkInfo getLocalApkFileInfo(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            return packageArchiveInfo != null ? new ApkInfo(context, packageArchiveInfo) : null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isForeground(Context context, String str) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInstalled(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            return applicationInfo != null && str.equals(applicationInfo.packageName);
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    @TargetApi(3)
    public void openApp(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e) {
        }
    }

    public boolean sendAPOInfo(Context context, String str, String str2, int i, int i2) {
        String str3;
        boolean z = false;
        PackageManager packageManager = context.getPackageManager();
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        IXAdURIUitls i3 = C1991m.m7449a().m7460i();
        C1982d m = C1991m.m7449a().m7464m();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        String encodeUrl = i3.encodeUrl(str);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, AccessibilityNodeInfoCompat.ACTION_CUT);
        encodeUrl = "&sn=" + n.getEncodedSN(context) + "&fb_act=" + i2 + "&pack=" + context.getPackageName() + "&v=" + ("android_" + C1907a.f6655c + "_" + "4.1.30") + "&targetscheme=" + encodeUrl + "&pk=" + str2;
        String str4 = "&open=";
        if (queryIntentActivities.size() > 0) {
            str3 = (str4 + "true") + "&n=" + queryIntentActivities.size();
            int i4 = 0;
            while (i4 < queryIntentActivities.size()) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i4);
                str3 = i4 == 0 ? str3 + "&p=" + resolveInfo.activityInfo.packageName : str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + resolveInfo.activityInfo.packageName;
                i4++;
            }
            z = true;
        } else {
            str3 = str4 + "false";
        }
        try {
            C2024d c2024d = new C2024d(i3.addParameters(m.vdUrl(encodeUrl + str3, i), null), BuildConfig.FLAVOR);
            c2024d.f7057e = 1;
            new C2021a().m7545a(c2024d);
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7393d("XAdPackageUtils", e.getMessage());
        }
        return z;
    }

    public void sendAPOIsSuccess(Context context, boolean z, int i, String str, String str2) {
        C1982d m = C1991m.m7449a().m7464m();
        IXAdURIUitls i2 = C1991m.m7449a().m7460i();
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        IBase64 e = C1991m.m7449a().m7456e();
        String encodeUrl = i2.encodeUrl(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aposuccess=" + z);
        if (!z) {
            stringBuilder.append("&failtime=" + i);
        }
        stringBuilder.append("&sn=" + n.getEncodedSN(context));
        stringBuilder.append("&mac=" + e.encode(n.getMacAddress(context)));
        stringBuilder.append("&cuid=" + n.getCUID(context));
        stringBuilder.append("&pack=" + context.getPackageName());
        stringBuilder.append("&v=" + ("android_" + C1907a.f6655c + "_" + "4.1.30"));
        stringBuilder.append("&targetscheme=" + encodeUrl);
        stringBuilder.append("&pk=" + str2);
        try {
            C2024d c2024d = new C2024d(i2.addParameters(m.vdUrl(stringBuilder.toString(), 369), null), BuildConfig.FLAVOR);
            c2024d.f7057e = 1;
            new C2021a().m7545a(c2024d);
        } catch (Exception e2) {
            C1991m.m7449a().m7457f().m7393d("XAdPackageUtils", e2.getMessage());
        }
    }

    public void sendDialerIsSuccess(Context context, boolean z, int i, String str) {
        C1982d m = C1991m.m7449a().m7464m();
        IXAdURIUitls i2 = C1991m.m7449a().m7460i();
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        IBase64 e = C1991m.m7449a().m7456e();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("callstate=" + z);
        if (!z) {
            stringBuilder.append("&duration=" + i);
        }
        stringBuilder.append("&sn=" + n.getEncodedSN(context));
        stringBuilder.append("&mac=" + e.encode(n.getMacAddress(context)));
        stringBuilder.append("&bdr=" + VERSION.SDK_INT);
        stringBuilder.append("&cuid=" + n.getCUID(context));
        stringBuilder.append("&pack=" + context.getPackageName());
        stringBuilder.append("&v=" + ("android_" + C1907a.f6655c + "_" + "4.1.30"));
        stringBuilder.append("&pk=" + str);
        try {
            C2024d c2024d = new C2024d(i2.addParameters(m.vdUrl(stringBuilder.toString(), 372), null), BuildConfig.FLAVOR);
            c2024d.f7057e = 1;
            new C2021a().m7545a(c2024d);
        } catch (Exception e2) {
            C1991m.m7449a().m7457f().m7393d("XAdPackageUtils", e2.getMessage());
        }
    }
}
