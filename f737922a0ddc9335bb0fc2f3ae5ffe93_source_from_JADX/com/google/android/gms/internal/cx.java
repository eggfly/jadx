package com.google.android.gms.internal;

import aer;
import android.location.Location;
import java.util.Date;
import java.util.Set;

@eh
public final class cx implements aer {
    private final int DW;
    private final Set<String> FH;
    private final boolean Hw;
    private final boolean VH;
    private final int Zo;
    private final Date j6;
    private final Location v5;

    public cx(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.j6 = date;
        this.DW = i;
        this.FH = set;
        this.v5 = location;
        this.Hw = z;
        this.Zo = i2;
        this.VH = z2;
    }

    public int DW() {
        return this.DW;
    }

    public Set<String> FH() {
        return this.FH;
    }

    public Location Hw() {
        return this.v5;
    }

    public boolean VH() {
        return this.VH;
    }

    public boolean Zo() {
        return this.Hw;
    }

    public Date j6() {
        return this.j6;
    }

    public int v5() {
        return this.Zo;
    }
}
