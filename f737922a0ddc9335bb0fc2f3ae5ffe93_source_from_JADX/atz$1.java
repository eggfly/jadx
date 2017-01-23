import java.security.PrivilegedAction;

class atz$1 implements PrivilegedAction<String> {
    public /* synthetic */ Object run() {
        return j6();
    }

    atz$1() {
    }

    public String j6() {
        return System.getProperty("user.name");
    }
}
