package com.qq.p035e.comm.constants;

import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.qq.e.comm.constants.CustomPkgConstants */
public class CustomPkgConstants {
    public static String getADActivityName() {
        return "com.qq.e.ads.ADActivity";
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return BuildConfig.FLAVOR;
    }

    public static String getDownLoadServiceName() {
        return "com.qq.e.comm.DownloadService";
    }
}
