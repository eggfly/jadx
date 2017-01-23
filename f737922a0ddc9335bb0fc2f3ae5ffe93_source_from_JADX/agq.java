public class agq implements Cloneable {
    long DW;
    long EQ;
    int FH;
    int Hw;
    byte[] VH;
    byte[] Zo;
    int gn;
    boolean j6;
    boolean tp;
    long u7;
    byte[] v5;
    private boolean we;

    public agq() {
        this.j6 = false;
        this.we = false;
        this.Hw = 255;
        this.tp = false;
        this.EQ = 0;
    }

    public void j6(long j) {
        this.u7 = j;
    }

    void j6(agp agp) {
        int i;
        if (this.j6) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.we) {
            i |= 2;
        }
        if (this.v5 != null) {
            i |= 4;
        }
        if (this.Zo != null) {
            i |= 8;
        }
        if (this.VH != null) {
            i |= 16;
        }
        int i2 = agp.SI == 1 ? 4 : agp.SI == 9 ? 2 : 0;
        agp.j6(-29921);
        agp.j6((byte) 8);
        agp.j6((byte) i);
        agp.j6((byte) ((int) this.EQ));
        agp.j6((byte) ((int) (this.EQ >> 8)));
        agp.j6((byte) ((int) (this.EQ >> 16)));
        agp.j6((byte) ((int) (this.EQ >> 24)));
        agp.j6((byte) i2);
        agp.j6((byte) this.Hw);
        if (this.v5 != null) {
            agp.j6((byte) this.v5.length);
            agp.j6((byte) (this.v5.length >> 8));
            agp.j6(this.v5, 0, this.v5.length);
        }
        if (this.Zo != null) {
            agp.j6(this.Zo, 0, this.Zo.length);
            agp.j6((byte) 0);
        }
        if (this.VH != null) {
            agp.j6(this.VH, 0, this.VH.length);
            agp.j6((byte) 0);
        }
    }

    public Object clone() {
        agq agq = (agq) super.clone();
        if (agq.v5 != null) {
            Object obj = new byte[agq.v5.length];
            System.arraycopy(agq.v5, 0, obj, 0, obj.length);
            agq.v5 = obj;
        }
        if (agq.Zo != null) {
            obj = new byte[agq.Zo.length];
            System.arraycopy(agq.Zo, 0, obj, 0, obj.length);
            agq.Zo = obj;
        }
        if (agq.VH != null) {
            obj = new byte[agq.VH.length];
            System.arraycopy(agq.VH, 0, obj, 0, obj.length);
            agq.VH = obj;
        }
        return agq;
    }
}
