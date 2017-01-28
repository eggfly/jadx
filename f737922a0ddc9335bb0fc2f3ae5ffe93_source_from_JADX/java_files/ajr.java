import com.aide.uidesigner.ProxyTextView;

public abstract class ajr {
    private static /* synthetic */ int[] DW;
    private static /* synthetic */ int[] j6;

    public abstract <S extends akh> ajw DW(aki<? super S> aki__super_S, S s, S s2);

    static /* synthetic */ int[] DW() {
        int[] iArr = DW;
        if (iArr == null) {
            iArr = new int[ajv$a.values().length];
            try {
                iArr[ajv$a.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajv$a.EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ajv$a.INSERT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ajv$a.REPLACE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            DW = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] j6() {
        int[] iArr = j6;
        if (iArr == null) {
            iArr = new int[ajr$a.values().length];
            try {
                iArr[ajr$a.HISTOGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajr$a.MYERS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            j6 = iArr;
        }
        return iArr;
    }

    public static ajr j6(ajr$a ajr_a) {
        switch (j6()[ajr_a.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return akd.j6;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return new aka();
            default:
                throw new IllegalArgumentException();
        }
    }

    public <S extends akh> ajw j6(aki<? super S> aki__super_S, S s, S s2) {
        ajv j6 = aki__super_S.j6(s, s2, j6(s, s2));
        switch (DW()[j6.j6().ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return ajw.j6(j6);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                aki akm = new akm(aki__super_S);
                akl j62 = akl.j6(s, j6);
                akl DW = akl.DW(s2, j6);
                ajw j63 = akl.j6(DW(akm, j62, DW), j62, DW);
                j6 = (ajv) j63.get(j63.size() - 1);
                if (j6.j6() == ajv$a.INSERT) {
                    while (j6.Hw < s2.j6() && aki__super_S.j6(s2, j6.FH, s2, j6.Hw)) {
                        j6.j6++;
                        j6.DW++;
                        j6.FH++;
                        j6.Hw++;
                    }
                }
                return j63;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return new ajw(0);
            default:
                throw new IllegalStateException();
        }
    }

    private static <S extends akh> ajv j6(S s, S s2) {
        return new ajv(0, s.j6(), 0, s2.j6());
    }
}
