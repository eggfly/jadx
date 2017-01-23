package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.c;

@eh
public final class ex extends en {
    private final String DW;
    private final c j6;

    public ex(Context context, String str, String str2) {
        this(str2, f.FH().j6(context, str));
    }

    public ex(String str, String str2) {
        this.j6 = new c(str2);
        this.DW = str;
    }

    public void j6() {
        this.j6.j6(this.DW);
    }
}
