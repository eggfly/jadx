public final class qz extends rm {
    private final abn j6;

    public qz(abn abn) {
        super("Exceptions");
        try {
            if (abn.k_()) {
                throw new adn("exceptions.isMutable()");
            }
            this.j6 = abn;
        } catch (NullPointerException e) {
            throw new NullPointerException("exceptions == null");
        }
    }

    public int j6() {
        return (this.j6.m_() * 2) + 8;
    }

    public abn DW() {
        return this.j6;
    }
}
