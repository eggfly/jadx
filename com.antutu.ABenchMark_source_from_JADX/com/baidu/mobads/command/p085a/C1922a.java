package com.baidu.mobads.command.p085a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.command.C1921b;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.p088c.C2012b;
import com.baidu.mobads.openad.p088c.C2014d;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.mobads.command.a.a */
public class C1922a extends C1921b {

    /* renamed from: com.baidu.mobads.command.a.a.a */
    class C1920a {
        final /* synthetic */ C1922a f6716a;
        private Timer f6717b;
        private long f6718c;
        private String f6719d;
        private Context f6720e;

        C1920a(C1922a c1922a, Context context, C1924a c1924a) {
            this.f6716a = c1922a;
            this.f6719d = c1924a.m7258d();
            this.f6720e = context;
            if (!TextUtils.isEmpty(this.f6719d)) {
                this.f6718c = System.currentTimeMillis() + 600000;
                TimerTask c1923b = new C1923b(this, c1922a, c1924a);
                this.f6717b = new Timer();
                this.f6717b.scheduleAtFixedRate(c1923b, 0, 3000);
            }
        }

        private boolean m7237a(Context context, String str) {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (str.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        }
    }

    public C1922a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
    }

    protected static boolean m7243a(Context context, C1924a c1924a) {
        if (C1991m.m7449a().m7463l().isInstalled(context, c1924a.f6738i)) {
            C1991m.m7449a().m7463l().openApp(context, c1924a.f6738i);
            return true;
        }
        String str = c1924a.f6732c + c1924a.f6731b;
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        context.startActivity(C1991m.m7449a().m7463l().getInstallIntent(str));
        return true;
    }

    private boolean m7244b() {
        return C1991m.m7449a().m7463l().isInstalled(this.a, this.c.getAppPackageName());
    }

    public void m7245a() {
        boolean z = false;
        C1982d m = C1991m.m7449a().m7464m();
        IXAdIOUtils k = C1991m.m7449a().m7462k();
        IXAdURIUitls i = C1991m.m7449a().m7460i();
        IXAdSystemUtils n = C1991m.m7449a().m7465n();
        IXAdContainerContext adContainerContext = this.b.getCurrentXAdContainer().getAdContainerContext();
        try {
            String md5;
            C1924a a;
            C1920a c1920a;
            String appPackageName = this.c.getAppPackageName();
            this.e.m7402i("XAdDownloadAPKCommand", "download pkg = " + appPackageName);
            if (appPackageName == null || appPackageName.equals(BuildConfig.FLAVOR)) {
                this.e.m7402i("XAdDownloadAPKCommand", "start to download but package is empty");
                md5 = m.getMD5(this.c.getOriginClickUrl());
            } else {
                md5 = appPackageName;
            }
            IOAdDownloader adsApkDownloader = C2014d.m7517a(this.a).getAdsApkDownloader(md5);
            C2012b a2 = C2012b.m7506a(md5);
            if (a2 == null || adsApkDownloader == null) {
                if (adsApkDownloader != null) {
                    adsApkDownloader.cancel();
                    adsApkDownloader.removeObservers();
                }
                C2012b.m7510b(md5);
                C2014d.m7517a(this.a).removeAdsApkDownloader(md5);
            } else {
                a = a2.m7515a();
                DownloadStatus state = adsApkDownloader.getState();
                this.e.m7393d("XAdDownloadAPKCommand", "startDownload>> downloader exist: state=" + state);
                if (state == DownloadStatus.CANCELLED || state == DownloadStatus.ERROR || state == DownloadStatus.PAUSED) {
                    adsApkDownloader.resume();
                    i.pintHttpInNewThread(this.c.getClickThroughUrl());
                    c1920a = new C1920a(this, this.a, a);
                    return;
                } else if (state == DownloadStatus.COMPLETED) {
                    if (C1922a.m7243a(this.a, a)) {
                        i.pintHttpInNewThread(this.c.getClickThroughUrl());
                        c1920a = new C1920a(this, this.a, a);
                        return;
                    }
                    adsApkDownloader.cancel();
                    adsApkDownloader.removeObservers();
                    C2012b.m7510b(md5);
                    C2014d.m7517a(this.a).removeAdsApkDownloader(md5);
                } else if (state == DownloadStatus.DOWNLOADING || state == DownloadStatus.INITING) {
                    Toast.makeText(this.a, adsApkDownloader.getTitle() + adsApkDownloader.getState().getMessage(), 0).show();
                    return;
                }
            }
            C1924a a3 = C1924a.m7246a(this.a, md5);
            if (a3 != null) {
                if (a3.f6736g == DownloadStatus.COMPLETED && C1922a.m7243a(this.a, a3)) {
                    C1920a c1920a2 = new C1920a(this, this.a, a3);
                    return;
                } else {
                    i.pintHttpInNewThread(this.c.getClickThroughUrl());
                    a = a3;
                }
            } else if (m7244b()) {
                C1991m.m7449a().m7463l().openApp(this.a, this.c.getAppPackageName());
                i.pintHttpInNewThread(this.c.getClickThroughUrl());
                return;
            } else {
                String str;
                appPackageName = this.c.getAppName();
                if (appPackageName == null || appPackageName.equals(BuildConfig.FLAVOR)) {
                    appPackageName = this.c.getTitle();
                    if (appPackageName == null || appPackageName.equals(BuildConfig.FLAVOR)) {
                        str = "\u60a8\u70b9\u51fb\u7684\u5e94\u7528";
                        a3 = new C1924a(md5, str);
                        a3.m7253a(this.c.getQueryKey(), this.c.getAdId(), this.c.getClickThroughUrl(), this.c.isAutoOpen());
                        a3.m7252a(m.getMD5(a3.f6739j) + ".apk", k.getStoreagePath(this.a));
                        a3.m7256b(this.b.getAdRequestInfo().getApid(), this.b.getProdInfo().getProdType());
                        a3.f6735f = C2012b.m7511c(md5);
                        if (!this.c.isActionOnlyWifi()) {
                            z = true;
                        }
                        a3.f6747r = z;
                        a3.m7250a(System.currentTimeMillis());
                        a3.m7255b(this.c.getAppSize());
                        a3.m7254a(this.c.isTooLarge());
                        a = a3;
                    }
                }
                str = appPackageName;
                a3 = new C1924a(md5, str);
                a3.m7253a(this.c.getQueryKey(), this.c.getAdId(), this.c.getClickThroughUrl(), this.c.isAutoOpen());
                a3.m7252a(m.getMD5(a3.f6739j) + ".apk", k.getStoreagePath(this.a));
                a3.m7256b(this.b.getAdRequestInfo().getApid(), this.b.getProdInfo().getProdType());
                a3.f6735f = C2012b.m7511c(md5);
                if (this.c.isActionOnlyWifi()) {
                    z = true;
                }
                a3.f6747r = z;
                a3.m7250a(System.currentTimeMillis());
                a3.m7255b(this.c.getAppSize());
                a3.m7254a(this.c.isTooLarge());
                a = a3;
            }
            a.f6748s = System.currentTimeMillis();
            c1920a = new C1920a(this, this.a, a);
            adsApkDownloader = adContainerContext.getDownloaderManager(this.a).createAdsApkDownloader(new URL(a.f6739j), a.f6732c, a.f6731b, 3, a.f6730a, a.f6738i);
            if (!(!this.c.getAPOOpen() || this.c.getPage() == null || this.c.getPage().equals(BuildConfig.FLAVOR))) {
                a.f6751v = true;
                a.f6752w = this.c.getPage();
            }
            adsApkDownloader.addObserver(new C2012b(this.a, a));
            if (a.f6747r || !n.is3GConnected(this.a).booleanValue()) {
                adsApkDownloader.start();
                return;
            }
            adsApkDownloader.pause();
            Toast.makeText(this.a, adsApkDownloader.getTitle() + " \u5c06\u5728\u8fde\u5165Wifi\u540e\u5f00\u59cb\u4e0b\u8f7d", 0).show();
        } catch (Throwable e) {
            this.e.m7398e("XAdDownloadAPKCommand", e);
        }
    }
}
