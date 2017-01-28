import com.aide.uidesigner.ProxyTextView;

public final class zl implements aag {
    public static final zl DW;
    public static final zl j6;
    private final boolean FH;

    static {
        j6 = new zl();
        DW = new zl(true);
    }

    private zl() {
        this.FH = false;
    }

    private zl(boolean z) {
        this.FH = z;
    }

    public boolean j6(zz zzVar, zw zwVar, zw zwVar2) {
        if (zwVar.j6() != abl.Zo) {
            return false;
        }
        if (!(zwVar2.gn() instanceof aat)) {
            return ((zwVar.gn() instanceof aat) && zzVar.j6() == 15) ? ((aat) zwVar.gn()).we() : false;
        } else {
            aat aat = (aat) zwVar2.gn();
            switch (zzVar.j6()) {
                case 14:
                case 16:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                case 21:
                case 22:
                    return aat.we();
                case 15:
                    return aat.j6(-aat.r_()).we();
                case 23:
                case 24:
                case 25:
                    return aat.J0();
                default:
                    return false;
            }
        }
    }

    public boolean j6(zz zzVar, zx zxVar) {
        return !this.FH && zzVar.v5() && j6(zxVar) >= 6;
    }

    private int j6(zx zxVar) {
        int i = 0;
        int i2 = 0;
        while (i < zxVar.m_()) {
            i2 += zxVar.DW(i).EQ();
            i++;
        }
        return i2;
    }

    public int j6() {
        return 16;
    }
}
