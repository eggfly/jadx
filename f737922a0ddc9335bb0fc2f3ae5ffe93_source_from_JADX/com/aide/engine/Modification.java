package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;

public class Modification implements Parcelable {
    public static final Creator<Modification> CREATOR;
    private int DW;
    private boolean EQ;
    private int FH;
    private int Hw;
    private int J0;
    private int VH;
    private int Zo;
    private String gn;
    private int j6;
    private String tp;
    private String u7;
    private int v5;
    private int we;

    static class 1 implements Creator<Modification> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public Modification j6(Parcel parcel) {
            return new Modification(parcel);
        }

        public Modification[] j6(int i) {
            return new Modification[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public Modification(Parcel parcel) {
        this.j6 = parcel.readInt();
        this.DW = parcel.readInt();
        this.FH = parcel.readInt();
        this.Hw = parcel.readInt();
        this.v5 = parcel.readInt();
        this.Zo = parcel.readInt();
        this.VH = parcel.readInt();
        this.gn = parcel.readString();
        this.u7 = parcel.readString();
        this.tp = parcel.readString();
        this.EQ = parcel.readInt() != 0;
        this.we = parcel.readInt();
        this.J0 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j6);
        parcel.writeInt(this.DW);
        parcel.writeInt(this.FH);
        parcel.writeInt(this.Hw);
        parcel.writeInt(this.v5);
        parcel.writeInt(this.Zo);
        parcel.writeInt(this.VH);
        parcel.writeString(this.gn);
        parcel.writeString(this.u7);
        parcel.writeString(this.tp);
        parcel.writeInt(this.EQ ? 1 : 0);
        parcel.writeInt(this.we);
        parcel.writeInt(this.J0);
    }

    protected Modification(String str, int i, int i2, int i3) {
        this.j6 = 11;
        this.gn = str;
        this.DW = i;
        this.we = i2;
        this.J0 = i3;
    }

    protected Modification(String str, String str2, boolean z) {
        this.j6 = 4;
        this.gn = str;
        this.tp = str2;
    }

    protected Modification(String str, String str2) {
        this.j6 = 1;
        this.gn = str;
        this.u7 = str2;
    }

    protected Modification(String str, String str2, int i) {
        this.j6 = 12;
        this.gn = str;
        this.u7 = str2;
    }

    protected Modification(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        this.j6 = 3;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.gn = str;
        this.Zo = i5;
        this.VH = i6;
    }

    protected Modification(int i, int i2, int i3, int i4, String str, int i5, int i6, boolean z) {
        this.j6 = 7;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.gn = str;
        this.Zo = i5;
        this.VH = i6;
    }

    protected Modification(int i, int i2, String str) {
        this.j6 = 2;
        this.DW = i;
        this.Hw = i2;
        this.gn = str;
    }

    protected Modification(int i, int i2, int i3, int i4, String str, String str2, boolean z) {
        this.j6 = 0;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.gn = str;
        this.u7 = str2;
        this.EQ = z;
    }

    protected Modification(int i, int i2, int i3, int i4, String str) {
        this.j6 = 8;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.gn = str;
    }

    protected Modification(int i, int i2, int i3, int i4, String str, boolean z) {
        this.j6 = 10;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.gn = str;
    }

    protected Modification(int i, int i2, String str, boolean z) {
        this.j6 = 9;
        this.Zo = i;
        this.VH = i2;
        this.gn = str;
    }

    public int j6() {
        return this.we;
    }

    public boolean DW() {
        return this.EQ;
    }

    public int FH() {
        return this.j6;
    }

    public String Hw() {
        return this.gn;
    }

    public String v5() {
        return this.u7;
    }

    public int Zo() {
        return this.DW;
    }

    public int VH() {
        return this.FH;
    }

    public int gn() {
        return this.Hw;
    }

    public int u7() {
        return this.v5;
    }

    public int tp() {
        return this.Zo;
    }

    public int EQ() {
        return this.VH;
    }

    public String toString() {
        switch (this.j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return "[REPLACE_TEXT_REGION(" + this.gn + ":" + this.DW + ":" + this.FH + ":" + this.Hw + ":" + this.v5 + ")to(" + this.u7 + ")]";
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "[RENAME_FILE_OR_DIRECTORY(" + this.gn + ")to(" + this.u7 + ")]";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "[MOVE_DIRECTORY_TREE_OR_FILE(" + this.gn + ")to(" + this.tp + ")]";
            case 6:
                return "[COPY_FILE(" + this.gn + ")to(" + this.tp + ")as(" + this.u7 + ")]";
            case 11:
                return "[INDENT_LINE(" + this.gn + ":" + this.DW + " to " + this.we + ")]";
            default:
                return "";
        }
    }
}
