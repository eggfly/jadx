package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable {
    private static ClassLoader DW;
    private static Integer FH;
    private static final Object j6;
    private boolean Hw;

    static {
        j6 = new Object();
        DW = null;
        FH = null;
    }

    public DowngradeableSafeParcel() {
        this.Hw = false;
    }
}
