package com.taobao.accs.utl;

import android.support.v4.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* renamed from: com.taobao.accs.utl.g */
public class C4142g extends ByteArrayInputStream {
    public C4142g(byte[] bArr) {
        super(bArr);
    }

    public int m16931a() {
        return read() & MotionEventCompat.ACTION_MASK;
    }

    public String m16932a(int i) {
        byte[] bArr = new byte[i];
        int read = read(bArr);
        if (read == i) {
            return new String(bArr, "utf-8");
        }
        throw new IOException("read len not match. ask for " + i + " but read for " + read);
    }

    public int m16933b() {
        return (m16931a() << 8) | m16931a();
    }

    public byte[] m16934c() {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }
}
