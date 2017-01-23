package com.jcraft.jsch;

import java.math.BigInteger;

public class KeyPairDSA extends KeyPair {
    private static final byte[] J0;
    private static final byte[] J8;
    private static final byte[] Ws;
    private byte[] EQ;
    private byte[] VH;
    private byte[] gn;
    private byte[] tp;
    private byte[] u7;
    private int we;

    public KeyPairDSA(JSch jSch) {
        this(jSch, null, null, null, null, null);
    }

    public KeyPairDSA(JSch jSch, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(jSch);
        this.we = 1024;
        this.VH = bArr;
        this.gn = bArr2;
        this.u7 = bArr3;
        this.tp = bArr4;
        this.EQ = bArr5;
        if (bArr != null) {
            this.we = new BigInteger(bArr).bitLength();
        }
    }

    static {
        J0 = Util.DW("-----BEGIN DSA PRIVATE KEY-----");
        J8 = Util.DW("-----END DSA PRIVATE KEY-----");
        Ws = Util.DW("ssh-dss");
    }

    byte[] DW() {
        int j6 = ((((((((((((((((j6(1) + 1) + 1) + 1) + j6(this.VH.length)) + this.VH.length) + 1) + j6(this.gn.length)) + this.gn.length) + 1) + j6(this.u7.length)) + this.u7.length) + 1) + j6(this.tp.length)) + this.tp.length) + 1) + j6(this.EQ.length)) + this.EQ.length;
        byte[] bArr = new byte[((j6(j6) + 1) + j6)];
        j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, j6(bArr, 0, j6), new byte[1]), this.VH), this.gn), this.u7), this.tp), this.EQ);
        return bArr;
    }

    boolean DW(byte[] bArr) {
        try {
            Buffer buffer;
            if (this.j6 == 1) {
                if (bArr[0] == (byte) 48) {
                    return false;
                }
                buffer = new Buffer(bArr);
                buffer.Hw();
                this.VH = buffer.u7();
                this.u7 = buffer.u7();
                this.gn = buffer.u7();
                this.tp = buffer.u7();
                this.EQ = buffer.u7();
                if (this.VH == null) {
                    return true;
                }
                this.we = new BigInteger(this.VH).bitLength();
                return true;
            } else if (this.j6 == 2) {
                buffer = new Buffer(bArr);
                buffer.DW(bArr.length);
                try {
                    this.EQ = buffer.j6(1, "")[0];
                    return true;
                } catch (JSchException e) {
                    return false;
                }
            } else if (bArr[0] != (byte) 48) {
                return false;
            } else {
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
                i3 += i5;
                if (this.VH == null) {
                    return true;
                }
                this.we = new BigInteger(this.VH).bitLength();
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
        if (this.VH == null) {
            return null;
        }
        return Buffer.j6(new byte[][]{Ws, this.VH, this.gn, this.u7, this.tp}).DW;
    }

    byte[] FH() {
        return Ws;
    }

    public byte[] j6(byte[] bArr) {
        try {
            SignatureDSA signatureDSA = (SignatureDSA) Class.forName(JSch.DW("signature.dss")).newInstance();
            signatureDSA.j6();
            signatureDSA.DW(this.EQ, this.VH, this.gn, this.u7);
            signatureDSA.j6(bArr);
            byte[] DW = signatureDSA.DW();
            return Buffer.j6(new byte[][]{Ws, DW}).DW;
        } catch (Exception e) {
            return null;
        }
    }

    static KeyPair j6(JSch jSch, Buffer buffer) {
        byte[][] j6 = buffer.j6(7, "invalid key format");
        KeyPair keyPairDSA = new KeyPairDSA(jSch, j6[1], j6[2], j6[3], j6[4], j6[5]);
        keyPairDSA.DW = new String(j6[6]);
        keyPairDSA.j6 = 0;
        return keyPairDSA;
    }

    public byte[] j6() {
        if (v5()) {
            throw new JSchException("key is encrypted.");
        }
        Buffer buffer = new Buffer();
        buffer.DW(Ws);
        buffer.DW(this.VH);
        buffer.DW(this.gn);
        buffer.DW(this.u7);
        buffer.DW(this.tp);
        buffer.DW(this.EQ);
        buffer.DW(Util.DW(this.DW));
        byte[] bArr = new byte[buffer.j6()];
        buffer.FH(bArr, 0, bArr.length);
        return bArr;
    }

    public void Zo() {
        super.Zo();
        Util.Hw(this.EQ);
    }
}
