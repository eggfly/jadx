package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.p121f.C2421d;
import com.facebook.ads.internal.util.C2507o;
import com.facebook.ads.internal.util.C2510r;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.o */
public class C2331o extends C2299a {
    private static final String f8112b;
    private final C2421d f8113c;
    private C2329n f8114d;
    private boolean f8115e;

    /* renamed from: com.facebook.ads.internal.adapters.o.1 */
    class C23301 implements Runnable {
        final /* synthetic */ C2331o f8111a;

        C23301(C2331o c2331o) {
            this.f8111a = c2331o;
        }

        public void run() {
            if (this.f8111a.f8113c.m9268b()) {
                Log.w(C2331o.f8112b, "Webview already destroyed, cannot activate");
            } else {
                this.f8111a.f8113c.loadUrl("javascript:" + this.f8111a.f8114d.m8944b());
            }
        }
    }

    static {
        f8112b = C2331o.class.getSimpleName();
    }

    public C2331o(Context context, C2421d c2421d, C2268b c2268b) {
        super(context, c2268b);
        this.f8113c = c2421d;
    }

    private void m8953a(Map<String, String> map) {
        if (this.f8114d != null) {
            if (!C2510r.m9516a(this.f8114d.m8945c())) {
                new C2507o(map).execute(new String[]{r0});
            }
        }
    }

    public void m8956a(C2329n c2329n) {
        this.f8114d = c2329n;
    }

    protected void m8957b() {
        if (this.f8114d != null) {
            if (!(this.f8113c == null || C2510r.m9516a(this.f8114d.m8946d()))) {
                if (this.f8113c.m9268b()) {
                    Log.w(f8112b, "Webview already destroyed, cannot send impression");
                } else {
                    this.f8113c.loadUrl("javascript:" + this.f8114d.m8946d());
                }
            }
            m8953a(Collections.singletonMap("evt", "native_imp"));
        }
    }

    public synchronized void m8958c() {
        if (!(this.f8115e || this.f8114d == null)) {
            this.f8115e = true;
            if (!(this.f8113c == null || C2510r.m9516a(this.f8114d.m8944b()))) {
                this.f8113c.post(new C23301(this));
            }
        }
    }

    public void m8959d() {
        m8953a(Collections.singletonMap("evt", "interstitial_displayed"));
    }
}
