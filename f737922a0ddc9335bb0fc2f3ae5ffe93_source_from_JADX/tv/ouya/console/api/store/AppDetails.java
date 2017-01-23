package tv.ouya.console.api.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import tv.ouya.console.api.Product;

public final class AppDetails implements Parcelable {
    public static final Creator<AppDetails> CREATOR;
    public String DW;
    public String EQ;
    public String FH;
    public String Hw;
    public boolean J0;
    public String J8;
    public int Mr;
    public boolean QX;
    public String VH;
    public boolean Ws;
    public String XL;
    public String Zo;
    public Product aM;
    public List<String> gn;
    public double j3;
    public String j6;
    public String tp;
    public Long u7;
    public Long v5;
    public String we;

    static class 1 implements Creator<AppDetails> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public AppDetails j6(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Long valueOf = Long.valueOf(parcel.readLong());
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            List arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            Long valueOf2 = Long.valueOf(parcel.readLong());
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            Boolean valueOf3 = Boolean.valueOf(parcel.readByte() == 1);
            String readString10 = parcel.readString();
            Boolean valueOf4 = Boolean.valueOf(parcel.readByte() == 1);
            Boolean valueOf5 = Boolean.valueOf(parcel.readByte() == 1);
            String readString11 = parcel.readString();
            Product product = null;
            if ((parcel.readInt() == 1 ? 1 : null) != null) {
                product = (Product) Product.CREATOR.createFromParcel(parcel);
            }
            return new AppDetails(readString, readString2, readString3, readString4, valueOf, readString5, readString6, arrayList, valueOf2, readString7, readString8, readString9, valueOf3, readString10, valueOf4, valueOf5, readString11, product, parcel.readDouble(), parcel.readInt());
        }

        public AppDetails[] j6(int i) {
            return new AppDetails[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public AppDetails() {
        this.gn = new ArrayList();
    }

    public AppDetails(String str, String str2, String str3, String str4, Long l, String str5, String str6, List<String> list, Long l2, String str7, String str8, String str9, Boolean bool, String str10, Boolean bool2, Boolean bool3, String str11, Product product, double d, int i) {
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = str4;
        this.v5 = l;
        this.Zo = str5;
        this.VH = str6;
        this.gn = list;
        this.u7 = l2;
        this.tp = str7;
        this.EQ = str8;
        this.we = str9;
        this.J0 = bool.booleanValue();
        this.J8 = str10;
        this.Ws = bool2.booleanValue();
        this.QX = bool3.booleanValue();
        this.XL = str11;
        this.aM = product;
        this.j3 = d;
        this.Mr = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppDetails)) {
            return false;
        }
        AppDetails appDetails = (AppDetails) obj;
        if (!this.DW.equals(appDetails.DW)) {
            return false;
        }
        if (!this.FH.equals(appDetails.FH)) {
            return false;
        }
        if (!this.j6.equals(appDetails.j6)) {
            return false;
        }
        if (!this.Hw.equals(appDetails.Hw)) {
            return false;
        }
        if (!this.v5.equals(appDetails.v5)) {
            return false;
        }
        if (!this.Zo.equals(appDetails.Zo)) {
            return false;
        }
        if (!this.VH.equals(appDetails.VH)) {
            return false;
        }
        if (!this.u7.equals(appDetails.u7)) {
            return false;
        }
        if (!this.tp.equals(appDetails.tp)) {
            return false;
        }
        if (!this.EQ.equals(appDetails.EQ)) {
            return false;
        }
        if (!this.we.equals(appDetails.we)) {
            return false;
        }
        if (this.J0 != appDetails.J0) {
            return false;
        }
        if (!this.J8.equals(appDetails.J8)) {
            return false;
        }
        if (this.Ws != appDetails.Ws) {
            return false;
        }
        if (this.QX != appDetails.QX) {
            return false;
        }
        if (this.XL == null) {
            if (appDetails.XL != null) {
                return false;
            }
        } else if (!this.XL.equals(appDetails.XL)) {
            return false;
        }
        if (this.aM == null) {
            if (appDetails.aM != null) {
                return false;
            }
        } else if (!this.aM.equals(appDetails.aM)) {
            return false;
        }
        if (this.j3 != appDetails.j3) {
            return false;
        }
        if (this.Mr != appDetails.Mr) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.j6.hashCode() * 31) + this.DW.hashCode()) * 31) + this.FH.hashCode()) * 31) + this.Hw.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        parcel.writeString(this.j6);
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
        parcel.writeString(this.Hw);
        parcel.writeLong(this.v5.longValue());
        parcel.writeString(this.Zo);
        parcel.writeString(this.VH);
        parcel.writeStringList(this.gn);
        parcel.writeLong(this.u7.longValue());
        parcel.writeString(this.tp);
        parcel.writeString(this.EQ);
        parcel.writeString(this.we);
        parcel.writeByte(this.J0 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.J8);
        if (this.Ws) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.QX) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.XL);
        if (this.aM == null) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.aM != null) {
            this.aM.writeToParcel(parcel, i);
        }
        parcel.writeDouble(this.j3);
        parcel.writeInt(this.Mr);
    }
}
