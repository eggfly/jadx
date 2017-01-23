import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class ahu extends aie<aoc> {
    private static /* synthetic */ int[] tp;
    private String DW;
    private boolean FH;
    private boolean Hw;
    private aqc VH;
    private String Zo;
    private ahv gn;
    private List<String> u7;
    private aia$a v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    static /* synthetic */ int[] Hw() {
        int[] iArr = tp;
        if (iArr == null) {
            iArr = new int[aof$a.values().length];
            try {
                iArr[aof$a.FAST_FORWARD.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[aof$a.FORCED.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[aof$a.IO_FAILURE.ordinal()] = 9;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[aof$a.LOCK_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[aof$a.NEW.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[aof$a.NOT_ATTEMPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[aof$a.NO_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[aof$a.REJECTED.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[aof$a.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[aof$a.RENAMED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            tp = iArr;
        }
        return iArr;
    }

    protected ahu(aoh aoh) {
        super(aoh);
        this.FH = false;
        this.Hw = false;
        this.Zo = null;
        this.u7 = new LinkedList();
    }

    public aoc j6() {
        aoc aoc = null;
        Object obj = 1;
        Zo();
        gn();
        akr akr;
        try {
            if (this.u7.isEmpty()) {
                if (this.Hw) {
                    aia VH = new aid(this.j6).VH();
                    VH.j6(this.DW);
                    VH.DW(VH().DW());
                    if (this.v5 != null) {
                        VH.j6(this.v5);
                    }
                    VH.j6();
                }
                aoc FH = this.j6.FH("HEAD");
                String str = "checkout: moving from " + j6(FH);
                anb DW = this.j6.DW(this.DW);
                if (DW == null) {
                    throw new ajn(MessageFormat.format(JGitText.j6().refNotResolved, new Object[]{this.DW}));
                }
                aqc aqc;
                boolean z;
                aof$a DW2;
                aql aql = new aql(this.j6);
                anb v5 = FH.v5();
                if (v5 == null) {
                    aqc = null;
                } else {
                    aqc = aql.Zo(v5);
                }
                DW = aql.Zo(DW);
                akr = new akr(this.j6, aqc == null ? null : aqc.u7(), this.j6.XL(), DW.u7());
                akr.j6(true);
                akr.v5();
                FH = this.j6.FH(this.DW);
                if (FH == null || FH.j6().startsWith("refs/heads/")) {
                    aoc = FH;
                }
                String v52 = aoh.v5(this.DW);
                aoh aoh = this.j6;
                String str2 = "HEAD";
                if (aoc == null) {
                    z = true;
                } else {
                    z = false;
                }
                aof j6 = aoh.j6(str2, z);
                j6.DW(this.FH);
                j6.j6(new StringBuilder(String.valueOf(str)).append(" to ").append(v52).toString(), false);
                if (aoc != null) {
                    DW2 = j6.DW(aoc.j6());
                } else {
                    j6.j6(DW);
                    DW2 = j6.Ws();
                }
                DW(false);
                switch (Hw()[DW2.ordinal()]) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj == null) {
                    throw new ajg(MessageFormat.format(JGitText.j6().checkoutUnexpectedResult, new Object[]{DW2.name()}));
                }
                if (akr.DW().isEmpty()) {
                    this.gn = ahv.j6;
                } else {
                    this.gn = new ahv(ahv$a.NONDELETED, akr.DW());
                }
                if (this.gn == null) {
                    this.gn = ahv.DW;
                }
            } else {
                DW();
                this.gn = ahv.j6;
                DW(false);
                if (this.gn == null) {
                    this.gn = ahv.DW;
                }
            }
            return aoc;
        } catch (akx e) {
            this.gn = new ahv(ahv$a.CONFLICTS, akr.j6());
            throw e;
        } catch (Throwable e2) {
            throw new ajg(e2.getMessage(), e2);
        } catch (Throwable th) {
            if (this.gn == null) {
                this.gn = ahv.DW;
            }
        }
    }

    private String j6(aoc aoc) {
        if (aoc.Hw().j6().equals(aoc.j6())) {
            return aoc.Hw().v5().FH();
        }
        return aoh.v5(aoc.Hw().j6());
    }

    public ahu j6(String str) {
        Zo();
        this.u7.add(str);
        return this;
    }

    protected ahu DW() {
        Object obj = 1;
        aql aql = new aql(this.j6);
        ako XL = this.j6.XL();
        awc awc;
        any Hw;
        try {
            aks FH = XL.FH();
            awc = new awc(aql.EQ());
            awc.j6(true);
            awc.j6(awj.j6(this.u7));
            if (!(this.VH == null && this.Zo == null)) {
                obj = null;
            }
            if (obj == null) {
                awc.DW(aql.Zo(VH()).u7());
            } else {
                awc.j6(new aku(XL));
            }
            File Mr = this.j6.Mr();
            Hw = this.j6.FH().Hw();
            while (awc.EQ()) {
                FH.j6(new ahu$1(this, awc.we(), awc.FH(0), awc.DW(0), Mr, Hw));
            }
            FH.Hw();
            awc.v5();
            Hw.FH();
            XL.u7();
            aql.we();
            return this;
        } catch (Throwable th) {
            XL.u7();
            aql.we();
        }
    }

    private ans VH() {
        if (this.VH != null) {
            return this.VH.XL();
        }
        try {
            String str;
            aoh aoh = this.j6;
            if (this.Zo == null) {
                str = "HEAD";
            } else {
                str = this.Zo;
            }
            ans DW = aoh.DW(str);
            if (DW != null) {
                return DW;
            }
            String str2 = JGitText.j6().refNotResolved;
            Object[] objArr = new Object[1];
            objArr[0] = this.Zo != null ? this.Zo : "HEAD";
            throw new ajn(MessageFormat.format(str2, objArr));
        } catch (akw e) {
            throw e;
        }
    }

    private void gn() {
        if (!this.u7.isEmpty()) {
            return;
        }
        if (this.DW == null || !aoh.Hw("refs/heads/" + this.DW)) {
            String str = JGitText.j6().branchNameInvalid;
            Object[] objArr = new Object[1];
            objArr[0] = this.DW == null ? "<null>" : this.DW;
            throw new aje(MessageFormat.format(str, objArr));
        }
    }

    public ahu DW(String str) {
        Zo();
        this.DW = str;
        return this;
    }

    public ahu j6(boolean z) {
        Zo();
        this.FH = z;
        return this;
    }

    public ahu FH(String str) {
        Zo();
        this.Zo = str;
        this.VH = null;
        return this;
    }

    public ahv FH() {
        if (this.gn == null) {
            return ahv.FH;
        }
        return this.gn;
    }
}
