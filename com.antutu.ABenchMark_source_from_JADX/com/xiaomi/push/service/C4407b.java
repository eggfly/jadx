package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4481b;
import com.xiaomi.smack.packet.C4482c;
import com.xiaomi.smack.packet.C4485f;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.b */
public class C4407b {
    private C4422k f15053a;

    public C4407b() {
        this.f15053a = new C4422k();
    }

    public static String m18182a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    private static void m18183a(Context context, Intent intent, String str) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, C4407b.m18182a(str));
        }
    }

    C4448b m18184a(C4468d c4468d) {
        Collection c = C4450y.m18390a().m18402c(c4468d.m18517l());
        if (c.isEmpty()) {
            return null;
        }
        Iterator it = c.iterator();
        if (c.size() == 1) {
            return (C4448b) it.next();
        }
        CharSequence n = c4468d.m18521n();
        CharSequence m = c4468d.m18519m();
        while (it.hasNext()) {
            C4448b c4448b = (C4448b) it.next();
            if (TextUtils.equals(n, c4448b.f15170b)) {
                return c4448b;
            }
            if (TextUtils.equals(m, c4448b.f15170b)) {
                return c4448b;
            }
        }
        return null;
    }

    public void m18185a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        context.sendBroadcast(intent);
    }

    public void m18186a(Context context, C4448b c4448b, int i) {
        if (!"5".equalsIgnoreCase(c4448b.f15176h)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(c4448b.f15169a);
            intent.putExtra(aa.f14993q, c4448b.f15176h);
            intent.putExtra("ext_reason", i);
            intent.putExtra(aa.f14992p, c4448b.f15170b);
            intent.putExtra(aa.f14975B, c4448b.f15178j);
            C4407b.m18183a(context, intent, c4448b.f15169a);
        }
    }

    public void m18187a(Context context, C4448b c4448b, String str, String str2) {
        if ("5".equalsIgnoreCase(c4448b.f15176h)) {
            C4302b.m17654d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(c4448b.f15169a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", c4448b.f15176h);
        intent.putExtra(aa.f14992p, c4448b.f15170b);
        intent.putExtra(aa.f14975B, c4448b.f15178j);
        C4407b.m18183a(context, intent, c4448b.f15169a);
    }

    public void m18188a(Context context, C4448b c4448b, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(c4448b.f15176h)) {
            this.f15053a.m18264a(context, c4448b, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(c4448b.f15169a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", c4448b.f15176h);
        intent.putExtra(aa.f14992p, c4448b.f15170b);
        intent.putExtra(aa.f14975B, c4448b.f15178j);
        C4407b.m18183a(context, intent, c4448b.f15169a);
    }

    public void m18189a(XMPushService xMPushService, String str, C4468d c4468d) {
        C4448b a = m18184a(c4468d);
        if (a == null) {
            C4302b.m17654d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f15053a.m18265a(xMPushService, c4468d, a);
        } else {
            String str2;
            String str3 = a.f15169a;
            if (c4468d instanceof C4482c) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (c4468d instanceof C4481b) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (c4468d instanceof C4485f) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                C4302b.m17654d("unknown packet type, drop it");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", c4468d.m18514c());
            intent.putExtra(aa.f14975B, a.f15178j);
            intent.putExtra(aa.f14997u, a.f15177i);
            C4407b.m18183a((Context) xMPushService, intent, str3);
        }
    }
}
