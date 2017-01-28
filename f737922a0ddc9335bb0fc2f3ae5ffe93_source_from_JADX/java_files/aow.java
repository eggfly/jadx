import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public abstract class aow {
    protected final any DW;
    protected final aql FH;
    protected aqg[] Hw;
    private anw VH;
    protected aqk[] Zo;
    protected final aoh j6;
    protected aqc[] v5;

    protected abstract boolean FH();

    public abstract ans Hw();

    protected aow(aoh aoh) {
        this.j6 = aoh;
        this.DW = this.j6.v5();
        this.FH = new aql(this.DW);
    }

    public aoh j6() {
        return this.j6;
    }

    public anw DW() {
        if (this.VH == null) {
            this.VH = j6().Hw();
        }
        return this.VH;
    }

    public boolean j6(anb... anbArr) {
        int i;
        int i2 = 0;
        this.Hw = new aqg[anbArr.length];
        for (i = 0; i < anbArr.length; i++) {
            this.Hw[i] = this.FH.gn(anbArr[i]);
        }
        this.v5 = new aqc[this.Hw.length];
        for (i = 0; i < this.Hw.length; i++) {
            try {
                this.v5[i] = this.FH.Zo(this.Hw[i]);
            } catch (alb e) {
                this.v5[i] = null;
            }
        }
        this.Zo = new aqk[this.Hw.length];
        while (i2 < this.Hw.length) {
            this.Zo[i2] = this.FH.VH(this.Hw[i2]);
            i2++;
        }
        try {
            boolean FH = FH();
            if (FH && this.VH != null) {
                this.VH.FH();
            }
            if (this.VH != null) {
                this.VH.Hw();
            }
            this.DW.FH();
            return FH;
        } catch (Throwable th) {
            if (this.VH != null) {
                this.VH.Hw();
            }
            this.DW.FH();
        }
    }

    protected avx j6(int i, int i2) {
        aqc DW = DW(i, i2);
        return DW == null ? new avz() : j6(DW.u7());
    }

    public aqc DW(int i, int i2) {
        if (this.v5[i] == null) {
            throw new alb(this.Hw[i], "commit");
        } else if (this.v5[i2] == null) {
            throw new alb(this.Hw[i2], "commit");
        } else {
            this.FH.XL();
            this.FH.j6(aqt.v5);
            this.FH.DW(this.v5[i]);
            this.FH.DW(this.v5[i2]);
            aqc Hw = this.FH.Hw();
            if (Hw == null) {
                return null;
            }
            if (this.FH.Hw() == null) {
                return Hw;
            }
            throw new IOException(MessageFormat.format(JGitText.j6().multipleMergeBasesFor, new Object[]{this.v5[i].DW(), this.v5[i2].DW(), Hw.DW(), r1.DW()}));
        }
    }

    protected avx j6(anb anb) {
        return new avy(null, this.DW, anb);
    }
}
