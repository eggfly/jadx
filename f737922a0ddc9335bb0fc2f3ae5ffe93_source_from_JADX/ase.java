import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.eclipse.jgit.JGitText;

public class ase {
    private static volatile ase DW;
    private static volatile int FH;
    private static final Random j6;
    private final int EQ;
    private final ReferenceQueue<aqx> Hw;
    private final boolean J0;
    private final int J8;
    private final AtomicInteger QX;
    private final AtomicReferenceArray<ase$a> VH;
    private final int Ws;
    private final AtomicLong XL;
    private final AtomicLong Zo;
    private final ase$b[] gn;
    private final int tp;
    private final ReentrantLock u7;
    private final int v5;
    private final long we;

    private static final int j6(int i) {
        if (i < 4096) {
            throw new IllegalArgumentException(JGitText.j6().invalidWindowSize);
        } else if (Integer.bitCount(i) == 1) {
            return Integer.numberOfTrailingZeros(i);
        } else {
            throw new IllegalArgumentException(JGitText.j6().windowSizeMustBePowerOf2);
        }
    }

    static {
        j6 = new Random();
        j6(new asf());
    }

    public static void j6(asf asf) {
        ase ase = new ase(asf);
        ase ase2 = DW;
        if (ase2 != null) {
            ase2.Hw();
        }
        DW = ase;
        FH = asf.Zo();
        aqz.j6(asf);
    }

    static int j6() {
        return FH;
    }

    static final aqx j6(aro aro, long j) {
        ase ase = DW;
        aqx FH = ase.FH(aro, ase.j6(j));
        if (ase != DW) {
            ase.Hw();
        }
        return FH;
    }

    static final void j6(aro aro) {
        DW.FH(aro);
    }

    private ase(asf asf) {
        this.v5 = DW(asf);
        int FH = FH(asf);
        if (this.v5 < 1) {
            throw new IllegalArgumentException(JGitText.j6().tSizeMustBeGreaterOrEqual1);
        } else if (FH < 1) {
            throw new IllegalArgumentException(JGitText.j6().lockCountMustBeGreaterOrEqual1);
        } else {
            this.Hw = new ReferenceQueue();
            this.Zo = new AtomicLong(1);
            this.VH = new AtomicReferenceArray(this.v5);
            this.gn = new ase$b[FH];
            for (FH = 0; FH < this.gn.length; FH++) {
                this.gn[FH] = new ase$b();
            }
            this.u7 = new ReentrantLock();
            FH = (int) (((double) this.v5) * 0.1d);
            if (64 < FH) {
                FH = 64;
            } else if (FH < 4) {
                FH = 4;
            }
            if (this.v5 < FH) {
                FH = this.v5;
            }
            this.tp = FH;
            this.EQ = asf.j6();
            this.we = asf.DW();
            this.J0 = asf.Hw();
            this.J8 = j6(asf.FH());
            this.Ws = 1 << this.J8;
            this.QX = new AtomicInteger();
            this.XL = new AtomicLong();
            if (this.EQ < 1) {
                throw new IllegalArgumentException(JGitText.j6().openFilesMustBeAtLeast1);
            } else if (this.we < ((long) this.Ws)) {
                throw new IllegalArgumentException(JGitText.j6().windowSizeMustBeLesserThanLimit);
            }
        }
    }

    private int j6(int i, long j) {
        return ((int) (j >>> this.J8)) + i;
    }

    private aqx DW(aro aro, long j) {
        if (aro.VH()) {
            this.QX.incrementAndGet();
        }
        try {
            if (this.J0) {
                return aro.DW(j, this.Ws);
            }
            return aro.j6(j, this.Ws);
        } catch (IOException e) {
            DW(aro);
            throw e;
        } catch (RuntimeException e2) {
            DW(aro);
            throw e2;
        } catch (Error e3) {
            DW(aro);
            throw e3;
        }
    }

    private ase$c j6(aro aro, long j, aqx aqx) {
        ase$c ase_c = new ase$c(aro, j, aqx, this.Hw);
        this.XL.addAndGet((long) ase_c.FH);
        return ase_c;
    }

    private void j6(ase$c ase_c) {
        this.XL.addAndGet((long) (-ase_c.FH));
        DW(ase_c.j6);
    }

    private void DW(aro aro) {
        if (aro.gn()) {
            this.QX.decrementAndGet();
        }
    }

    private boolean DW() {
        return this.EQ < this.QX.get() || this.we < this.XL.get();
    }

    private long j6(long j) {
        return (j >>> this.J8) << this.J8;
    }

    private static int DW(asf asf) {
        int FH = asf.FH();
        long DW = asf.DW();
        if (FH <= 0) {
            throw new IllegalArgumentException(JGitText.j6().invalidWindowSize);
        } else if (DW >= ((long) FH)) {
            return (int) Math.min(((DW / ((long) FH)) * 5) / 2, 2000000000);
        } else {
            throw new IllegalArgumentException(JGitText.j6().windowSizeMustBeLesserThanLimit);
        }
    }

    private static int FH(asf asf) {
        return Math.max(asf.j6(), 32);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private aqx FH(aro r9, long r10) {
        /*
        r8 = this;
        r3 = r8.Hw(r9, r10);
        r0 = r8.VH;
        r0 = r0.get(r3);
        r0 = (ase$a) r0;
        r1 = r8.j6(r0, r9, r10);
        if (r1 == 0) goto L_0x0014;
    L_0x0012:
        r0 = r1;
    L_0x0013:
        return r0;
    L_0x0014:
        r4 = r8.v5(r9, r10);
        monitor-enter(r4);
        r1 = r8.VH;	 Catch:{ all -> 0x002b }
        r1 = r1.get(r3);	 Catch:{ all -> 0x002b }
        r1 = (ase$a) r1;	 Catch:{ all -> 0x002b }
        if (r1 == r0) goto L_0x002e;
    L_0x0023:
        r0 = r8.j6(r1, r9, r10);	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x002e;
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        goto L_0x0013;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r2 = r8.DW(r9, r10);	 Catch:{ all -> 0x002b }
        r5 = r8.j6(r9, r10, r2);	 Catch:{ all -> 0x002b }
        r8.DW(r5);	 Catch:{ all -> 0x002b }
    L_0x0039:
        r0 = new ase$a;	 Catch:{ all -> 0x002b }
        r6 = j6(r1);	 Catch:{ all -> 0x002b }
        r0.<init>(r6, r5);	 Catch:{ all -> 0x002b }
        r6 = r8.VH;	 Catch:{ all -> 0x002b }
        r0 = r6.compareAndSet(r3, r1, r0);	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0060;
    L_0x004a:
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        r0 = r8.u7;
        r0 = r0.tryLock();
        if (r0 == 0) goto L_0x005e;
    L_0x0053:
        r8.v5();	 Catch:{ all -> 0x006a }
        r8.FH();	 Catch:{ all -> 0x006a }
        r0 = r8.u7;
        r0.unlock();
    L_0x005e:
        r0 = r2;
        goto L_0x0013;
    L_0x0060:
        r0 = r8.VH;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r3);	 Catch:{ all -> 0x002b }
        r0 = (ase$a) r0;	 Catch:{ all -> 0x002b }
        r1 = r0;
        goto L_0x0039;
    L_0x006a:
        r0 = move-exception;
        r1 = r8.u7;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ase.FH(aro, long):aqx");
    }

    private aqx j6(ase$a ase_a, aro aro, long j) {
        while (ase_a != null) {
            ase$c ase_c = ase_a.DW;
            if (ase_c.j6 == aro && ase_c.DW == j) {
                aqx aqx = (aqx) ase_c.get();
                if (aqx != null) {
                    DW(ase_c);
                    return aqx;
                }
                ase_a.j6();
                return null;
            }
            ase_a = ase_a.j6;
        }
        return null;
    }

    private void DW(ase$c ase_c) {
        long j = this.Zo.get();
        this.Zo.compareAndSet(j, 1 + j);
        ase_c.Hw = j;
    }

    private void FH() {
        while (DW()) {
            int nextInt = j6.nextInt(this.v5);
            int i = this.tp - 1;
            ase$a ase_a = null;
            int i2 = 0;
            while (i >= 0) {
                if (this.v5 <= nextInt) {
                    nextInt = 0;
                }
                int i3 = i2;
                ase$a ase_a2 = ase_a;
                ase_a = (ase$a) this.VH.get(nextInt);
                while (ase_a != null) {
                    if (!ase_a.FH && (ase_a2 == null || ase_a.DW.Hw < ase_a2.DW.Hw)) {
                        i3 = nextInt;
                        ase_a2 = ase_a;
                    }
                    ase_a = ase_a.j6;
                }
                nextInt++;
                i--;
                ase_a = ase_a2;
                i2 = i3;
            }
            if (ase_a != null) {
                ase_a.j6();
                v5();
                ase$a ase_a3 = (ase$a) this.VH.get(i2);
                this.VH.compareAndSet(i2, ase_a3, j6(ase_a3));
            }
        }
    }

    private void Hw() {
        for (int i = 0; i < this.v5; i++) {
            ase$a ase_a;
            do {
                ase_a = (ase$a) this.VH.get(i);
                for (ase$a ase_a2 = ase_a; ase_a2 != null; ase_a2 = ase_a2.j6) {
                    ase_a2.j6();
                }
            } while (!this.VH.compareAndSet(i, ase_a, null));
        }
        v5();
    }

    private void FH(aro aro) {
        for (int i = 0; i < this.v5; i++) {
            ase$a ase_a = (ase$a) this.VH.get(i);
            Object obj = null;
            for (ase$a ase_a2 = ase_a; ase_a2 != null; ase_a2 = ase_a2.j6) {
                if (ase_a2.DW.j6 == aro) {
                    ase_a2.j6();
                    obj = 1;
                } else if (ase_a2.FH) {
                    int i2 = 1;
                }
            }
            if (obj != null) {
                this.VH.compareAndSet(i, ase_a, j6(ase_a));
            }
        }
        v5();
    }

    private void v5() {
        while (true) {
            ase$c ase_c = (ase$c) this.Hw.poll();
            if (ase_c != null) {
                if (ase_c.j6()) {
                    boolean z;
                    j6(ase_c);
                    int Hw = Hw(ase_c.j6, ase_c.DW);
                    ase$a ase_a = (ase$a) this.VH.get(Hw);
                    for (ase$a ase_a2 = ase_a; ase_a2 != null; ase_a2 = ase_a2.j6) {
                        if (ase_a2.DW == ase_c) {
                            ase_a2.FH = true;
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        this.VH.compareAndSet(Hw, ase_a, j6(ase_a));
                    }
                }
            } else {
                return;
            }
        }
    }

    private int Hw(aro aro, long j) {
        return (j6(aro.DW, j) >>> 1) % this.v5;
    }

    private ase$b v5(aro aro, long j) {
        return this.gn[(j6(aro.DW, j) >>> 1) % this.gn.length];
    }

    private static ase$a j6(ase$a ase_a) {
        ase$a ase_a2 = ase_a;
        while (ase_a2 != null && ase_a2.FH) {
            ase_a2.DW.enqueue();
            ase_a2 = ase_a2.j6;
        }
        if (ase_a2 == null) {
            return null;
        }
        ase$a j6 = j6(ase_a2.j6);
        return j6 != ase_a2.j6 ? new ase$a(j6, ase_a2.DW) : ase_a2;
    }
}
