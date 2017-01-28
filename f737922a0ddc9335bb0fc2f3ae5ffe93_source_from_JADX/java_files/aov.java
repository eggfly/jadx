import java.text.MessageFormat;
import java.util.HashMap;
import org.eclipse.jgit.JGitText;

public abstract class aov {
    public static final aov DW;
    public static final apb FH;
    public static final apb Hw;
    public static final aov j6;
    private static final HashMap<String, aov> v5;

    public abstract aow j6(aoh aoh);

    public abstract String j6();

    static {
        j6 = new aoy("ours", 0);
        DW = new aoy("theirs", 1);
        FH = new apa();
        Hw = new aoz();
        v5 = new HashMap();
        j6(j6);
        j6(DW);
        j6(FH);
        j6(Hw);
    }

    public static void j6(aov aov) {
        j6(aov.j6(), aov);
    }

    public static synchronized void j6(String str, aov aov) {
        synchronized (aov.class) {
            if (v5.containsKey(str)) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().mergeStrategyAlreadyExistsAsDefault, new Object[]{str}));
            }
            v5.put(str, aov);
        }
    }
}
