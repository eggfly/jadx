public class bdu extends RuntimeException {
    Exception DW;

    public Throwable getCause() {
        return this.DW;
    }
}
