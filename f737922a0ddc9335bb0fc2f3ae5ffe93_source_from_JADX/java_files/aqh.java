import java.text.MessageFormat;
import java.util.AbstractList;
import org.eclipse.jgit.JGitText;

public class aqh<E extends aqg> extends AbstractList<E> {
    protected int DW;
    protected aqh$a j6;

    public /* synthetic */ void add(int i, Object obj) {
        j6(i, (aqg) obj);
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public /* synthetic */ Object set(int i, Object obj) {
        return DW(i, (aqg) obj);
    }

    public aqh() {
        this.j6 = new aqh$a(0);
        this.DW = 0;
    }

    public void j6(int i, E e) {
        if (i != this.DW) {
            throw new UnsupportedOperationException(MessageFormat.format(JGitText.j6().unsupportedOperationNotAddAtEnd, new Object[]{Integer.valueOf(i)}));
        }
        DW(i, e);
        this.DW++;
    }

    public E DW(int i, E e) {
        aqh$a aqh_a;
        aqh$a aqh_a2 = this.j6;
        while ((i >> aqh_a2.DW) >= 256) {
            aqh_a = new aqh$a(aqh_a2.DW + 8);
            aqh_a.j6[0] = this.j6;
            this.j6 = aqh_a;
            aqh_a2 = aqh_a;
        }
        aqh_a = aqh_a2;
        while (aqh_a.DW > 0) {
            int i2 = i >> aqh_a.DW;
            i -= i2 << aqh_a.DW;
            if (aqh_a.j6[i2] == null) {
                aqh_a.j6[i2] = new aqh$a(aqh_a.DW - 8);
            }
            aqh_a = (aqh$a) aqh_a.j6[i2];
        }
        Object obj = aqh_a.j6[i];
        aqh_a.j6[i] = e;
        return (aqg) obj;
    }

    public E j6(int i) {
        aqh$a aqh_a = this.j6;
        if ((i >> aqh_a.DW) >= 1024) {
            return null;
        }
        while (aqh_a != null && aqh_a.DW > 0) {
            int i2 = i >> aqh_a.DW;
            i -= i2 << aqh_a.DW;
            aqh_a = (aqh$a) aqh_a.j6[i2];
        }
        return aqh_a != null ? (aqg) aqh_a.j6[i] : null;
    }

    public int size() {
        return this.DW;
    }

    public void clear() {
        this.j6 = new aqh$a(0);
        this.DW = 0;
    }
}
