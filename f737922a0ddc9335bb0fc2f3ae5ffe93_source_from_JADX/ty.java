public final class ty {
    private final uc[] DW;
    private final uc[] FH;
    private final uc[] j6;

    public ty(aaa aaa) {
        int tp = aaa.j6().tp();
        this.j6 = new uc[tp];
        this.DW = new uc[tp];
        this.FH = new uc[tp];
        j6(aaa);
    }

    public uc j6(zi ziVar) {
        return this.j6[ziVar.j6()];
    }

    public uc j6(int i) {
        return this.j6[i];
    }

    public uc DW(zi ziVar) {
        return this.DW[ziVar.j6()];
    }

    public uc FH(zi ziVar) {
        return this.FH[ziVar.j6()];
    }

    private void j6(aaa aaa) {
        zj j6 = aaa.j6();
        int m_ = j6.m_();
        for (int i = 0; i < m_; i++) {
            zi j62 = j6.j6(i);
            int j63 = j62.j6();
            this.j6[j63] = new uc(j62.DW().j6(0).VH());
            aac VH = j62.VH().VH();
            this.DW[j63] = new uc(VH);
            this.FH[j63] = new uc(VH);
        }
    }
}
