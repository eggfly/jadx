package com.igexin.push.p171a.p172a;

import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3849c;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.push.p169f.p170b.C3711d;
import com.igexin.push.p178e.C3900a;
import com.umeng.analytics.C4156a;
import java.util.Calendar;

/* renamed from: com.igexin.push.a.a.c */
public class C3714c implements C3711d {
    private static C3714c f12524c;
    private long f12525a;
    private long f12526b;
    private boolean f12527d;

    private C3714c() {
        this.f12525a = 0;
        this.f12526b = 0;
        this.f12527d = false;
    }

    public static C3714c m15218c() {
        if (f12524c == null) {
            f12524c = new C3714c();
        }
        return f12524c;
    }

    public void m15219a() {
        m15222d();
    }

    public void m15220a(long j) {
        this.f12525a = j;
    }

    public boolean m15221b() {
        return System.currentTimeMillis() - this.f12525a > this.f12526b;
    }

    public void m15222d() {
        this.f12526b = C4156a.f13949k;
        long currentTimeMillis = System.currentTimeMillis();
        if (C3754m.f12658b != 0) {
            Calendar instance = Calendar.getInstance();
            C3900a c3900a;
            if (C3777e.m15491a().m15528a(currentTimeMillis)) {
                if (!this.f12527d) {
                    this.f12527d = true;
                    c3900a = new C3900a();
                    c3900a.m16004a(C3849c.stop);
                    C3854f.m15859a().m15878h().m16038a(c3900a);
                }
                if (C3754m.f12657a + C3754m.f12658b > 24) {
                    instance.set(11, (C3754m.f12657a + C3754m.f12658b) - 24);
                } else {
                    instance.set(11, C3754m.f12657a + C3754m.f12658b);
                }
                instance.set(12, 0);
                instance.set(13, 0);
                if (instance.getTimeInMillis() < currentTimeMillis) {
                    instance.add(5, 1);
                }
            } else {
                if (this.f12527d) {
                    this.f12527d = false;
                    c3900a = new C3900a();
                    c3900a.m16004a(C3849c.start);
                    C3854f.m15859a().m15878h().m16038a(c3900a);
                }
                instance.set(11, C3754m.f12657a);
                instance.set(12, 0);
                instance.set(13, 0);
                if (instance.getTimeInMillis() < currentTimeMillis) {
                    instance.add(5, 1);
                }
            }
            this.f12526b = instance.getTimeInMillis() - currentTimeMillis;
        } else if (this.f12527d) {
            this.f12527d = false;
            C3900a c3900a2 = new C3900a();
            c3900a2.m16004a(C3849c.start);
            C3854f.m15859a().m15878h().m16038a(c3900a2);
        }
        if (C3754m.f12659c > this.f12526b + currentTimeMillis) {
            this.f12526b = C3754m.f12659c - currentTimeMillis;
            if (!this.f12527d) {
                this.f12527d = true;
                C3900a c3900a3 = new C3900a();
                c3900a3.m16004a(C3849c.stop);
                C3854f.m15859a().m15878h().m16038a(c3900a3);
            }
        }
    }
}
