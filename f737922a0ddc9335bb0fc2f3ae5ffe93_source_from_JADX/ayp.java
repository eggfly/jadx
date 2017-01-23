import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class ayp implements ayh {
    public abstract ayv w_();

    public byte[] DW() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ayt(byteArrayOutputStream).j6((ayh) this);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] j6(String str) {
        OutputStream byteArrayOutputStream;
        if (str.equals("DER")) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new baj(byteArrayOutputStream).j6(this);
            return byteArrayOutputStream.toByteArray();
        } else if (!str.equals("DL")) {
            return DW();
        } else {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new bav(byteArrayOutputStream).j6(this);
            return byteArrayOutputStream.toByteArray();
        }
    }

    public int hashCode() {
        return w_().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ayh)) {
            return false;
        }
        return w_().equals(((ayh) obj).w_());
    }
}
