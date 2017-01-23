package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.webkit.WebView;

/* renamed from: com.facebook.ads.internal.f.d */
public class C2421d extends WebView {
    private boolean f8363a;

    public C2421d(Context context) {
        super(context);
    }

    public boolean m9268b() {
        return this.f8363a;
    }

    public void destroy() {
        this.f8363a = true;
        super.destroy();
    }
}
