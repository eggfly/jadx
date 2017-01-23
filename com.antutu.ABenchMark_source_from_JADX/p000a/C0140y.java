package p000a;

import java.nio.charset.Charset;
import okio.BufferedSink;
import p000a.p001a.C0037c;

/* renamed from: a.y */
public abstract class C0140y {

    /* renamed from: a.y.1 */
    static class C01411 extends C0140y {
        final /* synthetic */ C0131t f634a;
        final /* synthetic */ int f635b;
        final /* synthetic */ byte[] f636c;
        final /* synthetic */ int f637d;

        C01411(C0131t c0131t, int i, byte[] bArr, int i2) {
            this.f634a = c0131t;
            this.f635b = i;
            this.f636c = bArr;
            this.f637d = i2;
        }

        public C0131t m675a() {
            return this.f634a;
        }

        public void m676a(BufferedSink bufferedSink) {
            bufferedSink.write(this.f636c, this.f637d, this.f635b);
        }

        public long m677b() {
            return (long) this.f635b;
        }
    }

    public static C0140y m669a(C0131t c0131t, String str) {
        Charset charset = C0037c.f120e;
        if (c0131t != null) {
            charset = c0131t.m608a();
            if (charset == null) {
                charset = C0037c.f120e;
                c0131t = C0131t.m607a(c0131t + "; charset=utf-8");
            }
        }
        return C0140y.m670a(c0131t, str.getBytes(charset));
    }

    public static C0140y m670a(C0131t c0131t, byte[] bArr) {
        return C0140y.m671a(c0131t, bArr, 0, bArr.length);
    }

    public static C0140y m671a(C0131t c0131t, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C0037c.m159a((long) bArr.length, (long) i, (long) i2);
        return new C01411(c0131t, i2, bArr, i);
    }

    public abstract C0131t m672a();

    public abstract void m673a(BufferedSink bufferedSink);

    public long m674b() {
        return -1;
    }
}
