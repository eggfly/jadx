package com.cmcm.support;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import com.cmcm.support.C2242k.C1820a;
import com.cmcm.support.p116a.C2190c;
import com.cmcm.support.p116a.C2193f;
import com.cmcm.support.p116a.C2194g;
import com.cmcm.support.p117b.C2201b.C2200a;
import com.cmcm.support.p117b.C2202c;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.cmcm.support.e */
public class C2229e {
    private static Object f7669a;
    private static boolean f7670b;
    private boolean f7671c;
    private Context f7672d;
    private String f7673e;
    private String f7674f;
    private String f7675g;
    private int f7676h;
    private C2237i f7677i;
    private C1821b f7678j;
    private Handler f7679k;
    private IntentFilter f7680l;
    private C2193f f7681m;
    private C2236h f7682n;
    private C2221c f7683o;
    private C2242k f7684p;
    private C2244m f7685q;
    private C2239j f7686r;
    private Timer f7687s;
    private TimerTask f7688t;
    private C2198a f7689u;
    private BroadcastReceiver f7690v;
    private Runnable f7691w;

    /* renamed from: com.cmcm.support.e.1 */
    class C22231 extends BroadcastReceiver {
        final /* synthetic */ C2229e f7662a;

        C22231(C2229e c2229e) {
            this.f7662a = c2229e;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) && C2234g.m8423d(context) && this.f7662a.f7679k != null) {
                this.f7662a.f7679k.removeCallbacks(this.f7662a.f7691w);
                this.f7662a.f7679k.post(this.f7662a.f7691w);
            }
        }
    }

    /* renamed from: com.cmcm.support.e.2 */
    class C22242 implements Runnable {
        final /* synthetic */ C2229e f7663a;

        C22242(C2229e c2229e) {
            this.f7663a = c2229e;
        }

        public void run() {
            if (this.f7663a.f7683o != null) {
                this.f7663a.f7683o.m8349a();
            }
        }
    }

    /* renamed from: com.cmcm.support.e.3 */
    class C22253 extends TimerTask {
        final /* synthetic */ C2229e f7664a;

        C22253(C2229e c2229e) {
            this.f7664a = c2229e;
        }

        public void run() {
            this.f7664a.m8404b(2);
            this.f7664a.m8389g();
        }
    }

    /* renamed from: com.cmcm.support.e.4 */
    class C22264 implements C2200a {
        final /* synthetic */ C2229e f7665a;

        C22264(C2229e c2229e) {
            this.f7665a = c2229e;
        }

        public void m8367a(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7665a.f7681m != null) {
                this.f7665a.f7681m.m8249a("KSupport", "ReportActive success");
            }
            if (this.f7665a.f7689u != null) {
                this.f7665a.f7689u.m8264a("[" + c2202c.m8276d() + "] reportActive success");
            }
            this.f7665a.m8374a(j, bArr);
        }

        public void m8368b(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7665a.f7681m != null) {
                this.f7665a.f7681m.m8249a("KSupport", "ReportActive fail");
            }
            if (this.f7665a.f7689u != null) {
                this.f7665a.f7689u.m8264a("[" + c2202c.m8276d() + "] reportActive failed");
            }
            this.f7665a.m8374a(j, bArr);
            this.f7665a.m8376a(c2202c);
            if (this.f7665a.f7683o != null) {
                this.f7665a.f7683o.m8349a();
            }
        }
    }

    /* renamed from: com.cmcm.support.e.5 */
    class C22275 implements C2200a {
        final /* synthetic */ C2229e f7666a;

        C22275(C2229e c2229e) {
            this.f7666a = c2229e;
        }

        public void m8369a(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7666a.f7681m != null) {
                this.f7666a.f7681m.m8249a("KSupport", "reportEvent success");
            }
            if (this.f7666a.f7689u != null) {
                this.f7666a.f7689u.m8264a("[" + c2202c.m8276d() + "] reportEvent success");
            }
            this.f7666a.m8374a(j, bArr);
        }

        public void m8370b(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7666a.f7681m != null) {
                this.f7666a.f7681m.m8249a("KSupport", "reportEvent fail");
            }
            if (this.f7666a.f7689u != null) {
                this.f7666a.f7689u.m8264a("[" + c2202c.m8276d() + "] reportEvent failed");
            }
            this.f7666a.m8374a(j, bArr);
            this.f7666a.m8382b(c2202c);
            if (this.f7666a.f7683o != null) {
                this.f7666a.f7683o.m8349a();
            }
        }
    }

    /* renamed from: com.cmcm.support.e.6 */
    class C22286 implements C2200a {
        final /* synthetic */ boolean f7667a;
        final /* synthetic */ C2229e f7668b;

        C22286(C2229e c2229e, boolean z) {
            this.f7668b = c2229e;
            this.f7667a = z;
        }

        public void m8371a(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7668b.f7681m != null) {
                this.f7668b.f7681m.m8249a("KSupport", "report success");
            }
            if (this.f7668b.f7689u != null) {
                this.f7668b.f7689u.m8264a("[" + c2202c.m8276d() + "] report success");
            }
            this.f7668b.m8374a(j, bArr);
        }

        public void m8372b(long j, byte[] bArr, C2202c c2202c) {
            if (this.f7668b.f7681m != null) {
                this.f7668b.f7681m.m8249a("KSupport", "report fail");
            }
            if (this.f7668b.f7689u != null) {
                this.f7668b.f7689u.m8264a("[" + c2202c.m8276d() + "] report fail");
            }
            this.f7668b.m8374a(j, bArr);
            this.f7668b.m8377a(c2202c, this.f7667a);
            if (this.f7668b.f7683o != null) {
                this.f7668b.f7683o.m8349a();
            }
        }
    }

    static {
        f7669a = new Object();
        f7670b = false;
    }

    public C2229e() {
        this.f7671c = false;
        this.f7672d = null;
        this.f7673e = null;
        this.f7674f = null;
        this.f7675g = null;
        this.f7676h = 0;
        this.f7677i = null;
        this.f7678j = null;
        this.f7679k = null;
        this.f7680l = null;
        this.f7681m = null;
        this.f7682n = null;
        this.f7683o = null;
        this.f7684p = null;
        this.f7685q = null;
        this.f7686r = null;
        this.f7687s = null;
        this.f7688t = null;
        this.f7689u = null;
        this.f7690v = new C22231(this);
        this.f7691w = new C22242(this);
    }

    private void m8374a(long j, byte[] bArr) {
        if (this.f7686r != null && bArr != null) {
            this.f7686r.m8458a(j, bArr);
        }
    }

    private boolean m8376a(C2202c c2202c) {
        if (c2202c.m8269a() == null) {
            Log.d("KSupport", "getPublicString return null");
            if (c2202c.m8276d() != null) {
                Log.d("KSupport", c2202c.m8276d());
            }
        }
        return m8380a(c2202c.m8274b(), C2246o.m8502b(c2202c.m8269a()), c2202c.m8276d(), 0);
    }

    private boolean m8377a(C2202c c2202c, boolean z) {
        if (c2202c.m8269a() == null) {
            Log.d("KSupport", "getPublicString return null");
            if (c2202c.m8276d() != null) {
                Log.d("KSupport", c2202c.m8276d());
            }
        }
        return m8380a(c2202c.m8274b(), C2246o.m8503b(this.f7677i.m8451c(), c2202c.m8269a(), this.f7676h, this.f7673e), c2202c.m8276d(), z ? 0 : this.f7677i.m8450c(c2202c.m8276d()));
    }

    private boolean m8380a(byte[] bArr, int i, String str, int i2) {
        boolean z = false;
        if (bArr != null && i >= 0 && i <= bArr.length) {
            File d = C2246o.m8506d(this.f7672d, i2, this.f7684p.m8462a().getCacheDirectoryName());
            if (d != null) {
                int length = bArr.length - i;
                if (length > 0) {
                    ByteBuffer allocate = ByteBuffer.allocate(length);
                    while (i < bArr.length) {
                        allocate.put(bArr[i]);
                        i++;
                    }
                    try {
                        z = new C2190c().m8235a(d.getAbsolutePath(), str + '_' + System.currentTimeMillis() + ".ich", allocate.array());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    private boolean m8382b(C2202c c2202c) {
        if (c2202c.m8269a() == null) {
            Log.d("KSupport", "getPublicString return null");
            if (c2202c.m8276d() != null) {
                Log.d("KSupport", c2202c.m8276d());
            }
        }
        return m8380a(c2202c.m8274b(), C2246o.m8502b(c2202c.m8269a()), "kav_event", 1);
    }

    private boolean m8385c(int i) {
        return C2234g.m8423d(this.f7672d) && (i == 0 || C2234g.m8422c(this.f7672d));
    }

    private void m8389g() {
        if (this.f7688t != null) {
            this.f7688t.cancel();
            this.f7688t = null;
        }
        if (this.f7687s != null) {
            this.f7687s.purge();
            this.f7687s.cancel();
            this.f7687s = null;
        }
        m8390h();
    }

    private void m8390h() {
        if (this.f7687s == null) {
            this.f7687s = new Timer();
            this.f7688t = new C22253(this);
            this.f7687s.schedule(this.f7688t, C4156a.f13949k);
        }
    }

    private void m8391i() {
        this.f7680l = new IntentFilter();
        this.f7680l.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        try {
            this.f7672d.registerReceiver(this.f7690v, this.f7680l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String m8392j() {
        String nativeLibPathName = this.f7684p.m8462a().getNativeLibPathName();
        if (nativeLibPathName == null) {
            nativeLibPathName = "/lib/libcmcm_support.so";
        }
        return this.f7672d.getApplicationInfo().dataDir + nativeLibPathName;
    }

    private boolean m8393k() {
        boolean z = true;
        synchronized (f7669a) {
            if (f7670b) {
            } else {
                String j = m8392j();
                if (new File(j).exists()) {
                    try {
                        System.load(j);
                        f7670b = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        f7670b = false;
                    }
                }
                try {
                    System.loadLibrary("cmcm_support");
                    f7670b = true;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f7670b = false;
                }
                z = f7670b;
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8394l() {
        /*
        r6 = this;
        r0 = 1;
        r1 = r6.f7673e;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x000b;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
    L_0x000b:
        r1 = new java.io.File;
        r2 = r6.f7673e;
        r1.<init>(r2);
        r2 = r1.getParentFile();
        r1 = r6.f7684p;
        r1 = r1.m8462a();
        r1 = r1.getClientPrefix();
        r3 = r6.f7684p;
        r3 = r3.m8462a();
        r3 = r3.getClientVersion();
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x000a;
    L_0x0030:
        r4 = r6.f7682n;
        r4 = r4.m8444b(r1);
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x000a;
    L_0x003c:
        r3 = com.cmcm.support.p118c.C2214d.m8326a();
        r3.m8327a(r2);
        r3 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r3 = r3.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r3 = r3.getClientVersion();	 Catch:{ Exception -> 0x00a3 }
        r4 = r6.f7682n;	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.m8444b(r1);	 Catch:{ Exception -> 0x00a3 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00a3 }
        if (r3 != 0) goto L_0x009a;
    L_0x0059:
        r3 = r6.f7672d;	 Catch:{ Exception -> 0x00a3 }
        r4 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.getFmtAssetFileName();	 Catch:{ Exception -> 0x00a3 }
        r5 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r5 = r5.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r5 = r5.getFmtDstFilePath();	 Catch:{ Exception -> 0x00a3 }
        com.cmcm.support.p116a.C2191d.m8236a(r3, r4, r5);	 Catch:{ Exception -> 0x00a3 }
        r3 = r6.f7672d;	 Catch:{ Exception -> 0x00a3 }
        r4 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.getCtrlAssetFileName();	 Catch:{ Exception -> 0x00a3 }
        r5 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r5 = r5.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r5 = r5.getCtrlDstFilePath();	 Catch:{ Exception -> 0x00a3 }
        com.cmcm.support.p116a.C2191d.m8236a(r3, r4, r5);	 Catch:{ Exception -> 0x00a3 }
        r3 = r6.f7682n;	 Catch:{ Exception -> 0x00a3 }
        r4 = r6.f7684p;	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.m8462a();	 Catch:{ Exception -> 0x00a3 }
        r4 = r4.getClientVersion();	 Catch:{ Exception -> 0x00a3 }
        r3.m8438a(r1, r4);	 Catch:{ Exception -> 0x00a3 }
    L_0x009a:
        r1 = com.cmcm.support.p118c.C2214d.m8326a();
        r1.m8328b(r2);
        goto L_0x000a;
    L_0x00a3:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00b0 }
        r1 = com.cmcm.support.p118c.C2214d.m8326a();
        r1.m8328b(r2);
        goto L_0x000a;
    L_0x00b0:
        r0 = move-exception;
        r1 = com.cmcm.support.p118c.C2214d.m8326a();
        r1.m8328b(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcm.support.e.l():boolean");
    }

    private String m8395m() {
        if (this.f7678j != null && this.f7674f == null) {
            this.f7674f = this.f7678j.getPublicData();
        }
        return this.f7674f;
    }

    private String m8396n() {
        return (this.f7685q == null || this.f7685q.m8493m() == null) ? BuildConfig.FLAVOR : C2194g.m8252a(this.f7685q.m8493m());
    }

    public boolean m8397a() {
        return this.f7671c;
    }

    @SuppressLint({"SimpleDateFormat"})
    public boolean m8398a(int i) {
        long parseLong = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()));
        if (parseLong != this.f7682n.m8437a(i)) {
            this.f7682n.m8439a(i, parseLong);
            if (this.f7681m != null) {
                this.f7681m.m8249a("KSupport", "needReportActive = ture");
            }
            return true;
        }
        if (this.f7681m != null) {
            this.f7681m.m8249a("KSupport", "needReportActive = false");
        }
        return false;
    }

    public boolean m8399a(int i, int i2, String str) {
        if (!this.f7671c) {
            return false;
        }
        C2243l c2243l = new C2243l();
        c2243l.m8471a(Integer.toString(i));
        C2194g c2194g = new C2194g();
        c2194g.m8254a("value", i2);
        c2194g.m8256a("dimension", str);
        c2194g.m8256a("ext_map", BuildConfig.FLAVOR);
        c2194g.m8255a("uptime", System.currentTimeMillis() / 1000);
        c2243l.m8474b(c2194g.m8257b());
        c2243l.m8476c(m8403b());
        c2243l.m8468a(this.f7676h);
        c2243l.m8470a(this.f7686r.m8457a());
        if (m8405c().booleanValue()) {
            c2243l.m8480f("http://119.147.146.243/nep/v1/");
        } else {
            c2243l.m8480f(this.f7677i.m8447a(0));
        }
        c2243l.m8469a(new C22275(this));
        if (C2234g.m8422c(this.f7672d)) {
            return c2243l.m8477c(this.f7681m);
        }
        boolean b = m8382b(c2243l.m8473b());
        if (this.f7683o == null) {
            return b;
        }
        this.f7683o.m8349a();
        return b;
    }

    @SuppressLint({"SdCardPath"})
    public boolean m8400a(C1821b c1821b, C2198a c2198a) {
        if (!this.f7671c) {
            this.f7689u = c2198a;
            this.f7686r = new C2239j();
            this.f7684p = new C2242k();
            this.f7684p.m8463a(c1821b.getEnv());
            this.f7672d = c1821b.getApplicationContext();
            this.f7685q = c1821b.getPublicBean();
            try {
                this.f7673e = C2246o.m8496a(this.f7672d).getAbsolutePath() + "/";
            } catch (NullPointerException e) {
                this.f7673e = "/data/data/" + this.f7672d.getPackageName() + "/files/";
            }
            this.f7673e += this.f7684p.m8462a().getFmtDstFilePath();
            this.f7682n = new C2236h();
            this.f7682n.m8441a(this.f7672d.getSharedPreferences(this.f7684p.m8462a().getPreferenceConfigName(), 4));
            m8394l();
            this.f7677i = new C2237i(this.f7672d, this.f7684p.m8462a().getCtrlDstFilePath());
            this.f7676h = this.f7677i.m8445a();
            this.f7678j = c1821b;
            this.f7674f = m8395m();
            this.f7679k = new Handler(this.f7672d.getMainLooper());
            this.f7681m = new C2193f();
            this.f7681m.m8250a(c1821b.isDebugMode().booleanValue(), this.f7672d);
            m8391i();
            this.f7683o = new C2221c();
            this.f7683o.m8351a(this, this.f7672d, this.f7677i, this.f7674f, this.f7682n);
            this.f7671c = m8393k();
            m8390h();
        }
        return true;
    }

    public boolean m8401a(String str) {
        int a = this.f7677i.m8446a(str);
        if (a == 0) {
            return false;
        }
        double nextDouble = new Random(System.currentTimeMillis()).nextDouble();
        if (a < 10000 && ((int) (nextDouble * 10000.0d)) > a) {
            return false;
        }
        this.f7682n.m8443a(str, this.f7677i);
        return this.f7682n.m8442a(str);
    }

    public boolean m8402a(String str, String str2, boolean z) {
        if (!this.f7671c || !m8401a(str2)) {
            return false;
        }
        int c = this.f7677i.m8450c(str2);
        int d = this.f7677i.m8452d(str2);
        C2243l c2243l = new C2243l();
        c2243l.m8471a(str2);
        c2243l.m8474b(str);
        c2243l.m8479e(this.f7677i.m8451c());
        c2243l.m8476c(m8395m());
        c2243l.m8468a(this.f7676h);
        c2243l.m8478d(this.f7673e);
        c2243l.m8470a(this.f7686r.m8457a());
        if (m8405c().booleanValue()) {
            c2243l.m8480f("http://119.147.146.243/nep/v1/");
        } else {
            c2243l.m8480f(this.f7677i.m8447a(d));
        }
        c2243l.m8469a(new C22286(this, z));
        boolean a;
        if (z) {
            if (C2234g.m8423d(this.f7672d)) {
                return c2243l.m8472a(this.f7681m);
            }
            a = m8377a(c2243l.m8467a(), z);
            if (this.f7683o == null) {
                return a;
            }
            this.f7683o.m8349a();
            return a;
        } else if (m8385c(c)) {
            return c2243l.m8472a(this.f7681m);
        } else {
            a = m8377a(c2243l.m8467a(), z);
            if (this.f7683o == null) {
                return a;
            }
            this.f7683o.m8349a();
            return a;
        }
    }

    public String m8403b() {
        if (this.f7685q != null && this.f7675g == null) {
            C2194g c2194g = new C2194g();
            c2194g.m8256a("xaid", this.f7685q.m8481a());
            c2194g.m8256a(Constants.KEY_IMEI, this.f7685q.m8482b());
            c2194g.m8254a("mcc", this.f7685q.m8483c());
            c2194g.m8254a("mnc", this.f7685q.m8484d());
            c2194g.m8256a("cl", this.f7685q.m8485e());
            c2194g.m8254a("cn", this.f7685q.m8486f());
            c2194g.m8254a("cn2", this.f7685q.m8487g());
            c2194g.m8254a("prodid", this.f7685q.m8488h());
            c2194g.m8254a("ver", this.f7685q.m8489i());
            c2194g.m8256a(Constants.KEY_BRAND, this.f7685q.m8490j());
            c2194g.m8256a(Constants.KEY_MODEL, this.f7685q.m8491k());
            c2194g.m8254a("root", this.f7685q.m8492l());
            this.f7675g = c2194g.m8257b();
        }
        if (this.f7675g != null) {
            return this.f7675g;
        }
        Log.e("KSupport", "ERROR: Missing PublicBean");
        return BuildConfig.FLAVOR;
    }

    public boolean m8404b(int i) {
        if (!this.f7671c || !m8398a(i)) {
            return false;
        }
        C2243l c2243l = new C2243l();
        if (i == 1) {
            c2243l.m8471a("kav_event_active");
        } else if (i != 2) {
            return false;
        } else {
            c2243l.m8471a("kav_event_sactive");
        }
        c2243l.m8474b("ext_map=" + m8396n() + "&uptime=" + String.valueOf(System.currentTimeMillis() / 1000));
        c2243l.m8476c(m8403b());
        c2243l.m8468a(this.f7676h);
        c2243l.m8470a(this.f7686r.m8457a());
        if (m8405c().booleanValue()) {
            c2243l.m8480f("http://119.147.146.243/nep/v1/");
        } else {
            c2243l.m8480f(this.f7677i.m8447a(0));
        }
        c2243l.m8469a(new C22264(this));
        return c2243l.m8475b(this.f7681m);
    }

    public Boolean m8405c() {
        return this.f7678j.isDebugMode();
    }

    public C2193f m8406d() {
        return this.f7681m;
    }

    public C1820a m8407e() {
        return this.f7684p.m8462a();
    }

    public C2239j m8408f() {
        return this.f7686r;
    }
}
