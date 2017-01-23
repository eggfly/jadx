import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class amr {
    private static final Pattern DW;
    static final List<amt> j6;
    private List<amt> FH;
    private List<amt> Hw;
    private List<amt> v5;

    static {
        j6 = Collections.emptyList();
        DW = Pattern.compile("\\[[.:=]");
    }

    private amr(List<amt> list) {
        this((List) list, (List) list);
    }

    private amr(List<amt> list, List<amt> list2) {
        this.FH = list;
        this.Hw = new ArrayList(list2.size());
        this.Hw.addAll(list2);
        this.v5 = new ArrayList(list2.size());
    }

    public amr(String str, Character ch) {
        this(j6(str, ch));
    }

    private static List<amt> j6(String str, Character ch) {
        List DW = DW(str, ch);
        List arrayList = new ArrayList(2);
        arrayList.add(amu.j6);
        int size = DW.size() - 1;
        while (size >= 0) {
            List<amt> list;
            List<amt> arrayList2;
            amp amp = (amp) DW.get(size);
            if (amp.j6()) {
                arrayList.add(amp);
                amp.j6(arrayList);
                list = arrayList;
            } else {
                amp.j6(arrayList);
                arrayList2 = new ArrayList(2);
                arrayList2.add(amp);
                list = arrayList2;
            }
            size--;
            arrayList2 = list;
        }
        return arrayList;
    }

    private static int j6(int i, String str) {
        int i2 = i + 1;
        int i3 = i + 2;
        if (i + 1 >= str.length()) {
            throw new alj(i, "[", "]", str);
        }
        if (str.charAt(i2) == '!') {
            i2++;
            i3++;
        }
        Matcher matcher = DW.matcher(str);
        int i4 = i3;
        int i5 = i2;
        i3 = -1;
        while (i3 == -1) {
            i2 = str.indexOf(93, i4);
            if (i2 == -1) {
                throw new alj(i, "[", "]", str);
            } else if (!matcher.find(i5) || matcher.start() >= i2) {
                i3 = i2;
            } else {
                String group = matcher.group(0);
                String str2 = group.charAt(1) + "]";
                i5 = matcher.start();
                int indexOf = str.indexOf(str2, i5 + 2);
                if (indexOf == -1) {
                    throw new alj(i5, group, str2, str);
                }
                i2 = indexOf + 2;
                i4 = i2;
                i5 = i2;
            }
        }
        return i3;
    }

    private static List<amp> DW(String str, Character ch) {
        int i = 0;
        List<amp> arrayList = new ArrayList();
        while (i < str.length()) {
            int indexOf = str.indexOf(91, i);
            if (indexOf == -1) {
                arrayList.addAll(FH(str.substring(i), ch));
                i = str.length();
            } else {
                arrayList.addAll(FH(str.substring(i, indexOf), ch));
                i = j6(indexOf, str);
                arrayList.add(new ams(str.substring(indexOf + 1, i), str));
                i++;
            }
        }
        return arrayList;
    }

    private static List<amp> FH(String str, Character ch) {
        List<amp> arrayList = new ArrayList(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '*':
                    arrayList.add(j6(ch, true));
                    break;
                case '?':
                    arrayList.add(j6(ch, false));
                    break;
                default:
                    arrayList.add(new amq(charAt));
                    break;
            }
        }
        return arrayList;
    }

    private static amp j6(Character ch, boolean z) {
        if (ch != null) {
            return new amv(ch.charValue(), z);
        }
        return new amw(z);
    }

    private void j6(char c) {
        List list = this.v5;
        list.clear();
        Collection collection = null;
        int i = 0;
        while (i < this.Hw.size()) {
            Collection DW = ((amt) this.Hw.get(i)).DW(c);
            if (DW != collection) {
                list.addAll(DW);
            } else {
                DW = collection;
            }
            i++;
            collection = DW;
        }
        this.v5 = this.Hw;
        this.Hw = list;
    }

    public void j6(String str) {
        for (int i = 0; i < str.length(); i++) {
            j6(str.charAt(i));
        }
    }

    public void j6() {
        this.Hw.clear();
        this.Hw.addAll(this.FH);
    }

    public boolean DW() {
        ListIterator listIterator = this.Hw.listIterator(this.Hw.size());
        while (listIterator.hasPrevious()) {
            if (((amt) listIterator.previous()) == amu.j6) {
                return true;
            }
        }
        return false;
    }
}
