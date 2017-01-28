public class ej extends Exception {
    public Throwable fillInStackTrace() {
        return this;
    }
}
