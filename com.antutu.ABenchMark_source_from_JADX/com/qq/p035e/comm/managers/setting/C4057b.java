package com.qq.p035e.comm.managers.setting;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.qq.p035e.comm.constants.Constants.KEYS;

/* renamed from: com.qq.e.comm.managers.setting.b */
public final class C4057b extends C4056c {
    public C4057b() {
        m16576a(KEYS.SDKServerGetADReportSamplingRate, Integer.valueOf(1));
        m16576a(KEYS.SDKServerExpReportSamplingRate, Integer.valueOf(1));
        m16576a(KEYS.SDKServerClickReportSamplingRate, Integer.valueOf(100));
        m16576a(KEYS.RequireWindowFocus, Integer.valueOf(1));
        m16576a(KEYS.SHOW_LOGO, Integer.valueOf(0));
        m16576a(KEYS.INNER_BROWSER_SCHEME, "weixin,tel");
        m16576a(KEYS.THIRD_PARTY_BROWSER, "com.android.browser,com.android.chrome,com.baidu.browser.apps,com.UCMobile,com.tencent.mtt");
        m16576a(KEYS.Banner_RF, Integer.valueOf(30000));
        m16576a(KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(3000));
        m16576a(KEYS.SPLASH_EXPOSURE_TIME, Integer.valueOf(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
        m16576a(KEYS.SPLASH_NETWORK_PERMISION, Integer.valueOf(26));
        m16576a(KEYS.SPLASH_MAX_REQUEST_NUM, Integer.valueOf(100));
        m16576a(KEYS.FORCE_EXPOSURE, Integer.valueOf(1));
    }
}
