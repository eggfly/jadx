package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzb extends i {
    private static final String j6;
    private final e DW;

    static {
        j6 = f.ADVERTISER_ID.toString();
    }

    public zzb(Context context) {
        this(e.j6(context));
    }

    zzb(e eVar) {
        super(j6, new String[0]);
        this.DW = eVar;
    }

    public a j6(Map<String, a> map) {
        Object j6 = this.DW.j6();
        return j6 == null ? as.j6() : as.FH(j6);
    }

    public boolean j6() {
        return false;
    }
}
