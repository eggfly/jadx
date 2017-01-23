import com.aide.uidesigner.ProxyTextView;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class bag extends ayv {
    private static ayq[][] FH;
    private byte[] DW;
    String j6;

    public static ayq j6(Object obj) {
        if (obj == null || (obj instanceof ayq)) {
            return (ayq) obj;
        }
        if (obj instanceof bag) {
            return new ayq(((bag) obj).FH());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    bag(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        BigInteger bigInteger = null;
        long j = 0;
        int i = 0;
        while (i != bArr.length) {
            Object obj2;
            BigInteger bigInteger2;
            Object obj3;
            int i2 = bArr[i] & 255;
            if (j < 36028797018963968L) {
                j = (j * 128) + ((long) (i2 & 127));
                if ((i2 & 128) == 0) {
                    if (obj != null) {
                        switch (((int) j) / 40) {
                            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                                stringBuffer.append('0');
                                break;
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                                stringBuffer.append('1');
                                j -= 40;
                                break;
                            default:
                                stringBuffer.append('2');
                                j -= 80;
                                break;
                        }
                        obj = null;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j);
                    j = 0;
                    obj2 = obj;
                    bigInteger2 = bigInteger;
                    obj3 = obj2;
                }
                obj2 = obj;
                bigInteger2 = bigInteger;
                obj3 = obj2;
            } else {
                if (bigInteger == null) {
                    bigInteger = BigInteger.valueOf(j);
                }
                bigInteger = bigInteger.shiftLeft(7).or(BigInteger.valueOf((long) (i2 & 127)));
                if ((i2 & 128) == 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(bigInteger);
                    j = 0;
                    obj2 = obj;
                    bigInteger2 = null;
                    obj3 = obj2;
                }
                obj2 = obj;
                bigInteger2 = bigInteger;
                obj3 = obj2;
            }
            i++;
            obj2 = obj3;
            bigInteger = bigInteger2;
            obj = obj2;
        }
        this.j6 = stringBuffer.toString();
    }

    public bag(String str) {
        if (DW(str)) {
            this.j6 = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public String FH() {
        return this.j6;
    }

    private void j6(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    private void j6(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        int i;
        byte[] bArr = new byte[bitLength];
        for (i = bitLength - 1; i >= 0; i--) {
            bArr[i] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        i = bitLength - 1;
        bArr[i] = (byte) (bArr[i] & 127);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    private void j6(ByteArrayOutputStream byteArrayOutputStream) {
        bbf bbf = new bbf(this.j6);
        j6(byteArrayOutputStream, (long) ((Integer.parseInt(bbf.DW()) * 40) + Integer.parseInt(bbf.DW())));
        while (bbf.j6()) {
            String DW = bbf.DW();
            if (DW.length() < 18) {
                j6(byteArrayOutputStream, Long.parseLong(DW));
            } else {
                j6(byteArrayOutputStream, new BigInteger(DW));
            }
        }
    }

    protected byte[] Hw() {
        if (this.DW == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j6(byteArrayOutputStream);
            this.DW = byteArrayOutputStream.toByteArray();
        }
        return this.DW;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        int length = Hw().length;
        return length + (bbg.j6(length) + 1);
    }

    void j6(ayt ayt) {
        byte[] Hw = Hw();
        ayt.DW(6);
        ayt.j6(Hw.length);
        ayt.j6(Hw);
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    boolean j6(ayv ayv) {
        if (ayv instanceof bag) {
            return this.j6.equals(((bag) ayv).j6);
        }
        return false;
    }

    public String toString() {
        return FH();
    }

    private static boolean DW(String str) {
        if (str.length() < 3 || str.charAt(1) != '.') {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt < '0' || charAt > '2') {
            return false;
        }
        boolean z = false;
        for (int length = str.length() - 1; length >= 2; length--) {
            char charAt2 = str.charAt(length);
            if ('0' <= charAt2 && charAt2 <= '9') {
                z = true;
            } else if (charAt2 != '.' || !z) {
                return false;
            } else {
                z = false;
            }
        }
        return z;
    }

    static {
        FH = new ayq[255][];
    }

    static ayq DW(byte[] bArr) {
        if (bArr.length < 3) {
            return new ayq(bArr);
        }
        int i = bArr[bArr.length - 2] & 255;
        ayq[] ayqArr = FH[i];
        if (ayqArr == null) {
            ayqArr = new ayq[255];
            FH[i] = ayqArr;
        }
        int i2 = bArr[bArr.length - 1] & 255;
        ayq ayq = ayqArr[i2];
        if (ayq == null) {
            ayq = new ayq(bArr);
            ayqArr[i2] = ayq;
            return ayq;
        } else if (bhf.j6(bArr, ayq.Hw())) {
            return ayq;
        } else {
            int i3 = (i + 1) % 256;
            ayqArr = FH[i3];
            if (ayqArr == null) {
                ayqArr = new ayq[255];
                FH[i3] = ayqArr;
            }
            ayq = ayqArr[i2];
            if (ayq == null) {
                ayq = new ayq(bArr);
                ayqArr[i2] = ayq;
                return ayq;
            } else if (bhf.j6(bArr, ayq.Hw())) {
                return ayq;
            } else {
                i = (i2 + 1) % 256;
                ayq = ayqArr[i];
                if (ayq == null) {
                    ayq = new ayq(bArr);
                    ayqArr[i] = ayq;
                    return ayq;
                } else if (bhf.j6(bArr, ayq.Hw())) {
                    return ayq;
                } else {
                    return new ayq(bArr);
                }
            }
        }
    }
}
