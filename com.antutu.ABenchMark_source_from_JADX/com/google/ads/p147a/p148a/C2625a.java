package com.google.ads.p147a.p148a;

import com.google.android.gms.p146b.kg;
import com.google.android.gms.p146b.km;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.google.ads.a.a.a */
public interface C2625a {

    /* renamed from: com.google.ads.a.a.a.a */
    public static final class C2624a extends km {
        public String f9109a;

        public C2624a() {
            m10121a();
        }

        public C2624a m10121a() {
            this.f9109a = BuildConfig.FLAVOR;
            this.S = -1;
            return this;
        }

        public void m10122a(kg kgVar) {
            if (!this.f9109a.equals(BuildConfig.FLAVOR)) {
                kgVar.m13652a(1, this.f9109a);
            }
            super.m10117a(kgVar);
        }

        protected int m10123b() {
            int b = super.m10118b();
            return !this.f9109a.equals(BuildConfig.FLAVOR) ? b + kg.m13628b(1, this.f9109a) : b;
        }
    }
}
