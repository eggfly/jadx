package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzf extends i {
    private static final String j6;
    private final Context DW;

    static {
        j6 = f.APP_ID.toString();
    }

    public zzf(Context context) {
        super(j6, new String[0]);
        this.DW = context;
    }

    public a j6(Map<String, a> map) {
        return as.FH(this.DW.getPackageName());
    }

    public boolean j6() {
        return true;
    }
}
