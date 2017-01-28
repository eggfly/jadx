import java.io.IOException;

public class bgy extends IOException {
    private Throwable j6;

    public bgy(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
