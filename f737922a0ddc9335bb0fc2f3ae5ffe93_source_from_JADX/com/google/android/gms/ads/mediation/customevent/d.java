package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.i;
import java.util.HashMap;

@Deprecated
public final class d implements i {
    private final HashMap<String, Object> j6;

    public d() {
        this.j6 = new HashMap();
    }

    public Object j6(String str) {
        return this.j6.get(str);
    }
}
