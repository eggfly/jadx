import java.io.Reader;

class bw$b extends Reader {
    private boolean DW;
    private Reader j6;

    public bw$b(Reader reader) {
        this.j6 = reader;
        this.DW = false;
    }

    public int read(char[] cArr, int i, int i2) {
        int read = this.j6.read(cArr, i, i2);
        if (read == -1) {
            return -1;
        }
        int i3 = i + read;
        int i4 = i;
        boolean z = this.DW;
        int i5 = i;
        while (i4 < i3) {
            boolean z2;
            read = i4 + 1;
            char c = cArr[i4];
            switch (c) {
                case '\n':
                    if (z) {
                        i4 = i5;
                    } else {
                        i4 = i5 + 1;
                        cArr[i5] = '\n';
                    }
                    z2 = false;
                    break;
                case '\r':
                    i4 = i5 + 1;
                    cArr[i5] = '\n';
                    z2 = true;
                    break;
                default:
                    i4 = i5 + 1;
                    cArr[i5] = c;
                    z2 = false;
                    break;
            }
            z = z2;
            i5 = i4;
            i4 = read;
        }
        this.DW = z;
        return i5 - i;
    }

    public void close() {
        if (this.j6 != null) {
            this.j6.close();
            this.j6 = null;
        }
    }
}
