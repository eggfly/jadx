final class apm$b {
    private apm$a j6;

    apm$b() {
    }

    apm$a j6() {
        apm$a apm_a = this.j6;
        if (apm_a == null) {
            return new apm$a();
        }
        this.j6 = apm_a.j6;
        apm_a.v5();
        return apm_a;
    }

    void j6(apm$a apm_a) {
        apm_a.j6 = this.j6;
        this.j6 = apm_a;
    }
}
