import java.io.InputStream;

abstract class bbe extends InputStream {
    private int DW;
    protected final InputStream j6;

    bbe(InputStream inputStream, int i) {
        this.j6 = inputStream;
        this.DW = i;
    }

    int j6() {
        return this.DW;
    }

    protected void DW(boolean z) {
        if (this.j6 instanceof bbb) {
            ((bbb) this.j6).j6(z);
        }
    }
}
