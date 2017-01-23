package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.c */
final class C0759c implements Creator<NetworkResponse> {
    C0759c() {
    }

    public NetworkResponse m3018a(Parcel parcel) {
        return NetworkResponse.m2992a(parcel);
    }

    public NetworkResponse[] m3019a(int i) {
        return new NetworkResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3018a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3019a(i);
    }
}
