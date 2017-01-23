package com.google.android.gms.gcm;

public class b {
    public static final b DW;
    public static final b j6;
    private final int FH;
    private final int Hw;
    private final int v5;

    static {
        j6 = new b(0, 30, 3600);
        DW = new b(1, 30, 3600);
    }

    private b(int i, int i2, int i3) {
        this.FH = i;
        this.Hw = i2;
        this.v5 = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.FH == this.FH && bVar.Hw == this.Hw && bVar.v5 == this.v5;
    }

    public int hashCode() {
        return (((((this.FH + 1) ^ 1000003) * 1000003) ^ this.Hw) * 1000003) ^ this.v5;
    }

    public String toString() {
        int i = this.FH;
        int i2 = this.Hw;
        return "policy=" + i + " initial_backoff=" + i2 + " maximum_backoff=" + this.v5;
    }
}
