package com.aide.ui.scm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ModifiedFile implements Parcelable {
    public static final Creator<ModifiedFile> CREATOR;
    public final int DW;
    public final String j6;

    static class 1 implements Creator<ModifiedFile> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public ModifiedFile j6(Parcel parcel) {
            return new ModifiedFile(parcel);
        }

        public ModifiedFile[] j6(int i) {
            return new ModifiedFile[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public ModifiedFile(String str, int i) {
        this.j6 = str;
        this.DW = i;
    }

    public ModifiedFile(Parcel parcel) {
        this.DW = parcel.readInt();
        this.j6 = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.DW);
        parcel.writeString(this.j6);
    }

    public boolean j6() {
        return (this.DW & 1) != 0;
    }

    public boolean DW() {
        return (this.DW & 2) != 0;
    }

    public boolean FH() {
        return (this.DW & 4) != 0;
    }

    public boolean Hw() {
        return (this.DW & 8) != 0;
    }

    public boolean v5() {
        return (this.DW & 16) != 0;
    }

    public boolean Zo() {
        return (this.DW & 32) != 0;
    }

    public boolean VH() {
        return (this.DW & 64) != 0;
    }

    public String gn() {
        StringBuilder stringBuilder = new StringBuilder();
        if (j6()) {
            stringBuilder.append("added, ");
        }
        if (DW()) {
            stringBuilder.append("changed, ");
        }
        if (FH()) {
            stringBuilder.append("removed, ");
        }
        if (Hw()) {
            stringBuilder.append("missing, ");
        }
        if (v5()) {
            stringBuilder.append("modified, ");
        }
        if (Zo()) {
            stringBuilder.append("untracked, ");
        }
        if (VH()) {
            stringBuilder.append("conflicting, ");
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.toString();
    }
}
