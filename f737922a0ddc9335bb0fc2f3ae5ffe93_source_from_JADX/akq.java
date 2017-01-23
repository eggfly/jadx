import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.JGitText;

public class akq extends akn {
    private boolean Hw;

    protected akq(ako ako, int i) {
        super(ako, i);
    }

    public void DW(akt akt) {
        if (akt.u7() == 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().fileModeNotSetForPath, new Object[]{akt.J8()}));
        }
        FH(akt);
        j6(akt);
    }

    public void DW(int i, int i2) {
        FH(this.j6.DW(i));
        j6(i, i2);
    }

    public void j6(byte[] bArr, int i, any any, anb anb) {
        awc awc = new awc(any);
        awc.j6(new avy(bArr, any, anb.v5()));
        awc.j6(true);
        if (awc.EQ()) {
            akt j6 = j6(i, awc);
            FH(j6);
            j6(j6);
            while (awc.EQ()) {
                j6(j6(i, awc));
            }
        }
    }

    private akt j6(int i, awc awc) {
        akt akt = new akt(awc.J0(), i);
        avx j6 = awc.j6(0, avx.class);
        akt.j6(awc.DW(0));
        akt.j6(j6.v5(), j6.Zo());
        return akt;
    }

    public void DW() {
        if (!this.Hw) {
            v5();
        }
        FH();
    }

    private void FH(akt akt) {
        if (this.Hw && this.FH > 0) {
            akt akt2 = this.DW[this.FH - 1];
            int j6 = ako.j6(akt2, akt);
            if (j6 > 0) {
                this.Hw = false;
            } else if (j6 == 0) {
                int VH = akt2.VH();
                j6 = akt.VH();
                if (VH == j6) {
                    throw j6(akt, JGitText.j6().duplicateStagesNotAllowed);
                } else if (VH == 0 || j6 == 0) {
                    throw j6(akt, JGitText.j6().mixedStagesNotAllowed);
                } else if (VH > j6) {
                    this.Hw = false;
                }
            }
        }
    }

    private void v5() {
        Arrays.sort(this.DW, 0, this.FH, ako.j6);
        for (int i = 1; i < this.FH; i++) {
            akt akt = this.DW[i - 1];
            akt akt2 = this.DW[i];
            if (ako.j6(akt, akt2) == 0) {
                int VH = akt.VH();
                int VH2 = akt2.VH();
                if (VH == VH2) {
                    throw j6(akt2, JGitText.j6().duplicateStagesNotAllowed);
                } else if (VH == 0 || VH2 == 0) {
                    throw j6(akt2, JGitText.j6().mixedStagesNotAllowed);
                }
            }
        }
        this.Hw = true;
    }

    private static IllegalStateException j6(akt akt, String str) {
        return new IllegalStateException(new StringBuilder(String.valueOf(str)).append(": ").append(akt.VH()).append(" ").append(akt.J8()).toString());
    }
}
