import java.io.IOException;

public class bdk extends IOException {
    private Throwable j6;

    public bdk(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
