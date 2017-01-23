package com.xiaomi.smack;

import android.text.TextUtils;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4327b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4478e;
import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.packet.C4488h;
import com.xiaomi.smack.util.C4496g;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: com.xiaomi.smack.k */
public class C4472k {

    /* renamed from: com.xiaomi.smack.k.a */
    public static class C4469a extends C4468d {
        public C4469a(C4448b c4448b, String str, C4461a c4461a) {
            Object obj;
            Map hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put(Constants.EXTRA_KEY_TOKEN, c4448b.f15171c);
            hashMap.put("chid", c4448b.f15176h);
            hashMap.put("from", c4448b.f15170b);
            hashMap.put(AgooConstants.MESSAGE_ID, m18515k());
            hashMap.put("to", "xiaomi.com");
            if (c4448b.f15173e) {
                hashMap.put("kick", MessageService.MSG_DB_NOTIFY_REACHED);
            } else {
                hashMap.put("kick", MessageService.MSG_DB_READY_REPORT);
            }
            if (c4461a == null || c4461a.m18479l() <= 0) {
                obj = null;
            } else {
                String format = String.format("conn:%1$d,t:%2$d", new Object[]{Integer.valueOf(c4461a.m18477j()), Long.valueOf(c4461a.m18479l())});
                hashMap.put("pf", format);
                c4461a.m18478k();
                c4461a.m18480m();
                obj = format;
            }
            if (TextUtils.isEmpty(c4448b.f15174f)) {
                hashMap.put("client_attrs", BuildConfig.FLAVOR);
            } else {
                hashMap.put("client_attrs", c4448b.f15174f);
            }
            if (TextUtils.isEmpty(c4448b.f15175g)) {
                hashMap.put("cloud_attrs", BuildConfig.FLAVOR);
            } else {
                hashMap.put("cloud_attrs", c4448b.f15175g);
            }
            String a = (c4448b.f15172d.equals("XIAOMI-PASS") || c4448b.f15172d.equals("XMPUSH-PASS")) ? C4327b.m17737a(c4448b.f15172d, null, hashMap, c4448b.f15177i) : c4448b.f15172d.equals("XIAOMI-SASL") ? null : null;
            m18518l(c4448b.f15176h);
            m18522n(c4448b.f15170b);
            m18520m("xiaomi.com");
            m18524o(c4448b.f15169a);
            C4479a c4479a = new C4479a(Constants.EXTRA_KEY_TOKEN, null, (String[]) null, (String[]) null);
            c4479a.m18574b(c4448b.f15171c);
            m18511a(c4479a);
            c4479a = new C4479a("kick", null, (String[]) null, (String[]) null);
            c4479a.m18574b(c4448b.f15173e ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            m18511a(c4479a);
            c4479a = new C4479a("sig", null, (String[]) null, (String[]) null);
            c4479a.m18574b(a);
            m18511a(c4479a);
            C4479a c4479a2 = new C4479a("method", null, (String[]) null, (String[]) null);
            if (TextUtils.isEmpty(c4448b.f15172d)) {
                c4479a2.m18574b("XIAOMI-SASL");
            } else {
                c4479a2.m18574b(c4448b.f15172d);
            }
            m18511a(c4479a2);
            c4479a2 = new C4479a("client_attrs", null, (String[]) null, (String[]) null);
            c4479a2.m18574b(c4448b.f15174f == null ? BuildConfig.FLAVOR : C4496g.m18647a(c4448b.f15174f));
            m18511a(c4479a2);
            c4479a2 = new C4479a("cloud_attrs", null, (String[]) null, (String[]) null);
            c4479a2.m18574b(c4448b.f15175g == null ? BuildConfig.FLAVOR : C4496g.m18647a(c4448b.f15175g));
            m18511a(c4479a2);
            if (!TextUtils.isEmpty(obj)) {
                c4479a2 = new C4479a("pf", null, (String[]) null, (String[]) null);
                c4479a2.m18574b(obj);
                m18511a(c4479a2);
            }
        }

        public String m18532a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<bind ");
            if (m18515k() != null) {
                stringBuilder.append("id=\"" + m18515k() + "\" ");
            }
            if (m18519m() != null) {
                stringBuilder.append("to=\"").append(C4496g.m18647a(m18519m())).append("\" ");
            }
            if (m18521n() != null) {
                stringBuilder.append("from=\"").append(C4496g.m18647a(m18521n())).append("\" ");
            }
            if (m18517l() != null) {
                stringBuilder.append("chid=\"").append(C4496g.m18647a(m18517l())).append("\">");
            }
            if (m18528q() != null) {
                for (C4478e d : m18528q()) {
                    stringBuilder.append(d.m18567d());
                }
            }
            stringBuilder.append("</bind>");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.xiaomi.smack.k.b */
    public static class C4471b extends C4468d {
        private C4470a f15350c;

        /* renamed from: com.xiaomi.smack.k.b.a */
        public static class C4470a {
            public static final C4470a f15347a;
            public static final C4470a f15348b;
            private String f15349c;

            static {
                f15347a = new C4470a("result");
                f15348b = new C4470a(C4233j.f14375B);
            }

            private C4470a(String str) {
                this.f15349c = str;
            }

            public static C4470a m18533a(String str) {
                if (str == null) {
                    return null;
                }
                String toLowerCase = str.toLowerCase();
                return f15348b.toString().equals(toLowerCase) ? f15348b : f15347a.toString().equals(toLowerCase) ? f15347a : null;
            }

            public String toString() {
                return this.f15349c;
            }
        }

        public String m18534a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<bind ");
            if (m18515k() != null) {
                stringBuilder.append("id=\"" + m18515k() + "\" ");
            }
            if (m18519m() != null) {
                stringBuilder.append("to=\"").append(C4496g.m18647a(m18519m())).append("\" ");
            }
            if (m18521n() != null) {
                stringBuilder.append("from=\"").append(C4496g.m18647a(m18521n())).append("\" ");
            }
            if (m18517l() != null) {
                stringBuilder.append(" chid=\"").append(C4496g.m18647a(m18517l())).append("\" ");
            }
            if (this.f15350c == null) {
                stringBuilder.append("type=\"result\">");
            } else {
                stringBuilder.append("type=\"").append(m18536b()).append("\">");
            }
            if (m18528q() != null) {
                for (C4478e d : m18528q()) {
                    stringBuilder.append(d.m18567d());
                }
            }
            C4488h p = m18526p();
            if (p != null) {
                stringBuilder.append(p.m18621d());
            }
            stringBuilder.append("</bind>");
            return stringBuilder.toString();
        }

        public void m18535a(C4470a c4470a) {
            if (c4470a == null) {
                this.f15350c = C4470a.f15347a;
            } else {
                this.f15350c = c4470a;
            }
        }

        public C4470a m18536b() {
            return this.f15350c;
        }
    }

    public void m18537a(C4448b c4448b, String str, C4461a c4461a) {
        C4468d c4469a = new C4469a(c4448b, str, c4461a);
        c4461a.m18460a(c4469a);
        C4302b.m17649a("SMACK: bind id=" + c4469a.m18515k());
    }
}
