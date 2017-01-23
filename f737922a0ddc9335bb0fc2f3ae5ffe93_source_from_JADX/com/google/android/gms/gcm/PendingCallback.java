package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR;
    final IBinder j6;

    class 1 implements Creator<PendingCallback> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public PendingCallback j6(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public PendingCallback[] j6(int i) {
            return new PendingCallback[i];
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    static {
        CREATOR = new 1();
    }

    public PendingCallback(Parcel parcel) {
        this.j6 = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.j6);
    }
}
