package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C3000a.C3001a;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.signin.internal.C3553g;
import com.google.android.gms.signin.internal.C3554h;

/* renamed from: com.google.android.gms.b.ka */
public final class ka {
    public static final C3388d<C3554h> f11580a;
    public static final C3388d<C3554h> f11581b;
    public static final C3327b<C3554h, kd> f11582c;
    static final C3327b<C3554h, C3330a> f11583d;
    public static final Scope f11584e;
    public static final Scope f11585f;
    public static final C3444a<kd> f11586g;
    public static final C3444a<C3330a> f11587h;
    public static final kb f11588i;

    /* renamed from: com.google.android.gms.b.ka.1 */
    static class C33281 extends C3327b<C3554h, kd> {
        C33281() {
        }

        public C3554h m13595a(Context context, Looper looper, C3477g c3477g, kd kdVar, C2921b c2921b, C2922c c2922c) {
            return new C3554h(context, looper, true, c3477g, kdVar == null ? kd.f11595a : kdVar, c2921b, c2922c);
        }
    }

    /* renamed from: com.google.android.gms.b.ka.2 */
    static class C33292 extends C3327b<C3554h, C3330a> {
        C33292() {
        }

        public C3554h m13597a(Context context, Looper looper, C3477g c3477g, C3330a c3330a, C2921b c2921b, C2922c c2922c) {
            return new C3554h(context, looper, false, c3477g, c3330a.m13598a(), c2921b, c2922c);
        }
    }

    /* renamed from: com.google.android.gms.b.ka.a */
    public static class C3330a implements C3001a {
        private final Bundle f11579a;

        public Bundle m13598a() {
            return this.f11579a;
        }
    }

    static {
        f11580a = new C3388d();
        f11581b = new C3388d();
        f11582c = new C33281();
        f11583d = new C33292();
        f11584e = new Scope("profile");
        f11585f = new Scope(NotificationCompatApi21.CATEGORY_EMAIL);
        f11586g = new C3444a("SignIn.API", f11582c, f11580a);
        f11587h = new C3444a("SignIn.INTERNAL_API", f11583d, f11581b);
        f11588i = new C3553g();
    }
}
