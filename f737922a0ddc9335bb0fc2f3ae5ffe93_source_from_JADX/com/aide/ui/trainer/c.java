package com.aide.ui.trainer;

import android.content.Context;
import android.content.res.Resources;
import com.aide.ui.R;
import com.aide.ui.R.drawable;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import og;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class c {
    private String DW;
    private List<a> j6;

    class 1 implements Comparator<a> {
        final /* synthetic */ c j6;

        1(c cVar) {
            this.j6 = cVar;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((a) obj, (a) obj2);
        }

        public int j6(a aVar, a aVar2) {
            return aVar.DW() - aVar2.DW();
        }
    }

    public static class c {
        protected int DW;
        private String FH;
        private int Hw;
        private b Zo;
        protected Element j6;
        private boolean v5;

        public c(String str, Document document, int i, b bVar) {
            boolean z = false;
            this.j6 = c.DW((Node) document, 0);
            this.FH = str;
            this.Hw = i;
            this.Zo = bVar;
            if (com.aide.ui.e.Hw() || Arrays.asList(bVar.FH).contains(com.aide.ui.e.j6)) {
                z = true;
            }
            this.v5 = z;
            if (com.aide.ui.e.v5()) {
                this.DW = 3;
            } else {
                this.DW = 2;
            }
        }

        public int DW() {
            return this.Zo.DW;
        }

        public int FH() {
            return this.Hw;
        }

        public int Hw() {
            return c.EQ(this.j6, "Lesson");
        }

        public i DW(int i) {
            return new i(this, Hw(i), i, i >= this.DW);
        }

        public int v5() {
            return c.EQ(this.j6, "Sample");
        }

        public j FH(int i) {
            return new j(this, c.DW(this.j6, "Sample", i));
        }

        public List<j> Zo() {
            List<j> arrayList = new ArrayList();
            for (int i = 0; i < v5(); i++) {
                arrayList.add(FH(i));
            }
            return arrayList;
        }

        protected Element Hw(int i) {
            return c.DW(this.j6, "Lesson", i);
        }

        public String[] VH() {
            int lastIndexOf = c.gn(this.j6, "title").lastIndexOf(" ");
            return new String[]{r0.substring(0, lastIndexOf), r0.substring(lastIndexOf + 1)};
        }

        public String gn() {
            return this.FH;
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).FH.equals(this.FH);
        }

        public int u7() {
            String Hw = c.tp(this.j6, "icon");
            if (Hw.length() > 0) {
                try {
                    return ((Integer) drawable.class.getDeclaredField(Hw).get(null)).intValue();
                } catch (Exception e) {
                }
            }
            return R.drawable.ic_launcher;
        }

        public i FH(String str) {
            int Hw = Hw();
            int i = 0;
            while (i < Hw && !DW(i).XL().equals(str)) {
                i++;
            }
            return DW(i);
        }

        public boolean Hw(String str) {
            return FH(str).u7();
        }

        public long tp() {
            long EQ = EQ();
            int Hw = Hw();
            long j = EQ;
            for (int i = 0; i < Hw; i++) {
                Date tp = DW(i).tp();
                if (tp != null) {
                    j = Math.max(j, tp.getTime());
                }
            }
            return j;
        }

        public long EQ() {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(c.tp(this.j6, "release_date")).getTime();
            } catch (ParseException e) {
                return 0;
            }
        }

        public String we() {
            return c.gn(this.j6, "explore_section");
        }

        public String J0() {
            return c.gn(this.j6, "code_section");
        }

        public String J8() {
            return c.gn(this.j6, "code_template");
        }

        public boolean Ws() {
            return this.v5;
        }
    }

    public static class a extends c {
        public /* synthetic */ i DW(int i) {
            return j6(i);
        }

        public /* synthetic */ i FH(String str) {
            return j6(str);
        }

        public a(String str, Document document, int i, b bVar) {
            super(str, document, i, bVar);
        }

        public g j6(int i) {
            return new g(this, Hw(i), i, i >= this.DW);
        }

        public g j6(String str) {
            return (g) super.FH(str);
        }

        private h QX() {
            return new h(c.we(this.j6, "Files"));
        }

        public InputStream DW(String str) {
            return c.DW("templates", gn(), str);
        }

        public String j6() {
            return c.gn(this.j6, "full_title");
        }
    }

    public static class b {
        public int DW;
        public String[] FH;
        public String j6;

        public b(String str, int i, String[] strArr) {
            this.j6 = str;
            this.DW = i;
            this.FH = strArr;
        }
    }

    public static class d {
        private g DW;
        private Element j6;

        public d(Element element, g gVar) {
            this.j6 = element;
            this.DW = gVar;
        }

        public String j6() {
            return this.DW.J8();
        }

        public String DW() {
            return c.tp(this.j6, "code_file");
        }

        public int FH() {
            if (c.we(this.j6, "CodeHint") != null) {
                return 0;
            }
            if (c.we(this.j6, "CodeHint_1") != null) {
                return 1;
            }
            if (c.we(this.j6, "CodeHint_2") != null) {
                return 2;
            }
            if (c.we(this.j6, "CodeHint_3") != null) {
                return 3;
            }
            if (c.we(this.j6, "CodeHint_4") != null) {
                return 4;
            }
            if (c.we(this.j6, "CodeHint_5") != null) {
                return 5;
            }
            if (c.we(this.j6, "CodeHint_6") != null) {
                return 6;
            }
            if (c.we(this.j6, "CodeHint_7") != null) {
                return 7;
            }
            if (c.we(this.j6, "CodeHint_8") != null) {
                return 8;
            }
            if (c.we(this.j6, "CodeHint_9") != null) {
                return 9;
            }
            if (c.we(this.j6, "CodeHint_10") != null) {
                return 10;
            }
            return -1;
        }

        public String Hw() {
            return c.gn(c.we(this.j6, "ExpectedOutput"), "fail") + " " + v5();
        }

        public String v5() {
            return c.gn(c.we(this.j6, "ExpectedOutput"), "hint");
        }

        public String Zo() {
            return c.DW(c.we(this.j6, "ExpectedOutput"));
        }

        public boolean VH() {
            return c.we(this.j6, "Run") != null;
        }

        public int gn() {
            return c.j6(c.we(this.j6, "Run"), "success_duration", 10);
        }

        public String u7() {
            return c.gn(c.we(this.j6, "Run"), "success");
        }

        public String tp() {
            return c.gn(c.we(this.j6, "Run"), "file");
        }

        public String EQ() {
            return c.gn(this.j6, "task");
        }

        public boolean we() {
            return c.u7(this.j6, "designer_task");
        }

        public String J0() {
            if (we()) {
                return c.gn(this.j6, "designer_task");
            }
            return EQ();
        }

        public int J8() {
            return c.j6(this.j6, "level", -1);
        }

        public f j6(int i) {
            return new f(c.DW(this.j6, "SourceCode", i));
        }

        public int Ws() {
            return c.EQ(this.j6, "SourceCode");
        }

        public int QX() {
            return c.EQ(this.j6, "ExpectedCode");
        }

        public e DW(int i) {
            return new e(c.DW(this.j6, "ExpectedCode", i));
        }

        public boolean XL() {
            return J8() == 1;
        }
    }

    public static class e {
        private Element j6;

        public e(Element element) {
            this.j6 = element;
        }

        public int j6() {
            return c.j6(this.j6, "end_line", Integer.MAX_VALUE);
        }

        public String DW() {
            return c.DW(this.j6);
        }

        public int FH() {
            return c.j6(this.j6, "start_line", 1);
        }

        public int Hw() {
            return c.j6(this.j6, "count", -1);
        }

        public String v5() {
            return c.gn(this.j6, "fail");
        }
    }

    public static class f {
        private Element j6;

        public f(Element element) {
            this.j6 = element;
        }

        public String j6() {
            return c.tp(this.j6, "code_file");
        }

        public String DW() {
            return c.DW(this.j6);
        }
    }

    public static class i {
        private int DW;
        private c FH;
        private boolean Hw;
        protected Element j6;

        public i(c cVar, Element element, int i, boolean z) {
            this.j6 = element;
            this.FH = cVar;
            this.DW = i;
            this.Hw = z;
        }

        public String toString() {
            return XL();
        }

        public boolean u7() {
            return this.j6 != null;
        }

        public Date tp() {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(c.tp(this.j6, "release_date"));
            } catch (ParseException e) {
                return null;
            }
        }

        public int Hw() {
            return c.j6(this.j6, "time", -1);
        }

        public String EQ() {
            return c.gn(this.j6, "section");
        }

        public String we() {
            return c.gn(this.j6, "description");
        }

        public String J0() {
            String we = we();
            if (Ws()) {
                we = we + " (en)";
            }
            if (c.tp(this.j6, "example").length() > 0) {
                return we + "<br/><br/><b>" + c.tp(this.j6, "example").replace("<", "&lt;").replace(">", "&gt;") + "</b>";
            }
            return we;
        }

        public String J8() {
            return c.VH(this.j6, "title");
        }

        public boolean Ws() {
            return "en".equals(J8()) && !"en".equals(c.Hw());
        }

        public String QX() {
            return c.gn(this.j6, "title");
        }

        public String XL() {
            if (c.u7(this.j6, "id")) {
                return c.tp(this.j6, "id");
            }
            return gn().VH()[0] + " " + QX();
        }

        public c gn() {
            return this.FH;
        }

        public int aM() {
            return this.DW;
        }

        public boolean j3() {
            return this.Hw;
        }
    }

    public static class g extends i {
        private a DW;

        public /* synthetic */ c gn() {
            return FH();
        }

        public g(a aVar, Element element, int i, boolean z) {
            super(aVar, element, i, z);
            this.DW = aVar;
        }

        public h j6() {
            Element v5 = c.we(this.j6, "Files");
            if (v5 != null) {
                return new h(v5);
            }
            return this.DW.QX();
        }

        public int DW() {
            if (this.j6 == null) {
                return 1;
            }
            return c.EQ(this.j6, "Exercise");
        }

        public d j6(int i) {
            return new d(c.DW(this.j6, "Exercise", i), this);
        }

        public a FH() {
            return this.DW;
        }

        public int Hw() {
            return DW() * 2;
        }

        public float v5() {
            float f = 0.0f;
            int DW = DW();
            for (int i = 0; i < DW; i++) {
                f += (float) j6(i).J8();
            }
            return f / ((float) DW);
        }

        public boolean Zo() {
            return aM() == 0;
        }

        public boolean VH() {
            return aM() == 1 && com.aide.ui.e.v5();
        }
    }

    public static class h {
        private Element j6;

        public h(Element element) {
            this.j6 = element;
        }

        public List<String> j6() {
            List<String> arrayList = new ArrayList();
            for (int i = 0; i < c.EQ(this.j6, "CodeFile"); i++) {
                arrayList.add(c.tp(c.DW(this.j6, "CodeFile", i), "name"));
            }
            return arrayList;
        }

        public String DW() {
            return c.tp(this.j6, "template2");
        }

        public String FH() {
            return c.tp(this.j6, "template");
        }

        public String Hw() {
            return c.tp(this.j6, "project_name");
        }

        public String v5() {
            return c.tp(this.j6, "package_name");
        }

        public String Zo() {
            return c.tp(this.j6, "open_path");
        }
    }

    public static class j {
        private c DW;
        private Element j6;

        public j(c cVar, Element element) {
            this.j6 = element;
            this.DW = cVar;
        }

        public c j6() {
            return this.DW;
        }

        public String DW() {
            return c.tp(this.j6, "id");
        }

        public String FH() {
            return c.gn(this.j6, "title");
        }

        public String Hw() {
            String FH = c.gn(this.j6, "description");
            if (Zo()) {
                return FH + " (en)";
            }
            return FH;
        }

        public String v5() {
            return c.VH(this.j6, "title");
        }

        public boolean Zo() {
            return "en".equals(v5()) && !"en".equals(c.Hw());
        }

        public String VH() {
            return c.tp(this.j6, "project_dir");
        }

        public List<String> gn() {
            List<String> arrayList = new ArrayList();
            for (int i = 0; i < c.EQ(this.j6, "CodeFile"); i++) {
                arrayList.add(c.tp(c.DW(this.j6, "CodeFile", i), "name"));
            }
            return arrayList;
        }

        public long u7() {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(c.tp(this.j6, "release_date")).getTime();
            } catch (ParseException e) {
                return 0;
            }
        }
    }

    public c() {
        Exception exception;
        int i = 0;
        this.j6 = new ArrayList();
        og[] j6 = com.aide.ui.e.j6();
        int length = j6.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            List<b> DW = j6[i2].DW();
            if (DW != null) {
                i3 = i;
                for (b bVar : DW) {
                    String str = bVar.j6;
                    try {
                        int i4 = i3 + 1;
                        try {
                            this.j6.add(j6(str, i3, bVar));
                            i = i4;
                        } catch (Exception e) {
                            exception = e;
                            i = i4;
                            this.DW = exception.toString();
                            i3 = i;
                        }
                    } catch (Exception e2) {
                        Exception exception2 = e2;
                        i = i3;
                        exception = exception2;
                        this.DW = exception.toString();
                        i3 = i;
                    }
                    i3 = i;
                }
            } else {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        Collections.sort(this.j6, new 1(this));
    }

    public String j6() {
        return this.DW;
    }

    public String j6(String str) {
        if (v5(str) != null) {
            return str;
        }
        str = DW(DW());
        if (str.length() > 0) {
            return str;
        }
        return DW(((a) this.j6.get(0)).gn());
    }

    public String DW() {
        for (a aVar : this.j6) {
            if (aVar.Ws()) {
                return aVar.gn();
            }
        }
        return "";
    }

    public String DW(String str) {
        try {
            return Hw(str).j6(0).XL();
        } catch (Exception e) {
            return "";
        }
    }

    public List<c> FH() {
        return this.j6;
    }

    public a FH(String str) {
        return v5(str);
    }

    private a v5(String str) {
        for (a aVar : this.j6) {
            if (aVar.Hw(str)) {
                return aVar;
            }
        }
        return null;
    }

    public a Hw(String str) {
        for (a aVar : this.j6) {
            if (aVar.gn().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private a j6(String str, int i, b bVar) {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        InputStream DW = DW("trainer", str, "en.xml");
        Document parse = newDocumentBuilder.parse(DW);
        DW.close();
        return new a(str, parse, i, bVar);
    }

    private static InputStream DW(String str, String str2, String str3) {
        return com.aide.ui.e.gn().getAssets().open(str + "/" + str2 + "_" + str3);
    }

    private static String VH(Element element, String str) {
        if ("en".equals(Hw())) {
            return "en";
        }
        String tp = tp(element, str);
        if (tp.startsWith("@string/")) {
            try {
                tp = tp.split(" ")[0].substring("@string/".length()) + "_language";
                Context gn = com.aide.ui.e.gn();
                Resources resources = gn.getResources();
                tp = resources.getString(resources.getIdentifier(tp, "string", gn.getPackageName()));
                if (Hw().equals(tp)) {
                    return tp;
                }
            } catch (Exception e) {
            }
        }
        return "en";
    }

    public static String Hw() {
        if ("en".equals(Locale.getDefault().getLanguage())) {
            return "en";
        }
        try {
            Context gn = com.aide.ui.e.gn();
            Resources resources = gn.getResources();
            return resources.getString(resources.getIdentifier("trainer_language", "string", gn.getPackageName()));
        } catch (Exception e) {
            return "en";
        }
    }

    private static String gn(Element element, String str) {
        String string;
        String tp = tp(element, str);
        if (tp.startsWith("@string/")) {
            try {
                String[] split = tp.split(" ");
                String[] split2 = tp.substring(tp.indexOf(32) + 1).split(" ");
                String substring = split[0].substring("@string/".length());
                Context gn = com.aide.ui.e.gn();
                Resources resources = gn.getResources();
                string = resources.getString(resources.getIdentifier(substring, "string", gn.getPackageName()), (Object[]) split2);
            } catch (Exception e) {
                string = tp;
            }
        } else {
            string = tp;
        }
        return string.replace("<", "&lt;").replace(">", "&gt;").replace("'_", "<i>").replace("_'", "</i>").replace("!_", "<b>").replace("_!", "</b>").replace("__", "$UNDERSCORE$").replace("_", " ").replace("$UNDERSCORE$", "_").replace("\\n", "\n");
    }

    public static int j6(Element element, String str, int i) {
        try {
            i = Integer.parseInt(tp(element, str));
        } catch (Exception e) {
        }
        return i;
    }

    private static boolean u7(Element element, String str) {
        if (element == null) {
            return false;
        }
        return element.hasAttribute(str);
    }

    private static String tp(Element element, String str) {
        if (element == null) {
            return "";
        }
        return element.getAttribute(str);
    }

    private static String DW(Element element) {
        if (element == null) {
            return null;
        }
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof CharacterData) {
                return ((CharacterData) item).getTextContent().trim();
            }
        }
        return null;
    }

    private static int EQ(Element element, String str) {
        int i = 0;
        if (element == null) {
            return 0;
        }
        NodeList childNodes = element.getChildNodes();
        int i2 = 0;
        while (i < childNodes.getLength()) {
            Node item = childNodes.item(i);
            if ((item instanceof Element) && (str == null || str.equals(item.getNodeName()))) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static Element DW(Node node, int i) {
        return DW(node, null, i);
    }

    private static Element we(Element element, String str) {
        if (element == null) {
            return null;
        }
        return (Element) element.getElementsByTagName(str).item(0);
    }

    private static Element DW(Node node, String str, int i) {
        if (node == null) {
            return null;
        }
        NodeList childNodes = node.getChildNodes();
        int i2 = 0;
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item = childNodes.item(i3);
            if ((item instanceof Element) && (str == null || str.equals(item.getNodeName()))) {
                if (i2 == i) {
                    return (Element) item;
                }
                i2++;
            }
        }
        return null;
    }
}
