import java.io.File;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

class ahu$1 extends aks$c {
    private final /* synthetic */ ans FH;
    private final /* synthetic */ anl Hw;
    private final /* synthetic */ any Zo;
    final /* synthetic */ ahu j6;
    private final /* synthetic */ File v5;

    ahu$1(ahu ahu, String str, ans ans, anl anl, File file, any any) {
        this.j6 = ahu;
        this.FH = ans;
        this.Hw = anl;
        this.v5 = file;
        this.Zo = any;
        super(str);
    }

    public void j6(akt akt) {
        akt.j6(this.FH);
        akt.j6(this.Hw);
        try {
            akr.j6(this.j6.j6, new File(this.v5, akt.J8()), akt, this.Zo);
        } catch (Throwable e) {
            throw new ajg(MessageFormat.format(JGitText.j6().checkoutConflictWithFile, new Object[]{akt.J8()}), e);
        }
    }
}
