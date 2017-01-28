import com.aide.uidesigner.ProxyTextView;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public abstract class avl {
    private static /* synthetic */ int[] j6;

    public abstract avd j6(avn avn, aoh aoh, String str);

    public abstract String j6();

    static /* synthetic */ int[] v5() {
        int[] iArr = j6;
        if (iArr == null) {
            iArr = new int[avl$a.values().length];
            try {
                iArr[avl$a.HOST.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[avl$a.PASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[avl$a.PATH.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[avl$a.PORT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[avl$a.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            j6 = iArr;
        }
        return iArr;
    }

    public Set<String> DW() {
        return Collections.emptySet();
    }

    public Set<avl$a> FH() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.PATH));
    }

    public Set<avl$a> Hw() {
        return Collections.emptySet();
    }

    public boolean j6(avn avn) {
        return DW(avn, null, null);
    }

    public boolean DW(avn avn, aoh aoh, String str) {
        if (!DW().isEmpty() && !DW().contains(avn.DW())) {
            return false;
        }
        for (avl$a ordinal : FH()) {
            switch (v5()[ordinal.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    if (avn.v5() != null && avn.v5().length() != 0) {
                        break;
                    }
                    return false;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    if (avn.Zo() != null && avn.Zo().length() != 0) {
                        break;
                    }
                    return false;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    if (avn.j6() != null && avn.j6().length() != 0) {
                        break;
                    }
                    return false;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    if (avn.VH() > 0) {
                        break;
                    }
                    return false;
                case 5:
                    if (avn.FH() != null && avn.FH().length() != 0) {
                        break;
                    }
                    return false;
                default:
                    return false;
            }
        }
        Set copyOf = EnumSet.copyOf(FH());
        copyOf.addAll(Hw());
        if (avn.v5() != null && !copyOf.contains(avl$a.USER)) {
            return false;
        }
        if (avn.Zo() != null && !copyOf.contains(avl$a.PASS)) {
            return false;
        }
        if (avn.j6() != null && !copyOf.contains(avl$a.HOST)) {
            return false;
        }
        if (avn.VH() > 0 && !copyOf.contains(avl$a.PORT)) {
            return false;
        }
        if (avn.FH() == null || copyOf.contains(avl$a.PATH)) {
            return true;
        }
        return false;
    }
}
