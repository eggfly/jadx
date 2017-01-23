import com.aide.common.e;
import com.aide.ui.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pk {
    private Map<String, iw$g> DW;
    private Map<iw$g, String> j6;

    public pk() {
        this.j6 = new HashMap();
        this.DW = new HashMap();
    }

    public void j6() {
        this.DW.clear();
    }

    private iw$g FH(iw$g iw_g) {
        if (!this.DW.containsKey(iw_g.j6())) {
            this.DW.put(iw_g.j6(), iw_g);
        }
        return (iw$g) this.DW.get(iw_g.j6());
    }

    public void j6(iw$g iw_g) {
        j6(iw_g, 3);
    }

    private void j6(iw$g iw_g, int i) {
        String Hw = Hw(null, iw_g);
        if (Hw != null) {
            String DW = DW(Hw);
            if (!this.DW.containsKey(iw_g.j6()) || iz.j6(DW, ((iw$g) this.DW.get(iw_g.j6())).Hw) > 0) {
                this.DW.put(iw_g.j6(), new iw$g(iw_g, DW));
            }
            if (i > 0) {
                for (iw$g iw_g2 : ((jb) new jb().J0(FH(Hw))).j6) {
                    if (!Hw(iw_g2)) {
                        j6(iw_g2, i - 1);
                    }
                }
            }
        }
    }

    private static String DW(String str) {
        String[] split = str.split("/");
        return split[split.length - 2];
    }

    public void DW() {
        this.j6.clear();
    }

    public boolean j6(Map<String, String> map, iw$g iw_g) {
        return Hw(map, FH(iw_g)) != null;
    }

    public String DW(iw$g iw_g) {
        return Hw((Map) null, iw_g);
    }

    public List<String> DW(Map<String, String> map, iw$g iw_g) {
        return j6((Map) map, Hw(map, FH(iw_g)));
    }

    public List<String> j6(String str) {
        return j6(null, str);
    }

    public List<iw$g> FH(Map<String, String> map, iw$g iw_g) {
        List arrayList = new ArrayList();
        j6((Map) map, iw_g, arrayList, 3);
        return arrayList;
    }

    private void j6(Map<String, String> map, iw$g iw_g, List<iw$g> list, int i) {
        String Hw = Hw(map, FH(iw_g));
        if (Hw == null) {
            list.add(iw_g);
        } else if (i > 0) {
            for (iw$g iw_g2 : ((jb) new jb().J0(FH(Hw))).j6) {
                if (!Hw(iw_g2)) {
                    j6((Map) map, iw_g2, (List) list, i - 1);
                }
            }
        }
    }

    private List<String> j6(Map<String, String> map, String str) {
        List arrayList = new ArrayList();
        if (str != null) {
            j6((Map) map, str, arrayList, 3);
        }
        return arrayList;
    }

    private void j6(Map<String, String> map, String str, List<String> list, int i) {
        if (!list.contains(str)) {
            list.add(str);
            if (i > 0) {
                for (iw$g iw_g : ((jb) new jb().J0(FH(str))).j6) {
                    if (!Hw(iw_g)) {
                        String Hw = Hw(map, FH(iw_g));
                        if (Hw != null) {
                            j6((Map) map, Hw, (List) list, i - 1);
                        }
                    }
                }
            }
        }
    }

    private boolean Hw(iw$g iw_g) {
        return iw_g.DW.contains("android-all");
    }

    private List<String> v5() {
        List<String> arrayList = new ArrayList();
        for (String str : h.j3().split(";")) {
            if (!str.trim().isEmpty()) {
                arrayList.add(str.trim());
            }
        }
        if (iu.FH("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip")) {
            arrayList.add(iu.DW("https://dl-ssl.google.com/android/repository/google_m2repository_gms_v8_rc42_wear_2b1_rc4.zip"));
        }
        if (iu.FH("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip")) {
            arrayList.add(iu.DW("https://dl-ssl.google.com/android/repository/android_m2repository_r41.zip"));
        }
        arrayList.add(Zo());
        return arrayList;
    }

    private String Hw(Map<String, String> map, iw$g iw_g) {
        String str;
        if (map != null) {
            for (String str2 : map.keySet()) {
                String j6 = j6(str2, iw_g.j6, iw_g.DW, iw_g.Hw);
                if (j6 != null) {
                    String name = new File(j6).getName();
                    str2 = ((String) map.get(str2)) + "/" + name.substring(0, name.length() - 4) + ".exploded.aar";
                    DW(j6, str2);
                    return str2;
                }
            }
        }
        if (this.j6.containsKey(iw_g)) {
            str2 = (String) this.j6.get(iw_g);
            if (str2.length() == 0) {
                return null;
            }
            return str2;
        }
        str2 = v5(iw_g);
        if (str2 == null) {
            this.j6.put(iw_g, "");
            return str2;
        }
        this.j6.put(iw_g, str2);
        return str2;
    }

    private String v5(iw$g iw_g) {
        for (String DW : v5()) {
            String DW2 = DW(DW2, iw_g.j6, iw_g.DW, iw_g.Hw);
            if (DW2 != null) {
                return DW2;
            }
        }
        return null;
    }

    private String j6(String str, String str2, String str3, String str4) {
        String str5 = str + "/" + str3 + ".aar";
        if (new File(str5).exists()) {
            return str5;
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str3 + "-") && file.getName().endsWith(".aar") && ja.j6(file.getName().substring(str3.length() + 1, file.getName().length() - 4), str4)) {
                    return file.getPath();
                }
            }
        }
        return null;
    }

    private String DW(String str, String str2, String str3, String str4) {
        String str5 = str + "/" + str2.replace(".", "/") + "/" + str3;
        if (qh.we(str5)) {
            String j6 = j6(str5, str4);
            if (j6 != null) {
                str5 = str5 + "/" + j6 + "/" + str3 + "-" + j6;
                if (new File(str5 + ".jar").isFile()) {
                    return str5 + ".jar";
                }
                if (new File(str5 + ".aar").isDirectory()) {
                    return str5 + ".aar";
                }
                if (new File(str5 + ".exploded.aar").isDirectory()) {
                    return str5 + ".exploded.aar";
                }
                if (new File(str5 + ".aar").isFile()) {
                    DW(str5 + ".aar", str5 + ".exploded.aar");
                    return str5 + ".exploded.aar";
                }
            }
        }
        return null;
    }

    private String j6(String str, String str2) {
        String str3 = str + "/maven-metadata.xml";
        if (qh.J0(str3)) {
            str3 = ((ja) new ja().J0(str3)).FH(str2);
            if (str3 != null) {
                return str3;
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str32 : qh.Ws(str)) {
                arrayList.add(qh.Zo(str32));
            }
            return ja.j6(arrayList, str2);
        } catch (IOException e) {
            return null;
        }
    }

    private void DW(String str, String str2) {
        if (!FH(str, str2)) {
            try {
                qh.j6(new FileInputStream(str), str2, true);
                e.j6("Extracted AAR " + str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean FH(String str, String str2) {
        if (!new File(str2).isDirectory()) {
            return false;
        }
        File[] listFiles = new File(str2).listFiles();
        if (listFiles != null) {
            long lastModified = new File(str).lastModified();
            for (File file : listFiles) {
                if (file.isFile() && file.lastModified() < lastModified) {
                    return false;
                }
            }
        }
        return true;
    }

    private String FH(String str) {
        if (str.endsWith(".exploded.aar")) {
            return str.substring(0, str.length() - ".exploded.aar".length()) + ".pom";
        }
        return str.substring(0, str.length() - "._ar".length()) + ".pom";
    }

    private static String Zo() {
        return qh.j6() + "/.aide/maven";
    }

    public void FH() {
        com.aide.ui.e.j6(com.aide.ui.e.tp(), "Refreshing...", new pk$1(this), new pk$2(this));
    }

    public static String j6(iw$m iw_m, iw$g iw_g) {
        return iw_m.j6 + ("/" + iw_g.j6.replace('.', '/') + "/" + iw_g.DW) + "/maven-metadata.xml";
    }

    public static String DW(iw$m iw_m, iw$g iw_g) {
        String Zo = Zo();
        return Zo + ("/" + iw_g.j6.replace('.', '/') + "/" + iw_g.DW) + "/maven-metadata.xml";
    }

    public static String j6(iw$m iw_m, iw$g iw_g, String str, String str2) {
        return iw_m.j6 + (("/" + iw_g.j6.replace('.', '/') + "/" + iw_g.DW) + "/" + str + "/" + iw_g.DW + "-" + str) + str2;
    }

    public static String DW(iw$m iw_m, iw$g iw_g, String str, String str2) {
        String Zo = Zo();
        return Zo + (("/" + iw_g.j6.replace('.', '/') + "/" + iw_g.DW) + "/" + str + "/" + iw_g.DW + "-" + str) + str2;
    }
}
