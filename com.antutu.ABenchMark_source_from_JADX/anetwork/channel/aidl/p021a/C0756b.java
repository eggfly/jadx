package anetwork.channel.aidl.p021a;

import android.os.RemoteException;
import anetwork.channel.aidl.C0754f.C0755a;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: anetwork.channel.aidl.a.b */
public class C0756b extends C0755a {
    private InputStream f2474a;

    public int m3008a() {
        try {
            return this.f2474a.available();
        } catch (IOException e) {
            throw new RemoteException("IO Exception");
        }
    }

    public int m3009a(byte[] bArr) {
        try {
            return this.f2474a.read(bArr);
        } catch (IOException e) {
            throw new RemoteException("IO Exception");
        }
    }

    public long m3010a(int i) {
        try {
            return this.f2474a.skip((long) i);
        } catch (IOException e) {
            throw new RemoteException("IO Exception");
        }
    }

    public void m3011b() {
        try {
            this.f2474a.close();
        } catch (IOException e) {
            throw new RemoteException("IO Exception");
        }
    }

    public int m3012c() {
        try {
            return this.f2474a.read();
        } catch (IOException e) {
            throw new RemoteException("IO Exception");
        }
    }

    public int m3013d() {
        return 0;
    }
}
