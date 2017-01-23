import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class yi {
    private static final byte[] j6;
    private byte[] DW;
    private final tr FH;
    private int Hw;
    private final List<String> VH;
    private final List<Integer> Zo;
    private final List<yq> gn;
    private final List<yn> tp;
    private final List<yl> u7;
    private final List<String> v5;

    static {
        j6 = new byte[8192];
    }

    public yi() {
        this.FH = new tr();
        this.Hw = 0;
        this.v5 = new yi$1(this);
        this.Zo = new yi$2(this);
        this.VH = new yi$3(this);
        this.gn = new yi$4(this);
        this.u7 = new yi$5(this);
        this.tp = new yi$6(this);
        this.DW = new byte[0];
    }

    public yi(InputStream inputStream, int i) {
        this.FH = new tr();
        this.Hw = 0;
        this.v5 = new yi$1(this);
        this.Zo = new yi$2(this);
        this.VH = new yi$3(this);
        this.gn = new yi$4(this);
        this.u7 = new yi$5(this);
        this.tp = new yi$6(this);
        j6(inputStream, i);
    }

    public yi(File file) {
        this.FH = new tr();
        this.Hw = 0;
        this.v5 = new yi$1(this);
        this.Zo = new yi$2(this);
        this.VH = new yi$3(this);
        this.gn = new yi$4(this);
        this.u7 = new yi$5(this);
        this.tp = new yi$6(this);
        if (adb.j6(file.getName())) {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry != null) {
                j6(zipFile.getInputStream(entry), (int) entry.getSize());
                zipFile.close();
                return;
            }
            throw new acz("Expected classes.dex in " + file);
        } else if (file.getName().endsWith(".dex")) {
            j6(new FileInputStream(file), (int) file.length());
        } else {
            throw new acz("unknown output extension: " + file);
        }
    }

    private void j6(InputStream inputStream, int i) {
        if (i == -1) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(j6);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(j6, 0, read);
            }
            this.DW = byteArrayOutputStream.toByteArray();
        } else {
            this.DW = new byte[i];
            new DataInputStream(inputStream).readFully(this.DW);
        }
        this.Hw = this.DW.length;
        this.FH.j6(this);
    }

    private static void DW(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public tr j6() {
        return this.FH;
    }

    public yi$a j6(int i) {
        if (i >= 0 && i <= this.Hw) {
            return new yi$a(i, null);
        }
        throw new IllegalArgumentException("position=" + i + " length=" + this.Hw);
    }

    private static int Hw(int i) {
        return (i + 3) & -4;
    }

    public List<String> DW() {
        return this.v5;
    }

    public List<String> FH() {
        return this.VH;
    }

    public List<yq> Hw() {
        return this.gn;
    }

    public ys DW(int i) {
        if (i == 0) {
            return ys.j6;
        }
        return j6(i).tp();
    }

    public yf j6(yg ygVar) {
        int gn = ygVar.gn();
        if (gn != 0) {
            return j6(gn).rN();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public yh j6(yf$b yf_b) {
        int FH = yf_b.FH();
        if (FH != 0) {
            return j6(FH).lg();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    private static byte[] DW(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, length);
        return obj;
    }
}
