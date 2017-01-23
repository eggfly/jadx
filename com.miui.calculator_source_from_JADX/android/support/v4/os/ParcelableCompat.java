package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ParcelableCompat {

    static class CompatCreator<T> implements Creator<T> {
        final ParcelableCompatCreatorCallbacks<T> f635a;

        public CompatCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            this.f635a = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f635a.m1008a(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f635a.m1009a(i);
        }
    }

    public static <T> Creator<T> m1007a(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        if (VERSION.SDK_INT >= 13) {
            return ParcelableCompatCreatorHoneycombMR2Stub.m1010a(parcelableCompatCreatorCallbacks);
        }
        return new CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
