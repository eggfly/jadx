package tv.ouya.console.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CreditCardInfo implements Parcelable {
    public static final Creator<CreditCardInfo> CREATOR;
    private String DW;
    private String FH;
    private String Hw;
    private boolean Zo;
    private double j6;
    private String v5;

    static class 1 implements Creator<CreditCardInfo> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public CreditCardInfo j6(Parcel parcel) {
            boolean z = true;
            double readDouble = parcel.readDouble();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            return new CreditCardInfo(readDouble, readString, readString2, readString3, readString4, z);
        }

        public CreditCardInfo[] j6(int i) {
            return new CreditCardInfo[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public CreditCardInfo(double d, String str, String str2, String str3, String str4, boolean z) {
        this.j6 = d;
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        this.v5 = str4;
        this.Zo = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.j6);
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
        parcel.writeString(this.Hw);
        parcel.writeString(this.v5);
        parcel.writeInt(this.Zo ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreditCardInfo)) {
            return false;
        }
        CreditCardInfo creditCardInfo = (CreditCardInfo) obj;
        if (this.j6 != creditCardInfo.j6) {
            return false;
        }
        if (!this.DW.equals(creditCardInfo.DW)) {
            return false;
        }
        if (!this.FH.equals(creditCardInfo.FH)) {
            return false;
        }
        if (!this.Hw.equals(creditCardInfo.Hw)) {
            return false;
        }
        if (!this.v5.equals(creditCardInfo.v5)) {
            return false;
        }
        if (this.Zo != creditCardInfo.Zo) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Double.valueOf(this.j6).hashCode();
        if (this.DW != null) {
            hashCode = (hashCode * 31) + this.DW.hashCode();
        }
        if (this.FH != null) {
            hashCode = (hashCode * 31) + this.FH.hashCode();
        }
        if (this.Hw != null) {
            hashCode = (hashCode * 31) + this.Hw.hashCode();
        }
        if (this.v5 != null) {
            return (hashCode * 31) + this.v5.hashCode();
        }
        return hashCode;
    }
}
