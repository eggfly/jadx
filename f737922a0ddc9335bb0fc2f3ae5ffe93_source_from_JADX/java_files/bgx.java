public class bgx extends Exception {
    private Throwable j6;

    public bgx(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public bgx(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.j6;
    }
}
