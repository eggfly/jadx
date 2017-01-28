import java.security.PrivilegedAction;

class awq$1 implements PrivilegedAction<String> {
    public /* synthetic */ Object run() {
        return j6();
    }

    awq$1() {
    }

    public String j6() {
        return System.getProperty("os.name");
    }
}
