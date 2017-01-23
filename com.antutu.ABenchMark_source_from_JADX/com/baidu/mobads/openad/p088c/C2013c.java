package com.baidu.mobads.openad.p088c;

import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.openad.c.c */
class C2013c implements Runnable {
    final /* synthetic */ C2012b f7026a;

    C2013c(C2012b c2012b) {
        this.f7026a = c2012b;
    }

    public void run() {
        try {
            if (this.f7026a.f7021c.f6736g == DownloadStatus.CANCELLED) {
                C2012b.f7018a.cancel(this.f7026a.f7021c.f6735f);
                return;
            }
            C2012b.f7018a.notify(this.f7026a.f7021c.f6735f, this.f7026a.m7513d());
            if (this.f7026a.f7021c.f6736g == DownloadStatus.ERROR) {
                C1991m.m7449a().m7457f().m7393d("OAdApkDownloaderObserver", "status >> error");
            } else if (this.f7026a.f7021c.f6736g == DownloadStatus.INITING && this.f7026a.f7021c.f6746q == 1) {
                this.f7026a.m7514d("\u5f00\u59cb\u4e0b\u8f7d " + this.f7026a.f7021c.f6730a);
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7394d("OAdApkDownloaderObserver", e);
        }
    }
}
