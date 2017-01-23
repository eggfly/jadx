package com.antutu.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Environment;
import com.antutu.utils.downloader.DownloadsService;
import java.io.File;

public class ApkSearchUtils {
    private static String[] dirs;

    static {
        dirs = new String[]{DownloadsService.DOWNLOAD_PATH, "/wandoujia/app/", "/baidu/AppSearch/downloads/", "/360Download/", "/tencent/tassistant/apk/", "/LetvAppstore/", "/appcenter/downloader/apk/"};
    }

    public static String find3dPluginAPK(Context context) {
        for (String str : dirs) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.getName().toLowerCase().endsWith(".apk") && is3dPluginApk(context, file2)) {
                        return file2.getAbsolutePath();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static boolean is3dPluginApk(Context context, File file) {
        boolean z = true;
        try {
            String absolutePath = file.getAbsolutePath();
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(absolutePath, 1);
            if (packageArchiveInfo == null) {
                return false;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            if (!"com.antutu.benchmark.full".equals(packageArchiveInfo.packageName) || 6000400 > packageArchiveInfo.versionCode) {
                return false;
            }
            if (jni.checkAPK(absolutePath) != 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
