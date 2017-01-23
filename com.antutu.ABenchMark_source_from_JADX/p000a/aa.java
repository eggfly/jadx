package p000a;

import java.io.Closeable;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import p000a.p001a.C0037c;

/* renamed from: a.aa */
public abstract class aa implements Closeable {

    /* renamed from: a.aa.1 */
    static class C01031 extends aa {
        final /* synthetic */ C0131t f380a;
        final /* synthetic */ long f381b;
        final /* synthetic */ BufferedSource f382c;

        C01031(C0131t c0131t, long j, BufferedSource bufferedSource) {
            this.f380a = c0131t;
            this.f381b = j;
            this.f382c = bufferedSource;
        }

        public C0131t m455a() {
            return this.f380a;
        }

        public long m456b() {
            return this.f381b;
        }

        public BufferedSource m457c() {
            return this.f382c;
        }
    }

    public static aa m125a(C0131t c0131t, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new C01031(c0131t, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }

    public static aa m126a(C0131t c0131t, byte[] bArr) {
        return aa.m125a(c0131t, (long) bArr.length, new Buffer().write(bArr));
    }

    private Charset m127e() {
        C0131t a = m128a();
        return a != null ? a.m609a(C0037c.f120e) : C0037c.f120e;
    }

    public abstract C0131t m128a();

    public abstract long m129b();

    public abstract BufferedSource m130c();

    public void close() {
        C0037c.m160a(m130c());
    }

    public final String m131d() {
        Closeable c = m130c();
        try {
            String readString = c.readString(C0037c.m154a((BufferedSource) c, m127e()));
            return readString;
        } finally {
            C0037c.m160a(c);
        }
    }
}
