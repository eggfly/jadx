package p000a.p001a.p005c;

import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import java.net.ProtocolException;
import okio.BufferedSink;
import okio.Okio;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0139x;
import p000a.C0143z;
import p000a.p001a.C0037c;
import p000a.p001a.p003b.C0020g;

/* renamed from: a.a.c.b */
public final class C0024b implements C0001s {
    private final boolean f94a;

    public C0024b(boolean z) {
        this.f94a = z;
    }

    public C0143z m95a(C0030a c0030a) {
        C0025c c = ((C0031g) c0030a).m124c();
        C0020g b = ((C0031g) c0030a).m123b();
        C0139x a = c0030a.m117a();
        long currentTimeMillis = System.currentTimeMillis();
        c.m99a(a);
        if (C0029f.m114c(a.m663b()) && a.m665d() != null) {
            BufferedSink buffer = Okio.buffer(c.m97a(a, a.m665d().m674b()));
            a.m665d().m673a(buffer);
            buffer.close();
        }
        c.m98a();
        C0143z a2 = c.m100b().m686a(a).m683a(b.m88b().m58c()).m681a(currentTimeMillis).m691b(System.currentTimeMillis()).m690a();
        int b2 = a2.m697b();
        a2 = (this.f94a && b2 == Constants.COMMAND_RECEIVE_DATA) ? a2.m701f().m682a(C0037c.f118c).m690a() : a2.m701f().m682a(c.m96a(a2)).m690a();
        if ("close".equalsIgnoreCase(a2.m694a().m662a(HttpConstant.CONNECTION)) || "close".equalsIgnoreCase(a2.m695a(HttpConstant.CONNECTION))) {
            b.m90d();
        }
        if ((b2 != 204 && b2 != 205) || a2.m700e().m129b() <= 0) {
            return a2;
        }
        throw new ProtocolException("HTTP " + b2 + " had non-zero Content-Length: " + a2.m700e().m129b());
    }
}
