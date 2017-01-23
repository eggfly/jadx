package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.h */
final class C0764h implements Creator<ParcelableRequest> {
    C0764h() {
    }

    public ParcelableRequest m3032a(Parcel parcel) {
        return ParcelableRequest.m2995a(parcel);
    }

    public ParcelableRequest[] m3033a(int i) {
        return new ParcelableRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3032a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3033a(i);
    }
}
