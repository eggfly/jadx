import java.io.OutputStream;
import java.security.Signature;

class bhc$a extends OutputStream {
    private Signature DW;
    final /* synthetic */ bhc j6;

    bhc$a(bhc bhc, Signature signature) {
        this.j6 = bhc;
        this.DW = signature;
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.DW.update(bArr, i, i2);
        } catch (Throwable e) {
            throw new bgy("exception in content signer: " + e.getMessage(), e);
        }
    }

    public void write(byte[] bArr) {
        try {
            this.DW.update(bArr);
        } catch (Throwable e) {
            throw new bgy("exception in content signer: " + e.getMessage(), e);
        }
    }

    public void write(int i) {
        try {
            this.DW.update((byte) i);
        } catch (Throwable e) {
            throw new bgy("exception in content signer: " + e.getMessage(), e);
        }
    }

    byte[] j6() {
        return this.DW.sign();
    }
}
