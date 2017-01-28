public class bdr extends Exception {
    Exception j6;

    public bdr(String str, Exception exception) {
        super(str);
        this.j6 = exception;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
