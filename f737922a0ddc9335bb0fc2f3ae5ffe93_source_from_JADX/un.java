public final class un extends adc {
    public static final un j6;

    static {
        j6 = new un(0);
    }

    public un(int i) {
        super(i);
    }

    public un$b j6(int i) {
        return (un$b) v5(i);
    }

    public void j6(int i, un$b un_b) {
        j6(i, un_b);
    }

    public static un j6(ug ugVar) {
        int m_ = ugVar.m_();
        un$c un_c = new un$c(m_);
        for (int i = 0; i < m_; i++) {
            uf j6 = ugVar.j6(i);
            if (j6 instanceof uo) {
                un_c.j6(j6.VH(), ((uo) j6).FH());
            } else if (j6 instanceof up) {
                un_c.j6(j6.VH(), ((up) j6).FH());
            } else if (j6 instanceof um) {
                un_c.DW(j6.VH(), ((um) j6).FH());
            }
        }
        return un_c.j6();
    }
}
