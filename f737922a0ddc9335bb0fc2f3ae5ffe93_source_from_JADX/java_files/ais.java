import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ais extends aie<Map<String, atb>> {
    private final Collection<String> DW;

    public /* synthetic */ Object call() {
        return j6();
    }

    public ais(aoh aoh) {
        super(aoh);
        this.DW = new ArrayList();
    }

    public Map<String, atb> j6() {
        Zo();
        try {
            atd j6 = atd.j6(this.j6);
            if (!this.DW.isEmpty()) {
                j6.j6(awj.j6(this.DW));
            }
            Map<String, atb> hashMap = new HashMap();
            while (j6.DW()) {
                atb j62 = j6(j6);
                hashMap.put(j62.j6(), j62);
            }
            return hashMap;
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new ajg(e2.getMessage(), e2);
        }
    }

    private atb j6(atd atd) {
        anb Hw = atd.Hw();
        String FH = atd.FH();
        if (atd.v5() == null) {
            return new atb(atc.MISSING, FH, Hw);
        }
        if (atd.Zo() == null) {
            return new atb(atc.UNINITIALIZED, FH, Hw);
        }
        aoh tp = atd.tp();
        if (tp == null) {
            return new atb(atc.UNINITIALIZED, FH, Hw);
        }
        ans DW = tp.DW("HEAD");
        if (DW == null) {
            return new atb(atc.UNINITIALIZED, FH, Hw, DW);
        }
        if (DW.DW(Hw)) {
            return new atb(atc.INITIALIZED, FH, Hw, DW);
        }
        return new atb(atc.REV_CHECKED_OUT, FH, Hw, DW);
    }
}
