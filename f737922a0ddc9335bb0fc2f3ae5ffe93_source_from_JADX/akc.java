public abstract class akc extends ajr {
    public abstract <S extends akh> void j6(ajw ajw, ajy<S> ajy_S, ajx<S> ajx_S, ajx<S> ajx_S2, ajv ajv);

    public <S extends akh> ajw DW(aki<? super S> aki__super_S, S s, S s2) {
        ajz ajz = new ajz(aki__super_S, s, s2);
        ajy j6 = ajz.j6();
        ajx DW = ajz.DW();
        ajx FH = ajz.FH();
        ajw ajw = new ajw();
        j6(ajw, j6, DW, FH, new ajv(0, s.j6(), 0, s2.j6()));
        return ajw;
    }
}
