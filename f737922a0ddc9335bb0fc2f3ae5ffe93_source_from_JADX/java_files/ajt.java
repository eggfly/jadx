import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class ajt {
    static final amz j6;
    private static /* synthetic */ int[] tp;
    protected String DW;
    protected String FH;
    protected anl Hw;
    protected int VH;
    protected ajt$a Zo;
    protected amz gn;
    protected amz u7;
    protected anl v5;

    static /* synthetic */ int[] u7() {
        int[] iArr = tp;
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
            tp = iArr;
        }
        return iArr;
    }

    static {
        j6 = amz.j6(ans.Zo());
    }

    protected ajt() {
    }

    public static List<ajt> j6(awc awc) {
        return j6(awc, false);
    }

    public static List<ajt> j6(awc awc, boolean z) {
        if (awc.tp() != 2) {
            throw new IllegalArgumentException(JGitText.j6().treeWalkMustHaveExactlyTwoTrees);
        } else if (z && awc.VH()) {
            throw new IllegalArgumentException(JGitText.j6().cannotBeRecursiveWhenTreesAreIncluded);
        } else {
            List<ajt> arrayList = new ArrayList();
            anb ano = new ano();
            while (awc.EQ()) {
                ajt ajt = new ajt();
                awc.j6((ano) ano, 0);
                ajt.gn = amz.j6(ano);
                awc.j6((ano) ano, 1);
                ajt.u7 = amz.j6(ano);
                ajt.Hw = awc.DW(0);
                ajt.v5 = awc.DW(1);
                String we = awc.we();
                ajt.DW = we;
                ajt.FH = we;
                if (ajt.Hw == anl.Zo) {
                    ajt.DW = "/dev/null";
                    ajt.Zo = ajt$a.ADD;
                    arrayList.add(ajt);
                } else if (ajt.v5 == anl.Zo) {
                    ajt.FH = "/dev/null";
                    ajt.Zo = ajt$a.DELETE;
                    arrayList.add(ajt);
                } else if (!ajt.gn.equals(ajt.u7)) {
                    ajt.Zo = ajt$a.MODIFY;
                    if (akg.j6(ajt.Hw, ajt.v5)) {
                        arrayList.add(ajt);
                    } else {
                        arrayList.addAll(j6(ajt));
                    }
                } else if (ajt.Hw != ajt.v5) {
                    ajt.Zo = ajt$a.MODIFY;
                    arrayList.add(ajt);
                }
                if (z && awc.Ws()) {
                    awc.QX();
                }
            }
            return arrayList;
        }
    }

    static List<ajt> j6(ajt ajt) {
        ajt ajt2 = new ajt();
        ajt2.gn = ajt.VH();
        ajt2.Hw = ajt.FH();
        ajt2.DW = ajt.j6();
        ajt2.u7 = j6;
        ajt2.v5 = anl.Zo;
        ajt2.FH = "/dev/null";
        ajt2.Zo = ajt$a.DELETE;
        ajt ajt3 = new ajt();
        ajt3.gn = j6;
        ajt3.Hw = anl.Zo;
        ajt3.DW = "/dev/null";
        ajt3.u7 = ajt.gn();
        ajt3.v5 = ajt.Hw();
        ajt3.FH = ajt.DW();
        ajt3.Zo = ajt$a.ADD;
        return Arrays.asList(new ajt[]{ajt2, ajt3});
    }

    static ajt j6(ajt$a ajt_a, ajt ajt, ajt ajt2, int i) {
        ajt ajt3 = new ajt();
        ajt3.gn = ajt.gn;
        ajt3.Hw = ajt.Hw;
        ajt3.DW = ajt.DW;
        ajt3.u7 = ajt2.u7;
        ajt3.v5 = ajt2.v5;
        ajt3.FH = ajt2.FH;
        ajt3.Zo = ajt_a;
        ajt3.VH = i;
        return ajt3;
    }

    public String j6() {
        return this.DW;
    }

    public String DW() {
        return this.FH;
    }

    public String j6(ajt$b ajt_b) {
        return ajt_b == ajt$b.OLD ? j6() : DW();
    }

    public anl FH() {
        return this.Hw;
    }

    public anl Hw() {
        return this.v5;
    }

    public anl DW(ajt$b ajt_b) {
        return ajt_b == ajt$b.OLD ? FH() : Hw();
    }

    public ajt$a v5() {
        return this.Zo;
    }

    public int Zo() {
        return this.VH;
    }

    public amz VH() {
        return this.gn;
    }

    public amz gn() {
        return this.u7;
    }

    public amz FH(ajt$b ajt_b) {
        return ajt_b == ajt$b.OLD ? VH() : gn();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DiffEntry[");
        stringBuilder.append(this.Zo);
        stringBuilder.append(" ");
        switch (u7()[this.Zo.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuilder.append(this.FH);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuilder.append(this.DW);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                stringBuilder.append(this.DW);
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuilder.append(this.DW + "->" + this.FH);
                break;
            case 5:
                stringBuilder.append(this.DW + "->" + this.FH);
                break;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
