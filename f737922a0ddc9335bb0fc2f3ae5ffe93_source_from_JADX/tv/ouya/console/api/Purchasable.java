package tv.ouya.console.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;

public class Purchasable implements Parcelable {
    public static final Creator<Purchasable> CREATOR;
    private String DW;
    private String FH;
    private String Hw;
    private String j6;

    static class 1 implements Creator<Purchasable> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public Purchasable j6(Parcel parcel) {
            String readString = parcel.readString();
            switch (parcel.readByte()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    return new Purchasable(readString);
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return new Purchasable(readString, parcel.readString(), parcel.readString(), parcel.readString());
                default:
                    throw new IllegalArgumentException("Unable to rebuild purchasable. Encryption data state unknown");
            }
        }

        public Purchasable[] j6(int i) {
            return new Purchasable[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public Purchasable(String str) {
        this.j6 = str;
    }

    public Purchasable(String str, String str2, String str3, String str4) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        if (j6()) {
            parcel.writeByte((byte) 2);
            parcel.writeString(this.DW);
            parcel.writeString(this.FH);
            parcel.writeString(this.Hw);
            return;
        }
        parcel.writeByte((byte) 1);
    }

    public boolean j6() {
        return (this.DW == null || this.FH == null || this.Hw == null) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.j6.equals(((Purchasable) obj).j6);
    }

    public int hashCode() {
        return this.j6.hashCode();
    }
}
