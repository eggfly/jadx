import com.aide.uidesigner.ProxyTextView;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.JGitText;

public class akt {
    private static final byte[] DW;
    private final byte[] FH;
    private final int Hw;
    final byte[] j6;
    private byte v5;

    static {
        DW = new byte[8];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    akt(byte[] r8, axa r9, java.io.InputStream r10, java.security.MessageDigest r11) {
        /*
        r7 = this;
        r0 = 62;
        r1 = 1;
        r6 = 4095; // 0xfff float:5.738E-42 double:2.023E-320;
        r2 = 0;
        r7.<init>();
        r7.FH = r8;
        r3 = r9.j6;
        r7.Hw = r3;
        r3 = r7.FH;
        r4 = r7.Hw;
        awx.j6(r10, r3, r4, r0);
        r3 = r7.Ws();
        if (r3 == 0) goto L_0x004e;
    L_0x001c:
        r0 = 64;
        r3 = r7.FH;
        r4 = r7.Hw;
        r4 = r4 + 62;
        r5 = 2;
        awx.j6(r10, r3, r4, r5);
        r3 = r7.QX();
        r4 = -1610612737; // 0xffffffff9fffffff float:-1.0842021E-19 double:NaN;
        r3 = r3 & r4;
        if (r3 == 0) goto L_0x004e;
    L_0x0032:
        r0 = new java.io.IOException;
        r3 = org.eclipse.jgit.JGitText.j6();
        r3 = r3.DIRCUnrecognizedExtendedFlags;
        r1 = new java.lang.Object[r1];
        r4 = r7.QX();
        r4 = java.lang.String.valueOf(r4);
        r1[r2] = r4;
        r1 = java.text.MessageFormat.format(r3, r1);
        r0.<init>(r1);
        throw r0;
    L_0x004e:
        r3 = r9.j6;
        r3 = r3 + r0;
        r9.j6 = r3;
        r3 = r7.FH;
        r4 = r7.Hw;
        r11.update(r3, r4, r0);
        r3 = r7.FH;
        r4 = r7.Hw;
        r4 = r4 + 60;
        r3 = axb.j6(r3, r4);
        r3 = r3 & 4095;
        if (r3 >= r6) goto L_0x008b;
    L_0x0068:
        r1 = new byte[r3];
        r7.j6 = r1;
        r1 = r7.j6;
        awx.j6(r10, r1, r2, r3);
        r1 = r7.j6;
        r11.update(r1, r2, r3);
        r1 = r2;
    L_0x0077:
        r0 = r0 + r3;
        r3 = r0 + 8;
        r3 = r3 & -8;
        r0 = r3 - r0;
        r0 = r0 - r1;
        if (r0 <= 0) goto L_0x008a;
    L_0x0081:
        r4 = (long) r0;
        awx.j6(r10, r4);
        r1 = DW;
        r11.update(r1, r2, r0);
    L_0x008a:
        return;
    L_0x008b:
        r3 = new java.io.ByteArrayOutputStream;
        r3.<init>();
        r4 = new byte[r6];
        awx.j6(r10, r4, r2, r6);
        r3.write(r4);
    L_0x0098:
        r4 = r10.read();
        if (r4 >= 0) goto L_0x00aa;
    L_0x009e:
        r0 = new java.io.EOFException;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.shortReadOfBlock;
        r0.<init>(r1);
        throw r0;
    L_0x00aa:
        if (r4 != 0) goto L_0x00be;
    L_0x00ac:
        r3 = r3.toByteArray();
        r7.j6 = r3;
        r3 = r7.j6;
        r3 = r3.length;
        r4 = r7.j6;
        r11.update(r4, r2, r3);
        r11.update(r2);
        goto L_0x0077;
    L_0x00be:
        r3.write(r4);
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: akt.<init>(byte[], axa, java.io.InputStream, java.security.MessageDigest):void");
    }

    public akt(String str) {
        this(anj.DW(str));
    }

    public akt(String str, int i) {
        this(anj.DW(str), i);
    }

    public akt(byte[] bArr) {
        this(bArr, 0);
    }

    public akt(byte[] bArr, int i) {
        if (!j6(bArr)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidPath, new Object[]{DW(bArr)}));
        } else if (i < 0 || 3 < i) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidStageForPath, new Object[]{Integer.valueOf(i), DW(bArr)}));
        } else {
            this.FH = new byte[62];
            this.Hw = 0;
            this.j6 = bArr;
            int i2 = (i & 3) << 12;
            if (this.j6.length < 4095) {
                i2 |= this.j6.length;
            } else {
                i2 |= 4095;
            }
            axb.j6(this.FH, this.Hw + 60, i2);
        }
    }

    void j6(OutputStream outputStream) {
        int i = Ws() ? 64 : 62;
        int length = this.j6.length;
        outputStream.write(this.FH, this.Hw, i);
        outputStream.write(this.j6, 0, length);
        i += length;
        length = (i + 8) & -8;
        if (i != length) {
            outputStream.write(DW, 0, length - i);
        }
    }

    public final boolean j6(int i, int i2) {
        int i3 = this.Hw + 8;
        if (i != axb.DW(this.FH, i3) || i2 > axb.DW(this.FH, i3 + 4)) {
            return false;
        }
        return true;
    }

    public final void j6() {
        int i = this.Hw + 36;
        Arrays.fill(this.FH, i, i + 4, (byte) 0);
    }

    public final boolean DW() {
        return we() == 0 && anj.FH.j6(this.FH, this.Hw + 40) != 0;
    }

    final byte[] FH() {
        return this.FH;
    }

    final int Hw() {
        return this.Hw + 40;
    }

    public boolean v5() {
        return (this.FH[this.Hw + 60] & 128) != 0;
    }

    public boolean Zo() {
        return (this.v5 & 1) != 0;
    }

    public int VH() {
        return (this.FH[this.Hw + 60] >>> 4) & 3;
    }

    public boolean gn() {
        return (QX() & 1073741824) != 0;
    }

    public int u7() {
        return axb.DW(this.FH, this.Hw + 24);
    }

    public anl tp() {
        return anl.j6(u7());
    }

    public void j6(anl anl) {
        switch (anl.FH() & 61440) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case 16384:
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidModeForPath, new Object[]{anl, J8()}));
            default:
                axb.DW(this.FH, this.Hw + 24, anl.FH());
        }
    }

    public long EQ() {
        return DW(8);
    }

    public void j6(long j) {
        j6(8, j);
    }

    public int we() {
        return axb.DW(this.FH, this.Hw + 36);
    }

    public void j6(int i) {
        axb.DW(this.FH, this.Hw + 36, i);
    }

    public void DW(long j) {
        if (2147483647L <= j) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().sizeExceeds2GB, new Object[]{J8(), Long.valueOf(j)}));
        }
        j6((int) j);
    }

    public ans J0() {
        return ans.Hw(FH(), Hw());
    }

    public void j6(anb anb) {
        anb.DW(FH(), Hw());
    }

    public void j6(byte[] bArr, int i) {
        System.arraycopy(bArr, i, FH(), Hw(), 20);
    }

    public String J8() {
        return DW(this.j6);
    }

    public String toString() {
        return tp() + " " + we() + " " + EQ() + " " + J0() + " " + VH() + " " + J8() + "\n";
    }

    public void j6(akt akt) {
        int j6 = axb.j6(this.FH, this.Hw + 60) & 4095;
        System.arraycopy(akt.FH, akt.Hw, this.FH, this.Hw, 62);
        axb.j6(this.FH, this.Hw + 60, j6 | (axb.j6(this.FH, this.Hw + 60) & -4096));
    }

    boolean Ws() {
        return (this.FH[this.Hw + 60] & 64) != 0;
    }

    private long DW(int i) {
        int i2 = this.Hw + i;
        int DW = axb.DW(this.FH, i2);
        return ((long) (axb.DW(this.FH, i2 + 4) / 1000000)) + (1000 * ((long) DW));
    }

    private void j6(int i, long j) {
        int i2 = this.Hw + i;
        axb.DW(this.FH, i2, (int) (j / 1000));
        axb.DW(this.FH, i2 + 4, ((int) (j % 1000)) * 1000000);
    }

    private int QX() {
        if (Ws()) {
            return axb.j6(this.FH, this.Hw + 62) << 16;
        }
        return 0;
    }

    private static String DW(byte[] bArr) {
        return anj.DW.decode(ByteBuffer.wrap(bArr)).toString();
    }

    static boolean j6(byte[] bArr) {
        if (bArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (byte b : bArr) {
            switch (b) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    return false;
                case (byte) 47:
                    if (z) {
                        z = false;
                        break;
                    }
                    return false;
                default:
                    z = true;
                    break;
            }
        }
        return z;
    }

    static int j6(boolean z) {
        return z ? 64 : 62;
    }
}
