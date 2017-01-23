public final class qw extends rm {
    private final abh j6;

    public qw(abh abh) {
        super("ConstantValue");
        if ((abh instanceof abe) || (abh instanceof aat) || (abh instanceof aaz) || (abh instanceof aas) || (abh instanceof aap)) {
            this.j6 = abh;
        } else if (abh == null) {
            throw new NullPointerException("constantValue == null");
        } else {
            throw new IllegalArgumentException("bad type for constantValue");
        }
    }

    public int j6() {
        return 8;
    }

    public abh DW() {
        return this.j6;
    }
}
