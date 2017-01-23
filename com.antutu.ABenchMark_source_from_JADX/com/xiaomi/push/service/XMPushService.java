package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4303a;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.string.C4326a;
import com.xiaomi.channel.commonutils.string.C4328c;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C4371b;
import com.xiaomi.push.service.C4414d.C4384b;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.C4450y.C4449c;
import com.xiaomi.push.service.timers.C4441a;
import com.xiaomi.smack.C4336f;
import com.xiaomi.smack.C4338d;
import com.xiaomi.smack.C4403b;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.C4473l;
import com.xiaomi.smack.C4477p;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.packet.C4481b;
import com.xiaomi.smack.packet.C4482c;
import com.xiaomi.smack.packet.C4485f;
import com.xiaomi.smack.packet.C4485f.C4484b;
import com.xiaomi.smack.util.C4496g;
import com.xiaomi.stats.C4509f;
import com.xiaomi.stats.C4512h;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4518b;
import com.xiaomi.xmpush.thrift.C4532k;
import com.xiaomi.xmpush.thrift.C4542p;
import com.xiaomi.xmpush.thrift.C4548s;
import com.xiaomi.xmpush.thrift.C4550t;
import com.xiaomi.xmpush.thrift.ae;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;

public class XMPushService extends Service implements C4338d {
    public static int f14960a;
    private static final int f14961f;
    private C4403b f14962b;
    private af f14963c;
    private C4389d f14964d;
    private long f14965e;
    private C4473l f14966g;
    private C4461a f14967h;
    private C4407b f14968i;
    private PacketSync f14969j;
    private C4414d f14970k;
    private C4336f f14971l;

    /* renamed from: com.xiaomi.push.service.XMPushService.g */
    public static abstract class C4385g extends C4384b {
        public C4385g(int i) {
            super(i);
        }

        public abstract void m18019a();

        public abstract String m18020b();

        public void run() {
            if (!(this.a == 4 || this.a == 8)) {
                C4302b.m17649a("JOB: " + m18020b());
            }
            m18019a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.a */
    class C4386a extends C4385g {
        C4448b f14937b;
        final /* synthetic */ XMPushService f14938c;

        public C4386a(XMPushService xMPushService, C4448b c4448b) {
            this.f14938c = xMPushService;
            super(9);
            this.f14937b = null;
            this.f14937b = c4448b;
        }

        public void m18021a() {
            try {
                if (this.f14938c.m18101e()) {
                    C4448b b = C4450y.m18390a().m18398b(this.f14937b.f15176h, this.f14937b.f15170b);
                    if (b == null) {
                        C4302b.m17649a("ignore bind because the channel " + this.f14937b.f15176h + " is removed ");
                        return;
                    } else if (b.f15181m == C4449c.unbind) {
                        b.m18388a(C4449c.binding, 0, 0, null, null);
                        this.f14938c.f14967h.m18457a(b);
                        C4512h.m18710a(this.f14938c, b);
                        return;
                    } else {
                        C4302b.m17649a("trying duplicate bind, ingore! " + b.f15181m);
                        return;
                    }
                }
                C4302b.m17654d("trying bind while the connection is not created, quit!");
            } catch (Exception e) {
                C4302b.m17651a((Throwable) e);
                this.f14938c.m18079a(10, e);
            }
        }

        public String m18022b() {
            return "bind the client. " + this.f14937b.f15176h;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.b */
    static class C4387b extends C4385g {
        private final C4448b f14939b;

        public C4387b(C4448b c4448b) {
            super(12);
            this.f14939b = c4448b;
        }

        public void m18023a() {
            this.f14939b.m18388a(C4449c.unbind, 1, 21, null, null);
        }

        public String m18024b() {
            return "bind time out. chid=" + this.f14939b.f15176h;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof C4387b) ? false : TextUtils.equals(((C4387b) obj).f14939b.f15176h, this.f14939b.f15176h);
        }

        public int hashCode() {
            return this.f14939b.f15176h.hashCode();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.c */
    public class C4388c extends C4385g {
        final /* synthetic */ XMPushService f14940b;

        C4388c(XMPushService xMPushService) {
            this.f14940b = xMPushService;
            super(1);
        }

        public void m18025a() {
            if (this.f14940b.m18093a()) {
                this.f14940b.m18071o();
            } else {
                C4302b.m17649a("should not connect. quit the job.");
            }
        }

        public String m18026b() {
            return "do reconnect..";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.d */
    class C4389d extends BroadcastReceiver {
        final /* synthetic */ XMPushService f14941a;

        C4389d(XMPushService xMPushService) {
            this.f14941a = xMPushService;
        }

        public void onReceive(Context context, Intent intent) {
            this.f14941a.m18067k();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.e */
    public class C4390e extends C4385g {
        public int f14942b;
        public Exception f14943c;
        final /* synthetic */ XMPushService f14944d;

        C4390e(XMPushService xMPushService, int i, Exception exception) {
            this.f14944d = xMPushService;
            super(2);
            this.f14942b = i;
            this.f14943c = exception;
        }

        public void m18027a() {
            this.f14944d.m18079a(this.f14942b, this.f14943c);
        }

        public String m18028b() {
            return "disconnect the connection.";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.f */
    class C4391f extends C4385g {
        final /* synthetic */ XMPushService f14945b;
        private Intent f14946c;

        public C4391f(XMPushService xMPushService, Intent intent) {
            this.f14945b = xMPushService;
            super(15);
            this.f14946c = null;
            this.f14946c = intent;
        }

        public void m18029a() {
            this.f14945b.m18051a(this.f14946c);
        }

        public String m18030b() {
            return "Handle intent action = " + this.f14946c.getAction();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.h */
    class C4392h extends C4385g {
        final /* synthetic */ XMPushService f14947b;

        public C4392h(XMPushService xMPushService) {
            this.f14947b = xMPushService;
            super(5);
        }

        public void m18031a() {
            this.f14947b.f14970k.m18222b();
        }

        public String m18032b() {
            return "ask the job queue to quit";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.i */
    public class C4393i extends Binder {
        final /* synthetic */ XMPushService f14948a;

        public C4393i(XMPushService xMPushService) {
            this.f14948a = xMPushService;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.j */
    class C4394j extends C4385g {
        final /* synthetic */ XMPushService f14949b;
        private C4468d f14950c;

        public C4394j(XMPushService xMPushService, C4468d c4468d) {
            this.f14949b = xMPushService;
            super(8);
            this.f14950c = null;
            this.f14950c = c4468d;
        }

        public void m18033a() {
            this.f14949b.f14969j.m18017a(this.f14950c);
        }

        public String m18034b() {
            return "receive a message.";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.k */
    class C4395k extends C4385g {
        final /* synthetic */ XMPushService f14951b;

        public C4395k(XMPushService xMPushService) {
            this.f14951b = xMPushService;
            super(4);
        }

        public void m18035a() {
            if (this.f14951b.m18101e()) {
                try {
                    C4512h.m18705a();
                    this.f14951b.f14967h.m18481n();
                } catch (Exception e) {
                    C4302b.m17651a((Throwable) e);
                    this.f14951b.m18079a(10, e);
                }
            }
        }

        public String m18036b() {
            return "send ping..";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.l */
    class C4396l extends C4385g {
        C4448b f14952b;
        final /* synthetic */ XMPushService f14953c;

        public C4396l(XMPushService xMPushService, C4448b c4448b) {
            this.f14953c = xMPushService;
            super(4);
            this.f14952b = null;
            this.f14952b = c4448b;
        }

        public void m18037a() {
            try {
                this.f14952b.m18388a(C4449c.unbind, 1, 16, null, null);
                this.f14953c.f14967h.m18463a(this.f14952b.f15176h, this.f14952b.f15170b);
                this.f14952b.m18388a(C4449c.binding, 1, 16, null, null);
                this.f14953c.f14967h.m18457a(this.f14952b);
            } catch (Exception e) {
                C4302b.m17651a((Throwable) e);
                this.f14953c.m18079a(10, e);
            }
        }

        public String m18038b() {
            return "rebind the client. " + this.f14952b.f15176h;
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.m */
    class C4397m extends C4385g {
        final /* synthetic */ XMPushService f14954b;

        C4397m(XMPushService xMPushService) {
            this.f14954b = xMPushService;
            super(3);
        }

        public void m18039a() {
            this.f14954b.m18079a(11, null);
            if (this.f14954b.m18093a()) {
                this.f14954b.m18071o();
            }
        }

        public String m18040b() {
            return "reset the connection.";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService.n */
    class C4398n extends C4385g {
        C4448b f14955b;
        int f14956c;
        String f14957d;
        String f14958e;
        final /* synthetic */ XMPushService f14959f;

        public C4398n(XMPushService xMPushService, C4448b c4448b, int i, String str, String str2) {
            this.f14959f = xMPushService;
            super(9);
            this.f14955b = null;
            this.f14955b = c4448b;
            this.f14956c = i;
            this.f14957d = str;
            this.f14958e = str2;
        }

        public void m18041a() {
            if (!(this.f14955b.f15181m == C4449c.unbind || this.f14959f.f14967h == null)) {
                try {
                    this.f14959f.f14967h.m18463a(this.f14955b.f15176h, this.f14955b.f15170b);
                } catch (Exception e) {
                    C4302b.m17651a((Throwable) e);
                    this.f14959f.m18079a(10, e);
                }
            }
            this.f14955b.m18388a(C4449c.unbind, this.f14956c, 0, this.f14958e, this.f14957d);
        }

        public String m18042b() {
            return "unbind the channel. " + this.f14955b.f15176h;
        }
    }

    static {
        f14961f = Process.myPid();
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
        C4473l.a = true;
        f14960a = 1;
    }

    public XMPushService() {
        this.f14965e = 0;
        this.f14969j = null;
        this.f14970k = null;
        this.f14971l = new aj(this);
    }

    @TargetApi(11)
    public static Notification m18043a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (VERSION.SDK_INT >= 11) {
            Builder builder = new Builder(context);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentTitle("Push Service");
            builder.setContentText("Push Service");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            return builder.getNotification();
        }
        Notification notification = new Notification();
        notification.setLatestEventInfo(context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
        return notification;
    }

    public static C4482c m18046a(C4416f c4416f, Context context, C4542p c4542p) {
        try {
            C4482c c4482c = new C4482c();
            c4482c.m18518l("5");
            c4482c.m18520m("xiaomi.com");
            c4482c.m18522n(c4416f.f15074a);
            c4482c.m18594b(true);
            c4482c.m18602f("push");
            c4482c.m18524o(c4542p.f16046f);
            String str = c4416f.f15074a;
            c4542p.f16047g.f15873b = str.substring(0, str.indexOf("@"));
            c4542p.f16047g.f15875d = str.substring(str.indexOf("/") + 1);
            String valueOf = String.valueOf(C4326a.m17734a(ae.m18125a(ae.m18124a(c4416f.f15076c, c4482c.m18515k()), ae.m18793a(c4542p))));
            C4479a c4479a = new C4479a("s", null, (String[]) null, (String[]) null);
            c4479a.m18574b(valueOf);
            c4482c.m18511a(c4479a);
            C4302b.m17649a("try send mi push message. packagename:" + c4542p.f16046f + " action:" + c4542p.f16041a);
            return c4482c;
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return null;
        }
    }

    private C4482c m18047a(C4482c c4482c, String str) {
        byte[] a = ae.m18124a(str, c4482c.m18515k());
        C4482c c4482c2 = new C4482c();
        c4482c2.m18522n(c4482c.m18521n());
        c4482c2.m18520m(c4482c.m18519m());
        c4482c2.m18516k(c4482c.m18515k());
        c4482c2.m18518l(c4482c.m18517l());
        c4482c2.m18594b(true);
        String a2 = ae.m18120a(a, C4496g.m18652c(c4482c.m18588a()));
        C4479a c4479a = new C4479a("s", null, (String[]) null, (String[]) null);
        c4479a.m18574b(a2);
        c4482c2.m18511a(c4479a);
        return c4482c2;
    }

    private C4468d m18048a(C4468d c4468d, String str, String str2, boolean z) {
        C4450y a = C4450y.m18390a();
        List b = a.m18400b(str);
        if (b.isEmpty()) {
            C4302b.m17649a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            c4468d.m18524o(str);
            String l = c4468d.m18517l();
            if (TextUtils.isEmpty(l)) {
                l = (String) b.get(0);
                c4468d.m18518l(l);
            }
            C4448b b2 = a.m18398b(l, c4468d.m18521n());
            if (!m18101e()) {
                C4302b.m17649a("drop a packet as the channel is not connected, chid=" + l);
            } else if (b2 == null || b2.f15181m != C4449c.binded) {
                C4302b.m17649a("drop a packet as the channel is not opened, chid=" + l);
            } else if (TextUtils.equals(str2, b2.f15178j)) {
                return ((c4468d instanceof C4482c) && z) ? m18047a((C4482c) c4468d, b2.f15177i) : c4468d;
            } else {
                C4302b.m17649a("invalid session. " + str2);
            }
        }
        return null;
    }

    public static <T extends C4454a<T, ?>> C4542p m18049a(String str, String str2, T t, C4513a c4513a) {
        byte[] a = ae.m18793a(t);
        C4542p c4542p = new C4542p();
        C4532k c4532k = new C4532k();
        c4532k.f15872a = 5;
        c4532k.f15873b = "fakeid";
        c4542p.m19002a(c4532k);
        c4542p.m19004a(ByteBuffer.wrap(a));
        c4542p.m19000a(c4513a);
        c4542p.m19013c(true);
        c4542p.m19009b(str);
        c4542p.m19005a(false);
        c4542p.m19003a(str2);
        return c4542p;
    }

    private String m18050a(String str) {
        return "<iq id='0' chid='0' type='get'><ping>%1$s%2$s</ping></iq>";
    }

    private void m18051a(Intent intent) {
        C4448b c4448b = null;
        boolean z = true;
        boolean z2 = false;
        C4450y a = C4450y.m18390a();
        String stringExtra;
        if (aa.f14980d.equalsIgnoreCase(intent.getAction()) || aa.f14986j.equalsIgnoreCase(intent.getAction())) {
            stringExtra = intent.getStringExtra(aa.f14993q);
            if (TextUtils.isEmpty(intent.getStringExtra(aa.f14997u))) {
                C4302b.m17649a("security is empty. ignore.");
            } else if (stringExtra != null) {
                boolean a2 = m18054a(stringExtra, intent);
                C4448b b = m18055b(stringExtra, intent);
                if (!C4321d.m17709d(this)) {
                    this.f14968i.m18188a(this, b, false, 2, null);
                } else if (!m18101e()) {
                    m18090a(true);
                } else if (b.f15181m == C4449c.unbind) {
                    m18057c(new C4386a(this, b));
                } else if (a2) {
                    m18057c(new C4396l(this, b));
                } else if (b.f15181m == C4449c.binding) {
                    C4302b.m17649a(String.format("the client is binding. %1$s %2$s.", new Object[]{b.f15176h, b.f15170b}));
                } else if (b.f15181m == C4449c.binded) {
                    this.f14968i.m18188a(this, b, true, 0, null);
                }
            } else {
                C4302b.m17654d("channel id is empty, do nothing!");
            }
        } else if (aa.f14985i.equalsIgnoreCase(intent.getAction())) {
            stringExtra = intent.getStringExtra(aa.f15001y);
            r2 = intent.getStringExtra(aa.f14993q);
            Object stringExtra2 = intent.getStringExtra(aa.f14992p);
            C4302b.m17649a("Service called closechannel chid = " + r2 + " userId = " + stringExtra2);
            if (TextUtils.isEmpty(r2)) {
                for (String stringExtra3 : a.m18400b(stringExtra3)) {
                    m18053a(stringExtra3, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra2)) {
                m18053a(r2, 2);
            } else {
                m18088a(r2, stringExtra2, 2, null, null);
            }
        } else if (aa.f14981e.equalsIgnoreCase(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f15001y);
            r1 = intent.getStringExtra(aa.f14975B);
            Bundle bundleExtra = intent.getBundleExtra("ext_packet");
            C4468d a3 = m18048a(new C4482c(bundleExtra), stringExtra3, r1, intent.getBooleanExtra("ext_encrypt", true));
            if (a3 != null) {
                m18057c(new ag(this, a3));
            }
        } else if (aa.f14983g.equalsIgnoreCase(intent.getAction())) {
            r1 = intent.getStringExtra(aa.f15001y);
            r2 = intent.getStringExtra(aa.f14975B);
            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
            C4482c[] c4482cArr = new C4482c[parcelableArrayExtra.length];
            boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
            while (r3 < parcelableArrayExtra.length) {
                c4482cArr[r3] = new C4482c((Bundle) parcelableArrayExtra[r3]);
                c4482cArr[r3] = (C4482c) m18048a(c4482cArr[r3], r1, r2, booleanExtra);
                if (c4482cArr[r3] != null) {
                    r3++;
                } else {
                    return;
                }
            }
            m18057c(new C4399a(this, c4482cArr));
        } else if (aa.f14982f.equalsIgnoreCase(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f15001y);
            r1 = intent.getStringExtra(aa.f14975B);
            r4 = new C4481b(intent.getBundleExtra("ext_packet"));
            if (m18048a(r4, stringExtra3, r1, false) != null) {
                m18057c(new ag(this, r4));
            }
        } else if (aa.f14984h.equalsIgnoreCase(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f15001y);
            r1 = intent.getStringExtra(aa.f14975B);
            r4 = new C4485f(intent.getBundleExtra("ext_packet"));
            if (m18048a(r4, stringExtra3, r1, false) != null) {
                m18057c(new ag(this, r4));
            }
        } else if (aa.f14987k.equals(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f14993q);
            r1 = intent.getStringExtra(aa.f14992p);
            if (stringExtra3 != null) {
                C4302b.m17649a("request reset connection from chid = " + stringExtra3);
                C4448b b2 = C4450y.m18390a().m18398b(stringExtra3, r1);
                if (b2 != null && b2.f15177i.equals(intent.getStringExtra(aa.f14997u)) && b2.f15181m == C4449c.binded) {
                    C4461a g = m18103g();
                    if (g == null || !g.m18465a(System.currentTimeMillis() - 15000)) {
                        m18057c(new C4397m(this));
                    }
                }
            }
        } else if (aa.f14988l.equals(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f15001y);
            List b3 = a.m18400b(stringExtra3);
            if (b3.isEmpty()) {
                C4302b.m17649a("open channel should be called first before update info, pkg=" + stringExtra3);
                return;
            }
            stringExtra3 = intent.getStringExtra(aa.f14993q);
            Object stringExtra4 = intent.getStringExtra(aa.f14992p);
            if (TextUtils.isEmpty(stringExtra3)) {
                stringExtra3 = (String) b3.get(0);
            }
            if (TextUtils.isEmpty(stringExtra4)) {
                r0 = a.m18402c(stringExtra3);
                if (!(r0 == null || r0.isEmpty())) {
                    c4448b = (C4448b) r0.iterator().next();
                }
            } else {
                c4448b = a.m18398b(stringExtra3, stringExtra4);
            }
            if (c4448b != null) {
                if (intent.hasExtra(aa.f14999w)) {
                    c4448b.f15174f = intent.getStringExtra(aa.f14999w);
                }
                if (intent.hasExtra(aa.f15000x)) {
                    c4448b.f15175g = intent.getStringExtra(aa.f15000x);
                }
            }
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (ac.m18115a(getApplicationContext()).m18116a() && ac.m18115a(getApplicationContext()).m18117b() == 0) {
                C4302b.m17649a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            String stringExtra5 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra2 = intent.getBooleanExtra("mipush_env_chanage", false);
            r3 = intent.getIntExtra("mipush_env_type", 1);
            C4419h.m18239a((Context) this).m18242c(stringExtra5);
            if (!booleanExtra2 || "com.xiaomi.xmsf".equals(getPackageName())) {
                m18091a(byteArrayExtra, stringExtra5);
            } else {
                m18057c(new ap(this, 14, r3, byteArrayExtra, stringExtra5));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            r1 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            z2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            r0 = C4450y.m18390a().m18402c("5");
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                C4419h.m18239a((Context) this).m18241b(r1);
            }
            if (r0.isEmpty()) {
                if (z2) {
                    C4421j.m18250b(r1, byteArrayExtra2);
                }
            } else if (((C4448b) r0.iterator().next()).f15181m == C4449c.binded) {
                m18057c(new aq(this, 4, r1, byteArrayExtra2));
            } else if (z2) {
                C4421j.m18250b(r1, byteArrayExtra2);
            }
        } else if (ad.f15008a.equals(intent.getAction())) {
            stringExtra3 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra3 != null && !TextUtils.isEmpty(stringExtra3.trim())) {
                try {
                    getPackageManager().getPackageInfo(stringExtra3, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
                    z = false;
                } catch (NameNotFoundException e) {
                }
                if ("com.xiaomi.channel".equals(stringExtra3) && !C4450y.m18390a().m18402c(MessageService.MSG_DB_NOTIFY_REACHED).isEmpty() && r9) {
                    m18053a(MessageService.MSG_DB_NOTIFY_REACHED, 0);
                    C4302b.m17649a("close the miliao channel as the app is uninstalled.");
                    return;
                }
                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                r2 = sharedPreferences.getString(stringExtra3, null);
                if (!TextUtils.isEmpty(r2) && r9) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove(stringExtra3);
                    edit.commit();
                    if (C4436r.m18341e(this, stringExtra3)) {
                        C4436r.m18340d(this, stringExtra3);
                    }
                    C4436r.m18336b(this, stringExtra3);
                    if (m18101e() && r2 != null) {
                        try {
                            m18087a(m18077a(stringExtra3, r2));
                            C4302b.m17649a("uninstall " + stringExtra3 + " msg sent");
                        } catch (Exception e2) {
                            C4302b.m17654d("Fail to send Message: " + e2.getMessage());
                            m18079a(10, e2);
                        }
                    }
                }
            }
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            stringExtra3 = intent.getStringExtra(aa.f15001y);
            r1 = intent.getIntExtra(aa.f15002z, 0);
            if (!TextUtils.isEmpty(stringExtra3)) {
                if (r1 >= 0) {
                    C4436r.m18331a((Context) this, stringExtra3, r1);
                } else if (r1 == -1) {
                    C4436r.m18336b(this, stringExtra3);
                }
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            r2 = intent.getStringExtra(aa.f15001y);
            CharSequence stringExtra6 = intent.getStringExtra(aa.f14976C);
            CharSequence b4;
            if (intent.hasExtra(aa.f14974A)) {
                r1 = intent.getIntExtra(aa.f14974A, 0);
                b4 = C4328c.m17740b(r2 + r1);
            } else {
                b4 = C4328c.m17740b(r2);
                r1 = 0;
                z2 = true;
            }
            if (TextUtils.isEmpty(r2) || !TextUtils.equals(stringExtra6, r0)) {
                C4302b.m17654d("invalid notification for " + r2);
            } else if (z2) {
                C4436r.m18340d(this, r2);
            } else {
                C4436r.m18337b((Context) this, r2, r1);
            }
        }
    }

    private void m18053a(String str, int i) {
        Collection<C4448b> c = C4450y.m18390a().m18402c(str);
        if (c != null) {
            for (C4448b c4448b : c) {
                if (c4448b != null) {
                    m18080a(new C4398n(this, c4448b, i, null, null));
                }
            }
        }
        C4450y.m18390a().m18396a(str);
    }

    private boolean m18054a(String str, Intent intent) {
        C4448b b = C4450y.m18390a().m18398b(str, intent.getStringExtra(aa.f14992p));
        boolean z = false;
        if (b == null || str == null) {
            return false;
        }
        Object stringExtra = intent.getStringExtra(aa.f14975B);
        String stringExtra2 = intent.getStringExtra(aa.f14997u);
        if (!(TextUtils.isEmpty(b.f15178j) || TextUtils.equals(stringExtra, b.f15178j))) {
            C4302b.m17649a("session changed. old session=" + b.f15178j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(b.f15177i)) {
            return z;
        }
        C4302b.m17649a("security changed. chid = " + str + " sechash = " + C4328c.m17739a(stringExtra2));
        return true;
    }

    private C4448b m18055b(String str, Intent intent) {
        C4448b b = C4450y.m18390a().m18398b(str, intent.getStringExtra(aa.f14992p));
        if (b == null) {
            b = new C4448b(this);
        }
        b.f15176h = intent.getStringExtra(aa.f14993q);
        b.f15170b = intent.getStringExtra(aa.f14992p);
        b.f15171c = intent.getStringExtra(aa.f14995s);
        b.f15169a = intent.getStringExtra(aa.f15001y);
        b.f15174f = intent.getStringExtra(aa.f14999w);
        b.f15175g = intent.getStringExtra(aa.f15000x);
        b.f15173e = intent.getBooleanExtra(aa.f14998v, false);
        b.f15177i = intent.getStringExtra(aa.f14997u);
        b.f15178j = intent.getStringExtra(aa.f14975B);
        b.f15172d = intent.getStringExtra(aa.f14996t);
        b.f15179k = this.f14968i;
        b.f15180l = getApplicationContext();
        C4450y.m18390a().m18395a(b);
        return b;
    }

    private void m18057c(C4385g c4385g) {
        this.f14970k.m18219a((C4384b) c4385g);
    }

    private void m18066j() {
        if (C4418g.m18232a(getApplicationContext()) != null) {
            C4448b a = C4418g.m18232a(getApplicationContext()).m18229a(this);
            m18082a(a);
            C4450y.m18390a().m18395a(a);
            if (C4321d.m17709d(getApplicationContext())) {
                m18090a(true);
            }
        }
    }

    private void m18067k() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            C4302b.m17651a(e);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null) {
            C4302b.m17649a("network changed, " + activeNetworkInfo.toString());
        } else {
            C4302b.m17649a("network changed, no active network");
        }
        if (C4509f.m18694b() != null) {
            C4509f.m18694b().m18689b();
        }
        this.f14966g.m18485r();
        if (C4321d.m17709d(this)) {
            if (m18101e() && m18068l()) {
                m18069m();
            }
            if (!(m18101e() || m18102f())) {
                this.f14970k.m18223b(1);
                m18080a(new C4388c(this));
            }
            C4371b.m17957a((Context) this).m17965a();
        } else {
            m18080a(new C4390e(this, 2, null));
        }
        m18070n();
    }

    private boolean m18068l() {
        return System.currentTimeMillis() - this.f14965e < 30000 ? false : C4321d.m17710e(this);
    }

    private void m18069m() {
        this.f14965e = System.currentTimeMillis();
        if (this.f14970k.m18225d()) {
            C4302b.m17654d("ERROR, the job controller is blocked.");
            C4450y.m18390a().m18393a((Context) this, 14);
            stopSelf();
        } else if (!m18101e()) {
            m18090a(true);
        } else if (this.f14967h.m18484q() || C4321d.m17711f(this)) {
            m18080a(new C4395k(this));
        } else {
            m18080a(new C4390e(this, 17, null));
            m18090a(true);
        }
    }

    private void m18070n() {
        if (!m18093a()) {
            C4441a.m18355a();
        } else if (!C4441a.m18358b()) {
            C4441a.m18357a(true);
        }
    }

    private void m18071o() {
        if (this.f14967h != null && this.f14967h.m18475h()) {
            C4302b.m17654d("try to connect while connecting.");
        } else if (this.f14967h == null || !this.f14967h.m18476i()) {
            this.f14962b.m18160b(C4321d.m17712g(this));
            m18072p();
            if (this.f14967h == null) {
                C4450y.m18390a().m18392a((Context) this);
            }
            try {
                if (C4297i.m17629d()) {
                    sendBroadcast(this.f14967h == null ? new Intent("miui.intent.action.NETWORK_BLOCKED") : new Intent("miui.intent.action.NETWORK_CONNECTED"));
                }
            } catch (Throwable e) {
                C4302b.m17651a(e);
            }
        } else {
            C4302b.m17654d("try to connect while is connected.");
        }
    }

    private void m18072p() {
        try {
            this.f14966g.m18459a(this.f14971l, new at(this));
            this.f14966g.m18557t();
            this.f14967h = this.f14966g;
        } catch (Exception e) {
            C4302b.m17650a("fail to create xmpp connection", (Throwable) e);
            this.f14966g.m18548a(new C4485f(C4484b.unavailable), 3, e);
        }
    }

    private boolean m18073q() {
        return TextUtils.equals(getPackageName(), "com.xiaomi.xmsf") ? false : C4445v.m18368a((Context) this).m18375a(C4518b.ForegroundServiceSwitch.m18794a(), false);
    }

    private void m18074r() {
        if (VERSION.SDK_INT < 18) {
            startForeground(f14961f, new Notification());
        } else {
            bindService(new Intent(this, XMJobService.class), new al(this), 1);
        }
    }

    public C4473l m18075a(C4403b c4403b) {
        return new C4473l(this, c4403b);
    }

    public C4482c m18076a(byte[] bArr) {
        C4542p c4542p = new C4542p();
        try {
            ae.m18792a((C4454a) c4542p, bArr);
            return m18046a(C4418g.m18232a(this), (Context) this, c4542p);
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return null;
        }
    }

    public C4542p m18077a(String str, String str2) {
        C4454a c4548s = new C4548s();
        c4548s.m19057b(str2);
        c4548s.m19061c("app_uninstalled");
        c4548s.m19048a(C4468d.m18508j());
        c4548s.m19051a(false);
        return m18049a(str, str2, c4548s, C4513a.Notification);
    }

    public void m18078a(int i) {
        this.f14970k.m18223b(i);
    }

    public void m18079a(int i, Exception exception) {
        C4302b.m17649a("disconnect " + hashCode() + ", " + (this.f14967h == null ? null : Integer.valueOf(this.f14967h.hashCode())));
        if (this.f14967h != null) {
            this.f14967h.m18461a(new C4485f(C4484b.unavailable), i, exception);
            this.f14967h = null;
        }
        m18078a(7);
        m18078a(4);
        C4450y.m18390a().m18393a((Context) this, i);
    }

    public void m18080a(C4385g c4385g) {
        m18081a(c4385g, 0);
    }

    public void m18081a(C4385g c4385g, long j) {
        this.f14970k.m18220a((C4384b) c4385g, j);
    }

    public void m18082a(C4448b c4448b) {
        c4448b.m18387a(new ar(this));
    }

    public void m18083a(C4461a c4461a) {
        this.f14963c.m18130a();
        Iterator it = C4450y.m18390a().m18399b().iterator();
        while (it.hasNext()) {
            m18080a(new C4386a(this, (C4448b) it.next()));
        }
    }

    public void m18084a(C4461a c4461a, int i, Exception exception) {
        m18090a(false);
    }

    public void m18085a(C4461a c4461a, Exception exception) {
        m18090a(false);
    }

    public void m18086a(C4468d c4468d) {
        if (this.f14967h != null) {
            this.f14967h.m18460a(c4468d);
            return;
        }
        throw new C4477p("try send msg while connection is null.");
    }

    public void m18087a(C4542p c4542p) {
        if (this.f14967h != null) {
            C4468d a = m18046a(C4418g.m18232a(this), (Context) this, c4542p);
            if (a != null) {
                this.f14967h.m18460a(a);
                return;
            }
            return;
        }
        throw new C4477p("try send msg while connection is null.");
    }

    public void m18088a(String str, String str2, int i, String str3, String str4) {
        C4448b b = C4450y.m18390a().m18398b(str, str2);
        if (b != null) {
            m18080a(new C4398n(this, b, i, str4, str3));
        }
        C4450y.m18390a().m18397a(str, str2);
    }

    public void m18089a(String str, byte[] bArr) {
        if (this.f14967h != null) {
            C4468d a = m18076a(bArr);
            if (a != null) {
                this.f14967h.m18460a(a);
                return;
            } else {
                C4421j.m18246a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                return;
            }
        }
        throw new C4477p("try send msg while connection is null.");
    }

    public void m18090a(boolean z) {
        this.f14963c.m18131a(z);
    }

    public void m18091a(byte[] bArr, String str) {
        if (bArr == null) {
            C4421j.m18246a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            C4302b.m17649a("register request without payload");
            return;
        }
        C4454a c4542p = new C4542p();
        try {
            ae.m18792a(c4542p, bArr);
            if (c4542p.f16041a == C4513a.Registration) {
                C4454a c4550t = new C4550t();
                try {
                    ae.m18792a(c4550t, c4542p.m19018f());
                    C4421j.m18248a(c4542p.m19022j(), bArr);
                    m18080a(new C4420i(this, c4542p.m19022j(), c4550t.m19094d(), c4550t.m19103h(), bArr));
                    return;
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                    C4421j.m18246a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                    return;
                }
            }
            C4421j.m18246a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
            C4302b.m17649a("register request with invalid payload");
        } catch (Throwable e2) {
            C4302b.m17651a(e2);
            C4421j.m18246a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void m18092a(C4468d[] c4468dArr) {
        if (this.f14967h != null) {
            this.f14967h.m18464a(c4468dArr);
            return;
        }
        throw new C4477p("try send msg while connection is null.");
    }

    public boolean m18093a() {
        return C4321d.m17709d(this) && C4450y.m18390a().m18401c() > 0 && !m18097b();
    }

    public void m18094b(C4385g c4385g) {
        this.f14970k.m18218a(c4385g.a, (C4384b) c4385g);
    }

    public void m18095b(C4448b c4448b) {
        if (c4448b != null) {
            long a = c4448b.m18385a();
            C4302b.m17649a("schedule rebind job in " + (a / 1000));
            m18081a(new C4386a(this, c4448b), a);
        }
    }

    public void m18096b(C4461a c4461a) {
        C4302b.m17653c("begin to connect...");
    }

    public boolean m18097b() {
        try {
            Class cls = Class.forName("miui.os.Build");
            return cls.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean(null) || cls.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean(null);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean m18098b(int i) {
        return this.f14970k.m18221a(i);
    }

    public C4407b m18099c() {
        return new C4407b();
    }

    public C4407b m18100d() {
        return this.f14968i;
    }

    public boolean m18101e() {
        return this.f14967h != null && this.f14967h.m18476i();
    }

    public boolean m18102f() {
        return this.f14967h != null && this.f14967h.m18475h();
    }

    public C4461a m18103g() {
        return this.f14967h;
    }

    public void m18104h() {
        m18081a(new ak(this, 10), 15000);
    }

    public IBinder onBind(Intent intent) {
        return new C4393i(this);
    }

    public void onCreate() {
        super.onCreate();
        C4297i.m17625a(this);
        C4416f a = C4418g.m18232a(this);
        if (a != null) {
            C4303a.m17656a(a.f15080g);
        }
        ab.m18111a(this);
        this.f14962b = new am(this, null, 5222, "xiaomi.com", null);
        this.f14962b.m18158a(true);
        this.f14966g = m18075a(this.f14962b);
        this.f14966g.m18552b(m18050a("xiaomi.com"));
        Fallback fallback = new Fallback("mibind.chat.gslb.mi-idc.com");
        this.f14968i = m18099c();
        try {
            if (C4297i.m17629d()) {
                this.f14968i.m18185a((Context) this);
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
        C4441a.m18356a((Context) this);
        this.f14966g.m18458a((C4338d) this);
        this.f14969j = new PacketSync(this);
        this.f14963c = new af(this);
        new C4409c().m18191a();
        this.f14970k = new C4414d("Connection Controller Thread");
        m18080a(new an(this, 11));
        C4450y a2 = C4450y.m18390a();
        a2.m18404e();
        a2.m18394a(new ao(this));
        this.f14964d = new C4389d(this);
        registerReceiver(this.f14964d, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        if (m18073q()) {
            m18074r();
        }
        C4302b.m17649a("XMPushService created pid = " + f14961f);
    }

    public void onDestroy() {
        unregisterReceiver(this.f14964d);
        this.f14970k.m18224c();
        m18080a(new as(this, 2));
        m18080a(new C4392h(this));
        C4450y.m18390a().m18404e();
        C4450y.m18390a().m18393a((Context) this, 15);
        C4450y.m18390a().m18403d();
        this.f14966g.m18467b((C4338d) this);
        ah.m18136a().m18147b();
        C4441a.m18355a();
        super.onDestroy();
        C4302b.m17649a("Service destroyed");
    }

    public void onStart(Intent intent, int i) {
        if (intent == null) {
            C4302b.m17654d("onStart() with intent NULL");
        } else {
            C4302b.m17653c(String.format("onStart() with intent.Action = %s, chid = %s", new Object[]{intent.getAction(), intent.getStringExtra(aa.f14993q)}));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                C4302b.m17649a("Service called on timer");
                m18069m();
            } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                C4302b.m17649a("Service called on check alive.");
                if (m18068l()) {
                    m18069m();
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                m18080a(new C4391f(this, intent));
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return f14960a;
    }
}
