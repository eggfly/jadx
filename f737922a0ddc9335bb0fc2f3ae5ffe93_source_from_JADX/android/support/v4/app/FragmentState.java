package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR;
    final int DW;
    Fragment EQ;
    final boolean FH;
    final int Hw;
    final boolean VH;
    final String Zo;
    final boolean gn;
    final String j6;
    Bundle tp;
    final Bundle u7;
    final int v5;

    static class 1 implements Creator<FragmentState> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public FragmentState j6(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] j6(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.j6 = fragment.getClass().getName();
        this.DW = fragment.QX;
        this.FH = fragment.er;
        this.Hw = fragment.SI;
        this.v5 = fragment.KD;
        this.Zo = fragment.ro;
        this.VH = fragment.cb;
        this.gn = fragment.sh;
        this.u7 = fragment.aM;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.j6 = parcel.readString();
        this.DW = parcel.readInt();
        this.FH = parcel.readInt() != 0;
        this.Hw = parcel.readInt();
        this.v5 = parcel.readInt();
        this.Zo = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.VH = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.gn = z2;
        this.u7 = parcel.readBundle();
        this.tp = parcel.readBundle();
    }

    public Fragment j6(m mVar, Fragment fragment) {
        if (this.EQ != null) {
            return this.EQ;
        }
        Context VH = mVar.VH();
        if (this.u7 != null) {
            this.u7.setClassLoader(VH.getClassLoader());
        }
        this.EQ = Fragment.j6(VH, this.j6, this.u7);
        if (this.tp != null) {
            this.tp.setClassLoader(VH.getClassLoader());
            this.EQ.J8 = this.tp;
        }
        this.EQ.j6(this.DW, fragment);
        this.EQ.er = this.FH;
        this.EQ.gW = true;
        this.EQ.SI = this.Hw;
        this.EQ.KD = this.v5;
        this.EQ.ro = this.Zo;
        this.EQ.cb = this.VH;
        this.EQ.sh = this.gn;
        this.EQ.vy = mVar.Hw;
        if (o.j6) {
            Log.v("FragmentManager", "Instantiated fragment " + this.EQ);
        }
        return this.EQ;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.j6);
        parcel.writeInt(this.DW);
        parcel.writeInt(this.FH ? 1 : 0);
        parcel.writeInt(this.Hw);
        parcel.writeInt(this.v5);
        parcel.writeString(this.Zo);
        if (this.VH) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.gn) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.u7);
        parcel.writeBundle(this.tp);
    }

    static {
        CREATOR = new 1();
    }
}
