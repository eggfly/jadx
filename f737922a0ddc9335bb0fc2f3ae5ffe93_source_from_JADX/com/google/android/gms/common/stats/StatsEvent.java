package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable {
    public abstract int DW();

    public abstract long j6();

    public String toString() {
        long j6 = j6();
        String valueOf = String.valueOf("\t");
        int DW = DW();
        String valueOf2 = String.valueOf("\t");
        long u7 = u7();
        String valueOf3 = String.valueOf(we());
        return new StringBuilder(((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(j6).append(valueOf).append(DW).append(valueOf2).append(u7).append(valueOf3).toString();
    }

    public abstract long u7();

    public abstract String we();
}
