import com.aide.uidesigner.ProxyTextView;

public final class ajq$c {
    private static /* synthetic */ int[] FH;
    private final ajq DW;
    private final ajq j6;

    static /* synthetic */ int[] j6() {
        int[] iArr = FH;
        if (iArr == null) {
            iArr = new int[ajt$b.values().length];
            try {
                iArr[ajt$b.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajt$b.OLD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            FH = iArr;
        }
        return iArr;
    }

    public ajq$c(ajq ajq, ajq ajq2) {
        this.j6 = ajq;
        this.DW = ajq2;
    }

    public long j6(ajt$b ajt_b, ajt ajt) {
        switch (j6()[ajt_b.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return this.j6.j6(ajt.DW, ajt.gn.FH());
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return this.DW.j6(ajt.FH, ajt.u7.FH());
            default:
                throw new IllegalArgumentException();
        }
    }

    public anx DW(ajt$b ajt_b, ajt ajt) {
        switch (j6()[ajt_b.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return this.j6.DW(ajt.DW, ajt.gn.FH());
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return this.DW.DW(ajt.FH, ajt.u7.FH());
            default:
                throw new IllegalArgumentException();
        }
    }
}
