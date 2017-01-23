public final class agm implements ago {
    private long DW;
    private long j6;

    public agm() {
        this.j6 = 1;
        this.DW = 0;
    }

    public void j6(long j) {
        this.j6 = j & 65535;
        this.DW = (j >> 16) & 65535;
    }

    public void j6() {
        this.j6 = 1;
        this.DW = 0;
    }

    public long DW() {
        return (this.DW << 16) | this.j6;
    }

    public void j6(byte[] bArr, int i, int i2) {
        if (i2 == 1) {
            int i3 = i + 1;
            this.j6 += (long) (bArr[i] & 255);
            this.DW += this.j6;
            this.j6 %= 65521;
            this.DW %= 65521;
            return;
        }
        int i4 = i2 % 5552;
        i3 = i2 / 5552;
        int i5 = i;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            i2 -= 5552;
            int i7 = i5;
            i5 = 5552;
            while (true) {
                i3 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                i5 = i7 + 1;
                this.j6 += (long) (bArr[i7] & 255);
                this.DW += this.j6;
                i7 = i5;
                i5 = i3;
            }
            this.j6 %= 65521;
            this.DW %= 65521;
            i3 = i6;
            i5 = i7;
        }
        i3 = i2 - i4;
        i3 = i5;
        while (true) {
            i5 = i4 - 1;
            if (i4 <= 0) {
                this.j6 %= 65521;
                this.DW %= 65521;
                return;
            }
            i4 = i3 + 1;
            this.j6 = ((long) (bArr[i3] & 255)) + this.j6;
            this.DW += this.j6;
            i3 = i4;
            i4 = i5;
        }
    }
}
