package com.qq.p035e.comm.adevent;

/* renamed from: com.qq.e.comm.adevent.ADEvent */
public class ADEvent {
    private final int f13446a;
    private final Object[] f13447b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f13446a = i;
        this.f13447b = objArr;
    }

    public Object[] getParas() {
        return this.f13447b == null ? new Object[0] : this.f13447b;
    }

    public int getType() {
        return this.f13446a;
    }
}
