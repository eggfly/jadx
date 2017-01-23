import java.io.File;
import java.text.MessageFormat;
import java.util.Properties;
import org.eclipse.jgit.JGitText;

public class ave extends atv implements avw {
    static final avl v5;
    private final String VH;
    private final ate Zo;
    private final String gn;

    static {
        v5 = new ave$1();
    }

    ave(aoh aoh, avn avn) {
        super(aoh, avn);
        this.Zo = new ate(j6());
        this.VH = avn.j6();
        String FH = avn.FH();
        if (FH.startsWith("/")) {
            FH = FH.substring(1);
        }
        if (FH.endsWith("/")) {
            FH = FH.substring(0, FH.length() - 1);
        }
        this.gn = FH;
    }

    private Properties j6() {
        File file;
        if (this.FH.DW() != null) {
            file = new File(this.FH.DW(), this.Hw.v5());
            if (file.isFile()) {
                return j6(file);
            }
        }
        file = new File(this.FH.gn().FH(), this.Hw.v5());
        if (file.isFile()) {
            return j6(file);
        }
        Properties properties = new Properties();
        properties.setProperty("accesskey", this.Hw.v5());
        properties.setProperty("secretkey", this.Hw.Zo());
        return properties;
    }

    private static Properties j6(File file) {
        try {
            return ate.j6(file);
        } catch (Throwable e) {
            throw new alm(MessageFormat.format(JGitText.j6().cannotReadFile, new Object[]{file}), e);
        }
    }

    public atq QX() {
        avv ave_a = new ave$a(this, this.VH, this.gn + "/objects");
        atq avt = new avt(this, ave_a);
        avt.j6(ave_a.Hw());
        return avt;
    }

    public auj XL() {
        avv ave_a = new ave$a(this, this.VH, this.gn + "/objects");
        auj avu = new avu(this, ave_a);
        avu.j6(ave_a.Hw());
        return avu;
    }

    public void DW() {
    }
}
