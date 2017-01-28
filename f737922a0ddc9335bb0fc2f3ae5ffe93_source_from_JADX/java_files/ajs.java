import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ajs {
    public static final ani$b<ajs> j6;
    private final boolean DW;
    private final ajs$a FH;
    private final int Hw;

    static {
        j6 = new ajs$1();
    }

    private ajs(ani ani) {
        this.DW = ani.j6("diff", "noprefix", false);
        this.FH = j6(ani.j6("diff", null, "renames"));
        this.Hw = ani.j6("diff", "renamelimit", 200);
    }

    public boolean j6() {
        return this.DW;
    }

    public boolean DW() {
        return this.FH != ajs$a.FALSE;
    }

    public int FH() {
        return this.Hw;
    }

    private static ajs$a j6(String str) {
        if (str == null) {
            return ajs$a.FALSE;
        }
        if (axh.j6("copy", str) || axh.j6("copies", str)) {
            return ajs$a.COPY;
        }
        Boolean FH = axh.FH(str);
        if (FH == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().enumValueNotSupported2, new Object[]{"diff", "renames", str}));
        } else if (FH.booleanValue()) {
            return ajs$a.TRUE;
        } else {
            return ajs$a.FALSE;
        }
    }
}
