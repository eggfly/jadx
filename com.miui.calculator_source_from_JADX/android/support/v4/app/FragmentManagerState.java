package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR;
    FragmentState[] f241a;
    int[] f242b;
    BackStackState[] f243c;

    /* renamed from: android.support.v4.app.FragmentManagerState.1 */
    final class C00201 implements Creator<FragmentManagerState> {
        C00201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m377a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m378a(i);
        }

        public FragmentManagerState m377a(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] m378a(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f241a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f242b = parcel.createIntArray();
        this.f243c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f241a, i);
        parcel.writeIntArray(this.f242b);
        parcel.writeTypedArray(this.f243c, i);
    }

    static {
        CREATOR = new C00201();
    }
}
