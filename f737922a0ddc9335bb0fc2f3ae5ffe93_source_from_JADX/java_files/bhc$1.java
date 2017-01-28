import java.io.OutputStream;
import java.security.Signature;

class bhc$1 implements bgq {
    private bhc$a DW;
    final /* synthetic */ bhc j6;

    bhc$1(bhc bhc, Signature signature) {
        this.j6 = bhc;
        this.DW = new bhc$a(bhc, signature);
    }

    public bcp j6() {
        return this.j6.Hw;
    }

    public OutputStream DW() {
        return this.DW;
    }

    public byte[] FH() {
        try {
            return this.DW.j6();
        } catch (Throwable e) {
            throw new bgz("exception obtaining signature: " + e.getMessage(), e);
        }
    }
}
