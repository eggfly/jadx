import org.eclipse.jgit.JGitText;

public class aqu extends aqt {
    private int Zo;
    private final int j6;

    public static aqt j6(int i) {
        if (i >= 0) {
            return new aqu(i);
        }
        throw new IllegalArgumentException(JGitText.j6().skipMustBeNonNegative);
    }

    private aqu(int i) {
        this.j6 = i;
    }

    public boolean j6(aql aql, aqc aqc) {
        int i = this.j6;
        int i2 = this.Zo;
        this.Zo = i2 + 1;
        if (i > i2) {
            return false;
        }
        return true;
    }

    public aqt j6() {
        return new aqu(this.j6);
    }
}
