class abp$2 extends acd {
    final /* synthetic */ zw DW;
    final /* synthetic */ abp FH;
    final /* synthetic */ zw j6;

    abp$2(abp abp, zw zwVar, zw zwVar2) {
        this.FH = abp;
        this.j6 = zwVar;
        this.DW = zwVar2;
    }

    public int j6() {
        return this.FH.FH.VH();
    }

    public zw j6(zw zwVar) {
        if (zwVar.VH() == this.j6.VH()) {
            return this.DW.j6(zwVar.u7());
        }
        return zwVar;
    }
}
