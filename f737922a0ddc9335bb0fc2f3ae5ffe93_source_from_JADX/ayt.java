import java.io.IOException;
import java.io.OutputStream;

public class ayt {
    private OutputStream j6;

    public ayt(OutputStream outputStream) {
        this.j6 = outputStream;
    }

    void j6(int i) {
        if (i > 127) {
            int i2 = 1;
            int i3 = i;
            while (true) {
                i3 >>>= 8;
                if (i3 == 0) {
                    break;
                }
                i2++;
            }
            DW((byte) (i2 | 128));
            for (i3 = (i2 - 1) * 8; i3 >= 0; i3 -= 8) {
                DW((byte) (i >> i3));
            }
            return;
        }
        DW((byte) i);
    }

    void DW(int i) {
        this.j6.write(i);
    }

    void j6(byte[] bArr) {
        this.j6.write(bArr);
    }

    void j6(byte[] bArr, int i, int i2) {
        this.j6.write(bArr, i, i2);
    }

    void j6(int i, byte[] bArr) {
        DW(i);
        j6(bArr.length);
        j6(bArr);
    }

    void j6(int i, int i2) {
        if (i2 < 31) {
            DW(i | i2);
            return;
        }
        DW(i | 31);
        if (i2 < 128) {
            DW(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int length = bArr.length - 1;
        bArr[length] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            length--;
            bArr[length] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        j6(bArr, length, bArr.length - length);
    }

    void j6(int i, int i2, byte[] bArr) {
        j6(i, i2);
        j6(bArr.length);
        j6(bArr);
    }

    public void j6(ayh ayh) {
        if (ayh != null) {
            ayh.w_().j6(this);
            return;
        }
        throw new IOException("null object detected");
    }

    void j6(ayv ayv) {
        if (ayv != null) {
            ayv.j6(new ayt$a(this, this.j6));
            return;
        }
        throw new IOException("null object detected");
    }

    ayt j6() {
        return new baj(this.j6);
    }

    ayt DW() {
        return new bav(this.j6);
    }
}
