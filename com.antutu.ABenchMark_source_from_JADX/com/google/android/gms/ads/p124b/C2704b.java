package com.google.android.gms.ads.p124b;

/* renamed from: com.google.android.gms.ads.b.b */
public final class C2704b {
    private final boolean f9233a;
    private final int f9234b;
    private final boolean f9235c;

    /* renamed from: com.google.android.gms.ads.b.b.a */
    public static final class C2703a {
        private boolean f9230a;
        private int f9231b;
        private boolean f9232c;

        public C2703a() {
            this.f9230a = false;
            this.f9231b = 0;
            this.f9232c = false;
        }

        public C2703a m10281a(int i) {
            this.f9231b = i;
            return this;
        }

        public C2703a m10282a(boolean z) {
            this.f9230a = z;
            return this;
        }

        public C2704b m10283a() {
            return new C2704b();
        }

        public C2703a m10284b(boolean z) {
            this.f9232c = z;
            return this;
        }
    }

    private C2704b(C2703a c2703a) {
        this.f9233a = c2703a.f9230a;
        this.f9234b = c2703a.f9231b;
        this.f9235c = c2703a.f9232c;
    }

    public boolean m10285a() {
        return this.f9233a;
    }

    public int m10286b() {
        return this.f9234b;
    }

    public boolean m10287c() {
        return this.f9235c;
    }
}
