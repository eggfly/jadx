package com.facebook.ads.internal.p123a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2498g;

/* renamed from: com.facebook.ads.internal.a.d */
public class C2298d extends C2295a {
    private static final String f7955a;
    private final Context f7956b;
    private final Uri f7957c;

    static {
        f7955a = C2298d.class.getSimpleName();
    }

    public C2298d(Context context, Uri uri) {
        this.f7956b = context;
        this.f7957c = uri;
    }

    public C2487a m8717a() {
        return C2487a.OPEN_LINK;
    }

    public void m8718b() {
        m8706a(this.f7956b, this.f7957c);
        try {
            C2498g.m9476a(this.f7956b, Uri.parse(this.f7957c.getQueryParameter("link")));
        } catch (Throwable e) {
            Log.d(f7955a, "Failed to open link url: " + this.f7957c.toString(), e);
        }
    }
}
