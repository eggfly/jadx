public class ajz<S extends akh> {
    private final S DW;
    private final S FH;
    private ajx<S> Hw;
    private final aki<? super S> j6;
    private ajx<S> v5;

    public ajz(aki<? super S> aki__super_S, S s, S s2) {
        this.j6 = aki__super_S;
        this.DW = s;
        this.FH = s2;
    }

    public ajy<S> j6() {
        return new ajy(this.j6);
    }

    public ajx<S> DW() {
        if (this.Hw == null) {
            this.Hw = j6(this.DW);
        }
        return this.Hw;
    }

    public ajx<S> FH() {
        if (this.v5 == null) {
            this.v5 = j6(this.FH);
        }
        return this.v5;
    }

    private ajx<S> j6(S s) {
        int j6 = s.j6();
        int[] iArr = new int[j6];
        for (int i = 0; i < j6; i++) {
            iArr[i] = this.j6.j6(s, i);
        }
        return new ajx(s, iArr);
    }
}
