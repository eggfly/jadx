public final class uq extends va {
    public uq(aac aac) {
        super(aac, zx.j6);
    }

    public int j6() {
        return VH() & 1;
    }

    public void j6(acr acr) {
        if (j6() != 0) {
            acr.DW(ul.j6(0, 0));
        }
    }

    public uf j6(zx zxVar) {
        return new uq(u7());
    }

    protected String DW() {
        return null;
    }

    protected String j6(boolean z) {
        if (j6() == 0) {
            return null;
        }
        return "nop // spacer";
    }
}
