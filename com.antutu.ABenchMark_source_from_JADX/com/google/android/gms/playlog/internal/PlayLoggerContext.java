package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlayLoggerContext implements SafeParcelable {
    public static final C3545b CREATOR;
    public final int f12236a;
    public final String f12237b;
    public final int f12238c;
    public final int f12239d;
    public final String f12240e;
    public final String f12241f;
    public final boolean f12242g;
    public final String f12243h;
    public final boolean f12244i;
    public final int f12245j;

    static {
        CREATOR = new C3545b();
    }

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f12236a = i;
        this.f12237b = str;
        this.f12238c = i2;
        this.f12239d = i3;
        this.f12240e = str2;
        this.f12241f = str3;
        this.f12242g = z;
        this.f12243h = str4;
        this.f12244i = z2;
        this.f12245j = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.f12236a = 1;
        this.f12237b = (String) C3512u.m14580a((Object) str);
        this.f12238c = i;
        this.f12239d = i2;
        this.f12243h = str2;
        this.f12240e = str3;
        this.f12241f = str4;
        this.f12242g = !z;
        this.f12244i = z;
        this.f12245j = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.f12236a == playLoggerContext.f12236a && this.f12237b.equals(playLoggerContext.f12237b) && this.f12238c == playLoggerContext.f12238c && this.f12239d == playLoggerContext.f12239d && C3511t.m14579a(this.f12243h, playLoggerContext.f12243h) && C3511t.m14579a(this.f12240e, playLoggerContext.f12240e) && C3511t.m14579a(this.f12241f, playLoggerContext.f12241f) && this.f12242g == playLoggerContext.f12242g && this.f12244i == playLoggerContext.f12244i && this.f12245j == playLoggerContext.f12245j;
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f12236a), this.f12237b, Integer.valueOf(this.f12238c), Integer.valueOf(this.f12239d), this.f12243h, this.f12240e, this.f12241f, Boolean.valueOf(this.f12242g), Boolean.valueOf(this.f12244i), Integer.valueOf(this.f12245j));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.f12236a).append(',');
        stringBuilder.append("package=").append(this.f12237b).append(',');
        stringBuilder.append("packageVersionCode=").append(this.f12238c).append(',');
        stringBuilder.append("logSource=").append(this.f12239d).append(',');
        stringBuilder.append("logSourceName=").append(this.f12243h).append(',');
        stringBuilder.append("uploadAccount=").append(this.f12240e).append(',');
        stringBuilder.append("loggingId=").append(this.f12241f).append(',');
        stringBuilder.append("logAndroidId=").append(this.f12242g).append(',');
        stringBuilder.append("isAnonymous=").append(this.f12244i).append(',');
        stringBuilder.append("qosTier=").append(this.f12245j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3545b.m14751a(this, parcel, i);
    }
}
