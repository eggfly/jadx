package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.util.ALog;
import anetwork.channel.p022b.C0765a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import java.util.Map;

public class NetworkResponse implements Parcelable {
    public static final Creator<NetworkResponse> CREATOR;
    int f2448a;
    byte[] f2449b;
    private String f2450c;
    private Map<String, List<String>> f2451d;
    private Throwable f2452e;
    private C0765a f2453f;

    static {
        CREATOR = new C0759c();
    }

    public static NetworkResponse m2992a(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f2448a = parcel.readInt();
            networkResponse.f2450c = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                networkResponse.f2449b = new byte[readInt];
                parcel.readByteArray(networkResponse.f2449b);
            }
            networkResponse.f2451d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f2453f = (C0765a) parcel.readSerializable();
            } catch (Throwable th) {
                ALog.m2963i("ANet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Throwable e) {
            ALog.m2964w("ANet.NetworkResponse", "[readFromParcel]", null, e, new Object[0]);
        }
        return networkResponse;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkResponse [");
        stringBuilder.append("statusCode=").append(this.f2448a);
        stringBuilder.append(", desc=").append(this.f2450c);
        stringBuilder.append(", connHeadFields=").append(this.f2451d);
        stringBuilder.append(", bytedata=").append(this.f2449b != null ? new String(this.f2449b) : BuildConfig.FLAVOR);
        stringBuilder.append(", error=").append(this.f2452e);
        stringBuilder.append(", statisticData=").append(this.f2453f).append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2448a);
        parcel.writeString(this.f2450c);
        int i2 = 0;
        if (this.f2449b != null) {
            i2 = this.f2449b.length;
        }
        parcel.writeInt(i2);
        if (i2 > 0) {
            parcel.writeByteArray(this.f2449b);
        }
        parcel.writeMap(this.f2451d);
        if (this.f2453f != null) {
            parcel.writeSerializable(this.f2453f);
        }
    }
}
