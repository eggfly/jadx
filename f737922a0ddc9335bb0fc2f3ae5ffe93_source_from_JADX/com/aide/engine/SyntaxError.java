package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;

public class SyntaxError implements Parcelable {
    public static final Creator<SyntaxError> CREATOR;
    public int DW;
    public int EQ;
    public int FH;
    public int Hw;
    public boolean J0;
    public int J8;
    public String VH;
    public int Zo;
    public String[] gn;
    public int j6;
    public String tp;
    public String u7;
    public int v5;
    public int we;

    static class 1 implements Creator<SyntaxError> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public SyntaxError j6(Parcel parcel) {
            return new SyntaxError(parcel);
        }

        public SyntaxError[] j6(int i) {
            return new SyntaxError[i];
        }
    }

    public String j6() {
        return this.VH.replace("</C>", "'").replace("<//C>", "'");
    }

    public boolean DW() {
        return this.j6 == 0;
    }

    public boolean FH() {
        return this.j6 == 400;
    }

    public boolean Hw() {
        return this.j6 == 500;
    }

    public String v5() {
        return this.VH;
    }

    public boolean Zo() {
        switch (this.j6) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 250:
            case 251:
                return true;
            default:
                return false;
        }
    }

    static {
        CREATOR = new 1();
    }

    public SyntaxError(Parcel parcel) {
        this.FH = parcel.readInt();
        this.Hw = parcel.readInt();
        this.v5 = parcel.readInt();
        this.Zo = parcel.readInt();
        this.VH = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.gn = new String[readInt];
            parcel.readStringArray(this.gn);
        }
        this.j6 = parcel.readInt();
        this.EQ = parcel.readInt();
        this.we = parcel.readInt();
        this.J0 = parcel.readInt() != 0;
        this.J8 = parcel.readInt();
        this.DW = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeInt(this.FH);
        parcel.writeInt(this.Hw);
        parcel.writeInt(this.v5);
        parcel.writeInt(this.Zo);
        parcel.writeString(this.VH);
        if (this.gn == null || this.gn.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.gn.length);
            parcel.writeStringArray(this.gn);
        }
        parcel.writeInt(this.j6);
        parcel.writeInt(this.EQ);
        parcel.writeInt(this.we);
        if (this.J0) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.J8);
        parcel.writeInt(this.DW);
    }
}
