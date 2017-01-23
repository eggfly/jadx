import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class ahy extends aiu<ahy, aid> {
    private boolean EQ;
    private boolean J0;
    private Collection<String> J8;
    private boolean VH;
    private File Zo;
    private String gn;
    private aob tp;
    private String u7;
    private String v5;
    private boolean we;

    public /* synthetic */ Object call() {
        return j6();
    }

    public ahy() {
        super(null);
        this.gn = "origin";
        this.u7 = "HEAD";
        this.tp = anp.j6;
    }

    public aid j6() {
        try {
            avn avn = new avn(this.v5);
            aoh j6 = j6(avn);
            att j62 = j6(j6, avn);
            if (!this.J0) {
                j6(j6, j62);
            }
            return new aid(j6);
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new ajg(e2.getMessage(), e2);
        } catch (Throwable e22) {
            throw new ajg(e22.getMessage(), e22);
        }
    }

    private aoh j6(avn avn) {
        aif DW = aid.DW();
        DW.j6(this.VH);
        if (this.Zo == null) {
            this.Zo = new File(avn.u7(), ".git");
        }
        if (!this.Zo.exists() || this.Zo.listFiles().length == 0) {
            DW.j6(this.Zo);
            return DW.j6().QX();
        }
        throw new ajg(MessageFormat.format(JGitText.j6().cloneNonEmptyDirectory, new Object[]{this.Zo.getName()}));
    }

    private att j6(aoh aoh, avn avn) {
        String str;
        aur aur = new aur(aoh.VH(), this.gn);
        aur.j6(avn);
        if (this.VH) {
            str = "refs/heads/";
        } else {
            str = "refs/remotes/" + aur.j6();
        }
        aur.j6(new auq().j6(true).j6("refs/heads/*", new StringBuilder(String.valueOf(str)).append("/*").toString()));
        aur.j6(aoh.VH());
        aoh.VH().v5();
        aiu aic = new aic(aoh);
        aic.j6(this.gn);
        aic.j6(this.tp);
        aic.j6(auz.FETCH_TAGS);
        j6(aic);
        aic.j6(DW(str));
        return aic.j6();
    }

    private List<auq> DW(String str) {
        auq j6 = new auq().j6(true).j6("refs/heads/*", new StringBuilder(String.valueOf(str)).append("/*").toString());
        List<auq> arrayList = new ArrayList();
        if (this.EQ) {
            arrayList.add(j6);
        } else if (this.J8 != null && this.J8.size() > 0) {
            for (String str2 : this.J8) {
                if (j6.Hw(str2)) {
                    arrayList.add(j6.Zo(str2));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(aoh r4, att r5) {
        /*
        r3 = this;
        r0 = r3.u7;
        r1 = r5.j6(r0);
        r0 = r3.u7;
        r2 = "HEAD";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0011:
        r0 = r3.j6(r5);
        if (r0 == 0) goto L_0x0082;
    L_0x0017:
        if (r0 == 0) goto L_0x001f;
    L_0x0019:
        r1 = r0.v5();
        if (r1 != 0) goto L_0x0020;
    L_0x001f:
        return;
    L_0x0020:
        r1 = r0.j6();
        r2 = "refs/heads/";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0041;
    L_0x002d:
        r1 = "HEAD";
        r1 = r4.j6(r1);
        r1.we();
        r2 = r0.j6();
        r1.DW(r2);
        r3.j6(r4, r0);
    L_0x0041:
        r1 = r3.DW(r4, r0);
        r0 = r0.j6();
        r2 = "refs/heads/";
        r0 = r0.startsWith(r2);
        if (r0 == 0) goto L_0x0080;
    L_0x0052:
        r0 = 0;
    L_0x0053:
        r2 = "HEAD";
        r0 = r4.j6(r2, r0);
        r2 = r1.XL();
        r0.j6(r2);
        r0.Ws();
        r0 = r3.VH;
        if (r0 != 0) goto L_0x001f;
    L_0x0068:
        r0 = r4.XL();
        r2 = new akr;
        r1 = r1.u7();
        r2.<init>(r4, r0, r1);
        r2.v5();
        r0 = r3.we;
        if (r0 == 0) goto L_0x001f;
    L_0x007c:
        r3.j6(r4);
        goto L_0x001f;
    L_0x0080:
        r0 = 1;
        goto L_0x0053;
    L_0x0082:
        r0 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: ahy.j6(aoh, att):void");
    }

    private void j6(aoh aoh) {
        if (!new air(aoh).j6().isEmpty()) {
            aiu ait = new ait(aoh);
            j6(ait);
            ait.j6(this.tp);
            ait.j6();
        }
    }

    private aoc j6(att att) {
        aoc j6 = att.j6("HEAD");
        if (j6 == null) {
            return null;
        }
        aoc j62 = att.j6("refs/heads/master");
        if (j62 != null && j62.v5().DW(j6.v5())) {
            return j62;
        }
        for (aoc j622 : att.j6()) {
            if (j622.j6().startsWith("refs/heads/") && j622.v5().DW(j6.v5())) {
                break;
            }
        }
        j622 = null;
        return j622;
    }

    private void j6(aoh aoh, aoc aoc) {
        String v5 = aoh.v5(aoc.j6());
        aoh.VH().j6("branch", v5, "remote", this.gn);
        aoh.VH().j6("branch", v5, "merge", aoc.j6());
        aoh.VH().v5();
    }

    private aqc DW(aoh aoh, aoc aoc) {
        aql aql = new aql(aoh);
        try {
            aqc Zo = aql.Zo(aoc.v5());
            return Zo;
        } finally {
            aql.we();
        }
    }

    public ahy j6(String str) {
        this.v5 = str;
        return this;
    }

    public ahy j6(File file) {
        this.Zo = file;
        return this;
    }

    public ahy j6(aob aob) {
        this.tp = aob;
        return this;
    }

    public ahy j6(boolean z) {
        this.EQ = z;
        return this;
    }
}
