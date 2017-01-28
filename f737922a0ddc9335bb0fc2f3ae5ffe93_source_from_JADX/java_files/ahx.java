import java.util.List;
import java.util.Map;

public class ahx {
    public static final ahx j6;
    private final ahx$a DW;
    private final aqc FH;
    private final List<aoc> Hw;
    private final Map<String, aox$a> v5;

    public ahx(aqc aqc, List<aoc> list) {
        this.DW = ahx$a.OK;
        this.FH = aqc;
        this.Hw = list;
        this.v5 = null;
    }

    public ahx(Map<String, aox$a> map) {
        this.DW = ahx$a.FAILED;
        this.FH = null;
        this.Hw = null;
        this.v5 = map;
    }

    private ahx(ahx$a ahx_a) {
        this.DW = ahx_a;
        this.FH = null;
        this.Hw = null;
        this.v5 = null;
    }

    static {
        j6 = new ahx(ahx$a.CONFLICTING);
    }

    public ahx$a j6() {
        return this.DW;
    }

    public aqc DW() {
        return this.FH;
    }

    public Map<String, aox$a> FH() {
        return this.v5;
    }
}
