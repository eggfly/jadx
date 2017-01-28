import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class ase$c extends SoftReference<aqx> {
    final long DW;
    final int FH;
    long Hw;
    final aro j6;
    private boolean v5;

    protected ase$c(aro aro, long j, aqx aqx, ReferenceQueue<aqx> referenceQueue) {
        super(aqx, referenceQueue);
        this.j6 = aro;
        this.DW = j;
        this.FH = aqx.j6();
    }

    final synchronized boolean j6() {
        boolean z = true;
        synchronized (this) {
            if (this.v5) {
                z = false;
            } else {
                this.v5 = true;
            }
        }
        return z;
    }
}
