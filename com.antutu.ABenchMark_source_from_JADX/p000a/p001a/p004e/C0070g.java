package p000a.p001a.p004e;

import android.support.v4.view.ViewCompat;
import cn.sharesdk.framework.Platform;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.android.spdy.SpdyProtocol;
import p000a.p001a.C0021b;
import p000a.p001a.C0037c;
import p000a.p001a.p004e.C0072h.C0068b;
import p000a.p001a.p009g.C0090e;

/* renamed from: a.a.e.g */
public final class C0070g implements Closeable {
    static final ExecutorService f251a;
    static final /* synthetic */ boolean f252s;
    final boolean f253b;
    final C0013b f254c;
    final Map<Integer, C0076i> f255d;
    final String f256e;
    int f257f;
    int f258g;
    boolean f259h;
    final C0081m f260i;
    long f261j;
    long f262k;
    C0083n f263l;
    final C0083n f264m;
    boolean f265n;
    final Socket f266o;
    final C0077j f267p;
    final C0069c f268q;
    final Set<Integer> f269r;
    private final ExecutorService f270t;
    private Map<Integer, C0080l> f271u;
    private int f272v;

    /* renamed from: a.a.e.g.b */
    public static abstract class C0013b {
        public static final C0013b f52j;

        /* renamed from: a.a.e.g.b.1 */
        static class C00641 extends C0013b {
            C00641() {
            }

            public void m239a(C0076i c0076i) {
                c0076i.m313a(C0048b.REFUSED_STREAM);
            }
        }

        static {
            f52j = new C00641();
        }

        public void m42a(C0070g c0070g) {
        }

        public abstract void m43a(C0076i c0076i);
    }

    /* renamed from: a.a.e.g.1 */
    class C00561 extends C0021b {
        final /* synthetic */ int f211a;
        final /* synthetic */ C0048b f212c;
        final /* synthetic */ C0070g f213d;

        C00561(C0070g c0070g, String str, Object[] objArr, int i, C0048b c0048b) {
            this.f213d = c0070g;
            this.f211a = i;
            this.f212c = c0048b;
            super(str, objArr);
        }

        public void m229b() {
            try {
                this.f213d.m282b(this.f211a, this.f212c);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a.a.e.g.2 */
    class C00572 extends C0021b {
        final /* synthetic */ int f214a;
        final /* synthetic */ long f215c;
        final /* synthetic */ C0070g f216d;

        C00572(C0070g c0070g, String str, Object[] objArr, int i, long j) {
            this.f216d = c0070g;
            this.f214a = i;
            this.f215c = j;
            super(str, objArr);
        }

        public void m230b() {
            try {
                this.f216d.f267p.m335a(this.f214a, this.f215c);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a.a.e.g.3 */
    class C00583 extends C0021b {
        final /* synthetic */ boolean f217a;
        final /* synthetic */ int f218c;
        final /* synthetic */ int f219d;
        final /* synthetic */ C0080l f220e;
        final /* synthetic */ C0070g f221f;

        C00583(C0070g c0070g, String str, Object[] objArr, boolean z, int i, int i2, C0080l c0080l) {
            this.f221f = c0070g;
            this.f217a = z;
            this.f218c = i;
            this.f219d = i2;
            this.f220e = c0080l;
            super(str, objArr);
        }

        public void m231b() {
            try {
                this.f221f.m283b(this.f217a, this.f218c, this.f219d, this.f220e);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a.a.e.g.4 */
    class C00594 extends C0021b {
        final /* synthetic */ int f222a;
        final /* synthetic */ List f223c;
        final /* synthetic */ C0070g f224d;

        C00594(C0070g c0070g, String str, Object[] objArr, int i, List list) {
            this.f224d = c0070g;
            this.f222a = i;
            this.f223c = list;
            super(str, objArr);
        }

        public void m232b() {
            if (this.f224d.f260i.m356a(this.f222a, this.f223c)) {
                try {
                    this.f224d.f267p.m336a(this.f222a, C0048b.CANCEL);
                    synchronized (this.f224d) {
                        this.f224d.f269r.remove(Integer.valueOf(this.f222a));
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: a.a.e.g.5 */
    class C00605 extends C0021b {
        final /* synthetic */ int f225a;
        final /* synthetic */ List f226c;
        final /* synthetic */ boolean f227d;
        final /* synthetic */ C0070g f228e;

        C00605(C0070g c0070g, String str, Object[] objArr, int i, List list, boolean z) {
            this.f228e = c0070g;
            this.f225a = i;
            this.f226c = list;
            this.f227d = z;
            super(str, objArr);
        }

        public void m233b() {
            boolean a = this.f228e.f260i.m357a(this.f225a, this.f226c, this.f227d);
            if (a) {
                try {
                    this.f228e.f267p.m336a(this.f225a, C0048b.CANCEL);
                } catch (IOException e) {
                    return;
                }
            }
            if (a || this.f227d) {
                synchronized (this.f228e) {
                    this.f228e.f269r.remove(Integer.valueOf(this.f225a));
                }
            }
        }
    }

    /* renamed from: a.a.e.g.6 */
    class C00616 extends C0021b {
        final /* synthetic */ int f229a;
        final /* synthetic */ Buffer f230c;
        final /* synthetic */ int f231d;
        final /* synthetic */ boolean f232e;
        final /* synthetic */ C0070g f233f;

        C00616(C0070g c0070g, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            this.f233f = c0070g;
            this.f229a = i;
            this.f230c = buffer;
            this.f231d = i2;
            this.f232e = z;
            super(str, objArr);
        }

        public void m234b() {
            try {
                boolean a = this.f233f.f260i.m358a(this.f229a, this.f230c, this.f231d, this.f232e);
                if (a) {
                    this.f233f.f267p.m336a(this.f229a, C0048b.CANCEL);
                }
                if (a || this.f232e) {
                    synchronized (this.f233f) {
                        this.f233f.f269r.remove(Integer.valueOf(this.f229a));
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a.a.e.g.7 */
    class C00627 extends C0021b {
        final /* synthetic */ int f234a;
        final /* synthetic */ C0048b f235c;
        final /* synthetic */ C0070g f236d;

        C00627(C0070g c0070g, String str, Object[] objArr, int i, C0048b c0048b) {
            this.f236d = c0070g;
            this.f234a = i;
            this.f235c = c0048b;
            super(str, objArr);
        }

        public void m235b() {
            this.f236d.f260i.m355a(this.f234a, this.f235c);
            synchronized (this.f236d) {
                this.f236d.f269r.remove(Integer.valueOf(this.f234a));
            }
        }
    }

    /* renamed from: a.a.e.g.a */
    public static class C0063a {
        Socket f237a;
        String f238b;
        BufferedSource f239c;
        BufferedSink f240d;
        C0013b f241e;
        C0081m f242f;
        boolean f243g;

        public C0063a(boolean z) {
            this.f241e = C0013b.f52j;
            this.f242f = C0081m.f326a;
            this.f243g = z;
        }

        public C0063a m236a(C0013b c0013b) {
            this.f241e = c0013b;
            return this;
        }

        public C0063a m237a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f237a = socket;
            this.f238b = str;
            this.f239c = bufferedSource;
            this.f240d = bufferedSink;
            return this;
        }

        public C0070g m238a() {
            return new C0070g(this);
        }
    }

    /* renamed from: a.a.e.g.c */
    class C0069c extends C0021b implements C0068b {
        final C0072h f249a;
        final /* synthetic */ C0070g f250c;

        /* renamed from: a.a.e.g.c.1 */
        class C00651 extends C0021b {
            final /* synthetic */ C0076i f244a;
            final /* synthetic */ C0069c f245c;

            C00651(C0069c c0069c, String str, Object[] objArr, C0076i c0076i) {
                this.f245c = c0069c;
                this.f244a = c0076i;
                super(str, objArr);
            }

            public void m240b() {
                try {
                    this.f245c.f250c.f254c.m43a(this.f244a);
                } catch (Throwable e) {
                    C0090e.m389b().m394a(4, "FramedConnection.Listener failure for " + this.f245c.f250c.f256e, e);
                    try {
                        this.f244a.m313a(C0048b.PROTOCOL_ERROR);
                    } catch (IOException e2) {
                    }
                }
            }
        }

        /* renamed from: a.a.e.g.c.2 */
        class C00662 extends C0021b {
            final /* synthetic */ C0069c f246a;

            C00662(C0069c c0069c, String str, Object... objArr) {
                this.f246a = c0069c;
                super(str, objArr);
            }

            public void m241b() {
                this.f246a.f250c.f254c.m42a(this.f246a.f250c);
            }
        }

        /* renamed from: a.a.e.g.c.3 */
        class C00673 extends C0021b {
            final /* synthetic */ C0083n f247a;
            final /* synthetic */ C0069c f248c;

            C00673(C0069c c0069c, String str, Object[] objArr, C0083n c0083n) {
                this.f248c = c0069c;
                this.f247a = c0083n;
                super(str, objArr);
            }

            public void m242b() {
                try {
                    this.f248c.f250c.f267p.m338a(this.f247a);
                } catch (IOException e) {
                }
            }
        }

        C0069c(C0070g c0070g, C0072h c0072h) {
            this.f250c = c0070g;
            super("OkHttp %s", c0070g.f256e);
            this.f249a = c0072h;
        }

        private void m253a(C0083n c0083n) {
            C0070g.f251a.execute(new C00673(this, "OkHttp %s ACK Settings", new Object[]{this.f250c.f256e}, c0083n));
        }

        public void m254a() {
        }

        public void m255a(int i, int i2, int i3, boolean z) {
        }

        public void m256a(int i, int i2, List<C0049c> list) {
            this.f250c.m271a(i2, (List) list);
        }

        public void m257a(int i, long j) {
            if (i == 0) {
                synchronized (this.f250c) {
                    C0070g c0070g = this.f250c;
                    c0070g.f262k += j;
                    this.f250c.notifyAll();
                }
                return;
            }
            C0076i a = this.f250c.m267a(i);
            if (a != null) {
                synchronized (a) {
                    a.m312a(j);
                }
            }
        }

        public void m258a(int i, C0048b c0048b) {
            if (this.f250c.m288d(i)) {
                this.f250c.m286c(i, c0048b);
                return;
            }
            C0076i b = this.f250c.m280b(i);
            if (b != null) {
                b.m318c(c0048b);
            }
        }

        public void m259a(int i, C0048b c0048b, ByteString byteString) {
            if (byteString.size() > 0) {
            }
            synchronized (this.f250c) {
                C0076i[] c0076iArr = (C0076i[]) this.f250c.f255d.values().toArray(new C0076i[this.f250c.f255d.size()]);
                this.f250c.f259h = true;
            }
            for (C0076i c0076i : c0076iArr) {
                if (c0076i.m311a() > i && c0076i.m319c()) {
                    c0076i.m318c(C0048b.REFUSED_STREAM);
                    this.f250c.m280b(c0076i.m311a());
                }
            }
        }

        public void m260a(boolean z, int i, int i2) {
            if (z) {
                C0080l c = this.f250c.m284c(i);
                if (c != null) {
                    c.m353b();
                    return;
                }
                return;
            }
            this.f250c.m279a(true, i, i2, null);
        }

        public void m261a(boolean z, int i, int i2, List<C0049c> list) {
            if (this.f250c.m288d(i)) {
                this.f250c.m272a(i, list, z);
                return;
            }
            synchronized (this.f250c) {
                if (this.f250c.f259h) {
                    return;
                }
                C0076i a = this.f250c.m267a(i);
                if (a != null) {
                    a.m314a((List) list);
                    if (z) {
                        a.m325i();
                    }
                } else if (i <= this.f250c.f257f) {
                } else if (i % 2 == this.f250c.f258g % 2) {
                } else {
                    a = new C0076i(i, this.f250c, false, z, list);
                    this.f250c.f257f = i;
                    this.f250c.f255d.put(Integer.valueOf(i), a);
                    C0070g.f251a.execute(new C00651(this, "OkHttp %s stream %d", new Object[]{this.f250c.f256e, Integer.valueOf(i)}, a));
                }
            }
        }

        public void m262a(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (this.f250c.m288d(i)) {
                this.f250c.m273a(i, bufferedSource, i2, z);
                return;
            }
            C0076i a = this.f250c.m267a(i);
            if (a == null) {
                this.f250c.m270a(i, C0048b.PROTOCOL_ERROR);
                bufferedSource.skip((long) i2);
                return;
            }
            a.m315a(bufferedSource, i2);
            if (z) {
                a.m325i();
            }
        }

        public void m263a(boolean z, C0083n c0083n) {
            C0076i[] c0076iArr;
            long j;
            synchronized (this.f250c) {
                int d = this.f250c.f264m.m371d();
                if (z) {
                    this.f250c.f264m.m364a();
                }
                this.f250c.f264m.m365a(c0083n);
                m253a(c0083n);
                int d2 = this.f250c.f264m.m371d();
                if (d2 == -1 || d2 == d) {
                    c0076iArr = null;
                    j = 0;
                } else {
                    long j2 = (long) (d2 - d);
                    if (!this.f250c.f265n) {
                        this.f250c.m275a(j2);
                        this.f250c.f265n = true;
                    }
                    if (this.f250c.f255d.isEmpty()) {
                        j = j2;
                        c0076iArr = null;
                    } else {
                        j = j2;
                        c0076iArr = (C0076i[]) this.f250c.f255d.values().toArray(new C0076i[this.f250c.f255d.size()]);
                    }
                }
                C0070g.f251a.execute(new C00662(this, "OkHttp %s settings", this.f250c.f256e));
            }
            if (c0076iArr != null && j != 0) {
                for (C0076i c0076i : c0076iArr) {
                    synchronized (c0076i) {
                        c0076i.m312a(j);
                    }
                }
            }
        }

        protected void m264b() {
            C0048b c0048b;
            Throwable th;
            C0048b c0048b2 = C0048b.INTERNAL_ERROR;
            C0048b c0048b3 = C0048b.INTERNAL_ERROR;
            try {
                if (!this.f250c.f253b) {
                    this.f249a.m303a();
                }
                do {
                } while (this.f249a.m304a((C0068b) this));
                try {
                    this.f250c.m277a(C0048b.NO_ERROR, C0048b.CANCEL);
                } catch (IOException e) {
                }
                C0037c.m160a(this.f249a);
            } catch (IOException e2) {
                c0048b = C0048b.PROTOCOL_ERROR;
                try {
                    this.f250c.m277a(c0048b, C0048b.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                C0037c.m160a(this.f249a);
            } catch (Throwable th2) {
                th = th2;
                this.f250c.m277a(c0048b, c0048b3);
                C0037c.m160a(this.f249a);
                throw th;
            }
        }
    }

    static {
        f252s = !C0070g.class.desiredAssertionStatus();
        f251a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C0037c.m158a("OkHttp FramedConnection", true));
    }

    C0070g(C0063a c0063a) {
        int i = 2;
        this.f255d = new LinkedHashMap();
        this.f261j = 0;
        this.f263l = new C0083n();
        this.f264m = new C0083n();
        this.f265n = false;
        this.f269r = new LinkedHashSet();
        this.f260i = c0063a.f242f;
        this.f253b = c0063a.f243g;
        this.f254c = c0063a.f241e;
        this.f258g = c0063a.f243g ? 1 : 2;
        if (c0063a.f243g) {
            this.f258g += 2;
        }
        if (c0063a.f243g) {
            i = 1;
        }
        this.f272v = i;
        if (c0063a.f243g) {
            this.f263l.m363a(7, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        this.f256e = c0063a.f238b;
        this.f270t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C0037c.m158a(C0037c.m153a("OkHttp %s Push Observer", this.f256e), true));
        this.f264m.m363a(7, Platform.CUSTOMER_ACTION_MASK);
        this.f264m.m363a(5, SpdyProtocol.SLIGHTSSL_L7E);
        this.f262k = (long) this.f264m.m371d();
        this.f266o = c0063a.f237a;
        this.f267p = new C0077j(c0063a.f240d, this.f253b);
        this.f268q = new C0069c(this, new C0072h(c0063a.f239c, this.f253b));
    }

    private C0076i m265b(int i, List<C0049c> list, boolean z) {
        C0076i c0076i;
        Object obj = null;
        boolean z2 = !z;
        synchronized (this.f267p) {
            synchronized (this) {
                if (this.f259h) {
                    throw new C0047a();
                }
                int i2 = this.f258g;
                this.f258g += 2;
                c0076i = new C0076i(i2, this, z2, false, list);
                if (!z || this.f262k == 0 || c0076i.f299b == 0) {
                    obj = 1;
                }
                if (c0076i.m317b()) {
                    this.f255d.put(Integer.valueOf(i2), c0076i);
                }
            }
            if (i == 0) {
                this.f267p.m340a(z2, i2, i, (List) list);
            } else if (this.f253b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.f267p.m334a(i, i2, (List) list);
            }
        }
        if (obj != null) {
            this.f267p.m343b();
        }
        return c0076i;
    }

    public synchronized int m266a() {
        return this.f264m.m370c(Integer.MAX_VALUE);
    }

    synchronized C0076i m267a(int i) {
        return (C0076i) this.f255d.get(Integer.valueOf(i));
    }

    public C0076i m268a(List<C0049c> list, boolean z) {
        return m265b(0, list, z);
    }

    void m269a(int i, long j) {
        f251a.execute(new C00572(this, "OkHttp Window Update %s stream %d", new Object[]{this.f256e, Integer.valueOf(i)}, i, j));
    }

    void m270a(int i, C0048b c0048b) {
        f251a.execute(new C00561(this, "OkHttp %s stream %d", new Object[]{this.f256e, Integer.valueOf(i)}, i, c0048b));
    }

    void m271a(int i, List<C0049c> list) {
        synchronized (this) {
            if (this.f269r.contains(Integer.valueOf(i))) {
                m270a(i, C0048b.PROTOCOL_ERROR);
                return;
            }
            this.f269r.add(Integer.valueOf(i));
            this.f270t.execute(new C00594(this, "OkHttp %s Push Request[%s]", new Object[]{this.f256e, Integer.valueOf(i)}, i, list));
        }
    }

    void m272a(int i, List<C0049c> list, boolean z) {
        this.f270t.execute(new C00605(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f256e, Integer.valueOf(i)}, i, list, z));
    }

    void m273a(int i, BufferedSource bufferedSource, int i2, boolean z) {
        Buffer buffer = new Buffer();
        bufferedSource.require((long) i2);
        bufferedSource.read(buffer, (long) i2);
        if (buffer.size() != ((long) i2)) {
            throw new IOException(buffer.size() + " != " + i2);
        }
        this.f270t.execute(new C00616(this, "OkHttp %s Push Data[%s]", new Object[]{this.f256e, Integer.valueOf(i)}, i, buffer, i2, z));
    }

    public void m274a(int i, boolean z, Buffer buffer, long j) {
        if (j == 0) {
            this.f267p.m342a(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            int min;
            synchronized (this) {
                while (this.f262k <= 0) {
                    try {
                        if (this.f255d.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f262k), this.f267p.m345c());
                this.f262k -= (long) min;
            }
            j -= (long) min;
            C0077j c0077j = this.f267p;
            boolean z2 = z && j == 0;
            c0077j.m342a(z2, i, buffer, min);
        }
    }

    void m275a(long j) {
        this.f262k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m276a(p000a.p001a.p004e.C0048b r5) {
        /*
        r4 = this;
        r1 = r4.f267p;
        monitor-enter(r1);
        monitor-enter(r4);	 Catch:{ all -> 0x001a }
        r0 = r4.f259h;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
    L_0x000a:
        return;
    L_0x000b:
        r0 = 1;
        r4.f259h = r0;	 Catch:{ all -> 0x001d }
        r0 = r4.f257f;	 Catch:{ all -> 0x001d }
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        r2 = r4.f267p;	 Catch:{ all -> 0x001a }
        r3 = p000a.p001a.C0037c.f116a;	 Catch:{ all -> 0x001a }
        r2.m337a(r0, r5, r3);	 Catch:{ all -> 0x001a }
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x000a;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        throw r0;	 Catch:{ all -> 0x001a }
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.e.g.a(a.a.e.b):void");
    }

    void m277a(C0048b c0048b, C0048b c0048b2) {
        IOException iOException;
        IOException e;
        if (f252s || !Thread.holdsLock(this)) {
            C0076i[] c0076iArr;
            C0080l[] c0080lArr;
            try {
                m276a(c0048b);
                iOException = null;
            } catch (IOException e2) {
                iOException = e2;
            }
            synchronized (this) {
                if (this.f255d.isEmpty()) {
                    c0076iArr = null;
                } else {
                    C0076i[] c0076iArr2 = (C0076i[]) this.f255d.values().toArray(new C0076i[this.f255d.size()]);
                    this.f255d.clear();
                    c0076iArr = c0076iArr2;
                }
                if (this.f271u != null) {
                    C0080l[] c0080lArr2 = (C0080l[]) this.f271u.values().toArray(new C0080l[this.f271u.size()]);
                    this.f271u = null;
                    c0080lArr = c0080lArr2;
                } else {
                    c0080lArr = null;
                }
            }
            if (c0076iArr != null) {
                e2 = iOException;
                for (C0076i a : c0076iArr) {
                    try {
                        a.m313a(c0048b2);
                    } catch (IOException iOException2) {
                        if (e2 != null) {
                            e2 = iOException2;
                        }
                    }
                }
                iOException2 = e2;
            }
            if (c0080lArr != null) {
                for (C0080l c : c0080lArr) {
                    c.m354c();
                }
            }
            try {
                this.f267p.close();
                e2 = iOException2;
            } catch (IOException e3) {
                e2 = e3;
                if (iOException2 != null) {
                    e2 = iOException2;
                }
            }
            try {
                this.f266o.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    void m278a(boolean z) {
        if (z) {
            this.f267p.m331a();
            this.f267p.m344b(this.f263l);
            int d = this.f263l.m371d();
            if (d != Platform.CUSTOMER_ACTION_MASK) {
                this.f267p.m335a(0, (long) (d - Platform.CUSTOMER_ACTION_MASK));
            }
        }
        new Thread(this.f268q).start();
    }

    void m279a(boolean z, int i, int i2, C0080l c0080l) {
        f251a.execute(new C00583(this, "OkHttp %s ping %08x%08x", new Object[]{this.f256e, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, c0080l));
    }

    synchronized C0076i m280b(int i) {
        C0076i c0076i;
        c0076i = (C0076i) this.f255d.remove(Integer.valueOf(i));
        notifyAll();
        return c0076i;
    }

    public void m281b() {
        this.f267p.m343b();
    }

    void m282b(int i, C0048b c0048b) {
        this.f267p.m336a(i, c0048b);
    }

    void m283b(boolean z, int i, int i2, C0080l c0080l) {
        synchronized (this.f267p) {
            if (c0080l != null) {
                c0080l.m352a();
            }
            this.f267p.m339a(z, i, i2);
        }
    }

    synchronized C0080l m284c(int i) {
        return this.f271u != null ? (C0080l) this.f271u.remove(Integer.valueOf(i)) : null;
    }

    public void m285c() {
        m278a(true);
    }

    void m286c(int i, C0048b c0048b) {
        this.f270t.execute(new C00627(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f256e, Integer.valueOf(i)}, i, c0048b));
    }

    public void close() {
        m277a(C0048b.NO_ERROR, C0048b.CANCEL);
    }

    public synchronized boolean m287d() {
        return this.f259h;
    }

    boolean m288d(int i) {
        return i != 0 && (i & 1) == 0;
    }
}
