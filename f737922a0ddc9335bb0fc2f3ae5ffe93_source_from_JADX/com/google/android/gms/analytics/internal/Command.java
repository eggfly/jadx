package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR;
    private String DW;
    private String FH;
    private String j6;

    class 1 implements Creator<Command> {
        1() {
        }

        @Deprecated
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        @Deprecated
        public Command j6(Parcel parcel) {
            return new Command(parcel);
        }

        @Deprecated
        public Command[] j6(int i) {
            return new Command[i];
        }

        @Deprecated
        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    static {
        CREATOR = new 1();
    }

    @Deprecated
    Command(Parcel parcel) {
        j6(parcel);
    }

    @Deprecated
    private void j6(Parcel parcel) {
        this.j6 = parcel.readString();
        this.DW = parcel.readString();
        this.FH = parcel.readString();
    }

    public String DW() {
        return this.FH;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String j6() {
        return this.j6;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
    }
}
