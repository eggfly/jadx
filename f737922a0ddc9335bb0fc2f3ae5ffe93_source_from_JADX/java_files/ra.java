public final class ra extends rm {
    private final rp j6;

    public ra(rp rpVar) {
        super("InnerClasses");
        try {
            if (rpVar.k_()) {
                throw new adn("innerClasses.isMutable()");
            }
            this.j6 = rpVar;
        } catch (NullPointerException e) {
            throw new NullPointerException("innerClasses == null");
        }
    }

    public int j6() {
        return (this.j6.m_() * 8) + 8;
    }

    public rp DW() {
        return this.j6;
    }
}
