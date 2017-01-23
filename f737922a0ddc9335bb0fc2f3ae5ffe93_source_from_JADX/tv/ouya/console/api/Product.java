package tv.ouya.console.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Product implements Parcelable {
    public static final Creator<Product> CREATOR;
    private String DW;
    private int FH;
    private double Hw;
    private double VH;
    private double Zo;
    private String gn;
    private String j6;
    private int tp;
    private String u7;
    private String v5;

    static class 1 implements Creator<Product> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public Product j6(Parcel parcel) {
            return new Product(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString());
        }

        public Product[] j6(int i) {
            return new Product[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public Product() {
        this.tp = 5;
    }

    public Product(String str, String str2, int i, double d, String str3, double d2, double d3, String str4, String str5) {
        this.tp = 5;
        this.j6 = str;
        this.DW = str2;
        this.FH = i;
        this.Hw = d;
        this.v5 = str3;
        this.Zo = d2;
        this.VH = d3;
        this.gn = str4;
        this.u7 = str5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeInt(this.FH);
        if (this.tp >= 2) {
            parcel.writeDouble(this.Hw);
            parcel.writeString(this.v5);
        }
        if (this.tp >= 3) {
            parcel.writeDouble(this.Zo);
            parcel.writeDouble(this.VH);
        }
        if (this.tp >= 4) {
            parcel.writeString(this.gn);
        }
        if (this.tp >= 5) {
            parcel.writeString(this.u7);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        if (this.FH != product.FH) {
            return false;
        }
        if (!this.DW.equals(product.DW)) {
            return false;
        }
        if (!this.j6.equals(product.j6)) {
            return false;
        }
        if (this.Hw != product.Hw) {
            return false;
        }
        if (this.v5 != null && !this.v5.equals(product.v5)) {
            return false;
        }
        if (this.Zo != product.Zo) {
            return false;
        }
        if (this.VH != product.VH) {
            return false;
        }
        if (!this.gn.equals(product.gn)) {
            return false;
        }
        if (this.u7.equals(product.u7)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((this.j6.hashCode() * 31) + this.DW.hashCode()) * 31) + this.FH) * 31) + Double.valueOf(this.Hw).hashCode();
        if (this.v5 != null) {
            return (hashCode * 31) + this.v5.hashCode();
        }
        return hashCode;
    }
}
