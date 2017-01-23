package com.facebook.ads.internal.p127e.p129b;

import android.text.TextUtils;
import com.facebook.ads.internal.p127e.p129b.p130a.C2377b;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.e.b.e */
class C2390e extends C2389k {
    private final C2401h f8294a;
    private final C2377b f8295b;
    private C2386b f8296c;

    public C2390e(C2401h c2401h, C2377b c2377b) {
        super(c2401h, c2377b);
        this.f8295b = c2377b;
        this.f8294a = c2401h;
    }

    private void m9197a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        while (true) {
            int a = m9192a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean m9198a(C2388d c2388d) {
        int a = this.f8294a.m9244a();
        boolean z = a > 0;
        int a2 = this.f8295b.m9153a();
        if (z && c2388d.f8285c) {
            if (((float) c2388d.f8284b) > (((float) a) * 0.2f) + ((float) a2)) {
                return false;
            }
        }
        return true;
    }

    private String m9199b(C2388d c2388d) {
        int i = !TextUtils.isEmpty(this.f8294a.m9248c()) ? 1 : 0;
        int a = this.f8295b.m9158d() ? this.f8295b.m9153a() : this.f8294a.m9244a();
        int i2 = a >= 0 ? 1 : 0;
        long j = c2388d.f8285c ? ((long) a) - c2388d.f8284b : (long) a;
        int i3 = (i2 == 0 || !c2388d.f8285c) ? 0 : 1;
        return (c2388d.f8285c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (i2 != 0 ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j)}) : BuildConfig.FLAVOR) + (i3 != 0 ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(c2388d.f8284b), Integer.valueOf(a - 1), Integer.valueOf(a)}) : BuildConfig.FLAVOR) + (i != 0 ? String.format("Content-Type: %s\n", new Object[]{r9}) : BuildConfig.FLAVOR) + "\n";
    }

    private void m9200b(OutputStream outputStream, long j) {
        try {
            C2401h c2401h = new C2401h(this.f8294a);
            c2401h.m9246a((int) j);
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
            while (true) {
                int a = c2401h.m9245a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
                j += (long) a;
            }
            outputStream.flush();
        } finally {
            this.f8294a.m9247b();
        }
    }

    protected void m9201a(int i) {
        if (this.f8296c != null) {
            this.f8296c.m9178a(this.f8295b.f8271a, this.f8294a.f8323a, i);
        }
    }

    public void m9202a(C2386b c2386b) {
        this.f8296c = c2386b;
    }

    public void m9203a(C2388d c2388d, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m9199b(c2388d).getBytes(HttpRequest.f14548a));
        long j = c2388d.f8284b;
        if (m9198a(c2388d)) {
            m9197a(bufferedOutputStream, j);
        } else {
            m9200b(bufferedOutputStream, j);
        }
    }
}
