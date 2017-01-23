package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzc extends i {
    private static final String j6;
    private final e DW;

    static {
        j6 = f.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public zzc(Context context) {
        this(e.j6(context));
    }

    zzc(e eVar) {
        super(j6, new String[0]);
        this.DW = eVar;
    }

    public a j6(Map<String, a> map) {
        return as.FH(Boolean.valueOf(!this.DW.DW()));
    }

    public boolean j6() {
        return false;
    }
}
