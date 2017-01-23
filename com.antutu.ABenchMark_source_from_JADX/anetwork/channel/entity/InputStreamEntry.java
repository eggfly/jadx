package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anet.channel.p017a.C0644a;
import anet.channel.p017a.C0646b.C0645a;
import anet.channel.request.BodyEntry;
import anetwork.channel.aidl.C0754f;
import com.taobao.accs.data.Message;
import java.io.IOException;
import java.io.OutputStream;

public class InputStreamEntry implements BodyEntry {
    public static final Creator<InputStreamEntry> CREATOR;
    private C0754f f2509a;

    static {
        CREATOR = new C0771c();
    }

    private InputStreamEntry() {
        this.f2509a = null;
    }

    public int describeContents() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public int writeTo(OutputStream outputStream) {
        int i = 0;
        try {
            C0644a a = C0645a.f2174a.m2763a((int) Message.FLAG_RET);
            while (true) {
                int a2 = this.f2509a.m3002a(a.m2759a());
                if (a2 != -1) {
                    a.m2758a(outputStream);
                    i += a2;
                } else {
                    a.m2762d();
                    return i;
                }
            }
        } catch (Throwable e) {
            throw new IOException("RemoteException", e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.f2509a);
    }
}
