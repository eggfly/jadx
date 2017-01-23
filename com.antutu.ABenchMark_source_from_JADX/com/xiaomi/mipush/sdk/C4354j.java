package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.C4308d.C4306a;
import com.xiaomi.push.service.C4445v;
import com.xiaomi.push.service.C4446w;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4519c;
import com.xiaomi.xmpush.thrift.C4523f;
import com.xiaomi.xmpush.thrift.C4536m;
import com.xiaomi.xmpush.thrift.C4548s;
import com.xiaomi.xmpush.thrift.ae;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.mipush.sdk.j */
public class C4354j extends C4306a {
    private Context f14814a;

    public C4354j(Context context) {
        this.f14814a = context;
    }

    public int m17833a() {
        return 2;
    }

    public void run() {
        C4445v a = C4445v.m18368a(this.f14814a);
        C4454a c4536m = new C4536m();
        c4536m.m18946a(C4446w.m18377a(a, C4519c.MISC_CONFIG));
        c4536m.m18952b(C4446w.m18377a(a, C4519c.PLUGIN_CONFIG));
        C4454a c4548s = new C4548s("-1", false);
        c4548s.m19061c(C4523f.DailyCheckClientConfig.f15748z);
        c4548s.m19052a(ae.m18793a(c4536m));
        C4360o.m17853a(this.f14814a).m17867a(c4548s, C4513a.Notification, null);
    }
}
