package com.igexin.push.p174c;

/* renamed from: com.igexin.push.c.d */
public enum C3725d {
    NORMAL(0),
    BACKUP(1),
    TRY_NORMAL(2);
    
    private int f12568d;

    private C3725d(int i) {
        this.f12568d = -1;
        this.f12568d = i;
    }

    public static C3725d m15270a(int i) {
        for (C3725d c3725d : C3725d.m15271a()) {
            if (c3725d.m15272b() == i) {
                return c3725d;
            }
        }
        return null;
    }

    public static C3725d[] m15271a() {
        return (C3725d[]) f12567e.clone();
    }

    public int m15272b() {
        return this.f12568d;
    }
}
