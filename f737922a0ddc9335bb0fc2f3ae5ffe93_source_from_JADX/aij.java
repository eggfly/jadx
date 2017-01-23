import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.jgit.JGitText;

public class aij {
    private ans DW;
    private ans FH;
    private Map<String, int[][]> Hw;
    private aov VH;
    private String Zo;
    private Map<String, aox$a> gn;
    private ans[] j6;
    private aij$a v5;

    public aij(ans ans, ans ans2, ans[] ansArr, aij$a aij_a, aov aov, Map<String, aou<?>> map, String str) {
        this(ans, ans2, ansArr, aij_a, aov, map, null, null);
    }

    public aij(ans ans, ans ans2, ans[] ansArr, aij$a aij_a, aov aov, Map<String, aou<?>> map, Map<String, aox$a> map2, String str) {
        this.FH = ans;
        this.j6 = ansArr;
        this.DW = ans2;
        this.v5 = aij_a;
        this.VH = aov;
        this.Zo = str;
        this.gn = map2;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                j6((String) entry.getKey(), (aou) entry.getValue());
            }
        }
    }

    public aij$a j6() {
        return this.v5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (ans ans : this.j6) {
            if (i == 0) {
                stringBuilder.append(", ");
            } else {
                i = 0;
            }
            stringBuilder.append(ans.j6(ans));
        }
        String str = JGitText.j6().mergeUsingStrategyResultedInDescription;
        Object[] objArr = new Object[5];
        objArr[0] = stringBuilder;
        objArr[1] = ans.j6(this.DW);
        objArr[2] = this.VH.j6();
        objArr[3] = this.v5;
        objArr[4] = this.Zo == null ? "" : ", " + this.Zo;
        return MessageFormat.format(str, objArr);
    }

    public void j6(String str, aou<?> aou_) {
        if (aou_.DW()) {
            if (this.Hw == null) {
                this.Hw = new HashMap();
            }
            Iterator it = aou_.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((aor) it.next()).Hw().equals(aor$a.FIRST_CONFLICTING_RANGE)) {
                    i++;
                }
            }
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, this.j6.length + 1});
            Iterator it2 = aou_.iterator();
            int i2 = -1;
            while (it2.hasNext()) {
                int i3;
                aor aor = (aor) it2.next();
                if (aor.Hw().equals(aor$a.FIRST_CONFLICTING_RANGE)) {
                    if (i2 > -1) {
                        iArr[i2][this.j6.length] = 0;
                    }
                    i3 = i2 + 1;
                    i2 = aor.FH();
                    iArr[i3][aor.j6()] = aor.DW();
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3 = 0;
                }
                if (aor.Hw().equals(aor$a.NEXT_CONFLICTING_RANGE)) {
                    if (aor.FH() > i3) {
                        aor.FH();
                    }
                    iArr[i2][aor.j6()] = aor.DW();
                }
            }
            this.Hw.put(str, iArr);
        }
    }
}
