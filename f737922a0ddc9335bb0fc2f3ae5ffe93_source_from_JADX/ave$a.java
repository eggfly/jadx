import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.jgit.JGitText;

class ave$a extends avv {
    private final String DW;
    private final String FH;
    final /* synthetic */ ave j6;

    ave$a(ave ave, String str, String str2) {
        this.j6 = ave;
        this.DW = str;
        this.FH = str2;
    }

    private String gn(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        String str2 = this.FH;
        while (str.startsWith("../")) {
            str2 = str2.substring(0, str2.lastIndexOf(47));
            str = str.substring(3);
        }
        return new StringBuilder(String.valueOf(str2)).append("/").append(str).toString();
    }

    avn j6() {
        return new avn().DW("amazon-s3").j6(this.DW).FH("/" + this.FH);
    }

    Collection<avv> DW() {
        try {
            return VH("info/alternates");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    avv j6(String str) {
        return new ave$a(this.j6, this.DW, gn(str));
    }

    Collection<String> FH() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.j6.Zo.DW(this.j6.VH, gn("pack")));
        Collection<String> arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("pack-") && str.endsWith(".pack") && hashSet.contains(str.substring(0, str.length() - 5) + ".idx")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    avv$a DW(String str) {
        URLConnection j6 = this.j6.Zo.j6(this.j6.VH, gn(str));
        InputStream inputStream = j6.getInputStream();
        InputStream j62 = this.j6.Zo.j6(j6);
        int contentLength = j6.getContentLength();
        if (inputStream != j62) {
            contentLength = -1;
        }
        return new avv$a(j62, (long) contentLength);
    }

    void FH(String str) {
        this.j6.Zo.FH(this.j6.VH, gn(str));
    }

    OutputStream j6(String str, aob aob, String str2) {
        return this.j6.Zo.j6(this.j6.VH, gn(str), aob, str2);
    }

    void j6(String str, byte[] bArr) {
        this.j6.Zo.j6(this.j6.VH, gn(str), bArr);
    }

    Map<String, aoc> Hw() {
        TreeMap treeMap = new TreeMap();
        j6((Map) treeMap);
        j6(treeMap);
        j6(treeMap, "HEAD");
        return treeMap;
    }

    private void j6(TreeMap<String, aoc> treeMap) {
        try {
            for (String str : this.j6.Zo.DW(this.j6.VH, gn("../refs"))) {
                j6((TreeMap) treeMap, "refs/" + str);
            }
        } catch (Throwable e) {
            throw new amb(j6(), JGitText.j6().cannotListRefs, e);
        }
    }

    private aoc j6(TreeMap<String, aoc> treeMap, String str) {
        BufferedReader Zo;
        String substring;
        try {
            Zo = Zo("../" + str);
            String readLine = Zo.readLine();
            Zo.close();
            if (readLine == null) {
                throw new amb(j6(), MessageFormat.format(JGitText.j6().transportExceptionEmptyRef, new Object[]{str}));
            } else if (readLine.startsWith("ref: ")) {
                substring = readLine.substring("ref: ".length());
                aoc aoc = (aoc) treeMap.get(substring);
                if (aoc == null) {
                    aoc = j6((TreeMap) treeMap, substring);
                }
                if (aoc == null) {
                    aoc = new anu$c(aoc$a.NEW, substring, null);
                }
                r1 = new aom(str, aoc);
                treeMap.put(r1.j6(), r1);
                return r1;
            } else if (ans.j6(readLine)) {
                r1 = new anu$c(j6((aoc) treeMap.get(str)), str, ans.DW(readLine));
                treeMap.put(r1.j6(), r1);
                return r1;
            } else {
                throw new amb(j6(), MessageFormat.format(JGitText.j6().transportExceptionBadRef, new Object[]{str, readLine}));
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (Throwable e2) {
            throw new amb(j6(), MessageFormat.format(JGitText.j6().transportExceptionReadRef, new Object[]{substring}), e2);
        } catch (Throwable th) {
            Zo.close();
        }
    }

    private aoc$a j6(aoc aoc) {
        if (aoc == null || aoc.Zo() != aoc$a.PACKED) {
            return aoc$a.LOOSE;
        }
        return aoc$a.LOOSE_PACKED;
    }

    void v5() {
    }
}
