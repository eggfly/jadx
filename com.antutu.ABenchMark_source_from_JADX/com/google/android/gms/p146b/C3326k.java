package com.google.android.gms.p146b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.b.k */
public class C3326k {
    private static final String[] f11573e;
    private String f11574a;
    private String f11575b;
    private String f11576c;
    private String[] f11577d;
    private C2827g f11578f;

    static {
        f11573e = new String[]{"/aclk", "/pcs/click"};
    }

    public C3326k(C2827g c2827g) {
        this.f11574a = "googleads.g.doubleclick.net";
        this.f11575b = "/pagead/ads";
        this.f11576c = "ad.doubleclick.net";
        this.f11577d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.f11578f = c2827g;
    }

    private Uri m13582a(Uri uri, Context context, String str, boolean z) {
        try {
            boolean a = m13588a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C3348l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C3348l("Query parameter already exists: ms");
            }
            String a2 = z ? this.f11578f.m10933a(context, str) : this.f11578f.m10932a(context);
            return a ? m13584b(uri, "dc_ms", a2) : m13583a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C3348l("Provided Uri is not in a valid state");
        }
    }

    private Uri m13583a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m13584b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m13585a(Uri uri, Context context) {
        try {
            return m13582a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C3348l("Provided Uri is not in a valid state");
        }
    }

    public C2827g m13586a() {
        return this.f11578f;
    }

    public void m13587a(MotionEvent motionEvent) {
        this.f11578f.m10935a(motionEvent);
    }

    public boolean m13588a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f11576c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m13589b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f11577d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m13590c(Uri uri) {
        if (!m13589b(uri)) {
            return false;
        }
        for (String endsWith : f11573e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
