package com.igexin.push.p178e;

import android.content.Context;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3849c;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.C3857i;
import com.igexin.push.core.C3859k;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p170b.C3921g;
import com.igexin.push.p174c.C3722a;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.p182d.C3899h;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3877a;
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
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.e.j */
public class C3909j {
    private static String f13156a;
    private C3685c f13157b;
    private C3776k f13158c;
    private boolean f13159d;
    private long f13160e;
    private long f13161f;
    private boolean f13162g;

    static {
        f13156a = C3909j.class.getName();
    }

    public C3909j() {
        this.f13160e = 0;
        this.f13161f = 0;
    }

    private String m16055b(C3876e c3876e) {
        String str = BuildConfig.FLAVOR;
        if (c3876e instanceof C3881f) {
            return "R-" + ((C3881f) c3876e).m15967a();
        }
        if (c3876e instanceof C3892q) {
            return "R-" + ((C3892q) c3876e).f13121b;
        }
        if (c3876e instanceof C3886k) {
            return "S-" + String.valueOf(((C3886k) c3876e).f13093a);
        }
        if (c3876e instanceof C3888m) {
            if (((C3888m) c3876e).f13104e != 0) {
                return "S-" + String.valueOf(((C3888m) c3876e).f13104e);
            }
        } else if (c3876e instanceof C3889n) {
            return "S-" + String.valueOf(((C3889n) c3876e).f13105a);
        } else {
            if (c3876e instanceof C3890o) {
                return "S-" + String.valueOf(((C3890o) c3876e).f13110e);
            }
            if (c3876e instanceof C3880d) {
                return "C-" + ((C3880d) c3876e).f13064g;
            }
            if (c3876e instanceof C3891p) {
                return "C-" + ((C3891p) c3876e).f13118g;
            }
            if (c3876e instanceof C3877a) {
                return "C-" + ((C3877a) c3876e).f13040d;
            }
            if (c3876e instanceof C3879c) {
                return "C-" + ((C3879c) c3876e).f13054d;
            }
        }
        return str;
    }

    private boolean m16056c() {
        if (C3754m.f12670n && this.f13160e + this.f13161f >= C3754m.f12671o) {
            C3900a c3900a = new C3900a();
            c3900a.m16004a(C3849c.check);
            C3854f.m15859a().m15878h().m16038a(c3900a);
        }
        return false;
    }

    public int m16057a(String str, C3876e c3876e) {
        return m16058a(str, c3876e, false);
    }

    public int m16058a(String str, C3876e c3876e, boolean z) {
        if (str == null || c3876e == null) {
            return -1;
        }
        if (!C3855g.f12976n && !(c3876e instanceof C3884i) && !(c3876e instanceof C3886k) && !(c3876e instanceof C3881f)) {
            C3688a.m15095a("snl|sendData|not online|" + c3876e.getClass().getName());
            return -3;
        } else if (!this.f13159d) {
            return C3854f.m15859a().m15878h().m16033a(str, c3876e);
        } else {
            if (z) {
                int i = 10;
                if (C3754m.f12661e > 0) {
                    i = C3754m.f12661e;
                }
                if (this.f13157b.m15065a(SDKUrlConfig.getCmAddress(), 3, C3854f.m15859a().m15876f(), c3876e, true, i, new C3899h()) == null) {
                    return -2;
                }
            } else if (this.f13157b.m15062a(SDKUrlConfig.getCmAddress(), 3, C3854f.m15859a().m15876f(), c3876e, true) == null) {
                return -2;
            }
            byte[] d = c3876e.m15948d();
            if (d != null) {
                this.f13161f = (((long) d.length) + 8) + this.f13161f;
            } else {
                this.f13161f += 8;
            }
            m16056c();
            return 0;
        }
    }

    public void m16059a(Context context, C3685c c3685c, C3776k c3776k) {
        this.f13157b = c3685c;
        this.f13158c = c3776k;
    }

    public void m16060a(C3876e c3876e) {
        if (c3876e != null) {
            if (this.f13159d) {
                String b = m16055b(c3876e);
                if (!b.equals("S-") && !b.equals("R-")) {
                    if (b.length() > 0 && !b.equals("C-") && !b.equals("C-" + C3855g.f12982t) && !b.equals("R-" + C3855g.f12938B) && !b.equals("S-" + C3855g.f12981s)) {
                        C3854f.m15859a().m15878h().m16040b(b, c3876e);
                    } else if (this.f13158c != null) {
                        this.f13158c.m15486a(c3876e);
                    }
                    byte[] d = c3876e.m15948d();
                    if (d != null) {
                        this.f13160e = (((long) d.length) + 8) + this.f13160e;
                    } else {
                        this.f13160e += 8;
                    }
                    m16056c();
                }
            } else if (this.f13158c != null) {
                this.f13158c.m15486a(c3876e);
            }
        }
    }

    public void m16061a(boolean z) {
        if (this.f13159d != z) {
            this.f13159d = z;
            this.f13162g = false;
            if (z) {
                this.f13161f = 0;
                this.f13160e = 0;
                C3777e.m15491a().m15553d(true);
                return;
            }
            C3688a.m15097b(f13156a + "|setASNL() , isASNL = false, this.isASNL != isASNL, disconnect tcp !!!");
            C3777e.m15491a().m15557f();
        }
    }

    public boolean m16062a() {
        return this.f13159d;
    }

    public void m16063b() {
        C3855g.f12941E = 0;
        if (!this.f13159d && this.f13158c != null) {
            this.f13158c.m15487b();
        }
    }

    public void m16064b(boolean z) {
        C3722a e = C3730i.m15273a().m15277e();
        if (z) {
            e.m15267i();
            C3688a.m15097b(f13156a + "|disconnected by user ####");
            if (C3855g.f12976n) {
                C3855g.f12976n = false;
                C3777e.m15491a().m15564m();
            }
        } else {
            C3688a.m15097b(f13156a + "|disconnected by network ####");
            C3857i.m15894a().m15899a(C3859k.NETWORK_ERROR);
            e.m15267i();
            if (C3855g.f12976n) {
                C3855g.f12976n = false;
                C3777e.m15491a().m15564m();
            }
            C3688a.m15097b("SNL autoReconnect notifyNetworkDisconnected");
            C3777e.m15491a().m15553d(true);
        }
        if (this.f13159d) {
            C3854f.m15859a().m15878h().m16042b();
        } else if (this.f13158c != null) {
            this.f13158c.m15485a(z);
        }
    }

    public void m16065c(boolean z) {
        C3855g.f12941E = C3875b.m15932a().m15939c().m15998a(z);
        C3730i.m15273a().m15277e().m15261c();
        C3921g.m16131g().m16136h();
    }
}
