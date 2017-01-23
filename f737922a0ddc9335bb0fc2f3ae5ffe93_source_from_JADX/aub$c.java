import java.io.InputStream;
import java.text.MessageFormat;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.JGitText;

class aub$c extends InputStream {
    private final Inflater DW;
    private final byte[] FH;
    private aub$e Hw;
    private int VH;
    private long Zo;
    final /* synthetic */ aub j6;
    private long v5;

    aub$c(aub aub) {
        this.j6 = aub;
        this.DW = ann.j6();
        this.FH = new byte[512];
    }

    void j6() {
        this.DW.reset();
        ann.j6(this.DW);
    }

    void j6(aub$e aub_e, long j) {
        this.Hw = aub_e;
        this.v5 = j;
        this.Zo = 0;
        this.VH = this.j6.j6(this.Hw, 1);
        this.DW.setInput(this.j6.gn, this.VH, this.j6.EQ);
    }

    public long skip(long j) {
        long j2 = 0;
        while (j2 < j) {
            int read = read(this.FH, 0, (int) Math.min((long) this.FH.length, j - j2));
            if (read <= 0) {
                break;
            }
            j2 += (long) read;
        }
        return j2;
    }

    public int read() {
        return read(this.FH, 0, 1) == 1 ? this.FH[0] & 255 : -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int inflate = this.DW.inflate(bArr, i + i3, i2 - i3);
            if (inflate != 0) {
                i3 += inflate;
            } else if (!this.DW.finished()) {
                if (this.DW.needsInput()) {
                    this.j6.DW(this.Hw, this.j6.gn, this.VH, this.j6.EQ);
                    this.j6.Hw(this.j6.EQ);
                    this.VH = this.j6.j6(this.Hw, 1);
                    this.DW.setInput(this.j6.gn, this.VH, this.j6.EQ);
                } else {
                    throw new ala(MessageFormat.format(JGitText.j6().packfileCorruptionDetected, new Object[]{JGitText.j6().unknownZlibError}));
                }
            }
        }
        try {
            break;
            this.Zo += (long) i3;
            if (i3 > 0) {
                return i3;
            }
            return -1;
        } catch (DataFormatException e) {
            throw new ala(MessageFormat.format(JGitText.j6().packfileCorruptionDetected, new Object[]{e.getMessage()}));
        }
    }

    public void close() {
        if (read(this.FH) == -1 && this.Zo == this.v5) {
            int DW = this.j6.EQ - this.DW.getRemaining();
            if (DW > 0) {
                this.j6.DW(this.Hw, this.j6.gn, this.VH, DW);
                this.j6.Hw(DW);
            }
            this.DW.reset();
            return;
        }
        throw new ala(MessageFormat.format(JGitText.j6().packfileCorruptionDetected, new Object[]{JGitText.j6().wrongDecompressedLength}));
    }
}
