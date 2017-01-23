import java.util.Iterator;

public final class akl<S extends akh> extends akh {
    final int DW;
    private final int FH;
    final S j6;

    public static <S extends akh> akl<S> j6(S s, ajv ajv) {
        return new akl(s, ajv.j6, ajv.DW);
    }

    public static <S extends akh> akl<S> DW(S s, ajv ajv) {
        return new akl(s, ajv.FH, ajv.Hw);
    }

    public static <S extends akh> void j6(ajv ajv, akl<S> akl_S, akl<S> akl_S2) {
        ajv.j6 += akl_S.DW;
        ajv.DW += akl_S.DW;
        ajv.FH += akl_S2.DW;
        ajv.Hw += akl_S2.DW;
    }

    public static <S extends akh> ajw j6(ajw ajw, akl<S> akl_S, akl<S> akl_S2) {
        Iterator it = ajw.iterator();
        while (it.hasNext()) {
            j6((ajv) it.next(), (akl) akl_S, (akl) akl_S2);
        }
        return ajw;
    }

    public akl(S s, int i, int i2) {
        this.j6 = s;
        this.DW = i;
        this.FH = i2 - i;
    }

    public int j6() {
        return this.FH;
    }
}
