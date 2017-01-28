public class adm {
    private boolean j6;

    public adm() {
        this.j6 = true;
    }

    public adm(boolean z) {
        this.j6 = z;
    }

    public void l_() {
        this.j6 = false;
    }

    public final boolean EQ() {
        return !this.j6;
    }

    public final boolean k_() {
        return this.j6;
    }

    public final void we() {
        if (!this.j6) {
            throw new adn("immutable instance");
        }
    }

    public final void J0() {
        if (this.j6) {
            throw new adn("mutable instance");
        }
    }
}
