package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@eh
public class ax {
    private final ay DW;
    private final Map<String, aw> j6;

    public ax(ay ayVar) {
        this.DW = ayVar;
        this.j6 = new HashMap();
    }

    public ay j6() {
        return this.DW;
    }

    public void j6(String str, aw awVar) {
        this.j6.put(str, awVar);
    }

    public void j6(String str, String str2, long j) {
        at.j6(this.DW, (aw) this.j6.get(str2), j, str);
        this.j6.put(str, at.j6(this.DW, j));
    }
}
