package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR;
    private final long DW;
    private final long j6;

    class 1 implements Creator<OneoffTask> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public OneoffTask j6(Parcel parcel) {
            return new OneoffTask(null);
        }

        public OneoffTask[] j6(int i) {
            return new OneoffTask[i];
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    static {
        CREATOR = new 1();
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.j6 = parcel.readLong();
        this.DW = parcel.readLong();
    }

    public long DW() {
        return this.DW;
    }

    public long j6() {
        return this.j6;
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long j6 = j6();
        return new StringBuilder(String.valueOf(valueOf).length() + 64).append(valueOf).append(" windowStart=").append(j6).append(" windowEnd=").append(DW()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.j6);
        parcel.writeLong(this.DW);
    }
}
