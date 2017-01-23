package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.jb.C3268a;
import com.google.android.gms.p146b.jb.C3273b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.ho */
public class ho {
    public static final C3214a<Void> f11337a;
    private static iv f11338b;
    private static final Object f11339c;

    /* renamed from: com.google.android.gms.b.ho.a */
    public interface C3214a<T> {
        T m12764b();

        T m12765b(InputStream inputStream);
    }

    /* renamed from: com.google.android.gms.b.ho.1 */
    static class C32671 implements C3214a {
        C32671() {
        }

        public Void m13135a() {
            return null;
        }

        public Void m13136a(InputStream inputStream) {
            return null;
        }

        public /* synthetic */ Object m13137b() {
            return m13135a();
        }

        public /* synthetic */ Object m13138b(InputStream inputStream) {
            return m13136a(inputStream);
        }
    }

    /* renamed from: com.google.android.gms.b.ho.2 */
    class C32692 implements C3268a {
        final /* synthetic */ String f11327a;
        final /* synthetic */ C3274c f11328b;
        final /* synthetic */ ho f11329c;

        C32692(ho hoVar, String str, C3274c c3274c) {
            this.f11329c = hoVar;
            this.f11327a = str;
            this.f11328b = c3274c;
        }

        public void m13140a(jz jzVar) {
            C2972b.m11583d("Failed to load URL: " + this.f11327a + "\n" + jzVar.toString());
            this.f11328b.m13147a(null);
        }
    }

    /* renamed from: com.google.android.gms.b.ho.3 */
    class C32703 extends C3057c {
        final /* synthetic */ Map f11330a;
        final /* synthetic */ ho f11331b;

        C32703(ho hoVar, String str, C3273b c3273b, C3268a c3268a, Map map) {
            this.f11331b = hoVar;
            this.f11330a = map;
            super(str, c3273b, c3268a);
        }

        public Map<String, String> m13141a() {
            return this.f11330a == null ? super.m11985a() : this.f11330a;
        }
    }

    /* renamed from: com.google.android.gms.b.ho.b */
    private static class C3272b<T> extends it<InputStream> {
        private final C3214a<T> f11334a;
        private final C3273b<T> f11335b;

        /* renamed from: com.google.android.gms.b.ho.b.1 */
        class C32711 implements C3268a {
            final /* synthetic */ C3273b f11332a;
            final /* synthetic */ C3214a f11333b;

            C32711(C3273b c3273b, C3214a c3214a) {
                this.f11332a = c3273b;
                this.f11333b = c3214a;
            }

            public void m13142a(jz jzVar) {
                this.f11332a.m13146a(this.f11333b.m12764b());
            }
        }

        public C3272b(String str, C3214a<T> c3214a, C3273b<T> c3273b) {
            super(0, str, new C32711(c3273b, c3214a));
            this.f11334a = c3214a;
            this.f11335b = c3273b;
        }

        protected jb<InputStream> m13143a(gs gsVar) {
            return jb.m13529a(new ByteArrayInputStream(gsVar.f11162b), kv.m13770a(gsVar));
        }

        protected void m13144a(InputStream inputStream) {
            this.f11335b.m13146a(this.f11334a.m12765b(inputStream));
        }

        protected /* synthetic */ void m13145a(Object obj) {
            m13144a((InputStream) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.ho.c */
    private class C3274c<T> extends hw<T> implements C3273b<T> {
        final /* synthetic */ ho f11336a;

        private C3274c(ho hoVar) {
            this.f11336a = hoVar;
        }

        public void m13147a(T t) {
            super.m12217b((Object) t);
        }
    }

    static {
        f11339c = new Object();
        f11337a = new C32671();
    }

    public ho(Context context) {
        f11338b = ho.m13148a(context);
    }

    private static iv m13148a(Context context) {
        iv ivVar;
        synchronized (f11339c) {
            if (f11338b == null) {
                f11338b = C3109d.m12199a(context.getApplicationContext());
            }
            ivVar = f11338b;
        }
        return ivVar;
    }

    public <T> hz<T> m13149a(String str, C3214a<T> c3214a) {
        Object c3274c = new C3274c();
        f11338b.m13428a(new C3272b(str, c3214a, c3274c));
        return c3274c;
    }

    public hz<String> m13150a(String str, Map<String, String> map) {
        Object c3274c = new C3274c();
        f11338b.m13428a(new C32703(this, str, c3274c, new C32692(this, str, c3274c), map));
        return c3274c;
    }
}
