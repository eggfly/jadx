import java.io.IOException;

public class aln extends IOException {
    public aln(String str) {
        super(str);
    }

    public aln(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
