import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public abstract class aof {
    private boolean DW;
    private aoa FH;
    private String Hw;
    private ans VH;
    private ans Zo;
    private aof$a gn;
    private ans j6;
    private boolean tp;
    private final aoc u7;
    private boolean v5;

    protected abstract aof$a DW(aof$a aof_a);

    protected abstract aoh DW();

    protected abstract void FH();

    protected abstract aoe j6();

    protected abstract aof$a j6(aof$a aof_a);

    protected abstract aof$a j6(String str);

    protected abstract boolean j6(boolean z);

    protected aof(aoc aoc) {
        this.gn = aof$a.NOT_ATTEMPTED;
        this.u7 = aoc;
        this.Zo = aoc.v5();
        this.Hw = "";
    }

    public String Hw() {
        return v5().j6();
    }

    public aoc v5() {
        return this.u7;
    }

    public ans Zo() {
        return this.j6;
    }

    public void VH() {
        this.tp = true;
    }

    public void j6(anb anb) {
        this.j6 = anb.Hw();
    }

    public void DW(anb anb) {
        this.VH = anb != null ? anb.v5() : null;
    }

    public boolean gn() {
        return this.DW;
    }

    public void DW(boolean z) {
        this.DW = z;
    }

    public aoa u7() {
        return this.FH;
    }

    public void j6(aoa aoa) {
        this.FH = aoa;
    }

    public String tp() {
        return this.Hw;
    }

    protected boolean EQ() {
        return this.v5;
    }

    public void j6(String str, boolean z) {
        if (str == null && !z) {
            we();
        } else if (str == null && z) {
            this.Hw = "";
            this.v5 = true;
        } else {
            this.Hw = str;
            this.v5 = z;
        }
    }

    public void we() {
        this.Hw = null;
        this.v5 = false;
    }

    public ans J0() {
        return this.Zo;
    }

    protected void j6(ans ans) {
        this.Zo = ans;
    }

    public aof$a J8() {
        return this.gn;
    }

    private void aM() {
        if (this.j6 == null) {
            throw new IllegalStateException(JGitText.j6().aNewObjectIdIsRequired);
        }
    }

    public aof$a Ws() {
        this.DW = true;
        return QX();
    }

    public aof$a QX() {
        aql aql = new aql(DW());
        try {
            aof$a j6 = j6(aql);
            return j6;
        } finally {
            aql.we();
        }
    }

    public aof$a j6(aql aql) {
        aM();
        try {
            aof$a j6 = j6(aql, new aof$1(this));
            this.gn = j6;
            return j6;
        } catch (IOException e) {
            this.gn = aof$a.IO_FAILURE;
            throw e;
        }
    }

    public aof$a XL() {
        aql aql = new aql(DW());
        try {
            aof$a DW = DW(aql);
            return DW;
        } finally {
            aql.we();
        }
    }

    public aof$a DW(aql aql) {
        String j6 = v5().FH().j6();
        if (j6.startsWith("refs/heads/")) {
            aoc DW = j6().DW("HEAD");
            while (DW.DW()) {
                DW = DW.Hw();
                if (j6.equals(DW.j6())) {
                    aof$a aof_a = aof$a.REJECTED_CURRENT_BRANCH;
                    this.gn = aof_a;
                    return aof_a;
                }
            }
        }
        try {
            aof_a = j6(aql, new aof$2(this));
            this.gn = aof_a;
            return aof_a;
        } catch (IOException e) {
            this.gn = aof$a.IO_FAILURE;
            throw e;
        }
    }

    public aof$a DW(String str) {
        if (!str.startsWith("refs/")) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().illegalArgumentNotA, new Object[]{"refs/"}));
        } else if (j6().j6(Hw())) {
            return aof$a.LOCK_FAILURE;
        } else {
            try {
                aof$a aof_a;
                if (j6(false)) {
                    aoc DW = j6().DW(Hw());
                    if (DW != null && DW.DW() && str.equals(DW.Hw().j6())) {
                        aof_a = aof$a.NO_CHANGE;
                        this.gn = aof_a;
                        FH();
                        return aof_a;
                    }
                    if (DW != null) {
                        if (DW.v5() != null) {
                            j6(DW.v5());
                        }
                    }
                    DW = j6().DW(str);
                    if (!(DW == null || DW.v5() == null)) {
                        j6(DW.v5());
                    }
                    aof_a = j6(str);
                    this.gn = aof_a;
                    FH();
                    return aof_a;
                }
                aof_a = aof$a.LOCK_FAILURE;
                FH();
                return aof_a;
            } catch (IOException e) {
                this.gn = aof$a.IO_FAILURE;
                throw e;
            } catch (Throwable th) {
                FH();
            }
        }
    }

    private aof$a j6(aql aql, aof$b aof_b) {
        if (j6().j6(Hw())) {
            return aof$a.LOCK_FAILURE;
        }
        aof$a aof_a;
        if (j6(true)) {
            if (this.VH != null) {
                if (!anb.j6(this.VH, this.Zo != null ? this.Zo : ans.Zo())) {
                    aof_a = aof$a.LOCK_FAILURE;
                    FH();
                    return aof_a;
                }
            }
            if (this.Zo == null) {
                aof_a = aof_b.j6(aof$a.NEW);
                FH();
                return aof_a;
            }
            aqg j6 = j6(aql, this.j6);
            aqg j62 = j6(aql, this.Zo);
            if (j6 != j62 || this.tp) {
                try {
                    if ((j6 instanceof aqc) && (j62 instanceof aqc) && aql.j6((aqc) j62, (aqc) j6)) {
                        aof_a = aof_b.j6(aof$a.FAST_FORWARD);
                        FH();
                        return aof_a;
                    } else if (gn()) {
                        aof_a = aof_b.j6(aof$a.FORCED);
                        FH();
                        return aof_a;
                    } else {
                        aof_a = aof$a.REJECTED;
                        FH();
                        return aof_a;
                    }
                } finally {
                    FH();
                }
            } else {
                aof_a = aof_b.j6(aof$a.NO_CHANGE);
                FH();
                return aof_a;
            }
        }
        aof_a = aof$a.LOCK_FAILURE;
        return aof_a;
    }

    private static aqg j6(aql aql, anb anb) {
        aqg aqg = null;
        if (anb != null) {
            try {
                aqg = aql.gn(anb);
            } catch (ali e) {
            }
        }
        return aqg;
    }
}
