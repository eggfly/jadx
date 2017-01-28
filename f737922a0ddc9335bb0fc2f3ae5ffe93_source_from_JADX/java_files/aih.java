import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aih extends aie<Iterable<aqc>> {
    private aql DW;
    private boolean FH;
    private final List<awi> Hw;
    private int Zo;
    private int v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aih(aoh aoh) {
        super(aoh);
        this.FH = false;
        this.Hw = new ArrayList();
        this.v5 = -1;
        this.Zo = -1;
        this.DW = new aql(aoh);
    }

    public Iterable<aqc> j6() {
        Zo();
        if (this.Hw.size() > 0) {
            this.DW.j6(awf.j6(awj.DW(this.Hw), awl.Hw));
        }
        if (this.Zo > -1 && this.v5 > -1) {
            this.DW.j6(aqq.j6(aqu.j6(this.Zo), aqs.j6(this.v5)));
        } else if (this.Zo > -1) {
            this.DW.j6(aqu.j6(this.Zo));
        } else if (this.v5 > -1) {
            this.DW.j6(aqs.j6(this.v5));
        }
        if (!this.FH) {
            try {
                anb DW = this.j6.DW("HEAD");
                if (DW == null) {
                    throw new ajj(JGitText.j6().noHEADExistsAndNoExplicitStartingRevisionWasSpecified);
                }
                j6(DW);
            } catch (Throwable e) {
                throw new ajg(JGitText.j6().anExceptionOccurredWhileTryingToAddTheIdOfHEAD, e);
            }
        }
        DW(false);
        return this.DW;
    }

    public aih j6(anb anb) {
        return j6(true, anb);
    }

    public aih DW(anb anb) {
        return j6(false, anb);
    }

    public aih j6(anb anb, anb anb2) {
        return DW(anb).j6(anb2);
    }

    private aih j6(boolean z, anb anb) {
        Zo();
        if (z) {
            try {
                this.DW.DW(this.DW.Hw(anb));
                this.FH = true;
            } catch (ali e) {
                throw e;
            } catch (alb e2) {
                throw e2;
            } catch (Throwable e3) {
                throw new ajg(MessageFormat.format(JGitText.j6().exceptionOccurredDuringAddingOfOptionToALogCommand, new Object[]{anb}), e3);
            }
        }
        this.DW.FH(this.DW.Hw(anb));
        return this;
    }
}
