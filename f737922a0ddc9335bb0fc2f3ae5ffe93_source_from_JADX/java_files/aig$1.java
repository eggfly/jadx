import java.util.Comparator;

class aig$1 implements Comparator<aoc> {
    final /* synthetic */ aig j6;

    aig$1(aig aig) {
        this.j6 = aig;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((aoc) obj, (aoc) obj2);
    }

    public int j6(aoc aoc, aoc aoc2) {
        return aoc.j6().compareTo(aoc2.j6());
    }
}
