package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.g */
final class C0763g implements Creator<ParcelableObject> {
    C0763g() {
    }

    public ParcelableObject m3030a(Parcel parcel) {
        return new ParcelableObject(parcel);
    }

    public ParcelableObject[] m3031a(int i) {
        return new ParcelableObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3030a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3031a(i);
    }
}
