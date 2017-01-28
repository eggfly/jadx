import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public final class ze extends adm implements Comparable<ze> {
    public static final ze j6;
    private final TreeMap<abf, zc> DW;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ze) obj);
    }

    static {
        j6 = new ze();
        j6.l_();
    }

    public static ze j6(ze zeVar, ze zeVar2) {
        ze zeVar3 = new ze();
        zeVar3.DW(zeVar);
        zeVar3.DW(zeVar2);
        zeVar3.l_();
        return zeVar3;
    }

    public static ze j6(ze zeVar, zc zcVar) {
        ze zeVar2 = new ze();
        zeVar2.DW(zeVar);
        zeVar2.j6(zcVar);
        zeVar2.l_();
        return zeVar2;
    }

    public ze() {
        this.DW = new TreeMap();
    }

    public int hashCode() {
        return this.DW.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ze)) {
            return false;
        }
        return this.DW.equals(((ze) obj).DW);
    }

    public int j6(ze zeVar) {
        Iterator it = this.DW.values().iterator();
        Iterator it2 = zeVar.DW.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int j6 = ((zc) it.next()).j6((zc) it2.next());
            if (j6 != 0) {
                return j6;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        if (it2.hasNext()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("annotations{");
        Object obj = 1;
        for (zc zcVar : this.DW.values()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(zcVar.Hw());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int DW() {
        return this.DW.size();
    }

    public void j6(zc zcVar) {
        we();
        if (zcVar == null) {
            throw new NullPointerException("annotation == null");
        }
        abf DW = zcVar.DW();
        if (this.DW.containsKey(DW)) {
            throw new IllegalArgumentException("duplicate type: " + DW.Hw());
        }
        this.DW.put(DW, zcVar);
    }

    public void DW(ze zeVar) {
        we();
        if (zeVar == null) {
            throw new NullPointerException("toAdd == null");
        }
        for (zc j6 : zeVar.DW.values()) {
            j6(j6);
        }
    }

    public Collection<zc> Hw() {
        return Collections.unmodifiableCollection(this.DW.values());
    }
}
