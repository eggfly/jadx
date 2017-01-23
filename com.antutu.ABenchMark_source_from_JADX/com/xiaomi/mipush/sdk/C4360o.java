package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.string.C4328c;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ac;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4550t;
import com.xiaomi.xmpush.thrift.ae;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.mipush.sdk.o */
public class C4360o {
    private static C4360o f14825b;
    private static final ArrayList<C4359a> f14826e;
    private boolean f14827a;
    private Context f14828c;
    private String f14829d;
    private Intent f14830f;
    private Integer f14831g;

    /* renamed from: com.xiaomi.mipush.sdk.o.a */
    static class C4359a<T extends C4454a<T, ?>> {
        T f14822a;
        C4513a f14823b;
        boolean f14824c;

        C4359a() {
        }
    }

    static {
        f14826e = new ArrayList();
    }

    private C4360o(Context context) {
        this.f14827a = false;
        this.f14830f = null;
        this.f14831g = null;
        this.f14828c = context.getApplicationContext();
        this.f14829d = null;
        this.f14827a = m17857g();
    }

    public static C4360o m17853a(Context context) {
        if (f14825b == null) {
            f14825b = new C4360o(context);
        }
        return f14825b;
    }

    private void m17855a(Intent intent) {
        try {
            this.f14828c.startService(intent);
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
    }

    private boolean m17857g() {
        try {
            PackageInfo packageInfo = this.f14828c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= Constants.COMMAND_ELECTION;
        } catch (Exception e) {
            return false;
        }
    }

    private Intent m17858h() {
        Intent intent = new Intent();
        String packageName = this.f14828c.getPackageName();
        if (!m17874b() || "com.xiaomi.xmsf".equals(packageName)) {
            m17861k();
            intent.setComponent(new ComponentName(this.f14828c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m17859i());
            intent.putExtra("mipush_app_package", packageName);
            m17860j();
        }
        return intent;
    }

    private String m17859i() {
        try {
            if (this.f14828c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= Constants.COMMAND_ROUTING_ACK) {
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception e) {
        }
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private void m17860j() {
        try {
            this.f14828c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f14828c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    private void m17861k() {
        try {
            this.f14828c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f14828c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    private boolean m17862l() {
        String packageName = this.f14828c.getPackageName();
        return packageName.contains("miui") || packageName.contains(MsgConstant.MESSAGE_SYSTEM_SOURCE_XIAOMI) || (this.f14828c.getApplicationInfo().flags & 1) != 0;
    }

    public void m17863a() {
        m17855a(m17858h());
    }

    public void m17864a(int i) {
        Intent h = m17858h();
        h.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        h.putExtra(aa.f15001y, this.f14828c.getPackageName());
        h.putExtra(aa.f15002z, i);
        m17855a(h);
    }

    public final void m17865a(com.xiaomi.xmpush.thrift.aa aaVar) {
        Intent h = m17858h();
        byte[] a = ae.m18793a(C4355k.m17834a(this.f14828c, aaVar, C4513a.UnRegistration));
        if (a == null) {
            C4302b.m17649a("unregister fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        h.putExtra("mipush_app_id", C4343a.m17800a(this.f14828c).m17810c());
        h.putExtra("mipush_payload", a);
        m17855a(h);
    }

    public final void m17866a(C4550t c4550t, boolean z) {
        this.f14830f = null;
        Intent h = m17858h();
        byte[] a = ae.m18793a(C4355k.m17834a(this.f14828c, c4550t, C4513a.Registration));
        if (a == null) {
            C4302b.m17649a("register fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.REGISTER_APP");
        h.putExtra("mipush_app_id", C4343a.m17800a(this.f14828c).m17810c());
        h.putExtra("mipush_payload", a);
        h.putExtra("mipush_session", this.f14829d);
        h.putExtra("mipush_env_chanage", z);
        h.putExtra("mipush_env_type", C4343a.m17800a(this.f14828c).m17820m());
        if (C4321d.m17709d(this.f14828c) && m17878f()) {
            m17855a(h);
        } else {
            this.f14830f = h;
        }
    }

    public final <T extends C4454a<T, ?>> void m17867a(T t, C4513a c4513a, C4529i c4529i) {
        m17869a(t, c4513a, !c4513a.equals(C4513a.Registration), c4529i);
    }

    public <T extends C4454a<T, ?>> void m17868a(T t, C4513a c4513a, boolean z) {
        C4359a c4359a = new C4359a();
        c4359a.f14822a = t;
        c4359a.f14823b = c4513a;
        c4359a.f14824c = z;
        synchronized (f14826e) {
            f14826e.add(c4359a);
            if (f14826e.size() > 10) {
                f14826e.remove(0);
            }
        }
    }

    public final <T extends C4454a<T, ?>> void m17869a(T t, C4513a c4513a, boolean z, C4529i c4529i) {
        m17871a(t, c4513a, z, true, c4529i, true);
    }

    public final <T extends C4454a<T, ?>> void m17870a(T t, C4513a c4513a, boolean z, C4529i c4529i, boolean z2) {
        m17871a(t, c4513a, z, true, c4529i, z2);
    }

    public final <T extends C4454a<T, ?>> void m17871a(T t, C4513a c4513a, boolean z, boolean z2, C4529i c4529i, boolean z3) {
        m17872a(t, c4513a, z, z2, c4529i, z3, this.f14828c.getPackageName(), C4343a.m17800a(this.f14828c).m17810c());
    }

    public final <T extends C4454a<T, ?>> void m17872a(T t, C4513a c4513a, boolean z, boolean z2, C4529i c4529i, boolean z3, String str, String str2) {
        if (C4343a.m17800a(this.f14828c).m17816i()) {
            Intent h = m17858h();
            C4454a a = C4355k.m17835a(this.f14828c, t, c4513a, z, str, str2);
            if (c4529i != null) {
                a.m19001a(c4529i);
            }
            byte[] a2 = ae.m18793a(a);
            if (a2 == null) {
                C4302b.m17649a("send message fail, because msgBytes is null.");
                return;
            }
            h.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            h.putExtra("mipush_payload", a2);
            h.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            m17855a(h);
        } else if (z2) {
            m17868a((C4454a) t, c4513a, z);
        } else {
            C4302b.m17649a("drop the message before initialization.");
        }
    }

    public void m17873b(int i) {
        Intent h = m17858h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(aa.f15001y, this.f14828c.getPackageName());
        h.putExtra(aa.f14974A, i);
        h.putExtra(aa.f14976C, C4328c.m17740b(this.f14828c.getPackageName() + i));
        m17855a(h);
    }

    public boolean m17874b() {
        return this.f14827a && 1 == C4343a.m17800a(this.f14828c).m17820m();
    }

    public void m17875c() {
        if (this.f14830f != null) {
            m17855a(this.f14830f);
            this.f14830f = null;
        }
    }

    public void m17876d() {
        synchronized (f14826e) {
            Iterator it = f14826e.iterator();
            while (it.hasNext()) {
                C4359a c4359a = (C4359a) it.next();
                m17871a(c4359a.f14822a, c4359a.f14823b, c4359a.f14824c, false, null, true);
            }
            f14826e.clear();
        }
    }

    public void m17877e() {
        Intent h = m17858h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(aa.f15001y, this.f14828c.getPackageName());
        h.putExtra(aa.f14976C, C4328c.m17740b(this.f14828c.getPackageName()));
        m17855a(h);
    }

    public boolean m17878f() {
        if (!m17874b() || !m17862l()) {
            return true;
        }
        if (this.f14831g == null) {
            this.f14831g = Integer.valueOf(ac.m18115a(this.f14828c).m18117b());
            if (this.f14831g.intValue() == 0) {
                this.f14828c.getContentResolver().registerContentObserver(ac.m18115a(this.f14828c).m18118c(), false, new C4361p(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f14831g.intValue() != 0;
    }
}
