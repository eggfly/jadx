package com.cmcm.support;

import android.content.Context;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.cmcm.support.c */
public class C2221c {
    public static int f7642a;
    public static int f7643b;
    public static Comparator<C2207a> f7644c;
    private C2229e f7645d;
    private C2237i f7646e;
    private C2222d f7647f;
    private C2236h f7648g;
    private int f7649h;
    private int f7650i;
    private String f7651j;
    private String f7652k;
    private volatile boolean f7653l;
    private final Object f7654m;
    private Context f7655n;
    private Timer f7656o;
    private TimerTask f7657p;
    private final Object f7658q;

    /* renamed from: com.cmcm.support.c.1 */
    class C22041 extends TimerTask {
        final /* synthetic */ C2221c f7600a;

        C22041(C2221c c2221c) {
            this.f7600a = c2221c;
        }

        public void run() {
            this.f7600a.m8349a();
        }
    }

    /* renamed from: com.cmcm.support.c.2 */
    class C22052 extends Thread {
        final /* synthetic */ C2221c f7601a;

        C22052(C2221c c2221c) {
            this.f7601a = c2221c;
        }

        public void run() {
            try {
                if (this.f7601a.f7645d.m8406d() != null) {
                    this.f7601a.f7645d.m8406d().m8249a("KSupport", " BATCH REPORTER STARTED ........");
                }
                for (int i = 0; i < 2; i++) {
                    this.f7601a.m8350a(i);
                    if (i == 0 || C2234g.m8422c(this.f7601a.f7655n)) {
                        File a = C2246o.m8497a(this.f7601a.f7655n, i, this.f7601a.f7645d.m8407e().getCacheDirectoryName());
                        if (a != null) {
                            File[] listFiles = a.listFiles();
                            if (!(listFiles == null || listFiles.length == 0)) {
                                if (this.f7601a.f7645d.m8406d() != null) {
                                    this.f7601a.f7645d.m8406d().m8249a("KSupport", " -> ICH DIR : " + a.getAbsolutePath());
                                }
                                int a2 = (this.f7601a.f7645d == null || !this.f7601a.f7645d.m8397a()) ? -1 : this.f7601a.f7645d.m8405c().booleanValue() ? this.f7601a.f7647f.m8365a("http://119.147.146.243/nep/v1/", listFiles, this.f7601a.f7646e.m8451c(), this.f7601a.f7652k, this.f7601a.f7649h, this.f7601a.f7651j, this.f7601a.f7650i, this.f7601a.f7645d.m8406d(), this.f7601a.f7645d.m8408f(), this.f7601a.f7645d.m8403b()) : this.f7601a.f7647f.m8365a(this.f7601a.m8336b(i), listFiles, this.f7601a.f7646e.m8451c(), this.f7601a.f7652k, this.f7601a.f7649h, this.f7601a.f7651j, this.f7601a.f7650i, this.f7601a.f7645d.m8406d(), this.f7601a.f7645d.m8408f(), this.f7601a.f7645d.m8403b());
                                if (a2 == -1) {
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                synchronized (this.f7601a.f7654m) {
                    this.f7601a.f7653l = false;
                }
            } catch (Throwable th) {
                synchronized (this.f7601a.f7654m) {
                }
                this.f7601a.f7653l = false;
            }
        }
    }

    /* renamed from: com.cmcm.support.c.3 */
    static class C22063 implements Comparator<C2207a> {
        C22063() {
        }

        public int m8279a(C2207a c2207a, C2207a c2207a2) {
            return (int) (c2207a.m8280a() - c2207a2.m8280a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8279a((C2207a) obj, (C2207a) obj2);
        }
    }

    /* renamed from: com.cmcm.support.c.a */
    public class C2207a {
        final /* synthetic */ C2221c f7602a;
        private long f7603b;
        private File f7604c;

        public C2207a(C2221c c2221c, long j, File file) {
            this.f7602a = c2221c;
            this.f7603b = j;
            this.f7604c = file;
        }

        public long m8280a() {
            return this.f7603b;
        }

        public File m8281b() {
            return this.f7604c;
        }
    }

    static {
        f7642a = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        f7643b = 30;
        f7644c = new C22063();
    }

    public C2221c() {
        this.f7645d = null;
        this.f7646e = null;
        this.f7647f = new C2222d();
        this.f7648g = null;
        this.f7649h = -1;
        this.f7650i = 0;
        this.f7651j = null;
        this.f7652k = null;
        this.f7653l = false;
        this.f7654m = new Object();
        this.f7655n = null;
        this.f7656o = null;
        this.f7657p = null;
        this.f7658q = new Object();
    }

    private String m8336b(int i) {
        return this.f7646e == null ? null : this.f7646e.m8447a(i);
    }

    private boolean m8338c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (this.f7648g != null ? this.f7648g.m8436a() : currentTimeMillis) >= ((long) this.f7645d.m8407e().getIntervalWifiNet())) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            if (C2246o.m8505c(this.f7655n, i, this.f7645d.m8407e().getCacheDirectoryName()) >= f7643b) {
                return true;
            }
        }
        return false;
    }

    private void m8340d() {
        if (this.f7656o == null) {
            long e = m8342e();
            if (e >= 0) {
                synchronized (this.f7658q) {
                    this.f7656o = new Timer();
                    this.f7657p = new C22041(this);
                    this.f7656o.schedule(this.f7657p, e);
                }
            }
        }
    }

    private long m8342e() {
        long intervalWifiNet;
        int b = C2234g.m8421b(this.f7655n);
        if (b == 2) {
            intervalWifiNet = (long) this.f7645d.m8407e().getIntervalWifiNet();
        } else if (b != 4 && b != 8 && b != 16) {
            return -1;
        } else {
            intervalWifiNet = (long) this.f7645d.m8407e().getIntervalMobileNet();
        }
        long currentTimeMillis = (intervalWifiNet - (System.currentTimeMillis() - this.f7648g.m8436a())) + ((long) f7642a);
        return currentTimeMillis <= 0 ? intervalWifiNet : currentTimeMillis;
    }

    private void m8344f() {
        if (this.f7645d.m8406d() != null) {
            this.f7645d.m8406d().m8249a("KSupport", "clear batch timer");
        }
        synchronized (this.f7658q) {
            if (this.f7657p != null) {
                this.f7657p.cancel();
                this.f7657p = null;
            }
            if (this.f7656o != null) {
                this.f7656o.purge();
                this.f7656o.cancel();
                this.f7656o = null;
            }
        }
    }

    private void m8346g() {
        synchronized (this.f7654m) {
            this.f7653l = true;
        }
        new C22052(this).start();
    }

    public void m8349a() {
        if (this.f7645d != null && this.f7645d.m8397a()) {
            synchronized (this.f7654m) {
                if (this.f7653l) {
                    return;
                }
                if (C2234g.m8423d(this.f7655n)) {
                    m8352b();
                }
            }
        }
    }

    void m8350a(int i) {
        File a = C2246o.m8497a(this.f7655n, i, this.f7645d.m8407e().getCacheDirectoryName());
        if (a != null) {
            File[] listFiles = a.listFiles();
            if (listFiles != null && listFiles.length >= this.f7645d.m8407e().getMaxCacheCount()) {
                Queue priorityQueue = new PriorityQueue(this.f7645d.m8407e().getMaxCacheCount(), f7644c);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        priorityQueue.add(new C2207a(this, C2222d.m8363b(file.getName()), file));
                    }
                }
                int deleteCacheNum = this.f7645d.m8407e().getDeleteCacheNum();
                while (deleteCacheNum > 0) {
                    C2207a c2207a = (C2207a) priorityQueue.poll();
                    if (c2207a != null) {
                        c2207a.m8281b().delete();
                        deleteCacheNum--;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean m8351a(C2229e c2229e, Context context, C2237i c2237i, String str, C2236h c2236h) {
        this.f7655n = context;
        this.f7646e = c2237i;
        this.f7645d = c2229e;
        this.f7649h = c2237i.m8445a();
        this.f7650i = c2237i.m8448b();
        this.f7651j = C2246o.m8496a(context).getAbsolutePath() + "/";
        this.f7651j += this.f7645d.m8407e().getFmtDstFilePath();
        this.f7652k = str;
        this.f7648g = c2236h;
        return true;
    }

    protected void m8352b() {
        if (m8338c()) {
            synchronized (this.f7654m) {
                if (!this.f7653l) {
                    if (this.f7648g != null) {
                        this.f7648g.m8440a(System.currentTimeMillis());
                    }
                    m8346g();
                }
            }
            m8344f();
        }
        m8340d();
    }
}
