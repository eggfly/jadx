public class alq extends amb {
    public alq(avn avn, String str) {
        super(avn + ": " + str);
    }

    public alq(String str) {
        super(str);
    }

    public alq(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
