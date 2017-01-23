import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class azs extends ayv {
    private final int DW;
    private final byte[] FH;
    private final boolean j6;

    azs(boolean z, int i, byte[] bArr) {
        this.j6 = z;
        this.DW = i;
        this.FH = bArr;
    }

    public azs(int i, ayi ayi) {
        this.DW = i;
        this.j6 = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 != ayi.j6()) {
            try {
                byteArrayOutputStream.write(((ayp) ayi.j6(i2)).j6("DER"));
                i2++;
            } catch (Throwable e) {
                throw new ayu("malformed object: " + e, e);
            }
        }
        this.FH = byteArrayOutputStream.toByteArray();
    }

    public boolean gn() {
        return this.j6;
    }

    public byte[] FH() {
        return this.FH;
    }

    public int Hw() {
        return this.DW;
    }

    public ayv j6(int i) {
        if (i >= 31) {
            throw new IOException("unsupported tag number");
        }
        byte[] DW = DW();
        byte[] j6 = j6(i, DW);
        if ((DW[0] & 32) != 0) {
            j6[0] = (byte) (j6[0] | 32);
        }
        return new aym(j6).Hw();
    }

    int u7() {
        return (bbg.DW(this.DW) + bbg.j6(this.FH.length)) + this.FH.length;
    }

    void j6(ayt ayt) {
        int i = 64;
        if (this.j6) {
            i = 96;
        }
        ayt.j6(i, this.DW, this.FH);
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof azs)) {
            return false;
        }
        azs azs = (azs) ayv;
        if (this.j6 == azs.j6 && this.DW == azs.DW && bhf.j6(this.FH, azs.FH)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.j6 ? 1 : 0) ^ this.DW) ^ bhf.j6(this.FH);
    }

    private byte[] j6(int i, byte[] bArr) {
        int i2;
        if ((bArr[0] & 31) == 31) {
            i2 = bArr[1] & 255;
            if ((i2 & 127) == 0) {
                throw new ayu("corrupted stream - invalid high tag number found");
            }
            int i3 = 0;
            int i4 = i2;
            i2 = 2;
            while (i4 >= 0 && (i4 & 128) != 0) {
                i3 = ((i4 & 127) | i3) << 7;
                int i5 = bArr[i2] & 255;
                i2++;
                i4 = i5;
            }
            i4 = (i4 & 127) | i3;
        } else {
            i2 = 1;
        }
        Object obj = new byte[((bArr.length - i2) + 1)];
        System.arraycopy(bArr, i2, obj, 1, obj.length - 1);
        obj[0] = (byte) i;
        return obj;
    }
}
