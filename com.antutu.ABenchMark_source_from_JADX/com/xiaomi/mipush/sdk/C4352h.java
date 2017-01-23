package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4548s;
import java.util.HashMap;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.mipush.sdk.h */
final class C4352h implements Runnable {
    C4352h() {
    }

    public void run() {
        if (C4293e.m17611c(MiPushClient.sContext) != null) {
            C4454a c4548s = new C4548s();
            c4548s.m19057b(C4343a.m17800a(MiPushClient.sContext).m17810c());
            c4548s.m19061c("client_info_update");
            c4548s.m19048a(MiPushClient.generatePacketID());
            c4548s.m19050a(new HashMap());
            c4548s.m19068h().put(Constants.EXTRA_KEY_IMEI_MD5, C4329d.m17742a(C4293e.m17611c(MiPushClient.sContext)));
            int b = C4293e.m17609b();
            if (b >= 0) {
                c4548s.m19068h().put("space_id", Integer.toString(b));
            }
            C4360o.m17853a(MiPushClient.sContext).m17869a(c4548s, C4513a.Notification, false, null);
        }
    }
}
