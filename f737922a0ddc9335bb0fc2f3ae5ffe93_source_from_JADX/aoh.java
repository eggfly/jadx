import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.JGitText;

public abstract class aoh {
    private static final amk j6;
    private final AtomicInteger DW;
    private final File FH;
    private final awp Hw;
    private final File VH;
    private final File Zo;
    private final amk v5;

    public abstract anr FH();

    public abstract void U2();

    public abstract aol VH();

    public abstract aoe Zo();

    public abstract void j6(boolean z);

    static {
        j6 = new amk();
    }

    protected aoh(anf anf) {
        this.DW = new AtomicInteger(1);
        this.v5 = new amk();
        this.FH = anf.DW();
        this.Hw = anf.j6();
        this.Zo = anf.gn();
        this.VH = anf.u7();
    }

    public void j6(amn<?> amn_) {
        amn_.j6(this);
        this.v5.j6((amn) amn_);
        j6.j6((amn) amn_);
    }

    public void j6() {
        j6(false);
    }

    public File DW() {
        return this.FH;
    }

    public anw Hw() {
        return FH().FH();
    }

    public any v5() {
        return FH().Hw();
    }

    public awp gn() {
        return this.Hw;
    }

    public boolean j6(anb anb) {
        try {
            return FH().j6(anb);
        } catch (IOException e) {
            return false;
        }
    }

    public anx j6(anb anb, int i) {
        return FH().j6(anb, i);
    }

    public aof j6(String str) {
        return j6(str, false);
    }

    public aof j6(String str, boolean z) {
        return Zo().j6(str, z);
    }

    public ans DW(String str) {
        aql aql = new aql(this);
        try {
            ans j6 = j6(aql, str);
            return j6;
        } finally {
            aql.we();
        }
    }

    private ans j6(aql aql, String str) {
        ans gn;
        char[] toCharArray = str.toCharArray();
        anb anb = null;
        int i;
        for (int i2 = 0; i2 < toCharArray.length; i2 = i + 1) {
            anb j6;
            aqg DW;
            int i3;
            aqc aqc;
            int i4;
            switch (toCharArray[i2]) {
                case ':':
                    aqk VH;
                    if (anb == null) {
                        if (i2 == 0) {
                            try {
                                j6 = j6(aql, "HEAD");
                            } catch (alu e) {
                                throw new alu(str);
                            }
                        }
                        j6 = j6(aql, new String(toCharArray, 0, i2));
                        if (j6 == null) {
                            return null;
                        }
                        VH = aql.VH(j6);
                    } else {
                        VH = aql.VH(anb);
                    }
                    if (i2 == toCharArray.length - 1) {
                        return VH.Hw();
                    }
                    awc j62 = awc.j6(aql.EQ(), new String(toCharArray, i2 + 1, (toCharArray.length - i2) - 1), VH);
                    if (j62 != null) {
                        return j62.FH(0);
                    }
                    return null;
                case '@':
                    String str2;
                    aoc DW2;
                    i = i2 + 2;
                    while (i < toCharArray.length) {
                        if (toCharArray[i] == '}') {
                            str2 = new String(toCharArray, i2 + 2, (i - i2) - 2);
                            if (str2 != null) {
                                i--;
                                break;
                            }
                            DW2 = Zo().DW(new String(toCharArray, 0, i2));
                            if (DW2 == null) {
                                anb = j6(aql, DW2, str2);
                                break;
                            }
                            return null;
                        }
                        i++;
                    }
                    str2 = null;
                    if (str2 != null) {
                        i--;
                    } else {
                        DW2 = Zo().DW(new String(toCharArray, 0, i2));
                        if (DW2 == null) {
                            return null;
                        }
                        anb = j6(aql, DW2, str2);
                    }
                case '^':
                    if (anb == null) {
                        DW = DW(aql, new String(toCharArray, 0, i2));
                        if (DW == null) {
                            return null;
                        }
                    }
                    if (i2 + 1 < toCharArray.length) {
                        switch (toCharArray[i2 + 1]) {
                            case '0':
                            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                j6 = aql.Zo((anb) DW);
                                i3 = i2 + 1;
                                while (i3 < toCharArray.length && Character.isDigit(toCharArray[i3])) {
                                    i3++;
                                }
                                try {
                                    i2 = Integer.parseInt(new String(toCharArray, i2 + 1, (i3 - i2) - 1));
                                    if (i2 != 0) {
                                        aqc = (aqc) j6;
                                        if (i2 > aqc.tp()) {
                                            j6 = null;
                                        } else {
                                            j6 = aqc.DW(i2 - 1);
                                        }
                                    }
                                    i4 = i3 - 1;
                                    anb = j6;
                                    i = i4;
                                    break;
                                } catch (NumberFormatException e2) {
                                    throw new alu(JGitText.j6().invalidCommitParentNumber, str);
                                }
                            case '{':
                                String str3;
                                ans VH2;
                                i = i2 + 2;
                                while (i < toCharArray.length) {
                                    if (toCharArray[i] == '}') {
                                        str3 = new String(toCharArray, i2 + 2, (i - i2) - 2);
                                        if (str3 != null) {
                                            throw new alu(str);
                                        } else if (str3.equals("tree")) {
                                            anb = aql.VH((anb) DW);
                                            break;
                                        } else if (str3.equals("commit")) {
                                            anb = aql.Zo((anb) DW);
                                            break;
                                        } else if (str3.equals("blob")) {
                                            VH2 = aql.VH(DW);
                                            if (VH2 instanceof aqb) {
                                                break;
                                            }
                                            throw new alb(VH2, "blob");
                                        } else if (str3.equals("")) {
                                            anb = aql.VH(DW);
                                            break;
                                        } else {
                                            throw new alu(str);
                                        }
                                    }
                                    i++;
                                }
                                str3 = null;
                                if (str3 != null) {
                                    throw new alu(str);
                                } else if (str3.equals("tree")) {
                                    anb = aql.VH((anb) DW);
                                } else if (str3.equals("commit")) {
                                    anb = aql.Zo((anb) DW);
                                } else if (str3.equals("blob")) {
                                    VH2 = aql.VH(DW);
                                    if (VH2 instanceof aqb) {
                                        throw new alb(VH2, "blob");
                                    }
                                } else if (str3.equals("")) {
                                    anb = aql.VH(DW);
                                } else {
                                    throw new alu(str);
                                }
                            default:
                                gn = aql.gn(DW);
                                if (gn instanceof aqc) {
                                    aqc = (aqc) gn;
                                    if (aqc.tp() != 0) {
                                        anb = aqc.DW(0);
                                        i = i2;
                                        break;
                                    }
                                    i = i2;
                                    anb = null;
                                    break;
                                }
                                throw new alb(gn, "commit");
                        }
                    }
                    gn = aql.VH(DW);
                    if (gn instanceof aqc) {
                        aqc = (aqc) gn;
                        if (aqc.tp() != 0) {
                            anb = aqc.DW(0);
                            i = i2;
                            break;
                        }
                        i = i2;
                        anb = null;
                        break;
                    }
                    throw new alb(gn, "commit");
                    break;
                case '~':
                    if (anb == null) {
                        DW = DW(aql, new String(toCharArray, 0, i2));
                        if (DW == null) {
                            return null;
                        }
                    }
                    anb VH3 = aql.VH(DW);
                    if (VH3 instanceof aqc) {
                        i3 = i2 + 1;
                        while (i3 < toCharArray.length && Character.isDigit(toCharArray[i3])) {
                            i3++;
                        }
                        if (i3 - i2 > 1) {
                            try {
                                i2 = Integer.parseInt(new String(toCharArray, i2 + 1, (i3 - i2) - 1));
                                j6 = VH3;
                            } catch (NumberFormatException e3) {
                                throw new alu(JGitText.j6().invalidAncestryLength, str);
                            }
                        }
                        i2 = 1;
                        j6 = VH3;
                        while (i2 > 0) {
                            aqc = (aqc) j6;
                            if (aqc.tp() == 0) {
                                j6 = null;
                                i4 = i3 - 1;
                                anb = j6;
                                i = i4;
                                break;
                            }
                            VH3 = aqc.DW(0);
                            aql.Zo((aqg) VH3);
                            i2--;
                            j6 = VH3;
                        }
                        i4 = i3 - 1;
                        anb = j6;
                        i = i4;
                    } else {
                        throw new alb((ans) VH3, "commit");
                    }
                    break;
                default:
                    if (anb == null) {
                        i = i2;
                        break;
                    }
                    throw new alu(str);
            }
        }
        if (anb != null) {
            gn = anb.Hw();
        } else {
            gn = VH(str);
        }
        return gn;
    }

    private static boolean j6(char c) {
        return ('0' <= c && c <= '9') || (('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'));
    }

    private static boolean j6(String str, int i) {
        while (i < str.length()) {
            int i2 = i + 1;
            if (!j6(str.charAt(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    private aqg DW(aql aql, String str) {
        anb VH = VH(str);
        return VH != null ? aql.gn(VH) : null;
    }

    private ans VH(String str) {
        if (ans.j6(str)) {
            return ans.DW(str);
        }
        aoc DW = Zo().DW(str);
        if (DW != null) {
            return DW.v5();
        }
        if (amz.j6(str)) {
            return gn(str);
        }
        int indexOf = str.indexOf("-g");
        if (indexOf + 5 < str.length() && indexOf >= 0 && j6(str.charAt(indexOf + 2)) && j6(str.charAt(indexOf + 3)) && j6(str, indexOf + 4)) {
            String substring = str.substring(indexOf + 2);
            if (amz.j6(substring)) {
                return gn(substring);
            }
        }
        return null;
    }

    private aqc j6(aql aql, aoc aoc, String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                throw new alu(MessageFormat.format(JGitText.j6().invalidReflogRevision, new Object[]{str}));
            }
            asa j6 = new asb(this, aoc.j6()).j6(parseInt);
            if (j6 != null) {
                return aql.Zo(j6.j6());
            }
            throw new alu(MessageFormat.format(JGitText.j6().reflogEntryNotFound, new Object[]{Integer.valueOf(parseInt), aoc.j6()}));
        } catch (NumberFormatException e) {
            throw new alu(MessageFormat.format(JGitText.j6().invalidReflogRevision, new Object[]{str}));
        }
    }

    private ans gn(String str) {
        amz DW = amz.DW(str);
        any v5 = v5();
        try {
            Collection j6 = v5.j6(DW);
            if (j6.size() == 0) {
                return null;
            }
            if (j6.size() == 1) {
                ans ans = (ans) j6.iterator().next();
                v5.FH();
                return ans;
            }
            throw new akw(DW, j6);
        } finally {
            v5.FH();
        }
    }

    public void u7() {
        this.DW.incrementAndGet();
    }

    public void tp() {
        if (this.DW.decrementAndGet() == 0) {
            EQ();
        }
    }

    protected void EQ() {
        FH().v5();
        Zo().DW();
    }

    public String toString() {
        String path;
        if (DW() != null) {
            path = DW().getPath();
        } else {
            path = new StringBuilder(String.valueOf(getClass().getSimpleName())).append("-").append(System.identityHashCode(this)).toString();
        }
        return "Repository[" + path + "]";
    }

    public String we() {
        aoc FH = FH("HEAD");
        if (FH == null) {
            return null;
        }
        if (FH.DW()) {
            return FH.Hw().j6();
        }
        if (FH.v5() != null) {
            return FH.v5().DW();
        }
        return null;
    }

    public Set<ans> J0() {
        return Collections.emptySet();
    }

    public aoc FH(String str) {
        return Zo().DW(str);
    }

    public Map<String, aoc> J8() {
        try {
            return Zo().FH("");
        } catch (IOException e) {
            return new HashMap();
        }
    }

    public aoc j6(aoc aoc) {
        try {
            aoc = Zo().j6(aoc);
        } catch (IOException e) {
        }
        return aoc;
    }

    public File Ws() {
        if (!j3()) {
            return this.VH;
        }
        throw new all();
    }

    public ako QX() {
        return ako.j6(Ws(), gn());
    }

    public ako XL() {
        return ako.j6(Ws(), gn(), new aoh$1(this));
    }

    public aok aM() {
        if (j3() || DW() == null) {
            return aok.BARE;
        }
        if (new File(Mr(), ".dotest").exists()) {
            return aok.REBASING;
        }
        if (new File(DW(), ".dotest-merge").exists()) {
            return aok.REBASING_INTERACTIVE;
        }
        if (new File(DW(), "rebase-apply/rebasing").exists()) {
            return aok.REBASING_REBASING;
        }
        if (new File(DW(), "rebase-apply/applying").exists()) {
            return aok.APPLY;
        }
        if (new File(DW(), "rebase-apply").exists()) {
            return aok.REBASING;
        }
        if (new File(DW(), "rebase-merge/interactive").exists()) {
            return aok.REBASING_INTERACTIVE;
        }
        if (new File(DW(), "rebase-merge").exists()) {
            return aok.REBASING_MERGE;
        }
        if (new File(DW(), "MERGE_HEAD").exists()) {
            try {
                if (!QX().EQ()) {
                    return aok.MERGING_RESOLVED;
                }
            } catch (IOException e) {
            }
            return aok.MERGING;
        } else if (new File(DW(), "BISECT_LOG").exists()) {
            return aok.BISECTING;
        } else {
            if (!new File(DW(), "CHERRY_PICK_HEAD").exists()) {
                return aok.SAFE;
            }
            try {
                if (!QX().EQ()) {
                    return aok.CHERRY_PICKING_RESOLVED;
                }
            } catch (IOException e2) {
            }
            return aok.CHERRY_PICKING;
        }
    }

    public static boolean Hw(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        if (str.endsWith(".lock")) {
            return false;
        }
        int i = 0;
        char c = '\u0000';
        int i2 = 1;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= ' ') {
                return false;
            }
            switch (charAt) {
                case '*':
                case ':':
                case '?':
                case '[':
                case '\\':
                case '^':
                case '~':
                    return false;
                case '.':
                    switch (c) {
                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        case '.':
                        case '/':
                            return false;
                        default:
                            if (i != length - 1) {
                                break;
                            }
                            return false;
                    }
                case '/':
                    if (i != 0 && i != length - 1) {
                        i2++;
                        break;
                    }
                    return false;
                    break;
                case '{':
                    if (c != '@') {
                        break;
                    }
                    return false;
                default:
                    break;
            }
            i++;
            c = charAt;
        }
        if (i2 > 1) {
            return true;
        }
        return false;
    }

    public boolean j3() {
        return this.Zo == null;
    }

    public File Mr() {
        if (!j3()) {
            return this.Zo;
        }
        throw new all();
    }

    public static String v5(String str) {
        if (str.startsWith("refs/heads/")) {
            return str.substring("refs/heads/".length());
        }
        if (str.startsWith("refs/tags/")) {
            return str.substring("refs/tags/".length());
        }
        if (str.startsWith("refs/remotes/")) {
            return str.substring("refs/remotes/".length());
        }
        return str;
    }

    public String a8() {
        if (j3() || DW() == null) {
            throw new all();
        }
        try {
            return axe.DW(awx.j6(new File(DW(), "MERGE_MSG")));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void Zo(String str) {
        File file = new File(this.FH, "MERGE_MSG");
        if (str != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
            } finally {
                fileOutputStream.close();
            }
        } else {
            awv.j6(file, 4);
        }
    }

    public List<ans> lg() {
        if (j3() || DW() == null) {
            throw new all();
        }
        byte[] u7 = u7("MERGE_HEAD");
        if (u7 == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < u7.length; i = axe.Hw(u7, i + 40)) {
            linkedList.add(ans.v5(u7, i));
        }
        return linkedList;
    }

    public void j6(List<ans> list) {
        j6((List) list, "MERGE_HEAD");
    }

    public void j6(ans ans) {
        List singletonList;
        if (ans != null) {
            singletonList = Collections.singletonList(ans);
        } else {
            singletonList = null;
        }
        j6(singletonList, "CHERRY_PICK_HEAD");
    }

    private byte[] u7(String str) {
        try {
            byte[] j6 = awx.j6(new File(DW(), str));
            return j6.length > 0 ? j6 : null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private void j6(List<ans> list, String str) {
        File file = new File(DW(), str);
        if (list != null) {
            OutputStream axp = new axp(new FileOutputStream(file));
            try {
                for (ans DW : list) {
                    DW.DW(axp);
                    axp.write(10);
                }
            } finally {
                axp.close();
            }
        } else {
            awv.j6(file, 4);
        }
    }
}
