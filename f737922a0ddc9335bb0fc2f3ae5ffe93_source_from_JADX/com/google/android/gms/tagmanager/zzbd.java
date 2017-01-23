package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zzbd extends i {
    private static final String DW;
    private static final String j6;
    private final Context FH;

    static {
        j6 = f.INSTALL_REFERRER.toString();
        DW = g.COMPONENT.toString();
    }

    public zzbd(Context context) {
        super(j6, new String[0]);
        this.FH = context;
    }

    public a j6(Map<String, a> map) {
        Object DW = q.DW(this.FH, ((a) map.get(DW)) != null ? as.j6((a) map.get(DW)) : null);
        return DW != null ? as.FH(DW) : as.j6();
    }

    public boolean j6() {
        return true;
    }
}
