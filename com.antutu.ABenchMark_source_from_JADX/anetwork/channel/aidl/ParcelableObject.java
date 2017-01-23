package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableObject implements Parcelable {
    public static final Creator<ParcelableObject> CREATOR;

    static {
        CREATOR = new C0763g();
    }

    ParcelableObject(Parcel parcel) {
        m2994a(parcel);
    }

    ParcelableObject m2994a(Parcel parcel) {
        return new ParcelableObject();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
