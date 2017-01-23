package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR;
    public int f595a;
    public int f596b;
    public int f597c;
    public int f598d;
    public int f599e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo.1 */
    final class C00611 implements Creator<ParcelableVolumeInfo> {
        C00611() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m960a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m961a(i);
        }

        public ParcelableVolumeInfo m960a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public ParcelableVolumeInfo[] m961a(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(int i, int i2, int i3, int i4, int i5) {
        this.f595a = i;
        this.f596b = i2;
        this.f597c = i3;
        this.f598d = i4;
        this.f599e = i5;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f595a = parcel.readInt();
        this.f597c = parcel.readInt();
        this.f598d = parcel.readInt();
        this.f599e = parcel.readInt();
        this.f596b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f595a);
        parcel.writeInt(this.f597c);
        parcel.writeInt(this.f598d);
        parcel.writeInt(this.f599e);
        parcel.writeInt(this.f596b);
    }

    static {
        CREATOR = new C00611();
    }
}
