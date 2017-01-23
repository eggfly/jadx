package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

public class ParcelableHeader implements Parcelable {
    public static Creator<ParcelableHeader> f2454c;
    public int f2455a;
    public Map<String, List<String>> f2456b;

    static {
        f2454c = new C0761e();
    }

    ParcelableHeader() {
    }

    static ParcelableHeader m2993a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f2456b = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.f2455a = parcel.readInt();
        } catch (Throwable th) {
            ALog.m2961e("ANet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.f2455a + ", header=" + this.f2456b + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f2456b != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f2456b);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f2455a);
    }
}
