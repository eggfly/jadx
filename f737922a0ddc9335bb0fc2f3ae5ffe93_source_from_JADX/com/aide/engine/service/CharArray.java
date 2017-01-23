package com.aide.engine.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CharArray implements Parcelable {
    public static final Creator<CharArray> CREATOR;
    public int DW;
    public char[] j6;

    static class 1 implements Creator<CharArray> {
        private CharArray j6;

        1() {
            this.j6 = new CharArray();
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public CharArray j6(Parcel parcel) {
            this.j6.j6(parcel);
            return this.j6;
        }

        public CharArray[] j6(int i) {
            return new CharArray[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public CharArray(int i) {
        this.j6 = new char[i];
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.DW);
        int i2 = this.DW;
        char[] cArr = this.j6;
        for (int i3 = 0; i3 < i2; i3++) {
            parcel.writeInt(cArr[i3]);
        }
    }

    public void j6(Parcel parcel) {
        this.DW = parcel.readInt();
        if (this.j6 == null || this.j6.length < this.DW) {
            this.j6 = new char[Math.max(10000, (this.DW * 5) / 4)];
        }
        int i = this.DW;
        char[] cArr = this.j6;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }
}
