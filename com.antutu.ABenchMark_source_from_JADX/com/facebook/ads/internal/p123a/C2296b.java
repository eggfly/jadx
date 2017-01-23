package com.facebook.ads.internal.p123a;

import android.content.Context;
import android.net.Uri;

/* renamed from: com.facebook.ads.internal.a.b */
public class C2296b {
    public static C2295a m8708a(Context context, Uri uri) {
        String authority = uri.getAuthority();
        return "store".equals(authority) ? uri.getQueryParameter("video_url") != null ? null : new C2297c(context, uri) : "open_link".equals(authority) ? new C2298d(context, uri) : null;
    }
}
