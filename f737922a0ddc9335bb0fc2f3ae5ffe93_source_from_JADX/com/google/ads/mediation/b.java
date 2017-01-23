package com.google.ads.mediation;

import aeo$b;
import android.location.Location;
import java.util.Date;
import java.util.Set;

@Deprecated
public class b {
    private final aeo$b DW;
    private final Set<String> FH;
    private final boolean Hw;
    private final Date j6;
    private final Location v5;

    public b(Date date, aeo$b aeo_b, Set<String> set, boolean z, Location location) {
        this.j6 = date;
        this.DW = aeo_b;
        this.FH = set;
        this.Hw = z;
        this.v5 = location;
    }
}
