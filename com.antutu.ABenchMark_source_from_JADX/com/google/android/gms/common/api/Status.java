package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements C3386f, SafeParcelable {
    public static final Creator<Status> CREATOR;
    public static final Status f11821a;
    public static final Status f11822b;
    public static final Status f11823c;
    public static final Status f11824d;
    public static final Status f11825e;
    private final int f11826f;
    private final int f11827g;
    private final String f11828h;
    private final PendingIntent f11829i;

    static {
        f11821a = new Status(0);
        f11822b = new Status(14);
        f11823c = new Status(8);
        f11824d = new Status(15);
        f11825e = new Status(16);
        CREATOR = new C3452m();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f11826f = i;
        this.f11827g = i2;
        this.f11828h = str;
        this.f11829i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String m13958g() {
        return this.f11828h != null ? this.f11828h : C3445b.m14243a(this.f11827g);
    }

    public Status m13959a() {
        return this;
    }

    PendingIntent m13960b() {
        return this.f11829i;
    }

    public String m13961c() {
        return this.f11828h;
    }

    int m13962d() {
        return this.f11826f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean m13963e() {
        return this.f11827g <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f11826f == status.f11826f && this.f11827g == status.f11827g && C3511t.m14579a(this.f11828h, status.f11828h) && C3511t.m14579a(this.f11829i, status.f11829i);
    }

    public int m13964f() {
        return this.f11827g;
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f11826f), Integer.valueOf(this.f11827g), this.f11828h, this.f11829i);
    }

    public String toString() {
        return C3511t.m14578a((Object) this).m14576a("statusCode", m13958g()).m14576a("resolution", this.f11829i).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3452m.m14262a(this, parcel, i);
    }
}
