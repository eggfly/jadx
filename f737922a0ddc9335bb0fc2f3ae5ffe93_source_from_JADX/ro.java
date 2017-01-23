public abstract class ro extends rm {
    private final int DW;
    private final zf j6;

    public ro(String str, zf zfVar, int i) {
        super(str);
        try {
            if (zfVar.k_()) {
                throw new adn("parameterAnnotations.isMutable()");
            }
            this.j6 = zfVar;
            this.DW = i;
        } catch (NullPointerException e) {
            throw new NullPointerException("parameterAnnotations == null");
        }
    }

    public final int j6() {
        return this.DW + 6;
    }

    public final zf DW() {
        return this.j6;
    }
}
