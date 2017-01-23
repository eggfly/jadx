import org.eclipse.jgit.JGitText;

public class aqs extends aqt {
    private int Zo;
    private int j6;

    public static aqt j6(int i) {
        if (i >= 0) {
            return new aqs(i);
        }
        throw new IllegalArgumentException(JGitText.j6().maxCountMustBeNonNegative);
    }

    private aqs(int i) {
        this.Zo = 0;
        this.j6 = i;
    }

    public boolean j6(aql aql, aqc aqc) {
        this.Zo++;
        if (this.Zo <= this.j6) {
            return true;
        }
        throw alv.j6;
    }

    public aqt j6() {
        return new aqs(this.j6);
    }
}
