import java.io.IOException;

public class avp extends IOException {
    public avp(Throwable th) {
        initCause(th);
    }
}
