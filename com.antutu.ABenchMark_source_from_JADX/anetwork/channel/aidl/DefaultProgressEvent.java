package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DefaultProgressEvent implements Parcelable {
    public static final Creator<DefaultProgressEvent> CREATOR;
    int f2443a;
    int f2444b;
    int f2445c;
    String f2446d;
    byte[] f2447e;

    static {
        CREATOR = new C0758b();
    }

    public static DefaultProgressEvent m2991a(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f2443a = parcel.readInt();
            defaultProgressEvent.f2444b = parcel.readInt();
            defaultProgressEvent.f2445c = parcel.readInt();
            defaultProgressEvent.f2446d = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f2447e = bArr;
            }
        } catch (Exception e) {
        }
        return defaultProgressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f2443a + ", size=" + this.f2444b + ", total=" + this.f2445c + ", desc=" + this.f2446d + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2443a);
        parcel.writeInt(this.f2444b);
        parcel.writeInt(this.f2445c);
        parcel.writeString(this.f2446d);
        parcel.writeInt(this.f2447e != null ? this.f2447e.length : 0);
        parcel.writeByteArray(this.f2447e);
    }
}
