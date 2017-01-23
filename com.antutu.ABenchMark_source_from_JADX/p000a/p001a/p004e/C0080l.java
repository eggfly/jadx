package p000a.p001a.p004e;

import java.util.concurrent.CountDownLatch;

/* renamed from: a.a.e.l */
final class C0080l {
    private final CountDownLatch f323a;
    private long f324b;
    private long f325c;

    C0080l() {
        this.f323a = new CountDownLatch(1);
        this.f324b = -1;
        this.f325c = -1;
    }

    void m352a() {
        if (this.f324b != -1) {
            throw new IllegalStateException();
        }
        this.f324b = System.nanoTime();
    }

    void m353b() {
        if (this.f325c != -1 || this.f324b == -1) {
            throw new IllegalStateException();
        }
        this.f325c = System.nanoTime();
        this.f323a.countDown();
    }

    void m354c() {
        if (this.f325c != -1 || this.f324b == -1) {
            throw new IllegalStateException();
        }
        this.f325c = this.f324b - 1;
        this.f323a.countDown();
    }
}
