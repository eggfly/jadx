package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

public final class WakeLockEvent extends C3525f implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR;
    final int f12171a;
    private final long f12172b;
    private int f12173c;
    private final String f12174d;
    private final int f12175e;
    private final List<String> f12176f;
    private final String f12177g;
    private final long f12178h;
    private int f12179i;
    private final String f12180j;
    private final String f12181k;
    private final float f12182l;
    private final long f12183m;
    private long f12184n;

    static {
        CREATOR = new C3532g();
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.f12171a = i;
        this.f12172b = j;
        this.f12173c = i2;
        this.f12174d = str;
        this.f12180j = str3;
        this.f12175e = i3;
        this.f12184n = -1;
        this.f12176f = list;
        this.f12177g = str2;
        this.f12178h = j2;
        this.f12179i = i4;
        this.f12181k = str4;
        this.f12182l = f;
        this.f12183m = j3;
    }

    public long m14701a() {
        return this.f12172b;
    }

    public int m14702b() {
        return this.f12173c;
    }

    public String m14703c() {
        return this.f12174d;
    }

    public String m14704d() {
        return this.f12180j;
    }

    public int describeContents() {
        return 0;
    }

    public int m14705e() {
        return this.f12175e;
    }

    public List<String> m14706f() {
        return this.f12176f;
    }

    public String m14707g() {
        return this.f12177g;
    }

    public long m14708h() {
        return this.f12178h;
    }

    public long m14709i() {
        return this.f12184n;
    }

    public int m14710j() {
        return this.f12179i;
    }

    public String m14711k() {
        return this.f12181k;
    }

    public String m14712l() {
        return "\t" + m14703c() + "\t" + m14705e() + "\t" + (m14706f() == null ? BuildConfig.FLAVOR : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, m14706f())) + "\t" + m14710j() + "\t" + (m14704d() == null ? BuildConfig.FLAVOR : m14704d()) + "\t" + (m14711k() == null ? BuildConfig.FLAVOR : m14711k()) + "\t" + m14713m();
    }

    public float m14713m() {
        return this.f12182l;
    }

    public long m14714n() {
        return this.f12183m;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3532g.m14735a(this, parcel, i);
    }
}
