import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.jgit.JGitText;

class avu extends atf implements auj {
    private final avn DW;
    private final avv FH;
    private final avd Hw;
    private Collection<aus> VH;
    private Map<String, aoc> Zo;
    private final aoh j6;
    private LinkedHashMap<String, String> v5;

    avu(avw avw, avv avv) {
        this.Hw = (avd) avw;
        this.j6 = this.Hw.FH;
        this.DW = this.Hw.Hw();
        this.FH = avv;
    }

    public void j6(aob aob, Map<String, aus> map) {
        Hw();
        this.v5 = null;
        this.Zo = new TreeMap(j6());
        this.VH = new ArrayList(map.size());
        List<aus> arrayList = new ArrayList();
        for (aus aus : map.values()) {
            String v5 = aus.v5();
            if (!v5.startsWith("refs/") || !aoh.Hw(v5)) {
                aus.j6(aus$a.REJECTED_OTHER_REASON);
                aus.j6(JGitText.j6().funnyRefname);
            } else if (anb.j6(ans.Zo(), aus.FH())) {
                j6(aus);
            } else {
                arrayList.add(aus);
            }
        }
        if (!arrayList.isEmpty()) {
            j6((List) arrayList, aob);
        }
        for (aus aus2 : arrayList) {
            DW(aus2);
        }
        if (!arrayList.isEmpty() && Zo()) {
            j6((List) arrayList);
        }
        aog avu_1 = new avu$1(this, this.Zo.values());
        if (!this.VH.isEmpty()) {
            try {
                avu_1.DW();
                for (aus aus22 : this.VH) {
                    aus22.j6(aus$a.OK);
                }
            } catch (Throwable e) {
                Throwable th = e;
                for (aus aus222 : this.VH) {
                    aus222.j6(aus$a.REJECTED_OTHER_REASON);
                    aus222.j6(th.getMessage());
                }
                throw new amb(this.DW, JGitText.j6().failedUpdatingRefs, th);
            }
        }
        try {
            avu_1.j6();
        } catch (Throwable e2) {
            throw new amb(this.DW, JGitText.j6().failedUpdatingRefs, e2);
        }
    }

    public void u7() {
        this.FH.v5();
    }

    private void j6(List<aus> list, aob aob) {
        OutputStream axp;
        String str = null;
        asy asy = new asy(this.Hw.J8(), this.j6.v5());
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        for (aus FH : list) {
            try {
                hashSet.add(FH.FH());
            } catch (IOException e) {
                Throwable e2 = e;
                String str2 = null;
            }
        }
        for (aoc aoc : DW()) {
            hashSet2.add(aoc.v5());
            if (aoc.VH() != null) {
                hashSet2.add(aoc.VH());
            }
        }
        asy.j6(aob, hashSet, hashSet2);
        if (asy.DW() == 0) {
            asy.v5();
            return;
        }
        this.v5 = new LinkedHashMap();
        for (String str3 : this.FH.FH()) {
            this.v5.put(str3, str3);
        }
        String str32 = "pack-" + asy.FH().DW();
        String stringBuilder = new StringBuilder(String.valueOf(str32)).append(".pack").toString();
        String str4 = "pack/" + stringBuilder;
        try {
            String str5 = "pack/" + str32 + ".idx";
        } catch (IOException e3) {
            e2 = e3;
            str2 = str4;
            try {
                DW(str);
                DW(str2);
                throw new amb(this.DW, JGitText.j6().cannotStoreObjects, e2);
            } catch (Throwable th) {
                asy.v5();
            }
        }
        try {
            if (this.v5.remove(stringBuilder) != null) {
                this.FH.j6(this.v5.keySet());
                this.FH.FH(str5);
            }
            str32 = "Put " + str32.substring(0, 12);
            OutputStream j6 = this.FH.j6(str4, aob, new StringBuilder(String.valueOf(str32)).append("..pack").toString());
            try {
                axp = new axp(j6);
                try {
                    asy.j6(aob, aob, axp);
                    axp.close();
                    j6 = this.FH.j6(str5, aob, new StringBuilder(String.valueOf(str32)).append("..idx").toString());
                    try {
                        axp = new axp(j6);
                        try {
                            asy.j6(axp);
                            axp.close();
                            Collection arrayList = new ArrayList();
                            arrayList.add(stringBuilder);
                            arrayList.addAll(this.v5.keySet());
                            this.FH.j6(arrayList);
                            asy.v5();
                        } catch (Throwable th2) {
                            e2 = th2;
                            axp.close();
                            throw e2;
                        }
                    } catch (Throwable th3) {
                        e2 = th3;
                        axp = j6;
                        axp.close();
                        throw e2;
                    }
                } catch (Throwable th4) {
                    e2 = th4;
                    axp.close();
                    throw e2;
                }
            } catch (Throwable th5) {
                e2 = th5;
                axp = j6;
                axp.close();
                throw e2;
            }
        } catch (IOException e4) {
            e2 = e4;
            str = str5;
            str2 = str4;
            DW(str);
            DW(str2);
            throw new amb(this.DW, JGitText.j6().cannotStoreObjects, e2);
        }
    }

    private void DW(String str) {
        if (str != null) {
            try {
                this.FH.FH(str);
            } catch (IOException e) {
            }
        }
    }

    private void j6(aus aus) {
        aoc aoc = (aoc) this.Zo.remove(aus.v5());
        if (aoc == null) {
            aus.j6(aus$a.OK);
            return;
        }
        if (aoc.Zo().DW()) {
            this.VH.add(aus);
        }
        if (aoc.Zo().j6()) {
            try {
                this.FH.Hw(aus.v5());
                aus.j6(aus$a.OK);
            } catch (IOException e) {
                aus.j6(aus$a.REJECTED_OTHER_REASON);
                aus.j6(e.getMessage());
            }
        }
        try {
            this.FH.v5(aus.v5());
        } catch (IOException e2) {
            aus.j6(aus$a.REJECTED_OTHER_REASON);
            aus.j6(e2.getMessage());
        }
    }

    private void DW(aus aus) {
        try {
            this.FH.j6(aus.v5(), aus.FH());
            this.Zo.put(aus.v5(), new anu$c(aoc$a.LOOSE, aus.v5(), aus.FH()));
            aus.j6(aus$a.OK);
        } catch (IOException e) {
            aus.j6(aus$a.REJECTED_OTHER_REASON);
            aus.j6(e.getMessage());
        }
    }

    private boolean Zo() {
        return j6().isEmpty() && this.v5 != null && this.v5.isEmpty();
    }

    private void j6(List<aus> list) {
        try {
            this.FH.j6("../HEAD", anj.DW("ref: " + DW((List) list) + "\n"));
            try {
                String str = "[core]\n\trepositoryformatversion = 0\n";
                this.FH.j6("../config", anj.DW("[core]\n\trepositoryformatversion = 0\n"));
            } catch (Throwable e) {
                throw new amb(this.DW, JGitText.j6().cannotCreateConfig, e);
            }
        } catch (Throwable e2) {
            throw new amb(this.DW, JGitText.j6().cannotCreateHEAD, e2);
        }
    }

    private static String DW(List<aus> list) {
        for (aus v5 : list) {
            String v52 = v5.v5();
            if (v52.equals("refs/heads/master")) {
                return v52;
            }
        }
        for (aus v53 : list) {
            v52 = v53.v5();
            if (v52.startsWith("refs/heads/")) {
                return v52;
            }
        }
        return ((aus) list.get(0)).v5();
    }
}
