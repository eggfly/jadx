package com.google.android.gms.p146b;

import android.location.Location;
import com.google.android.gms.ads.mediation.C2974a;
import java.util.Date;
import java.util.Set;

@gb
/* renamed from: com.google.android.gms.b.eb */
public final class eb implements C2974a {
    private final Date f10729a;
    private final int f10730b;
    private final Set<String> f10731c;
    private final boolean f10732d;
    private final Location f10733e;
    private final int f10734f;
    private final boolean f10735g;

    public eb(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f10729a = date;
        this.f10730b = i;
        this.f10731c = set;
        this.f10733e = location;
        this.f10732d = z;
        this.f10734f = i2;
        this.f10735g = z2;
    }

    public Date m12475a() {
        return this.f10729a;
    }

    public int m12476b() {
        return this.f10730b;
    }

    public Set<String> m12477c() {
        return this.f10731c;
    }

    public Location m12478d() {
        return this.f10733e;
    }

    public int m12479e() {
        return this.f10734f;
    }

    public boolean m12480f() {
        return this.f10732d;
    }

    public boolean m12481g() {
        return this.f10735g;
    }
}
