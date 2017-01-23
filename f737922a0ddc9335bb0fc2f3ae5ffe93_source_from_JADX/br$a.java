import java.io.OutputStream;

class br$a implements br$c {
    private byte[] DW;
    private int FH;
    final /* synthetic */ br j6;

    private br$a(br brVar) {
        this.j6 = brVar;
    }

    public void j6(OutputStream outputStream) {
        outputStream.write(this.DW, 0, this.FH);
    }

    public void j6(byte[] bArr, int i) {
        if (this.DW == null || i > this.DW.length) {
            this.DW = new byte[((i * 5) / 4)];
        }
        System.arraycopy(bArr, 0, this.DW, 0, i);
        this.FH = i;
    }
}
