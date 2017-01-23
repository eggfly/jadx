public class ahm {
    private static agz u7;
    public short DW;
    public short FH;
    public short Hw;
    public int VH;
    public int Zo;
    public String gn;
    public int j6;
    public short v5;

    public ahm() {
        this.j6 = 101010256;
        this.DW = (short) 0;
        this.FH = (short) 0;
    }

    public static ahm j6(ahq ahq) {
        if (ahq.FH() != 101010256) {
            ahq.j6(ahq.DW() - 4);
            return null;
        }
        ahm ahm = new ahm();
        ahm.DW(ahq);
        return ahm;
    }

    public static agz j6() {
        if (u7 == null) {
            u7 = aha.j6(ahm.class.getName());
        }
        return u7;
    }

    private void DW(ahq ahq) {
        boolean j6 = j6().j6();
        this.DW = ahq.Hw();
        if (j6) {
            u7.Hw(String.format("This disk number: 0x%04x", new Object[]{Short.valueOf(this.DW)}));
        }
        this.FH = ahq.Hw();
        if (j6) {
            u7.Hw(String.format("Central dir start disk number: 0x%04x", new Object[]{Short.valueOf(this.FH)}));
        }
        this.Hw = ahq.Hw();
        if (j6) {
            u7.Hw(String.format("Central entries on this disk: 0x%04x", new Object[]{Short.valueOf(this.Hw)}));
        }
        this.v5 = ahq.Hw();
        if (j6) {
            u7.Hw(String.format("Total number of central entries: 0x%04x", new Object[]{Short.valueOf(this.v5)}));
        }
        this.Zo = ahq.FH();
        if (j6) {
            u7.Hw(String.format("Central directory size: 0x%08x", new Object[]{Integer.valueOf(this.Zo)}));
        }
        this.VH = ahq.FH();
        if (j6) {
            u7.Hw(String.format("Central directory offset: 0x%08x", new Object[]{Integer.valueOf(this.VH)}));
        }
        this.gn = ahq.DW(ahq.Hw());
        if (j6) {
            u7.Hw(".ZIP file comment: " + this.gn);
        }
    }

    public void j6(ahs ahs) {
        j6().j6();
        ahs.j6(this.j6);
        ahs.j6(this.DW);
        ahs.j6(this.FH);
        ahs.j6(this.Hw);
        ahs.j6(this.v5);
        ahs.j6(this.Zo);
        ahs.j6(this.VH);
        ahs.j6((short) this.gn.length());
        ahs.j6(this.gn);
    }
}
