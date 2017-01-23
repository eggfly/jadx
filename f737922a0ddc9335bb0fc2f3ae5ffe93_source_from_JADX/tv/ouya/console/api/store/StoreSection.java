package tv.ouya.console.api.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class StoreSection implements Parcelable {
    public static final Creator<StoreSection> CREATOR;
    private a DW;
    private List<StoreSection> FH;
    private String j6;

    static class 1 implements Creator<StoreSection> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public StoreSection j6(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(j6(parcel));
            }
            return new StoreSection(readString, readString2, arrayList);
        }

        public StoreSection[] j6(int i) {
            return new StoreSection[i];
        }
    }

    public enum a {
        TAG,
        LIST
    }

    static {
        CREATOR = new 1();
    }

    public StoreSection(String str, String str2, List<StoreSection> list) {
        this.j6 = str;
        this.DW = a.valueOf(str2.toUpperCase());
        this.FH = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreSection)) {
            return false;
        }
        StoreSection storeSection = (StoreSection) obj;
        if (!this.j6.equals(storeSection.j6)) {
            return false;
        }
        if (!this.DW.equals(storeSection.DW)) {
            return false;
        }
        if (this.FH.equals(storeSection.FH)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.j6.hashCode() * 31) + this.DW.hashCode()) * 31) + this.FH.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j6);
        parcel.writeString(this.DW.name().toUpperCase());
        parcel.writeInt(this.FH.size());
        for (int i2 = 0; i2 < this.FH.size(); i2++) {
            ((StoreSection) this.FH.get(i2)).writeToParcel(parcel, i);
        }
    }
}
