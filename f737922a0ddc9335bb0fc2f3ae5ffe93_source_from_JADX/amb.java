import java.io.IOException;

public class amb extends IOException {
    public amb(avn avn, String str) {
        super(avn.v5(null) + ": " + str);
    }

    public amb(avn avn, String str, Throwable th) {
        this(avn.v5(null) + ": " + str, th);
    }

    public amb(String str) {
        super(str);
    }

    public amb(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
