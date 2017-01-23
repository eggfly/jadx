package com.jcraft.jsch;

import java.math.BigInteger;
import java.util.Vector;

public class KeyPairPKCS8 extends KeyPair {
    private static final byte[] EQ;
    private static final byte[] J0;
    private static final byte[] J8;
    private static final byte[] QX;
    private static final byte[] VH;
    private static final byte[] XL;
    private static final byte[] gn;
    private static final byte[] tp;
    private static final byte[] u7;
    private static final byte[] we;
    private KeyPair Ws;

    static {
        VH = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, (byte) 13, (byte) 1, (byte) 1, (byte) 1};
        gn = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -50, (byte) 56, (byte) 4, (byte) 1};
        u7 = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, (byte) 13, (byte) 1, (byte) 5, (byte) 13};
        tp = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, (byte) 13, (byte) 1, (byte) 5, (byte) 12};
        EQ = new byte[]{(byte) 96, (byte) -122, (byte) 72, (byte) 1, (byte) 101, (byte) 3, (byte) 4, (byte) 1, (byte) 2};
        we = new byte[]{(byte) 96, (byte) -122, (byte) 72, (byte) 1, (byte) 101, (byte) 3, (byte) 4, (byte) 1, (byte) 22};
        J0 = new byte[]{(byte) 96, (byte) -122, (byte) 72, (byte) 1, (byte) 101, (byte) 3, (byte) 4, (byte) 1, (byte) 42};
        J8 = new byte[]{(byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, (byte) 13, (byte) 1, (byte) 5, (byte) 3};
        QX = Util.DW("-----BEGIN DSA PRIVATE KEY-----");
        XL = Util.DW("-----END DSA PRIVATE KEY-----");
    }

    public KeyPairPKCS8(JSch jSch) {
        super(jSch);
        this.Ws = null;
    }

    byte[] DW() {
        return null;
    }

    boolean DW(byte[] bArr) {
        try {
            Vector vector = new Vector();
            ASN1[] asn1Arr = (ASN1[]) null;
            asn1Arr = new ASN1(this, bArr).DW();
            ASN1 asn1 = asn1Arr[1];
            ASN1 asn12 = asn1Arr[2];
            asn1Arr = asn1.DW();
            byte[] j6 = asn1Arr[0].j6();
            ASN1[] DW = asn1Arr[1].DW();
            if (DW.length > 0) {
                for (ASN1 j62 : DW) {
                    vector.addElement(j62.j6());
                }
            }
            byte[] j63 = asn12.j6();
            KeyPair keyPairRSA;
            if (Util.DW(j6, VH)) {
                keyPairRSA = new KeyPairRSA(this.FH);
                keyPairRSA.j6((KeyPair) this);
                if (keyPairRSA.DW(j63)) {
                    this.Ws = keyPairRSA;
                }
            } else if (Util.DW(j6, gn)) {
                asn1 = new ASN1(this, j63);
                if (vector.size() == 0) {
                    asn1Arr = asn1.DW();
                    Object j64 = asn1Arr[1].j6();
                    ASN1[] DW2 = asn1Arr[0].DW();
                    for (ASN1 j65 : DW2) {
                        vector.addElement(j65.j6());
                    }
                    vector.addElement(j64);
                } else {
                    vector.addElement(asn1.j6());
                }
                j6 = (byte[]) vector.elementAt(0);
                byte[] bArr2 = (byte[]) vector.elementAt(2);
                byte[] bArr3 = (byte[]) vector.elementAt(3);
                j63 = new KeyPairDSA(this.FH, j6, (byte[]) vector.elementAt(1), bArr2, new BigInteger(bArr2).modPow(new BigInteger(bArr3), new BigInteger(j6)).toByteArray(), bArr3).DW();
                keyPairRSA = new KeyPairDSA(this.FH);
                keyPairRSA.j6((KeyPair) this);
                if (keyPairRSA.DW(j63)) {
                    this.Ws = keyPairRSA;
                }
            }
            if (this.Ws != null) {
                return true;
            }
            return false;
        } catch (ASN1Exception e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public byte[] Hw() {
        return this.Ws.Hw();
    }

    byte[] FH() {
        return this.Ws.FH();
    }

    public byte[] j6(byte[] bArr) {
        return this.Ws.j6(bArr);
    }

    public byte[] j6() {
        return this.Ws.j6();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean FH(byte[] r11) {
        /*
        r10 = this;
        r7 = 1;
        r6 = 0;
        r0 = r10.v5();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r6 = r7;
    L_0x0009:
        return r6;
    L_0x000a:
        if (r11 != 0) goto L_0x0017;
    L_0x000c:
        r0 = r10.v5();
        if (r0 == 0) goto L_0x0015;
    L_0x0012:
        r0 = r6;
    L_0x0013:
        r6 = r0;
        goto L_0x0009;
    L_0x0015:
        r0 = r7;
        goto L_0x0013;
    L_0x0017:
        r0 = 0;
        r0 = (com.jcraft.jsch.KeyPair.ASN1[]) r0;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = new com.jcraft.jsch.KeyPair$ASN1;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r1 = r10.Zo;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0.<init>(r10, r1);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = r0.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r1 = 1;
        r1 = r0[r1];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r1 = r1.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = 0;
        r0 = r0[r2];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = r0.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = 0;
        r2 = r0[r2];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r2.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 1;
        r3 = r0[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = 0;
        r0 = (byte[]) r0;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = 0;
        r0 = (byte[]) r0;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = 0;
        r0 = (byte[]) r0;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = u7;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = com.jcraft.jsch.Util.DW(r2, r0);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        if (r0 == 0) goto L_0x00d6;
    L_0x004e:
        r0 = r3.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = 0;
        r2 = r0[r2];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 1;
        r0 = r0[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r2.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 0;
        r3 = r2[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r2.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 0;
        r3 = r2[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r4 = r3.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = new java.math.BigInteger;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r5 = 1;
        r2 = r2[r5];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r2.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3.<init>(r2);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r3.toString();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r5 = java.lang.Integer.parseInt(r2);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = r0.DW();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = 0;
        r2 = r0[r2];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r2.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = 1;
        r0 = r0[r3];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r8 = r0.j6();	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = r10.Hw(r2);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        if (r0 == 0) goto L_0x0009;
    L_0x009c:
        r2 = 0;
        r2 = (byte[]) r2;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r3 = "pbkdf";
        r3 = com.jcraft.jsch.JSch.DW(r3);	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
        r3 = r3.newInstance();	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
        r3 = (com.jcraft.jsch.PBKDF) r3;	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
        r9 = r0.DW();	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
        r2 = r3.j6(r11, r4, r5, r9);	 Catch:{ Exception -> 0x00e6, ASN1Exception -> 0x00e3 }
    L_0x00b8:
        if (r2 == 0) goto L_0x0009;
    L_0x00ba:
        r3 = 1;
        r0.j6(r3, r2, r8);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        com.jcraft.jsch.Util.Hw(r2);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = r1.length;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r4 = new byte[r2];	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r2 = 0;
        r3 = r1.length;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r5 = 0;
        r0.j6(r1, r2, r3, r4, r5);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = r10.DW(r4);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        if (r0 == 0) goto L_0x0009;
    L_0x00d0:
        r0 = 0;
        r10.v5 = r0;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r6 = r7;
        goto L_0x0009;
    L_0x00d6:
        r0 = J8;	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        r0 = com.jcraft.jsch.Util.DW(r2, r0);	 Catch:{ ASN1Exception -> 0x00e3, Exception -> 0x00e0 }
        if (r0 == 0) goto L_0x0009;
    L_0x00de:
        goto L_0x0009;
    L_0x00e0:
        r0 = move-exception;
        goto L_0x0009;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x0009;
    L_0x00e6:
        r3 = move-exception;
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KeyPairPKCS8.FH(byte[]):boolean");
    }

    Cipher Hw(byte[] bArr) {
        String str;
        String str2;
        try {
            if (Util.DW(bArr, EQ)) {
                str2 = "aes128-cbc";
            } else if (Util.DW(bArr, we)) {
                str2 = "aes192-cbc";
            } else if (Util.DW(bArr, J0)) {
                str2 = "aes256-cbc";
            } else {
                str2 = null;
            }
            try {
                return (Cipher) Class.forName(JSch.DW(str2)).newInstance();
            } catch (Exception e) {
                str = str2;
            }
        } catch (Exception e2) {
            str = null;
            if (JSch.v5().j6(4)) {
                str2 = "";
                if (str == null) {
                    str = "unknown oid: " + Util.FH(bArr);
                } else {
                    str = "function " + str + " is not supported";
                }
                JSch.v5().j6(4, "PKCS8: " + str);
            }
            return null;
        }
    }
}
