import java.io.IOException;

public class ayk extends IOException {
    private Throwable j6;

    ayk(String str) {
        super(str);
    }

    ayk(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
