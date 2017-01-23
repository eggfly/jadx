package com.aide.ui.scm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GitConfiguration implements Parcelable {
    public static final Creator<GitConfiguration> CREATOR;
    public final String DW;
    public final String FH;
    public final boolean Hw;
    public final String j6;

    static class 1 implements Creator<GitConfiguration> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public GitConfiguration j6(Parcel parcel) {
            return new GitConfiguration(parcel);
        }

        public GitConfiguration[] j6(int i) {
            return new GitConfiguration[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public GitConfiguration(String str, String str2, String str3, boolean z) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = z;
    }

    public GitConfiguration(Parcel parcel) {
        this.j6 = parcel.readString();
        this.DW = parcel.readString();
        this.FH = parcel.readString();
        this.Hw = parcel.readByte() != null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
        parcel.writeByte(this.Hw ? (byte) 1 : (byte) 0);
    }
}
