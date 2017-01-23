package com.google.android.gms.analytics.internal;

public abstract class t extends s {
    private boolean j6;

    protected t(v vVar) {
        super(vVar);
    }

    protected void P8() {
        if (!vy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public void ei() {
        j6();
        this.j6 = true;
    }

    protected abstract void j6();

    public boolean vy() {
        return this.j6;
    }
}
