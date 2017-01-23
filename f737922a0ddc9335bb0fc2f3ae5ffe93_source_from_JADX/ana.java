import java.util.zip.Inflater;

class ana extends Inflater {
    private static final byte[] j6;

    static {
        j6 = new byte[1];
    }

    ana() {
        super(false);
    }

    public int inflate(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            return super.inflate(bArr, i, i2);
        }
        if (super.inflate(j6, 0, 1) <= 0) {
            return 0;
        }
        throw new RuntimeException();
    }

    public int inflate(byte[] bArr) {
        return super.inflate(bArr);
    }

    public void end() {
    }

    void j6() {
        super.end();
    }
}
