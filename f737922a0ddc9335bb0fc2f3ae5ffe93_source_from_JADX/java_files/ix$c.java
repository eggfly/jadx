import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Iterator;

class ix$c extends ArrayList<ix$b> implements ix$b {
    private ix$c() {
    }

    public int j6() {
        return 2;
    }

    public boolean DW() {
        return size() == 0;
    }

    void FH() {
        for (int size = size() - 1; size >= 0; size--) {
            ix$b ix_b = (ix$b) get(size);
            if (ix_b.DW()) {
                remove(size);
            } else if (!(ix_b instanceof ix$c)) {
                return;
            }
        }
    }

    public int j6(ix$b ix_b) {
        if (ix_b != null) {
            switch (ix_b.j6()) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    return -1;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    return 1;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    int j6;
                    Iterator it = iterator();
                    Iterator it2 = ((ix$c) ix_b).iterator();
                    do {
                        if (!it.hasNext() && !it2.hasNext()) {
                            return 0;
                        }
                        ix$b ix_b2;
                        ix$b ix_b3 = it.hasNext() ? (ix$b) it.next() : null;
                        if (it2.hasNext()) {
                            ix_b2 = (ix$b) it2.next();
                        } else {
                            ix_b2 = null;
                        }
                        if (ix_b3 != null) {
                            j6 = ix_b3.j6(ix_b2);
                            continue;
                        } else if (ix_b2 == null) {
                            j6 = 0;
                            continue;
                        } else {
                            j6 = ix_b2.j6(ix_b3) * -1;
                            continue;
                        }
                    } while (j6 == 0);
                    return j6;
                default:
                    throw new RuntimeException("invalid item: " + ix_b.getClass());
            }
        } else if (size() == 0) {
            return 0;
        } else {
            return ((ix$b) get(0)).j6(null);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            ix$b ix_b = (ix$b) it.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(ix_b instanceof ix$c ? '-' : '.');
            }
            stringBuilder.append(ix_b);
        }
        return stringBuilder.toString();
    }
}
