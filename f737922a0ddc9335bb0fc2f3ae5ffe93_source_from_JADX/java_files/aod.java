import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class aod implements Comparator<aoc> {
    public static final aod j6;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((aoc) obj, (aoc) obj2);
    }

    static {
        j6 = new aod();
    }

    public int j6(aoc aoc, aoc aoc2) {
        return DW(aoc, aoc2);
    }

    public static Collection<aoc> j6(Collection<aoc> collection) {
        Collection arrayList = new ArrayList(collection);
        Collections.sort(arrayList, j6);
        return arrayList;
    }

    public static int j6(aoc aoc, String str) {
        return aoc.j6().compareTo(str);
    }

    public static int DW(aoc aoc, aoc aoc2) {
        return aoc.j6().compareTo(aoc2.j6());
    }
}
