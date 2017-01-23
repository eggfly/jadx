package org.codehaus.groovy.util;

import java.lang.ref.ReferenceQueue;

public class ManagedReference<T> implements Finalizable {
    private static final ReferenceManager j6;
    private final Reference<T, ManagedReference<T>> DW;
    private final ReferenceManager FH;

    static class 1 extends ReferenceManager {
        1(ReferenceQueue referenceQueue) {
            super(referenceQueue);
        }
    }

    static {
        j6 = new 1(null);
    }

    public ManagedReference(ReferenceType referenceType, ReferenceManager referenceManager, T t) {
        if (referenceManager == null) {
            referenceManager = j6;
        }
        this.FH = referenceManager;
        this.DW = referenceType.j6(t, this, referenceManager.j6());
        referenceManager.j6(this.DW);
    }

    public ManagedReference(ReferenceBundle referenceBundle, T t) {
        this(referenceBundle.j6(), referenceBundle.DW(), t);
    }

    public final T J0() {
        return this.DW.get();
    }

    public final void J8() {
        this.DW.clear();
        this.FH.DW();
    }

    public void we() {
        J8();
    }
}
