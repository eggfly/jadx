package com.baidu.mobads.openad.p088c;

import android.content.Context;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.p083a.C2004b;
import com.baidu.mobads.openad.p083a.C2005c;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p089d.C1929a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.openad.c.d */
public class C2014d implements IOAdDownloaderManager {
    private static C2014d f7027b;
    protected Context f7028a;
    private HashMap<String, IOAdDownloader> f7029c;
    private C2005c f7030d;
    private AtomicBoolean f7031e;

    static {
        f7027b = null;
    }

    protected C2014d(Context context) {
        this.f7029c = new HashMap();
        this.f7031e = new AtomicBoolean(false);
        this.f7028a = context;
    }

    public static C2014d m7517a(Context context) {
        if (f7027b == null) {
            f7027b = new C2014d(context);
        }
        return f7027b;
    }

    public void m7518a(String str, IOAdDownloader iOAdDownloader) {
        synchronized (this.f7029c) {
            this.f7029c.put(str, iOAdDownloader);
        }
    }

    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        IOAdDownloader c2011a;
        c2011a = new C2011a(this.f7028a, url, str, str2, i, str3, str4);
        m7518a(str4, c2011a);
        try {
            if (this.f7030d == null) {
                this.f7030d = new C2005c(this.f7028a);
                this.f7030d.m7481a(new C2004b(this.f7030d));
                this.f7030d.addEventListener("network_changed", new C2015e(this));
                this.f7030d.m7480a();
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e);
        }
        return c2011a;
    }

    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return new C1929a(this.f7028a, url, str, str2);
    }

    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new C1928f(this.f7028a, url, str, str2, z);
    }

    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.f7029c) {
            iOAdDownloader = (IOAdDownloader) this.f7029c.get(str);
        }
        return iOAdDownloader;
    }

    public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IOAdDownloader> arrayList = null;
        synchronized (this.f7029c) {
            Collection<IOAdDownloader> values = this.f7029c.values();
            if (values.size() > 0) {
                ArrayList<IOAdDownloader> arrayList2 = new ArrayList();
                for (IOAdDownloader add : values) {
                    arrayList2.add(add);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.f7029c) {
            this.f7029c.remove(str);
        }
        return Boolean.valueOf(true);
    }

    public void removeAllAdsApkDownloaderes() {
        synchronized (this.f7029c) {
            this.f7029c.clear();
        }
    }

    public void resumeUndownloadedAfterRestartApp(long j) {
        if (!this.f7031e.getAndSet(true)) {
            List a = C1924a.m7247a(this.f7028a, j);
            if (a != null && a.size() > 0) {
                int i = 0;
                while (i < a.size()) {
                    try {
                        String str = (String) a.get(i);
                        if (C2012b.m7506a(str) == null && getAdsApkDownloader(str) == null) {
                            C1924a a2 = C1924a.m7246a(this.f7028a, str);
                            if (a2 == null) {
                                C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "pack[" + str + "] has no local data, continue");
                            } else {
                                IOAdDownloader createAdsApkDownloader = createAdsApkDownloader(new URL(a2.f6739j), a2.f6732c, a2.f6731b, 1, a2.f6730a, a2.f6738i);
                                createAdsApkDownloader.addObserver(new C2012b(this.f7028a, a2));
                                createAdsApkDownloader.start();
                            }
                        } else {
                            C1991m.m7449a().m7457f().m7393d("OAdDownloadManager", "pack[" + str + "] has been stated before, continue");
                        }
                        i++;
                    } catch (Throwable e) {
                        C1991m.m7449a().m7457f().m7394d("OAdDownloadManager", e);
                        return;
                    }
                }
            }
        }
    }
}
