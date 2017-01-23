package p000a.p001a.p005c;

import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.apache.http.entity.mime.MIME;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0119l;
import p000a.C0120m;
import p000a.C0127q;
import p000a.C0131t;
import p000a.C0139x;
import p000a.C0139x.C0138a;
import p000a.C0140y;
import p000a.C0143z;
import p000a.C0143z.C0142a;
import p000a.p001a.C0037c;
import p000a.p001a.C0046d;

/* renamed from: a.a.c.a */
public final class C0023a implements C0001s {
    private final C0120m f93a;

    public C0023a(C0120m c0120m) {
        this.f93a = c0120m;
    }

    private String m93a(List<C0119l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            C0119l c0119l = (C0119l) list.get(i);
            stringBuilder.append(c0119l.m520a()).append('=').append(c0119l.m522b());
        }
        return stringBuilder.toString();
    }

    public C0143z m94a(C0030a c0030a) {
        boolean z = false;
        C0139x a = c0030a.m117a();
        C0138a e = a.m666e();
        C0140y d = a.m665d();
        if (d != null) {
            C0131t a2 = d.m672a();
            if (a2 != null) {
                e.m658a(MIME.CONTENT_TYPE, a2.toString());
            }
            long b = d.m674b();
            if (b != -1) {
                e.m658a(HttpRequest.f14558k, Long.toString(b));
                e.m660b("Transfer-Encoding");
            } else {
                e.m658a("Transfer-Encoding", "chunked");
                e.m660b(HttpRequest.f14558k);
            }
        }
        if (a.m662a(HttpConstant.HOST) == null) {
            e.m658a(HttpConstant.HOST, C0037c.m151a(a.m661a(), false));
        }
        if (a.m662a(HttpConstant.CONNECTION) == null) {
            e.m658a(HttpConstant.CONNECTION, "Keep-Alive");
        }
        if (a.m662a(HttpRequest.f14554g) == null) {
            z = true;
            e.m658a(HttpRequest.f14554g, HttpRequest.f14551d);
        }
        List a3 = this.f93a.m523a(a.m661a());
        if (!a3.isEmpty()) {
            e.m658a("Cookie", m93a(a3));
        }
        if (a.m662a(HttpRequest.f14569v) == null) {
            e.m658a(HttpRequest.f14569v, C0046d.m189a());
        }
        C0143z a4 = c0030a.m118a(e.m659a());
        C0028e.m109a(this.f93a, a.m661a(), a4.m699d());
        C0142a a5 = a4.m701f().m686a(a);
        if (z && HttpRequest.f14551d.equalsIgnoreCase(a4.m695a(HttpRequest.f14557j)) && C0028e.m111b(a4)) {
            Source gzipSource = new GzipSource(a4.m700e().m130c());
            C0127q a6 = a4.m699d().m551b().m544b(HttpRequest.f14557j).m544b(HttpRequest.f14558k).m543a();
            a5.m684a(a6);
            a5.m682a(new C0032h(a6, Okio.buffer(gzipSource)));
        }
        return a5.m690a();
    }
}
