package org.codehaus.groovy.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ReferenceManager {
    private static final ReferenceBundle DW;
    private static final ReferenceBundle FH;
    private ReferenceQueue j6;

    static class 1 extends ReferenceManager {
        1(ReferenceQueue referenceQueue) {
            super(referenceQueue);
        }

        public void DW() {
            ReferenceQueue j6 = j6();
            while (true) {
                Reference poll = j6.poll();
                if (poll != null) {
                    if (poll instanceof Reference) {
                        Finalizable j62 = ((Reference) poll).j6();
                        if (j62 != null) {
                            j62.we();
                        }
                    }
                    poll.clear();
                } else {
                    return;
                }
            }
        }

        public void j6(Reference reference) {
            DW();
        }

        public String toString() {
            return "ReferenceManager(callback)";
        }
    }

    static class 2 extends ReferenceManager {
        final /* synthetic */ ReferenceManager DW;
        final /* synthetic */ int FH;
        private AtomicInteger Hw;
        final /* synthetic */ ReferenceQueue j6;
        private volatile ReferenceManager v5;

        2(ReferenceQueue referenceQueue, ReferenceQueue referenceQueue2, ReferenceManager referenceManager, int i) {
            this.j6 = referenceQueue2;
            this.DW = referenceManager;
            this.FH = i;
            super(referenceQueue);
            this.Hw = new AtomicInteger();
            this.v5 = ReferenceManager.j6(this.j6);
        }

        public void j6(Reference reference) {
            if (this.v5 == this.DW) {
                this.DW.j6(reference);
                return;
            }
            int incrementAndGet = this.Hw.incrementAndGet();
            if (incrementAndGet > this.FH || incrementAndGet < 0) {
                this.v5 = this.DW;
            }
        }

        public String toString() {
            return "ReferenceManager(thresholded, current manager=" + this.v5 + ", threshold=" + this.Hw.get() + "/" + this.FH + ")";
        }
    }

    private static class ThreadedReferenceManager extends ReferenceManager {
        private volatile boolean DW;
        private final Thread j6;

        class 1 extends Thread {
            final /* synthetic */ ThreadedReferenceManager j6;

            public void run() {
                ReferenceQueue j6 = this.j6.j6();
                while (this.j6.DW) {
                    try {
                        Reference remove = j6.remove(1000);
                        if (remove != null) {
                            if (remove instanceof Reference) {
                                Finalizable j62 = ((Reference) remove).j6();
                                if (j62 != null) {
                                    j62.we();
                                }
                            }
                            remove.clear();
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }

        public String toString() {
            return "ReferenceManager(threaded, thread=" + this.j6 + ")";
        }
    }

    public static ReferenceManager j6(ReferenceQueue referenceQueue) {
        return new ReferenceManager(referenceQueue);
    }

    public static ReferenceManager DW(ReferenceQueue referenceQueue) {
        return new 1(referenceQueue);
    }

    public static ReferenceManager j6(ReferenceQueue referenceQueue, ReferenceManager referenceManager, int i) {
        if (i >= 0) {
            return new 2(referenceQueue, referenceQueue, referenceManager, i);
        }
        throw new IllegalArgumentException("threshold must not be below 0.");
    }

    public ReferenceManager(ReferenceQueue referenceQueue) {
        this.j6 = referenceQueue;
    }

    protected ReferenceQueue j6() {
        return this.j6;
    }

    public void j6(Reference reference) {
    }

    public void DW() {
    }

    public String toString() {
        return "ReferenceManager(idling)";
    }

    static {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        ReferenceManager j6 = j6(referenceQueue, DW(referenceQueue), 500);
        DW = new ReferenceBundle(j6, ReferenceType.SOFT);
        FH = new ReferenceBundle(j6, ReferenceType.WEAK);
    }
}
