import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aim extends aiu<aim, Iterable<aul>> {
    private boolean EQ;
    private aob VH;
    private final List<auq> Zo;
    private String gn;
    private boolean tp;
    private boolean u7;
    private String v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aim(aoh aoh) {
        super(aoh);
        this.v5 = "origin";
        this.VH = anp.j6;
        this.gn = "git-receive-pack";
        this.EQ = false;
        this.Zo = new ArrayList(3);
    }

    public Iterable<aul> j6() {
        Zo();
        Iterable arrayList = new ArrayList(3);
        try {
            if (this.Zo.isEmpty()) {
                this.Zo.addAll(new aur(this.j6.VH(), DW()).v5());
            }
            if (this.Zo.isEmpty()) {
                aoc FH = this.j6.FH("HEAD");
                if (FH != null && FH.DW()) {
                    this.Zo.add(new auq(FH.FH().j6()));
                }
            }
            if (this.tp) {
                for (int i = 0; i < this.Zo.size(); i++) {
                    this.Zo.set(i, ((auq) this.Zo.get(i)).j6(true));
                }
            }
            for (avd avd : avd.DW(this.j6, this.v5, avd$a.PUSH)) {
                avd.FH(this.EQ);
                if (this.gn != null) {
                    avd.DW(this.gn);
                }
                avd.v5(this.u7);
                j6(avd);
                try {
                    arrayList.add(avd.DW(this.VH, avd.j6(this.Zo)));
                    avd.DW();
                } catch (Throwable e) {
                    throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfPushCommand, e);
                } catch (Throwable th) {
                    avd.DW();
                }
            }
            return arrayList;
        } catch (URISyntaxException e2) {
            throw new ajf(MessageFormat.format(JGitText.j6().invalidRemote, new Object[]{this.v5}));
        } catch (Throwable e3) {
            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfPushCommand, e3);
        } catch (Throwable e32) {
            throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfPushCommand, e32);
        }
    }

    public String DW() {
        return this.v5;
    }

    public aim j6(aob aob) {
        Zo();
        this.VH = aob;
        return this;
    }
}
