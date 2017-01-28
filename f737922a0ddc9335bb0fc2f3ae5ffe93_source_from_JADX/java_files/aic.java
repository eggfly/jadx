import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aic extends aiu<aic, att> {
    private boolean EQ;
    private aob VH;
    private List<auq> Zo;
    private boolean gn;
    private boolean tp;
    private boolean u7;
    private String v5;
    private auz we;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aic(aoh aoh) {
        super(aoh);
        this.v5 = "origin";
        this.VH = anp.j6;
        this.EQ = true;
        this.Zo = new ArrayList(3);
    }

    public att j6() {
        Zo();
        avd j6;
        try {
            j6 = avd.j6(this.j6, this.v5);
            j6.DW(this.gn);
            j6.Hw(this.u7);
            j6.v5(this.tp);
            if (this.we != null) {
                j6.j6(this.we);
            }
            j6.j6(this.EQ);
            j6(j6);
            att j62 = j6.j6(this.VH, this.Zo);
            j6.DW();
            return j62;
        } catch (Throwable e) {
            throw new ajf(MessageFormat.format(JGitText.j6().invalidRemote, new Object[]{this.v5}), e);
        } catch (Throwable e2) {
            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfFetchCommand, e2);
        } catch (URISyntaxException e3) {
            throw new ajf(MessageFormat.format(JGitText.j6().invalidRemote, new Object[]{this.v5}));
        } catch (Throwable e22) {
            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfFetchCommand, e22);
        } catch (Throwable th) {
            j6.DW();
        }
    }

    public aic j6(String str) {
        Zo();
        this.v5 = str;
        return this;
    }

    public aic j6(aob aob) {
        Zo();
        this.VH = aob;
        return this;
    }

    public aic j6(List<auq> list) {
        Zo();
        this.Zo.clear();
        this.Zo.addAll(list);
        return this;
    }

    public aic j6(auz auz) {
        Zo();
        this.we = auz;
        return this;
    }
}
