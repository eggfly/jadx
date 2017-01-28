public abstract class xb extends xc {
    private int j6;

    public xb() {
        this.j6 = -1;
    }

    public final boolean Zo() {
        return this.j6 >= 0;
    }

    public final int VH() {
        if (this.j6 >= 0) {
            return this.j6;
        }
        throw new RuntimeException("index not yet set");
    }

    public final void j6(int i) {
        if (this.j6 != -1) {
            throw new RuntimeException("index already set");
        }
        this.j6 = i;
    }

    public final String gn() {
        return '[' + Integer.toHexString(this.j6) + ']';
    }
}
