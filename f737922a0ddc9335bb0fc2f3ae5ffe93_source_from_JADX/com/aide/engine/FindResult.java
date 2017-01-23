package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class FindResult implements Parcelable {
    public static final Creator<FindResult> CREATOR;
    public int DW;
    public int FH;
    public int Hw;
    public List<Highlighting> Zo;
    public String j6;
    public String v5;

    static class 1 implements Creator<FindResult> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public FindResult j6(Parcel parcel) {
            return new FindResult(parcel);
        }

        public FindResult[] j6(int i) {
            return new FindResult[i];
        }
    }

    public static class Highlighting implements Parcelable {
        public static final Creator<Highlighting> CREATOR;
        public int DW;
        public int FH;
        public int Hw;
        public int j6;
        public f v5;

        static class 1 implements Creator<Highlighting> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public Highlighting j6(Parcel parcel) {
                return new Highlighting(parcel);
            }

            public Highlighting[] j6(int i) {
                return new Highlighting[i];
            }
        }

        static {
            CREATOR = new 1();
        }

        public Highlighting(Parcel parcel) {
            this.j6 = parcel.readInt();
            this.DW = parcel.readInt();
            this.FH = parcel.readInt();
            this.Hw = parcel.readInt();
            this.v5 = f.values()[parcel.readInt()];
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.j6);
            parcel.writeInt(this.DW);
            parcel.writeInt(this.FH);
            parcel.writeInt(this.Hw);
            parcel.writeInt(this.v5.ordinal());
        }

        public Highlighting(f fVar, int i, int i2, int i3, int i4) {
            this.v5 = fVar;
            this.j6 = i;
            this.DW = i2;
            this.FH = i3;
            this.Hw = i4;
        }
    }

    static {
        CREATOR = new 1();
    }

    public FindResult(Parcel parcel) {
        this.j6 = parcel.readString();
        this.DW = parcel.readInt();
        this.FH = parcel.readInt();
        this.Hw = parcel.readInt();
        this.v5 = parcel.readString();
        this.Zo = new ArrayList();
        parcel.readList(this.Zo, getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        parcel.writeInt(this.DW);
        parcel.writeInt(this.FH);
        parcel.writeInt(this.Hw);
        parcel.writeString(this.v5);
        parcel.writeList(this.Zo);
    }

    public FindResult(String str, String str2, List<Highlighting> list, int i, int i2, int i3) {
        this.Zo = list;
        this.j6 = str;
        this.v5 = str2;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
    }
}
