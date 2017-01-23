package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder j6;

    class 1 implements Creator<BinderWrapper> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public BinderWrapper j6(Parcel parcel) {
            return new BinderWrapper(null);
        }

        public BinderWrapper[] j6(int i) {
            return new BinderWrapper[i];
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    static {
        CREATOR = new 1();
    }

    public BinderWrapper() {
        this.j6 = null;
    }

    private BinderWrapper(Parcel parcel) {
        this.j6 = null;
        this.j6 = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.j6);
    }
}
