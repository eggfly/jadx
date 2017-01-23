package com.google.android.gms.p146b;

import android.util.Base64;

/* renamed from: com.google.android.gms.b.e */
class C3159e implements C3158m {
    C3159e() {
    }

    public String m12448a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m12449a(String str, boolean z) {
        return Base64.decode(str, z ? 11 : 2);
    }
}
