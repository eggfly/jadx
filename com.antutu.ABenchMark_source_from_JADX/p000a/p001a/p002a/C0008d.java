package p000a.p001a.p002a;

import com.facebook.ads.AdError;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.BufferedSink;
import p000a.p001a.p007f.C0085a;

/* renamed from: a.a.a.d */
public final class C0008d implements Closeable, Flushable {
    static final Pattern f31a;
    static final /* synthetic */ boolean f32j;
    final C0085a f33b;
    final int f34c;
    BufferedSink f35d;
    final LinkedHashMap<String, C0007b> f36e;
    int f37f;
    boolean f38g;
    boolean f39h;
    boolean f40i;
    private long f41k;
    private long f42l;
    private long f43m;
    private final Executor f44n;
    private final Runnable f45o;

    /* renamed from: a.a.a.d.a */
    public final class C0006a {
        final C0007b f20a;
        final boolean[] f21b;
        final /* synthetic */ C0008d f22c;
        private boolean f23d;

        void m16a() {
            if (this.f20a.f29f == this) {
                for (int i = 0; i < this.f22c.f34c; i++) {
                    try {
                        this.f22c.f33b.m373a(this.f20a.f27d[i]);
                    } catch (IOException e) {
                    }
                }
                this.f20a.f29f = null;
            }
        }

        public void m17b() {
            synchronized (this.f22c) {
                if (this.f23d) {
                    throw new IllegalStateException();
                }
                if (this.f20a.f29f == this) {
                    this.f22c.m20a(this, false);
                }
                this.f23d = true;
            }
        }
    }

    /* renamed from: a.a.a.d.b */
    private final class C0007b {
        final String f24a;
        final long[] f25b;
        final File[] f26c;
        final File[] f27d;
        boolean f28e;
        C0006a f29f;
        long f30g;

        void m18a(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.f25b) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    static {
        f32j = !C0008d.class.desiredAssertionStatus();
        f31a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    private synchronized void m19d() {
        if (m23b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void m20a(p000a.p001a.p002a.C0008d.C0006a r11, boolean r12) {
        /*
        r10 = this;
        r0 = 0;
        monitor-enter(r10);
        r2 = r11.f20a;	 Catch:{ all -> 0x000e }
        r1 = r2.f29f;	 Catch:{ all -> 0x000e }
        if (r1 == r11) goto L_0x0011;
    L_0x0008:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x000e }
        r0.<init>();	 Catch:{ all -> 0x000e }
        throw r0;	 Catch:{ all -> 0x000e }
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0011:
        if (r12 == 0) goto L_0x0052;
    L_0x0013:
        r1 = r2.f28e;	 Catch:{ all -> 0x000e }
        if (r1 != 0) goto L_0x0052;
    L_0x0017:
        r1 = r0;
    L_0x0018:
        r3 = r10.f34c;	 Catch:{ all -> 0x000e }
        if (r1 >= r3) goto L_0x0052;
    L_0x001c:
        r3 = r11.f21b;	 Catch:{ all -> 0x000e }
        r3 = r3[r1];	 Catch:{ all -> 0x000e }
        if (r3 != 0) goto L_0x003e;
    L_0x0022:
        r11.m17b();	 Catch:{ all -> 0x000e }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x000e }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x000e }
        r2.<init>();	 Catch:{ all -> 0x000e }
        r3 = "Newly created entry didn't create value for index ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x000e }
        r1 = r2.append(r1);	 Catch:{ all -> 0x000e }
        r1 = r1.toString();	 Catch:{ all -> 0x000e }
        r0.<init>(r1);	 Catch:{ all -> 0x000e }
        throw r0;	 Catch:{ all -> 0x000e }
    L_0x003e:
        r3 = r10.f33b;	 Catch:{ all -> 0x000e }
        r4 = r2.f27d;	 Catch:{ all -> 0x000e }
        r4 = r4[r1];	 Catch:{ all -> 0x000e }
        r3 = r3.m375b(r4);	 Catch:{ all -> 0x000e }
        if (r3 != 0) goto L_0x004f;
    L_0x004a:
        r11.m17b();	 Catch:{ all -> 0x000e }
    L_0x004d:
        monitor-exit(r10);
        return;
    L_0x004f:
        r1 = r1 + 1;
        goto L_0x0018;
    L_0x0052:
        r1 = r10.f34c;	 Catch:{ all -> 0x000e }
        if (r0 >= r1) goto L_0x008b;
    L_0x0056:
        r1 = r2.f27d;	 Catch:{ all -> 0x000e }
        r1 = r1[r0];	 Catch:{ all -> 0x000e }
        if (r12 == 0) goto L_0x0085;
    L_0x005c:
        r3 = r10.f33b;	 Catch:{ all -> 0x000e }
        r3 = r3.m375b(r1);	 Catch:{ all -> 0x000e }
        if (r3 == 0) goto L_0x0082;
    L_0x0064:
        r3 = r2.f26c;	 Catch:{ all -> 0x000e }
        r3 = r3[r0];	 Catch:{ all -> 0x000e }
        r4 = r10.f33b;	 Catch:{ all -> 0x000e }
        r4.m374a(r1, r3);	 Catch:{ all -> 0x000e }
        r1 = r2.f25b;	 Catch:{ all -> 0x000e }
        r4 = r1[r0];	 Catch:{ all -> 0x000e }
        r1 = r10.f33b;	 Catch:{ all -> 0x000e }
        r6 = r1.m376c(r3);	 Catch:{ all -> 0x000e }
        r1 = r2.f25b;	 Catch:{ all -> 0x000e }
        r1[r0] = r6;	 Catch:{ all -> 0x000e }
        r8 = r10.f42l;	 Catch:{ all -> 0x000e }
        r4 = r8 - r4;
        r4 = r4 + r6;
        r10.f42l = r4;	 Catch:{ all -> 0x000e }
    L_0x0082:
        r0 = r0 + 1;
        goto L_0x0052;
    L_0x0085:
        r3 = r10.f33b;	 Catch:{ all -> 0x000e }
        r3.m373a(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0082;
    L_0x008b:
        r0 = r10.f37f;	 Catch:{ all -> 0x000e }
        r0 = r0 + 1;
        r10.f37f = r0;	 Catch:{ all -> 0x000e }
        r0 = 0;
        r2.f29f = r0;	 Catch:{ all -> 0x000e }
        r0 = r2.f28e;	 Catch:{ all -> 0x000e }
        r0 = r0 | r12;
        if (r0 == 0) goto L_0x00e3;
    L_0x0099:
        r0 = 1;
        r2.f28e = r0;	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = "CLEAN";
        r0 = r0.writeUtf8(r1);	 Catch:{ all -> 0x000e }
        r1 = 32;
        r0.writeByte(r1);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = r2.f24a;	 Catch:{ all -> 0x000e }
        r0.writeUtf8(r1);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r2.m18a(r0);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = 10;
        r0.writeByte(r1);	 Catch:{ all -> 0x000e }
        if (r12 == 0) goto L_0x00c7;
    L_0x00be:
        r0 = r10.f43m;	 Catch:{ all -> 0x000e }
        r4 = 1;
        r4 = r4 + r0;
        r10.f43m = r4;	 Catch:{ all -> 0x000e }
        r2.f30g = r0;	 Catch:{ all -> 0x000e }
    L_0x00c7:
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r0.flush();	 Catch:{ all -> 0x000e }
        r0 = r10.f42l;	 Catch:{ all -> 0x000e }
        r2 = r10.f41k;	 Catch:{ all -> 0x000e }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00da;
    L_0x00d4:
        r0 = r10.m21a();	 Catch:{ all -> 0x000e }
        if (r0 == 0) goto L_0x004d;
    L_0x00da:
        r0 = r10.f44n;	 Catch:{ all -> 0x000e }
        r1 = r10.f45o;	 Catch:{ all -> 0x000e }
        r0.execute(r1);	 Catch:{ all -> 0x000e }
        goto L_0x004d;
    L_0x00e3:
        r0 = r10.f36e;	 Catch:{ all -> 0x000e }
        r1 = r2.f24a;	 Catch:{ all -> 0x000e }
        r0.remove(r1);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = "REMOVE";
        r0 = r0.writeUtf8(r1);	 Catch:{ all -> 0x000e }
        r1 = 32;
        r0.writeByte(r1);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = r2.f24a;	 Catch:{ all -> 0x000e }
        r0.writeUtf8(r1);	 Catch:{ all -> 0x000e }
        r0 = r10.f35d;	 Catch:{ all -> 0x000e }
        r1 = 10;
        r0.writeByte(r1);	 Catch:{ all -> 0x000e }
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.d.a(a.a.a.d$a, boolean):void");
    }

    boolean m21a() {
        return this.f37f >= AdError.SERVER_ERROR_CODE && this.f37f >= this.f36e.size();
    }

    boolean m22a(C0007b c0007b) {
        if (c0007b.f29f != null) {
            c0007b.f29f.m16a();
        }
        for (int i = 0; i < this.f34c; i++) {
            this.f33b.m373a(c0007b.f26c[i]);
            this.f42l -= c0007b.f25b[i];
            c0007b.f25b[i] = 0;
        }
        this.f37f++;
        this.f35d.writeUtf8("REMOVE").writeByte(32).writeUtf8(c0007b.f24a).writeByte(10);
        this.f36e.remove(c0007b.f24a);
        if (m21a()) {
            this.f44n.execute(this.f45o);
        }
        return true;
    }

    public synchronized boolean m23b() {
        return this.f39h;
    }

    void m24c() {
        while (this.f42l > this.f41k) {
            m22a((C0007b) this.f36e.values().iterator().next());
        }
        this.f40i = false;
    }

    public synchronized void close() {
        if (!this.f38g || this.f39h) {
            this.f39h = true;
        } else {
            for (C0007b c0007b : (C0007b[]) this.f36e.values().toArray(new C0007b[this.f36e.size()])) {
                if (c0007b.f29f != null) {
                    c0007b.f29f.m17b();
                }
            }
            m24c();
            this.f35d.close();
            this.f35d = null;
            this.f39h = true;
        }
    }

    public synchronized void flush() {
        if (this.f38g) {
            m19d();
            m24c();
            this.f35d.flush();
        }
    }
}
