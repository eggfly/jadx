import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

class ary$1 extends aog {
    private final /* synthetic */ ark DW;
    private final /* synthetic */ ary$g FH;
    private final /* synthetic */ axf Hw;
    final /* synthetic */ ary j6;

    ary$1(ary ary, axf axf, ark ark, ary$g ary_g, axf axf2) {
        this.j6 = ary;
        this.DW = ark;
        this.FH = ary_g;
        this.Hw = axf2;
        super(axf);
    }

    protected void j6(String str, byte[] bArr) {
        this.DW.FH(true);
        this.DW.DW(true);
        try {
            this.DW.j6(bArr);
            try {
                this.DW.FH();
                if (this.DW.Hw()) {
                    this.j6.tp.compareAndSet(this.FH, new ary$g(this.Hw, this.DW.v5()));
                    return;
                }
                throw new aln(MessageFormat.format(JGitText.j6().unableToWrite, new Object[]{str}));
            } catch (InterruptedException e) {
                this.DW.Zo();
                throw new aln(MessageFormat.format(JGitText.j6().interruptedWriting, new Object[]{str}));
            }
        } catch (Throwable e2) {
            throw new aln(MessageFormat.format(JGitText.j6().unableToWrite, new Object[]{str}), e2);
        }
    }
}
