package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.p146b.gb;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.o */
public final class C2777o {
    private long f9433a;
    private Bundle f9434b;
    private int f9435c;
    private List<String> f9436d;
    private boolean f9437e;
    private int f9438f;
    private boolean f9439g;
    private String f9440h;
    private SearchAdRequestParcel f9441i;
    private Location f9442j;
    private String f9443k;
    private Bundle f9444l;
    private Bundle f9445m;
    private List<String> f9446n;
    private String f9447o;
    private String f9448p;
    private boolean f9449q;

    public C2777o() {
        this.f9433a = -1;
        this.f9434b = new Bundle();
        this.f9435c = -1;
        this.f9436d = new ArrayList();
        this.f9437e = false;
        this.f9438f = -1;
        this.f9439g = false;
        this.f9440h = null;
        this.f9441i = null;
        this.f9442j = null;
        this.f9443k = null;
        this.f9444l = new Bundle();
        this.f9445m = new Bundle();
        this.f9446n = new ArrayList();
        this.f9447o = null;
        this.f9448p = null;
        this.f9449q = false;
    }

    public C2777o(AdRequestParcel adRequestParcel) {
        this.f9433a = adRequestParcel.f9308b;
        this.f9434b = adRequestParcel.f9309c;
        this.f9435c = adRequestParcel.f9310d;
        this.f9436d = adRequestParcel.f9311e;
        this.f9437e = adRequestParcel.f9312f;
        this.f9438f = adRequestParcel.f9313g;
        this.f9439g = adRequestParcel.f9314h;
        this.f9440h = adRequestParcel.f9315i;
        this.f9441i = adRequestParcel.f9316j;
        this.f9442j = adRequestParcel.f9317k;
        this.f9443k = adRequestParcel.f9318l;
        this.f9444l = adRequestParcel.f9319m;
        this.f9445m = adRequestParcel.f9320n;
        this.f9446n = adRequestParcel.f9321o;
        this.f9447o = adRequestParcel.f9322p;
        this.f9448p = adRequestParcel.f9323q;
    }

    public AdRequestParcel m10721a() {
        return new AdRequestParcel(7, this.f9433a, this.f9434b, this.f9435c, this.f9436d, this.f9437e, this.f9438f, this.f9439g, this.f9440h, this.f9441i, this.f9442j, this.f9443k, this.f9444l, this.f9445m, this.f9446n, this.f9447o, this.f9448p, this.f9449q);
    }

    public C2777o m10722a(Location location) {
        this.f9442j = location;
        return this;
    }
}
