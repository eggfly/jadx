package com.igexin.push.core;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p165d.C3684e;
import com.igexin.p158b.p159a.p165d.p166a.C3664f;
import com.igexin.p158b.p159a.p165d.p166a.C3690c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3752k;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.p175b.C3795b;
import com.igexin.push.core.p175b.C3796c;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p175b.C3819z;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.extension.C3910a;
import com.igexin.push.p169f.p170b.C3732h;
import com.igexin.push.p169f.p170b.C3916a;
import com.igexin.push.p169f.p170b.C3918c;
import com.igexin.push.p169f.p170b.C3921g;
import com.igexin.push.p171a.p172a.C3712a;
import com.igexin.push.p171a.p172a.C3713b;
import com.igexin.push.p171a.p172a.C3714c;
import com.igexin.push.p171a.p172a.C3715d;
import com.igexin.push.p173b.C3718a;
import com.igexin.push.p173b.C3719b;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.p178e.C3900a;
import com.igexin.push.p178e.C3902c;
import com.igexin.push.p178e.C3909j;
import com.igexin.push.p182d.C3870a;
import com.igexin.push.p182d.p183a.C3869c;
import com.igexin.push.util.C3922a;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import com.igexin.sdk.p186a.C3940b;
import com.igexin.sdk.p186a.C3941c;
import com.igexin.sdk.p186a.C3942d;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.common.C4209a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.core.f */
public class C3854f implements C3690c {
    private static C3854f f12922l;
    private Context f12923a;
    private C3856h f12924b;
    private Handler f12925c;
    private ConcurrentLinkedQueue f12926d;
    private C3777e f12927e;
    private ConnectivityManager f12928f;
    private C3685c f12929g;
    private C3683b f12930h;
    private C3909j f12931i;
    private C3902c f12932j;
    private C3719b f12933k;
    private final int f12934m;
    private final int f12935n;
    private final AtomicBoolean f12936o;

    private C3854f() {
        this.f12934m = 100;
        this.f12935n = 30;
        this.f12936o = new AtomicBoolean(false);
        this.f12926d = new ConcurrentLinkedQueue();
        this.f12924b = new C3856h();
    }

    public static C3854f m15859a() {
        if (f12922l == null) {
            f12922l = new C3854f();
        }
        return f12922l;
    }

    private void m15860q() {
        try {
            if (C3754m.f12672p && m15886p()) {
                String packageName = this.f12923a.getPackageName();
                List<PackageInfo> installedPackages = this.f12923a.getPackageManager().getInstalledPackages(4);
                if (installedPackages != null && !installedPackages.isEmpty()) {
                    for (PackageInfo packageInfo : installedPackages) {
                        if ((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & SpdyProtocol.SLIGHTSSLV2) == 1) {
                            ServiceInfo[] serviceInfoArr = packageInfo.services;
                            if (!(serviceInfoArr == null || serviceInfoArr.length == 0)) {
                                int length = serviceInfoArr.length;
                                int i = 0;
                                while (i < length) {
                                    ServiceInfo serviceInfo = serviceInfoArr[i];
                                    if (C3794a.f12735o.equals(serviceInfo.name) || C3794a.f12734n.equals(serviceInfo.name) || C3794a.f12736p.equals(serviceInfo.name)) {
                                        String str = packageInfo.packageName;
                                        if (!packageName.equals(str)) {
                                            C3799f.m15623a().m15658d().put(str, serviceInfo.name);
                                        }
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean m15861r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("com.igexin.sdk.action.snlrefresh");
        intentFilter.addAction("com.igexin.sdk.action.snlretire");
        intentFilter.addAction(C3855g.f12958V);
        intentFilter.addAction("com.igexin.sdk.action.execute");
        intentFilter.addAction("com.igexin.sdk.action.doaction");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (C3922a.m16147c()) {
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        }
        if (this.f12923a.registerReceiver(C3862n.m15905a(), intentFilter) == null) {
            C3688a.m15097b("CoreLogic|InternalPublicReceiver|Failed");
        }
        intentFilter = new IntentFilter();
        intentFilter.addDataScheme(C4209a.f14200c);
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        if (this.f12923a.registerReceiver(C3861m.m15904a(), intentFilter) == null) {
            C3688a.m15097b("CoreLogic|InternalPackageReceiver|Failed");
        }
        return true;
    }

    public void m15862a(C3853e c3853e) {
        this.f12925c = c3853e;
    }

    public boolean m15863a(Context context) {
        this.f12923a = context;
        if (this.f12924b != null && this.f12924b.isAlive()) {
            C3688a.m15097b("CoreLogic|coreThread is alive +++++");
        } else if (!this.f12936o.getAndSet(true)) {
            C3688a.m15097b("CoreLogic|start coreThread +++++");
            this.f12924b.start();
        }
        return true;
    }

    public boolean m15864a(Intent intent) {
        if (C3855g.f12969g == null) {
            return false;
        }
        C3855g.f12969g.sendBroadcast(intent);
        return true;
    }

    public boolean m15865a(Message message) {
        if (C3855g.f12970h.get()) {
            this.f12925c.sendMessage(message);
        } else {
            this.f12926d.add(message);
        }
        return true;
    }

    public boolean m15866a(C3664f c3664f, C3684e c3684e) {
        return this.f12927e != null && this.f12927e.m15531a((Object) c3664f);
    }

    public boolean m15867a(C3666d c3666d, C3684e c3684e) {
        return this.f12927e != null && this.f12927e.m15529a(c3666d);
    }

    public boolean m15868a(C3732h c3732h) {
        return c3732h != null && C3685c.m15060b().m15053a(c3732h, false, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m15869a(java.lang.String r9) {
        /*
        r8 = this;
        r7 = 1;
        r3 = 0;
        r0 = com.igexin.push.core.p176a.C3777e.m15491a();
        r1 = "ss";
        r0 = r0.m15551d(r1);
        r1 = com.igexin.push.core.C3855g.f12969g;
        if (r1 == 0) goto L_0x009a;
    L_0x0010:
        r1 = r8.f12932j;
        if (r1 == 0) goto L_0x009a;
    L_0x0014:
        r1 = new com.igexin.sdk.a.d;
        r2 = com.igexin.push.core.C3855g.f12969g;
        r1.<init>(r2);
        r1.m16227b();
        com.igexin.push.core.C3855g.f12972j = r3;
        com.igexin.push.core.C3855g.f12977o = r3;
        r1 = new com.igexin.push.e.a;
        r1.<init>();
        r2 = com.igexin.push.core.C3849c.stop;
        r1.m16004a(r2);
        r2 = r8.f12932j;
        r2.m16038a(r1);
        if (r0 == 0) goto L_0x009a;
    L_0x0033:
        r1 = "1";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x009a;
    L_0x003b:
        r0 = "ps";
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x009b }
        r0 = r1.exec(r0);	 Catch:{ Exception -> 0x009b }
        r0 = r0.getInputStream();	 Catch:{ Exception -> 0x009b }
        if (r0 == 0) goto L_0x0097;
    L_0x004b:
        r1 = com.igexin.push.core.C3855g.f12969g;	 Catch:{ Exception -> 0x009b }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x009b }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x009b }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x009b }
        r3.<init>(r0);	 Catch:{ Exception -> 0x009b }
        r2.<init>(r3);	 Catch:{ Exception -> 0x009b }
    L_0x005b:
        r3 = r2.readLine();	 Catch:{ Exception -> 0x009b }
        if (r3 == 0) goto L_0x0091;
    L_0x0061:
        r4 = "\\s+";
        r4 = r3.split(r4);	 Catch:{ Exception -> 0x009b }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b }
        r5.<init>();	 Catch:{ Exception -> 0x009b }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x009b }
        r6 = "/files/gdaemon";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x009b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x009b }
        r3 = r3.contains(r5);	 Catch:{ Exception -> 0x009b }
        if (r3 == 0) goto L_0x005b;
    L_0x0080:
        r3 = r4.length;	 Catch:{ Exception -> 0x009b }
        if (r3 <= 0) goto L_0x005b;
    L_0x0083:
        r1 = 1;
        r1 = r4[r1];	 Catch:{ Exception -> 0x009b }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x009b }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x009b }
        android.os.Process.killProcess(r1);	 Catch:{ Exception -> 0x009b }
    L_0x0091:
        r2.close();	 Catch:{ Exception -> 0x009b }
        r0.close();	 Catch:{ Exception -> 0x009b }
    L_0x0097:
        r8.m15875e();
    L_0x009a:
        return r7;
    L_0x009b:
        r0 = move-exception;
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.a(java.lang.String):boolean");
    }

    public boolean m15870a(boolean z) {
        if (!(C3855g.f12969g == null || this.f12932j == null)) {
            new C3942d(C3855g.f12969g).m16226a();
            C3855g.f12972j = true;
            if (!new C3940b(C3855g.f12969g).m16222b()) {
                new C3941c(C3855g.f12969g).m16223a();
                C3855g.f12973k = true;
                new C3940b(C3855g.f12969g).m16221a();
            }
            if (z) {
                new C3941c(C3855g.f12969g).m16223a();
                C3855g.f12973k = true;
            }
            C3900a c3900a = new C3900a();
            c3900a.m16004a(C3849c.start);
            this.f12932j.m16038a(c3900a);
        }
        return true;
    }

    public void m15871b() {
        try {
            this.f12928f = (ConnectivityManager) this.f12923a.getSystemService("connectivity");
            C3855g.m15890a(this.f12923a);
            this.f12933k = new C3719b(this.f12923a);
            C3752k.m15410a().m15411b();
            m15861r();
            this.f12929g = C3685c.m15060b();
            this.f12929g.m15066a(new C3870a(this.f12923a, m15880j()));
            this.f12929g.m15050a((C3690c) this);
            this.f12929g.m15049a(this.f12923a);
            C3666d c3718a = new C3718a();
            c3718a.m15235a(C3799f.m15623a());
            c3718a.m15235a(C3796c.m15612a());
            c3718a.m15235a(C3795b.m15607a());
            c3718a.m15235a(C3742a.m15382a());
            c3718a.m15235a(C3819z.m15684a());
            this.f12929g.m15053a(c3718a, true, false);
            C3685c.m15060b().m15067a(C3700a.m15134a(C3855g.f12938B.getBytes()));
            C3855g.ae = this.f12929g.m15053a(C3918c.m16117g(), false, true);
            C3855g.af = this.f12929g.m15053a(C3921g.m16131g(), true, true);
            C3730i.m15273a().m15275c();
            m15873c();
            this.f12927e = C3777e.m15491a();
            m15874d();
            this.f12931i = new C3909j();
            this.f12931i.m16059a(this.f12923a, this.f12929g, this.f12927e);
            this.f12932j = new C3902c();
            this.f12932j.m16036a(this.f12923a);
            C3900a c3900a = new C3900a();
            c3900a.m16004a(C3849c.start);
            this.f12932j.m16038a(c3900a);
            C3714c.m15218c().m15222d();
            C3855g.f12970h.set(true);
            Iterator it = this.f12926d.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                if (this.f12925c != null) {
                    this.f12925c.sendMessage(message);
                }
            }
            C3777e.m15491a().m15571t();
            this.f12927e.m15511a(Process.myPid());
            m15860q();
            C3910a.m16066a().m16069a(this.f12923a);
        } catch (Exception e) {
            C3688a.m15097b("CoreLogic CoreLogic|init|failed");
        }
    }

    public boolean m15872b(String str) {
        if (!(C3855g.f12969g == null || this.f12932j == null)) {
            new C3941c(C3855g.f12969g).m16224b();
            C3855g.f12973k = false;
            C3855g.f12977o = false;
            C3900a c3900a = new C3900a();
            c3900a.m16004a(C3849c.stop);
            this.f12932j.m16038a(c3900a);
        }
        return true;
    }

    public C3916a m15873c() {
        C3666d g = C3916a.m16109g();
        g.m16112a(new C3712a());
        g.m16112a(new C3713b());
        g.m16112a(new C3715d());
        g.m16112a(C3714c.m15218c());
        C3855g.ag = this.f12929g.m15053a(g, false, true);
        this.f12923a.sendBroadcast(new Intent());
        return g;
    }

    public void m15874d() {
        if (TextUtils.isEmpty(C3855g.f12987y)) {
            try {
                if (C3922a.m16139a()) {
                    WifiInfo connectionInfo = ((WifiManager) this.f12923a.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
                    if (connectionInfo != null) {
                        C3799f.m15623a().m15644a(connectionInfo.getMacAddress());
                    }
                    C3688a.m15097b("CoreLogic mac:" + C3855g.f12987y);
                }
            } catch (Throwable th) {
            }
        }
    }

    public void m15875e() {
        Intent intent = new Intent(this.f12923a.getApplicationContext(), PushService.class);
        intent.putExtra(PushConsts.CMD_ACTION, "stopUserService");
        this.f12923a.getApplicationContext().startService(intent);
        this.f12923a.stopService(new Intent(this.f12923a, PushService.class));
    }

    public C3683b m15876f() {
        if (this.f12930h == null) {
            this.f12930h = C3869c.m15917a();
        }
        return this.f12930h;
    }

    public C3909j m15877g() {
        return this.f12931i;
    }

    public C3902c m15878h() {
        return this.f12932j;
    }

    public C3777e m15879i() {
        return this.f12927e;
    }

    public ConnectivityManager m15880j() {
        return this.f12928f;
    }

    public C3719b m15881k() {
        return this.f12933k;
    }

    public void m15882l() {
        try {
            this.f12923a.unregisterReceiver(C3685c.m15060b());
        } catch (Exception e) {
        }
        try {
            this.f12923a.unregisterReceiver(C3861m.m15904a());
        } catch (Exception e2) {
        }
        try {
            this.f12923a.unregisterReceiver(C3862n.m15905a());
        } catch (Exception e3) {
        }
        try {
            C3910a.m16066a().m16071b();
        } catch (Throwable th) {
        }
    }

    public String m15883m() {
        if (this.f12928f == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = this.f12928f.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() == 1 ? UtilityImpl.NET_TYPE_WIFI : activeNetworkInfo.getType() == 0 ? "mobile" : null : null;
    }

    public boolean m15884n() {
        return true;
    }

    public long m15885o() {
        return 94808;
    }

    public boolean m15886p() {
        try {
            ActivityManager activityManager = (ActivityManager) C3855g.f12969g.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j = (memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            if (memoryInfo.lowMemory) {
                C3688a.m15098b("CoreLogic", "system in lowMemory, available menmory = " + j + "M");
                return false;
            } else if (j < 100) {
                return false;
            } else {
                return (((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) + Runtime.getRuntime().freeMemory()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID > 30;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
