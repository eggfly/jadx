import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.eclipse.jgit.JGitText;

class avg extends avd implements avf {
    static final avl v5;
    private final File Zo;

    static {
        v5 = new avg$1();
    }

    avg(aoh aoh, avn avn, File file) {
        super(aoh, avn);
        this.Zo = file;
    }

    public atq QX() {
        try {
            return new atk(this, new FileInputStream(this.Zo));
        } catch (FileNotFoundException e) {
            throw new amb(this.Hw, JGitText.j6().notFound);
        }
    }

    public auj XL() {
        throw new alm(JGitText.j6().pushIsNotSupportedForBundleTransport);
    }

    public void DW() {
    }
}
