package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.ii;
import org.android.agoo.common.AgooConstants;

@gb
/* renamed from: com.google.android.gms.ads.internal.f */
public class C2798f {
    private C2796a f9482a;
    private boolean f9483b;
    private boolean f9484c;

    /* renamed from: com.google.android.gms.ads.internal.f.a */
    public interface C2796a {
        void m10772a(String str);
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.f.b */
    public static class C2797b implements C2796a {
        private final C3232a f9480a;
        private final ii f9481b;

        public C2797b(C3232a c3232a, ii iiVar) {
            this.f9480a = c3232a;
            this.f9481b = iiVar;
        }

        public void m10773a(String str) {
            C2972b.m11576a("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme(HttpConstant.HTTPS);
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter(AgooConstants.MESSAGE_ID, "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.f9480a == null || this.f9480a.f11167b == null || TextUtils.isEmpty(this.f9480a.f11167b.f9899o))) {
                builder.appendQueryParameter("debugDialog", this.f9480a.f11167b.f9899o);
            }
            C2968s.m11525e().m13035a(this.f9481b.getContext(), this.f9481b.m13252o().f10081b, builder.toString());
        }
    }

    public C2798f() {
        this.f9484c = ((Boolean) aq.f10295i.m11794c()).booleanValue();
    }

    public C2798f(boolean z) {
        this.f9484c = z;
    }

    public void m10774a() {
        this.f9483b = true;
    }

    public void m10775a(C2796a c2796a) {
        this.f9482a = c2796a;
    }

    public void m10776a(String str) {
        C2972b.m11576a("Action was blocked because no click was detected.");
        if (this.f9482a != null) {
            this.f9482a.m10772a(str);
        }
    }

    public boolean m10777b() {
        return !this.f9484c || this.f9483b;
    }
}
