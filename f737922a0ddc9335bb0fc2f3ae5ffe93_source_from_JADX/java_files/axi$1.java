import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

class axi$1 extends axi {
    private volatile String j6;

    axi$1() {
    }

    public String j6(String str) {
        return System.getenv(str);
    }

    public String DW(String str) {
        return System.getProperty(str);
    }

    public ara DW(ani ani, awp awp) {
        File Zo = awp.Zo();
        return Zo == null ? new axi$1$1(this, null, awp) : new ara(ani, awp.j6(awp.j6(Zo, "etc"), "gitconfig"), awp);
    }

    public ara j6(ani ani, awp awp) {
        return new ara(ani, new File(awp.FH(), ".gitconfig"), awp);
    }

    public String j6() {
        if (this.j6 == null) {
            try {
                this.j6 = InetAddress.getLocalHost().getCanonicalHostName();
            } catch (UnknownHostException e) {
                this.j6 = "localhost";
            }
            if (!axi.FH && this.j6 == null) {
                throw new AssertionError();
            }
        }
        return this.j6;
    }

    public long DW() {
        return System.currentTimeMillis();
    }

    public int j6(long j) {
        return Hw().getOffset(j) / 60000;
    }
}
