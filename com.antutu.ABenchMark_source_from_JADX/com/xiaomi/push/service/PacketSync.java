package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.google.protobuf.micro.C3616c;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C4371b;
import com.xiaomi.push.protobuf.C4380b.C4379a;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.C4450y.C4449c;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.smack.C4403b;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.C4472k.C4471b;
import com.xiaomi.smack.C4472k.C4471b.C4470a;
import com.xiaomi.smack.C4473l;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.packet.C4481b;
import com.xiaomi.smack.packet.C4482c;
import com.xiaomi.smack.packet.C4488h;
import com.xiaomi.smack.util.C4500j;
import com.xiaomi.stats.C4512h;
import java.util.Date;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;

public class PacketSync {
    private XMPushService f14930a;

    public interface PacketReceiveHandler extends Parcelable {
    }

    PacketSync(XMPushService xMPushService) {
        this.f14930a = xMPushService;
    }

    private void m18015a(C4479a c4479a) {
        Object c = c4479a.m18575c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C4403b.m18156b(), false);
            if (fallbacksByHost != null && split.length > 0) {
                fallbacksByHost.m17902a(split);
                this.f14930a.m18079a(20, null);
                this.f14930a.m18090a(true);
            }
        }
    }

    private void m18016b(C4468d c4468d) {
        Object m = c4468d.m18519m();
        Object l = c4468d.m18517l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l)) {
            C4448b b = C4450y.m18390a().m18398b(l, m);
            if (b != null) {
                C4500j.m18663a(this.f14930a, b.f15169a, (long) C4500j.m18659a(c4468d.m18510a()), true, System.currentTimeMillis());
            }
        }
    }

    public void m18017a(C4468d c4468d) {
        if (!"5".equals(c4468d.m18517l())) {
            m18016b(c4468d);
        }
        C4448b b;
        if (c4468d instanceof C4471b) {
            C4471b c4471b = (C4471b) c4468d;
            C4470a b2 = c4471b.m18536b();
            String l = c4471b.m18517l();
            String m = c4471b.m18519m();
            if (!TextUtils.isEmpty(l)) {
                b = C4450y.m18390a().m18398b(l, m);
                if (b == null) {
                    return;
                }
                if (b2 == C4470a.f15347a) {
                    b.m18388a(C4449c.binded, 1, 0, null, null);
                    C4302b.m17649a("SMACK: channel bind succeeded, chid=" + l);
                    return;
                }
                C4488h p = c4471b.m18526p();
                C4302b.m17649a("SMACK: channel bind failed, error=" + p.m18621d());
                if (p != null) {
                    if (BaseMonitor.ALARM_POINT_AUTH.equals(p.m18619b())) {
                        if ("invalid-sig".equals(p.m18618a())) {
                            C4302b.m17649a("SMACK: bind error invalid-sig token = " + b.f15171c + " sec = " + b.f15177i);
                            C4512h.m18708a(0, C4452a.BIND_INVALID_SIG.m18407a(), 1, null, 0);
                        }
                        b.m18388a(C4449c.unbind, 1, 5, p.m18618a(), p.m18619b());
                        C4450y.m18390a().m18397a(l, m);
                    } else if ("cancel".equals(p.m18619b())) {
                        b.m18388a(C4449c.unbind, 1, 7, p.m18618a(), p.m18619b());
                        C4450y.m18390a().m18397a(l, m);
                    } else if ("wait".equals(p.m18619b())) {
                        this.f14930a.m18095b(b);
                        b.m18388a(C4449c.unbind, 1, 7, p.m18618a(), p.m18619b());
                    }
                    C4302b.m17649a("SMACK: channel bind failed, chid=" + l + " reason=" + p.m18618a());
                    return;
                }
                return;
            }
            return;
        }
        String l2 = c4468d.m18517l();
        if (TextUtils.isEmpty(l2)) {
            l2 = MessageService.MSG_DB_NOTIFY_REACHED;
            c4468d.m18518l(l2);
        }
        C4479a p2;
        String m2;
        String a;
        if (!l2.equals(MessageService.MSG_DB_READY_REPORT)) {
            if (c4468d instanceof C4481b) {
                p2 = c4468d.m18525p("kick");
                if (p2 != null) {
                    m2 = c4468d.m18519m();
                    a = p2.m18572a(C4233j.f14402y);
                    String a2 = p2.m18572a("reason");
                    C4302b.m17649a("kicked by server, chid=" + l2 + " userid=" + m2 + " type=" + a + " reason=" + a2);
                    if ("wait".equals(a)) {
                        b = C4450y.m18390a().m18398b(l2, m2);
                        if (b != null) {
                            this.f14930a.m18095b(b);
                            b.m18388a(C4449c.unbind, 3, 0, a2, a);
                            return;
                        }
                        return;
                    }
                    this.f14930a.m18088a(l2, m2, 3, a2, a);
                    C4450y.m18390a().m18397a(l2, m2);
                    return;
                }
            } else if (c4468d instanceof C4482c) {
                C4482c c4482c = (C4482c) c4468d;
                if ("redir".equals(c4482c.m18592b())) {
                    p2 = c4482c.m18525p(C0714a.HOSTS);
                    if (p2 != null) {
                        m18015a(p2);
                        return;
                    }
                    return;
                }
            }
            this.f14930a.m18100d().m18189a(this.f14930a, l2, c4468d);
        } else if (c4468d instanceof C4481b) {
            C4481b c4481b = (C4481b) c4468d;
            if (MessageService.MSG_DB_READY_REPORT.equals(c4468d.m18515k()) && "result".equals(c4481b.m18585b().toString())) {
                C4461a g = this.f14930a.m18103g();
                if (g instanceof C4473l) {
                    ((C4473l) g).m18561x();
                }
                C4512h.m18713b();
            } else if (IntentUtil.AGOO_COMMAND.equals(c4481b.m18585b().toString())) {
                p2 = c4468d.m18525p("u");
                if (p2 != null) {
                    l2 = p2.m18572a("url");
                    m2 = p2.m18572a("startts");
                    a = p2.m18572a("endts");
                    try {
                        Date date = new Date(Long.parseLong(m2));
                        Date date2 = new Date(Long.parseLong(a));
                        m2 = p2.m18572a(Constants.EXTRA_KEY_TOKEN);
                        boolean equals = "true".equals(p2.m18572a("force"));
                        Object a3 = p2.m18572a("maxlen");
                        C4371b.m17957a(this.f14930a).m17966a(l2, m2, date2, date, !TextUtils.isEmpty(a3) ? Integer.parseInt(a3) * IXAdIOUtils.BUFFER_SIZE : 0, equals);
                    } catch (NumberFormatException e) {
                        C4302b.m17649a("parseLong fail " + e.getMessage());
                    }
                }
            }
            if (c4481b.m18581a(KEYS.PLACEMENTS) != null) {
                try {
                    ah.m18136a().m18145a(C4379a.m17997b(Base64.decode(c4481b.m18581a(KEYS.PLACEMENTS), 8)));
                } catch (IllegalArgumentException e2) {
                    C4302b.m17649a("invalid Base64 exception + " + e2.getMessage());
                } catch (C3616c e3) {
                    C4302b.m17649a("invalid pb exception + " + e3.getMessage());
                }
            }
        }
    }
}
