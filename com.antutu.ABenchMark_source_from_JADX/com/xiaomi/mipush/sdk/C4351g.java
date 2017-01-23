package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.module.C4426b;
import com.xiaomi.push.service.module.C4429c;
import com.xiaomi.push.service.module.C4430d;

/* renamed from: com.xiaomi.mipush.sdk.g */
final class C4351g implements Runnable {
    C4351g() {
    }

    public void run() {
        C4426b a = C4429c.m18307a(MiPushClient.sContext).m18312a(C4430d.MODULE_CDATA);
        if (a != null) {
            try {
                a.m18302a().loadClass("com.xiaomi.push.mpcd.MpcdPlugin").getMethod("main", new Class[]{Context.class}).invoke(null, new Object[]{MiPushClient.sContext});
            } catch (Exception e) {
                C4302b.m17649a("plugin load fail");
            }
        }
    }
}
