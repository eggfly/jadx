package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class w {
    private final String DW;
    private final String FH;
    private final boolean Hw;
    private final Map<String, String> Zo;
    private final long j6;
    private long v5;

    public w(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        b.j6(str);
        b.j6(str2);
        this.j6 = j;
        this.DW = str;
        this.FH = str2;
        this.Hw = z;
        this.v5 = j2;
        if (map != null) {
            this.Zo = new HashMap(map);
        } else {
            this.Zo = Collections.emptyMap();
        }
    }

    public String DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }

    public boolean Hw() {
        return this.Hw;
    }

    public Map<String, String> Zo() {
        return this.Zo;
    }

    public long j6() {
        return this.j6;
    }

    public void j6(long j) {
        this.v5 = j;
    }

    public long v5() {
        return this.v5;
    }
}
