package com.google.android.gms.internal;

import aeq$c;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.zzah;

@Deprecated
public final class gw {
    private static gw DW;
    private static Object j6;
    private final String FH;
    private final String Hw;
    private final String VH;
    private final String Zo;
    private final String gn;
    private final boolean tp;
    private final boolean u7;
    private final Status v5;

    static {
        j6 = new Object();
    }

    gw(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(aeq$c.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.tp = z;
            z = z2;
        } else {
            this.tp = false;
        }
        this.u7 = z;
        zzah com_google_android_gms_common_internal_zzah = new zzah(context);
        this.Zo = com_google_android_gms_common_internal_zzah.j6("firebase_database_url");
        this.gn = com_google_android_gms_common_internal_zzah.j6("google_storage_bucket");
        this.VH = com_google_android_gms_common_internal_zzah.j6("gcm_defaultSenderId");
        this.Hw = com_google_android_gms_common_internal_zzah.j6("google_api_key");
        Object j6 = ad.j6(context);
        if (j6 == null) {
            j6 = com_google_android_gms_common_internal_zzah.j6("google_app_id");
        }
        if (TextUtils.isEmpty(j6)) {
            this.v5 = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.FH = null;
            return;
        }
        this.FH = j6;
        this.v5 = Status.j6;
    }

    gw(String str, boolean z) {
        this(str, z, null, null, null);
    }

    gw(String str, boolean z, String str2, String str3, String str4) {
        this.FH = str;
        this.Hw = null;
        this.v5 = Status.j6;
        this.u7 = z;
        this.tp = !z;
        this.Zo = str2;
        this.VH = str4;
        this.gn = str3;
    }

    private static gw DW(String str) {
        gw gwVar;
        synchronized (j6) {
            if (DW == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            gwVar = DW;
        }
        return gwVar;
    }

    public static boolean DW() {
        return DW("isMeasurementExplicitlyDisabled").tp;
    }

    public static Status j6(Context context) {
        Status status;
        b.j6((Object) context, (Object) "Context must not be null.");
        synchronized (j6) {
            if (DW == null) {
                DW = new gw(context);
            }
            status = DW.v5;
        }
        return status;
    }

    public static Status j6(Context context, String str, boolean z) {
        Status j6;
        b.j6((Object) context, (Object) "Context must not be null.");
        b.j6(str, (Object) "App ID must be nonempty.");
        synchronized (j6) {
            if (DW != null) {
                j6 = DW.j6(str);
            } else {
                DW = new gw(str, z);
                j6 = DW.v5;
            }
        }
        return j6;
    }

    public static String j6() {
        return DW("getGoogleAppId").FH;
    }

    Status j6(String str) {
        if (this.FH == null || this.FH.equals(str)) {
            return Status.j6;
        }
        String str2 = this.FH;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
