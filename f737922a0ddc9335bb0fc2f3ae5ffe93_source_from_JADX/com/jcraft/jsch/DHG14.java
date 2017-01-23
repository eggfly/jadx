package com.jcraft.jsch;

import com.aide.uidesigner.ProxyTextView;

public class DHG14 extends KeyExchange {
    static final byte[] DW;
    static final byte[] j6;
    DH FH;
    byte[] Hw;
    byte[] VH;
    byte[] Zo;
    private int a8;
    private Packet er;
    byte[] gn;
    private int lg;
    private Buffer rN;
    byte[] v5;

    public DHG14() {
        this.a8 = 0;
    }

    static {
        j6 = new byte[]{(byte) 2};
        byte[] bArr = new byte[257];
        bArr[1] = (byte) -1;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[4] = (byte) -1;
        bArr[5] = (byte) -1;
        bArr[6] = (byte) -1;
        bArr[7] = (byte) -1;
        bArr[8] = (byte) -1;
        bArr[9] = (byte) -55;
        bArr[10] = (byte) 15;
        bArr[11] = (byte) -38;
        bArr[12] = (byte) -94;
        bArr[13] = (byte) 33;
        bArr[14] = (byte) 104;
        bArr[15] = (byte) -62;
        bArr[16] = (byte) 52;
        bArr[17] = (byte) -60;
        bArr[18] = (byte) -58;
        bArr[19] = (byte) 98;
        bArr[20] = (byte) -117;
        bArr[21] = Byte.MIN_VALUE;
        bArr[22] = (byte) -36;
        bArr[23] = (byte) 28;
        bArr[24] = (byte) -47;
        bArr[25] = (byte) 41;
        bArr[26] = (byte) 2;
        bArr[27] = (byte) 78;
        bArr[28] = (byte) 8;
        bArr[29] = (byte) -118;
        bArr[30] = (byte) 103;
        bArr[31] = (byte) -52;
        bArr[32] = (byte) 116;
        bArr[33] = (byte) 2;
        bArr[34] = (byte) 11;
        bArr[35] = (byte) -66;
        bArr[36] = (byte) -90;
        bArr[37] = (byte) 59;
        bArr[38] = (byte) 19;
        bArr[39] = (byte) -101;
        bArr[40] = (byte) 34;
        bArr[41] = (byte) 81;
        bArr[42] = (byte) 74;
        bArr[43] = (byte) 8;
        bArr[44] = (byte) 121;
        bArr[45] = (byte) -114;
        bArr[46] = (byte) 52;
        bArr[47] = (byte) 4;
        bArr[48] = (byte) -35;
        bArr[49] = (byte) -17;
        bArr[50] = (byte) -107;
        bArr[51] = (byte) 25;
        bArr[52] = (byte) -77;
        bArr[53] = (byte) -51;
        bArr[54] = (byte) 58;
        bArr[55] = (byte) 67;
        bArr[56] = (byte) 27;
        bArr[57] = (byte) 48;
        bArr[58] = (byte) 43;
        bArr[59] = (byte) 10;
        bArr[60] = (byte) 109;
        bArr[61] = (byte) -14;
        bArr[62] = (byte) 95;
        bArr[63] = (byte) 20;
        bArr[64] = (byte) 55;
        bArr[65] = (byte) 79;
        bArr[66] = (byte) -31;
        bArr[67] = (byte) 53;
        bArr[68] = (byte) 109;
        bArr[69] = (byte) 109;
        bArr[70] = (byte) 81;
        bArr[71] = (byte) -62;
        bArr[72] = (byte) 69;
        bArr[73] = (byte) -28;
        bArr[74] = (byte) -123;
        bArr[75] = (byte) -75;
        bArr[76] = (byte) 118;
        bArr[77] = (byte) 98;
        bArr[78] = (byte) 94;
        bArr[79] = (byte) 126;
        bArr[80] = (byte) -58;
        bArr[81] = (byte) -12;
        bArr[82] = (byte) 76;
        bArr[83] = (byte) 66;
        bArr[84] = (byte) -23;
        bArr[85] = (byte) -90;
        bArr[86] = (byte) 55;
        bArr[87] = (byte) -19;
        bArr[88] = (byte) 107;
        bArr[89] = (byte) 11;
        bArr[90] = (byte) -1;
        bArr[91] = (byte) 92;
        bArr[92] = (byte) -74;
        bArr[93] = (byte) -12;
        bArr[94] = (byte) 6;
        bArr[95] = (byte) -73;
        bArr[96] = (byte) -19;
        bArr[97] = (byte) -18;
        bArr[98] = (byte) 56;
        bArr[99] = (byte) 107;
        bArr[100] = (byte) -5;
        bArr[101] = (byte) 90;
        bArr[102] = (byte) -119;
        bArr[103] = (byte) -97;
        bArr[104] = (byte) -91;
        bArr[105] = (byte) -82;
        bArr[106] = (byte) -97;
        bArr[107] = (byte) 36;
        bArr[108] = (byte) 17;
        bArr[109] = (byte) 124;
        bArr[110] = (byte) 75;
        bArr[111] = (byte) 31;
        bArr[112] = (byte) -26;
        bArr[ProxyTextView.INPUTTYPE_textPostalAddress] = (byte) 73;
        bArr[114] = (byte) 40;
        bArr[115] = (byte) 102;
        bArr[116] = (byte) 81;
        bArr[117] = (byte) -20;
        bArr[118] = (byte) -28;
        bArr[119] = (byte) 91;
        bArr[120] = (byte) 61;
        bArr[121] = (byte) -62;
        bArr[123] = (byte) 124;
        bArr[124] = (byte) -72;
        bArr[125] = (byte) -95;
        bArr[126] = (byte) 99;
        bArr[127] = (byte) -65;
        bArr[128] = (byte) 5;
        bArr[ProxyTextView.INPUTTYPE_textPassword] = (byte) -104;
        bArr[130] = (byte) -38;
        bArr[131] = (byte) 72;
        bArr[132] = (byte) 54;
        bArr[133] = (byte) 28;
        bArr[134] = (byte) 85;
        bArr[135] = (byte) -45;
        bArr[136] = (byte) -102;
        bArr[137] = (byte) 105;
        bArr[138] = (byte) 22;
        bArr[139] = (byte) 63;
        bArr[140] = (byte) -88;
        bArr[141] = (byte) -3;
        bArr[142] = (byte) 36;
        bArr[143] = (byte) -49;
        bArr[144] = (byte) 95;
        bArr[ProxyTextView.INPUTTYPE_textVisiblePassword] = (byte) -125;
        bArr[146] = (byte) 101;
        bArr[147] = (byte) 93;
        bArr[148] = (byte) 35;
        bArr[149] = (byte) -36;
        bArr[150] = (byte) -93;
        bArr[151] = (byte) -83;
        bArr[152] = (byte) -106;
        bArr[153] = (byte) 28;
        bArr[154] = (byte) 98;
        bArr[155] = (byte) -13;
        bArr[156] = (byte) 86;
        bArr[157] = (byte) 32;
        bArr[158] = (byte) -123;
        bArr[159] = (byte) 82;
        bArr[160] = (byte) -69;
        bArr[ProxyTextView.INPUTTYPE_textWebEditText] = (byte) -98;
        bArr[162] = (byte) -43;
        bArr[163] = (byte) 41;
        bArr[164] = (byte) 7;
        bArr[165] = (byte) 112;
        bArr[166] = (byte) -106;
        bArr[167] = (byte) -106;
        bArr[168] = (byte) 109;
        bArr[169] = (byte) 103;
        bArr[170] = (byte) 12;
        bArr[171] = (byte) 53;
        bArr[172] = (byte) 78;
        bArr[173] = (byte) 74;
        bArr[174] = (byte) -68;
        bArr[175] = (byte) -104;
        bArr[176] = (byte) 4;
        bArr[ProxyTextView.INPUTTYPE_textFilter] = (byte) -15;
        bArr[178] = (byte) 116;
        bArr[179] = (byte) 108;
        bArr[180] = (byte) 8;
        bArr[181] = (byte) -54;
        bArr[182] = (byte) 24;
        bArr[183] = (byte) 33;
        bArr[184] = (byte) 124;
        bArr[185] = (byte) 50;
        bArr[186] = (byte) -112;
        bArr[187] = (byte) 94;
        bArr[188] = (byte) 70;
        bArr[189] = (byte) 46;
        bArr[190] = (byte) 54;
        bArr[191] = (byte) -50;
        bArr[192] = (byte) 59;
        bArr[ProxyTextView.INPUTTYPE_textPhonetic] = (byte) -29;
        bArr[194] = (byte) -98;
        bArr[195] = (byte) 119;
        bArr[196] = (byte) 44;
        bArr[197] = (byte) 24;
        bArr[198] = (byte) 14;
        bArr[199] = (byte) -122;
        bArr[200] = (byte) 3;
        bArr[201] = (byte) -101;
        bArr[202] = (byte) 39;
        bArr[203] = (byte) -125;
        bArr[204] = (byte) -94;
        bArr[205] = (byte) -20;
        bArr[206] = (byte) 7;
        bArr[207] = (byte) -94;
        bArr[208] = (byte) -113;
        bArr[ProxyTextView.INPUTTYPE_textWebEmailAddress] = (byte) -75;
        bArr[210] = (byte) -59;
        bArr[211] = (byte) 93;
        bArr[212] = (byte) -16;
        bArr[213] = (byte) 111;
        bArr[214] = (byte) 76;
        bArr[215] = (byte) 82;
        bArr[216] = (byte) -55;
        bArr[217] = (byte) -34;
        bArr[218] = (byte) 43;
        bArr[219] = (byte) -53;
        bArr[220] = (byte) -10;
        bArr[221] = (byte) -107;
        bArr[222] = (byte) 88;
        bArr[223] = (byte) 23;
        bArr[224] = (byte) 24;
        bArr[ProxyTextView.INPUTTYPE_textWebPassword] = (byte) 57;
        bArr[226] = (byte) -107;
        bArr[227] = (byte) 73;
        bArr[228] = (byte) 124;
        bArr[229] = (byte) -22;
        bArr[230] = (byte) -107;
        bArr[231] = (byte) 106;
        bArr[232] = (byte) -27;
        bArr[233] = (byte) 21;
        bArr[234] = (byte) -46;
        bArr[235] = (byte) 38;
        bArr[236] = (byte) 24;
        bArr[237] = (byte) -104;
        bArr[238] = (byte) -6;
        bArr[239] = (byte) 5;
        bArr[240] = (byte) 16;
        bArr[241] = (byte) 21;
        bArr[242] = (byte) 114;
        bArr[243] = (byte) -114;
        bArr[244] = (byte) 90;
        bArr[245] = (byte) -118;
        bArr[246] = (byte) -84;
        bArr[247] = (byte) -86;
        bArr[248] = (byte) 104;
        bArr[249] = (byte) -1;
        bArr[250] = (byte) -1;
        bArr[251] = (byte) -1;
        bArr[252] = (byte) -1;
        bArr[253] = (byte) -1;
        bArr[254] = (byte) -1;
        bArr[255] = (byte) -1;
        bArr[256] = (byte) -1;
        DW = bArr;
    }

    public void j6(Session session, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.XL = session;
        this.Hw = bArr;
        this.v5 = bArr2;
        this.Zo = bArr3;
        this.VH = bArr4;
        try {
            this.aM = (HASH) Class.forName(session.v5("sha-1")).newInstance();
            this.aM.j6();
        } catch (Exception e) {
            System.err.println(e);
        }
        this.rN = new Buffer();
        this.er = new Packet(this.rN);
        try {
            this.FH = (DH) Class.forName(session.v5("dh")).newInstance();
            this.FH.j6();
            this.FH.j6(DW);
            this.FH.DW(j6);
            this.gn = this.FH.DW();
            this.er.j6();
            this.rN.j6((byte) 30);
            this.rN.FH(this.gn);
            if (bArr != null) {
                session.DW(this.er);
                if (JSch.v5().j6(1)) {
                    JSch.v5().j6(1, "SSH_MSG_KEXDH_INIT sent");
                    JSch.v5().j6(1, "expecting SSH_MSG_KEXDH_REPLY");
                }
                this.lg = 31;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public boolean j6(Buffer buffer) {
        SignatureRSA signatureRSA;
        Object e;
        boolean DW;
        Exception exception;
        SignatureDSA signatureDSA;
        switch (this.lg) {
            case 31:
                buffer.Hw();
                buffer.VH();
                int VH = buffer.VH();
                if (VH != 31) {
                    System.err.println("type: must be 31 " + VH);
                    return false;
                }
                this.U2 = buffer.tp();
                byte[] gn = buffer.gn();
                byte[] tp = buffer.tp();
                this.FH.FH(gn);
                this.j3 = j6(this.FH.FH());
                this.rN.EQ();
                this.rN.DW(this.v5);
                this.rN.DW(this.Hw);
                this.rN.DW(this.VH);
                this.rN.DW(this.Zo);
                this.rN.DW(this.U2);
                this.rN.FH(this.gn);
                this.rN.FH(gn);
                this.rN.FH(this.j3);
                gn = new byte[this.rN.j6()];
                this.rN.Hw(gn);
                this.aM.j6(gn, 0, gn.length);
                this.Mr = this.aM.FH();
                VH = ((((this.U2[0] << 24) & -16777216) | ((this.U2[1] << 16) & 16711680)) | ((this.U2[2] << 8) & 65280)) | (this.U2[3] & 255);
                String FH = Util.FH(this.U2, 4, VH);
                int i = VH + 4;
                int i2;
                int i3;
                Object obj;
                int i4;
                Object obj2;
                if (FH.equals("ssh-rsa")) {
                    this.a8 = 0;
                    i2 = i + 1;
                    i3 = i2 + 1;
                    i = i3 + 1;
                    i3 = i + 1;
                    VH = ((((this.U2[i] << 24) & -16777216) | ((this.U2[i2] << 16) & 16711680)) | ((this.U2[i3] << 8) & 65280)) | (this.U2[i] & 255);
                    obj = new byte[VH];
                    System.arraycopy(this.U2, i3, obj, 0, VH);
                    VH += i3;
                    i3 = VH + 1;
                    i4 = i3 + 1;
                    i3 = i4 + 1;
                    i4 = i3 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i3] << 16) & 16711680)) | ((this.U2[i4] << 8) & 65280)) | (this.U2[i3] & 255);
                    obj2 = new byte[VH];
                    System.arraycopy(this.U2, i4, obj2, 0, VH);
                    VH += i4;
                    try {
                        signatureRSA = (SignatureRSA) Class.forName(this.XL.v5("signature.rsa")).newInstance();
                        try {
                            signatureRSA.j6();
                        } catch (Exception e2) {
                            e = e2;
                            System.err.println(e);
                            signatureRSA.j6(obj, obj2);
                            signatureRSA.j6(this.Mr);
                            DW = signatureRSA.DW(tp);
                            if (JSch.v5().j6(1)) {
                                JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                            }
                            this.lg = 0;
                            return DW;
                        }
                    } catch (Exception e3) {
                        exception = e3;
                        signatureRSA = null;
                        e = exception;
                        System.err.println(e);
                        signatureRSA.j6(obj, obj2);
                        signatureRSA.j6(this.Mr);
                        DW = signatureRSA.DW(tp);
                        if (JSch.v5().j6(1)) {
                            JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                        }
                        this.lg = 0;
                        return DW;
                    }
                    signatureRSA.j6(obj, obj2);
                    signatureRSA.j6(this.Mr);
                    DW = signatureRSA.DW(tp);
                    if (JSch.v5().j6(1)) {
                        JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                    }
                } else if (FH.equals("ssh-dss")) {
                    gn = (byte[]) null;
                    this.a8 = 1;
                    i2 = i + 1;
                    i3 = i2 + 1;
                    i = i3 + 1;
                    i3 = i + 1;
                    VH = ((((this.U2[i] << 24) & -16777216) | ((this.U2[i2] << 16) & 16711680)) | ((this.U2[i3] << 8) & 65280)) | (this.U2[i] & 255);
                    obj = new byte[VH];
                    System.arraycopy(this.U2, i3, obj, 0, VH);
                    VH += i3;
                    i3 = VH + 1;
                    i4 = i3 + 1;
                    i3 = i4 + 1;
                    i4 = i3 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i3] << 16) & 16711680)) | ((this.U2[i4] << 8) & 65280)) | (this.U2[i3] & 255);
                    obj2 = new byte[VH];
                    System.arraycopy(this.U2, i4, obj2, 0, VH);
                    VH += i4;
                    i4 = VH + 1;
                    int i5 = i4 + 1;
                    i4 = i5 + 1;
                    i5 = i4 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i4] << 16) & 16711680)) | ((this.U2[i5] << 8) & 65280)) | (this.U2[i4] & 255);
                    Object obj3 = new byte[VH];
                    System.arraycopy(this.U2, i5, obj3, 0, VH);
                    VH += i5;
                    i5 = VH + 1;
                    int i6 = i5 + 1;
                    i5 = i6 + 1;
                    i6 = i5 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i5] << 16) & 16711680)) | ((this.U2[i6] << 8) & 65280)) | (this.U2[i5] & 255);
                    Object obj4 = new byte[VH];
                    System.arraycopy(this.U2, i6, obj4, 0, VH);
                    VH += i6;
                    try {
                        signatureDSA = (SignatureDSA) Class.forName(this.XL.v5("signature.dss")).newInstance();
                        try {
                            signatureDSA.j6();
                        } catch (Exception e4) {
                            e = e4;
                            System.err.println(e);
                            signatureDSA.j6(obj4, obj, obj2, obj3);
                            signatureDSA.j6(this.Mr);
                            DW = signatureDSA.DW(tp);
                            if (JSch.v5().j6(1)) {
                                JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                            }
                            this.lg = 0;
                            return DW;
                        }
                    } catch (Exception e32) {
                        exception = e32;
                        signatureDSA = null;
                        e = exception;
                        System.err.println(e);
                        signatureDSA.j6(obj4, obj, obj2, obj3);
                        signatureDSA.j6(this.Mr);
                        DW = signatureDSA.DW(tp);
                        if (JSch.v5().j6(1)) {
                            JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                        }
                        this.lg = 0;
                        return DW;
                    }
                    signatureDSA.j6(obj4, obj, obj2, obj3);
                    signatureDSA.j6(this.Mr);
                    DW = signatureDSA.DW(tp);
                    if (JSch.v5().j6(1)) {
                        JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                    }
                } else {
                    System.err.println("unknown alg");
                    DW = false;
                }
                this.lg = 0;
                return DW;
            default:
                return false;
        }
    }

    public String j6() {
        if (this.a8 == 1) {
            return "DSA";
        }
        return "RSA";
    }

    public int DW() {
        return this.lg;
    }
}
