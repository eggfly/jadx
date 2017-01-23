package com.xiaomi.smack;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.service.ah;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.util.C4496g;
import com.xiaomi.smack.util.C4500j;
import java.io.Writer;
import java.util.Locale;

/* renamed from: com.xiaomi.smack.i */
class C4466i {
    private Writer f15326a;
    private C4473l f15327b;

    protected C4466i(C4473l c4473l) {
        this.f15327b = c4473l;
        this.f15326a = c4473l.k;
    }

    private void m18496b(C4468d c4468d) {
        synchronized (this.f15326a) {
            try {
                String a = c4468d.m18510a();
                this.f15326a.write(a + "\r\n");
                this.f15326a.flush();
                Object o = c4468d.m18523o();
                if (!TextUtils.isEmpty(o)) {
                    C4500j.m18663a(this.f15327b.p, o, (long) C4500j.m18659a(a), false, System.currentTimeMillis());
                }
            } catch (Throwable e) {
                throw new C4477p(e);
            }
        }
    }

    void m18497a() {
        this.f15327b.h.clear();
    }

    public void m18498a(C4468d c4468d) {
        m18496b(c4468d);
        this.f15327b.m18469b(c4468d);
    }

    public void m18499b() {
        synchronized (this.f15326a) {
            this.f15326a.write("</stream:stream>");
            this.f15326a.flush();
        }
    }

    void m18500c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<stream:stream");
        stringBuilder.append(" xmlns=\"xm\"");
        stringBuilder.append(" xmlns:stream=\"xm\"");
        stringBuilder.append(" to=\"").append(this.f15327b.m18466b()).append("\"");
        stringBuilder.append(" version=\"105\"");
        stringBuilder.append(" model=\"").append(C4496g.m18647a(Build.MODEL)).append("\"");
        stringBuilder.append(" os=\"").append(C4496g.m18647a(VERSION.INCREMENTAL)).append("\"");
        Object e = ah.m18140e();
        if (!TextUtils.isEmpty(e)) {
            stringBuilder.append(" uid=\"").append(e).append("\"");
        }
        stringBuilder.append(" sdk=\"").append(21).append("\"");
        stringBuilder.append(" connpt=\"").append(C4496g.m18647a(this.f15327b.m18471d())).append("\"");
        stringBuilder.append(" host=\"").append(this.f15327b.m18554c()).append("\"");
        stringBuilder.append(" locale=\"").append(C4496g.m18647a(Locale.getDefault().toString())).append("\"");
        byte[] a = this.f15327b.m18455a().m18159a();
        if (a != null) {
            stringBuilder.append(" ps=\"").append(Base64.encodeToString(a, 10)).append("\"");
        }
        stringBuilder.append(">");
        this.f15326a.write(stringBuilder.toString());
        this.f15326a.flush();
    }

    public void m18501d() {
        synchronized (this.f15326a) {
            try {
                this.f15326a.write(this.f15327b.m18558u() + "\r\n");
                this.f15326a.flush();
                this.f15327b.m18560w();
            } catch (Throwable e) {
                throw new C4477p(e);
            }
        }
    }
}
