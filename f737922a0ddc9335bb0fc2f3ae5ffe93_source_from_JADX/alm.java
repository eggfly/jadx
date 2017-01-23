import java.io.IOException;

public class alm extends IOException {
    public alm(String str) {
        super(str);
    }

    public alm(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
