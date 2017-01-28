public final class aaf extends zo {
    private final abn j6;

    public static String j6(abn abn) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("catch");
        int m_ = abn.m_();
        for (int i = 0; i < m_; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(abn.j6(i).Hw());
        }
        return stringBuffer.toString();
    }

    public aaf(zz zzVar, aac aac, zx zxVar, abn abn) {
        super(zzVar, aac, null, zxVar);
        if (zzVar.Hw() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (abn == null) {
            throw new NullPointerException("catches == null");
        } else {
            this.j6 = abn;
        }
    }

    public String j6() {
        return j6(this.j6);
    }

    public abn DW() {
        return this.j6;
    }

    public void j6(zo$b zo_b) {
        zo_b.j6(this);
    }

    public zo j6(abl abl) {
        return new aaf(Zo(), VH(), tp(), this.j6.j6(abl));
    }

    public zo j6(zw zwVar, zx zxVar) {
        return new aaf(Zo(), VH(), zxVar, this.j6);
    }
}
