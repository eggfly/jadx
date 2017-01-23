package p000a.p001a.p006d;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000a.C0127q;
import p000a.C0127q.C0126a;
import p000a.C0130r;
import p000a.C0134u;
import p000a.C0139x;
import p000a.C0143z;
import p000a.C0143z.C0142a;
import p000a.aa;
import p000a.p001a.C0010a;
import p000a.p001a.C0037c;
import p000a.p001a.p003b.C0020g;
import p000a.p001a.p005c.C0025c;
import p000a.p001a.p005c.C0028e;
import p000a.p001a.p005c.C0032h;
import p000a.p001a.p005c.C0033i;
import p000a.p001a.p005c.C0035k;

/* renamed from: a.a.d.a */
public final class C0045a implements C0025c {
    final C0134u f150a;
    final C0020g f151b;
    final BufferedSource f152c;
    final BufferedSink f153d;
    int f154e;

    /* renamed from: a.a.d.a.a */
    private abstract class C0039a implements Source {
        protected final ForwardingTimeout f132a;
        protected boolean f133b;
        final /* synthetic */ C0045a f134c;

        private C0039a(C0045a c0045a) {
            this.f134c = c0045a;
            this.f132a = new ForwardingTimeout(this.f134c.f152c.timeout());
        }

        protected final void m172a(boolean z) {
            if (this.f134c.f154e != 6) {
                if (this.f134c.f154e != 5) {
                    throw new IllegalStateException("state: " + this.f134c.f154e);
                }
                this.f134c.m182a(this.f132a);
                this.f134c.f154e = 6;
                if (this.f134c.f151b != null) {
                    this.f134c.f151b.m87a(!z, this.f134c);
                }
            }
        }

        public Timeout timeout() {
            return this.f132a;
        }
    }

    /* renamed from: a.a.d.a.b */
    private final class C0040b implements Sink {
        final /* synthetic */ C0045a f135a;
        private final ForwardingTimeout f136b;
        private boolean f137c;

        C0040b(C0045a c0045a) {
            this.f135a = c0045a;
            this.f136b = new ForwardingTimeout(this.f135a.f153d.timeout());
        }

        public synchronized void close() {
            if (!this.f137c) {
                this.f137c = true;
                this.f135a.f153d.writeUtf8("0\r\n\r\n");
                this.f135a.m182a(this.f136b);
                this.f135a.f154e = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f137c) {
                this.f135a.f153d.flush();
            }
        }

        public Timeout timeout() {
            return this.f136b;
        }

        public void write(Buffer buffer, long j) {
            if (this.f137c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.f135a.f153d.writeHexadecimalUnsignedLong(j);
                this.f135a.f153d.writeUtf8("\r\n");
                this.f135a.f153d.write(buffer, j);
                this.f135a.f153d.writeUtf8("\r\n");
            }
        }
    }

    /* renamed from: a.a.d.a.c */
    private class C0041c extends C0039a {
        final /* synthetic */ C0045a f138d;
        private final C0130r f139e;
        private long f140f;
        private boolean f141g;

        C0041c(C0045a c0045a, C0130r c0130r) {
            this.f138d = c0045a;
            super(null);
            this.f140f = -1;
            this.f141g = true;
            this.f139e = c0130r;
        }

        private void m173a() {
            if (this.f140f != -1) {
                this.f138d.f152c.readUtf8LineStrict();
            }
            try {
                this.f140f = this.f138d.f152c.readHexadecimalUnsignedLong();
                String trim = this.f138d.f152c.readUtf8LineStrict().trim();
                if (this.f140f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f140f + trim + "\"");
                } else if (this.f140f == 0) {
                    this.f141g = false;
                    C0028e.m109a(this.f138d.f150a.m625f(), this.f139e, this.f138d.m186d());
                    m172a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (!this.b) {
                if (this.f141g && !C0037c.m164a((Source) this, 100, TimeUnit.MILLISECONDS)) {
                    m172a(false);
                }
                this.b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.f141g) {
                return -1;
            } else {
                if (this.f140f == 0 || this.f140f == -1) {
                    m173a();
                    if (!this.f141g) {
                        return -1;
                    }
                }
                long read = this.f138d.f152c.read(buffer, Math.min(j, this.f140f));
                if (read == -1) {
                    m172a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f140f -= read;
                return read;
            }
        }
    }

    /* renamed from: a.a.d.a.d */
    private final class C0042d implements Sink {
        final /* synthetic */ C0045a f142a;
        private final ForwardingTimeout f143b;
        private boolean f144c;
        private long f145d;

        C0042d(C0045a c0045a, long j) {
            this.f142a = c0045a;
            this.f143b = new ForwardingTimeout(this.f142a.f153d.timeout());
            this.f145d = j;
        }

        public void close() {
            if (!this.f144c) {
                this.f144c = true;
                if (this.f145d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f142a.m182a(this.f143b);
                this.f142a.f154e = 3;
            }
        }

        public void flush() {
            if (!this.f144c) {
                this.f142a.f153d.flush();
            }
        }

        public Timeout timeout() {
            return this.f143b;
        }

        public void write(Buffer buffer, long j) {
            if (this.f144c) {
                throw new IllegalStateException("closed");
            }
            C0037c.m159a(buffer.size(), 0, j);
            if (j > this.f145d) {
                throw new ProtocolException("expected " + this.f145d + " bytes but received " + j);
            }
            this.f142a.f153d.write(buffer, j);
            this.f145d -= j;
        }
    }

    /* renamed from: a.a.d.a.e */
    private class C0043e extends C0039a {
        final /* synthetic */ C0045a f146d;
        private long f147e;

        public C0043e(C0045a c0045a, long j) {
            this.f146d = c0045a;
            super(null);
            this.f147e = j;
            if (this.f147e == 0) {
                m172a(true);
            }
        }

        public void close() {
            if (!this.b) {
                if (!(this.f147e == 0 || C0037c.m164a((Source) this, 100, TimeUnit.MILLISECONDS))) {
                    m172a(false);
                }
                this.b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f147e == 0) {
                return -1;
            } else {
                long read = this.f146d.f152c.read(buffer, Math.min(this.f147e, j));
                if (read == -1) {
                    m172a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f147e -= read;
                if (this.f147e == 0) {
                    m172a(true);
                }
                return read;
            }
        }
    }

    /* renamed from: a.a.d.a.f */
    private class C0044f extends C0039a {
        final /* synthetic */ C0045a f148d;
        private boolean f149e;

        C0044f(C0045a c0045a) {
            this.f148d = c0045a;
            super(null);
        }

        public void close() {
            if (!this.b) {
                if (!this.f149e) {
                    m172a(false);
                }
                this.b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f149e) {
                return -1;
            } else {
                long read = this.f148d.f152c.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.f149e = true;
                m172a(true);
                return -1;
            }
        }
    }

    public C0045a(C0134u c0134u, C0020g c0020g, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f154e = 0;
        this.f150a = c0134u;
        this.f151b = c0020g;
        this.f152c = bufferedSource;
        this.f153d = bufferedSink;
    }

    private Source m174b(C0143z c0143z) {
        if (!C0028e.m111b(c0143z)) {
            return m184b(0);
        }
        if ("chunked".equalsIgnoreCase(c0143z.m695a("Transfer-Encoding"))) {
            return m178a(c0143z.m694a().m661a());
        }
        long a = C0028e.m107a(c0143z);
        return a != -1 ? m184b(a) : m188f();
    }

    public aa m175a(C0143z c0143z) {
        return new C0032h(c0143z.m699d(), Okio.buffer(m174b(c0143z)));
    }

    public Sink m176a(long j) {
        if (this.f154e != 1) {
            throw new IllegalStateException("state: " + this.f154e);
        }
        this.f154e = 2;
        return new C0042d(this, j);
    }

    public Sink m177a(C0139x c0139x, long j) {
        if ("chunked".equalsIgnoreCase(c0139x.m662a("Transfer-Encoding"))) {
            return m187e();
        }
        if (j != -1) {
            return m176a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public Source m178a(C0130r c0130r) {
        if (this.f154e != 4) {
            throw new IllegalStateException("state: " + this.f154e);
        }
        this.f154e = 5;
        return new C0041c(this, c0130r);
    }

    public void m179a() {
        this.f153d.flush();
    }

    public void m180a(C0127q c0127q, String str) {
        if (this.f154e != 0) {
            throw new IllegalStateException("state: " + this.f154e);
        }
        this.f153d.writeUtf8(str).writeUtf8("\r\n");
        int a = c0127q.m548a();
        for (int i = 0; i < a; i++) {
            this.f153d.writeUtf8(c0127q.m549a(i)).writeUtf8(": ").writeUtf8(c0127q.m552b(i)).writeUtf8("\r\n");
        }
        this.f153d.writeUtf8("\r\n");
        this.f154e = 1;
    }

    public void m181a(C0139x c0139x) {
        m180a(c0139x.m664c(), C0033i.m136a(c0139x, this.f151b.m88b().m52a().m459b().type()));
    }

    void m182a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public C0142a m183b() {
        return m185c();
    }

    public Source m184b(long j) {
        if (this.f154e != 4) {
            throw new IllegalStateException("state: " + this.f154e);
        }
        this.f154e = 5;
        return new C0043e(this, j);
    }

    public C0142a m185c() {
        if (this.f154e == 1 || this.f154e == 3) {
            C0142a a;
            C0035k a2;
            do {
                try {
                    a2 = C0035k.m146a(this.f152c.readUtf8LineStrict());
                    a = new C0142a().m685a(a2.f113a).m680a(a2.f114b).m688a(a2.f115c).m684a(m186d());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f151b);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a2.f114b == 100);
            this.f154e = 4;
            return a;
        }
        throw new IllegalStateException("state: " + this.f154e);
    }

    public C0127q m186d() {
        C0126a c0126a = new C0126a();
        while (true) {
            String readUtf8LineStrict = this.f152c.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return c0126a.m543a();
            }
            C0010a.f46a.m34a(c0126a, readUtf8LineStrict);
        }
    }

    public Sink m187e() {
        if (this.f154e != 1) {
            throw new IllegalStateException("state: " + this.f154e);
        }
        this.f154e = 2;
        return new C0040b(this);
    }

    public Source m188f() {
        if (this.f154e != 4) {
            throw new IllegalStateException("state: " + this.f154e);
        } else if (this.f151b == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.f154e = 5;
            this.f151b.m90d();
            return new C0044f(this);
        }
    }
}
