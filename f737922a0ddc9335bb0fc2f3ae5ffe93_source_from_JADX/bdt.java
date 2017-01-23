import java.io.OutputStream;

public class bdt implements bea {
    private final byte[] DW;
    private final ayq j6;

    public bdt(byte[] bArr) {
        this(new ayq(bbl.j6.FH()), bArr);
    }

    public bdt(ayq ayq, byte[] bArr) {
        this.j6 = ayq;
        this.DW = bArr;
    }

    public void j6(OutputStream outputStream) {
        outputStream.write(this.DW);
    }

    public ayq j6() {
        return this.j6;
    }
}
