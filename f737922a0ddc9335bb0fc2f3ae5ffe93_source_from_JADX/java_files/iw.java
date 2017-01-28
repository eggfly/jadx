import com.aide.common.e;
import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.collections.AST;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.codehaus.groovy.antlr.SourceBuffer;
import org.codehaus.groovy.antlr.UnicodeEscapingReader;
import org.codehaus.groovy.antlr.parser.GroovyLexer;
import org.codehaus.groovy.antlr.parser.GroovyRecognizer;

public class iw extends oe<iw> {
    public iw$a DW;
    public List<iw$b> EQ;
    public int FH;
    public int Hw;
    public iw$h J0;
    public Map<String, iw$j> J8;
    public List<iw$i> VH;
    public List<iw$i> Zo;
    public List<iw$i> gn;
    public String j6;
    public List<iw$b> tp;
    public int u7;
    public SortedMap<String, iw$a> v5;
    public List<iw$b> we;

    protected /* synthetic */ oe DW(String str) {
        return u7(str);
    }

    public String j6(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).DW == null) {
            return this.DW.DW;
        }
        return ((iw$a) this.v5.get(str)).DW;
    }

    public String FH(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).j6 == null) {
            return this.DW.j6;
        }
        return ((iw$a) this.v5.get(str)).j6;
    }

    public String Hw(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).v5 == null) {
            return this.DW.v5;
        }
        return ((iw$a) this.v5.get(str)).v5;
    }

    public String v5(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).Hw == null) {
            return this.DW.Hw;
        }
        return ((iw$a) this.v5.get(str)).Hw;
    }

    public boolean Zo(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).Zo == null) {
            return "true".equals(this.DW.Zo);
        }
        return "true".equals(((iw$a) this.v5.get(str)).Zo);
    }

    public String VH(String str) {
        if (str == null || !this.v5.containsKey(str) || ((iw$a) this.v5.get(str)).FH == null) {
            return this.DW.FH;
        }
        return ((iw$a) this.v5.get(str)).FH;
    }

    public iw$j gn(String str) {
        if (str == null) {
            return null;
        }
        return (iw$j) this.J8.get(str);
    }

    protected iw u7(String str) {
        return new iw(str);
    }

    public iw() {
        this.DW = new iw$a(this);
        this.FH = -1;
        this.Hw = -1;
        this.v5 = new TreeMap();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = new ArrayList();
        this.u7 = -1;
        this.tp = new ArrayList();
        this.EQ = new ArrayList();
        this.we = new ArrayList();
        this.J8 = new HashMap();
    }

    public void tp(String str) {
        String str2 = "\t\t" + str + " {\n\t\t}";
        if (this.Hw != -1) {
            j6(str2, "", this.Hw);
        } else {
            j6("\tproductFlavors {\n" + str2 + "\n\t}\n", "android", this.FH);
        }
    }

    public void EQ(String str) {
        J8("compile '" + str + "'");
    }

    public void we(String str) {
        J8("compile project('" + (":" + qh.DW(qh.v5(qh.v5(this.Ws)), str).replace("/", ":")) + "')");
    }

    private void J8(String str) {
        j6("\t" + str, "dependencies", this.u7);
    }

    private void j6(String str, String str2, int i) {
        try {
            List<String> arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.Ws));
            int i2 = 1;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
                if (i2 == i) {
                    arrayList.add(str);
                }
                i2++;
            }
            if (i < 0) {
                arrayList.add(str2 + " {");
                arrayList.add(str);
                arrayList.add("}");
            }
            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(this.Ws);
            for (String write : arrayList) {
                fileWriter.write(write);
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (Throwable e) {
            e.j6(e);
        }
    }

    private iw(String str) {
        this.DW = new iw$a(this);
        this.FH = -1;
        this.Hw = -1;
        this.v5 = new TreeMap();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = new ArrayList();
        this.u7 = -1;
        this.tp = new ArrayList();
        this.EQ = new ArrayList();
        this.we = new ArrayList();
        this.J8 = new HashMap();
        try {
            Reader fileReader = new FileReader(str);
            SourceBuffer sourceBuffer = new SourceBuffer();
            Reader unicodeEscapingReader = new UnicodeEscapingReader(fileReader, sourceBuffer);
            GroovyLexer groovyLexer = new GroovyLexer(unicodeEscapingReader);
            unicodeEscapingReader.j6((CharScanner) groovyLexer);
            GroovyRecognizer j6 = GroovyRecognizer.j6(groovyLexer);
            j6.j6(sourceBuffer);
            j6.VH();
            fileReader.close();
            for (AST FH = j6.FH(); FH != null; FH = gn(FH)) {
                j6(FH, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j6(AST ast, String str) {
        String DW = DW(ast);
        if (DW != null) {
            String str2 = str.length() == 0 ? DW : str + "." + DW;
            int i = -1;
            switch (str2.hashCode()) {
                case -1189621910:
                    if (str2.equals("model.android.productFlavors")) {
                        i = 5;
                        break;
                    }
                    break;
                case -861391249:
                    if (str2.equals("android")) {
                        i = 0;
                        break;
                    }
                    break;
                case -798179579:
                    if (str2.equals("android.productFlavors")) {
                        i = 4;
                        break;
                    }
                    break;
                case 503774505:
                    if (str2.equals("dependencies")) {
                        i = 6;
                        break;
                    }
                    break;
                case 594250125:
                    if (str2.equals("model.android.compileSdkVersion")) {
                        i = 3;
                        break;
                    }
                    break;
                case 1216524306:
                    if (str2.equals("android.compileSdkVersion")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1914505386:
                    if (str2.equals("model.android")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.FH = j6(ast);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.j6 = v5(ast);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                    this.Hw = j6(ast);
                    break;
                case 6:
                    this.u7 = j6(ast);
                    break;
                default:
                    if (!j6(str2, "android.defaultConfig")) {
                        if (!j6(str2, "model.android.defaultConfig")) {
                            if (!j6(str2, "model.android.defaultConfig.with")) {
                                if (!j6(str2, "android.productFlavors")) {
                                    if (!j6(str2, "model.android.productFlavors")) {
                                        if (!j6(str2, "android.signingConfigs")) {
                                            if (!j6(str2, "model.android.signingConfigs")) {
                                                if (!j6(str2, "dependencies")) {
                                                    if (!j6(str2, "subprojects.dependencies")) {
                                                        if (!j6(str2, "allprojects.dependencies")) {
                                                            if (!j6(str2, "repositories")) {
                                                                if (!j6(str2, "subprojects.repositories")) {
                                                                    if (j6(str2, "allprojects.repositories")) {
                                                                        DW(ast, j6(str2, 2), this.VH);
                                                                        break;
                                                                    }
                                                                }
                                                                DW(ast, j6(str2, 2), this.gn);
                                                                break;
                                                            }
                                                            DW(ast, j6(str2, 1), this.Zo);
                                                            break;
                                                        }
                                                        j6(ast, j6(str2, 2), this.we);
                                                        break;
                                                    }
                                                    j6(ast, j6(str2, 2), this.EQ);
                                                    break;
                                                }
                                                j6(ast, j6(str2, 1), this.tp);
                                                break;
                                            }
                                            DW(ast, str2, 3);
                                            break;
                                        }
                                        DW(ast, str2, 2);
                                        break;
                                    }
                                    j6(ast, str2, 3);
                                    break;
                                }
                                j6(ast, str2, 2);
                                break;
                            }
                            j6(ast, j6(str2, 4), this.DW);
                            break;
                        }
                        j6(ast, j6(str2, 3), this.DW);
                        break;
                    }
                    j6(ast, j6(str2, 2), this.DW);
                    break;
                    break;
            }
            for (AST j6 : Hw(ast)) {
                j6(j6, str2);
            }
        }
    }

    private void j6(AST ast, String str, List<iw$b> list) {
        int i = -1;
        switch (str.hashCode()) {
            case 557892929:
                if (str.equals("testCompile")) {
                    i = 1;
                    break;
                }
                break;
            case 950491699:
                if (str.equals("compile")) {
                    i = 2;
                    break;
                }
                break;
            case 1223343650:
                if (str.equals("wearApp")) {
                    i = 0;
                    break;
                }
                break;
        }
        String FH;
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                FH = FH(ast, "project");
                if (FH != null) {
                    this.J0 = new iw$h(ast.v5());
                    this.J0.j6 = FH;
                    return;
                }
                list.add(new iw$l(ast.v5()));
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                list.add(new iw$k(ast.v5()));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                FH = FH(ast, "project");
                if (FH != null) {
                    iw$h iw_h = new iw$h(ast.v5());
                    list.add(iw_h);
                    iw_h.j6 = FH;
                    return;
                }
                FH = FH(ast, "files");
                if (FH != null) {
                    iw$c iw_c = new iw$c(ast.v5());
                    list.add(iw_c);
                    iw_c.j6 = FH;
                    return;
                }
                Map DW = DW(ast, "fileTree");
                if (DW != null) {
                    iw$d iw_d = new iw$d(ast.v5());
                    list.add(iw_d);
                    iw_d.j6 = (String) DW.get("dir");
                    iw_d.DW = (String) DW.get("include");
                    return;
                }
                FH = v5(ast);
                if (FH != null) {
                    iw$g iw_g = new iw$g(ast.v5());
                    list.add(iw_g);
                    iw_g.Zo = FH;
                    String[] split = FH.split(":");
                    if (split.length > 0) {
                        iw_g.j6 = split[0];
                    }
                    if (split.length > 1) {
                        iw_g.DW = split[1];
                    }
                    if (split.length > 2) {
                        FH = split[2];
                        if (FH.indexOf("@") >= 0) {
                            iw_g.Hw = FH.substring(0, FH.indexOf("@"));
                            iw_g.v5 = FH.substring(FH.indexOf("@") + 1);
                            return;
                        }
                        iw_g.Hw = FH;
                        return;
                    }
                    return;
                }
                list.add(new iw$l(ast.v5()));
            default:
                list.add(new iw$l(ast.v5()));
        }
    }

    private void j6(AST ast, String str, int i) {
        String DW = DW(str, i);
        if (!this.v5.containsKey(DW)) {
            this.v5.put(DW, new iw$a(this));
        }
        String j6 = j6(str, i + 1);
        if (j6 != null) {
            j6(ast, j6, (iw$a) this.v5.get(DW));
        }
    }

    private void j6(AST ast, String str, iw$a iw_a) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1491430776:
                if (str.equals("minSdkVersion.apiLevel")) {
                    obj = 1;
                    break;
                }
                break;
            case -1312692432:
                if (str.equals("minSdkVersion")) {
                    obj = null;
                    break;
                }
                break;
            case -1045207741:
                if (str.equals("multiDexEnabled")) {
                    obj = 8;
                    break;
                }
                break;
            case -1011352949:
                if (str.equals("applicationId")) {
                    obj = 7;
                    break;
                }
                break;
            case 670017769:
                if (str.equals("targetSdkVersion.apiLevel")) {
                    obj = 3;
                    break;
                }
                break;
            case 688591589:
                if (str.equals("versionCode")) {
                    obj = 4;
                    break;
                }
                break;
            case 688906115:
                if (str.equals("versionName")) {
                    obj = 5;
                    break;
                }
                break;
            case 908759025:
                if (str.equals("packageName")) {
                    obj = 6;
                    break;
                }
                break;
            case 1346695087:
                if (str.equals("targetSdkVersion")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                iw_a.j6 = v5(ast);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                iw_a.DW = v5(ast);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                iw_a.Hw = v5(ast);
            case 5:
                iw_a.FH = v5(ast);
            case 6:
                iw_a.v5 = v5(ast);
            case 7:
                iw_a.v5 = v5(ast);
            case 8:
                iw_a.Zo = v5(ast);
            default:
        }
    }

    private void DW(AST ast, String str, int i) {
        String DW = DW(str, i);
        if (!this.J8.containsKey(DW)) {
            this.J8.put(DW, new iw$j(this));
        }
        String j6 = j6(str, i + 1);
        if (j6 != null) {
            j6(ast, j6, (iw$j) this.J8.get(DW));
        }
    }

    private void j6(AST ast, String str, iw$j iw_j) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -996366692:
                if (str.equals("storePassword")) {
                    obj = 3;
                    break;
                }
                break;
            case -45289958:
                if (str.equals("keyPassword")) {
                    obj = 2;
                    break;
                }
                break;
            case 473180977:
                if (str.equals("keyAlias")) {
                    obj = 1;
                    break;
                }
                break;
            case 1691552253:
                if (str.equals("storeFile")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                iw_j.j6 = FH(ast, "file");
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                iw_j.DW = v5(ast);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                iw_j.FH = v5(ast);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                iw_j.Hw = v5(ast);
            default:
        }
    }

    private void DW(AST ast, String str, List<iw$i> list) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1844260212:
                if (str.equals("maven.url")) {
                    obj = 3;
                    break;
                }
                break;
            case -1777904321:
                if (str.equals("jcenter")) {
                    obj = 1;
                    break;
                }
                break;
            case -1349030688:
                if (str.equals("flatDir.dirs")) {
                    obj = 2;
                    break;
                }
                break;
            case -138026646:
                if (str.equals("mavenCentral")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                list.add(new iw$m(ast.v5(), "http://repo.maven.apache.org/maven2"));
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                list.add(new iw$m(ast.v5(), "https://jcenter.bintray.com"));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                iw$e iw_e = new iw$e(ast.v5());
                iw_e.j6 = v5(ast);
                list.add(iw_e);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                list.add(new iw$m(ast.v5(), v5(ast)));
            default:
        }
    }

    private int j6(AST ast) {
        AST gn = gn(VH(VH(ast)));
        return gn == null ? ast.v5() : gn.v5();
    }

    private String DW(AST ast) {
        if (Zo(ast) == 28 && (Zo(VH(ast)) == 27 || Zo(VH(ast)) == 124)) {
            return FH(VH(VH(ast)));
        }
        return null;
    }

    private String FH(AST ast) {
        if (Zo(ast) != 90) {
            return u7(ast);
        }
        AST VH = VH(ast);
        return FH(VH) + "." + u7(gn(VH));
    }

    private List<AST> Hw(AST ast) {
        List<AST> arrayList = new ArrayList();
        for (AST VH = VH(gn(VH(VH(ast)))); VH != null; VH = gn(VH)) {
            if (Zo(VH) == 28) {
                arrayList.add(VH);
            }
        }
        return arrayList;
    }

    private Map<String, String> DW(AST ast, String str) {
        AST gn = gn(VH(VH(ast)));
        if (Zo(gn) != 33 || Zo(VH(gn)) != 27 || !str.equals(u7(VH(VH(gn))))) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (gn = VH(gn(VH(VH(gn)))); gn != null; gn = gn(gn)) {
            if (Zo(gn) == 54) {
                String u7 = u7(VH(gn));
                AST VH = VH(gn(VH(gn)));
                if (Zo(VH) == 57) {
                    hashMap.put(u7, u7(VH(VH(VH(VH)))));
                } else {
                    hashMap.put(u7, u7(VH));
                }
            }
        }
        return hashMap;
    }

    private String FH(AST ast, String str) {
        AST gn = gn(VH(VH(ast)));
        if (Zo(gn) == 33 && Zo(VH(gn)) == 27 && str.equals(u7(VH(VH(gn))))) {
            gn = VH(gn(VH(VH(gn))));
            if (Zo(gn) == 28) {
                return u7(VH(gn));
            }
        }
        return null;
    }

    private String v5(AST ast) {
        AST gn = gn(VH(VH(ast)));
        if (Zo(gn) == 88 || Zo(gn) == 199) {
            return u7(gn);
        }
        if (Zo(gn) != 33) {
            return null;
        }
        if (Zo(VH(gn)) == 28) {
            return u7(VH(VH(gn)));
        }
        return u7(VH(gn));
    }

    private static int Zo(AST ast) {
        if (ast == null) {
            return 0;
        }
        return ast.Hw();
    }

    private static AST VH(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.j6();
    }

    private static AST gn(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.DW();
    }

    private static String u7(AST ast) {
        if (ast == null) {
            return null;
        }
        return ast.FH();
    }

    private String j6(String str, int i) {
        String[] split = str.split("\\.");
        if (split.length <= i) {
            return null;
        }
        String str2 = "";
        while (i < split.length) {
            if (str2.length() > 0) {
                str2 = str2 + ".";
            }
            str2 = str2 + split[i];
            i++;
        }
        return str2;
    }

    private String DW(String str, int i) {
        String[] split = str.split("\\.");
        if (split.length > i) {
            return split[i];
        }
        return null;
    }

    private boolean j6(String str, String str2) {
        return str.startsWith(str2 + ".");
    }
}
