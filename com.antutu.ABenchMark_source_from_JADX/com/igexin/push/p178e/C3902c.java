package com.igexin.push.p178e;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3849c;
import com.igexin.push.core.C3852d;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.C3866q;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p170b.C3732h;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3877a;
import com.igexin.push.p182d.p185c.C3878b;
import com.igexin.push.p182d.p185c.C3879c;
import com.igexin.push.p182d.p185c.C3880d;
import com.igexin.push.p182d.p185c.C3881f;
import com.igexin.push.p182d.p185c.C3884i;
import com.igexin.push.p182d.p185c.C3886k;
import com.igexin.push.p182d.p185c.C3888m;
import com.igexin.push.p182d.p185c.C3889n;
import com.igexin.push.p182d.p185c.C3890o;
import com.igexin.push.p182d.p185c.C3891p;
import com.igexin.push.p182d.p185c.C3892q;
import com.igexin.push.util.C3922a;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushService;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.e.c */
public class C3902c {
    private Context f13134a;
    private C3852d f13135b;
    private C3732h f13136c;
    private C3732h f13137d;
    private C3901b f13138e;
    private List f13139f;
    private Map f13140g;
    private Map f13141h;
    private boolean f13142i;

    private C3876e m16015a(byte[] bArr) {
        C3878b b = m16019b(bArr);
        C3876e c3876e = null;
        switch (b.f13045b) {
            case SpdyProtocol.QUIC /*4*/:
                c3876e = new C3886k();
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                c3876e = new C3888m();
                break;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                c3876e = new C3881f();
                break;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                c3876e = new C3892q();
                break;
            case C2279R.styleable.ActionBar_popupTheme /*25*/:
                c3876e = new C3880d();
                break;
            case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                c3876e = new C3891p();
                break;
            case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                c3876e = new C3879c();
                break;
            case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                c3876e = new C3877a();
                break;
            case jni.SID_UX_GAME /*36*/:
                c3876e = new C3889n();
                break;
            case jni.SID_UX_IMG /*37*/:
                c3876e = new C3890o();
                break;
            case C1692R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                c3876e = new C3884i();
                break;
        }
        if (c3876e != null) {
            c3876e.m15946a(b.f13048e);
        }
        return c3876e;
    }

    private C3878b m16019b(byte[] bArr) {
        C3878b c3878b = new C3878b();
        c3878b.f13044a = C3687f.m15089c(bArr, 0);
        c3878b.f13045b = bArr[2];
        c3878b.f13048e = new byte[c3878b.f13044a];
        C3687f.m15077a(bArr, 3, c3878b.f13048e, 0, c3878b.f13044a);
        return c3878b;
    }

    private void m16020b(C3900a c3900a) {
        switch (C3907h.f13150b[c3900a.f13128a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f13139f.clear();
                this.f13140g.clear();
                this.f13141h.clear();
                if (this.f13136c != null) {
                    this.f13136c.m14970t();
                }
                if (this.f13137d != null) {
                    this.f13137d.m14970t();
                }
                this.f13142i = false;
                boolean z = C3855g.f12972j;
                boolean z2 = C3855g.f12973k;
                boolean a = C3777e.m15491a().m15528a(System.currentTimeMillis());
                boolean b = C3922a.m16145b();
                if (!z || !z2 || a || !b) {
                    return;
                }
                if (C3754m.f12670n) {
                    Intent intent = new Intent();
                    intent.setAction("com.igexin.sdk.action.snlrefresh");
                    intent.putExtra("groupid", C3855g.f12966d);
                    intent.putExtra("branch", PushBuildConfig.sdk_conf_channelid);
                    intent.putExtra("responseSNLAction", C3855g.f12958V);
                    this.f13134a.sendBroadcast(intent);
                    this.f13136c = new C3903d(this, 1000);
                    if (!C3854f.m15859a().m15868a(this.f13136c)) {
                        return;
                    }
                    return;
                }
                m16026d();
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                int size = this.f13139f.size();
                if (size == 0) {
                    m16026d();
                    return;
                }
                int i = 1;
                C3908i c3908i = (C3908i) this.f13139f.get(0);
                while (i < size) {
                    C3908i c3908i2 = (C3908i) this.f13139f.get(i);
                    if (c3908i2.m16053c() >= c3908i.m16053c()) {
                        c3908i2 = c3908i;
                    }
                    i++;
                    c3908i = c3908i2;
                }
                if (this.f13134a.getPackageName().equals(c3908i.m16047a())) {
                    m16026d();
                    return;
                }
                this.f13135b = C3852d.prepare;
                this.f13138e = new C3901b();
                this.f13138e.m16008a(c3908i.m16047a());
                this.f13138e.m16010b(c3908i.m16050b());
                C3900a c3900a2 = new C3900a();
                c3900a2.m16004a(C3849c.determine);
                m16038a(c3900a2);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
                if (this.f13136c != null) {
                    this.f13136c.m14970t();
                }
                m16024c();
            default:
        }
    }

    private void m16021b(String str) {
        C3901b c3901b = (C3901b) this.f13140g.get(str);
        c3901b.m16006a(new C3906g(this, c3901b, str));
        try {
            Context createPackageContext = this.f13134a.createPackageContext(c3901b.m16005a(), 3);
            this.f13134a.bindService(new Intent(createPackageContext, createPackageContext.getClassLoader().loadClass(c3901b.m16009b())), c3901b.m16013d(), 0);
        } catch (Exception e) {
        }
        this.f13140g.put(str, c3901b);
    }

    private List m16023c(String str) {
        List arrayList = new ArrayList();
        for (Entry entry : this.f13141h.entrySet()) {
            if (((C3901b) entry.getValue()).m16014e().equals(str)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    private void m16024c() {
        this.f13135b = C3852d.init;
        C3900a c3900a = new C3900a();
        c3900a.m16004a(C3849c.start);
        m16038a(c3900a);
    }

    private void m16025c(C3900a c3900a) {
        switch (C3907h.f13150b[c3900a.f13128a.ordinal()]) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
                if (this.f13137d != null) {
                    this.f13137d.m14970t();
                }
                if (this.f13138e.m16011c() != null) {
                    try {
                        this.f13134a.unbindService(this.f13138e.m16013d());
                    } catch (Exception e) {
                    }
                }
                m16024c();
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                this.f13137d = new C3904e(this, 5000);
                if (C3854f.m15859a().m15868a(this.f13137d)) {
                    this.f13138e.m16006a(new C3905f(this));
                } else {
                    this.f13138e.m16006a(new C3905f(this));
                }
                try {
                    Context createPackageContext = this.f13134a.createPackageContext(this.f13138e.m16005a(), 3);
                    this.f13134a.bindService(new Intent(createPackageContext, createPackageContext.getClassLoader().loadClass(this.f13138e.m16009b())), this.f13138e.m16013d(), 0);
                } catch (Exception e2) {
                }
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                try {
                    this.f13138e.m16011c().onPSNLConnected(this.f13134a.getPackageName(), PushService.class.getName(), BuildConfig.FLAVOR, 0);
                } catch (Exception e3) {
                }
            default:
        }
    }

    private void m16026d() {
        this.f13139f.clear();
        this.f13135b = C3852d.active;
        if (this.f13142i) {
            for (Entry key : this.f13140g.entrySet()) {
                m16021b((String) key.getKey());
            }
            this.f13142i = false;
        }
        C3854f.m15859a().m15877g().m16061a(true);
    }

    private void m16027d(C3900a c3900a) {
        Intent intent;
        switch (C3907h.f13150b[c3900a.f13128a.ordinal()]) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                C3688a.m15097b("SNLCoordinator|event = stop, setASNL(false)");
                C3854f.m15859a().m15877g().m16061a(false);
                C3854f.m15859a().m15877g().m16064b(true);
                if (C3754m.f12670n) {
                    intent = new Intent();
                    intent.setAction("com.igexin.sdk.action.snlretire");
                    intent.putExtra("groupid", C3855g.f12966d);
                    intent.putExtra("branch", PushBuildConfig.sdk_conf_channelid);
                    this.f13134a.sendBroadcast(intent);
                    return;
                }
                C3900a c3900a2 = new C3900a();
                c3900a2.m16004a(C3849c.retire);
                C3854f.m15859a().m15878h().m16038a(c3900a2);
            case SpdyProtocol.QUIC /*4*/:
                C3855g.f12957U = System.currentTimeMillis();
                for (Entry value : this.f13140g.entrySet()) {
                    try {
                        this.f13134a.unbindService(((C3901b) value.getValue()).m16013d());
                    } catch (Exception e) {
                    }
                }
                C3688a.m15097b("SNLCoordinator | state = " + C3852d.passive + ", setASNL(false)");
                C3854f.m15859a().m15877g().m16061a(false);
                m16024c();
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                intent = new Intent();
                intent.setAction("com.igexin.sdk.action.snlretire");
                intent.putExtra("groupid", C3855g.f12966d);
                intent.putExtra("branch", PushBuildConfig.sdk_conf_channelid);
                this.f13134a.sendBroadcast(intent);
            default:
        }
    }

    private void m16030e(C3900a c3900a) {
        switch (C3907h.f13150b[c3900a.f13128a.ordinal()]) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (C3855g.f12976n) {
                    C3876e c3889n = new C3889n();
                    c3889n.f13105a = C3855g.f12981s;
                    C3854f.m15859a().m15877g().m16058a("S-" + String.valueOf(C3855g.f12981s), c3889n, true);
                    break;
                }
                break;
            case SpdyProtocol.QUIC /*4*/:
                break;
            default:
                return;
        }
        C3855g.f12957U = System.currentTimeMillis();
        C3854f.m15859a().m15877g().m16064b(true);
        try {
            this.f13134a.unbindService(this.f13138e.m16013d());
        } catch (Exception e) {
        }
        m16024c();
    }

    public int m16032a(String str) {
        if (this.f13135b != C3852d.prepare || str.equals(BuildConfig.FLAVOR)) {
            return -1;
        }
        this.f13137d.m14970t();
        this.f13140g.clear();
        this.f13141h.clear();
        this.f13142i = false;
        this.f13139f.clear();
        this.f13138e.m16012c(str);
        this.f13135b = C3852d.passive;
        C3688a.m15097b("SNLCoordinator | state = " + C3852d.passive + ", setASNL(false)");
        C3854f.m15859a().m15877g().m16061a(false);
        return 0;
    }

    public int m16033a(String str, C3876e c3876e) {
        C3878b c3878b = new C3878b();
        c3878b.f13048e = c3876e.m15948d();
        if (c3878b.f13048e != null) {
            c3878b.f13044a = c3878b.f13048e.length;
            c3878b.f13045b = (byte) c3876e.f13034i;
            byte[] a = c3878b.m15956a();
            if (!(this.f13138e == null || this.f13138e.m16011c() == null)) {
                try {
                    return this.f13138e.m16011c().sendByASNL(this.f13138e.m16014e(), str, a);
                } catch (Exception e) {
                    m16024c();
                }
            }
        }
        return -1;
    }

    public int m16034a(String str, String str2) {
        if (this.f13135b == C3852d.prepare || this.f13135b == C3852d.passive) {
            return -1;
        }
        C3901b c3901b = new C3901b();
        c3901b.m16008a(str);
        c3901b.m16010b(str2);
        c3901b.m16012c(str);
        this.f13140g.put(str, c3901b);
        if (this.f13135b == C3852d.active) {
            m16021b(str);
        } else {
            this.f13142i = true;
        }
        return 0;
    }

    public int m16035a(String str, String str2, byte[] bArr) {
        C3876e a = m16015a(bArr);
        C3901b c3901b = (C3901b) this.f13140g.get(str);
        if (c3901b == null || !C3855g.f12976n) {
            return -1;
        }
        this.f13141h.put(str2, c3901b);
        return C3854f.m15859a().m15877g().m16057a(str2, a);
    }

    public void m16036a(Context context) {
        this.f13134a = context;
        this.f13135b = C3852d.init;
        this.f13139f = new ArrayList();
        this.f13140g = new HashMap();
        this.f13141h = new HashMap();
    }

    public void m16037a(Intent intent) {
        String stringExtra;
        String stringExtra2;
        if (intent.getAction().equals("com.igexin.sdk.action.snlrefresh") && C3754m.f12670n) {
            stringExtra = intent.getStringExtra("groupid");
            stringExtra2 = intent.getStringExtra("responseSNLAction");
            boolean z = C3855g.f12972j;
            boolean z2 = C3855g.f12973k;
            String stringExtra3 = intent.getStringExtra("branch");
            boolean a = C3777e.m15491a().m15528a(System.currentTimeMillis());
            long a2 = C3866q.m15909a() + C3866q.m15910b();
            if (C3855g.f12966d.equals(stringExtra) && PushBuildConfig.sdk_conf_channelid.equals(stringExtra3) && z && z2 && !a) {
                Intent intent2 = new Intent();
                intent2.setAction(stringExtra2);
                intent2.putExtra("groupid", C3855g.f12966d);
                intent2.putExtra("branch", PushBuildConfig.sdk_conf_channelid);
                intent2.putExtra("pkgname", C3855g.f12969g.getPackageName());
                intent2.putExtra("classname", PushService.class.getName());
                intent2.putExtra("startup_time", C3855g.f12957U);
                intent2.putExtra("network_traffic", a2);
                C3855g.f12969g.sendBroadcast(intent2);
            }
        } else if (intent.getAction().equals(C3855g.f12958V) && C3754m.f12670n) {
            stringExtra = intent.getStringExtra("groupid");
            stringExtra2 = intent.getStringExtra("branch");
            if (C3855g.f12966d.equals(stringExtra) && PushBuildConfig.sdk_conf_channelid.equals(stringExtra2)) {
                C3908i c3908i = new C3908i();
                c3908i.m16049a(intent.getStringExtra("groupid"));
                c3908i.m16052b(intent.getStringExtra("pkgname"));
                c3908i.m16054c(intent.getStringExtra("classname"));
                c3908i.m16048a(intent.getLongExtra("startup_time", 0));
                c3908i.m16051b(intent.getLongExtra("network_traffic", 0));
                this.f13139f.add(c3908i);
            }
        } else if (intent.getAction().equals("com.igexin.sdk.action.snlretire") && C3754m.f12670n) {
            stringExtra = intent.getStringExtra("groupid");
            stringExtra2 = intent.getStringExtra("branch");
            if (C3855g.f12966d.equals(stringExtra) && PushBuildConfig.sdk_conf_channelid.equals(stringExtra2)) {
                C3900a c3900a = new C3900a();
                c3900a.m16004a(C3849c.retire);
                C3854f.m15859a().m15878h().m16038a(c3900a);
            }
        }
    }

    public void m16038a(C3900a c3900a) {
        switch (C3907h.f13149a[this.f13135b.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m16020b(c3900a);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m16025c(c3900a);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m16027d(c3900a);
            case SpdyProtocol.QUIC /*4*/:
                m16030e(c3900a);
            default:
        }
    }

    public boolean m16039a() {
        if (this.f13135b != C3852d.active) {
            return false;
        }
        for (Entry value : this.f13140g.entrySet()) {
            try {
                ((C3901b) value.getValue()).m16011c().onASNLNetworkConnected();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public int m16040b(String str, C3876e c3876e) {
        C3878b c3878b = new C3878b();
        c3878b.f13048e = c3876e.m15948d();
        c3878b.f13044a = c3878b.f13048e.length;
        c3878b.f13045b = (byte) c3876e.f13034i;
        byte[] a = c3878b.m15956a();
        C3901b c3901b = (C3901b) this.f13141h.get(str);
        if (c3901b != null) {
            try {
                if (str.startsWith("S-")) {
                    this.f13141h.put("C-" + C3700a.m15132a(str.substring(2, str.length())), c3901b);
                }
                return c3901b.m16011c().receiveToPSNL(c3901b.m16014e(), str, a);
            } catch (RemoteException e) {
                this.f13140g.remove(c3901b.m16014e());
                this.f13141h.remove(str);
            }
        }
        return -1;
    }

    public int m16041b(String str, String str2, byte[] bArr) {
        C3854f.m15859a().m15877g().m16060a(m16015a(bArr));
        return 0;
    }

    public boolean m16042b() {
        if (this.f13135b != C3852d.active) {
            return false;
        }
        for (Entry value : this.f13140g.entrySet()) {
            try {
                ((C3901b) value.getValue()).m16011c().onASNLNetworkDisconnected();
            } catch (Exception e) {
            }
        }
        return true;
    }
}
