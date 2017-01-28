public class bft implements bel {
    private byte[] DW;
    private bel j6;

    public bft(bel bel, byte[] bArr) {
        this.j6 = bel;
        this.DW = bArr;
    }

    public byte[] j6() {
        return this.DW;
    }

    public bel DW() {
        return this.j6;
    }
}
