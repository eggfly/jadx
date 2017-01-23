package com.aide.engine;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aide.engine.EngineSolution.File;
import java.util.ArrayList;
import java.util.List;

public class EngineSolutionProject implements Parcelable {
    public static final Creator<EngineSolutionProject> CREATOR;
    final String DW;
    final boolean EQ;
    final String FH;
    final List<File> Hw;
    final boolean J0;
    final boolean J8;
    final List<String> QX;
    final String VH;
    final String Ws;
    final List<String> XL;
    final boolean Zo;
    final List<String> aM;
    final String gn;
    public final String j6;
    final String tp;
    final String u7;
    final List<String> v5;
    final boolean we;

    static class 1 implements Creator<EngineSolutionProject> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public EngineSolutionProject j6(Parcel parcel) {
            return new EngineSolutionProject(parcel);
        }

        public EngineSolutionProject[] j6(int i) {
            return new EngineSolutionProject[i];
        }
    }

    public EngineSolutionProject(String str, String str2, String str3, List<File> list, List<String> list2, boolean z, String str4, String str5, String str6, String str7, boolean z2, boolean z3, boolean z4, boolean z5, String str8, List<String> list3, List<String> list4, List<String> list5) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = list;
        this.v5 = list2;
        this.Zo = z;
        this.VH = str4;
        this.gn = str5;
        this.u7 = str6;
        this.tp = str7;
        this.EQ = z2;
        this.we = z3;
        this.J0 = z4;
        this.J8 = z5;
        this.Ws = str8;
        this.QX = list3;
        this.XL = list4;
        this.aM = list5;
    }

    static {
        CREATOR = new 1();
    }

    public EngineSolutionProject(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.j6 = parcel.readString();
        this.DW = parcel.readString();
        this.FH = parcel.readString();
        this.Zo = parcel.readInt() != 0;
        this.VH = parcel.readString();
        this.gn = parcel.readString();
        this.u7 = parcel.readString();
        this.tp = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.EQ = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.we = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.J0 = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.J8 = z2;
        this.Ws = parcel.readString();
        this.v5 = new ArrayList();
        parcel.readList(this.v5, getClass().getClassLoader());
        this.QX = new ArrayList();
        parcel.readList(this.QX, getClass().getClassLoader());
        this.XL = new ArrayList();
        parcel.readList(this.XL, getClass().getClassLoader());
        this.aM = new ArrayList();
        parcel.readList(this.aM, getClass().getClassLoader());
        this.Hw = new ArrayList();
        parcel.readList(this.Hw, getClass().getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
        parcel.writeInt(this.Zo ? 1 : 0);
        parcel.writeString(this.VH);
        parcel.writeString(this.gn);
        parcel.writeString(this.u7);
        parcel.writeString(this.tp);
        if (this.EQ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.we) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.J0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.J8) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.Ws);
        parcel.writeList(this.v5);
        parcel.writeList(this.QX);
        parcel.writeList(this.XL);
        parcel.writeList(this.aM);
        parcel.writeList(this.Hw);
    }
}
