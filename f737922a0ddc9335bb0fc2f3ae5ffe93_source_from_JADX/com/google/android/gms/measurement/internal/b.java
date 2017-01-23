package com.google.android.gms.measurement.internal;

abstract class b extends ak {
    private boolean j6;

    b(ai aiVar) {
        super(aiVar);
        this.J8.j6(this);
    }

    boolean DW() {
        return false;
    }

    protected void FH() {
        if (!j6()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void Hw() {
        if (this.j6) {
            throw new IllegalStateException("Can't initialize twice");
        }
        v5();
        this.J8.ro();
        this.j6 = true;
    }

    boolean j6() {
        return this.j6;
    }

    protected abstract void v5();
}
