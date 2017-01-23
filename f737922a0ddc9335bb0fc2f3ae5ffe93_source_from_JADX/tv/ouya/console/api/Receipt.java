package tv.ouya.console.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Receipt implements Parcelable {
    public static final Creator<Receipt> CREATOR;
    private static final SimpleDateFormat j6;
    private String DW;
    private int FH;
    private Date Hw;
    private double VH;
    private String Zo;
    private String gn;
    private Date u7;
    private String v5;

    static class 1 implements Creator<Receipt> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public Receipt j6(Parcel parcel) {
            return new Receipt(parcel.readString(), parcel.readInt(), new Date(parcel.readLong()), new Date(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readString());
        }

        public Receipt[] j6(int i) {
            return new Receipt[i];
        }
    }

    static {
        j6 = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        j6.setTimeZone(TimeZone.getTimeZone("UTC"));
        CREATOR = new 1();
    }

    public Receipt(String str, int i, Date date, Date date2, String str2, String str3, double d, String str4) {
        this.DW = str;
        this.FH = i;
        this.Hw = date;
        this.u7 = date2;
        this.v5 = str2;
        this.Zo = str3;
        this.VH = d;
        this.gn = str4;
    }

    public String j6() {
        return this.DW;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.DW);
        parcel.writeInt(this.FH);
        parcel.writeLong(this.Hw.getTime());
        parcel.writeLong(this.u7.getTime());
        parcel.writeString(this.v5);
        parcel.writeString(this.Zo);
        parcel.writeDouble(this.VH);
        parcel.writeString(this.gn);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Receipt)) {
            return false;
        }
        Receipt receipt = (Receipt) obj;
        if (!this.DW.equals(receipt.DW)) {
            return false;
        }
        if (this.FH != receipt.FH) {
            return false;
        }
        if (!this.Hw.equals(receipt.Hw)) {
            return false;
        }
        if (!this.v5.equals(receipt.v5)) {
            return false;
        }
        if (!this.Zo.equals(receipt.Zo)) {
            return false;
        }
        if (this.VH != receipt.VH) {
            return false;
        }
        if (this.gn == null || this.gn.equals(receipt.gn)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((this.DW.hashCode() * 31) + this.FH) * 31) + this.Hw.hashCode()) * 31) + this.v5.hashCode()) * 31) + this.Zo.hashCode()) * 31) + Double.valueOf(this.VH).hashCode();
        if (this.gn != null) {
            return (hashCode * 31) + this.gn.hashCode();
        }
        return hashCode;
    }
}
