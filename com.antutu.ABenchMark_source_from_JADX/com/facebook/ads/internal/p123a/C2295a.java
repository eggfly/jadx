package com.facebook.ads.internal.p123a;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2507o;
import com.facebook.ads.internal.util.C2510r;

/* renamed from: com.facebook.ads.internal.a.a */
public abstract class C2295a {
    public abstract C2487a m8705a();

    protected void m8706a(Context context, Uri uri) {
        if (!C2510r.m9516a(uri.getQueryParameter("native_click_report_url"))) {
            new C2507o().execute(new String[]{r0});
            C2498g.m9477a(context, "Click logged");
        }
    }

    public abstract void m8707b();
}
