package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.eo */
public class eo {
    private final boolean f10805a;
    private final boolean f10806b;
    private final boolean f10807c;
    private final boolean f10808d;
    private final boolean f10809e;

    /* renamed from: com.google.android.gms.b.eo.a */
    public static final class C3171a {
        private boolean f10800a;
        private boolean f10801b;
        private boolean f10802c;
        private boolean f10803d;
        private boolean f10804e;

        public C3171a m12619a(boolean z) {
            this.f10800a = z;
            return this;
        }

        public eo m12620a() {
            return new eo();
        }

        public C3171a m12621b(boolean z) {
            this.f10801b = z;
            return this;
        }

        public C3171a m12622c(boolean z) {
            this.f10802c = z;
            return this;
        }

        public C3171a m12623d(boolean z) {
            this.f10803d = z;
            return this;
        }

        public C3171a m12624e(boolean z) {
            this.f10804e = z;
            return this;
        }
    }

    private eo(C3171a c3171a) {
        this.f10805a = c3171a.f10800a;
        this.f10806b = c3171a.f10801b;
        this.f10807c = c3171a.f10802c;
        this.f10808d = c3171a.f10803d;
        this.f10809e = c3171a.f10804e;
    }

    public JSONObject m12625a() {
        try {
            return new JSONObject().put("sms", this.f10805a).put("tel", this.f10806b).put("calendar", this.f10807c).put("storePicture", this.f10808d).put("inlineVideo", this.f10809e);
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
