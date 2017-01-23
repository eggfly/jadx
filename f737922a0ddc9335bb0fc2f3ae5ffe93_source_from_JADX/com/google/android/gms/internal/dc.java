package com.google.android.gms.internal;

import afc;
import android.location.Location;
import com.google.android.gms.ads.formats.b;
import com.google.android.gms.ads.formats.b.a;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.Date;
import java.util.List;
import java.util.Set;

@eh
public final class dc implements afc {
    private final int DW;
    private final Set<String> FH;
    private final boolean Hw;
    private final NativeAdOptionsParcel VH;
    private final int Zo;
    private final List<String> gn;
    private final Date j6;
    private final boolean u7;
    private final Location v5;

    public dc(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.j6 = date;
        this.DW = i;
        this.FH = set;
        this.v5 = location;
        this.Hw = z;
        this.Zo = i2;
        this.VH = nativeAdOptionsParcel;
        this.gn = list;
        this.u7 = z2;
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
        return this.u7;
    }

    public boolean Zo() {
        return this.Hw;
    }

    public b gn() {
        return this.VH == null ? null : new a().j6(this.VH.DW).j6(this.VH.FH).DW(this.VH.Hw).j6();
    }

    public Date j6() {
        return this.j6;
    }

    public boolean tp() {
        return this.gn != null && this.gn.contains("1");
    }

    public boolean u7() {
        return this.gn != null && this.gn.contains("2");
    }

    public int v5() {
        return this.Zo;
    }
}
