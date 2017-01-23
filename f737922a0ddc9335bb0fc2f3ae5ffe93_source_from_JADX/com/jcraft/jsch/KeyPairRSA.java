package com.jcraft.jsch;

import java.math.BigInteger;

public class KeyPairRSA extends KeyPair {
    private static final byte[] QX;
    private static final byte[] XL;
    private static final byte[] aM;
    private byte[] EQ;
    private byte[] J0;
    private byte[] J8;
    private byte[] VH;
    private int Ws;
    private byte[] gn;
    private byte[] tp;
    private byte[] u7;
    private byte[] we;

    public KeyPairRSA(JSch jSch) {
        this(jSch, null, null, null);
    }

    public KeyPairRSA(JSch jSch, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(jSch);
        this.Ws = 1024;
        this.VH = bArr;
        this.gn = bArr2;
        this.u7 = bArr3;
        if (bArr != null) {
            this.Ws = new BigInteger(bArr).bitLength();
        }
    }

    static {
        QX = Util.DW("-----BEGIN RSA PRIVATE KEY-----");
        XL = Util.DW("-----END RSA PRIVATE KEY-----");
        aM = Util.DW("ssh-rsa");
    }

    byte[] DW() {
        int j6 = (((((((((((((((((((((((((j6(1) + 1) + 1) + 1) + j6(this.VH.length)) + this.VH.length) + 1) + j6(this.gn.length)) + this.gn.length) + 1) + j6(this.u7.length)) + this.u7.length) + 1) + j6(this.tp.length)) + this.tp.length) + 1) + j6(this.EQ.length)) + this.EQ.length) + 1) + j6(this.we.length)) + this.we.length) + 1) + j6(this.J0.length)) + this.J0.length) + 1) + j6(this.J8.length)) + this.J8.length;
        byte[] bArr = new byte[((j6(j6) + 1) + j6)];
        j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, 0, j6), new byte[1]), this.VH), this.gn), this.u7), this.tp), this.EQ), this.we), this.J0), this.J8);
        return bArr;
    }

    boolean DW(byte[] bArr) {
        try {
            Buffer buffer;
            if (this.j6 == 2) {
                buffer = new Buffer(bArr);
                buffer.DW(bArr.length);
                try {
                    byte[][] j6 = buffer.j6(4, "");
                    this.u7 = j6[0];
                    this.tp = j6[1];
                    this.EQ = j6[2];
                    this.J8 = j6[3];
                    VH();
                    gn();
                    return true;
                } catch (JSchException e) {
                    return false;
                }
            } else if (this.j6 != 1) {
                int i;
                int i2;
                int i3 = bArr[1] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    int i4 = 0;
                    i3 = 2;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i4 = (bArr[i3] & 255) + (i4 << 8);
                        i3++;
                        i = i2;
                    }
                } else {
                    i3 = 2;
                }
                if (bArr[i3] != (byte) 2) {
                    return false;
                }
                i3++;
                int i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.VH = new byte[i3];
                System.arraycopy(bArr, i5, this.VH, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.gn = new byte[i3];
                System.arraycopy(bArr, i5, this.gn, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.u7 = new byte[i3];
                System.arraycopy(bArr, i5, this.u7, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.tp = new byte[i3];
                System.arraycopy(bArr, i5, this.tp, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.EQ = new byte[i3];
                System.arraycopy(bArr, i5, this.EQ, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.we = new byte[i3];
                System.arraycopy(bArr, i5, this.we, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.J0 = new byte[i3];
                System.arraycopy(bArr, i5, this.J0, 0, i3);
                i3 = (i3 + i5) + 1;
                i5 = i3 + 1;
                i3 = bArr[i3] & 255;
                if ((i3 & 128) != 0) {
                    i = i3 & 127;
                    i3 = 0;
                    while (true) {
                        i2 = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        i3 = (i3 << 8) + (bArr[i5] & 255);
                        i5++;
                        i = i2;
                    }
                }
                this.J8 = new byte[i3];
                System.arraycopy(bArr, i5, this.J8, 0, i3);
                i3 += i5;
                if (this.VH == null) {
                    return true;
                }
                this.Ws = new BigInteger(this.VH).bitLength();
                return true;
            } else if (bArr[0] == 48) {
                return false;
            } else {
                buffer = new Buffer(bArr);
                this.gn = buffer.u7();
                this.u7 = buffer.u7();
                this.VH = buffer.u7();
                buffer.u7();
                this.tp = buffer.u7();
                this.EQ = buffer.u7();
                if (this.VH != null) {
                    this.Ws = new BigInteger(this.VH).bitLength();
                }
                VH();
                gn();
                u7();
                return true;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public byte[] Hw() {
        byte[] Hw = super.Hw();
        if (Hw != null) {
            return Hw;
        }
        if (this.gn == null) {
            return null;
        }
        return Buffer.j6(new byte[][]{aM, this.gn, this.VH}).DW;
    }

    byte[] FH() {
        return aM;
    }

    public byte[] j6(byte[] bArr) {
        try {
            SignatureRSA signatureRSA = (SignatureRSA) Class.forName(JSch.DW("signature.rsa")).newInstance();
            signatureRSA.j6();
            signatureRSA.DW(this.u7, this.VH);
            signatureRSA.j6(bArr);
            byte[] DW = signatureRSA.DW();
            return Buffer.j6(new byte[][]{aM, DW}).DW;
        } catch (Exception e) {
            return null;
        }
    }

    static KeyPair j6(JSch jSch, Buffer buffer) {
        byte[][] j6 = buffer.j6(8, "invalid key format");
        KeyPair keyPairRSA = new KeyPairRSA(jSch, j6[1], j6[2], j6[3]);
        keyPairRSA.J8 = j6[4];
        keyPairRSA.tp = j6[5];
        keyPairRSA.EQ = j6[6];
        keyPairRSA.DW = new String(j6[7]);
        keyPairRSA.j6 = 0;
        return keyPairRSA;
    }

    public byte[] j6() {
        if (v5()) {
            throw new JSchException("key is encrypted.");
        }
        Buffer buffer = new Buffer();
        buffer.DW(aM);
        buffer.DW(this.VH);
        buffer.DW(this.gn);
        buffer.DW(this.u7);
        buffer.DW(u7());
        buffer.DW(this.tp);
        buffer.DW(this.EQ);
        buffer.DW(Util.DW(this.DW));
        byte[] bArr = new byte[buffer.j6()];
        buffer.FH(bArr, 0, bArr.length);
        return bArr;
    }

    private byte[] VH() {
        if (this.we == null) {
            this.we = new BigInteger(this.u7).mod(new BigInteger(this.tp).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.we;
    }

    private byte[] gn() {
        if (this.J0 == null) {
            this.J0 = new BigInteger(this.u7).mod(new BigInteger(this.EQ).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.J0;
    }

    private byte[] u7() {
        if (this.J8 == null) {
            this.J8 = new BigInteger(this.EQ).modInverse(new BigInteger(this.tp)).toByteArray();
        }
        return this.J8;
    }

    public void Zo() {
        super.Zo();
        Util.Hw(this.u7);
    }
}
