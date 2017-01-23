package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.C2755b;
import com.google.android.gms.ads.internal.client.C2755b.C2754a;
import com.google.android.gms.ads.mediation.C2633b;
import java.util.Date;

/* renamed from: com.google.android.gms.ads.c */
public final class C2716c {
    public static final String f9255a;
    private final C2755b f9256b;

    /* renamed from: com.google.android.gms.ads.c.a */
    public static final class C2712a {
        private final C2754a f9241a;

        public C2712a() {
            this.f9241a = new C2754a();
            this.f9241a.m10588b(C2716c.f9255a);
        }

        public C2712a m10310a(int i) {
            this.f9241a.m10582a(i);
            return this;
        }

        public C2712a m10311a(Location location) {
            this.f9241a.m10583a(location);
            return this;
        }

        public C2712a m10312a(Class<? extends C2633b> cls, Bundle bundle) {
            this.f9241a.m10584a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f9241a.m10590c(C2716c.f9255a);
            }
            return this;
        }

        public C2712a m10313a(String str) {
            this.f9241a.m10585a(str);
            return this;
        }

        public C2712a m10314a(Date date) {
            this.f9241a.m10586a(date);
            return this;
        }

        public C2712a m10315a(boolean z) {
            this.f9241a.m10587a(z);
            return this;
        }

        public C2716c m10316a() {
            return new C2716c();
        }

        public C2712a m10317b(String str) {
            this.f9241a.m10588b(str);
            return this;
        }

        public C2712a m10318b(boolean z) {
            this.f9241a.m10589b(z);
            return this;
        }
    }

    static {
        f9255a = C2755b.f9374a;
    }

    private C2716c(C2712a c2712a) {
        this.f9256b = new C2755b(c2712a.f9241a);
    }

    public C2755b m10333a() {
        return this.f9256b;
    }
}
