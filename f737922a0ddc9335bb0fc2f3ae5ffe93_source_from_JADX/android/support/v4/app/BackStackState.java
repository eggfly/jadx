package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR;
    final int DW;
    final ArrayList<String> EQ;
    final int FH;
    final String Hw;
    final CharSequence VH;
    final int Zo;
    final int gn;
    final int[] j6;
    final ArrayList<String> tp;
    final CharSequence u7;
    final int v5;

    static class 1 implements Creator<BackStackState> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public BackStackState j6(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] j6(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(g gVar) {
        int i = 0;
        for (a aVar = gVar.FH; aVar != null; aVar = aVar.j6) {
            if (aVar.u7 != null) {
                i += aVar.u7.size();
            }
        }
        this.j6 = new int[(i + (gVar.v5 * 7))];
        if (gVar.we) {
            i = 0;
            for (a aVar2 = gVar.FH; aVar2 != null; aVar2 = aVar2.j6) {
                int i2 = i + 1;
                this.j6[i] = aVar2.FH;
                int i3 = i2 + 1;
                this.j6[i2] = aVar2.Hw != null ? aVar2.Hw.QX : -1;
                int i4 = i3 + 1;
                this.j6[i3] = aVar2.v5;
                i2 = i4 + 1;
                this.j6[i4] = aVar2.Zo;
                i4 = i2 + 1;
                this.j6[i2] = aVar2.VH;
                i2 = i4 + 1;
                this.j6[i4] = aVar2.gn;
                if (aVar2.u7 != null) {
                    int size = aVar2.u7.size();
                    i4 = i2 + 1;
                    this.j6[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.j6[i4] = ((Fragment) aVar2.u7.get(i2)).QX;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.j6[i2] = 0;
                }
            }
            this.DW = gVar.tp;
            this.FH = gVar.EQ;
            this.Hw = gVar.J8;
            this.v5 = gVar.QX;
            this.Zo = gVar.XL;
            this.VH = gVar.aM;
            this.gn = gVar.j3;
            this.u7 = gVar.Mr;
            this.tp = gVar.U2;
            this.EQ = gVar.a8;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.j6 = parcel.createIntArray();
        this.DW = parcel.readInt();
        this.FH = parcel.readInt();
        this.Hw = parcel.readString();
        this.v5 = parcel.readInt();
        this.Zo = parcel.readInt();
        this.VH = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.gn = parcel.readInt();
        this.u7 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.tp = parcel.createStringArrayList();
        this.EQ = parcel.createStringArrayList();
    }

    public g j6(o oVar) {
        g gVar = new g(oVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.j6.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.FH = this.j6[i2];
            if (o.j6) {
                Log.v("FragmentManager", "Instantiate " + gVar + " op #" + i + " base fragment #" + this.j6[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.j6[i3];
            if (i2 >= 0) {
                aVar.Hw = (Fragment) oVar.Zo.get(i2);
            } else {
                aVar.Hw = null;
            }
            i3 = i4 + 1;
            aVar.v5 = this.j6[i4];
            i4 = i3 + 1;
            aVar.Zo = this.j6[i3];
            i3 = i4 + 1;
            aVar.VH = this.j6[i4];
            int i5 = i3 + 1;
            aVar.gn = this.j6[i3];
            i4 = i5 + 1;
            int i6 = this.j6[i5];
            if (i6 > 0) {
                aVar.u7 = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (o.j6) {
                        Log.v("FragmentManager", "Instantiate " + gVar + " set remove fragment #" + this.j6[i4]);
                    }
                    i5 = i4 + 1;
                    aVar.u7.add((Fragment) oVar.Zo.get(this.j6[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            gVar.j6(aVar);
            i++;
            i2 = i4;
        }
        gVar.tp = this.DW;
        gVar.EQ = this.FH;
        gVar.J8 = this.Hw;
        gVar.QX = this.v5;
        gVar.we = true;
        gVar.XL = this.Zo;
        gVar.aM = this.VH;
        gVar.j3 = this.gn;
        gVar.Mr = this.u7;
        gVar.U2 = this.tp;
        gVar.a8 = this.EQ;
        gVar.j6(1);
        return gVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.j6);
        parcel.writeInt(this.DW);
        parcel.writeInt(this.FH);
        parcel.writeString(this.Hw);
        parcel.writeInt(this.v5);
        parcel.writeInt(this.Zo);
        TextUtils.writeToParcel(this.VH, parcel, 0);
        parcel.writeInt(this.gn);
        TextUtils.writeToParcel(this.u7, parcel, 0);
        parcel.writeStringList(this.tp);
        parcel.writeStringList(this.EQ);
    }

    static {
        CREATOR = new 1();
    }
}
