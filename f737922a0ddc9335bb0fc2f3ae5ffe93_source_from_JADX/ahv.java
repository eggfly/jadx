import java.util.ArrayList;
import java.util.List;

public class ahv {
    public static final ahv DW;
    public static final ahv FH;
    public static final ahv j6;
    private final ahv$a Hw;
    private final List<String> Zo;
    private final List<String> v5;

    static {
        j6 = new ahv(ahv$a.OK, null);
        DW = new ahv(ahv$a.ERROR, null);
        FH = new ahv(ahv$a.NOT_TRIED, null);
    }

    ahv(ahv$a ahv_a, List<String> list) {
        this.Hw = ahv_a;
        if (ahv_a == ahv$a.CONFLICTS) {
            this.v5 = list;
        } else {
            this.v5 = new ArrayList(0);
        }
        if (ahv_a == ahv$a.NONDELETED) {
            this.Zo = list;
        } else {
            this.Zo = new ArrayList(0);
        }
    }

    public ahv$a j6() {
        return this.Hw;
    }
}
