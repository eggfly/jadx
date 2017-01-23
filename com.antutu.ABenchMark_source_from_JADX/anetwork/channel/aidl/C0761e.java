package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.e */
final class C0761e implements Creator<ParcelableHeader> {
    C0761e() {
    }

    public ParcelableHeader m3022a(Parcel parcel) {
        return ParcelableHeader.m2993a(parcel);
    }

    public ParcelableHeader[] m3023a(int i) {
        return new ParcelableHeader[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3022a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3023a(i);
    }
}
