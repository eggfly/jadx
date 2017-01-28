import java.io.OutputStream;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

class auv extends OutputStream {
    private final byte[] DW;
    private int FH;
    private final OutputStream j6;

    auv(int i, int i2, OutputStream outputStream) {
        if (i <= 0 || i > 255) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().channelMustBeInRange0_255, new Object[]{Integer.valueOf(i)}));
        } else if (i2 <= 5) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().packetSizeMustBeAtLeast, new Object[]{Integer.valueOf(i2), Integer.valueOf(5)}));
        } else if (65520 < i2) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().packetSizeMustBeAtMost, new Object[]{Integer.valueOf(i2), Integer.valueOf(65520)}));
        } else {
            this.j6 = outputStream;
            this.DW = new byte[i2];
            this.DW[4] = (byte) i;
            this.FH = 5;
        }
    }

    void j6() {
        if (5 < this.FH) {
            DW();
        }
    }

    public void flush() {
        j6();
        this.j6.flush();
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int length = this.DW.length - this.FH;
            if (this.FH != 5 || length >= i2) {
                if (length == 0) {
                    DW();
                }
                length = Math.min(i2, length);
                System.arraycopy(bArr, i, this.DW, this.FH, length);
                this.FH += length;
                i += length;
                i2 -= length;
            } else {
                auf.j6(this.DW, this.DW.length);
                this.j6.write(this.DW, 0, 5);
                this.j6.write(bArr, i, length);
                i += length;
                i2 -= length;
            }
        }
    }

    public void write(int i) {
        if (this.FH == this.DW.length) {
            DW();
        }
        byte[] bArr = this.DW;
        int i2 = this.FH;
        this.FH = i2 + 1;
        bArr[i2] = (byte) i;
    }

    private void DW() {
        auf.j6(this.DW, this.FH);
        this.j6.write(this.DW, 0, this.FH);
        this.FH = 5;
    }
}
