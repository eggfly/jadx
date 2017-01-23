package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.android.spdy.SpdyProtocol;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR;
    final int f10106a;
    final long f10107b;
    final String f10108c;
    final int f10109d;
    final int f10110e;
    final String f10111f;

    static {
        CREATOR = new C2996a();
    }

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f10106a = i;
        this.f10107b = j;
        this.f10108c = (String) C3512u.m14580a((Object) str);
        this.f10109d = i2;
        this.f10110e = i3;
        this.f10111f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f10106a == accountChangeEvent.f10106a && this.f10107b == accountChangeEvent.f10107b && C3511t.m14579a(this.f10108c, accountChangeEvent.f10108c) && this.f10109d == accountChangeEvent.f10109d && this.f10110e == accountChangeEvent.f10110e && C3511t.m14579a(this.f10111f, accountChangeEvent.f10111f);
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f10106a), Long.valueOf(this.f10107b), this.f10108c, Integer.valueOf(this.f10109d), Integer.valueOf(this.f10110e), this.f10111f);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.f10109d) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                str = "ADDED";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                str = "REMOVED";
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                str = "RENAMED_FROM";
                break;
            case SpdyProtocol.QUIC /*4*/:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.f10108c + ", changeType = " + str + ", changeData = " + this.f10111f + ", eventIndex = " + this.f10110e + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2996a.m11644a(this, parcel, i);
    }
}
