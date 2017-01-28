import org.eclipse.jgit.JGitText;

public class asj {
    public static long j6(byte[] bArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3 + 1;
            if (((bArr[i3] & 255) & 128) == 0) {
                break;
            }
            i3 = i;
        }
        i3 = i;
        long j = 0;
        while (true) {
            int i4 = i3 + 1;
            i3 = bArr[i3] & 255;
            j |= (long) ((i3 & 127) << i2);
            i2 += 7;
            if ((i3 & 128) == 0) {
                return j;
            }
            i3 = i4;
        }
    }

    public static final byte[] j6(byte[] bArr, byte[] bArr2) {
        return j6(bArr, bArr2, null);
    }

    public static final byte[] j6(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            i3 = bArr2[i3] & 255;
            i2 |= (i3 & 127) << i;
            i += 7;
            if ((i3 & 128) == 0) {
                break;
            }
            i3 = i4;
        }
        if (bArr.length != i2) {
            throw new IllegalArgumentException(JGitText.j6().baseLengthIncorrect);
        }
        i = 0;
        i2 = 0;
        while (true) {
            i3 = i4 + 1;
            i4 = bArr2[i4] & 255;
            i |= (i4 & 127) << i2;
            i2 += 7;
            if ((i4 & 128) == 0) {
                break;
            }
            i4 = i3;
        }
        if (bArr3 == null) {
            bArr3 = new byte[i];
        } else if (bArr3.length != i) {
            throw new IllegalArgumentException(JGitText.j6().resultLengthIncorrect);
        }
        i = 0;
        while (i3 < bArr2.length) {
            i2 = i3 + 1;
            int i5 = bArr2[i3] & 255;
            if ((i5 & 128) != 0) {
                int i6;
                if ((i5 & 1) != 0) {
                    i4 = i2 + 1;
                    i2 = bArr2[i2] & 255;
                } else {
                    i4 = i2;
                    i2 = 0;
                }
                if ((i5 & 2) != 0) {
                    i3 = i4 + 1;
                    i2 |= (bArr2[i4] & 255) << 8;
                } else {
                    i3 = i4;
                }
                if ((i5 & 4) != 0) {
                    i4 = i3 + 1;
                    i2 |= (bArr2[i3] & 255) << 16;
                } else {
                    i4 = i3;
                }
                if ((i5 & 8) != 0) {
                    i6 = i2 | ((bArr2[i4] & 255) << 24);
                    i2 = i4 + 1;
                } else {
                    i6 = i2;
                    i2 = i4;
                }
                if ((i5 & 16) != 0) {
                    i3 = i2 + 1;
                    i2 = bArr2[i2] & 255;
                } else {
                    i3 = i2;
                    i2 = 0;
                }
                if ((i5 & 32) != 0) {
                    i4 = i3 + 1;
                    i2 |= (bArr2[i3] & 255) << 8;
                } else {
                    i4 = i3;
                }
                if ((i5 & 64) != 0) {
                    i3 = i4 + 1;
                    i2 |= (bArr2[i4] & 255) << 16;
                } else {
                    i3 = i4;
                }
                if (i2 == 0) {
                    i2 = 65536;
                }
                System.arraycopy(bArr, i6, bArr3, i, i2);
                i += i2;
            } else if (i5 != 0) {
                System.arraycopy(bArr2, i2, bArr3, i, i5);
                i3 = i2 + i5;
                i += i5;
            } else {
                throw new IllegalArgumentException(JGitText.j6().unsupportedCommand0);
            }
        }
        return bArr3;
    }
}
