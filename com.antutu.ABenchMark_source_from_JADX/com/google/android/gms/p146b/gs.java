package com.google.android.gms.p146b;

import com.taobao.accs.common.Constants;
import java.util.Map;

/* renamed from: com.google.android.gms.b.gs */
public class gs {
    public final int f11161a;
    public final byte[] f11162b;
    public final Map<String, String> f11163c;
    public final boolean f11164d;
    public final long f11165e;

    public gs(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f11161a = i;
        this.f11162b = bArr;
        this.f11163c = map;
        this.f11164d = z;
        this.f11165e = j;
    }

    public gs(byte[] bArr, Map<String, String> map) {
        this(Constants.COMMAND_HANDSHAKE, bArr, map, false, 0);
    }
}
