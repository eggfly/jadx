public class ayu extends IllegalStateException {
    private Throwable j6;

    public ayu(String str) {
        super(str);
    }

    public ayu(String str, Throwable th) {
        super(str);
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
