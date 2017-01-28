import java.util.Enumeration;

public class azl extends ayw {
    public azl(ayh ayh) {
        super(ayh);
    }

    public azl(ayi ayi) {
        super(ayi);
    }

    int u7() {
        Enumeration Hw = Hw();
        int i = 0;
        while (Hw.hasMoreElements()) {
            i = ((ayh) Hw.nextElement()).w_().u7() + i;
        }
        return (i + 2) + 2;
    }

    void j6(ayt ayt) {
        ayt.DW(48);
        ayt.DW(128);
        Enumeration Hw = Hw();
        while (Hw.hasMoreElements()) {
            ayt.j6((ayh) Hw.nextElement());
        }
        ayt.DW(0);
        ayt.DW(0);
    }
}
