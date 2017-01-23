import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public class aib extends aie<List<String>> {
    private static /* synthetic */ int[] Hw;
    private final Set<String> DW;
    private boolean FH;

    public /* synthetic */ Object call() {
        return j6();
    }

    static /* synthetic */ int[] DW() {
        int[] iArr = Hw;
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
            Hw = iArr;
        }
        return iArr;
    }

    protected aib(aoh aoh) {
        super(aoh);
        this.DW = new HashSet();
    }

    public List<String> j6() {
        Zo();
        List<String> arrayList = new ArrayList();
        if (this.DW.isEmpty()) {
            return arrayList;
        }
        try {
            String substring;
            String we = this.j6.we();
            if (!this.FH) {
                aql aql = new aql(this.j6);
                aqc Zo = aql.Zo(this.j6.DW("HEAD"));
                for (String substring2 : this.DW) {
                    if (substring2 != null && this.j6.FH(substring2) != null && !aql.j6(aql.Zo(this.j6.DW(substring2)), Zo)) {
                        throw new ajl();
                    }
                }
            }
            DW(false);
            for (String substring22 : this.DW) {
                if (substring22 != null) {
                    aoc FH = this.j6.FH(substring22);
                    if (FH != null) {
                        String j6 = FH.j6();
                        if (j6.equals(we)) {
                            throw new aix(MessageFormat.format(JGitText.j6().cannotDeleteCheckedOutBranch, new Object[]{substring22}));
                        }
                        Object obj;
                        aof j62 = this.j6.j6(j6);
                        j62.j6("branch deleted", false);
                        j62.DW(true);
                        switch (DW()[j62.XL().ordinal()]) {
                            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            case 7:
                            case 9:
                                obj = null;
                                break;
                            default:
                                obj = 1;
                                break;
                        }
                        if (obj != null) {
                            arrayList.add(j6);
                            if (j6.startsWith("refs/heads/")) {
                                substring22 = j6.substring("refs/heads/".length());
                                aol VH = this.j6.VH();
                                VH.j6("branch", substring22);
                                VH.v5();
                            }
                        } else {
                            throw new ajg(MessageFormat.format(JGitText.j6().deleteBranchUnexpectedResult, new Object[]{r7.name()}));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        }
    }

    public aib j6(String... strArr) {
        Zo();
        this.DW.clear();
        for (Object add : strArr) {
            this.DW.add(add);
        }
        return this;
    }
}
