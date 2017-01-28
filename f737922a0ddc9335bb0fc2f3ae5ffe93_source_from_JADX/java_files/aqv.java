import java.security.MessageDigest;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

final class aqv extends aqx {
    private final byte[] Hw;

    aqv(aro aro, long j, byte[] bArr) {
        super(aro, j, bArr.length);
        this.Hw = bArr;
    }

    protected int j6(int i, byte[] bArr, int i2, int i3) {
        int min = Math.min(this.Hw.length - i, i3);
        System.arraycopy(this.Hw, i, bArr, i2, min);
        return min;
    }

    protected int j6(int i, Inflater inflater) {
        int length = this.Hw.length - i;
        inflater.setInput(this.Hw, i, length);
        return length;
    }

    void j6(CRC32 crc32, long j, int i) {
        crc32.update(this.Hw, (int) (j - this.DW), i);
    }

    void j6(asx asx, long j, int i, MessageDigest messageDigest) {
        int i2 = (int) (j - this.DW);
        asx.write(this.Hw, i2, i);
        if (messageDigest != null) {
            messageDigest.update(this.Hw, i2, i);
        }
    }

    void j6(Inflater inflater, byte[] bArr, long j, int i) {
        inflater.setInput(this.Hw, (int) (j - this.DW), i);
        do {
        } while (inflater.inflate(bArr, 0, bArr.length) > 0);
    }
}
