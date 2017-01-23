package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR;
    private final float DW;
    private final int j6;

    static class 1 implements Creator<RatingCompat> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public RatingCompat j6(Parcel parcel) {
            return new RatingCompat(parcel.readFloat(), null);
        }

        public RatingCompat[] j6(int i) {
            return new RatingCompat[i];
        }
    }

    private RatingCompat(int i, float f) {
        this.j6 = i;
        this.DW = f;
    }

    public String toString() {
        return "Rating:style=" + this.j6 + " rating=" + (this.DW < 0.0f ? "unrated" : String.valueOf(this.DW));
    }

    public int describeContents() {
        return this.j6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j6);
        parcel.writeFloat(this.DW);
    }

    static {
        CREATOR = new 1();
    }
}
