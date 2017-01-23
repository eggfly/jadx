import com.aide.uidesigner.ProxyTextView;

public class beu implements beo {
    private static final byte[] VH;
    private int DW;
    private byte[] FH;
    private int Hw;
    private int Zo;
    private byte[] j6;
    private byte[] v5;

    public beu() {
        this.j6 = new byte[48];
        this.FH = new byte[16];
        this.v5 = new byte[16];
        FH();
    }

    public String j6() {
        return "MD2";
    }

    public int DW() {
        return 16;
    }

    public int j6(byte[] bArr, int i) {
        byte length = (byte) (this.FH.length - this.Hw);
        for (int i2 = this.Hw; i2 < this.FH.length; i2++) {
            this.FH[i2] = length;
        }
        j6(this.FH);
        DW(this.FH);
        DW(this.v5);
        System.arraycopy(this.j6, this.DW, bArr, i, 16);
        FH();
        return 16;
    }

    public void FH() {
        int i;
        this.DW = 0;
        for (i = 0; i != this.j6.length; i++) {
            this.j6[i] = (byte) 0;
        }
        this.Hw = 0;
        for (i = 0; i != this.FH.length; i++) {
            this.FH[i] = (byte) 0;
        }
        this.Zo = 0;
        for (i = 0; i != this.v5.length; i++) {
            this.v5[i] = (byte) 0;
        }
    }

    public void j6(byte b) {
        byte[] bArr = this.FH;
        int i = this.Hw;
        this.Hw = i + 1;
        bArr[i] = b;
        if (this.Hw == 16) {
            j6(this.FH);
            DW(this.FH);
            this.Hw = 0;
        }
    }

    public void j6(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        while (this.Hw != 0) {
            if (i2 <= 0) {
                i3 = i2;
                i4 = i;
                break;
            }
            j6(bArr[i]);
            i++;
            i2--;
        }
        i3 = i2;
        i4 = i;
        while (i3 > 16) {
            System.arraycopy(bArr, i4, this.FH, 0, 16);
            j6(this.FH);
            DW(this.FH);
            i3 -= 16;
            i4 += 16;
        }
        while (i3 > 0) {
            j6(bArr[i4]);
            i4++;
            i3--;
        }
    }

    protected void j6(byte[] bArr) {
        int i = this.v5[15];
        for (int i2 = 0; i2 < 16; i2++) {
            byte[] bArr2 = this.v5;
            bArr2[i2] = (byte) (VH[(i ^ bArr[i2]) & 255] ^ bArr2[i2]);
            i = this.v5[i2];
        }
    }

    protected void DW(byte[] bArr) {
        int i;
        for (i = 0; i < 16; i++) {
            this.j6[i + 16] = bArr[i];
            this.j6[i + 32] = (byte) (bArr[i] ^ this.j6[i]);
        }
        int i2 = 0;
        i = 0;
        while (i2 < 18) {
            int i3 = i;
            for (i = 0; i < 48; i++) {
                byte[] bArr2 = this.j6;
                byte b = (byte) (VH[i3] ^ bArr2[i]);
                bArr2[i] = b;
                i3 = b & 255;
            }
            i3 = (i3 + i2) % 256;
            i2++;
            i = i3;
        }
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = (byte) 41;
        bArr[1] = (byte) 46;
        bArr[2] = (byte) 67;
        bArr[3] = (byte) -55;
        bArr[4] = (byte) -94;
        bArr[5] = (byte) -40;
        bArr[6] = (byte) 124;
        bArr[7] = (byte) 1;
        bArr[8] = (byte) 61;
        bArr[9] = (byte) 54;
        bArr[10] = (byte) 84;
        bArr[11] = (byte) -95;
        bArr[12] = (byte) -20;
        bArr[13] = (byte) -16;
        bArr[14] = (byte) 6;
        bArr[15] = (byte) 19;
        bArr[16] = (byte) 98;
        bArr[17] = (byte) -89;
        bArr[18] = (byte) 5;
        bArr[19] = (byte) -13;
        bArr[20] = (byte) -64;
        bArr[21] = (byte) -57;
        bArr[22] = (byte) 115;
        bArr[23] = (byte) -116;
        bArr[24] = (byte) -104;
        bArr[25] = (byte) -109;
        bArr[26] = (byte) 43;
        bArr[27] = (byte) -39;
        bArr[28] = (byte) -68;
        bArr[29] = (byte) 76;
        bArr[30] = (byte) -126;
        bArr[31] = (byte) -54;
        bArr[32] = (byte) 30;
        bArr[33] = (byte) -101;
        bArr[34] = (byte) 87;
        bArr[35] = (byte) 60;
        bArr[36] = (byte) -3;
        bArr[37] = (byte) -44;
        bArr[38] = (byte) -32;
        bArr[39] = (byte) 22;
        bArr[40] = (byte) 103;
        bArr[41] = (byte) 66;
        bArr[42] = (byte) 111;
        bArr[43] = (byte) 24;
        bArr[44] = (byte) -118;
        bArr[45] = (byte) 23;
        bArr[46] = (byte) -27;
        bArr[47] = (byte) 18;
        bArr[48] = (byte) -66;
        bArr[49] = (byte) 78;
        bArr[50] = (byte) -60;
        bArr[51] = (byte) -42;
        bArr[52] = (byte) -38;
        bArr[53] = (byte) -98;
        bArr[54] = (byte) -34;
        bArr[55] = (byte) 73;
        bArr[56] = (byte) -96;
        bArr[57] = (byte) -5;
        bArr[58] = (byte) -11;
        bArr[59] = (byte) -114;
        bArr[60] = (byte) -69;
        bArr[61] = (byte) 47;
        bArr[62] = (byte) -18;
        bArr[63] = (byte) 122;
        bArr[64] = (byte) -87;
        bArr[65] = (byte) 104;
        bArr[66] = (byte) 121;
        bArr[67] = (byte) -111;
        bArr[68] = (byte) 21;
        bArr[69] = (byte) -78;
        bArr[70] = (byte) 7;
        bArr[71] = (byte) 63;
        bArr[72] = (byte) -108;
        bArr[73] = (byte) -62;
        bArr[74] = (byte) 16;
        bArr[75] = (byte) -119;
        bArr[76] = (byte) 11;
        bArr[77] = (byte) 34;
        bArr[78] = (byte) 95;
        bArr[79] = (byte) 33;
        bArr[80] = Byte.MIN_VALUE;
        bArr[81] = Byte.MAX_VALUE;
        bArr[82] = (byte) 93;
        bArr[83] = (byte) -102;
        bArr[84] = (byte) 90;
        bArr[85] = (byte) -112;
        bArr[86] = (byte) 50;
        bArr[87] = (byte) 39;
        bArr[88] = (byte) 53;
        bArr[89] = (byte) 62;
        bArr[90] = (byte) -52;
        bArr[91] = (byte) -25;
        bArr[92] = (byte) -65;
        bArr[93] = (byte) -9;
        bArr[94] = (byte) -105;
        bArr[95] = (byte) 3;
        bArr[96] = (byte) -1;
        bArr[97] = (byte) 25;
        bArr[98] = (byte) 48;
        bArr[99] = (byte) -77;
        bArr[100] = (byte) 72;
        bArr[101] = (byte) -91;
        bArr[102] = (byte) -75;
        bArr[103] = (byte) -47;
        bArr[104] = (byte) -41;
        bArr[105] = (byte) 94;
        bArr[106] = (byte) -110;
        bArr[107] = (byte) 42;
        bArr[108] = (byte) -84;
        bArr[109] = (byte) 86;
        bArr[110] = (byte) -86;
        bArr[111] = (byte) -58;
        bArr[112] = (byte) 79;
        bArr[ProxyTextView.INPUTTYPE_textPostalAddress] = (byte) -72;
        bArr[114] = (byte) 56;
        bArr[115] = (byte) -46;
        bArr[116] = (byte) -106;
        bArr[117] = (byte) -92;
        bArr[118] = (byte) 125;
        bArr[119] = (byte) -74;
        bArr[120] = (byte) 118;
        bArr[121] = (byte) -4;
        bArr[122] = (byte) 107;
        bArr[123] = (byte) -30;
        bArr[124] = (byte) -100;
        bArr[125] = (byte) 116;
        bArr[126] = (byte) 4;
        bArr[127] = (byte) -15;
        bArr[128] = (byte) 69;
        bArr[ProxyTextView.INPUTTYPE_textPassword] = (byte) -99;
        bArr[130] = (byte) 112;
        bArr[131] = (byte) 89;
        bArr[132] = (byte) 100;
        bArr[133] = (byte) 113;
        bArr[134] = (byte) -121;
        bArr[135] = (byte) 32;
        bArr[136] = (byte) -122;
        bArr[137] = (byte) 91;
        bArr[138] = (byte) -49;
        bArr[139] = (byte) 101;
        bArr[140] = (byte) -26;
        bArr[141] = (byte) 45;
        bArr[142] = (byte) -88;
        bArr[143] = (byte) 2;
        bArr[144] = (byte) 27;
        bArr[ProxyTextView.INPUTTYPE_textVisiblePassword] = (byte) 96;
        bArr[146] = (byte) 37;
        bArr[147] = (byte) -83;
        bArr[148] = (byte) -82;
        bArr[149] = (byte) -80;
        bArr[150] = (byte) -71;
        bArr[151] = (byte) -10;
        bArr[152] = (byte) 28;
        bArr[153] = (byte) 70;
        bArr[154] = (byte) 97;
        bArr[155] = (byte) 105;
        bArr[156] = (byte) 52;
        bArr[157] = (byte) 64;
        bArr[158] = (byte) 126;
        bArr[159] = (byte) 15;
        bArr[160] = (byte) 85;
        bArr[ProxyTextView.INPUTTYPE_textWebEditText] = (byte) 71;
        bArr[162] = (byte) -93;
        bArr[163] = (byte) 35;
        bArr[164] = (byte) -35;
        bArr[165] = (byte) 81;
        bArr[166] = (byte) -81;
        bArr[167] = (byte) 58;
        bArr[168] = (byte) -61;
        bArr[169] = (byte) 92;
        bArr[170] = (byte) -7;
        bArr[171] = (byte) -50;
        bArr[172] = (byte) -70;
        bArr[173] = (byte) -59;
        bArr[174] = (byte) -22;
        bArr[175] = (byte) 38;
        bArr[176] = (byte) 44;
        bArr[ProxyTextView.INPUTTYPE_textFilter] = (byte) 83;
        bArr[178] = (byte) 13;
        bArr[179] = (byte) 110;
        bArr[180] = (byte) -123;
        bArr[181] = (byte) 40;
        bArr[182] = (byte) -124;
        bArr[183] = (byte) 9;
        bArr[184] = (byte) -45;
        bArr[185] = (byte) -33;
        bArr[186] = (byte) -51;
        bArr[187] = (byte) -12;
        bArr[188] = (byte) 65;
        bArr[189] = (byte) -127;
        bArr[190] = (byte) 77;
        bArr[191] = (byte) 82;
        bArr[192] = (byte) 106;
        bArr[ProxyTextView.INPUTTYPE_textPhonetic] = (byte) -36;
        bArr[194] = (byte) 55;
        bArr[195] = (byte) -56;
        bArr[196] = (byte) 108;
        bArr[197] = (byte) -63;
        bArr[198] = (byte) -85;
        bArr[199] = (byte) -6;
        bArr[200] = (byte) 36;
        bArr[201] = (byte) -31;
        bArr[202] = (byte) 123;
        bArr[203] = (byte) 8;
        bArr[204] = (byte) 12;
        bArr[205] = (byte) -67;
        bArr[206] = (byte) -79;
        bArr[207] = (byte) 74;
        bArr[208] = (byte) 120;
        bArr[ProxyTextView.INPUTTYPE_textWebEmailAddress] = (byte) -120;
        bArr[210] = (byte) -107;
        bArr[211] = (byte) -117;
        bArr[212] = (byte) -29;
        bArr[213] = (byte) 99;
        bArr[214] = (byte) -24;
        bArr[215] = (byte) 109;
        bArr[216] = (byte) -23;
        bArr[217] = (byte) -53;
        bArr[218] = (byte) -43;
        bArr[219] = (byte) -2;
        bArr[220] = (byte) 59;
        bArr[222] = (byte) 29;
        bArr[223] = (byte) 57;
        bArr[224] = (byte) -14;
        bArr[ProxyTextView.INPUTTYPE_textWebPassword] = (byte) -17;
        bArr[226] = (byte) -73;
        bArr[227] = (byte) 14;
        bArr[228] = (byte) 102;
        bArr[229] = (byte) 88;
        bArr[230] = (byte) -48;
        bArr[231] = (byte) -28;
        bArr[232] = (byte) -90;
        bArr[233] = (byte) 119;
        bArr[234] = (byte) 114;
        bArr[235] = (byte) -8;
        bArr[236] = (byte) -21;
        bArr[237] = (byte) 117;
        bArr[238] = (byte) 75;
        bArr[239] = (byte) 10;
        bArr[240] = (byte) 49;
        bArr[241] = (byte) 68;
        bArr[242] = (byte) 80;
        bArr[243] = (byte) -76;
        bArr[244] = (byte) -113;
        bArr[245] = (byte) -19;
        bArr[246] = (byte) 31;
        bArr[247] = (byte) 26;
        bArr[248] = (byte) -37;
        bArr[249] = (byte) -103;
        bArr[250] = (byte) -115;
        bArr[251] = (byte) 51;
        bArr[252] = (byte) -97;
        bArr[253] = (byte) 17;
        bArr[254] = (byte) -125;
        bArr[255] = (byte) 20;
        VH = bArr;
    }
}
