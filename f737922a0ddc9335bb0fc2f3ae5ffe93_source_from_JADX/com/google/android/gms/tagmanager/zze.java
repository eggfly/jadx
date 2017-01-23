package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.h.a;
import java.util.Map;

class zze extends i {
    private static final String DW;
    private static final String FH;
    private static final String j6;
    private final Context Hw;

    static {
        j6 = f.ADWORDS_CLICK_REFERRER.toString();
        DW = g.COMPONENT.toString();
        FH = g.CONVERSION_ID.toString();
    }

    public zze(Context context) {
        super(j6, FH);
        this.Hw = context;
    }

    public a j6(Map<String, a> map) {
        a aVar = (a) map.get(FH);
        if (aVar == null) {
            return as.j6();
        }
        String j6 = as.j6(aVar);
        aVar = (a) map.get(DW);
        Object j62 = q.j6(this.Hw, j6, aVar != null ? as.j6(aVar) : null);
        return j62 != null ? as.FH(j62) : as.j6();
    }

    public boolean j6() {
        return true;
    }
}
