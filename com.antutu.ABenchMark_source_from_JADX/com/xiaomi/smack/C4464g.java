package com.xiaomi.smack;

import com.qq.p035e.comm.constants.Constants.KEYS;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.C4461a.C4460a;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4481b;
import com.xiaomi.smack.packet.C4481b.C4480a;
import com.xiaomi.smack.util.C4493c;
import org.android.agoo.message.MessageService;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.g */
class C4464g {
    private Thread f15321a;
    private C4473l f15322b;
    private XmlPullParser f15323c;
    private boolean f15324d;

    protected C4464g(C4473l c4473l) {
        this.f15322b = c4473l;
        m18491a();
    }

    private void m18488a(C4468d c4468d) {
        if (c4468d != null) {
            for (C4460a a : this.f15322b.g.values()) {
                a.m18452a(c4468d);
            }
        }
    }

    private void m18489e() {
        this.f15323c = XmlPullParserFactory.newInstance().newPullParser();
        this.f15323c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        this.f15323c.setInput(this.f15322b.j);
    }

    private void m18490f() {
        try {
            m18489e();
            int eventType = this.f15323c.getEventType();
            String str = BuildConfig.FLAVOR;
            do {
                this.f15322b.m18483p();
                if (eventType == 2) {
                    String name = this.f15323c.getName();
                    if (this.f15323c.getName().equals(C4233j.f14376C)) {
                        m18488a(C4493c.m18636a(this.f15323c));
                        str = name;
                    } else if (this.f15323c.getName().equals("iq")) {
                        m18488a(C4493c.m18635a(this.f15323c, this.f15322b));
                        str = name;
                    } else if (this.f15323c.getName().equals("presence")) {
                        m18488a(C4493c.m18638b(this.f15323c));
                        str = name;
                    } else if (this.f15323c.getName().equals("stream")) {
                        str = BuildConfig.FLAVOR;
                        for (int i = 0; i < this.f15323c.getAttributeCount(); i++) {
                            if (this.f15323c.getAttributeName(i).equals("from")) {
                                this.f15322b.o.m18157a(this.f15323c.getAttributeValue(i));
                            } else if (this.f15323c.getAttributeName(i).equals("challenge")) {
                                str = this.f15323c.getAttributeValue(i);
                            } else if (KEYS.PLACEMENTS.equals(this.f15323c.getAttributeName(i))) {
                                String attributeValue = this.f15323c.getAttributeValue(i);
                                C4468d c4481b = new C4481b();
                                c4481b.m18518l(MessageService.MSG_DB_READY_REPORT);
                                c4481b.m18516k(MessageService.MSG_DB_READY_REPORT);
                                c4481b.m18583a(KEYS.PLACEMENTS, attributeValue);
                                c4481b.m18582a(C4480a.f15380b);
                                m18488a(c4481b);
                            }
                        }
                        this.f15322b.m18462a(str);
                        str = name;
                    } else if (this.f15323c.getName().equals(C4233j.f14375B)) {
                        throw new C4477p(C4493c.m18640d(this.f15323c));
                    } else {
                        if (this.f15323c.getName().equals("warning")) {
                            this.f15323c.next();
                            if (this.f15323c.getName().equals("multi-login")) {
                                m18492a(6, null);
                                str = name;
                            }
                        } else if (this.f15323c.getName().equals("bind")) {
                            m18488a(C4493c.m18639c(this.f15323c));
                            str = name;
                        }
                        str = name;
                    }
                } else if (eventType == 3 && this.f15323c.getName().equals("stream")) {
                    m18492a(13, null);
                }
                eventType = this.f15323c.next();
                if (this.f15324d) {
                    break;
                }
            } while (eventType != 1);
            if (eventType == 1) {
                throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + str + " host=" + this.f15322b.m18554c());
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
            if (this.f15324d) {
                C4302b.m17653c("reader is shutdown, ignore the exception.");
                return;
            }
            try {
                m18492a(9, e);
            } catch (Exception e2) {
            }
        }
    }

    protected void m18491a() {
        this.f15324d = false;
        this.f15321a = new C4465h(this, "Smack Packet Reader (" + this.f15322b.n + C4233j.f14397t);
    }

    void m18492a(int i, Exception exception) {
        this.f15324d = true;
        this.f15322b.m18545a(i, exception);
    }

    public void m18493b() {
        this.f15321a.start();
    }

    public void m18494c() {
        this.f15324d = true;
    }

    void m18495d() {
        this.f15322b.g.clear();
    }
}
