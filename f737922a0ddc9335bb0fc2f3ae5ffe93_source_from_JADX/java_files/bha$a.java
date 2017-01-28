import java.io.OutputStream;

class bha$a extends OutputStream {
    private ben DW;
    final /* synthetic */ bha j6;

    bha$a(bha bha, ben ben) {
        this.j6 = bha;
        this.DW = ben;
    }

    public void write(byte[] bArr, int i, int i2) {
        this.DW.j6(bArr, i, i2);
    }

    public void write(byte[] bArr) {
        this.DW.j6(bArr, 0, bArr.length);
    }

    public void write(int i) {
        this.DW.j6((byte) i);
    }

    byte[] j6() {
        byte[] bArr = new byte[this.DW.DW()];
        this.DW.j6(bArr, 0);
        return bArr;
    }
}
