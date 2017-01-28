import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class j<T> implements ClassLoaderCreator<T> {
    private final i<T> j6;

    public j(i<T> iVar) {
        this.j6 = iVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.j6.j6(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.j6.j6(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.j6.j6(i);
    }
}
