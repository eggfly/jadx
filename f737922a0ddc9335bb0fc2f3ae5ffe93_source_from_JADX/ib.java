import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ib {
    private cc DW;
    private int EQ;
    private Set<String> FH;
    private Set<String> Hw;
    private String VH;
    private String Zo;
    private int gn;
    private ih j6;
    private StringBuilder tp;
    private Map<String, Integer> u7;
    private Set<String> v5;
    private int we;

    public ib(cc ccVar, ih ihVar) {
        this.FH = new HashSet(Arrays.asList(new String[]{"text", "textOff", "textOn", "hint", "summary", "title", "dialogTitle"}));
        this.Hw = new HashSet(Arrays.asList(new String[]{"section", "description", "title", "task", "designer_task", "fail", "success", "hint"}));
        this.v5 = new HashSet(Arrays.asList(new String[]{"fail", "hint"}));
        this.u7 = new HashMap();
        this.DW = ccVar;
        this.j6 = ihVar;
    }

    public void j6(bv bvVar, bv bvVar2, int i, int i2, int i3, int i4) {
        this.DW.rN.DW();
        if (i == i3 && i2 == i4) {
            this.EQ = 1;
            this.we = Integer.MAX_VALUE;
        } else {
            this.EQ = Math.min(i, i3);
            this.we = Math.max(i, i3);
        }
        cj DW = this.DW.sh.DW(bvVar, this.j6);
        this.tp = new StringBuilder();
        String v5 = bvVar.v5();
        if (v5.startsWith("course_") && v5.endsWith("_en.xml")) {
            DW(DW);
        } else {
            j6(DW);
        }
        this.DW.sh.j6(DW);
        if (this.tp.length() > 0) {
            if (bvVar2.nw()) {
                int indexOf;
                List lg = bvVar2.lg();
                for (int i5 = 1; i5 < lg.size(); i5++) {
                    indexOf = ((String) lg.get(i5)).indexOf("<resources>");
                    if (indexOf >= 0) {
                        int length = (indexOf + "<resources>".length()) + 1;
                        this.DW.rN.j6(bvVar2, i5, length, i5, length, "\n" + this.tp.toString());
                        indexOf = 1;
                        break;
                    }
                }
                indexOf = 0;
                if (indexOf == 0) {
                    this.DW.rN.j6(bvVar2, 1, 1, 1, 1, this.tp.toString());
                }
            } else {
                this.DW.rN.DW(bvVar2, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n" + this.tp.toString() + "\n</resources>\n");
            }
        }
        this.DW.rN.FH();
    }

    private void j6(cj cjVar) {
        j6(cjVar, cjVar.Ws());
    }

    private void j6(cj cjVar, int i) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg));
        }
        if (cjVar.rN(i) == 203 && cjVar.nw(i) >= this.EQ && cjVar.SI(i) <= this.we) {
            String Hw = Hw(cjVar, i);
            String FH = FH(cjVar, i);
            if (this.FH.contains(Hw) && "android".equals(FH)) {
                FH = v5(cjVar, i);
                if (!FH.startsWith("@string/")) {
                    String j6 = j6(cjVar, i, "android", "key");
                    if (j6 != null) {
                        Hw = j6.toLowerCase() + "_" + Hw;
                    } else {
                        Hw = j6(FH);
                    }
                    j6(cjVar, i, "@string/" + Hw);
                    j6(Hw, FH, false);
                }
            }
        }
    }

    private String j6(String str) {
        String str2 = "";
        for (int i = 0; i < Math.min(str.length(), 30); i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                str2 = str2 + "_";
            } else if (Character.isJavaIdentifierPart(charAt)) {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    private void DW(cj cjVar) {
        String v5 = cjVar.we().v5();
        this.Zo = v5.substring(0, v5.length() - "_en.xml".length());
        this.VH = null;
        this.gn = 0;
        this.u7.clear();
        DW(cjVar, cjVar.Ws());
    }

    private void DW(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            DW(cjVar, cjVar.Hw(i, i2));
        }
        if (cjVar.rN(i) == 203 && cjVar.nw(i) >= this.EQ && cjVar.SI(i) <= this.we) {
            String v5;
            String Hw = Hw(cjVar, i);
            FH(cjVar, i);
            if ("title".equals(Hw)) {
                this.gn = 0;
                v5 = v5(cjVar, i);
                if (v5 == null || v5.startsWith("@string/")) {
                    this.VH = null;
                } else {
                    this.VH = v5.toLowerCase().replace(" ", "_").replace("-", "_");
                    DW("Lesson " + v5);
                }
            }
            if ("task".equals(Hw)) {
                this.gn++;
                this.u7.clear();
                for (String v52 : this.v5) {
                    this.u7.put(v52, Integer.valueOf(1));
                }
            }
            if (this.Hw.contains(Hw)) {
                String v53 = v5(cjVar, i);
                if (!(this.VH == null || v53.startsWith("@string/"))) {
                    String substring;
                    v52 = this.Zo + "_" + this.VH;
                    if (this.gn > 0) {
                        v52 = v52 + "_" + this.gn;
                    }
                    v52 = v52 + "_" + Hw;
                    if (this.u7.containsKey(Hw)) {
                        v52 = v52 + "_" + this.u7.get(Hw);
                    }
                    if (v52.endsWith("_title")) {
                        substring = v52.substring(0, v52.length() - "_title".length());
                    } else {
                        substring = v52;
                    }
                    List<String> arrayList = new ArrayList();
                    String replace = j6(v53, (List) arrayList).replace("'", "\\'");
                    v52 = "@string/" + substring;
                    v53 = v52;
                    for (String v522 : arrayList) {
                        v53 = v53 + " " + v522.replace("_", "__").replace(" ", "_");
                    }
                    j6(cjVar, i, v53);
                    j6(substring, replace, true);
                }
                if (this.u7.containsKey(Hw)) {
                    this.u7.put(Hw, Integer.valueOf(((Integer) this.u7.get(Hw)).intValue() + 1));
                }
            }
        }
    }

    private String j6(String str, List<String> list) {
        String str2 = "";
        int i = 1;
        while (true) {
            int indexOf = str.indexOf("!_");
            int indexOf2 = str.indexOf("'_");
            if (indexOf == -1 && indexOf2 == -1) {
                return str2 + str;
            }
            int indexOf3;
            if (indexOf == -1 || (indexOf2 != -1 && indexOf2 <= indexOf)) {
                indexOf3 = str.indexOf("_'", indexOf2 + 2) + 2;
                indexOf = indexOf2;
            } else {
                indexOf3 = str.indexOf("_!", indexOf + 2) + 2;
            }
            if (indexOf >= indexOf3) {
                return str2 + str;
            }
            StringBuilder append = new StringBuilder().append(str2).append(str.substring(0, indexOf)).append("%");
            int i2 = i + 1;
            String stringBuilder = append.append(i).append("$s").toString();
            list.add(str.substring(indexOf, indexOf3));
            str = str.substring(indexOf3);
            int i3 = i2;
            str2 = stringBuilder;
            i = i3;
        }
    }

    private void j6(String str, String str2, boolean z) {
        String str3 = "    <string name=\"" + str + "\">" + str2 + "</string>\n";
        if (z) {
            this.tp.append(str3);
        } else {
            this.tp.insert(0, str3);
        }
    }

    private void DW(String str) {
        this.tp.append("\n    <!-- " + str + " -->\n");
    }

    private void j6(cj cjVar, int i, String str) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        this.DW.rN.j6(cjVar.we(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), "\"" + str + "\"");
    }

    private String FH(cj cjVar, int i) {
        return cjVar.BT(cjVar.Hw(cjVar.Hw(i, 0), 0));
    }

    private String Hw(cj cjVar, int i) {
        return cjVar.BT(cjVar.Hw(cjVar.Hw(i, 0), 2));
    }

    private String j6(cj cjVar, int i, String str, String str2) {
        int aM = cjVar.aM(i);
        for (int lg = cjVar.lg(aM) - 1; lg >= 0; lg--) {
            int Hw = cjVar.Hw(aM, lg);
            if (cjVar.rN(Hw) == 203 && str2.equals(Hw(cjVar, Hw)) && str.equals(FH(cjVar, Hw))) {
                return v5(cjVar, Hw);
            }
        }
        return null;
    }

    private String v5(cj cjVar, int i) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        String str = "";
        for (int i2 = 1; i2 < cjVar.lg(Hw) - 1; i2++) {
            int Hw2 = cjVar.Hw(Hw, i2);
            if (cjVar.rN(Hw2) == 18) {
                str = str + cjVar.a8(Hw2);
            } else if (cjVar.rN(Hw2) == 20) {
                str = str + cjVar.a8(Hw2);
            } else if (cjVar.rN(Hw2) == 205) {
                str = str + "&" + cjVar.BT(cjVar.Hw(Hw2, 1)) + ";";
            } else {
                str = str + this.j6.Hw().XL(cjVar.rN(Hw2));
            }
        }
        return str;
    }
}
