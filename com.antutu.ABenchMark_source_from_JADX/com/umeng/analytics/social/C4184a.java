package com.umeng.analytics.social;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.umeng.analytics.social.a */
public class C4184a extends RuntimeException {
    private static final long f14051b = -4656673116019167471L;
    protected int f14052a;
    private String f14053c;

    public C4184a(int i, String str) {
        super(str);
        this.f14052a = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f14053c = BuildConfig.FLAVOR;
        this.f14052a = i;
        this.f14053c = str;
    }

    public C4184a(String str) {
        super(str);
        this.f14052a = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f14053c = BuildConfig.FLAVOR;
        this.f14053c = str;
    }

    public C4184a(String str, Throwable th) {
        super(str, th);
        this.f14052a = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f14053c = BuildConfig.FLAVOR;
        this.f14053c = str;
    }

    public int m17053a() {
        return this.f14052a;
    }

    public String getMessage() {
        return this.f14053c;
    }
}
