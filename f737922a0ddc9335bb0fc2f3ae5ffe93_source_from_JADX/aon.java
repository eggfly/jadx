import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class aon implements aob {
    static final /* synthetic */ boolean j6;
    private final aob DW;
    private final ReentrantLock FH;
    private final Thread Hw;
    private final Semaphore VH;
    private final AtomicInteger Zo;
    private final AtomicInteger v5;

    static {
        j6 = !aon.class.desiredAssertionStatus();
    }

    public aon(aob aob) {
        this.DW = aob;
        this.FH = new ReentrantLock();
        this.Hw = Thread.currentThread();
        this.v5 = new AtomicInteger(0);
        this.Zo = new AtomicInteger(0);
        this.VH = new Semaphore(0);
    }

    public void DW(int i) {
        if (Zo()) {
            this.DW.DW(i);
            return;
        }
        throw new IllegalStateException();
    }

    public void j6(String str, int i) {
        if (Zo()) {
            this.DW.j6(str, i);
            return;
        }
        throw new IllegalStateException();
    }

    public void FH(int i) {
        this.v5.addAndGet(i);
    }

    public void FH() {
        if (this.v5.decrementAndGet() == 0) {
            this.VH.release();
        }
    }

    public void Hw() {
        if (j6 || Zo()) {
            while (this.v5.get() > 0) {
                v5();
                this.VH.acquire();
            }
            v5();
            return;
        }
        throw new AssertionError();
    }

    private void v5() {
        int andSet = this.Zo.getAndSet(0);
        if (andSet > 0) {
            this.DW.j6(andSet);
        }
    }

    public void j6(int i) {
        int andAdd = this.Zo.getAndAdd(i);
        if (Zo()) {
            v5();
        } else if (andAdd == 0) {
            this.VH.release();
        }
    }

    public boolean j6() {
        this.FH.lock();
        try {
            boolean j6 = this.DW.j6();
            return j6;
        } finally {
            this.FH.unlock();
        }
    }

    public void DW() {
        if (Zo()) {
            this.DW.DW();
            return;
        }
        throw new IllegalStateException();
    }

    private boolean Zo() {
        return Thread.currentThread() == this.Hw;
    }
}
