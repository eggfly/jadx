import android.os.Parcel;
import android.os.Parcelable.Creator;

class h$a<T> implements Creator<T> {
    final i<T> j6;

    public h$a(i<T> iVar) {
        this.j6 = iVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.j6.j6(parcel, null);
    }

    public T[] newArray(int i) {
        return this.j6.j6(i);
    }
}
