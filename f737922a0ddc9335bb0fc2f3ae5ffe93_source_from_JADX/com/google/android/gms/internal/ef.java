package com.google.android.gms.internal;

import java.util.Map;

public class ef {
    public final byte[] DW;
    public final Map<String, String> FH;
    public final boolean Hw;
    public final int j6;
    public final long v5;

    public ef(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.j6 = i;
        this.DW = bArr;
        this.FH = map;
        this.Hw = z;
        this.v5 = j;
    }

    public ef(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
