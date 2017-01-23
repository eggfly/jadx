package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.xiaomi.pushsdk.BuildConfig;

public final class ConnectionEvent extends C3525f implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR;
    final int f12159a;
    private final long f12160b;
    private int f12161c;
    private final String f12162d;
    private final String f12163e;
    private final String f12164f;
    private final String f12165g;
    private final String f12166h;
    private final String f12167i;
    private final long f12168j;
    private final long f12169k;
    private long f12170l;

    static {
        CREATOR = new C3526a();
    }

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f12159a = i;
        this.f12160b = j;
        this.f12161c = i2;
        this.f12162d = str;
        this.f12163e = str2;
        this.f12164f = str3;
        this.f12165g = str4;
        this.f12170l = -1;
        this.f12166h = str5;
        this.f12167i = str6;
        this.f12168j = j2;
        this.f12169k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public long m14689a() {
        return this.f12160b;
    }

    public int m14690b() {
        return this.f12161c;
    }

    public String m14691c() {
        return this.f12162d;
    }

    public String m14692d() {
        return this.f12163e;
    }

    public int describeContents() {
        return 0;
    }

    public String m14693e() {
        return this.f12164f;
    }

    public String m14694f() {
        return this.f12165g;
    }

    public String m14695g() {
        return this.f12166h;
    }

    public String m14696h() {
        return this.f12167i;
    }

    public long m14697i() {
        return this.f12170l;
    }

    public long m14698j() {
        return this.f12169k;
    }

    public long m14699k() {
        return this.f12168j;
    }

    public String m14700l() {
        return "\t" + m14691c() + "/" + m14692d() + "\t" + m14693e() + "/" + m14694f() + "\t" + (this.f12166h == null ? BuildConfig.FLAVOR : this.f12166h) + "\t" + m14698j();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3526a.m14715a(this, parcel, i);
    }
}
