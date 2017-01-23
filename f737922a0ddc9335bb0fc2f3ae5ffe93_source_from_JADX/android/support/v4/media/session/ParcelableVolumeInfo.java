package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR;
    public int DW;
    public int FH;
    public int Hw;
    public int j6;
    public int v5;

    static class 1 implements Creator<ParcelableVolumeInfo> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public ParcelableVolumeInfo j6(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public ParcelableVolumeInfo[] j6(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.j6 = parcel.readInt();
        this.FH = parcel.readInt();
        this.Hw = parcel.readInt();
        this.v5 = parcel.readInt();
        this.DW = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j6);
        parcel.writeInt(this.FH);
        parcel.writeInt(this.Hw);
        parcel.writeInt(this.v5);
        parcel.writeInt(this.DW);
    }

    static {
        CREATOR = new 1();
    }
}
