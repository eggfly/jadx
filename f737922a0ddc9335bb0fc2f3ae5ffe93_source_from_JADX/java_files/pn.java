import com.aide.analytics.a;
import com.aide.common.w;
import com.aide.ui.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class pn {
    public List<pn$a> j6(String str) {
        List<pn$a> arrayList = new ArrayList();
        for (og j6 : e.j6()) {
            pn$a[] j62 = j6.j6();
            if (j62 != null) {
                for (pn$a pn_a : j62) {
                    if (str.equals(pn_a.Zo.EQ)) {
                        arrayList.add(pn_a);
                    }
                }
            }
        }
        Collections.sort(arrayList, new pn$1(this));
        return arrayList;
    }

    public List<List<pn$a>> j6() {
        ArrayList arrayList = new ArrayList();
        List<pn$a> arrayList2 = new ArrayList();
        for (og j6 : e.j6()) {
            pn$a[] j62 = j6.j6();
            if (j62 != null) {
                for (Object add : j62) {
                    arrayList2.add(add);
                }
            }
        }
        Collections.sort(arrayList2, new pn$2(this));
        for (pn$a pn_a : arrayList2) {
            if (pn_a.Zo.u7) {
                arrayList.add(pn_a);
            }
        }
        for (pn$a pn_a2 : arrayList2) {
            if (!pn_a2.Zo.u7) {
                arrayList.add(pn_a2);
            }
        }
        List<List<pn$a>> arrayList3 = new ArrayList();
        String str = "";
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            pn$a pn_a3 = (pn$a) it.next();
            if (!str.equals(pn_a3.Zo.Hw)) {
                arrayList3.add(new ArrayList());
                str = pn_a3.Zo.Hw;
            }
            ((List) arrayList3.get(arrayList3.size() - 1)).add(pn_a3);
        }
        return arrayList3;
    }

    public String DW(String str) {
        return "com.mycompany." + str.toLowerCase();
    }

    public String j6(String str, String str2) {
        if (DW(str, str2)) {
            return str2;
        }
        int i = 2;
        while (!DW(str, str2 + i)) {
            i++;
        }
        return str2 + i;
    }

    public boolean DW(String str, String str2) {
        if (str2.length() == 0) {
            return false;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!Character.isJavaIdentifierPart(str2.charAt(i))) {
                return false;
            }
        }
        if (new File(FH(str, str2)).exists()) {
            return false;
        }
        return true;
    }

    public String FH(String str, String str2) {
        return str2.length() == 0 ? str : str + File.separator + str2;
    }

    public boolean Hw(String str, String str2) {
        if (str2.startsWith(".") || !str2.contains(".")) {
            return false;
        }
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (charAt == '.') {
                if (i == str2.length() - 1 || str2.charAt(i + 1) == '.') {
                    return false;
                }
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
            i++;
        }
        if (str2.length() > 0) {
            return true;
        }
        return false;
    }

    public List<String> j6(String str, String str2, String str3, String str4, pn$a pn_a) {
        a.j6("Create project " + pn_a.Zo.gn, Collections.singletonMap("template", pn_a.j6));
        String replace = str3.replace('.', '_');
        List<String> arrayList = new ArrayList();
        try {
            String FH = FH(str, str2);
            new File(FH).mkdirs();
            InputStream open = e.gn().getAssets().open("templates/" + pn_a.DW);
            Map j6 = j6(open, true, FH, str2, str3, replace, str4, pn_a.FH);
            open.close();
            for (Object obj : pn_a.FH) {
                if (j6.containsKey(obj)) {
                    arrayList.add(j6.get(obj));
                }
            }
            e.nw().v5(FH);
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
        }
        return arrayList;
    }

    private Map<String, String> j6(InputStream inputStream, boolean z, String str, String str2, String str3, String str4, String str5, String[] strArr) {
        Map hashMap = new HashMap();
        InputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return hashMap;
            }
            String replace = nextEntry.getName().replace("$package_name$", str3.replace('.', File.separatorChar)).replace("$project_name$", str2).replace("$flavor_name$", str5);
            String str6 = str + File.separator + replace;
            com.aide.common.e.j6("Extract " + replace + " to " + str6);
            try {
                if (nextEntry.isDirectory()) {
                    new File(str6).mkdirs();
                } else {
                    for (String str7 : strArr) {
                        if (str6.endsWith("/" + str7)) {
                            hashMap.put(str7, str6);
                        }
                    }
                    if (z || !new File(str6).isFile()) {
                        new File(str6).getParentFile().mkdirs();
                        String toLowerCase = str6.toLowerCase(Locale.ENGLISH);
                        if (toLowerCase.endsWith("build.gradle") || toLowerCase.endsWith(".java") || toLowerCase.endsWith(".xml") || toLowerCase.endsWith(".c") || toLowerCase.endsWith(".cpp") || toLowerCase.endsWith(".cc") || toLowerCase.endsWith(".h") || toLowerCase.endsWith(".hpp") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm") || toLowerCase.endsWith(".css") || toLowerCase.endsWith(".js")) {
                            toLowerCase = w.j6(new BufferedReader(new InputStreamReader(zipInputStream))).replace("\r\n", "\n").replace("$project_name$", str2).replace("$package_name$", str3).replace("$package_name_jni$", str4);
                            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str6));
                            outputStreamWriter.write(toLowerCase);
                            outputStreamWriter.close();
                        } else {
                            OutputStream fileOutputStream = new FileOutputStream(str6);
                            w.j6(zipInputStream, fileOutputStream, false);
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (Throwable e) {
                com.aide.common.e.j6(e);
            }
        }
    }

    public boolean FH(String str) {
        return (str == null || qh.tp(str) || e.a8().J8(str)) ? false : true;
    }

    public Map<String, String> j6(InputStream inputStream, String str, String str2, String str3, List<String> list) {
        return j6(inputStream, false, str, str2, str3, str3, "", (String[]) list.toArray(new String[list.size()]));
    }
}
