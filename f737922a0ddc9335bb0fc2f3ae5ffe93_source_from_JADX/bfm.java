import java.security.SecureRandom;

public class bfm extends bep {
    private bfo j6;

    public bfm(SecureRandom secureRandom, bfo bfo) {
        super(secureRandom, j6(bfo));
        this.j6 = bfo;
    }

    public bfo DW() {
        return this.j6;
    }

    static int j6(bfo bfo) {
        return bfo.v5() != 0 ? bfo.v5() : bfo.j6().bitLength();
    }
}
