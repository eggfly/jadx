import java.util.Map;

public class aio {
    static final aio DW;
    static final aio FH;
    static final aio Hw;
    static final aio j6;
    private Map<String, aox$a> VH;
    private final aqc Zo;
    private final aio$a v5;

    static {
        j6 = new aio(aio$a.OK);
        DW = new aio(aio$a.ABORTED);
        FH = new aio(aio$a.UP_TO_DATE);
        Hw = new aio(aio$a.FAST_FORWARD);
    }

    private aio(aio$a aio_a) {
        this.v5 = aio_a;
        this.Zo = null;
    }

    aio(aqc aqc) {
        this.v5 = aio$a.STOPPED;
        this.Zo = aqc;
    }

    aio(Map<String, aox$a> map) {
        this.v5 = aio$a.FAILED;
        this.Zo = null;
        this.VH = map;
    }

    public aio$a j6() {
        return this.v5;
    }
}
