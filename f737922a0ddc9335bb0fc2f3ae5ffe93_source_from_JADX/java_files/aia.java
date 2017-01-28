import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class aia extends aie<aoc> {
    private static /* synthetic */ int[] VH;
    private String DW;
    private boolean FH;
    private aia$a Hw;
    private aqc Zo;
    private String v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    static /* synthetic */ int[] DW() {
        int[] iArr = VH;
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
            VH = iArr;
        }
        return iArr;
    }

    protected aia(aoh aoh) {
        super(aoh);
        this.FH = false;
        this.v5 = "HEAD";
    }

    public aoc j6() {
        String str = null;
        boolean z = false;
        Zo();
        Hw();
        aql aql = new aql(this.j6);
        try {
            aoc FH = this.j6.FH(this.DW);
            boolean z2 = FH != null && FH.j6().startsWith("refs/heads/");
            if (this.FH || !z2) {
                aof$a Ws;
                anb FH2 = FH();
                if (this.v5 != null) {
                    aoc FH3 = this.j6.FH(this.v5);
                    if (FH3 != null) {
                        str = FH3.j6();
                    }
                }
                String str2 = "";
                String str3;
                if (str == null) {
                    if (this.Zo != null) {
                        str = this.Zo.J8();
                    } else {
                        str = aql.Zo(this.j6.DW(this.v5)).J8();
                    }
                    if (z2) {
                        str3 = str2;
                        str2 = "branch: Reset start-point to commit " + str;
                        str = str3;
                    } else {
                        str3 = str2;
                        str2 = "branch: Created from commit " + str;
                        str = str3;
                    }
                } else if (!str.startsWith("refs/heads/") && !str.startsWith("refs/remotes/")) {
                    FH2 = aql.VH(aql.gn(FH2));
                    if (z2) {
                        str3 = str2;
                        str2 = "branch: Reset start-point to tag " + str;
                        str = str3;
                    } else {
                        str3 = str2;
                        str2 = "branch: Created from tag " + str;
                        str = str3;
                    }
                } else if (z2) {
                    str2 = "branch: Reset start-point to branch " + str;
                } else {
                    str2 = "branch: Created from branch " + str;
                }
                aof j6 = this.j6.j6("refs/heads/" + this.DW);
                j6.j6(FH2);
                j6.j6(str2, false);
                if (z2 && this.FH) {
                    Ws = j6.Ws();
                } else {
                    Ws = j6.QX();
                }
                DW(false);
                switch (DW()[Ws.ordinal()]) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 6:
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        if (!z2) {
                            z2 = true;
                            break;
                        }
                        z2 = false;
                        break;
                    default:
                        z2 = false;
                        break;
                }
                if (z2) {
                    FH = this.j6.FH(this.DW);
                    if (FH == null) {
                        throw new ajg(JGitText.j6().createBranchFailedUnknownReason);
                    }
                    if (str.length() == 0) {
                        aql.we();
                    } else {
                        if (this.Hw == aia$a.SET_UPSTREAM || this.Hw == aia$a.TRACK) {
                            z = true;
                        } else if (this.Hw != aia$a.NOTRACK) {
                            str2 = this.j6.VH().j6("branch", null, "autosetupmerge");
                            if (!"false".equals(str2)) {
                                z = "always".equals(str2) ? true : str.startsWith("refs/remotes/");
                            }
                        }
                        if (z) {
                            aol VH = this.j6.VH();
                            String[] split = str.split("/", 4);
                            if (split[1].equals("remotes")) {
                                str2 = split[2];
                                String str4 = split[3];
                                VH.j6("branch", this.DW, "remote", str2);
                                VH.j6("branch", this.DW, "merge", "refs/heads/" + str4);
                            } else {
                                VH.j6("branch", this.DW, "remote", ".");
                                VH.j6("branch", this.DW, "merge", str);
                            }
                            VH.v5();
                        }
                        aql.we();
                    }
                    return FH;
                }
                throw new ajg(MessageFormat.format(JGitText.j6().createBranchUnexpectedResult, new Object[]{Ws.name()}));
            }
            throw new ajm(MessageFormat.format(JGitText.j6().refAlreadyExists, new Object[]{this.DW}));
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        } catch (Throwable th) {
            aql.we();
        }
    }

    private ans FH() {
        if (this.Zo != null) {
            return this.Zo.XL();
        }
        try {
            String str;
            aoh aoh = this.j6;
            if (this.v5 == null) {
                str = "HEAD";
            } else {
                str = this.v5;
            }
            ans DW = aoh.DW(str);
            if (DW != null) {
                return DW;
            }
            String str2 = JGitText.j6().refNotResolved;
            Object[] objArr = new Object[1];
            objArr[0] = this.v5 != null ? this.v5 : "HEAD";
            throw new ajn(MessageFormat.format(str2, objArr));
        } catch (akw e) {
            throw e;
        }
    }

    private void Hw() {
        if (this.DW == null || !aoh.Hw("refs/heads/" + this.DW)) {
            String str = JGitText.j6().branchNameInvalid;
            Object[] objArr = new Object[1];
            objArr[0] = this.DW == null ? "<null>" : this.DW;
            throw new aje(MessageFormat.format(str, objArr));
        }
    }

    public aia j6(String str) {
        Zo();
        this.DW = str;
        return this;
    }

    public aia DW(String str) {
        Zo();
        this.v5 = str;
        this.Zo = null;
        return this;
    }

    public aia j6(aia$a aia_a) {
        Zo();
        this.Hw = aia_a;
        return this;
    }
}
