final class amv extends amp {
    private final char j6;

    amv(char c, boolean z) {
        super(z);
        this.j6 = c;
    }

    protected final boolean j6(char c) {
        return c != this.j6;
    }
}
