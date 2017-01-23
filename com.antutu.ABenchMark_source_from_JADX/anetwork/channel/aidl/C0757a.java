package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.a */
final class C0757a implements Creator<DefaultFinishEvent> {
    C0757a() {
    }

    public DefaultFinishEvent m3014a(Parcel parcel) {
        return DefaultFinishEvent.m2990a(parcel);
    }

    public DefaultFinishEvent[] m3015a(int i) {
        return new DefaultFinishEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3014a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3015a(i);
    }
}
