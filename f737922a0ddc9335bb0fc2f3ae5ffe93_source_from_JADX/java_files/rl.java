public abstract class rl extends rm {
    private final int DW;
    private final ze j6;

    public rl(String str, ze zeVar, int i) {
        super(str);
        try {
            if (zeVar.k_()) {
                throw new adn("annotations.isMutable()");
            }
            this.j6 = zeVar;
            this.DW = i;
        } catch (NullPointerException e) {
            throw new NullPointerException("annotations == null");
        }
    }

    public final int j6() {
        return this.DW + 6;
    }

    public final ze DW() {
        return this.j6;
    }
}
