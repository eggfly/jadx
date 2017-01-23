package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class ParcelableCompatCreatorHoneycombMR2<T> implements ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> f636a;

    public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.f636a = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f636a.m1008a(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f636a.m1008a(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f636a.m1009a(i);
    }
}
