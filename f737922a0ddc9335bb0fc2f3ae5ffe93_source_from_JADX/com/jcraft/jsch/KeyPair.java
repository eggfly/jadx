package com.jcraft.jsch;

import java.util.Hashtable;
import java.util.Vector;

public abstract class KeyPair {
    private static byte[] EQ;
    static byte[][] Hw;
    private static final String[] J8;
    private static final String[] QX;
    private static final byte[] VH;
    private static final String[] Ws;
    protected String DW;
    JSch FH;
    private byte[] J0;
    protected byte[] Zo;
    private Cipher gn;
    int j6;
    private byte[] tp;
    private HASH u7;
    protected boolean v5;
    private byte[] we;

    class ASN1 {
        int DW;
        int FH;
        final /* synthetic */ KeyPair Hw;
        byte[] j6;

        ASN1(KeyPair keyPair, byte[] bArr) {
            this(keyPair, bArr, 0, bArr.length);
        }

        ASN1(KeyPair keyPair, byte[] bArr, int i, int i2) {
            this.Hw = keyPair;
            this.j6 = bArr;
            this.DW = i;
            this.FH = i2;
            if (i + i2 > bArr.length) {
                throw new ASN1Exception(keyPair);
            }
        }

        private int j6(int[] iArr) {
            int i = iArr[0];
            int i2 = i + 1;
            i = this.j6[i] & 255;
            if ((i & 128) != 0) {
                int i3 = i & 127;
                i = 0;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0) {
                        break;
                    }
                    i = (i << 8) + (this.j6[i2] & 255);
                    i2++;
                    i3 = i4;
                }
            }
            iArr[0] = i2;
            return i;
        }

        byte[] j6() {
            int[] iArr = new int[]{this.DW + 1};
            int j6 = j6(iArr);
            Object obj = new byte[j6];
            System.arraycopy(this.j6, iArr[0], obj, 0, obj.length);
            return obj;
        }

        ASN1[] DW() {
            byte b = this.j6[this.DW];
            int[] iArr = new int[]{this.DW + 1};
            int j6 = j6(iArr);
            if (b == 5) {
                return new ASN1[0];
            }
            int i = iArr[0];
            Vector vector = new Vector();
            while (j6 > 0) {
                i++;
                j6--;
                iArr[0] = i;
                int j62 = j6(iArr);
                int i2 = iArr[0];
                j6 -= i2 - i;
                vector.addElement(new ASN1(this.Hw, this.j6, i - 1, ((i2 - i) + 1) + j62));
                i = i2 + j62;
                j6 -= j62;
            }
            ASN1[] asn1Arr = new ASN1[vector.size()];
            for (i = 0; i < vector.size(); i++) {
                asn1Arr[i] = (ASN1) vector.elementAt(i);
            }
            return asn1Arr;
        }
    }

    class ASN1Exception extends Exception {
        final /* synthetic */ KeyPair j6;

        ASN1Exception(KeyPair keyPair) {
            this.j6 = keyPair;
        }
    }

    abstract boolean DW(byte[] bArr);

    abstract byte[] DW();

    abstract byte[] FH();

    public abstract byte[] j6();

    public abstract byte[] j6(byte[] bArr);

    static {
        VH = Util.DW("\n");
        Hw = new byte[][]{Util.DW("Proc-Type: 4,ENCRYPTED"), Util.DW("DEK-Info: DES-EDE3-CBC,")};
        EQ = Util.DW(" ");
        J8 = new String[]{"PuTTY-User-Key-File-2: ", "Encryption: ", "Comment: ", "Public-Lines: "};
        Ws = new String[]{"Private-Lines: "};
        QX = new String[]{"Private-MAC: "};
    }

    public KeyPair(JSch jSch) {
        this.j6 = 0;
        this.DW = "no comment";
        this.FH = null;
        this.v5 = false;
        this.Zo = null;
        this.we = null;
        this.J0 = null;
        this.FH = jSch;
    }

    public byte[] Hw() {
        return this.J0;
    }

    private byte[] j6(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] j6 = j6(bArr2, bArr3);
            this.gn.j6(1, j6, bArr3);
            Util.Hw(j6);
            byte[] bArr4 = new byte[bArr.length];
            this.gn.j6(bArr, 0, bArr.length, bArr4, 0);
            return bArr4;
        } catch (Exception e) {
            return null;
        }
    }

    int j6(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        bArr[i] = (byte) 48;
        return DW(bArr, i3, i2);
    }

    int j6(byte[] bArr, int i, byte[] bArr2) {
        int i2 = i + 1;
        bArr[i] = (byte) 2;
        i2 = DW(bArr, i2, bArr2.length);
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        return i2 + bArr2.length;
    }

    int j6(int i) {
        int i2 = 1;
        if (i > 127) {
            while (i > 0) {
                i >>>= 8;
                i2++;
            }
        }
        return i2;
    }

    int DW(byte[] bArr, int i, int i2) {
        int j6 = j6(i2) - 1;
        if (j6 == 0) {
            int i3 = i + 1;
            bArr[i] = (byte) i2;
            return i3;
        }
        int i4 = i + 1;
        bArr[i] = (byte) (j6 | 128);
        i3 = i4 + j6;
        while (j6 > 0) {
            bArr[(i4 + j6) - 1] = (byte) (i2 & 255);
            i2 >>>= 8;
            j6--;
        }
        return i3;
    }

    private HASH VH() {
        try {
            this.u7 = (HASH) Class.forName(JSch.DW("md5")).newInstance();
            this.u7.j6();
        } catch (Exception e) {
        }
        return this.u7;
    }

    private Cipher gn() {
        try {
            this.gn = (Cipher) Class.forName(JSch.DW("3des-cbc")).newInstance();
        } catch (Exception e) {
        }
        return this.gn;
    }

    synchronized byte[] j6(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int i = 0;
        synchronized (this) {
            if (this.gn == null) {
                this.gn = gn();
            }
            if (this.u7 == null) {
                this.u7 = VH();
            }
            Object obj = new byte[this.gn.DW()];
            int DW = this.u7.DW();
            Object obj2 = new byte[((obj.length % DW == 0 ? 0 : DW) + ((obj.length / DW) * DW))];
            Object obj3;
            try {
                bArr3 = (byte[]) null;
                if (this.j6 == 0) {
                    while (i + DW <= obj2.length) {
                        if (bArr3 != null) {
                            this.u7.j6(bArr3, 0, bArr3.length);
                        }
                        this.u7.j6(bArr, 0, bArr.length);
                        this.u7.j6(bArr2, 0, bArr2.length > 8 ? 8 : bArr2.length);
                        bArr3 = this.u7.FH();
                        System.arraycopy(bArr3, 0, obj2, i, bArr3.length);
                        i += bArr3.length;
                    }
                    System.arraycopy(obj2, 0, obj, 0, obj.length);
                    bArr3 = obj;
                } else if (this.j6 == 1) {
                    while (i + DW <= obj2.length) {
                        if (bArr3 != null) {
                            this.u7.j6(bArr3, 0, bArr3.length);
                        }
                        this.u7.j6(bArr, 0, bArr.length);
                        bArr3 = this.u7.FH();
                        System.arraycopy(bArr3, 0, obj2, i, bArr3.length);
                        i += bArr3.length;
                    }
                    System.arraycopy(obj2, 0, obj, 0, obj.length);
                    obj3 = obj;
                } else if (this.j6 == 2) {
                    HASH hash = (HASH) Class.forName(JSch.DW("sha-1")).newInstance();
                    byte[] bArr4 = new byte[4];
                    obj = new byte[40];
                    while (i < 2) {
                        hash.j6();
                        bArr4[3] = (byte) i;
                        hash.j6(bArr4, 0, bArr4.length);
                        hash.j6(bArr, 0, bArr.length);
                        System.arraycopy(hash.FH(), 0, obj, i * 20, 20);
                        i++;
                    }
                    obj3 = obj;
                } else {
                    obj3 = obj;
                }
            } catch (Exception e) {
                Exception exception = e;
                obj3 = obj;
                System.err.println(exception);
            }
        }
        return bArr3;
    }

    public boolean v5() {
        return this.v5;
    }

    public boolean FH(byte[] bArr) {
        if (!this.v5) {
            return true;
        }
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            byte[] j6 = j6(this.Zo, bArr2, this.we);
            Util.Hw(bArr2);
            if (DW(j6)) {
                this.v5 = false;
            }
            if (this.v5) {
                return false;
            }
            return true;
        } else if (this.v5) {
            return false;
        } else {
            return true;
        }
    }

    public static KeyPair j6(JSch jSch, String str, String str2) {
        byte[] bArr = (byte[]) null;
        byte[] bArr2 = (byte[]) null;
        try {
            String stringBuilder;
            byte[] Hw = Util.Hw(str);
            if (str2 == null) {
                stringBuilder = new StringBuilder(String.valueOf(str)).append(".pub").toString();
            } else {
                stringBuilder = str2;
            }
            try {
                bArr2 = Util.Hw(stringBuilder);
            } catch (Throwable e) {
                if (str2 != null) {
                    throw new JSchException(e.toString(), e);
                }
            }
            try {
                KeyPair j6 = j6(jSch, Hw, bArr2);
                return j6;
            } finally {
                Util.Hw(Hw);
            }
        } catch (Throwable e2) {
            throw new JSchException(e2.toString(), e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.jcraft.jsch.KeyPair j6(com.jcraft.jsch.JSch r19, byte[] r20, byte[] r21) {
        /*
        r2 = 8;
        r12 = new byte[r2];
        r11 = 1;
        r2 = 0;
        r2 = (byte[]) r2;
        r3 = 0;
        r3 = (byte[]) r3;
        r8 = 0;
        r7 = 0;
        r9 = "";
        r6 = 0;
        if (r21 != 0) goto L_0x0089;
    L_0x0013:
        if (r20 == 0) goto L_0x0089;
    L_0x0015:
        r0 = r20;
        r4 = r0.length;
        r5 = 11;
        if (r4 <= r5) goto L_0x0089;
    L_0x001c:
        r4 = 0;
        r4 = r20[r4];
        if (r4 != 0) goto L_0x0089;
    L_0x0021:
        r4 = 1;
        r4 = r20[r4];
        if (r4 != 0) goto L_0x0089;
    L_0x0026:
        r4 = 2;
        r4 = r20[r4];
        if (r4 != 0) goto L_0x0089;
    L_0x002b:
        r4 = 3;
        r4 = r20[r4];
        r5 = 7;
        if (r4 != r5) goto L_0x0089;
    L_0x0031:
        r2 = new com.jcraft.jsch.Buffer;
        r0 = r20;
        r2.<init>(r0);
        r0 = r20;
        r3 = r0.length;
        r2.DW(r3);
        r3 = new java.lang.String;
        r4 = r2.tp();
        r3.<init>(r4);
        r2.J0();
        r4 = "ssh-rsa";
        r4 = r3.equals(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0053:
        r0 = r19;
        r2 = com.jcraft.jsch.KeyPairRSA.j6(r0, r2);
    L_0x0059:
        return r2;
    L_0x005a:
        r4 = "ssh-dss";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x006a;
    L_0x0063:
        r0 = r19;
        r2 = com.jcraft.jsch.KeyPairDSA.j6(r0, r2);
        goto L_0x0059;
    L_0x006a:
        r2 = new com.jcraft.jsch.JSchException;
        r3 = new java.lang.StringBuilder;
        r4 = "privatekey: invalid key ";
        r3.<init>(r4);
        r4 = new java.lang.String;
        r5 = 4;
        r6 = 7;
        r0 = r20;
        r4.<init>(r0, r5, r6);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0089:
        if (r20 == 0) goto L_0x0093;
    L_0x008b:
        r4 = j6(r19, r20);	 Catch:{ Exception -> 0x00bf }
        if (r4 == 0) goto L_0x0093;
    L_0x0091:
        r2 = r4;
        goto L_0x0059;
    L_0x0093:
        if (r20 == 0) goto L_0x00c7;
    L_0x0095:
        r0 = r20;
        r4 = r0.length;	 Catch:{ Exception -> 0x00bf }
        r5 = r4;
    L_0x0099:
        r10 = 0;
    L_0x009a:
        if (r10 < r5) goto L_0x00ca;
    L_0x009c:
        r13 = r6;
        r14 = r12;
        r6 = r7;
        r7 = r8;
        r8 = r11;
    L_0x00a1:
        if (r10 < r5) goto L_0x00fd;
    L_0x00a3:
        if (r20 == 0) goto L_0x04be;
    L_0x00a5:
        if (r7 != 0) goto L_0x0476;
    L_0x00a7:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "invalid privatekey: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x00bf:
        r2 = move-exception;
        r3 = r2 instanceof com.jcraft.jsch.JSchException;
        if (r3 == 0) goto L_0x06e4;
    L_0x00c4:
        r2 = (com.jcraft.jsch.JSchException) r2;
        throw r2;
    L_0x00c7:
        r4 = 0;
        r5 = r4;
        goto L_0x0099;
    L_0x00ca:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r13 = 45;
        if (r4 != r13) goto L_0x00fa;
    L_0x00d0:
        r4 = r10 + 4;
        if (r4 >= r5) goto L_0x00fa;
    L_0x00d4:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r13 = 45;
        if (r4 != r13) goto L_0x00fa;
    L_0x00dc:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r13 = 45;
        if (r4 != r13) goto L_0x00fa;
    L_0x00e4:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r13 = 45;
        if (r4 != r13) goto L_0x00fa;
    L_0x00ec:
        r4 = r10 + 4;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r13 = 45;
        if (r4 != r13) goto L_0x00fa;
    L_0x00f4:
        r13 = r6;
        r14 = r12;
        r6 = r7;
        r7 = r8;
        r8 = r11;
        goto L_0x00a1;
    L_0x00fa:
        r10 = r10 + 1;
        goto L_0x009a;
    L_0x00fd:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 66;
        if (r4 != r11) goto L_0x0231;
    L_0x0103:
        r4 = r10 + 3;
        if (r4 >= r5) goto L_0x0231;
    L_0x0107:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 69;
        if (r4 != r11) goto L_0x0231;
    L_0x010f:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 71;
        if (r4 != r11) goto L_0x0231;
    L_0x0117:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 73;
        if (r4 != r11) goto L_0x0231;
    L_0x011f:
        r4 = r10 + 6;
        r7 = r4 + 2;
        if (r7 < r5) goto L_0x013d;
    L_0x0125:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "invalid privatekey: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x013d:
        r7 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r10 = 68;
        if (r7 != r10) goto L_0x0158;
    L_0x0143:
        r7 = r4 + 1;
        r7 = r20[r7];	 Catch:{ Exception -> 0x00bf }
        r10 = 83;
        if (r7 != r10) goto L_0x0158;
    L_0x014b:
        r7 = r4 + 2;
        r7 = r20[r7];	 Catch:{ Exception -> 0x00bf }
        r10 = 65;
        if (r7 != r10) goto L_0x0158;
    L_0x0153:
        r7 = 1;
    L_0x0154:
        r10 = r4 + 3;
        goto L_0x00a1;
    L_0x0158:
        r7 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r10 = 82;
        if (r7 != r10) goto L_0x0170;
    L_0x015e:
        r7 = r4 + 1;
        r7 = r20[r7];	 Catch:{ Exception -> 0x00bf }
        r10 = 83;
        if (r7 != r10) goto L_0x0170;
    L_0x0166:
        r7 = r4 + 2;
        r7 = r20[r7];	 Catch:{ Exception -> 0x00bf }
        r10 = 65;
        if (r7 != r10) goto L_0x0170;
    L_0x016e:
        r7 = 2;
        goto L_0x0154;
    L_0x0170:
        r6 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r7 = 83;
        if (r6 != r7) goto L_0x0189;
    L_0x0176:
        r6 = r4 + 1;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 83;
        if (r6 != r7) goto L_0x0189;
    L_0x017e:
        r6 = r4 + 2;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 72;
        if (r6 != r7) goto L_0x0189;
    L_0x0186:
        r7 = 3;
        r6 = 1;
        goto L_0x0154;
    L_0x0189:
        r6 = r4 + 6;
        if (r6 >= r5) goto L_0x01c9;
    L_0x018d:
        r6 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r7 = 80;
        if (r6 != r7) goto L_0x01c9;
    L_0x0193:
        r6 = r4 + 1;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 82;
        if (r6 != r7) goto L_0x01c9;
    L_0x019b:
        r6 = r4 + 2;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 73;
        if (r6 != r7) goto L_0x01c9;
    L_0x01a3:
        r6 = r4 + 3;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 86;
        if (r6 != r7) goto L_0x01c9;
    L_0x01ab:
        r6 = r4 + 4;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 65;
        if (r6 != r7) goto L_0x01c9;
    L_0x01b3:
        r6 = r4 + 5;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 84;
        if (r6 != r7) goto L_0x01c9;
    L_0x01bb:
        r6 = r4 + 6;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 69;
        if (r6 != r7) goto L_0x01c9;
    L_0x01c3:
        r7 = 3;
        r6 = 3;
        r8 = 0;
        r4 = r4 + 3;
        goto L_0x0154;
    L_0x01c9:
        r6 = r4 + 8;
        if (r6 >= r5) goto L_0x0219;
    L_0x01cd:
        r6 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r7 = 69;
        if (r6 != r7) goto L_0x0219;
    L_0x01d3:
        r6 = r4 + 1;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 78;
        if (r6 != r7) goto L_0x0219;
    L_0x01db:
        r6 = r4 + 2;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 67;
        if (r6 != r7) goto L_0x0219;
    L_0x01e3:
        r6 = r4 + 3;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 82;
        if (r6 != r7) goto L_0x0219;
    L_0x01eb:
        r6 = r4 + 4;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 89;
        if (r6 != r7) goto L_0x0219;
    L_0x01f3:
        r6 = r4 + 5;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 80;
        if (r6 != r7) goto L_0x0219;
    L_0x01fb:
        r6 = r4 + 6;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 84;
        if (r6 != r7) goto L_0x0219;
    L_0x0203:
        r6 = r4 + 7;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 69;
        if (r6 != r7) goto L_0x0219;
    L_0x020b:
        r6 = r4 + 8;
        r6 = r20[r6];	 Catch:{ Exception -> 0x00bf }
        r7 = 68;
        if (r6 != r7) goto L_0x0219;
    L_0x0213:
        r7 = 3;
        r6 = 3;
        r4 = r4 + 5;
        goto L_0x0154;
    L_0x0219:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "invalid privatekey: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x0231:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 65;
        if (r4 != r11) goto L_0x02b5;
    L_0x0237:
        r4 = r10 + 7;
        if (r4 >= r5) goto L_0x02b5;
    L_0x023b:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 69;
        if (r4 != r11) goto L_0x02b5;
    L_0x0243:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 83;
        if (r4 != r11) goto L_0x02b5;
    L_0x024b:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x02b5;
    L_0x0253:
        r4 = r10 + 4;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 50;
        if (r4 != r11) goto L_0x02b5;
    L_0x025b:
        r4 = r10 + 5;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 53;
        if (r4 != r11) goto L_0x02b5;
    L_0x0263:
        r4 = r10 + 6;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 54;
        if (r4 != r11) goto L_0x02b5;
    L_0x026b:
        r4 = r10 + 7;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x02b5;
    L_0x0273:
        r10 = r10 + 8;
        r4 = "aes256-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = com.jcraft.jsch.Session.VH(r4);	 Catch:{ Exception -> 0x00bf }
        if (r4 == 0) goto L_0x029d;
    L_0x0282:
        r4 = "aes256-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = java.lang.Class.forName(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = r4.newInstance();	 Catch:{ Exception -> 0x00bf }
        r4 = (com.jcraft.jsch.Cipher) r4;	 Catch:{ Exception -> 0x00bf }
        r11 = r4.j6();	 Catch:{ Exception -> 0x00bf }
        r11 = new byte[r11];	 Catch:{ Exception -> 0x00bf }
        r13 = r4;
        r14 = r11;
        goto L_0x00a1;
    L_0x029d:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "privatekey: aes256-cbc is not available ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x02b5:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 65;
        if (r4 != r11) goto L_0x0339;
    L_0x02bb:
        r4 = r10 + 7;
        if (r4 >= r5) goto L_0x0339;
    L_0x02bf:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 69;
        if (r4 != r11) goto L_0x0339;
    L_0x02c7:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 83;
        if (r4 != r11) goto L_0x0339;
    L_0x02cf:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x0339;
    L_0x02d7:
        r4 = r10 + 4;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 49;
        if (r4 != r11) goto L_0x0339;
    L_0x02df:
        r4 = r10 + 5;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 57;
        if (r4 != r11) goto L_0x0339;
    L_0x02e7:
        r4 = r10 + 6;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 50;
        if (r4 != r11) goto L_0x0339;
    L_0x02ef:
        r4 = r10 + 7;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x0339;
    L_0x02f7:
        r10 = r10 + 8;
        r4 = "aes192-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = com.jcraft.jsch.Session.VH(r4);	 Catch:{ Exception -> 0x00bf }
        if (r4 == 0) goto L_0x0321;
    L_0x0306:
        r4 = "aes192-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = java.lang.Class.forName(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = r4.newInstance();	 Catch:{ Exception -> 0x00bf }
        r4 = (com.jcraft.jsch.Cipher) r4;	 Catch:{ Exception -> 0x00bf }
        r11 = r4.j6();	 Catch:{ Exception -> 0x00bf }
        r11 = new byte[r11];	 Catch:{ Exception -> 0x00bf }
        r13 = r4;
        r14 = r11;
        goto L_0x00a1;
    L_0x0321:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "privatekey: aes192-cbc is not available ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x0339:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 65;
        if (r4 != r11) goto L_0x03bd;
    L_0x033f:
        r4 = r10 + 7;
        if (r4 >= r5) goto L_0x03bd;
    L_0x0343:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 69;
        if (r4 != r11) goto L_0x03bd;
    L_0x034b:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 83;
        if (r4 != r11) goto L_0x03bd;
    L_0x0353:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x03bd;
    L_0x035b:
        r4 = r10 + 4;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 49;
        if (r4 != r11) goto L_0x03bd;
    L_0x0363:
        r4 = r10 + 5;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 50;
        if (r4 != r11) goto L_0x03bd;
    L_0x036b:
        r4 = r10 + 6;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 56;
        if (r4 != r11) goto L_0x03bd;
    L_0x0373:
        r4 = r10 + 7;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 45;
        if (r4 != r11) goto L_0x03bd;
    L_0x037b:
        r10 = r10 + 8;
        r4 = "aes128-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = com.jcraft.jsch.Session.VH(r4);	 Catch:{ Exception -> 0x00bf }
        if (r4 == 0) goto L_0x03a5;
    L_0x038a:
        r4 = "aes128-cbc";
        r4 = com.jcraft.jsch.JSch.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = java.lang.Class.forName(r4);	 Catch:{ Exception -> 0x00bf }
        r4 = r4.newInstance();	 Catch:{ Exception -> 0x00bf }
        r4 = (com.jcraft.jsch.Cipher) r4;	 Catch:{ Exception -> 0x00bf }
        r11 = r4.j6();	 Catch:{ Exception -> 0x00bf }
        r11 = new byte[r11];	 Catch:{ Exception -> 0x00bf }
        r13 = r4;
        r14 = r11;
        goto L_0x00a1;
    L_0x03a5:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "privatekey: aes128-cbc is not available ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x03bd:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 67;
        if (r4 != r11) goto L_0x0402;
    L_0x03c3:
        r4 = r10 + 3;
        if (r4 >= r5) goto L_0x0402;
    L_0x03c7:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 66;
        if (r4 != r11) goto L_0x0402;
    L_0x03cf:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 67;
        if (r4 != r11) goto L_0x0402;
    L_0x03d7:
        r4 = r10 + 3;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 44;
        if (r4 != r11) goto L_0x0402;
    L_0x03df:
        r10 = r10 + 4;
        r4 = 0;
    L_0x03e2:
        r11 = r14.length;	 Catch:{ Exception -> 0x00bf }
        if (r4 >= r11) goto L_0x00a1;
    L_0x03e5:
        r11 = r10 + 1;
        r10 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r10 = j6(r10);	 Catch:{ Exception -> 0x00bf }
        r10 = r10 << 4;
        r12 = r10 & 240;
        r10 = r11 + 1;
        r11 = r20[r11];	 Catch:{ Exception -> 0x00bf }
        r11 = j6(r11);	 Catch:{ Exception -> 0x00bf }
        r11 = r11 & 15;
        r11 = r11 + r12;
        r11 = (byte) r11;	 Catch:{ Exception -> 0x00bf }
        r14[r4] = r11;	 Catch:{ Exception -> 0x00bf }
        r4 = r4 + 1;
        goto L_0x03e2;
    L_0x0402:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 13;
        if (r4 != r11) goto L_0x041b;
    L_0x0408:
        r4 = r10 + 1;
        r0 = r20;
        r11 = r0.length;	 Catch:{ Exception -> 0x00bf }
        if (r4 >= r11) goto L_0x041b;
    L_0x040f:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 10;
        if (r4 != r11) goto L_0x041b;
    L_0x0417:
        r10 = r10 + 1;
        goto L_0x00a1;
    L_0x041b:
        r4 = r20[r10];	 Catch:{ Exception -> 0x00bf }
        r11 = 10;
        if (r4 != r11) goto L_0x0472;
    L_0x0421:
        r4 = r10 + 1;
        r0 = r20;
        r11 = r0.length;	 Catch:{ Exception -> 0x00bf }
        if (r4 >= r11) goto L_0x0472;
    L_0x0428:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 10;
        if (r4 != r11) goto L_0x0434;
    L_0x0430:
        r10 = r10 + 2;
        goto L_0x00a3;
    L_0x0434:
        r4 = r10 + 1;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 13;
        if (r4 != r11) goto L_0x044f;
    L_0x043c:
        r4 = r10 + 2;
        r0 = r20;
        r11 = r0.length;	 Catch:{ Exception -> 0x00bf }
        if (r4 >= r11) goto L_0x044f;
    L_0x0443:
        r4 = r10 + 2;
        r4 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r11 = 10;
        if (r4 != r11) goto L_0x044f;
    L_0x044b:
        r10 = r10 + 3;
        goto L_0x00a3;
    L_0x044f:
        r4 = 0;
        r11 = r10 + 1;
    L_0x0452:
        r0 = r20;
        r12 = r0.length;	 Catch:{ Exception -> 0x00bf }
        if (r11 < r12) goto L_0x0461;
    L_0x0457:
        if (r4 != 0) goto L_0x0472;
    L_0x0459:
        r10 = r10 + 1;
        r4 = 3;
        if (r6 == r4) goto L_0x00a3;
    L_0x045e:
        r8 = 0;
        goto L_0x00a3;
    L_0x0461:
        r12 = r20[r11];	 Catch:{ Exception -> 0x00bf }
        r15 = 10;
        if (r12 == r15) goto L_0x0457;
    L_0x0467:
        r12 = r20[r11];	 Catch:{ Exception -> 0x00bf }
        r15 = 58;
        if (r12 != r15) goto L_0x046f;
    L_0x046d:
        r4 = 1;
        goto L_0x0457;
    L_0x046f:
        r11 = r11 + 1;
        goto L_0x0452;
    L_0x0472:
        r10 = r10 + 1;
        goto L_0x00a1;
    L_0x0476:
        r4 = r10;
    L_0x0477:
        if (r4 < r5) goto L_0x0498;
    L_0x0479:
        r5 = r5 - r4;
        if (r5 == 0) goto L_0x0480;
    L_0x047c:
        r5 = r4 - r10;
        if (r5 != 0) goto L_0x04a1;
    L_0x0480:
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "invalid privatekey: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x0498:
        r11 = r20[r4];	 Catch:{ Exception -> 0x00bf }
        r12 = 45;
        if (r11 == r12) goto L_0x0479;
    L_0x049e:
        r4 = r4 + 1;
        goto L_0x0477;
    L_0x04a1:
        r4 = r4 - r10;
        r12 = new byte[r4];	 Catch:{ Exception -> 0x00bf }
        r4 = 0;
        r5 = r12.length;	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        java.lang.System.arraycopy(r0, r10, r12, r4, r5);	 Catch:{ Exception -> 0x00bf }
        r15 = 0;
        r5 = 0;
        r4 = r12.length;	 Catch:{ Exception -> 0x00bf }
        r11 = r5;
    L_0x04af:
        if (r11 < r4) goto L_0x0524;
    L_0x04b1:
        r4 = r11 - r15;
        if (r4 <= 0) goto L_0x04bb;
    L_0x04b5:
        r2 = r11 - r15;
        r2 = com.jcraft.jsch.Util.j6(r12, r15, r2);	 Catch:{ Exception -> 0x00bf }
    L_0x04bb:
        com.jcraft.jsch.Util.Hw(r12);	 Catch:{ Exception -> 0x00bf }
    L_0x04be:
        if (r2 == 0) goto L_0x074c;
    L_0x04c0:
        r4 = r2.length;	 Catch:{ Exception -> 0x00bf }
        r5 = 4;
        if (r4 <= r5) goto L_0x074c;
    L_0x04c4:
        r4 = 0;
        r4 = r2[r4];	 Catch:{ Exception -> 0x00bf }
        r5 = 63;
        if (r4 != r5) goto L_0x074c;
    L_0x04cb:
        r4 = 1;
        r4 = r2[r4];	 Catch:{ Exception -> 0x00bf }
        r5 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r4 != r5) goto L_0x074c;
    L_0x04d2:
        r4 = 2;
        r4 = r2[r4];	 Catch:{ Exception -> 0x00bf }
        r5 = -7;
        if (r4 != r5) goto L_0x074c;
    L_0x04d8:
        r4 = 3;
        r4 = r2[r4];	 Catch:{ Exception -> 0x00bf }
        r5 = -21;
        if (r4 != r5) goto L_0x074c;
    L_0x04df:
        r5 = new com.jcraft.jsch.Buffer;	 Catch:{ Exception -> 0x00bf }
        r5.<init>(r2);	 Catch:{ Exception -> 0x00bf }
        r5.Hw();	 Catch:{ Exception -> 0x00bf }
        r5.Hw();	 Catch:{ Exception -> 0x00bf }
        r5.tp();	 Catch:{ Exception -> 0x00bf }
        r4 = r5.tp();	 Catch:{ Exception -> 0x00bf }
        r4 = com.jcraft.jsch.Util.DW(r4);	 Catch:{ Exception -> 0x00bf }
        r10 = "3des-cbc";
        r10 = r4.equals(r10);	 Catch:{ Exception -> 0x00bf }
        if (r10 == 0) goto L_0x055e;
    L_0x04fe:
        r5.Hw();	 Catch:{ Exception -> 0x00bf }
        r2 = r2.length;	 Catch:{ Exception -> 0x00bf }
        r3 = r5.DW();	 Catch:{ Exception -> 0x00bf }
        r2 = r2 - r3;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x00bf }
        r5.Hw(r2);	 Catch:{ Exception -> 0x00bf }
        r2 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00bf }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r4 = "unknown privatekey format: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00bf }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00bf }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00bf }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00bf }
        throw r2;	 Catch:{ Exception -> 0x00bf }
    L_0x0524:
        r5 = r12[r11];	 Catch:{ Exception -> 0x00bf }
        r10 = 10;
        if (r5 != r10) goto L_0x0553;
    L_0x052a:
        r5 = r11 + -1;
        r5 = r12[r5];	 Catch:{ Exception -> 0x00bf }
        r10 = 13;
        if (r5 != r10) goto L_0x054e;
    L_0x0532:
        r5 = 1;
        r10 = r5;
    L_0x0534:
        r16 = r11 + 1;
        if (r10 == 0) goto L_0x0551;
    L_0x0538:
        r5 = 1;
    L_0x0539:
        r5 = r11 - r5;
        r17 = r11 + 1;
        r17 = r4 - r17;
        r0 = r16;
        r1 = r17;
        java.lang.System.arraycopy(r12, r0, r12, r5, r1);	 Catch:{ Exception -> 0x00bf }
        if (r10 == 0) goto L_0x054a;
    L_0x0548:
        r4 = r4 + -1;
    L_0x054a:
        r4 = r4 + -1;
        goto L_0x04af;
    L_0x054e:
        r5 = 0;
        r10 = r5;
        goto L_0x0534;
    L_0x0551:
        r5 = 0;
        goto L_0x0539;
    L_0x0553:
        r5 = r12[r11];	 Catch:{ Exception -> 0x00bf }
        r10 = 45;
        if (r5 == r10) goto L_0x04b1;
    L_0x0559:
        r5 = r11 + 1;
        r11 = r5;
        goto L_0x04af;
    L_0x055e:
        r10 = "none";
        r4 = r4.equals(r10);	 Catch:{ Exception -> 0x00bf }
        if (r4 == 0) goto L_0x074c;
    L_0x0567:
        r5.Hw();	 Catch:{ Exception -> 0x00bf }
        r5.Hw();	 Catch:{ Exception -> 0x00bf }
        r4 = 0;
        r2 = r2.length;	 Catch:{ Exception -> 0x00bf }
        r8 = r5.DW();	 Catch:{ Exception -> 0x00bf }
        r2 = r2 - r8;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x00bf }
        r5.Hw(r2);	 Catch:{ Exception -> 0x00bf }
        r11 = r2;
        r12 = r4;
    L_0x057b:
        if (r21 == 0) goto L_0x0748;
    L_0x057d:
        r0 = r21;
        r8 = r0.length;	 Catch:{ Exception -> 0x06df }
        r0 = r21;
        r2 = r0.length;	 Catch:{ Exception -> 0x06df }
        r4 = 4;
        if (r2 <= r4) goto L_0x0657;
    L_0x0586:
        r2 = 0;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 45;
        if (r2 != r4) goto L_0x0657;
    L_0x058d:
        r2 = 1;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 45;
        if (r2 != r4) goto L_0x0657;
    L_0x0594:
        r2 = 2;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 45;
        if (r2 != r4) goto L_0x0657;
    L_0x059b:
        r2 = 3;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 45;
        if (r2 != r4) goto L_0x0657;
    L_0x05a2:
        r2 = 1;
        r5 = 0;
    L_0x05a4:
        r5 = r5 + 1;
        r0 = r21;
        r4 = r0.length;	 Catch:{ Exception -> 0x06df }
        if (r4 <= r5) goto L_0x05b1;
    L_0x05ab:
        r4 = r21[r5];	 Catch:{ Exception -> 0x06df }
        r10 = 10;
        if (r4 != r10) goto L_0x05a4;
    L_0x05b1:
        r0 = r21;
        r4 = r0.length;	 Catch:{ Exception -> 0x06df }
        if (r4 > r5) goto L_0x05b7;
    L_0x05b6:
        r2 = 0;
    L_0x05b7:
        if (r2 != 0) goto L_0x0600;
    L_0x05b9:
        r0 = r21;
        r4 = r0.length;	 Catch:{ Exception -> 0x06df }
        if (r4 > r5) goto L_0x05bf;
    L_0x05be:
        r2 = 0;
    L_0x05bf:
        r4 = r5;
    L_0x05c0:
        if (r2 == 0) goto L_0x05c4;
    L_0x05c2:
        if (r4 < r8) goto L_0x062b;
    L_0x05c4:
        if (r2 == 0) goto L_0x0748;
    L_0x05c6:
        r2 = r4 - r5;
        r0 = r21;
        r3 = com.jcraft.jsch.Util.j6(r0, r5, r2);	 Catch:{ Exception -> 0x06df }
        if (r20 == 0) goto L_0x05d3;
    L_0x05d0:
        r2 = 3;
        if (r7 != r2) goto L_0x0748;
    L_0x05d3:
        r2 = 8;
        r2 = r3[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 100;
        if (r2 != r4) goto L_0x064b;
    L_0x05db:
        r7 = 1;
        r4 = r3;
        r3 = r9;
    L_0x05de:
        r2 = 0;
        r5 = 1;
        if (r7 != r5) goto L_0x06fc;
    L_0x05e2:
        r2 = new com.jcraft.jsch.KeyPairDSA;
        r0 = r19;
        r2.<init>(r0);
    L_0x05e9:
        if (r2 == 0) goto L_0x0059;
    L_0x05eb:
        r2.v5 = r12;
        r2.J0 = r4;
        r2.j6 = r6;
        r2.DW = r3;
        r2.gn = r13;
        if (r12 == 0) goto L_0x0714;
    L_0x05f7:
        r3 = 1;
        r2.v5 = r3;
        r2.we = r14;
        r2.Zo = r11;
        goto L_0x0059;
    L_0x0600:
        r4 = r21[r5];	 Catch:{ Exception -> 0x06df }
        r10 = 10;
        if (r4 != r10) goto L_0x0628;
    L_0x0606:
        r4 = 0;
        r10 = r5 + 1;
    L_0x0609:
        r0 = r21;
        r15 = r0.length;	 Catch:{ Exception -> 0x06df }
        if (r10 < r15) goto L_0x0613;
    L_0x060e:
        if (r4 != 0) goto L_0x0628;
    L_0x0610:
        r5 = r5 + 1;
        goto L_0x05b9;
    L_0x0613:
        r15 = r21[r10];	 Catch:{ Exception -> 0x06df }
        r16 = 10;
        r0 = r16;
        if (r15 == r0) goto L_0x060e;
    L_0x061b:
        r15 = r21[r10];	 Catch:{ Exception -> 0x06df }
        r16 = 58;
        r0 = r16;
        if (r15 != r0) goto L_0x0625;
    L_0x0623:
        r4 = 1;
        goto L_0x060e;
    L_0x0625:
        r10 = r10 + 1;
        goto L_0x0609;
    L_0x0628:
        r5 = r5 + 1;
        goto L_0x05b7;
    L_0x062b:
        r10 = r21[r4];	 Catch:{ Exception -> 0x06df }
        r15 = 10;
        if (r10 != r15) goto L_0x0641;
    L_0x0631:
        r10 = r4 + 1;
        r15 = r8 - r4;
        r15 = r15 + -1;
        r0 = r21;
        r1 = r21;
        java.lang.System.arraycopy(r0, r10, r1, r4, r15);	 Catch:{ Exception -> 0x06df }
        r8 = r8 + -1;
        goto L_0x05c0;
    L_0x0641:
        r10 = r21[r4];	 Catch:{ Exception -> 0x06df }
        r15 = 45;
        if (r10 == r15) goto L_0x05c4;
    L_0x0647:
        r4 = r4 + 1;
        goto L_0x05c0;
    L_0x064b:
        r2 = 8;
        r2 = r3[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r2 != r4) goto L_0x0748;
    L_0x0653:
        r7 = 2;
        r4 = r3;
        r3 = r9;
        goto L_0x05de;
    L_0x0657:
        r2 = 0;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r2 != r4) goto L_0x0748;
    L_0x065e:
        r2 = 1;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r2 != r4) goto L_0x0748;
    L_0x0665:
        r2 = 2;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r2 != r4) goto L_0x0748;
    L_0x066c:
        r2 = 3;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 45;
        if (r2 != r4) goto L_0x0748;
    L_0x0673:
        if (r20 != 0) goto L_0x0745;
    L_0x0675:
        r0 = r21;
        r2 = r0.length;	 Catch:{ Exception -> 0x06df }
        r4 = 7;
        if (r2 <= r4) goto L_0x0745;
    L_0x067b:
        r2 = 4;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 100;
        if (r2 != r4) goto L_0x06bb;
    L_0x0682:
        r2 = 1;
    L_0x0683:
        r4 = 0;
    L_0x0684:
        if (r4 < r8) goto L_0x06c4;
    L_0x0686:
        r5 = r4 + 1;
        if (r5 >= r8) goto L_0x0742;
    L_0x068a:
        r4 = r5;
    L_0x068b:
        if (r4 < r8) goto L_0x06cd;
    L_0x068d:
        r7 = r4 - r5;
        r0 = r21;
        r3 = com.jcraft.jsch.Util.j6(r0, r5, r7);	 Catch:{ Exception -> 0x0737 }
    L_0x0695:
        r7 = r4 + 1;
        if (r4 >= r8) goto L_0x073a;
    L_0x0699:
        r4 = r7;
    L_0x069a:
        if (r4 < r8) goto L_0x06d6;
    L_0x069c:
        if (r4 <= 0) goto L_0x073f;
    L_0x069e:
        r5 = r4 + -1;
        r5 = r21[r5];	 Catch:{ Exception -> 0x0737 }
        r8 = 13;
        if (r5 != r8) goto L_0x073f;
    L_0x06a6:
        r4 = r4 + -1;
        r5 = r4;
    L_0x06a9:
        if (r7 >= r5) goto L_0x073a;
    L_0x06ab:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0737 }
        r5 = r5 - r7;
        r0 = r21;
        r4.<init>(r0, r7, r5);	 Catch:{ Exception -> 0x0737 }
        r7 = r2;
        r18 = r4;
        r4 = r3;
        r3 = r18;
        goto L_0x05de;
    L_0x06bb:
        r2 = 4;
        r2 = r21[r2];	 Catch:{ Exception -> 0x06df }
        r4 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r2 != r4) goto L_0x0745;
    L_0x06c2:
        r2 = 2;
        goto L_0x0683;
    L_0x06c4:
        r5 = r21[r4];	 Catch:{ Exception -> 0x0737 }
        r7 = 32;
        if (r5 == r7) goto L_0x0686;
    L_0x06ca:
        r4 = r4 + 1;
        goto L_0x0684;
    L_0x06cd:
        r7 = r21[r4];	 Catch:{ Exception -> 0x0737 }
        r10 = 32;
        if (r7 == r10) goto L_0x068d;
    L_0x06d3:
        r4 = r4 + 1;
        goto L_0x068b;
    L_0x06d6:
        r5 = r21[r4];	 Catch:{ Exception -> 0x0737 }
        r10 = 10;
        if (r5 == r10) goto L_0x069c;
    L_0x06dc:
        r4 = r4 + 1;
        goto L_0x069a;
    L_0x06df:
        r2 = move-exception;
    L_0x06e0:
        r4 = r3;
        r3 = r9;
        goto L_0x05de;
    L_0x06e4:
        r3 = r2 instanceof java.lang.Throwable;
        if (r3 == 0) goto L_0x06f2;
    L_0x06e8:
        r3 = new com.jcraft.jsch.JSchException;
        r4 = r2.toString();
        r3.<init>(r4, r2);
        throw r3;
    L_0x06f2:
        r3 = new com.jcraft.jsch.JSchException;
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x06fc:
        r5 = 2;
        if (r7 != r5) goto L_0x0708;
    L_0x06ff:
        r2 = new com.jcraft.jsch.KeyPairRSA;
        r0 = r19;
        r2.<init>(r0);
        goto L_0x05e9;
    L_0x0708:
        r5 = 3;
        if (r6 != r5) goto L_0x05e9;
    L_0x070b:
        r2 = new com.jcraft.jsch.KeyPairPKCS8;
        r0 = r19;
        r2.<init>(r0);
        goto L_0x05e9;
    L_0x0714:
        r3 = r2.DW(r11);
        if (r3 == 0) goto L_0x071f;
    L_0x071a:
        r3 = 0;
        r2.v5 = r3;
        goto L_0x0059;
    L_0x071f:
        r2 = new com.jcraft.jsch.JSchException;
        r3 = new java.lang.StringBuilder;
        r4 = "invalid privatekey: ";
        r3.<init>(r4);
        r0 = r20;
        r3 = r3.append(r0);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0737:
        r4 = move-exception;
        r7 = r2;
        goto L_0x06e0;
    L_0x073a:
        r7 = r2;
        r4 = r3;
        r3 = r9;
        goto L_0x05de;
    L_0x073f:
        r5 = r4;
        goto L_0x06a9;
    L_0x0742:
        r4 = r5;
        goto L_0x0695;
    L_0x0745:
        r2 = r7;
        goto L_0x0683;
    L_0x0748:
        r4 = r3;
        r3 = r9;
        goto L_0x05de;
    L_0x074c:
        r11 = r2;
        r12 = r8;
        goto L_0x057b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KeyPair.j6(com.jcraft.jsch.JSch, byte[], byte[]):com.jcraft.jsch.KeyPair");
    }

    private static byte j6(byte b) {
        if (48 > b || b > 57) {
            return (byte) ((b - 97) + 10);
        }
        return (byte) (b - 48);
    }

    public void Zo() {
        Util.Hw(this.tp);
    }

    public void finalize() {
        Zo();
    }

    static KeyPair j6(JSch jSch, byte[] bArr) {
        byte[] bArr2 = (byte[]) null;
        bArr2 = (byte[]) null;
        Buffer buffer = new Buffer(bArr);
        Hashtable hashtable = new Hashtable();
        do {
        } while (j6(buffer, hashtable));
        String str = (String) hashtable.get("PuTTY-User-Key-File-2");
        if (str == null) {
            return null;
        }
        KeyPair keyPairRSA;
        byte[] j6 = j6(buffer, Integer.parseInt((String) hashtable.get("Public-Lines")));
        do {
        } while (j6(buffer, hashtable));
        byte[] j62 = j6(buffer, Integer.parseInt((String) hashtable.get("Private-Lines")));
        do {
        } while (j6(buffer, hashtable));
        byte[] j63 = Util.j6(j62, 0, j62.length);
        j62 = Util.j6(j6, 0, j6.length);
        Buffer buffer2;
        byte[] bArr3;
        if (str.equals("ssh-rsa")) {
            buffer2 = new Buffer(j62);
            buffer2.DW(j62.length);
            buffer2.Hw(new byte[buffer2.Hw()]);
            bArr3 = new byte[buffer2.Hw()];
            buffer2.Hw(bArr3);
            j6 = new byte[buffer2.Hw()];
            buffer2.Hw(j6);
            keyPairRSA = new KeyPairRSA(jSch, j6, bArr3, null);
        } else if (!str.equals("ssh-dss")) {
            return null;
        } else {
            buffer2 = new Buffer(j62);
            buffer2.DW(j62.length);
            buffer2.Hw(new byte[buffer2.Hw()]);
            bArr3 = new byte[buffer2.Hw()];
            buffer2.Hw(bArr3);
            j6 = new byte[buffer2.Hw()];
            buffer2.Hw(j6);
            byte[] bArr4 = new byte[buffer2.Hw()];
            buffer2.Hw(bArr4);
            byte[] bArr5 = new byte[buffer2.Hw()];
            buffer2.Hw(bArr5);
            keyPairRSA = new KeyPairDSA(jSch, bArr3, j6, bArr4, bArr5, null);
        }
        if (keyPairRSA == null) {
            return null;
        }
        keyPairRSA.v5 = !hashtable.get("Encryption").equals("none");
        keyPairRSA.j6 = 2;
        keyPairRSA.DW = (String) hashtable.get("Comment");
        if (!keyPairRSA.v5) {
            keyPairRSA.Zo = j63;
            keyPairRSA.DW(j63);
        } else if (Session.VH(JSch.DW("aes256-cbc"))) {
            try {
                keyPairRSA.gn = (Cipher) Class.forName(JSch.DW("aes256-cbc")).newInstance();
                keyPairRSA.we = new byte[keyPairRSA.gn.j6()];
                keyPairRSA.Zo = j63;
            } catch (Exception e) {
                throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
            }
        } else {
            throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
        }
        return keyPairRSA;
    }

    private static byte[] j6(Buffer buffer, int i) {
        Object obj = buffer.DW;
        int i2 = buffer.FH;
        Object obj2 = (byte[]) null;
        int i3 = i2;
        int i4 = i2;
        while (true) {
            int i5 = i - 1;
            if (i <= 0) {
                break;
            }
            Object obj3;
            while (obj.length > i4) {
                i2 = i4 + 1;
                if (obj[i4] == 13) {
                    if (obj2 == null) {
                        obj3 = new byte[((i2 - i3) - 1)];
                        System.arraycopy(obj, i3, obj3, 0, (i2 - i3) - 1);
                    } else {
                        Object obj4 = new byte[(((obj2.length + i2) - i3) - 1)];
                        System.arraycopy(obj2, 0, obj4, 0, obj2.length);
                        System.arraycopy(obj, i3, obj4, obj2.length, (i2 - i3) - 1);
                        for (i4 = 0; i4 < obj2.length; i4++) {
                            obj2[i4] = null;
                        }
                        obj3 = obj4;
                    }
                    if (obj[i2] == 10) {
                        i2++;
                    }
                    obj2 = obj3;
                    i3 = i2;
                    i = i5;
                    i4 = i2;
                } else {
                    i4 = i2;
                }
            }
            i2 = i4;
            obj3 = obj2;
            if (obj[i2] == 10) {
                i2++;
            }
            obj2 = obj3;
            i3 = i2;
            i = i5;
            i4 = i2;
        }
        if (obj2 != null) {
            buffer.FH = i3;
        }
        return obj2;
    }

    private static boolean j6(Buffer buffer, Hashtable hashtable) {
        Object obj;
        byte[] bArr = buffer.DW;
        int i = buffer.FH;
        int i2 = i;
        while (i2 < bArr.length) {
            if (bArr[i2] == (byte) 13) {
                obj = null;
                break;
            } else if (bArr[i2] == 58) {
                obj = new String(bArr, i, i2 - i);
                i2++;
                if (i2 < bArr.length && bArr[i2] == 32) {
                    i2++;
                }
                i = i2;
            } else {
                i2++;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        for (i2 = i; i2 < bArr.length; i2++) {
            if (bArr[i2] == (byte) 13) {
                String str = new String(bArr, i, i2 - i);
                i2++;
                if (i2 < bArr.length && bArr[i2] == 10) {
                    i2++;
                }
                i = i2;
                String str2 = str;
                if (r0 != null) {
                    hashtable.put(obj, r0);
                    buffer.FH = i;
                }
                if (obj != null || r0 == null) {
                    return false;
                }
                return true;
            }
        }
        Object obj2 = null;
        if (obj2 != null) {
            hashtable.put(obj, obj2);
            buffer.FH = i;
        }
        if (obj != null) {
        }
        return false;
    }

    void j6(KeyPair keyPair) {
        this.J0 = keyPair.J0;
        this.j6 = keyPair.j6;
        this.DW = keyPair.DW;
        this.gn = keyPair.gn;
    }
}
