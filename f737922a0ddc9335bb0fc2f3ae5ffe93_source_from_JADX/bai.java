import java.io.InputStream;

public class bai implements ays {
    private baz j6;

    bai(baz baz) {
        this.j6 = baz;
    }

    public InputStream FH() {
        return this.j6;
    }

    public ayv v5() {
        return new bah(this.j6.DW());
    }

    public ayv w_() {
        try {
            return v5();
        } catch (Throwable e) {
            throw new ayu("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
