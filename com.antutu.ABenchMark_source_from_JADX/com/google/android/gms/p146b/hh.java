package com.google.android.gms.p146b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.concurrent.Future;

@gb
/* renamed from: com.google.android.gms.b.hh */
public final class hh {

    /* renamed from: com.google.android.gms.b.hh.b */
    public interface C3234b {
        void m12928a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.b.hh.a */
    private static abstract class C3237a extends he {
        private C3237a() {
        }

        public void m12983b() {
        }
    }

    /* renamed from: com.google.android.gms.b.hh.1 */
    static class C32381 extends C3237a {
        final /* synthetic */ Context f11268a;
        final /* synthetic */ boolean f11269b;

        C32381(Context context, boolean z) {
            this.f11268a = context;
            this.f11269b = z;
            super();
        }

        public void m12984a() {
            Editor edit = hh.m12992a(this.f11268a).edit();
            edit.putBoolean("use_https", this.f11269b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.b.hh.2 */
    static class C32392 extends C3237a {
        final /* synthetic */ Context f11270a;
        final /* synthetic */ C3234b f11271b;

        C32392(Context context, C3234b c3234b) {
            this.f11270a = context;
            this.f11271b = c3234b;
            super();
        }

        public void m12985a() {
            SharedPreferences a = hh.m12992a(this.f11270a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", a.getBoolean("use_https", true));
            if (this.f11271b != null) {
                this.f11271b.m12928a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hh.3 */
    static class C32403 extends C3237a {
        final /* synthetic */ Context f11272a;
        final /* synthetic */ int f11273b;

        C32403(Context context, int i) {
            this.f11272a = context;
            this.f11273b = i;
            super();
        }

        public void m12986a() {
            Editor edit = hh.m12992a(this.f11272a).edit();
            edit.putInt("webview_cache_version", this.f11273b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.b.hh.4 */
    static class C32414 extends C3237a {
        final /* synthetic */ Context f11274a;
        final /* synthetic */ C3234b f11275b;

        C32414(Context context, C3234b c3234b) {
            this.f11274a = context;
            this.f11275b = c3234b;
            super();
        }

        public void m12987a() {
            SharedPreferences a = hh.m12992a(this.f11274a);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", a.getInt("webview_cache_version", 0));
            if (this.f11275b != null) {
                this.f11275b.m12928a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hh.5 */
    static class C32425 extends C3237a {
        final /* synthetic */ Context f11276a;
        final /* synthetic */ boolean f11277b;

        C32425(Context context, boolean z) {
            this.f11276a = context;
            this.f11277b = z;
            super();
        }

        public void m12988a() {
            Editor edit = hh.m12992a(this.f11276a).edit();
            edit.putBoolean("content_url_opted_out", this.f11277b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.b.hh.6 */
    static class C32436 extends C3237a {
        final /* synthetic */ Context f11278a;
        final /* synthetic */ C3234b f11279b;

        C32436(Context context, C3234b c3234b) {
            this.f11278a = context;
            this.f11279b = c3234b;
            super();
        }

        public void m12989a() {
            SharedPreferences a = hh.m12992a(this.f11278a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", a.getBoolean("content_url_opted_out", true));
            if (this.f11279b != null) {
                this.f11279b.m12928a(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hh.7 */
    static class C32447 extends C3237a {
        final /* synthetic */ Context f11280a;
        final /* synthetic */ String f11281b;

        C32447(Context context, String str) {
            this.f11280a = context;
            this.f11281b = str;
            super();
        }

        public void m12990a() {
            Editor edit = hh.m12992a(this.f11280a).edit();
            edit.putString("content_url_hashes", this.f11281b);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.b.hh.8 */
    static class C32458 extends C3237a {
        final /* synthetic */ Context f11282a;
        final /* synthetic */ C3234b f11283b;

        C32458(Context context, C3234b c3234b) {
            this.f11282a = context;
            this.f11283b = c3234b;
            super();
        }

        public void m12991a() {
            SharedPreferences a = hh.m12992a(this.f11282a);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", a.getString("content_url_hashes", BuildConfig.FLAVOR));
            if (this.f11283b != null) {
                this.f11283b.m12928a(bundle);
            }
        }
    }

    public static SharedPreferences m12992a(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future m12993a(Context context, int i) {
        return new C32403(context, i).m10975g();
    }

    public static Future m12994a(Context context, C3234b c3234b) {
        return new C32392(context, c3234b).m10975g();
    }

    public static Future m12995a(Context context, String str) {
        return new C32447(context, str).m10975g();
    }

    public static Future m12996a(Context context, boolean z) {
        return new C32381(context, z).m10975g();
    }

    public static Future m12997b(Context context, C3234b c3234b) {
        return new C32414(context, c3234b).m10975g();
    }

    public static Future m12998b(Context context, boolean z) {
        return new C32425(context, z).m10975g();
    }

    public static Future m12999c(Context context, C3234b c3234b) {
        return new C32436(context, c3234b).m10975g();
    }

    public static Future m13000d(Context context, C3234b c3234b) {
        return new C32458(context, c3234b).m10975g();
    }
}
