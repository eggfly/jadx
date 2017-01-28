import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class ahw extends aie<ahx> {
    private List<aoc> DW;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected ahw(aoh aoh) {
        super(aoh);
        this.DW = new LinkedList();
    }

    public ahx j6() {
        List linkedList = new LinkedList();
        Zo();
        aql aql = new aql(this.j6);
        try {
            aoc FH = this.j6.FH("HEAD");
            if (FH == null) {
                throw new ajj(JGitText.j6().commitOnRepoWithoutHEADCurrentlyNotSupported);
            }
            aqc Zo = aql.Zo(FH.v5());
            aqc aqc = Zo;
            for (aoc FH2 : this.DW) {
                anb VH = FH2.VH();
                if (VH == null) {
                    VH = FH2.v5();
                }
                aqc Zo2 = aql.Zo(VH);
                if (Zo2.tp() != 1) {
                    throw new ajh(MessageFormat.format(JGitText.j6().canOnlyCherryPickCommitsWithOneParent, new Object[]{Zo2.DW(), Integer.valueOf(Zo2.tp())}));
                }
                aqg DW = Zo2.DW(0);
                aql.Zo(DW);
                aox aox = (aox) aov.Hw.DW(this.j6);
                aox.j6(new awa(this.j6));
                aox.DW(DW.u7());
                if (aox.j6(Zo, Zo2)) {
                    if (!anb.j6(Zo.u7().XL(), aox.Hw())) {
                        akr akr = new akr(this.j6, Zo.u7(), this.j6.XL(), aox.Hw());
                        akr.j6(true);
                        akr.v5();
                        aqc j6 = new aid(v5()).FH().j6(Zo2.J0()).FH("cherry-pick: " + Zo2.J8()).j6(Zo2.we()).j6();
                        linkedList.add(FH2);
                        aqc = j6;
                    }
                } else if (aox.gn()) {
                    r0 = new ahx(aox.VH());
                    aql.we();
                    return r0;
                } else {
                    String j62 = new aot().j6(Zo2.J0(), aox.v5());
                    this.j6.j6(Zo2.XL());
                    this.j6.Zo(j62);
                    r0 = ahx.j6;
                    aql.we();
                    return r0;
                }
            }
            aql.we();
            return new ahx(aqc, linkedList);
        } catch (Throwable e) {
            throw new ajg(MessageFormat.format(JGitText.j6().exceptionCaughtDuringExecutionOfCherryPickCommand, new Object[]{e}), e);
        } catch (Throwable th) {
            aql.we();
        }
    }

    public ahw j6(aoc aoc) {
        Zo();
        this.DW.add(aoc);
        return this;
    }

    public ahw j6(anb anb) {
        return j6(anb.FH(), anb);
    }

    public ahw j6(String str, anb anb) {
        return j6(new anu$c(aoc$a.LOOSE, str, anb.Hw()));
    }
}
