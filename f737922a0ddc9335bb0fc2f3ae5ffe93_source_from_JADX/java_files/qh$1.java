import java.io.Reader;

class qh$1 extends Reader {
    final /* synthetic */ Reader j6;

    qh$1(Reader reader) {
        this.j6 = reader;
    }

    public int read(char[] cArr, int i, int i2) {
        return this.j6.read(cArr, i, i2);
    }

    public void close() {
        qh.j6.j6();
    }
}
