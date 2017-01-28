import java.util.Enumeration;

public class azn extends ayy {
    public azn(ayh ayh) {
        super(ayh);
    }

    public azn(ayi ayi) {
        super(ayi, false);
    }

    public azn(ayh[] ayhArr) {
        super(ayhArr, false);
    }

    int u7() {
        Enumeration FH = FH();
        int i = 0;
        while (FH.hasMoreElements()) {
            i = ((ayh) FH.nextElement()).w_().u7() + i;
        }
        return (i + 2) + 2;
    }

    void j6(ayt ayt) {
        ayt.DW(49);
        ayt.DW(128);
        Enumeration FH = FH();
        while (FH.hasMoreElements()) {
            ayt.j6((ayh) FH.nextElement());
        }
        ayt.DW(0);
        ayt.DW(0);
    }
}
