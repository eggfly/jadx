package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.e;
import com.google.android.gms.ads.internal.client.o;
import com.google.android.gms.ads.internal.client.s;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.bs;
import com.google.android.gms.internal.cp;

public class b {
    private final Context DW;
    private final ab FH;
    private final s j6;

    public static class a {
        private final ac DW;
        private final Context j6;

        a(Context context, ac acVar) {
            this.j6 = context;
            this.DW = acVar;
        }

        public a(Context context, String str) {
            this((Context) com.google.android.gms.common.internal.b.j6((Object) context, (Object) "context cannot be null"), w.DW().j6(context, str, new cp()));
        }

        public a j6(a aVar) {
            try {
                this.DW.j6(new o(aVar));
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Failed to set AdListener.", e);
            }
            return this;
        }

        public a j6(com.google.android.gms.ads.formats.b bVar) {
            try {
                this.DW.j6(new NativeAdOptionsParcel(bVar));
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Failed to specify native ad options", e);
            }
            return this;
        }

        public a j6(com.google.android.gms.ads.formats.c.a aVar) {
            try {
                this.DW.j6(new br(aVar));
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Failed to add app install ad listener", e);
            }
            return this;
        }

        public a j6(com.google.android.gms.ads.formats.d.a aVar) {
            try {
                this.DW.j6(new bs(aVar));
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Failed to add content ad listener", e);
            }
            return this;
        }

        public b j6() {
            try {
                return new b(this.j6, this.DW.j6());
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.DW("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    b(Context context, ab abVar) {
        this(context, abVar, s.j6());
    }

    b(Context context, ab abVar, s sVar) {
        this.DW = context;
        this.FH = abVar;
        this.j6 = sVar;
    }

    private void j6(e eVar) {
        try {
            this.FH.j6(this.j6.j6(this.DW, eVar));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.DW("Failed to load ad.", e);
        }
    }

    public void j6(c cVar) {
        j6(cVar.j6());
    }
}
