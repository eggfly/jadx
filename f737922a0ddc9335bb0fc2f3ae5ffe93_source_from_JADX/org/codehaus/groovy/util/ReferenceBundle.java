package org.codehaus.groovy.util;

import java.lang.ref.ReferenceQueue;

public class ReferenceBundle {
    private static final ReferenceBundle FH;
    private static final ReferenceBundle Hw;
    private static final ReferenceBundle Zo;
    private static final ReferenceBundle v5;
    private ReferenceType DW;
    private ReferenceManager j6;

    public ReferenceBundle(ReferenceManager referenceManager, ReferenceType referenceType) {
        this.j6 = referenceManager;
        this.DW = referenceType;
    }

    public ReferenceType j6() {
        return this.DW;
    }

    public ReferenceManager DW() {
        return this.j6;
    }

    static {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        ReferenceManager j6 = ReferenceManager.j6(referenceQueue, ReferenceManager.DW(referenceQueue), 5000);
        FH = new ReferenceBundle(j6, ReferenceType.SOFT);
        Hw = new ReferenceBundle(j6, ReferenceType.WEAK);
        Zo = new ReferenceBundle(j6, ReferenceType.PHANTOM);
        v5 = new ReferenceBundle(ReferenceManager.j6(null), ReferenceType.HARD);
    }

    public static ReferenceBundle FH() {
        return FH;
    }

    public static ReferenceBundle Hw() {
        return Hw;
    }
}
