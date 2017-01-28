import com.aide.uidesigner.ProxyTextView;

public final class ut extends adc {
    public static final ut j6;

    static {
        j6 = new ut(0);
    }

    public static ut j6(ug ugVar, int i) {
        int i2 = 0;
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j6;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                aac aac = aac.j6;
                int m_ = ugVar.m_();
                ut$a[] ut_aArr = new ut$a[m_];
                int i3 = 0;
                int i4 = 0;
                aac aac2 = aac;
                for (int i5 = 0; i5 < m_; i5++) {
                    uf j6 = ugVar.j6(i5);
                    if (j6 instanceof uc) {
                        i4 = 1;
                    } else {
                        aac u7 = j6.u7();
                        if (!(u7.equals(aac) || u7.j6(r3) || (i == 3 && r1 == 0))) {
                            ut_aArr[i3] = new ut$a(j6.VH(), u7);
                            i3++;
                            i4 = 0;
                            aac2 = u7;
                        }
                    }
                }
                ut utVar = new ut(i3);
                while (i2 < i3) {
                    utVar.j6(i2, ut_aArr[i2]);
                    i2++;
                }
                utVar.l_();
                return utVar;
            default:
                throw new IllegalArgumentException("bogus howMuch");
        }
    }

    public ut(int i) {
        super(i);
    }

    public ut$a j6(int i) {
        return (ut$a) v5(i);
    }

    public void j6(int i, ut$a ut_a) {
        j6(i, ut_a);
    }
}
