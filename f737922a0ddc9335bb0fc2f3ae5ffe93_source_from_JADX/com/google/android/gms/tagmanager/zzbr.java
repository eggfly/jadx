package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzbr extends i {
    private static final String j6;
    private final Context DW;

    static {
        j6 = f.MOBILE_ADWORDS_UNIQUE_ID.toString();
    }

    public zzbr(Context context) {
        super(j6, new String[0]);
        this.DW = context;
    }

    public a j6(Map<String, a> map) {
        Object j6 = j6(this.DW);
        return j6 == null ? as.j6() : as.FH(j6);
    }

    protected String j6(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean j6() {
        return true;
    }
}
