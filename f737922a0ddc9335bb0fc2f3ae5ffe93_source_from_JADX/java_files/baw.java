import java.util.Enumeration;

public class baw extends ayw {
    private int DW;

    public baw() {
        this.DW = -1;
    }

    public baw(ayh ayh) {
        super(ayh);
        this.DW = -1;
    }

    public baw(ayi ayi) {
        super(ayi);
        this.DW = -1;
    }

    private int tp() {
        if (this.DW < 0) {
            Enumeration Hw = Hw();
            int i = 0;
            while (Hw.hasMoreElements()) {
                i = ((ayh) Hw.nextElement()).w_().VH().u7() + i;
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
        ayt DW = ayt.DW();
        int tp = tp();
        ayt.DW(48);
        ayt.j6(tp);
        Enumeration Hw = Hw();
        while (Hw.hasMoreElements()) {
            DW.j6((ayh) Hw.nextElement());
        }
    }
}
