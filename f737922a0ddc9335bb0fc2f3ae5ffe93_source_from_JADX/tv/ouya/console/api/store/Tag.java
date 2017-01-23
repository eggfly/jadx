package tv.ouya.console.api.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Tag implements Parcelable {
    public static final Creator<Tag> CREATOR;
    private String DW;
    private String FH;
    public Boolean j6;

    static class 1 implements Creator<Tag> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public Tag j6(Parcel parcel) {
            boolean z = true;
            String readString = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            return new Tag(readString, Boolean.valueOf(z), parcel.readString());
        }

        public Tag[] j6(int i) {
            return new Tag[i];
        }
    }

    static {
        CREATOR = new 1();
    }

    public Tag(String str, Boolean bool, String str2) {
        this.DW = str;
        this.j6 = bool;
        this.FH = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (!this.DW.equals(tag.DW)) {
            return false;
        }
        if (this.j6 != this.j6) {
            return false;
        }
        if (this.FH.equals(tag.FH)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.DW.hashCode() * 31) + this.j6.hashCode()) * 31) + this.FH.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.DW);
        parcel.writeInt(this.j6.booleanValue() ? 1 : 0);
        parcel.writeString(this.FH);
    }
}
