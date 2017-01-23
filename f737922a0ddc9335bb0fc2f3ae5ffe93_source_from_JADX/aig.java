import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aig extends aie<List<aoc>> {
    private aig$a DW;

    public /* synthetic */ Object call() {
        return j6();
    }

    protected aig(aoh aoh) {
        super(aoh);
    }

    public List<aoc> j6() {
        Zo();
        try {
            Map FH;
            if (this.DW == null) {
                FH = this.j6.Zo().FH("refs/heads/");
            } else if (this.DW == aig$a.REMOTE) {
                FH = this.j6.Zo().FH("refs/remotes/");
            } else {
                FH = new HashMap(this.j6.Zo().FH("refs/heads/"));
                FH.putAll(this.j6.Zo().FH("refs/remotes/"));
            }
            List<aoc> arrayList = new ArrayList();
            arrayList.addAll(FH.values());
            Collections.sort(arrayList, new aig$1(this));
            DW(false);
            return arrayList;
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        }
    }

    public aig j6(aig$a aig_a) {
        Zo();
        this.DW = aig_a;
        return this;
    }
}
