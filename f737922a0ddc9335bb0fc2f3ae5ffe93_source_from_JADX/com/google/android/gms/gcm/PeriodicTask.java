package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR;
    protected long DW;
    protected long j6;

    class 1 implements Creator<PeriodicTask> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public PeriodicTask j6(Parcel parcel) {
            return new PeriodicTask(null);
        }

        public PeriodicTask[] j6(int i) {
            return new PeriodicTask[i];
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    static {
        CREATOR = new 1();
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.j6 = -1;
        this.DW = -1;
        this.j6 = parcel.readLong();
        this.DW = Math.min(parcel.readLong(), this.j6);
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
        return new StringBuilder(String.valueOf(valueOf).length() + 54).append(valueOf).append(" period=").append(j6).append(" flex=").append(DW()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.j6);
        parcel.writeLong(this.DW);
    }
}
