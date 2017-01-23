package p000a.p001a.p004e;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: a.a.e.i */
public final class C0076i {
    static final /* synthetic */ boolean f297i;
    long f298a;
    long f299b;
    final int f300c;
    final C0070g f301d;
    final C0073a f302e;
    final C0075c f303f;
    final C0075c f304g;
    C0048b f305h;
    private final List<C0049c> f306j;
    private List<C0049c> f307k;
    private final C0074b f308l;

    /* renamed from: a.a.e.i.a */
    final class C0073a implements Sink {
        static final /* synthetic */ boolean f284c;
        boolean f285a;
        boolean f286b;
        final /* synthetic */ C0076i f287d;
        private final Buffer f288e;

        static {
            f284c = !C0076i.class.desiredAssertionStatus();
        }

        C0073a(C0076i c0076i) {
            this.f287d = c0076i;
            this.f288e = new Buffer();
        }

        private void m305a(boolean z) {
            synchronized (this.f287d) {
                this.f287d.f304g.enter();
                while (this.f287d.f299b <= 0 && !this.f286b && !this.f285a && this.f287d.f305h == null) {
                    try {
                        this.f287d.m328l();
                    } catch (Throwable th) {
                        this.f287d.f304g.m309a();
                    }
                }
                this.f287d.f304g.m309a();
                this.f287d.m327k();
                long min = Math.min(this.f287d.f299b, this.f288e.size());
                C0076i c0076i = this.f287d;
                c0076i.f299b -= min;
            }
            this.f287d.f304g.enter();
            try {
                C0070g c0070g = this.f287d.f301d;
                int i = this.f287d.f300c;
                boolean z2 = z && min == this.f288e.size();
                c0070g.m274a(i, z2, this.f288e, min);
            } finally {
                this.f287d.f304g.m309a();
            }
        }

        public void close() {
            if (f284c || !Thread.holdsLock(this.f287d)) {
                synchronized (this.f287d) {
                    if (this.f285a) {
                        return;
                    }
                    if (!this.f287d.f302e.f286b) {
                        if (this.f288e.size() > 0) {
                            while (this.f288e.size() > 0) {
                                m305a(true);
                            }
                        } else {
                            this.f287d.f301d.m274a(this.f287d.f300c, true, null, 0);
                        }
                    }
                    synchronized (this.f287d) {
                        this.f285a = true;
                    }
                    this.f287d.f301d.m281b();
                    this.f287d.m326j();
                    return;
                }
            }
            throw new AssertionError();
        }

        public void flush() {
            if (f284c || !Thread.holdsLock(this.f287d)) {
                synchronized (this.f287d) {
                    this.f287d.m327k();
                }
                while (this.f288e.size() > 0) {
                    m305a(false);
                    this.f287d.f301d.m281b();
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return this.f287d.f304g;
        }

        public void write(Buffer buffer, long j) {
            if (f284c || !Thread.holdsLock(this.f287d)) {
                this.f288e.write(buffer, j);
                while (this.f288e.size() >= 16384) {
                    m305a(false);
                }
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a.a.e.i.b */
    private final class C0074b implements Source {
        static final /* synthetic */ boolean f289c;
        boolean f290a;
        boolean f291b;
        final /* synthetic */ C0076i f292d;
        private final Buffer f293e;
        private final Buffer f294f;
        private final long f295g;

        static {
            f289c = !C0076i.class.desiredAssertionStatus();
        }

        C0074b(C0076i c0076i, long j) {
            this.f292d = c0076i;
            this.f293e = new Buffer();
            this.f294f = new Buffer();
            this.f295g = j;
        }

        private void m306a() {
            this.f292d.f303f.enter();
            while (this.f294f.size() == 0 && !this.f291b && !this.f290a && this.f292d.f305h == null) {
                try {
                    this.f292d.m328l();
                } catch (Throwable th) {
                    this.f292d.f303f.m309a();
                }
            }
            this.f292d.f303f.m309a();
        }

        private void m307b() {
            if (this.f290a) {
                throw new IOException("stream closed");
            } else if (this.f292d.f305h != null) {
                throw new C0084o(this.f292d.f305h);
            }
        }

        void m308a(BufferedSource bufferedSource, long j) {
            if (f289c || !Thread.holdsLock(this.f292d)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (this.f292d) {
                        z = this.f291b;
                        obj = this.f294f.size() + j > this.f295g ? 1 : null;
                    }
                    if (obj != null) {
                        bufferedSource.skip(j);
                        this.f292d.m316b(C0048b.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f293e, j);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        j -= read;
                        synchronized (this.f292d) {
                            obj = this.f294f.size() == 0 ? 1 : null;
                            this.f294f.writeAll(this.f293e);
                            if (obj != null) {
                                this.f292d.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public void close() {
            synchronized (this.f292d) {
                this.f290a = true;
                this.f294f.clear();
                this.f292d.notifyAll();
            }
            this.f292d.m326j();
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (this.f292d) {
                m306a();
                m307b();
                if (this.f294f.size() == 0) {
                    j2 = -1;
                } else {
                    j2 = this.f294f.read(buffer, Math.min(j, this.f294f.size()));
                    C0076i c0076i = this.f292d;
                    c0076i.f298a += j2;
                    if (this.f292d.f298a >= ((long) (this.f292d.f301d.f263l.m371d() / 2))) {
                        this.f292d.f301d.m269a(this.f292d.f300c, this.f292d.f298a);
                        this.f292d.f298a = 0;
                    }
                    synchronized (this.f292d.f301d) {
                        C0070g c0070g = this.f292d.f301d;
                        c0070g.f261j += j2;
                        if (this.f292d.f301d.f261j >= ((long) (this.f292d.f301d.f263l.m371d() / 2))) {
                            this.f292d.f301d.m269a(0, this.f292d.f301d.f261j);
                            this.f292d.f301d.f261j = 0;
                        }
                    }
                }
            }
            return j2;
        }

        public Timeout timeout() {
            return this.f292d.f303f;
        }
    }

    /* renamed from: a.a.e.i.c */
    class C0075c extends AsyncTimeout {
        final /* synthetic */ C0076i f296a;

        C0075c(C0076i c0076i) {
            this.f296a = c0076i;
        }

        public void m309a() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        protected IOException newTimeoutException(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected void timedOut() {
            this.f296a.m316b(C0048b.CANCEL);
        }
    }

    static {
        f297i = !C0076i.class.desiredAssertionStatus();
    }

    C0076i(int i, C0070g c0070g, boolean z, boolean z2, List<C0049c> list) {
        this.f298a = 0;
        this.f303f = new C0075c(this);
        this.f304g = new C0075c(this);
        this.f305h = null;
        if (c0070g == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f300c = i;
            this.f301d = c0070g;
            this.f299b = (long) c0070g.f264m.m371d();
            this.f308l = new C0074b(this, (long) c0070g.f263l.m371d());
            this.f302e = new C0073a(this);
            this.f308l.f291b = z2;
            this.f302e.f286b = z;
            this.f306j = list;
        }
    }

    private boolean m310d(C0048b c0048b) {
        if (f297i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f305h != null) {
                    return false;
                } else if (this.f308l.f291b && this.f302e.f286b) {
                    return false;
                } else {
                    this.f305h = c0048b;
                    notifyAll();
                    this.f301d.m280b(this.f300c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    public int m311a() {
        return this.f300c;
    }

    void m312a(long j) {
        this.f299b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void m313a(C0048b c0048b) {
        if (m310d(c0048b)) {
            this.f301d.m282b(this.f300c, c0048b);
        }
    }

    void m314a(List<C0049c> list) {
        if (f297i || !Thread.holdsLock(this)) {
            boolean z = true;
            synchronized (this) {
                if (this.f307k == null) {
                    this.f307k = list;
                    z = m317b();
                    notifyAll();
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.f307k);
                    arrayList.addAll(list);
                    this.f307k = arrayList;
                }
            }
            if (!z) {
                this.f301d.m280b(this.f300c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    void m315a(BufferedSource bufferedSource, int i) {
        if (f297i || !Thread.holdsLock(this)) {
            this.f308l.m308a(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    public void m316b(C0048b c0048b) {
        if (m310d(c0048b)) {
            this.f301d.m270a(this.f300c, c0048b);
        }
    }

    public synchronized boolean m317b() {
        boolean z = false;
        synchronized (this) {
            if (this.f305h == null) {
                if (!(this.f308l.f291b || this.f308l.f290a) || (!(this.f302e.f286b || this.f302e.f285a) || this.f307k == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    synchronized void m318c(C0048b c0048b) {
        if (this.f305h == null) {
            this.f305h = c0048b;
            notifyAll();
        }
    }

    public boolean m319c() {
        return this.f301d.f253b == ((this.f300c & 1) == 1);
    }

    public synchronized List<C0049c> m320d() {
        this.f303f.enter();
        while (this.f307k == null && this.f305h == null) {
            try {
                m328l();
            } catch (Throwable th) {
                this.f303f.m309a();
            }
        }
        this.f303f.m309a();
        if (this.f307k != null) {
        } else {
            throw new C0084o(this.f305h);
        }
        return this.f307k;
    }

    public Timeout m321e() {
        return this.f303f;
    }

    public Timeout m322f() {
        return this.f304g;
    }

    public Source m323g() {
        return this.f308l;
    }

    public Sink m324h() {
        synchronized (this) {
            if (this.f307k != null || m319c()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f302e;
    }

    void m325i() {
        if (f297i || !Thread.holdsLock(this)) {
            boolean b;
            synchronized (this) {
                this.f308l.f291b = true;
                b = m317b();
                notifyAll();
            }
            if (!b) {
                this.f301d.m280b(this.f300c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    void m326j() {
        if (f297i || !Thread.holdsLock(this)) {
            Object obj;
            boolean b;
            synchronized (this) {
                obj = (!this.f308l.f291b && this.f308l.f290a && (this.f302e.f286b || this.f302e.f285a)) ? 1 : null;
                b = m317b();
            }
            if (obj != null) {
                m313a(C0048b.CANCEL);
                return;
            } else if (!b) {
                this.f301d.m280b(this.f300c);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void m327k() {
        if (this.f302e.f285a) {
            throw new IOException("stream closed");
        } else if (this.f302e.f286b) {
            throw new IOException("stream finished");
        } else if (this.f305h != null) {
            throw new C0084o(this.f305h);
        }
    }

    void m328l() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
