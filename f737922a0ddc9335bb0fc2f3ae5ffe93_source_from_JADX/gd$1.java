import java.util.Comparator;

class gd$1 implements Comparator<bz> {
    final /* synthetic */ gd j6;

    gd$1(gd gdVar) {
        this.j6 = gdVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((bz) obj, (bz) obj2);
    }

    public int j6(bz bzVar, bz bzVar2) {
        if (bzVar.tp() != bzVar2.tp()) {
            return bzVar.tp().vy() - bzVar2.tp().vy();
        }
        return bzVar.er() - bzVar2.er();
    }
}
