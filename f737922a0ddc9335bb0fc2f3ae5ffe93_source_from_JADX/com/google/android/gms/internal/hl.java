package com.google.android.gms.internal;

import android.content.Context;

public class hl {
    private static hl DW;
    private zzpv j6;

    static {
        DW = new hl();
    }

    public hl() {
        this.j6 = null;
    }

    public static zzpv DW(Context context) {
        return DW.j6(context);
    }

    public synchronized zzpv j6(Context context) {
        if (this.j6 == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.j6 = new zzpv(context);
        }
        return this.j6;
    }
}
