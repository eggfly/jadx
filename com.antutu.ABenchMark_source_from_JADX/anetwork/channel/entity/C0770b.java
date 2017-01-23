package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anetwork.channel.aidl.C0751d.C0752a;

/* renamed from: anetwork.channel.entity.b */
final class C0770b implements Creator<BodyHandlerEntry> {
    C0770b() {
    }

    public BodyHandlerEntry m3052a(Parcel parcel) {
        BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry();
        bodyHandlerEntry.f2508a = C0752a.m2998a(parcel.readStrongBinder());
        return bodyHandlerEntry;
    }

    public BodyHandlerEntry[] m3053a(int i) {
        return new BodyHandlerEntry[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3052a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3053a(i);
    }
}
