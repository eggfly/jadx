import java.util.Enumeration;

public class bal extends ayw {
    private int DW;

    public bal() {
        this.DW = -1;
    }

    public bal(ayi ayi) {
        super(ayi);
        this.DW = -1;
    }

    public bal(ayh[] ayhArr) {
        super(ayhArr);
        this.DW = -1;
    }

    private int tp() {
        if (this.DW < 0) {
            Enumeration Hw = Hw();
            int i = 0;
            while (Hw.hasMoreElements()) {
                i = ((ayh) Hw.nextElement()).w_().Zo().u7() + i;
            }
            this.DW = i;
        }
        return this.DW;
    }

    int u7() {
        int tp = tp();
        return tp + (bbg.j6(tp) + 1);
    }

    void j6(ayt ayt) {
        ayt j6 = ayt.j6();
        int tp = tp();
        ayt.DW(48);
        ayt.j6(tp);
        Enumeration Hw = Hw();
        while (Hw.hasMoreElements()) {
            j6.j6((ayh) Hw.nextElement());
        }
    }
}
