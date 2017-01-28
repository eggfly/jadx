public class g extends RuntimeException {
    public g() {
        this(null);
    }

    public g(String str) {
        if (str == null) {
            str = "The operation has been canceled.";
        }
        super(str);
    }
}
