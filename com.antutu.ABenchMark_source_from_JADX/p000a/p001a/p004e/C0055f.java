package p000a.p001a.p004e;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.internal.C4103b;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import p000a.C0127q;
import p000a.C0127q.C0126a;
import p000a.C0134u;
import p000a.C0135v;
import p000a.C0139x;
import p000a.C0143z;
import p000a.C0143z.C0142a;
import p000a.aa;
import p000a.p001a.C0010a;
import p000a.p001a.C0037c;
import p000a.p001a.p003b.C0020g;
import p000a.p001a.p005c.C0025c;
import p000a.p001a.p005c.C0032h;
import p000a.p001a.p005c.C0033i;
import p000a.p001a.p005c.C0035k;

/* renamed from: a.a.e.f */
public final class C0055f implements C0025c {
    private static final ByteString f197b;
    private static final ByteString f198c;
    private static final ByteString f199d;
    private static final ByteString f200e;
    private static final ByteString f201f;
    private static final ByteString f202g;
    private static final ByteString f203h;
    private static final ByteString f204i;
    private static final List<ByteString> f205j;
    private static final List<ByteString> f206k;
    final C0020g f207a;
    private final C0134u f208l;
    private final C0070g f209m;
    private C0076i f210n;

    /* renamed from: a.a.e.f.a */
    class C0054a extends ForwardingSource {
        final /* synthetic */ C0055f f196a;

        public C0054a(C0055f c0055f, Source source) {
            this.f196a = c0055f;
            super(source);
        }

        public void close() {
            this.f196a.f207a.m87a(false, this.f196a);
            super.close();
        }
    }

    static {
        f197b = ByteString.encodeUtf8("connection");
        f198c = ByteString.encodeUtf8(C4103b.ELECTION_KEY_HOST);
        f199d = ByteString.encodeUtf8("keep-alive");
        f200e = ByteString.encodeUtf8("proxy-connection");
        f201f = ByteString.encodeUtf8("transfer-encoding");
        f202g = ByteString.encodeUtf8("te");
        f203h = ByteString.encodeUtf8(ModelFields.ENCODING);
        f204i = ByteString.encodeUtf8("upgrade");
        f205j = C0037c.m156a(f197b, f198c, f199d, f200e, f202g, f201f, f203h, f204i, C0049c.f165c, C0049c.f166d, C0049c.f167e, C0049c.f168f);
        f206k = C0037c.m156a(f197b, f198c, f199d, f200e, f202g, f201f, f203h, f204i);
    }

    public C0055f(C0134u c0134u, C0020g c0020g, C0070g c0070g) {
        this.f208l = c0134u;
        this.f207a = c0020g;
        this.f209m = c0070g;
    }

    public static C0142a m222a(List<C0049c> list) {
        String str = null;
        C0126a c0126a = new C0126a();
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = ((C0049c) list.get(i)).f169g;
            String utf8 = ((C0049c) list.get(i)).f170h.utf8();
            if (!byteString.equals(C0049c.f164b)) {
                if (!f206k.contains(byteString)) {
                    C0010a.f46a.m35a(c0126a, byteString.utf8(), utf8);
                }
                utf8 = str;
            }
            i++;
            str = utf8;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C0035k a = C0035k.m146a("HTTP/1.1 " + str);
        return new C0142a().m685a(C0135v.HTTP_2).m680a(a.f114b).m688a(a.f115c).m684a(c0126a.m543a());
    }

    public static List<C0049c> m223b(C0139x c0139x) {
        int i = 0;
        C0127q c = c0139x.m664c();
        List<C0049c> arrayList = new ArrayList(c.m548a() + 4);
        arrayList.add(new C0049c(C0049c.f165c, c0139x.m663b()));
        arrayList.add(new C0049c(C0049c.f166d, C0033i.m135a(c0139x.m661a())));
        arrayList.add(new C0049c(C0049c.f168f, C0037c.m151a(c0139x.m661a(), false)));
        arrayList.add(new C0049c(C0049c.f167e, c0139x.m661a().m592b()));
        int a = c.m548a();
        while (i < a) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c.m549a(i).toLowerCase(Locale.US));
            if (!f205j.contains(encodeUtf8)) {
                arrayList.add(new C0049c(encodeUtf8, c.m552b(i)));
            }
            i++;
        }
        return arrayList;
    }

    public aa m224a(C0143z c0143z) {
        return new C0032h(c0143z.m699d(), Okio.buffer(new C0054a(this, this.f210n.m323g())));
    }

    public Sink m225a(C0139x c0139x, long j) {
        return this.f210n.m324h();
    }

    public void m226a() {
        this.f210n.m324h().close();
    }

    public void m227a(C0139x c0139x) {
        if (this.f210n == null) {
            this.f210n = this.f209m.m268a(C0055f.m223b(c0139x), c0139x.m665d() != null);
            this.f210n.m321e().timeout((long) this.f208l.m621b(), TimeUnit.MILLISECONDS);
            this.f210n.m322f().timeout((long) this.f208l.m622c(), TimeUnit.MILLISECONDS);
        }
    }

    public C0142a m228b() {
        return C0055f.m222a(this.f210n.m320d());
    }
}
