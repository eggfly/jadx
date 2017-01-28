import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aks extends akn {
    private static final Comparator<aks$c> Hw;
    private final List<aks$c> v5;

    static {
        Hw = new aks$1();
    }

    protected aks(ako ako, int i) {
        super(ako, i);
        this.v5 = new ArrayList();
    }

    public void j6(aks$c aks_c) {
        this.v5.add(aks_c);
    }

    public boolean Hw() {
        if (!this.v5.isEmpty()) {
            return super.Hw();
        }
        this.j6.u7();
        return true;
    }

    public void DW() {
        if (!this.v5.isEmpty()) {
            v5();
            FH();
        }
    }

    private void v5() {
        Collections.sort(this.v5, Hw);
        int tp = this.j6.tp();
        int i = 0;
        for (aks$c aks_c : this.v5) {
            int j6 = this.j6.j6(aks_c.DW, aks_c.DW.length);
            int i2 = j6 < 0 ? 1 : 0;
            if (j6 < 0) {
                j6 = -(j6 + 1);
            }
            int min = Math.min(j6, tp) - i;
            if (min > 0) {
                j6(i, min);
            }
            i = i2 != 0 ? j6 : this.j6.j6(j6);
            if (!(aks_c instanceof aks$a)) {
                if (aks_c instanceof aks$b) {
                    i = this.j6.j6(aks_c.DW, aks_c.DW.length, j6);
                } else {
                    akt akt;
                    akt akt2;
                    if (i2 != 0) {
                        akt2 = new akt(aks_c.DW);
                        aks_c.j6(akt2);
                        if (akt2.u7() == 0) {
                            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().fileModeNotSetForPath, new Object[]{akt2.J8()}));
                        }
                        akt = akt2;
                    } else {
                        akt2 = this.j6.DW(j6);
                        aks_c.j6(akt2);
                        akt = akt2;
                    }
                    j6(akt);
                }
            }
        }
        int i3 = tp - i;
        if (i3 > 0) {
            j6(i, i3);
        }
    }
}
