import java.io.InputStream;

public class azk implements ays {
    private aza j6;

    azk(aza aza) {
        this.j6 = aza;
    }

    public InputStream FH() {
        return new azr(this.j6);
    }

    public ayv v5() {
        return new azj(bhp.j6(FH()));
    }

    public ayv w_() {
        try {
            return v5();
        } catch (Throwable e) {
            throw new ayu("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
