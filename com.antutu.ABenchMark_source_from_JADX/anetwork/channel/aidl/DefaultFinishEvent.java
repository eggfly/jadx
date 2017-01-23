package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anetwork.channel.p022b.C0765a;

public class DefaultFinishEvent implements Parcelable {
    public static final Creator<DefaultFinishEvent> CREATOR;
    Object f2439a;
    int f2440b;
    String f2441c;
    C0765a f2442d;

    static {
        CREATOR = new C0757a();
    }

    static DefaultFinishEvent m2990a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent();
        try {
            defaultFinishEvent.f2440b = parcel.readInt();
            defaultFinishEvent.f2441c = parcel.readString();
            try {
                defaultFinishEvent.f2442d = (C0765a) parcel.readSerializable();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
        }
        return defaultFinishEvent;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DefaultFinishEvent [");
        stringBuilder.append("code=").append(this.f2440b);
        stringBuilder.append(", desc=").append(this.f2441c);
        stringBuilder.append(", context=").append(this.f2439a);
        stringBuilder.append(", statisticData=").append(this.f2442d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2440b);
        parcel.writeString(this.f2441c);
        if (this.f2442d != null) {
            parcel.writeSerializable(this.f2442d);
        }
    }
}
