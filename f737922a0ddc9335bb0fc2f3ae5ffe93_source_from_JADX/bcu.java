public class bcu extends azu {
    public bcu(azu azu) {
        super(azu.FH(), azu.Hw());
    }

    public String toString() {
        if (this.j6.length == 1) {
            return "KeyUsage: 0x" + Integer.toHexString(this.j6[0] & 255);
        }
        return "KeyUsage: 0x" + Integer.toHexString(((this.j6[1] & 255) << 8) | (this.j6[0] & 255));
    }
}
