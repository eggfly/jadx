package p000a.p001a.p002a;

import anet.channel.util.HttpConstant;
import com.taobao.accs.ErrorCode;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.android.agoo.message.MessageService;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0127q;
import p000a.C0127q.C0126a;
import p000a.C0135v;
import p000a.C0139x;
import p000a.C0143z;
import p000a.C0143z.C0142a;
import p000a.p001a.C0010a;
import p000a.p001a.C0037c;
import p000a.p001a.p002a.C0005c.C0004a;
import p000a.p001a.p005c.C0028e;
import p000a.p001a.p005c.C0029f;
import p000a.p001a.p005c.C0032h;

/* renamed from: a.a.a.a */
public final class C0002a implements C0001s {
    final C0009e f5a;

    /* renamed from: a.a.a.a.1 */
    class C00001 implements Source {
        boolean f0a;
        final /* synthetic */ BufferedSource f1b;
        final /* synthetic */ C0003b f2c;
        final /* synthetic */ BufferedSink f3d;
        final /* synthetic */ C0002a f4e;

        C00001(C0002a c0002a, BufferedSource bufferedSource, C0003b c0003b, BufferedSink bufferedSink) {
            this.f4e = c0002a;
            this.f1b = bufferedSource;
            this.f2c = c0003b;
            this.f3d = bufferedSink;
        }

        public void close() {
            if (!(this.f0a || C0037c.m164a((Source) this, 100, TimeUnit.MILLISECONDS))) {
                this.f0a = true;
                this.f2c.m8b();
            }
            this.f1b.close();
        }

        public long read(Buffer buffer, long j) {
            try {
                long read = this.f1b.read(buffer, j);
                if (read == -1) {
                    if (!this.f0a) {
                        this.f0a = true;
                        this.f3d.close();
                    }
                    return -1;
                }
                buffer.copyTo(this.f3d.buffer(), buffer.size() - read, read);
                this.f3d.emitCompleteSegments();
                return read;
            } catch (IOException e) {
                if (!this.f0a) {
                    this.f0a = true;
                    this.f2c.m8b();
                }
                throw e;
            }
        }

        public Timeout timeout() {
            return this.f1b.timeout();
        }
    }

    public C0002a(C0009e c0009e) {
        this.f5a = c0009e;
    }

    private C0003b m1a(C0143z c0143z, C0139x c0139x, C0009e c0009e) {
        if (c0009e == null) {
            return null;
        }
        if (C0005c.m15a(c0143z, c0139x)) {
            return c0009e.m25a(c0143z);
        }
        if (!C0029f.m112a(c0139x.m663b())) {
            return null;
        }
        try {
            c0009e.m30b(c0139x);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    private static C0127q m2a(C0127q c0127q, C0127q c0127q2) {
        int i;
        int i2 = 0;
        C0126a c0126a = new C0126a();
        int a = c0127q.m548a();
        for (i = 0; i < a; i++) {
            String a2 = c0127q.m549a(i);
            String b = c0127q.m552b(i);
            if (!("Warning".equalsIgnoreCase(a2) && b.startsWith(MessageService.MSG_DB_NOTIFY_REACHED)) && (!C0002a.m5a(a2) || c0127q2.m550a(a2) == null)) {
                C0010a.f46a.m35a(c0126a, a2, b);
            }
        }
        i = c0127q2.m548a();
        while (i2 < i) {
            String a3 = c0127q2.m549a(i2);
            if (!HttpRequest.f14558k.equalsIgnoreCase(a3) && C0002a.m5a(a3)) {
                C0010a.f46a.m35a(c0126a, a3, c0127q2.m552b(i2));
            }
            i2++;
        }
        return c0126a.m543a();
    }

    private C0143z m3a(C0003b c0003b, C0143z c0143z) {
        if (c0003b == null) {
            return c0143z;
        }
        Sink a = c0003b.m7a();
        if (a == null) {
            return c0143z;
        }
        return c0143z.m701f().m682a(new C0032h(c0143z.m699d(), Okio.buffer(new C00001(this, c0143z.m700e().m130c(), c0003b, Okio.buffer(a))))).m690a();
    }

    private static C0143z m4a(C0143z c0143z) {
        return (c0143z == null || c0143z.m700e() == null) ? c0143z : c0143z.m701f().m682a(null).m690a();
    }

    static boolean m5a(String str) {
        return (HttpConstant.CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpRequest.f14566s.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public C0143z m6a(C0030a c0030a) {
        C0143z c0143z = null;
        C0143z a = this.f5a != null ? this.f5a.m26a(c0030a.m117a()) : c0143z;
        C0005c a2 = new C0004a(System.currentTimeMillis(), c0030a.m117a(), a).m14a();
        C0139x c0139x = a2.f18a;
        C0143z c0143z2 = a2.f19b;
        if (this.f5a != null) {
            this.f5a.m28a(a2);
        }
        if (a != null && c0143z2 == null) {
            C0037c.m160a(a.m700e());
        }
        if (c0139x == null && c0143z2 == null) {
            return new C0142a().m686a(c0030a.m117a()).m685a(C0135v.HTTP_1_1).m680a(504).m688a("Unsatisfiable Request (only-if-cached)").m682a(C0037c.f118c).m681a(-1).m691b(System.currentTimeMillis()).m690a();
        }
        if (c0139x == null) {
            return c0143z2.m701f().m692b(C0002a.m4a(c0143z2)).m690a();
        }
        try {
            c0143z = c0030a.m118a(c0139x);
            if (c0143z2 != null) {
                if (c0143z.m697b() == ErrorCode.DM_PACKAGENAME_INVALID) {
                    a = c0143z2.m701f().m684a(C0002a.m2a(c0143z2.m699d(), c0143z.m699d())).m681a(c0143z.m703h()).m691b(c0143z.m704i()).m692b(C0002a.m4a(c0143z2)).m687a(C0002a.m4a(c0143z)).m690a();
                    c0143z.m700e().close();
                    this.f5a.m27a();
                    this.f5a.m29a(c0143z2, a);
                    return a;
                }
                C0037c.m160a(c0143z2.m700e());
            }
            a = c0143z.m701f().m692b(C0002a.m4a(c0143z2)).m687a(C0002a.m4a(c0143z)).m690a();
            return C0028e.m111b(a) ? m3a(m1a(a, c0143z.m694a(), this.f5a), a) : a;
        } finally {
            if (c0143z == null && a != null) {
                C0037c.m160a(a.m700e());
            }
        }
    }
}
