package org.codehaus.groovy.util;

public abstract class LazyReference<T> extends LockableObject {
    private static final ManagedReference DW;
    private static final ManagedReference j6;
    private ManagedReference<T> FH;
    private final ReferenceBundle v5;

    static class 1 extends ManagedReference {
        1(ReferenceType referenceType, ReferenceManager referenceManager, Object obj) {
            super(referenceType, referenceManager, obj);
        }
    }

    static class 2 extends ManagedReference {
        2(ReferenceType referenceType, ReferenceManager referenceManager, Object obj) {
            super(referenceType, referenceManager, obj);
        }
    }

    public abstract T DW();

    static {
        j6 = new 1(ReferenceType.HARD, null, null);
        DW = new 2(ReferenceType.HARD, null, null);
    }

    public LazyReference(ReferenceBundle referenceBundle) {
        this.FH = j6;
        this.v5 = referenceBundle;
    }

    public T FH() {
        ManagedReference managedReference = this.FH;
        if (managedReference == j6) {
            return j6(false);
        }
        if (managedReference == DW) {
            return null;
        }
        T J0 = managedReference.J0();
        if (J0 == null) {
            return j6(true);
        }
        return J0;
    }

    private T j6(boolean z) {
        Hw();
        try {
            ManagedReference managedReference = this.FH;
            T DW;
            if (z || managedReference == j6) {
                DW = DW();
                if (DW == null) {
                    this.FH = DW;
                } else {
                    this.FH = new ManagedReference(this.v5, DW);
                }
                v5();
                return DW;
            }
            DW = managedReference.J0();
            return DW;
        } finally {
            v5();
        }
    }

    public String toString() {
        Object J0 = this.FH.J0();
        if (J0 == null) {
            return "<null>";
        }
        return J0.toString();
    }
}
