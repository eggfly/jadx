import com.aide.uidesigner.ProxyTextView;
import java.io.EOFException;
import java.io.InputStream;
import org.eclipse.jgit.JGitText;

public abstract class asp extends InputStream {
    private long DW;
    private int EQ;
    private long FH;
    private final byte[] Hw;
    private InputStream VH;
    private int Zo;
    private long gn;
    private final InputStream j6;
    private long tp;
    private int u7;
    private int v5;

    protected abstract long DW();

    protected abstract InputStream j6();

    public asp(InputStream inputStream) {
        int i = 0;
        this.Hw = new byte[512];
        this.j6 = inputStream;
        if (j6(this.Hw.length)) {
            int i2;
            int i3 = 0;
            do {
                byte[] bArr = this.Hw;
                int i4 = this.v5;
                this.v5 = i4 + 1;
                i2 = bArr[i4] & 255;
                this.DW |= (long) ((i2 & 127) << i3);
                i3 += 7;
            } while ((i2 & 128) != 0);
            do {
                byte[] bArr2 = this.Hw;
                i2 = this.v5;
                this.v5 = i2 + 1;
                i3 = bArr2[i2] & 255;
                this.FH |= (long) ((i3 & 127) << i);
                i += 7;
            } while ((i3 & 128) != 0);
            this.u7 = Hw();
            return;
        }
        throw new EOFException();
    }

    public long FH() {
        return this.FH;
    }

    public int read() {
        byte[] bArr = new byte[1];
        return read(bArr, 0, 1) == 1 ? bArr[0] & 255 : -1;
    }

    public void close() {
        this.j6.close();
        if (this.VH != null) {
            this.VH.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long skip(long r10) {
        /*
        r9 = this;
        r2 = 0;
        r0 = r2;
    L_0x0003:
        r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r4 < 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r4 = r9.EQ;
        r4 = (long) r4;
        r4 = java.lang.Math.min(r10, r4);
        r6 = r9.u7;
        switch(r6) {
            case 0: goto L_0x0020;
            case 1: goto L_0x003a;
            case 2: goto L_0x0007;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = new ala;
        r1 = org.eclipse.jgit.JGitText.j6();
        r1 = r1.unsupportedCommand0;
        r0.<init>(r1);
        throw r0;
    L_0x0020:
        r6 = r9.tp;
        r6 = r6 + r4;
        r9.tp = r6;
    L_0x0025:
        r0 = r0 + r4;
        r10 = r10 - r4;
        r6 = r9.EQ;
        r6 = (long) r6;
        r4 = r6 - r4;
        r4 = (int) r4;
        r9.EQ = r4;
        r4 = r9.EQ;
        if (r4 != 0) goto L_0x0003;
    L_0x0033:
        r4 = r9.Hw();
        r9.u7 = r4;
        goto L_0x0003;
    L_0x003a:
        r6 = r9.v5;
        r6 = (long) r6;
        r6 = r6 + r4;
        r6 = (int) r6;
        r9.v5 = r6;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: asp.skip(long):long");
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > 0) {
            int min = Math.min(i2, this.EQ);
            switch (this.u7) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    Zo();
                    min = this.VH.read(bArr, i, min);
                    if (min >= 0) {
                        this.tp += (long) min;
                        this.gn = this.tp;
                        break;
                    }
                    throw new ala(JGitText.j6().baseLengthIncorrect);
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    System.arraycopy(this.Hw, this.v5, bArr, i, min);
                    this.v5 += min;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    if (i3 <= 0) {
                        return -1;
                    }
                    return i3;
                default:
                    throw new ala(JGitText.j6().unsupportedCommand0);
            }
            i3 += min;
            i += min;
            i2 -= min;
            this.EQ -= min;
            if (this.EQ == 0) {
                this.u7 = Hw();
            }
        }
        return i3;
    }

    private boolean j6(int i) {
        int v5 = v5();
        if (i < v5) {
            return true;
        }
        if (v5 == 0) {
            this.v5 = 0;
            this.Zo = 0;
        } else if (this.Hw.length - this.v5 < i) {
            System.arraycopy(this.Hw, this.v5, this.Hw, 0, v5);
            this.v5 = 0;
            this.Zo = v5;
        }
        do {
            v5 = this.j6.read(this.Hw, this.Zo, this.Hw.length - this.Zo);
            if (v5 >= 0) {
                this.Zo = v5 + this.Zo;
            } else if (v5() <= 0) {
                return false;
            } else {
                return true;
            }
        } while (this.Zo < this.Hw.length);
        return true;
    }

    private int Hw() {
        if (!j6(8)) {
            return 2;
        }
        byte[] bArr = this.Hw;
        int i = this.v5;
        this.v5 = i + 1;
        int i2 = bArr[i] & 255;
        if ((i2 & 128) != 0) {
            byte[] bArr2;
            int i3;
            long j;
            byte[] bArr3;
            int i4;
            this.tp = 0;
            if ((i2 & 1) != 0) {
                bArr2 = this.Hw;
                i3 = this.v5;
                this.v5 = i3 + 1;
                this.tp = (long) (bArr2[i3] & 255);
            }
            if ((i2 & 2) != 0) {
                j = this.tp;
                bArr3 = this.Hw;
                i4 = this.v5;
                this.v5 = i4 + 1;
                this.tp = j | ((long) ((bArr3[i4] & 255) << 8));
            }
            if ((i2 & 4) != 0) {
                j = this.tp;
                bArr3 = this.Hw;
                i4 = this.v5;
                this.v5 = i4 + 1;
                this.tp = j | ((long) ((bArr3[i4] & 255) << 16));
            }
            if ((i2 & 8) != 0) {
                j = this.tp;
                bArr3 = this.Hw;
                i4 = this.v5;
                this.v5 = i4 + 1;
                this.tp = j | ((long) ((bArr3[i4] & 255) << 24));
            }
            this.EQ = 0;
            if ((i2 & 16) != 0) {
                bArr2 = this.Hw;
                i3 = this.v5;
                this.v5 = i3 + 1;
                this.EQ = bArr2[i3] & 255;
            }
            if ((i2 & 32) != 0) {
                i = this.EQ;
                byte[] bArr4 = this.Hw;
                int i5 = this.v5;
                this.v5 = i5 + 1;
                this.EQ = i | ((bArr4[i5] & 255) << 8);
            }
            if ((i2 & 64) != 0) {
                i2 = this.EQ;
                bArr2 = this.Hw;
                i3 = this.v5;
                this.v5 = i3 + 1;
                this.EQ = i2 | ((bArr2[i3] & 255) << 16);
            }
            if (this.EQ != 0) {
                return 0;
            }
            this.EQ = 65536;
            return 0;
        } else if (i2 != 0) {
            j6(i2);
            this.EQ = i2;
            return 1;
        } else {
            throw new ala(JGitText.j6().unsupportedCommand0);
        }
    }

    private int v5() {
        return this.Zo - this.v5;
    }

    private void Zo() {
        if (this.VH == null) {
            this.VH = j6();
            if (DW() != this.DW) {
                throw new ala(JGitText.j6().baseLengthIncorrect);
            }
            awx.j6(this.VH, this.tp);
            this.gn = this.tp;
        } else if (this.gn < this.tp) {
            awx.j6(this.VH, this.tp - this.gn);
            this.gn = this.tp;
        } else if (this.gn > this.tp) {
            this.VH.close();
            this.VH = j6();
            awx.j6(this.VH, this.tp);
            this.gn = this.tp;
        }
    }
}
