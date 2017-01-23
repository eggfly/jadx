package com.baidu.mobads.openad.p088c;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import java.util.List;

/* renamed from: com.baidu.mobads.openad.c.e */
class C2015e implements IOAdEventListener {
    final /* synthetic */ C2014d f7032a;

    C2015e(C2014d c2014d) {
        this.f7032a = c2014d;
    }

    public void run(IOAdEvent iOAdEvent) {
        try {
            C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "\u7f51\u7edc\u72b6\u6001\u5df2\u7ecf\u6539\u53d8");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7032a.f7028a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "\u6ca1\u6709\u53ef\u7528\u7f51\u7edc");
                return;
            }
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "\u5f53\u524d\u7f51\u7edc\u540d\u79f0\uff1a" + typeName + "; \u7f51\u7edc\u7c7b\u578b\uff1a" + type);
            List<IOAdDownloader> allAdsApkDownloaderes = this.f7032a.getAllAdsApkDownloaderes();
            if (allAdsApkDownloaderes != null) {
                for (IOAdDownloader iOAdDownloader : allAdsApkDownloaderes) {
                    if (type == 1) {
                        if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                            try {
                                iOAdDownloader.resume();
                            } catch (Throwable e) {
                                C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e);
                            }
                        }
                    } else if (type == 0) {
                        C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "mobile net work");
                        C2012b a = C2012b.m7506a(iOAdDownloader.getPackageName());
                        if (a != null) {
                            C1924a a2 = a.m7515a();
                            if (a2 == null) {
                                continue;
                            } else if (!a2.f6747r) {
                                try {
                                    iOAdDownloader.pause();
                                } catch (Throwable e2) {
                                    C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e2);
                                }
                            } else if (iOAdDownloader.getState() == DownloadStatus.ERROR || iOAdDownloader.getState() == DownloadStatus.PAUSED) {
                                try {
                                    iOAdDownloader.resume();
                                } catch (Throwable e22) {
                                    C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e22);
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable e222) {
            C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e222);
        }
    }
}
