import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class bat extends ayv implements azb {
    private static final char[] j6;
    private byte[] DW;

    static {
        j6 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public bat(byte[] bArr) {
        this.DW = bArr;
    }

    public String j6() {
        StringBuffer stringBuffer = new StringBuffer("#");
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ayt(byteArrayOutputStream).j6((ayh) this);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != toByteArray.length; i++) {
                stringBuffer.append(j6[(toByteArray[i] >>> 4) & 15]);
                stringBuffer.append(j6[toByteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new RuntimeException("internal error encoding BitString");
        }
    }

    public String toString() {
        return j6();
    }

    public byte[] FH() {
        return this.DW;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.DW.length) + 1) + this.DW.length;
    }

    void j6(ayt ayt) {
        ayt.j6(28, FH());
    }

    boolean j6(ayv ayv) {
        if (ayv instanceof bat) {
            return bhf.j6(this.DW, ((bat) ayv).DW);
        }
        return false;
    }

    public int hashCode() {
        return bhf.j6(this.DW);
    }
}
