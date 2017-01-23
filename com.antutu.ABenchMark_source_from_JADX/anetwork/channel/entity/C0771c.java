package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anetwork.channel.aidl.C0754f.C0755a;

/* renamed from: anetwork.channel.entity.c */
final class C0771c implements Creator<InputStreamEntry> {
    C0771c() {
    }

    public InputStreamEntry m3054a(Parcel parcel) {
        InputStreamEntry inputStreamEntry = new InputStreamEntry();
        inputStreamEntry.f2509a = C0755a.m3007a(parcel.readStrongBinder());
        return inputStreamEntry;
    }

    public InputStreamEntry[] m3055a(int i) {
        return new InputStreamEntry[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3054a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3055a(i);
    }
}
