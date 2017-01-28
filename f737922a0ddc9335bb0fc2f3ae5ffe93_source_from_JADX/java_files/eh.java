public class eh extends Exception {
    public Throwable fillInStackTrace() {
        return this;
    }
}
