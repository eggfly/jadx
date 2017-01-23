import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class bq {
    public boolean DW;
    public boolean FH;
    public boolean Hw;
    public int VH;
    public boolean Zo;
    public Map<String, Integer> gn;
    public String j6;
    public Map<String, Set<? extends bd>> u7;
    public int v5;

    public bq() {
        this.gn = new HashMap();
        this.u7 = new HashMap();
    }

    public int j6(bj bjVar) {
        if (this.gn.containsKey(bjVar.j6())) {
            return ((Integer) this.gn.get(bjVar.j6())).intValue();
        }
        return 4;
    }

    public Set<? extends bd> DW(bj bjVar) {
        if (this.u7.containsKey(bjVar.j6())) {
            return (Set) this.u7.get(bjVar.j6());
        }
        Set<? extends bd> FH = bjVar.FH();
        if (FH == null) {
            return Collections.EMPTY_SET;
        }
        return FH;
    }
}
