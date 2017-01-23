import java.util.Comparator;

public final class acg$a implements Comparator<acg> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((acg) obj, (acg) obj2);
    }

    public int j6(acg acg, acg acg2) {
        int Hw = acg.VH;
        int Hw2 = acg2.VH;
        if (Hw < Hw2) {
            return -1;
        }
        if (Hw > Hw2) {
            return 1;
        }
        return 0;
    }
}
