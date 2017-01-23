public class bbx extends azu {
    public bbx(azu azu) {
        super(azu.FH(), azu.Hw());
    }

    public String toString() {
        return "NetscapeCertType: 0x" + Integer.toHexString(this.j6[0] & 255);
    }
}
