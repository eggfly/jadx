import java.util.Comparator;

class we$a implements Comparator<we> {
    private we$a() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((we) obj, (we) obj2);
    }

    public int j6(we weVar, we weVar2) {
        int VH = weVar.FH.VH();
        int VH2 = weVar2.FH.VH();
        if (VH < VH2) {
            return -1;
        }
        if (VH > VH2) {
            return 1;
        }
        return 0;
    }
}
