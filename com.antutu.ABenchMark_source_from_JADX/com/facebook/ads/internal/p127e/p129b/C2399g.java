package com.facebook.ads.internal.p127e.p129b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.p127e.p129b.p130a.C2377b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.e.b.g */
final class C2399g {
    private final AtomicInteger f8317a;
    private final String f8318b;
    private volatile C2390e f8319c;
    private final List<C2386b> f8320d;
    private final C2386b f8321e;
    private final C2387c f8322f;

    /* renamed from: com.facebook.ads.internal.e.b.g.a */
    private static final class C2398a extends Handler implements C2386b {
        private final String f8315a;
        private final List<C2386b> f8316b;

        public C2398a(String str, List<C2386b> list) {
            super(Looper.getMainLooper());
            this.f8315a = str;
            this.f8316b = list;
        }

        public void m9230a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (C2386b a : this.f8316b) {
                a.m9178a((File) message.obj, this.f8315a, message.arg1);
            }
        }
    }

    public C2399g(String str, C2387c c2387c) {
        this.f8317a = new AtomicInteger(0);
        this.f8320d = new CopyOnWriteArrayList();
        this.f8318b = (String) C2404j.m9249a(str);
        this.f8322f = (C2387c) C2404j.m9249a(c2387c);
        this.f8321e = new C2398a(str, this.f8320d);
    }

    private synchronized void m9231c() {
        this.f8319c = this.f8319c == null ? m9233e() : this.f8319c;
    }

    private synchronized void m9232d() {
        if (this.f8317a.decrementAndGet() <= 0) {
            this.f8319c.m9193a();
            this.f8319c = null;
        }
    }

    private C2390e m9233e() {
        C2390e c2390e = new C2390e(new C2401h(this.f8318b), new C2377b(this.f8322f.m9179a(this.f8318b), this.f8322f.f8280c));
        c2390e.m9202a(this.f8321e);
        return c2390e;
    }

    public void m9234a() {
        this.f8320d.clear();
        if (this.f8319c != null) {
            this.f8319c.m9202a(null);
            this.f8319c.m9193a();
            this.f8319c = null;
        }
        this.f8317a.set(0);
    }

    public void m9235a(C2388d c2388d, Socket socket) {
        m9231c();
        try {
            this.f8317a.incrementAndGet();
            this.f8319c.m9203a(c2388d, socket);
        } finally {
            m9232d();
        }
    }

    public int m9236b() {
        return this.f8317a.get();
    }
}
