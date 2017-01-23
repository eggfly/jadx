package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class y {
    private static final String[] FH;
    private String[] DW;
    private k Hw;
    private String j6;

    static {
        FH = new String[]{"/aclk", "/pcs/click"};
    }

    private Uri DW(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    private Uri j6(Uri uri, Context context, String str, boolean z) {
        try {
            boolean j6 = j6(uri);
            if (j6) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new z("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new z("Query parameter already exists: ms");
            }
            String j62 = z ? this.Hw.j6(context, str) : this.Hw.j6(context);
            return j6 ? DW(uri, "dc_ms", j62) : j6(uri, "ms", j62);
        } catch (UnsupportedOperationException e) {
            throw new z("Provided Uri is not in a valid state");
        }
    }

    private Uri j6(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    public boolean DW(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.DW) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean FH(Uri uri) {
        if (!DW(uri)) {
            return false;
        }
        for (String endsWith : FH) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public Uri j6(Uri uri, Context context) {
        try {
            return j6(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new z("Provided Uri is not in a valid state");
        }
    }

    public k j6() {
        return this.Hw;
    }

    public void j6(MotionEvent motionEvent) {
        this.Hw.j6(motionEvent);
    }

    public boolean j6(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.j6);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
