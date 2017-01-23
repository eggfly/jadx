package com.google.android.gms.ads.formats;

public final class b {
    private final int DW;
    private final boolean FH;
    private final boolean j6;

    public static final class a {
        private int DW;
        private boolean FH;
        private boolean j6;

        public a() {
            this.j6 = false;
            this.DW = 0;
            this.FH = false;
        }

        public a DW(boolean z) {
            this.FH = z;
            return this;
        }

        public a j6(int i) {
            this.DW = i;
            return this;
        }

        public a j6(boolean z) {
            this.j6 = z;
            return this;
        }

        public b j6() {
            return new b();
        }
    }

    private b(a aVar) {
        this.j6 = aVar.j6;
        this.DW = aVar.DW;
        this.FH = aVar.FH;
    }

    public int DW() {
        return this.DW;
    }

    public boolean FH() {
        return this.FH;
    }

    public boolean j6() {
        return this.j6;
    }
}
