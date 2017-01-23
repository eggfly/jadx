package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: anetwork.channel.aidl.b */
final class C0758b implements Creator<DefaultProgressEvent> {
    C0758b() {
    }

    public DefaultProgressEvent m3016a(Parcel parcel) {
        return DefaultProgressEvent.m2991a(parcel);
    }

    public DefaultProgressEvent[] m3017a(int i) {
        return new DefaultProgressEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3016a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3017a(i);
    }
}
