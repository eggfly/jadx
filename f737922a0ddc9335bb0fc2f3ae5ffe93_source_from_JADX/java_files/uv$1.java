class uv$1 extends zo$a {
    final /* synthetic */ int DW;
    final /* synthetic */ int FH;
    final /* synthetic */ boolean[] j6;

    uv$1(boolean[] zArr, int i, int i2) {
        this.j6 = zArr;
        this.DW = i;
        this.FH = i2;
    }

    public void j6(zt ztVar) {
        if (ztVar.Zo().j6() == 3) {
            boolean z;
            int r_ = ((aat) ztVar.p_()).r_();
            boolean[] zArr = this.j6;
            if (this.j6[0] && r_ + (this.DW - this.FH) == ztVar.gn().VH()) {
                z = true;
            } else {
                z = false;
            }
            zArr[0] = z;
        }
    }
}
