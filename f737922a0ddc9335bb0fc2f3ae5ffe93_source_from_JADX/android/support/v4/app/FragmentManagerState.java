package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR;
    int[] DW;
    BackStackState[] FH;
    FragmentState[] j6;

    static class 1 implements Creator<FragmentManagerState> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public FragmentManagerState j6(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] j6(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.j6 = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.DW = parcel.createIntArray();
        this.FH = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.j6, i);
        parcel.writeIntArray(this.DW);
        parcel.writeTypedArray(this.FH, i);
    }

    static {
        CREATOR = new 1();
    }
}
