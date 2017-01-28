class aro$a {
    final long DW;
    final int FH;
    final int Hw;
    final aro$a j6;
    final long v5;

    aro$a(aro$a aro_a, long j, int i, int i2, long j2) {
        this.j6 = aro_a;
        this.DW = j;
        this.FH = i;
        this.Hw = i2;
        this.v5 = j2;
    }

    anx j6(aro aro, asg asg) {
        while (this.j6 != null) {
            this = this.j6;
        }
        return DW(aro, asg);
    }

    private anx DW(aro aro, asg asg) {
        return new arf(this.DW, this.v5, this.Hw, aro, asg.DW);
    }
}
