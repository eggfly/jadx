package com.baidu.mobads.production;

import com.baidu.mobads.p093h.C1960g;

public class BaiduXAdSDKContext {
    protected static Boolean isRemoteLoadSuccess;
    protected static C1960g mApkLoader;

    static {
        isRemoteLoadSuccess = Boolean.valueOf(false);
    }

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = Boolean.valueOf(false);
    }
}
