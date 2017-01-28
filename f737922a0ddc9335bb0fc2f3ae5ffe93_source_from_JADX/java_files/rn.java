public abstract class rn extends rm {
    private final sc j6;

    public rn(String str, sc scVar) {
        super(str);
        try {
            if (scVar.k_()) {
                throw new adn("localVariables.isMutable()");
            }
            this.j6 = scVar;
        } catch (NullPointerException e) {
            throw new NullPointerException("localVariables == null");
        }
    }

    public final int j6() {
        return (this.j6.m_() * 10) + 8;
    }

    public final sc DW() {
        return this.j6;
    }
}
