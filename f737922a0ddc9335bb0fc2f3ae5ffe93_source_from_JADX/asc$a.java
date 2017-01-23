import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

final class asc$a extends anx {
    private final long DW;
    private final File FH;
    private final ans Hw;
    private final int j6;
    private final arb v5;

    private asc$a(int i, long j, File file, anb anb, arb arb) {
        this.j6 = i;
        this.DW = j;
        this.FH = file;
        this.Hw = anb.Hw();
        this.v5 = arb;
    }

    public int DW() {
        return this.j6;
    }

    public long j6() {
        return this.DW;
    }

    public boolean Hw() {
        return true;
    }

    public byte[] v5() {
        throw new alf(this.Hw);
    }

    public anz FH() {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        Object obj = null;
        try {
            InputStream j6 = asc.DW(new FileInputStream(this.FH));
            try {
                byte[] bArr = new byte[64];
                j6.mark(20);
                awx.j6(j6, bArr, 0, 2);
                if (asc.DW(bArr)) {
                    j6.reset();
                    j6 = asc.DW(asc.DW(j6, this.DW, this.Hw));
                    do {
                    } while (j6.read() > 0);
                    inputStream = j6;
                } else {
                    asc.DW(j6, bArr, 2, 18);
                    int i = bArr[0] & 255;
                    int i2 = 1;
                    while ((i & 128) != 0) {
                        int i3 = i2 + 1;
                        i = bArr[i2] & 255;
                        i2 = i3;
                    }
                    j6.reset();
                    awx.j6(j6, (long) i2);
                    inputStream = asc.DW(asc.DW(j6, this.DW, this.Hw));
                }
                try {
                    return new anz$a(this.j6, this.DW, inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    int i4 = 1;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = j6;
                if (obj == null) {
                    inputStream2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            return this.v5.j6(this.Hw, this.j6).FH();
        }
    }
}
