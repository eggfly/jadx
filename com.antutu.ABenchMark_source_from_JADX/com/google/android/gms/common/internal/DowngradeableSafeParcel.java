package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object f12024a;
    private static ClassLoader f12025b;
    private static Integer f12026c;
    private boolean f12027d;

    static {
        f12024a = new Object();
        f12025b = null;
        f12026c = null;
    }

    public DowngradeableSafeParcel() {
        this.f12027d = false;
    }
}
