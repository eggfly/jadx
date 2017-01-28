import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public final class zc extends adm implements adq, Comparable<zc> {
    private final zd DW;
    private final TreeMap<abe, zg> FH;
    private final abf j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((zc) obj);
    }

    public zc(abf abf, zd zdVar) {
        if (abf == null) {
            throw new NullPointerException("type == null");
        } else if (zdVar == null) {
            throw new NullPointerException("visibility == null");
        } else {
            this.j6 = abf;
            this.DW = zdVar;
            this.FH = new TreeMap();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zc)) {
            return false;
        }
        zc zcVar = (zc) obj;
        if (this.j6.equals(zcVar.j6) && this.DW == zcVar.DW) {
            return this.FH.equals(zcVar.FH);
        }
        return false;
    }

    public int hashCode() {
        return (((this.j6.hashCode() * 31) + this.FH.hashCode()) * 31) + this.DW.hashCode();
    }

    public int j6(zc zcVar) {
        int j6 = this.j6.j6(zcVar.j6);
        if (j6 != 0) {
            return j6;
        }
        j6 = this.DW.compareTo(zcVar.DW);
        if (j6 != 0) {
            return j6;
        }
        Iterator it = this.FH.values().iterator();
        Iterator it2 = zcVar.FH.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            j6 = ((zg) it.next()).j6((zg) it2.next());
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
        return Hw();
    }

    public String Hw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.DW.Hw());
        stringBuilder.append("-annotation ");
        stringBuilder.append(this.j6.Hw());
        stringBuilder.append(" {");
        Object obj = 1;
        for (zg zgVar : this.FH.values()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(zgVar.j6().Hw());
            stringBuilder.append(": ");
            stringBuilder.append(zgVar.DW().Hw());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public abf DW() {
        return this.j6;
    }

    public zd v5() {
        return this.DW;
    }

    public void j6(zg zgVar) {
        we();
        if (zgVar == null) {
            throw new NullPointerException("pair == null");
        }
        this.FH.put(zgVar.j6(), zgVar);
    }

    public void DW(zg zgVar) {
        we();
        if (zgVar == null) {
            throw new NullPointerException("pair == null");
        }
        abe j6 = zgVar.j6();
        if (this.FH.get(j6) != null) {
            throw new IllegalArgumentException("name already added: " + j6);
        }
        this.FH.put(j6, zgVar);
    }

    public Collection<zg> Zo() {
        return Collections.unmodifiableCollection(this.FH.values());
    }
}
