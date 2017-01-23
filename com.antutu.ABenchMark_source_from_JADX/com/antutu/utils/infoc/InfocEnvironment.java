package com.antutu.utils.infoc;

import com.cmcm.support.C2242k.C1820a;

public class InfocEnvironment implements C1820a {
    private static final String CACHE_DIR_NAME = "infoc_cache";
    private static final String CLIENT_PREFIX = "host_";
    private static final String CLIENT_VERSION = "6.3.3";
    private static final String CTRL_FILE_NAME = "kctrl.dat";
    private static final int DELETE_CACHE_NUM = 500;
    private static final String FMT_FILE_NAME = "kfmt.dat";
    private static final int INTERVAL_MOBILE_NET = 600000;
    private static final int INTERVAL_WIFI_NET = 120000;
    private static final int MAX_CACHE_COUNT = 2000;
    private static final String NATIVE_LIB_PATH_NAME = "/lib/libcmcm_support.so";
    private static final String PREF_FILE_NAME = "infoc_preference";
    private static final String TAG;

    static {
        TAG = InfocEnvironment.class.getSimpleName();
    }

    public String getCacheDirectoryName() {
        return CACHE_DIR_NAME;
    }

    public String getClientPrefix() {
        return CLIENT_PREFIX;
    }

    public String getClientVersion() {
        return CLIENT_VERSION;
    }

    public String getCtrlAssetFileName() {
        return CTRL_FILE_NAME;
    }

    public String getCtrlDstFilePath() {
        return CTRL_FILE_NAME;
    }

    public int getDeleteCacheNum() {
        return DELETE_CACHE_NUM;
    }

    public String getFmtAssetFileName() {
        return FMT_FILE_NAME;
    }

    public String getFmtDstFilePath() {
        return FMT_FILE_NAME;
    }

    public int getIntervalMobileNet() {
        return INTERVAL_MOBILE_NET;
    }

    public int getIntervalWifiNet() {
        return INTERVAL_WIFI_NET;
    }

    public int getMaxCacheCount() {
        return MAX_CACHE_COUNT;
    }

    public String getNativeLibPathName() {
        return NATIVE_LIB_PATH_NAME;
    }

    public String getPreferenceConfigName() {
        return PREF_FILE_NAME;
    }
}
