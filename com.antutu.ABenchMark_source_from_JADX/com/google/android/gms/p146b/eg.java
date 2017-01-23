package com.google.android.gms.p146b;

import android.location.Location;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.C2990l;
import com.google.android.gms.ads.p124b.C2704b;
import com.google.android.gms.ads.p124b.C2704b.C2703a;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.b.eg */
public final class eg implements C2990l {
    private final Date f10742a;
    private final int f10743b;
    private final Set<String> f10744c;
    private final boolean f10745d;
    private final Location f10746e;
    private final int f10747f;
    private final NativeAdOptionsParcel f10748g;
    private final List<String> f10749h;
    private final boolean f10750i;

    public eg(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.f10742a = date;
        this.f10743b = i;
        this.f10744c = set;
        this.f10746e = location;
        this.f10745d = z;
        this.f10747f = i2;
        this.f10748g = nativeAdOptionsParcel;
        this.f10749h = list;
        this.f10750i = z2;
    }

    public Date m12548a() {
        return this.f10742a;
    }

    public int m12549b() {
        return this.f10743b;
    }

    public Set<String> m12550c() {
        return this.f10744c;
    }

    public Location m12551d() {
        return this.f10746e;
    }

    public int m12552e() {
        return this.f10747f;
    }

    public boolean m12553f() {
        return this.f10745d;
    }

    public boolean m12554g() {
        return this.f10750i;
    }

    public C2704b m12555h() {
        return this.f10748g == null ? null : new C2703a().m10282a(this.f10748g.f9486b).m10281a(this.f10748g.f9487c).m10284b(this.f10748g.f9488d).m10283a();
    }

    public boolean m12556i() {
        return this.f10749h != null && this.f10749h.contains(MessageService.MSG_DB_NOTIFY_CLICK);
    }

    public boolean m12557j() {
        return this.f10749h != null && this.f10749h.contains(MessageService.MSG_DB_NOTIFY_REACHED);
    }
}
