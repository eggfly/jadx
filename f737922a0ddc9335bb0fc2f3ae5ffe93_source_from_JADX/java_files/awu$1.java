import java.security.PrivilegedAction;

class awu$1 implements PrivilegedAction<String> {
    public /* synthetic */ Object run() {
        return j6();
    }

    awu$1() {
    }

    public String j6() {
        return System.getProperty("java.library.path");
    }
}
