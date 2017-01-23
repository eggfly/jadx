package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import anet.channel.p017a.C0644a;
import anet.channel.p017a.C0646b.C0645a;
import anet.channel.request.BodyEntry;
import anetwork.channel.aidl.C0751d;
import com.taobao.accs.data.Message;
import java.io.IOException;
import java.io.OutputStream;

public class BodyHandlerEntry implements BodyEntry {
    public static final Creator<BodyHandlerEntry> CREATOR;
    C0751d f2508a;

    static {
        CREATOR = new C0770b();
    }

    private BodyHandlerEntry() {
        this.f2508a = null;
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
            while (!this.f2508a.m2997a()) {
                int a2 = this.f2508a.m2996a(a.m2759a());
                outputStream.write(a.m2759a(), 0, a2);
                i += a2;
            }
            a.m2762d();
            return i;
        } catch (Throwable e) {
            throw new IOException("RemoteException", e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.f2508a);
    }
}
