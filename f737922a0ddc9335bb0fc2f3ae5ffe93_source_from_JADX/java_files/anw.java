import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public abstract class anw {
    private byte[] DW;
    private final MessageDigest j6;

    public abstract void FH();

    public abstract void Hw();

    public abstract ans j6(int i, long j, InputStream inputStream);

    public abstract aub j6(InputStream inputStream);

    protected anw() {
        this.j6 = anj.j6();
    }

    protected byte[] j6() {
        if (this.DW == null) {
            this.DW = new byte[8192];
        }
        return this.DW;
    }

    protected MessageDigest DW() {
        this.j6.reset();
        return this.j6;
    }

    public ans j6(int i, byte[] bArr) {
        return j6(i, bArr, 0, bArr.length);
    }

    public ans j6(int i, byte[] bArr, int i2, int i3) {
        MessageDigest DW = DW();
        DW.update(anj.DW(i));
        DW.update((byte) 32);
        DW.update(anj.j6((long) i3));
        DW.update((byte) 0);
        DW.update(bArr, i2, i3);
        return ans.j6(DW.digest());
    }

    public final ans j6(aoo aoo) {
        return aoo.j6(this);
    }

    public final ans j6(anh anh) {
        return DW(1, anh.VH());
    }

    public ans DW(int i, byte[] bArr) {
        return DW(i, bArr, 0, bArr.length);
    }

    public ans DW(int i, byte[] bArr, int i2, int i3) {
        return j6(i, (long) i3, new ByteArrayInputStream(bArr, i2, i3));
    }
}
