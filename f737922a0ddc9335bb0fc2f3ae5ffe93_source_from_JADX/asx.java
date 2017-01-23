import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.zip.CRC32;
import org.eclipse.jgit.JGitText;

public final class asx extends OutputStream {
    private final OutputStream DW;
    private final asy FH;
    private final CRC32 Hw;
    private byte[] VH;
    private long Zo;
    private byte[] gn;
    private final aob j6;
    private long u7;
    private final MessageDigest v5;

    public asx(aob aob, OutputStream outputStream, asy asy) {
        this.Hw = new CRC32();
        this.v5 = anj.j6();
        this.VH = new byte[32];
        this.j6 = aob;
        this.DW = outputStream;
        this.FH = asy;
        this.u7 = 131072;
    }

    public void write(int i) {
        this.Zo++;
        this.DW.write(i);
        this.Hw.update(i);
        this.v5.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int min = Math.min(i2, 131072);
            this.Zo += (long) min;
            if (this.u7 <= this.Zo) {
                if (this.j6.j6()) {
                    throw new IOException(JGitText.j6().packingCancelledDuringObjectsWriting);
                }
                this.u7 = this.Zo + 131072;
            }
            this.DW.write(bArr, i, min);
            this.Hw.update(bArr, i, min);
            this.v5.update(bArr, i, min);
            i += min;
            i2 -= min;
        }
    }

    public void flush() {
        this.DW.flush();
    }

    void j6(int i, long j) {
        System.arraycopy(anj.j6, 0, this.VH, 0, 4);
        axb.DW(this.VH, 4, i);
        axb.DW(this.VH, 8, (int) j);
        write(this.VH, 0, 12);
    }

    public void j6(asv asv) {
        this.FH.j6(this, asv);
    }

    public void j6(asv asv, long j) {
        if (asv.we()) {
            if (this.FH.j6()) {
                asv u7 = asv.u7();
                if (u7 != null && u7.J0()) {
                    long j2 = this.Zo;
                    write(this.VH, 0, DW(6, j));
                    long yS = j2 - u7.yS();
                    int length = this.VH.length - 1;
                    this.VH[length] = (byte) ((int) (yS & 127));
                    while (true) {
                        yS >>= 7;
                        if (yS <= 0) {
                            write(this.VH, length, this.VH.length - length);
                            return;
                        }
                        length--;
                        yS--;
                        this.VH[length] = (byte) ((int) (128 | (yS & 127)));
                    }
                }
            }
            int DW = DW(7, j);
            asv.gn().DW(this.VH, DW);
            write(this.VH, 0, DW + 20);
            return;
        }
        write(this.VH, 0, DW(asv.J8(), j));
    }

    private int DW(int i, long j) {
        long j2 = j >>> 4;
        this.VH[0] = (byte) ((int) (((long) ((j2 > 0 ? 128 : 0) | (i << 4))) | (15 & j)));
        int i2 = 1;
        long j3 = j2;
        while (j3 > 0) {
            long j4 = j2 >>> 7;
            int i3 = i2 + 1;
            this.VH[i2] = (byte) ((int) ((j3 & 127) | ((long) (j4 > 0 ? 128 : 0))));
            i2 = i3;
            j3 = j4;
            j2 = j4;
        }
        return i2;
    }

    public byte[] j6() {
        if (this.gn == null) {
            this.gn = new byte[16384];
        }
        return this.gn;
    }

    void DW() {
        this.j6.j6(1);
    }

    public long FH() {
        return this.Zo;
    }

    int Hw() {
        return (int) this.Hw.getValue();
    }

    void v5() {
        this.Hw.reset();
    }

    byte[] Zo() {
        return this.v5.digest();
    }
}
