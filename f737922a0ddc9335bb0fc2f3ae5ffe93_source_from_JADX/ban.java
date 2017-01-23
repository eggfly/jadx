import java.util.Enumeration;

public class ban extends ayy {
    private int j6;

    public ban() {
        this.j6 = -1;
    }

    public ban(ayh ayh) {
        super(ayh);
        this.j6 = -1;
    }

    public ban(ayi ayi) {
        super(ayi, true);
        this.j6 = -1;
    }

    ban(ayi ayi, boolean z) {
        super(ayi, z);
        this.j6 = -1;
    }

    private int tp() {
        if (this.j6 < 0) {
            Enumeration FH = FH();
            int i = 0;
            while (FH.hasMoreElements()) {
                i = ((ayh) FH.nextElement()).w_().Zo().u7() + i;
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
        ayt j6 = ayt.j6();
        int tp = tp();
        ayt.DW(49);
        ayt.j6(tp);
        Enumeration FH = FH();
        while (FH.hasMoreElements()) {
            j6.j6((ayh) FH.nextElement());
        }
    }
}
