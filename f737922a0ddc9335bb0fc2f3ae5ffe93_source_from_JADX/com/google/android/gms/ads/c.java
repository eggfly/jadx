package com.google.android.gms.ads;

import aes;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.e;
import java.util.Date;

public final class c {
    public static final String j6;
    private final e DW;

    public static final class a {
        private final com.google.android.gms.ads.internal.client.e.a j6;

        public a() {
            this.j6 = new com.google.android.gms.ads.internal.client.e.a();
            this.j6.DW(c.j6);
        }

        public a DW(String str) {
            this.j6.DW(str);
            return this;
        }

        public a DW(boolean z) {
            this.j6.DW(z);
            return this;
        }

        public a j6(int i) {
            this.j6.j6(i);
            return this;
        }

        public a j6(Location location) {
            this.j6.j6(location);
            return this;
        }

        public a j6(Class<? extends aes> cls, Bundle bundle) {
            this.j6.j6(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.j6.FH(c.j6);
            }
            return this;
        }

        public a j6(String str) {
            this.j6.j6(str);
            return this;
        }

        public a j6(Date date) {
            this.j6.j6(date);
            return this;
        }

        public a j6(boolean z) {
            this.j6.j6(z);
            return this;
        }

        public c j6() {
            return new c();
        }
    }

    static {
        j6 = e.j6;
    }

    private c(a aVar) {
        this.DW = new e(aVar.j6);
    }

    public e j6() {
        return this.DW;
    }
}
