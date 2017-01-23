package p000a;

import java.io.Closeable;
import java.io.Flushable;
import p000a.p001a.p002a.C0008d;
import p000a.p001a.p002a.C0009e;

/* renamed from: a.c */
public final class C0106c implements Closeable, Flushable {
    final C0009e f394a;
    final C0008d f395b;

    public void close() {
        this.f395b.close();
    }

    public void flush() {
        this.f395b.flush();
    }
}
