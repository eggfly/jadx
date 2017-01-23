package com.igexin.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.download.j */
class C3710j extends Handler {
    final /* synthetic */ SdkDownLoader f12520a;

    C3710j(SdkDownLoader sdkDownLoader, Looper looper) {
        this.f12520a = sdkDownLoader;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                synchronized (this.f12520a.f12501h) {
                    if (this.f12520a.f12500g.size() > 0 && this.f12520a.updateData.size() > 0) {
                        for (DownloadInfo downloadInfo : this.f12520a.updateData.values()) {
                            IDownloadCallback a = this.f12520a.m15184a(downloadInfo.mData8);
                            if (a != null) {
                                a.update(downloadInfo);
                            }
                        }
                    }
                    break;
                }
            default:
        }
    }
}
