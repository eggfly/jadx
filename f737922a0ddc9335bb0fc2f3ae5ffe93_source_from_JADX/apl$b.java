final class apl$b {
    private apl$a j6;

    apl$b() {
    }

    apl$a j6() {
        apl$a apl_a = this.j6;
        if (apl_a == null) {
            return new apl$a();
        }
        this.j6 = apl_a.j6;
        apl_a.Hw();
        return apl_a;
    }

    void j6(apl$a apl_a) {
        apl_a.j6 = this.j6;
        this.j6 = apl_a;
    }
}
