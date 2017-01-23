import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class any {
    public abstract anx FH(anb anb, int i);

    public abstract any j6();

    public abstract Collection<ans> j6(amz amz);

    public amz j6(anb anb) {
        return j6(anb, 7);
    }

    public amz j6(anb anb, int i) {
        if (i == 40) {
            return amz.j6(anb);
        }
        amz j6 = anb.j6(i);
        Collection j62 = j6(j6);
        while (1 < r0.size() && i < 40) {
            i++;
            amz j63 = anb.j6(i);
            List arrayList = new ArrayList(8);
            for (anb anb2 : r0) {
                if (j63.DW(anb2) == 0) {
                    arrayList.add(anb2);
                }
            }
            if (1 < arrayList.size()) {
                j62 = arrayList;
                j6 = j63;
            } else {
                j62 = j6(j63);
                j6 = j63;
            }
        }
        return j6;
    }

    public boolean DW(anb anb) {
        return DW(anb, -1);
    }

    public boolean DW(anb anb, int i) {
        try {
            FH(anb, i);
            return true;
        } catch (ali e) {
            return false;
        }
    }

    public anx FH(anb anb) {
        return FH(anb, -1);
    }

    public <T extends ans> anc<T> j6(Iterable<T> iterable, boolean z) {
        return new any$1(this, iterable.iterator());
    }

    public long Hw(anb anb, int i) {
        return FH(anb, i).j6();
    }

    public <T extends ans> and<T> DW(Iterable<T> iterable, boolean z) {
        return new any$2(this, iterable.iterator());
    }

    public void j6(aql aql, Collection<aqc> collection) {
    }

    public void j6(apy apy, aqc aqc, aqc aqc2) {
    }

    public void DW() {
    }

    public void FH() {
    }
}
