import com.aide.uidesigner.ProxyTextView;
import java.util.Comparator;

class akg$1 implements Comparator<ajt> {
    private static /* synthetic */ int[] j6;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((ajt) obj, (ajt) obj2);
    }

    akg$1() {
    }

    static /* synthetic */ int[] j6() {
        int[] iArr = j6;
        if (iArr == null) {
            iArr = new int[ajt$a.values().length];
            try {
                iArr[ajt$a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ajt$a.COPY.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ajt$a.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ajt$a.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ajt$a.RENAME.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            j6 = iArr;
        }
        return iArr;
    }

    public int j6(ajt ajt, ajt ajt2) {
        int compareTo = j6(ajt).compareTo(j6(ajt2));
        if (compareTo == 0) {
            return j6(ajt.v5()) - j6(ajt2.v5());
        }
        return compareTo;
    }

    private String j6(ajt ajt) {
        if (ajt.Zo == ajt$a.DELETE) {
            return ajt.DW;
        }
        return ajt.FH;
    }

    private int j6(ajt$a ajt_a) {
        switch (j6()[ajt_a.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return 2;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return 1;
            default:
                return 10;
        }
    }
}
