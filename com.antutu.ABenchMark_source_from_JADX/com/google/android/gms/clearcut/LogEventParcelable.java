package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.C3383b.C3381b;
import com.google.android.gms.common.internal.C3505s;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.kq.C3339d;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final C3384d CREATOR;
    public final int f11776a;
    public PlayLoggerContext f11777b;
    public byte[] f11778c;
    public int[] f11779d;
    public final C3339d f11780e;
    public final C3381b f11781f;
    public final C3381b f11782g;

    static {
        CREATOR = new C3384d();
    }

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.f11776a = i;
        this.f11777b = playLoggerContext;
        this.f11778c = bArr;
        this.f11779d = iArr;
        this.f11780e = null;
        this.f11781f = null;
        this.f11782g = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, C3339d c3339d, C3381b c3381b, C3381b c3381b2, int[] iArr) {
        this.f11776a = 1;
        this.f11777b = playLoggerContext;
        this.f11780e = c3339d;
        this.f11781f = c3381b;
        this.f11782g = c3381b2;
        this.f11779d = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.f11776a == logEventParcelable.f11776a && C3511t.m14579a(this.f11777b, logEventParcelable.f11777b) && Arrays.equals(this.f11778c, logEventParcelable.f11778c) && Arrays.equals(this.f11779d, logEventParcelable.f11779d) && C3511t.m14579a(this.f11780e, logEventParcelable.f11780e) && C3511t.m14579a(this.f11781f, logEventParcelable.f11781f) && C3511t.m14579a(this.f11782g, logEventParcelable.f11782g);
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f11776a), this.f11777b, this.f11778c, this.f11779d, this.f11780e, this.f11781f, this.f11782g);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
        stringBuilder.append(this.f11776a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f11777b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f11778c == null ? null : new String(this.f11778c));
        stringBuilder.append(", ");
        stringBuilder.append(this.f11779d == null ? (String) null : C3505s.m14516a(", ").m14518a(Arrays.asList(new int[][]{this.f11779d})));
        stringBuilder.append(", ");
        stringBuilder.append(this.f11780e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f11781f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f11782g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3384d.m13946a(this, parcel, i);
    }
}
