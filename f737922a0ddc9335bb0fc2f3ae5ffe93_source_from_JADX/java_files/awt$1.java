import java.security.PrivilegedAction;

class awt$1 implements PrivilegedAction<String> {
    public /* synthetic */ Object run() {
        return j6();
    }

    awt$1() {
    }

    public String j6() {
        return System.getProperty("os.name");
    }
}
