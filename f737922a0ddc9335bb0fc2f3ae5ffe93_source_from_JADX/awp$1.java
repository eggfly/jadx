import java.security.PrivilegedAction;

class awp$1 implements PrivilegedAction<String> {
    final /* synthetic */ awp j6;

    awp$1(awp awp) {
        this.j6 = awp;
    }

    public /* synthetic */ Object run() {
        return j6();
    }

    public String j6() {
        return System.getProperty("user.home");
    }
}
