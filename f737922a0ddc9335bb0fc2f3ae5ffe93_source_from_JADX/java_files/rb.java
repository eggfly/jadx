public final class rb extends rm {
    private final sb j6;

    public rb(sb sbVar) {
        super("LineNumberTable");
        try {
            if (sbVar.k_()) {
                throw new adn("lineNumbers.isMutable()");
            }
            this.j6 = sbVar;
        } catch (NullPointerException e) {
            throw new NullPointerException("lineNumbers == null");
        }
    }

    public int j6() {
        return (this.j6.m_() * 4) + 8;
    }

    public sb DW() {
        return this.j6;
    }
}
