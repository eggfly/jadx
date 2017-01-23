import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.JGitText;

public class ani {
    private static final String[] j6;
    private static final String v5;
    private final amk DW;
    private final AtomicReference<ani$c> FH;
    private final ani Hw;

    static {
        j6 = new String[0];
        v5 = new String();
    }

    public ani() {
        this(null);
    }

    public ani(ani ani) {
        this.DW = new amk();
        this.Hw = ani;
        this.FH = new AtomicReference(VH());
    }

    private static String DW(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        Object obj = null;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\b':
                    stringBuilder.append("\\b");
                    break;
                case '\t':
                    stringBuilder.append("\\t");
                    break;
                case '\n':
                    if (obj != null) {
                        stringBuilder.append('\"');
                        obj = null;
                    }
                    stringBuilder.append("\\n\\\n");
                    i = stringBuilder.length();
                    break;
                case ' ':
                    if (obj == null && stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
                        stringBuilder.insert(i, '\"');
                        obj = 1;
                    }
                    stringBuilder.append(' ');
                    break;
                case '\"':
                    stringBuilder.append("\\\"");
                    break;
                case '#':
                case ';':
                    if (obj == null) {
                        stringBuilder.insert(i, '\"');
                        obj = 1;
                    }
                    stringBuilder.append(charAt);
                    break;
                case '\\':
                    stringBuilder.append("\\\\");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        if (obj != null) {
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public int j6(String str, String str2, int i) {
        return j6(str, null, str2, i);
    }

    public int j6(String str, String str2, String str3, int i) {
        long j6 = j6(str, str2, str3, (long) i);
        if (-2147483648L <= j6 && j6 <= 2147483647L) {
            return (int) j6;
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().integerValueOutOfRange, new Object[]{str, str3}));
    }

    public long j6(String str, String str2, long j) {
        return j6(str, null, str2, j);
    }

    public long j6(String str, String str2, String str3, long j) {
        String j6 = j6(str, str2, str3);
        if (j6 == null) {
            return j;
        }
        String trim = j6.trim();
        if (trim.length() == 0) {
            return j;
        }
        long j2;
        switch (axh.j6(trim.charAt(trim.length() - 1))) {
            case 'g':
                j2 = 1073741824;
                break;
            case 'k':
                j2 = 1024;
                break;
            case 'm':
                j2 = 1048576;
                break;
            default:
                j2 = 1;
                break;
        }
        if (j2 > 1) {
            trim = trim.substring(0, trim.length() - 1).trim();
        }
        if (trim.length() == 0) {
            return j;
        }
        try {
            return j2 * Long.parseLong(trim);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidIntegerValue, new Object[]{str, str3, j6}));
        }
    }

    public boolean j6(String str, String str2, boolean z) {
        return j6(str, null, str2, z);
    }

    public boolean j6(String str, String str2, String str3, boolean z) {
        String Hw = Hw(str, str2, str3);
        if (Hw == null) {
            return z;
        }
        if (v5 == Hw) {
            return true;
        }
        try {
            return axh.DW(Hw);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidBooleanValue, new Object[]{str, str3, Hw}));
        }
    }

    public <T extends Enum<?>> T j6(String str, String str2, String str3, T t) {
        return j6((Enum[]) j6((Object) t), str, str2, str3, (Enum) t);
    }

    private static <T> T[] j6(T t) {
        try {
            return (Object[]) t.getClass().getMethod("values", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable e) {
            String name = t.getClass().getName();
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().enumValuesNotAvailable, new Object[]{name}), e);
        }
    }

    public <T extends Enum<?>> T j6(T[] tArr, String str, String str2, String str3, T t) {
        String j6 = j6(str, str2, str3);
        if (j6 == null) {
            return t;
        }
        String replace = j6.replace(' ', '_');
        T t2 = null;
        int length = tArr.length;
        int i = 0;
        T t3 = null;
        while (i < length) {
            T t4 = tArr[i];
            if (axh.j6(t4.name(), replace)) {
                return t4;
            }
            if (!axh.j6(t4.name(), "TRUE")) {
                if (axh.j6(t4.name(), "FALSE")) {
                    t3 = t4;
                    t4 = t2;
                } else {
                    t4 = t2;
                }
            }
            i++;
            t2 = t4;
        }
        if (!(t2 == null || t3 == null)) {
            try {
                if (!axh.DW(replace)) {
                    t2 = t3;
                }
                return t2;
            } catch (IllegalArgumentException e) {
            }
        }
        if (str2 != null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().enumValueNotSupported3, new Object[]{str, str3, j6}));
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().enumValueNotSupported2, new Object[]{str, str3, j6}));
    }

    public String j6(String str, String str2, String str3) {
        return Hw(str, str2, str3);
    }

    public String[] DW(String str, String str2, String str3) {
        String[] DW;
        if (this.Hw != null) {
            DW = this.Hw.DW(str, str2, str3);
        } else {
            DW = j6;
        }
        List<String> v5 = v5(str, str2, str3);
        if (v5 == null) {
            return DW;
        }
        Object obj = new String[(DW.length + v5.size())];
        int length = DW.length;
        System.arraycopy(DW, 0, obj, 0, length);
        for (String str4 : v5) {
            int i = length + 1;
            obj[length] = str4;
            length = i;
        }
        return obj;
    }

    public <T> T j6(ani$b<T> ani_b_T) {
        ani$c v5 = v5();
        T t = v5.DW.get(ani_b_T);
        if (t != null) {
            return t;
        }
        t = ani_b_T.DW(this);
        v5.DW.put(ani_b_T, t);
        return t;
    }

    public amj j6(amg amg) {
        return this.DW.j6(amg);
    }

    protected boolean j6() {
        return true;
    }

    protected void DW() {
        this.DW.j6(new amf());
    }

    private String Hw(String str, String str2, String str3) {
        List v5 = v5(str, str2, str3);
        if (v5 != null) {
            return (String) v5.get(0);
        }
        if (this.Hw != null) {
            return this.Hw.Hw(str, str2, str3);
        }
        return null;
    }

    private List<String> v5(String str, String str2, String str3) {
        List<String> list = null;
        for (ani$a ani_a : ((ani$c) this.FH.get()).j6) {
            if (ani_a.j6(str, str2, str3)) {
                list = j6((List) list, ani_a.v5);
            }
        }
        return list;
    }

    private static List<String> j6(List<String> list, String str) {
        if (list == null) {
            return Collections.singletonList(str);
        }
        if (list.size() == 1) {
            List<String> arrayList = new ArrayList(2);
            arrayList.add((String) list.get(0));
            arrayList.add(str);
            return arrayList;
        }
        list.add(str);
        return list;
    }

    private ani$c v5() {
        ani$c ani_c;
        ani$c ani_c2;
        do {
            ani_c2 = (ani$c) this.FH.get();
            ani$c Zo = Zo();
            if (ani_c2.FH == Zo) {
                return ani_c2;
            }
            ani_c = new ani$c(ani_c2.j6, Zo);
        } while (!this.FH.compareAndSet(ani_c2, ani_c));
        return ani_c;
    }

    private ani$c Zo() {
        return this.Hw != null ? this.Hw.v5() : null;
    }

    public void DW(String str, String str2, String str3, int i) {
        DW(str, str2, str3, (long) i);
    }

    public void DW(String str, String str2, String str3, long j) {
        String stringBuilder;
        if (j >= 1073741824 && j % 1073741824 == 0) {
            stringBuilder = new StringBuilder(String.valueOf(String.valueOf(j / 1073741824))).append(" g").toString();
        } else if (j >= 1048576 && j % 1048576 == 0) {
            stringBuilder = new StringBuilder(String.valueOf(String.valueOf(j / 1048576))).append(" m").toString();
        } else if (j < 1024 || j % 1024 != 0) {
            stringBuilder = String.valueOf(j);
        } else {
            stringBuilder = new StringBuilder(String.valueOf(String.valueOf(j / 1024))).append(" k").toString();
        }
        j6(str, str2, str3, stringBuilder);
    }

    public void DW(String str, String str2, String str3, boolean z) {
        j6(str, str2, str3, z ? "true" : "false");
    }

    public void j6(String str, String str2, String str3, String str4) {
        j6(str, str2, str3, Collections.singletonList(str4));
    }

    public void FH(String str, String str2, String str3) {
        j6(str, str2, str3, Collections.emptyList());
    }

    public void j6(String str, String str2) {
        ani$c ani_c;
        do {
            ani_c = (ani$c) this.FH.get();
        } while (!this.FH.compareAndSet(ani_c, j6(ani_c, str, str2)));
    }

    private ani$c j6(ani$c ani_c, String str, String str2) {
        List arrayList = new ArrayList(ani_c.j6.size());
        Object obj = null;
        for (ani$a ani_a : ani_c.j6) {
            if (ani_a.j6(str, str2)) {
                obj = 1;
            } else if (obj == null || ani_a.DW != null || ani_a.FH != null) {
                arrayList.add(ani_a);
            }
        }
        return j6(arrayList);
    }

    public void j6(String str, String str2, String str3, List<String> list) {
        ani$c ani_c;
        do {
            ani_c = (ani$c) this.FH.get();
        } while (!this.FH.compareAndSet(ani_c, j6(ani_c, str, str2, str3, (List) list)));
        if (j6()) {
            DW();
        }
    }

    private ani$c j6(ani$c ani_c, String str, String str2, String str3, List<String> list) {
        int i;
        List j6 = j6(ani_c, (List) list);
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (i3 < j6.size() && i2 < list.size()) {
            ani$a ani_a = (ani$a) j6.get(i3);
            if (ani_a.j6(str, str2, str3)) {
                int i5 = i2 + 1;
                j6.set(i3, ani_a.j6((String) list.get(i2)));
                i = i3 + 1;
                i4 = i5;
            } else {
                i = i4;
                i4 = i2;
            }
            i3++;
            i2 = i4;
            i4 = i;
        }
        if (i2 == list.size() && i3 < j6.size()) {
            while (i3 < j6.size()) {
                i5 = i3 + 1;
                if (((ani$a) j6.get(i3)).j6(str, str2, str3)) {
                    i3 = i5 - 1;
                    j6.remove(i3);
                } else {
                    i3 = i5;
                }
            }
        }
        if (i2 < list.size() && r3 == j6.size()) {
            if (i4 < 0) {
                i = j6(j6, str, str2);
            } else {
                i = i4;
            }
            if (i < 0) {
                ani_a = new ani$a();
                ani_a.DW = str;
                ani_a.FH = str2;
                j6.add(ani_a);
                i4 = j6.size();
            } else {
                i4 = i;
            }
            while (i2 < list.size()) {
                ani$a ani_a2 = new ani$a();
                ani_a2.DW = str;
                ani_a2.FH = str2;
                ani_a2.Hw = str3;
                i3 = i2 + 1;
                ani_a2.v5 = (String) list.get(i2);
                i = i4 + 1;
                j6.add(i4, ani_a2);
                i4 = i;
                i2 = i3;
            }
        }
        return j6(j6);
    }

    private static List<ani$a> j6(ani$c ani_c, List<String> list) {
        List arrayList = new ArrayList((ani_c.j6.size() + list.size()) + 1);
        arrayList.addAll(ani_c.j6);
        return arrayList;
    }

    private static int j6(List<ani$a> list, String str, String str2) {
        for (int i = 0; i < list.size(); i++) {
            if (((ani$a) list.get(i)).j6(str, str2, null)) {
                i++;
                while (i < list.size()) {
                    ani$a ani_a = (ani$a) list.get(i);
                    if (!ani_a.j6(str, str2, ani_a.Hw)) {
                        return i;
                    }
                    i++;
                }
                return i;
            }
        }
        return -1;
    }

    public String FH() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ani$a ani_a : ((ani$c) this.FH.get()).j6) {
            if (ani_a.j6 != null) {
                stringBuilder.append(ani_a.j6);
            }
            if (ani_a.DW != null && ani_a.Hw == null) {
                stringBuilder.append('[');
                stringBuilder.append(ani_a.DW);
                if (ani_a.FH != null) {
                    stringBuilder.append(' ');
                    String DW = DW(ani_a.FH);
                    Object obj = (DW.startsWith("\"") && DW.endsWith("\"")) ? 1 : null;
                    if (obj == null) {
                        stringBuilder.append('\"');
                    }
                    stringBuilder.append(DW);
                    if (obj == null) {
                        stringBuilder.append('\"');
                    }
                }
                stringBuilder.append(']');
            } else if (!(ani_a.DW == null || ani_a.Hw == null)) {
                if (ani_a.j6 == null || "".equals(ani_a.j6)) {
                    stringBuilder.append('\t');
                }
                stringBuilder.append(ani_a.Hw);
                if (v5 != ani_a.v5) {
                    stringBuilder.append(" =");
                    if (ani_a.v5 != null) {
                        stringBuilder.append(' ');
                        stringBuilder.append(DW(ani_a.v5));
                    }
                }
                if (ani_a.Zo != null) {
                    stringBuilder.append(' ');
                }
            }
            if (ani_a.Zo != null) {
                stringBuilder.append(ani_a.Zo);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(java.lang.String r13) {
        /*
        r12 = this;
        r10 = 34;
        r9 = 0;
        r8 = -1;
        r2 = 0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = new ani$d;
        r5.<init>(r13);
        r0 = new ani$a;
        r0.<init>();
        r1 = r2;
    L_0x0015:
        r3 = r5.j6();
        if (r8 != r3) goto L_0x0025;
    L_0x001b:
        r0 = r12.FH;
        r1 = r12.j6(r4);
        r0.set(r1);
        return;
    L_0x0025:
        r3 = (char) r3;
        r6 = 10;
        if (r6 != r3) goto L_0x003a;
    L_0x002a:
        r4.add(r0);
        r3 = r0.DW;
        if (r3 == 0) goto L_0x0106;
    L_0x0031:
        r1 = new ani$a;
        r1.<init>();
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x0015;
    L_0x003a:
        r6 = r0.Zo;
        if (r6 == 0) goto L_0x0054;
    L_0x003e:
        r6 = r0.Zo;
        r7 = new java.lang.StringBuilder;
        r6 = java.lang.String.valueOf(r6);
        r7.<init>(r6);
        r3 = r7.append(r3);
        r3 = r3.toString();
        r0.Zo = r3;
        goto L_0x0015;
    L_0x0054:
        r6 = 59;
        if (r6 == r3) goto L_0x005c;
    L_0x0058:
        r6 = 35;
        if (r6 != r3) goto L_0x0063;
    L_0x005c:
        r3 = java.lang.String.valueOf(r3);
        r0.Zo = r3;
        goto L_0x0015;
    L_0x0063:
        r6 = r0.DW;
        if (r6 != 0) goto L_0x008c;
    L_0x0067:
        r6 = java.lang.Character.isWhitespace(r3);
        if (r6 == 0) goto L_0x008c;
    L_0x006d:
        r6 = r0.j6;
        if (r6 != 0) goto L_0x0076;
    L_0x0071:
        r6 = "";
        r0.j6 = r6;
    L_0x0076:
        r6 = r0.j6;
        r7 = new java.lang.StringBuilder;
        r6 = java.lang.String.valueOf(r6);
        r7.<init>(r6);
        r3 = r7.append(r3);
        r3 = r3.toString();
        r0.j6 = r3;
        goto L_0x0015;
    L_0x008c:
        r6 = 91;
        if (r6 != r3) goto L_0x00be;
    L_0x0090:
        r3 = j6(r5);
        r0.DW = r3;
        r3 = r5.j6();
        if (r10 != r3) goto L_0x00a7;
    L_0x009c:
        r3 = 1;
        r3 = j6(r5, r3, r10);
        r0.FH = r3;
        r3 = r5.j6();
    L_0x00a7:
        r6 = 93;
        if (r6 == r3) goto L_0x00b7;
    L_0x00ab:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.badGroupHeader;
        r0.<init>(r1);
        throw r0;
    L_0x00b7:
        r3 = "";
        r0.Zo = r3;
        goto L_0x0015;
    L_0x00be:
        if (r1 == 0) goto L_0x00fa;
    L_0x00c0:
        r3 = r1.DW;
        r0.DW = r3;
        r3 = r1.FH;
        r0.FH = r3;
        r5.DW();
        r3 = DW(r5);
        r0.Hw = r3;
        r3 = r0.Hw;
        r6 = "\n";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x00f2;
    L_0x00dc:
        r3 = r0.Hw;
        r6 = r0.Hw;
        r6 = r6.length();
        r6 = r6 + -1;
        r3 = r3.substring(r9, r6);
        r0.Hw = r3;
        r3 = v5;
        r0.v5 = r3;
        goto L_0x0015;
    L_0x00f2:
        r3 = j6(r5, r9, r8);
        r0.v5 = r3;
        goto L_0x0015;
    L_0x00fa:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.invalidLineInConfigFile;
        r0.<init>(r1);
        throw r0;
    L_0x0106:
        r0 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: ani.j6(java.lang.String):void");
    }

    private ani$c VH() {
        return new ani$c(Collections.emptyList(), Zo());
    }

    private ani$c j6(List<ani$a> list) {
        return new ani$c(Collections.unmodifiableList(list), Zo());
    }

    protected void Hw() {
        this.FH.set(VH());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String j6(ani$d r7) {
        /*
        r6 = 32;
        r5 = 9;
        r3 = 1;
        r4 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x000b:
        r1 = r7.j6();
        if (r1 >= 0) goto L_0x001d;
    L_0x0011:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unexpectedEndOfConfigFile;
        r0.<init>(r1);
        throw r0;
    L_0x001d:
        r2 = 93;
        if (r2 != r1) goto L_0x0029;
    L_0x0021:
        r7.DW();
    L_0x0024:
        r0 = r0.toString();
        return r0;
    L_0x0029:
        if (r6 == r1) goto L_0x002d;
    L_0x002b:
        if (r5 != r1) goto L_0x005f;
    L_0x002d:
        r1 = r7.j6();
        if (r1 >= 0) goto L_0x003f;
    L_0x0033:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unexpectedEndOfConfigFile;
        r0.<init>(r1);
        throw r0;
    L_0x003f:
        r2 = 34;
        if (r2 != r1) goto L_0x0047;
    L_0x0043:
        r7.DW();
        goto L_0x0024;
    L_0x0047:
        if (r6 == r1) goto L_0x002d;
    L_0x0049:
        if (r5 == r1) goto L_0x002d;
    L_0x004b:
        r1 = new akz;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.badSectionEntry;
        r3 = new java.lang.Object[r3];
        r3[r4] = r0;
        r0 = java.text.MessageFormat.format(r2, r3);
        r1.<init>(r0);
        throw r1;
    L_0x005f:
        r2 = (char) r1;
        r2 = java.lang.Character.isLetterOrDigit(r2);
        if (r2 != 0) goto L_0x006e;
    L_0x0066:
        r2 = 46;
        if (r2 == r1) goto L_0x006e;
    L_0x006a:
        r2 = 45;
        if (r2 != r1) goto L_0x0073;
    L_0x006e:
        r1 = (char) r1;
        r0.append(r1);
        goto L_0x000b;
    L_0x0073:
        r1 = new akz;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.badSectionEntry;
        r3 = new java.lang.Object[r3];
        r3[r4] = r0;
        r0 = java.text.MessageFormat.format(r2, r3);
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ani.j6(ani$d):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String DW(ani$d r7) {
        /*
        r6 = 61;
        r5 = 32;
        r4 = 10;
        r3 = 9;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x000d:
        r1 = r7.j6();
        if (r1 >= 0) goto L_0x001f;
    L_0x0013:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unexpectedEndOfConfigFile;
        r0.<init>(r1);
        throw r0;
    L_0x001f:
        if (r6 != r1) goto L_0x0026;
    L_0x0021:
        r0 = r0.toString();
        return r0;
    L_0x0026:
        if (r5 == r1) goto L_0x002a;
    L_0x0028:
        if (r3 != r1) goto L_0x005c;
    L_0x002a:
        r1 = r7.j6();
        if (r1 >= 0) goto L_0x003c;
    L_0x0030:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unexpectedEndOfConfigFile;
        r0.<init>(r1);
        throw r0;
    L_0x003c:
        if (r6 == r1) goto L_0x0021;
    L_0x003e:
        r2 = 59;
        if (r2 == r1) goto L_0x0048;
    L_0x0042:
        r2 = 35;
        if (r2 == r1) goto L_0x0048;
    L_0x0046:
        if (r4 != r1) goto L_0x004c;
    L_0x0048:
        r7.DW();
        goto L_0x0021;
    L_0x004c:
        if (r5 == r1) goto L_0x002a;
    L_0x004e:
        if (r3 == r1) goto L_0x002a;
    L_0x0050:
        r0 = new akz;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.badEntryDelimiter;
        r0.<init>(r1);
        throw r0;
    L_0x005c:
        r2 = (char) r1;
        r2 = java.lang.Character.isLetterOrDigit(r2);
        if (r2 != 0) goto L_0x0067;
    L_0x0063:
        r2 = 45;
        if (r1 != r2) goto L_0x006c;
    L_0x0067:
        r1 = (char) r1;
        r0.append(r1);
        goto L_0x000d;
    L_0x006c:
        if (r4 != r1) goto L_0x0076;
    L_0x006e:
        r7.DW();
        r1 = (char) r1;
        r0.append(r1);
        goto L_0x0021;
    L_0x0076:
        r1 = new akz;
        r2 = org.eclipse.jgit.JGitText.j6();
        r2 = r2.badEntryName;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r0;
        r0 = java.text.MessageFormat.format(r2, r3);
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ani.DW(ani$d):java.lang.String");
    }

    private static String j6(ani$d ani_d, boolean z, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (true) {
            int j6 = ani_d.j6();
            if (j6 < 0) {
                if (stringBuilder.length() == 0) {
                    throw new akz(JGitText.j6().unexpectedEndOfConfigFile);
                }
            } else if (10 == j6) {
                if (z) {
                    throw new akz(JGitText.j6().newlineInQuotesNotAllowed);
                }
                ani_d.DW();
            } else if (i != j6) {
                if (!z) {
                    if (Character.isWhitespace((char) j6)) {
                        i2 = 1;
                    } else if (59 == j6 || 35 == j6) {
                        ani_d.DW();
                    }
                }
                if (i2 != 0) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(' ');
                    }
                    i2 = 0;
                }
                if (92 == j6) {
                    switch (ani_d.j6()) {
                        case -1:
                            throw new akz(JGitText.j6().endOfFileInEscape);
                        case 10:
                            break;
                        case 34:
                            stringBuilder.append('\"');
                            break;
                        case 92:
                            stringBuilder.append('\\');
                            break;
                        case 98:
                            stringBuilder.append('\b');
                            break;
                        case 110:
                            stringBuilder.append('\n');
                            break;
                        case 116:
                            stringBuilder.append('\t');
                            break;
                        default:
                            throw new akz(MessageFormat.format(JGitText.j6().badEscape, new Object[]{Character.valueOf((char) ani_d.j6())}));
                    }
                } else if (34 == j6) {
                    z = !z;
                } else {
                    stringBuilder.append((char) j6);
                }
            }
            if (stringBuilder.length() > 0) {
                return stringBuilder.toString();
            }
            return null;
        }
    }
}
