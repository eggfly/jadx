import java.io.OutputStream;

class ayt$a extends ayt {
    private boolean DW;
    final /* synthetic */ ayt j6;

    public ayt$a(ayt ayt, OutputStream outputStream) {
        this.j6 = ayt;
        super(outputStream);
        this.DW = true;
    }

    public void DW(int i) {
        if (this.DW) {
            this.DW = false;
        } else {
            super.DW(i);
        }
    }
}
