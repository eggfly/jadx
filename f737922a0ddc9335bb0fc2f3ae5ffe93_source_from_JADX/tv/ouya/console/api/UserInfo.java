package tv.ouya.console.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserInfo implements Parcelable {
    public static final Creator<UserInfo> CREATOR;
    public static final DateFormat j6;
    private String DW;
    private String FH;
    private String Hw;
    private boolean VH;
    private int Zo;
    private boolean gn;
    private Calendar v5;

    static class 1 implements Creator<UserInfo> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }

        public UserInfo j6(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            UserInfo userInfo = new UserInfo();
            userInfo.DW = parcel.readString();
            userInfo.FH = parcel.readString();
            userInfo.Hw = parcel.readString();
            long readLong = parcel.readLong();
            if (readLong > 0) {
                userInfo.v5 = new GregorianCalendar();
                userInfo.v5.setTimeInMillis(readLong);
            }
            userInfo.Zo = parcel.readInt();
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            userInfo.VH = z;
            if (parcel.readByte() != (byte) 1) {
                z2 = false;
            }
            userInfo.gn = z2;
            return userInfo;
        }

        public UserInfo[] j6(int i) {
            return new UserInfo[i];
        }
    }

    static {
        CREATOR = new 1();
        j6 = new SimpleDateFormat("MM/dd/yyyy");
        j6.setLenient(false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (this.FH == null ? userInfo.FH != null : !this.FH.equals(userInfo.FH)) {
            return false;
        }
        if (this.Hw == null ? userInfo.Hw != null : !this.Hw.equals(userInfo.Hw)) {
            return false;
        }
        if (this.DW == null ? userInfo.DW != null : !this.DW.equals(userInfo.DW)) {
            return false;
        }
        if (this.v5 == null ? userInfo.v5 != null : !this.v5.equals(userInfo.v5)) {
            return false;
        }
        if (this.VH != userInfo.VH) {
            return false;
        }
        if (this.gn != userInfo.gn) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.DW != null ? this.DW.hashCode() : 0) * 31;
        if (this.FH != null) {
            hashCode = this.FH.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.Hw != null) {
            hashCode = this.Hw.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.v5 != null) {
            i = this.v5.hashCode();
        }
        return ((((((hashCode + i) * 31) + new Integer(this.Zo).hashCode()) * 31) + Boolean.valueOf(this.VH).hashCode()) * 31) + Boolean.valueOf(this.gn).hashCode();
    }

    public String toString() {
        int i = 1;
        StringBuilder append = new StringBuilder().append("UserInfo{username='").append(this.DW).append('\'').append(", email='").append(this.FH).append('\'').append(", password='").append(this.Hw).append('\'').append(", dateOfBirth='").append(this.v5).append('\'').append(", gender='").append(this.Zo).append('\'').append(", founder='").append(this.VH ? 1 : 0).append('\'').append(", emailOptOut='");
        if (!this.gn) {
            i = 0;
        }
        return append.append(i).append('\'').append('}').toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.DW);
        parcel.writeString(this.FH);
        parcel.writeString(this.Hw);
        parcel.writeLong(this.v5 == null ? 0 : this.v5.getTimeInMillis());
        parcel.writeInt(this.Zo);
        if (this.VH) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.gn) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
