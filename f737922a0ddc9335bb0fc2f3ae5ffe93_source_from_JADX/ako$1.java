import java.util.Comparator;

class ako$1 implements Comparator<akt> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((akt) obj, (akt) obj2);
    }

    ako$1() {
    }

    public int j6(akt akt, akt akt2) {
        int j6 = ako.j6(akt, akt2);
        return j6 != 0 ? j6 : akt.VH() - akt2.VH();
    }
}
