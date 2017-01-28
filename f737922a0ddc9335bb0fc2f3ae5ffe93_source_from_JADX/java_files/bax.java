import java.util.Enumeration;

public class bax extends ayy {
    private int j6;

    public bax() {
        this.j6 = -1;
    }

    public bax(ayh ayh) {
        super(ayh);
        this.j6 = -1;
    }

    public bax(ayi ayi) {
        super(ayi, false);
        this.j6 = -1;
    }

    public bax(ayh[] ayhArr) {
        super(ayhArr, false);
        this.j6 = -1;
    }

    private int tp() {
        if (this.j6 < 0) {
            Enumeration FH = FH();
            int i = 0;
            while (FH.hasMoreElements()) {
                i = ((ayh) FH.nextElement()).w_().VH().u7() + i;
            }
            this.j6 = i;
        }
        return this.j6;
    }

    int u7() {
        int tp = tp();
        return tp + (bbg.j6(tp) + 1);
    }

    void j6(ayt ayt) {
        ayt DW = ayt.DW();
        int tp = tp();
        ayt.DW(49);
        ayt.j6(tp);
        Enumeration FH = FH();
        while (FH.hasMoreElements()) {
            DW.j6((ayh) FH.nextElement());
        }
    }
}
