import java.security.PrivilegedAction;

class awu$2 implements PrivilegedAction<String> {
    final /* synthetic */ awu j6;

    awu$2(awu awu) {
        this.j6 = awu;
    }

    public /* synthetic */ Object run() {
        return j6();
    }

    public String j6() {
        return System.getenv("HOME");
    }
}
