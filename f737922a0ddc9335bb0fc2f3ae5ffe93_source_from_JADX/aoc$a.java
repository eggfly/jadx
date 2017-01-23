public enum aoc$a {
    NEW(true, false),
    LOOSE(true, false),
    PACKED(false, true),
    LOOSE_PACKED(true, true),
    NETWORK(false, false);
    
    private final boolean VH;
    private final boolean Zo;

    private aoc$a(boolean z, boolean z2) {
        this.Zo = z;
        this.VH = z2;
    }

    public boolean j6() {
        return this.Zo;
    }

    public boolean DW() {
        return this.VH;
    }
}
