package com.igexin.download;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.igexin.download.d */
class C3704d extends ContentObserver {
    final /* synthetic */ DownloadService f12508a;

    public C3704d(DownloadService downloadService) {
        this.f12508a = downloadService;
        super(new Handler());
    }

    public void onChange(boolean z) {
        this.f12508a.m15153a();
    }
}
