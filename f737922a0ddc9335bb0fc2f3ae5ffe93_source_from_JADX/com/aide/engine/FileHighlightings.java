package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileHighlightings implements Parcelable {
    public static final Creator<FileHighlightings> CREATOR;
    public f[] DW;
    public int[] FH;
    public int[] Hw;
    public int VH;
    public int[] Zo;
    public int gn;
    public String j6;
    public int[] v5;

    static class 1 implements Creator<FileHighlightings> {
        private FileHighlightings j6;

        1() {
            this.j6 = new FileHighlightings();
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public FileHighlightings j6(Parcel parcel) {
            this.j6.j6(parcel);
            return this.j6;
        }

        public FileHighlightings[] j6(int i) {
            return new FileHighlightings[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public int describeContents() {
        return 0;
    }

    public void j6(Parcel parcel) {
        this.j6 = parcel.readString();
        this.VH = parcel.readInt();
        this.gn = parcel.readInt();
        if (this.DW == null || this.DW.length < this.VH) {
            int i = (this.VH * 5) / 4;
            this.DW = new f[i];
            this.FH = new int[i];
            this.v5 = new int[i];
            this.Hw = new int[i];
            this.Zo = new int[i];
        }
        f[] values = f.values();
        for (i = 0; i < this.VH; i++) {
            byte readByte = parcel.readByte();
            if (readByte == null) {
                this.DW[i] = null;
            } else if ((readByte & 128) == 0) {
                this.DW[i] = values[readByte];
                int readInt = parcel.readInt();
                int[] iArr = this.FH;
                this.v5[i] = readInt;
                iArr[i] = readInt;
                this.Hw[i] = parcel.readByte();
                this.Zo[i] = parcel.readByte();
            } else {
                this.DW[i] = values[readByte & 127];
                this.FH[i] = parcel.readInt();
                this.Hw[i] = parcel.readInt();
                this.v5[i] = parcel.readInt();
                this.Zo[i] = parcel.readInt();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.VH = Math.min(30000, this.VH);
        parcel.writeString(this.j6);
        parcel.writeInt(this.VH);
        parcel.writeInt(this.gn);
        for (int i2 = 0; i2 < this.VH; i2++) {
            f fVar = this.DW[i2];
            if (fVar == null || fVar == f.PLAIN) {
                parcel.writeByte((byte) 0);
            } else {
                int i3 = this.FH[i2];
                int i4 = this.Hw[i2];
                int i5 = this.v5[i2];
                int i6 = this.Zo[i2];
                if (i3 != i5 || i6 >= 127) {
                    parcel.writeByte((byte) (fVar.ordinal() | 128));
                    parcel.writeInt(i3);
                    parcel.writeInt(i4);
                    parcel.writeInt(i5);
                    parcel.writeInt(i6);
                } else {
                    parcel.writeByte((byte) fVar.ordinal());
                    parcel.writeInt(i3);
                    parcel.writeByte((byte) i4);
                    parcel.writeByte((byte) i6);
                }
            }
        }
    }
}
