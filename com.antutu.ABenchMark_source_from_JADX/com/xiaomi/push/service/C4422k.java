package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.packet.C4482c;
import com.xiaomi.smack.util.C4500j;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4534l;
import com.xiaomi.xmpush.thrift.C4542p;
import com.xiaomi.xmpush.thrift.ae;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.push.service.k */
public class C4422k {
    public static C4542p m18251a(Context context, C4542p c4542p) {
        C4454a c4534l = new C4534l();
        c4534l.m18922b(c4542p.m19020h());
        C4529i m = c4542p.m19025m();
        if (m != null) {
            c4534l.m18915a(m.m18867b());
            c4534l.m18914a(m.m18874d());
            if (!TextUtils.isEmpty(m.m18879f())) {
                c4534l.m18926c(m.m18879f());
            }
        }
        c4534l.m18916a(ae.m18791a(context, c4542p.f16046f));
        C4542p a = XMPushService.m18049a(c4542p.m19022j(), c4542p.m19020h(), c4534l, C4513a.AckMessage);
        m = c4542p.m19025m().m18856a();
        m.m18860a("mat", Long.toString(System.currentTimeMillis()));
        a.m19001a(m);
        return a;
    }

    private static void m18252a(XMPushService xMPushService, C4542p c4542p) {
        xMPushService.m18080a(new C4424m(4, xMPushService, c4542p));
    }

    private static void m18253a(XMPushService xMPushService, C4542p c4542p, String str) {
        xMPushService.m18080a(new C4434p(4, xMPushService, c4542p, str));
    }

    private static void m18254a(XMPushService xMPushService, C4542p c4542p, String str, String str2) {
        xMPushService.m18080a(new C4435q(4, xMPushService, c4542p, str, str2));
    }

    private static void m18255a(XMPushService xMPushService, byte[] bArr, long j) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        C4542p c4542p = new C4542p();
        try {
            ae.m18792a((C4454a) c4542p, bArr);
            if (TextUtils.isEmpty(c4542p.f16046f)) {
                C4302b.m17649a("receive a mipush message without package name");
                return;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mrt", Long.toString(valueOf.longValue()));
            intent.setPackage(c4542p.f16046f);
            String a = C4436r.m18328a(c4542p);
            C4500j.m18663a(xMPushService, a, j, true, System.currentTimeMillis());
            C4529i m = c4542p.m19025m();
            if (m != null) {
                m.m18860a("mrt", Long.toString(valueOf.longValue()));
            }
            String str;
            if (C4513a.SendMessage == c4542p.m18999a() && C4419h.m18239a((Context) xMPushService).m18240a(c4542p.f16046f) && !C4436r.m18338b(c4542p)) {
                str = BuildConfig.FLAVOR;
                if (m != null) {
                    str = m.m18867b();
                }
                C4302b.m17649a("Drop a message for unregistered, msgid=" + str);
                C4422k.m18253a(xMPushService, c4542p, c4542p.f16046f);
            } else if (C4513a.SendMessage != c4542p.m18999a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), c4542p.f16046f)) {
                if (!(m == null || m.m18867b() == null)) {
                    C4302b.m17649a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[]{c4542p.m19020h(), m.m18867b()}));
                }
                if (m != null) {
                    Map s = m.m18892s();
                    if (s != null && s.containsKey("hide") && "true".equalsIgnoreCase((String) s.get("hide"))) {
                        C4422k.m18252a(xMPushService, c4542p);
                        return;
                    }
                }
                if (C4422k.m18263c(c4542p) && C4422k.m18257a((Context) xMPushService, a)) {
                    C4422k.m18259b(xMPushService, c4542p);
                } else if (C4422k.m18258a(c4542p) && !C4422k.m18257a((Context) xMPushService, a) && !C4422k.m18261b(c4542p)) {
                    C4422k.m18262c(xMPushService, c4542p);
                } else if ((C4436r.m18338b(c4542p) && C4422k.m18260b((Context) xMPushService, c4542p.f16046f)) || C4422k.m18256a((Context) xMPushService, intent)) {
                    if (C4513a.Registration == c4542p.m18999a()) {
                        str = c4542p.m19022j();
                        Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                        edit.putString(str, c4542p.f16045e);
                        edit.commit();
                    }
                    if (m != null && !TextUtils.isEmpty(m.m18881h()) && !TextUtils.isEmpty(m.m18883j()) && m.f15846h != 1 && (C4436r.m18333a(m.m18892s()) || !C4436r.m18332a((Context) xMPushService, c4542p.f16046f))) {
                        boolean z = false;
                        str = null;
                        if (m != null) {
                            if (m.f15848j != null) {
                                str = (String) m.f15848j.get("jobkey");
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = m.m18867b();
                            }
                            z = C4438s.m18345a(xMPushService, c4542p.f16046f, str);
                        }
                        if (z) {
                            C4302b.m17649a("drop a duplicate message, key=" + str);
                        } else {
                            C4436r.m18330a((Context) xMPushService, c4542p, bArr);
                            if (!C4436r.m18338b(c4542p)) {
                                Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                                intent2.putExtra("mipush_payload", bArr);
                                intent2.setPackage(c4542p.f16046f);
                                try {
                                    List queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                    if (!(queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty())) {
                                        xMPushService.sendBroadcast(intent2, C4407b.m18182a(c4542p.f16046f));
                                    }
                                } catch (Exception e) {
                                    xMPushService.sendBroadcast(intent2, C4407b.m18182a(c4542p.f16046f));
                                }
                            }
                        }
                        C4422k.m18252a(xMPushService, c4542p);
                    } else if (!"com.xiaomi.xmsf".contains(c4542p.f16046f) || c4542p.m19014c() || m == null || !m.m18892s().containsKey("ab")) {
                        xMPushService.sendBroadcast(intent, C4407b.m18182a(c4542p.f16046f));
                    } else {
                        C4422k.m18252a(xMPushService, c4542p);
                        C4302b.m17653c("receive abtest message. ack it." + m.m18867b());
                    }
                    if (c4542p.m18999a() == C4513a.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                        xMPushService.stopSelf();
                    }
                } else if (C4422k.m18260b((Context) xMPushService, c4542p.f16046f)) {
                    C4302b.m17649a("receive a mipush message, we can see the app, but we can't see the receiver.");
                } else {
                    xMPushService.m18080a(new C4423l(4, xMPushService, c4542p));
                }
            } else {
                C4302b.m17649a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + c4542p.f16046f);
                C4422k.m18254a(xMPushService, c4542p, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + c4542p.f16046f);
            }
        } catch (Throwable th) {
            C4302b.m17651a(th);
        }
    }

    private static boolean m18256a(Context context, Intent intent) {
        try {
            List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) ? false : true;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean m18257a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return (packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() && packageManager.queryIntentServices(intent, 32).isEmpty()) ? false : true;
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return false;
        }
    }

    private static boolean m18258a(C4542p c4542p) {
        return "com.xiaomi.xmsf".equals(c4542p.f16046f) && c4542p.m19025m() != null && c4542p.m19025m().m18892s() != null && c4542p.m19025m().m18892s().containsKey("miui_package_name");
    }

    private static void m18259b(XMPushService xMPushService, C4542p c4542p) {
        xMPushService.m18080a(new C4432n(4, xMPushService, c4542p));
    }

    private static boolean m18260b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static boolean m18261b(C4542p c4542p) {
        return c4542p.m19025m().m18892s().containsKey("notify_effect");
    }

    private static void m18262c(XMPushService xMPushService, C4542p c4542p) {
        xMPushService.m18080a(new C4433o(4, xMPushService, c4542p));
    }

    private static boolean m18263c(C4542p c4542p) {
        return (c4542p.m19025m() == null || c4542p.m19025m().m18892s() == null) ? false : MessageService.MSG_DB_NOTIFY_REACHED.equals(c4542p.m19025m().m18892s().get("obslete_ads_message"));
    }

    public void m18264a(Context context, C4448b c4448b, boolean z, int i, String str) {
        if (!z) {
            C4416f a = C4418g.m18232a(context);
            if (a != null && "token-expired".equals(str)) {
                try {
                    C4418g.m18233a(context, a.f15077d, a.f15078e, a.f15079f);
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                } catch (Throwable e2) {
                    C4302b.m17651a(e2);
                }
            }
        }
    }

    public void m18265a(XMPushService xMPushService, C4468d c4468d, C4448b c4448b) {
        if (c4468d instanceof C4482c) {
            C4482c c4482c = (C4482c) c4468d;
            C4479a p = c4482c.m18525p("s");
            if (p != null) {
                try {
                    C4422k.m18255a(xMPushService, ae.m18127b(ae.m18124a(c4448b.f15177i, c4482c.m18515k()), p.m18575c()), (long) C4500j.m18659a(c4468d.m18510a()));
                    return;
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                    return;
                }
            }
            return;
        }
        C4302b.m17649a("not a mipush message");
    }
}
