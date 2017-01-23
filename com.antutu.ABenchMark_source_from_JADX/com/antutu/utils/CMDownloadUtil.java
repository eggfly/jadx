package com.antutu.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.antutu.redacc.C1692R;
import com.antutu.utils.downloader.DownloadsService;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CMDownloadUtil {
    public static final String ACTION_DOWLOAD_CM_FROM = "com.antutu.ABenchMark.ACTION_DOWLOAD_CM_FROM";
    public static final String ACTION_DOWNLOAD_CM = "download_cm_success";
    public static final String ACTION_DOWNLOAD_CM_INTERRUPTTED = "download_cm_interruptted";
    public static final String CM = "com.cleanmaster.mguard";
    public static final String CM_CN = "com.cleanmaster.mguard_cn";
    private static final String CM_SWITCH_ACTIVITY = "com.cooperate.UISwitchActivity";
    public static final String SHARE_PREF_DOWNLOAD_CM = "download_cm_success";
    public static final String URL_CM_CN = "http://dl.cm.ksmobile.com/cleanmaster_cn/BD/cleanmaste_att_DeviceInfo.apk";
    public static String cmAPK;
    public static boolean isDownloading;
    private static Map<String, String> mDownloadSources;

    static {
        isDownloading = false;
        cmAPK = BuildConfig.FLAVOR;
        String[] split = URL_CM_CN.split("/");
        cmAPK = split[split.length - 1];
        mDownloadSources = new HashMap();
        mDownloadSources.put(PointMark.E_EXIST_APP_DOWNLOAD_CM, "3D200100");
        mDownloadSources.put(PointMark.K_DETAIL_SCORES_CLEAN_GARBAGE, "3D200101");
        mDownloadSources.put(PointMark.K_STABILITY_CLEAN_GARBAGE, "3D200102");
        mDownloadSources.put(PointMark.E_HOME_DOWNLOAD_CM, "3D200103");
        mDownloadSources.put(PointMark.K_CLEAN_GARBAGE, "3D200066");
        mDownloadSources.put(PointMark.K_FEATURE_CLEAN_GARBAGE, "3D200104");
    }

    private static boolean checkDownloaded(Context context) {
        return context.getSharedPreferences("cm_config", 4).getBoolean(SHARE_PREF_DOWNLOAD_CM, false);
    }

    public static void downloadInternationalCM(Context context, String str) {
        MLog.m6871i(BuildConfig.FLAVOR, "hzd, @downloadInternationalCM, from=" + str);
        if (NetUtils.isNetworkAvailable()) {
            String str2 = BuildConfig.FLAVOR;
            str2 = (String) mDownloadSources.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "3D200066";
            }
            if (needDownloadApp(context, "com.android.vending")) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + CM + "&referrer=utm_source%" + str2)));
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + CM + "&referrer=utm_source%" + str2));
            intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
            context.startActivity(intent);
            return;
        }
        Methods.showToast(context, (int) C1692R.string.network_error, 0);
    }

    public static boolean isDownloaded(Context context) {
        File file = new File(DownloadsService.DOWNLOAD_ABSOLUTE_PATH + cmAPK);
        return checkDownloaded(context) && file.exists() && file.isFile();
    }

    public static boolean isNeedDownload(Context context) {
        return needDownloadApp(context, CM) & needDownloadApp(context, CM_CN);
    }

    private static boolean needDownloadApp(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) == null;
        } catch (NameNotFoundException e) {
            return true;
        }
    }

    public static void openCM(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("extra_from", context.getPackageName());
        intent.putExtra("extra_to", "proc");
        try {
            boolean needDownloadApp = needDownloadApp(context, CM);
            boolean needDownloadApp2 = needDownloadApp(context, CM_CN);
            if (!needDownloadApp && needDownloadApp2) {
                intent.setComponent(new ComponentName(CM, CM_SWITCH_ACTIVITY));
            } else if (needDownloadApp && !needDownloadApp2) {
                intent.setComponent(new ComponentName(CM_CN, CM_SWITCH_ACTIVITY));
            }
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static boolean tryInstallFromLocal(Context context) {
        if (checkDownloaded(context)) {
            File file = new File(DownloadsService.DOWNLOAD_ABSOLUTE_PATH + cmAPK);
            if (file.exists() && file.isFile()) {
                Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                flags.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                context.startActivity(flags);
                return false;
            }
        }
        if (NetUtils.isNetworkAvailable()) {
            return true;
        }
        Methods.showToast(context, (int) C1692R.string.network_error, 0);
        return false;
    }
}
