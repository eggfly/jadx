import com.aide.uidesigner.ProxyTextView;
import java.io.OutputStream;

public class asn {
    private static final int[] Zo;
    private static final int[] v5;
    private final int[] DW;
    private final long[] FH;
    private final int Hw;
    private final byte[] j6;

    public static long j6(int i) {
        return (long) (((i * 3) / 4) + i);
    }

    public asn(byte[] bArr) {
        this.j6 = bArr;
        aso aso = new aso(this.j6, this.j6.length);
        this.DW = aso.j6;
        this.Hw = aso.Hw;
        this.FH = new long[(j6(aso) + 1)];
        DW(aso);
    }

    private int j6(aso aso) {
        int i = 0;
        for (int i2 : this.DW) {
            int i22;
            if (i22 != 0) {
                int i3 = i22;
                i22 = 0;
                do {
                    i22++;
                    if (i22 == 64) {
                        aso.FH[i3] = 0;
                        break;
                    }
                    i3 = aso.FH[i3];
                } while (i3 != 0);
                i += i22;
            }
        }
        return i;
    }

    private void DW(aso aso) {
        int i = 1;
        for (int i2 = 0; i2 < this.DW.length; i2++) {
            int i3 = this.DW[i2];
            if (i3 != 0) {
                int i4;
                this.DW[i2] = i;
                int i5 = i3;
                i3 = i;
                i = i5;
                while (true) {
                    i4 = i3 + 1;
                    this.FH[i3] = aso.DW[i];
                    i = aso.FH[i];
                    if (i == 0) {
                        break;
                    }
                    i3 = i4;
                }
                i = i4;
            }
        }
    }

    public long j6() {
        return (long) this.j6.length;
    }

    public long DW() {
        return (((8 + 16) + j6(this.j6)) + j6(this.DW)) + j6(this.FH);
    }

    private static long j6(byte[] bArr) {
        return (long) j6(1, bArr.length);
    }

    private static long j6(int[] iArr) {
        return (long) j6(4, iArr.length);
    }

    private static long j6(long[] jArr) {
        return (long) j6(8, jArr.length);
    }

    private static int j6(int i, int i2) {
        return (i2 * i) + 12;
    }

    public void j6(OutputStream outputStream, byte[] bArr) {
        j6(outputStream, bArr, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j6(java.io.OutputStream r21, byte[] r22, int r23) {
        /*
        r20 = this;
        r0 = r22;
        r14 = r0.length;
        r4 = (long) r14;
        r0 = r20;
        r1 = r21;
        r2 = r23;
        r15 = r0.j6(r1, r4, r2);
        r4 = 16;
        if (r14 < r4) goto L_0x0019;
    L_0x0012:
        r0 = r20;
        r4 = r0.DW;
        r4 = r4.length;
        if (r4 != 0) goto L_0x0020;
    L_0x0019:
        r0 = r22;
        r4 = r15.j6(r0);
    L_0x001f:
        return r4;
    L_0x0020:
        r6 = 0;
        r5 = 16;
        r4 = 0;
        r0 = r22;
        r4 = j6(r0, r4);
        r9 = 0;
        r11 = r4;
        r12 = r5;
        r13 = r6;
    L_0x002e:
        if (r12 < r14) goto L_0x003c;
    L_0x0030:
        r4 = r9;
    L_0x0031:
        if (r4 >= r14) goto L_0x00f6;
    L_0x0033:
        r5 = r14 - r4;
        r0 = r22;
        r4 = r15.j6(r0, r4, r5);
        goto L_0x001f;
    L_0x003c:
        r0 = r20;
        r4 = r0.Hw;
        r16 = r11 & r4;
        r0 = r20;
        r4 = r0.DW;
        r7 = r4[r16];
        if (r7 != 0) goto L_0x005a;
    L_0x004a:
        r6 = r13 + 1;
        r4 = r22[r13];
        r5 = r12 + 1;
        r7 = r22[r12];
        r4 = j6(r11, r4, r7);
        r11 = r4;
        r12 = r5;
        r13 = r6;
        goto L_0x002e;
    L_0x005a:
        r6 = -1;
        r5 = -1;
        r4 = 0;
    L_0x005d:
        r0 = r20;
        r10 = r0.FH;
        r8 = r7 + 1;
        r18 = r10[r7];
        r7 = j6(r18);
        if (r7 != r11) goto L_0x00b9;
    L_0x006b:
        r7 = 0;
        if (r9 >= r13) goto L_0x0080;
    L_0x006e:
        r7 = r13 - r9;
        r0 = r20;
        r10 = r0.j6;
        r17 = DW(r18);
        r0 = r22;
        r1 = r17;
        r7 = j6(r0, r13, r10, r1, r7);
    L_0x0080:
        r0 = r20;
        r10 = r0.j6;
        r17 = DW(r18);
        r0 = r22;
        r1 = r17;
        r10 = j6(r0, r13, r10, r1);
        r10 = r10 + r7;
        if (r6 >= r10) goto L_0x0099;
    L_0x0093:
        r5 = DW(r18);
        r4 = r7;
        r6 = r10;
    L_0x0099:
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r6 >= r7) goto L_0x00a4;
    L_0x009d:
        r0 = r20;
        r7 = r0.FH;
        r7 = r7.length;
        if (r8 < r7) goto L_0x00f9;
    L_0x00a4:
        r7 = 16;
        if (r6 >= r7) goto L_0x00c7;
    L_0x00a8:
        r6 = r13 + 1;
        r4 = r22[r13];
        r5 = r12 + 1;
        r7 = r22[r12];
        r4 = j6(r11, r4, r7);
        r11 = r4;
        r12 = r5;
        r13 = r6;
        goto L_0x002e;
    L_0x00b9:
        r7 = j6(r18);
        r0 = r20;
        r10 = r0.Hw;
        r7 = r7 & r10;
        r0 = r16;
        if (r7 == r0) goto L_0x0099;
    L_0x00c6:
        goto L_0x00a4;
    L_0x00c7:
        r7 = r13 - r4;
        if (r9 >= r7) goto L_0x00d8;
    L_0x00cb:
        r8 = r7 - r9;
        r0 = r22;
        r8 = r15.j6(r0, r9, r8);
        if (r8 != 0) goto L_0x00d8;
    L_0x00d5:
        r4 = 0;
        goto L_0x001f;
    L_0x00d8:
        r4 = r5 - r4;
        r4 = (long) r4;
        r4 = r15.j6(r4, r6);
        if (r4 != 0) goto L_0x00e4;
    L_0x00e1:
        r4 = 0;
        goto L_0x001f;
    L_0x00e4:
        r4 = r7 + r6;
        r6 = r4 + 16;
        if (r14 <= r6) goto L_0x0031;
    L_0x00ea:
        r0 = r22;
        r5 = j6(r0, r4);
        r9 = r4;
        r11 = r5;
        r12 = r6;
        r13 = r4;
        goto L_0x002e;
    L_0x00f6:
        r4 = 1;
        goto L_0x001f;
    L_0x00f9:
        r7 = r8;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: asn.j6(java.io.OutputStream, byte[], int):boolean");
    }

    private asm j6(OutputStream outputStream, long j, int i) {
        return new asm(outputStream, j6(), j, i);
    }

    private static int j6(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i;
        while (i3 < bArr.length && i2 < bArr2.length && bArr[i3] == bArr2[i2]) {
            i3++;
            i2++;
        }
        return i3 - i;
    }

    private static int j6(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i2 == 0) {
            return 0;
        }
        int i4 = i - 1;
        int i5 = i2 - 1;
        int i6 = i4;
        while (bArr[i6] == bArr2[i5]) {
            i6--;
            i5--;
            if (i5 < 0) {
                break;
            }
            i3--;
            if (i3 <= 0) {
                break;
            }
        }
        return i4 - i6;
    }

    public String toString() {
        String[] strArr = new String[]{"bytes", "KiB", "MiB", "GiB"};
        long DW = DW();
        int i = 0;
        while (1024 <= DW && i < strArr.length - 1) {
            int i2 = (int) (DW % 1024);
            DW /= 1024;
            if (i2 != 0) {
                DW++;
            }
            i++;
        }
        return "DeltaIndex[" + DW + " " + strArr[i] + "]";
    }

    static int j6(byte[] bArr, int i) {
        int i2 = ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
        i2 ^= v5[i2 >>> 31];
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 4] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 5] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 6] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 7] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 8] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 9] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 10] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 11] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 12] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 13] & 255));
        i2 = v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 14] & 255));
        return v5[i2 >>> 23] ^ ((i2 << 8) | (bArr[i + 15] & 255));
    }

    private static int j6(int i, byte b, byte b2) {
        int i2 = Zo[b & 255] ^ i;
        return v5[i2 >>> 23] ^ ((i2 << 8) | (b2 & 255));
    }

    private static int j6(long j) {
        return (int) (j >>> 32);
    }

    private static int DW(long j) {
        return (int) j;
    }

    static {
        int[] iArr = new int[256];
        iArr[1] = -725175507;
        iArr[2] = 2102121847;
        iArr[3] = -1450351014;
        iArr[4] = 777066947;
        iArr[5] = -90723602;
        iArr[6] = 1394265268;
        iArr[7] = -2015592551;
        iArr[8] = 1554133894;
        iArr[9] = -2006679381;
        iArr[10] = 568977137;
        iArr[11] = -181447204;
        iArr[12] = 1928538693;
        iArr[13] = -1506436760;
        iArr[14] = 263782194;
        iArr[15] = -612479969;
        iArr[16] = 1837290529;
        iArr[17] = -1186699508;
        iArr[18] = 281608534;
        iArr[19] = -1005604229;
        iArr[20] = 1137954274;
        iArr[21] = -1760198961;
        iArr[22] = 1050155157;
        iArr[23] = -362894408;
        iArr[24] = 824240039;
        iArr[25] = -437889910;
        iArr[26] = 1282093776;
        iArr[27] = -1733459459;
        iArr[28] = 527564388;
        iArr[29] = -877179575;
        iArr[30] = 1647979283;
        iArr[31] = -1224959938;
        iArr[32] = 264444783;
        iArr[33] = -620386238;
        iArr[34] = 1921568280;
        iArr[35] = -1504805579;
        iArr[36] = 563217068;
        iArr[37] = -178998911;
        iArr[38] = 1557780443;
        iArr[39] = -2011208458;
        iArr[40] = 1398876393;
        iArr[41] = -2019058748;
        iArr[42] = 774569374;
        iArr[43] = -85176653;
        iArr[44] = 2100310314;
        iArr[45] = -1443462649;
        iArr[46] = 8119389;
        iArr[47] = -725788816;
        iArr[48] = 1648480078;
        iArr[49] = -1232634781;
        iArr[50] = 520755769;
        iArr[51] = -875779820;
        iArr[52] = 1276171917;
        iArr[53] = -1730779744;
        iArr[54] = 828048378;
        iArr[55] = -442650409;
        iArr[56] = 1055128776;
        iArr[57] = -366653467;
        iArr[58] = 1135094207;
        iArr[59] = -1754359150;
        iArr[60] = 280159499;
        iArr[61] = -999008730;
        iArr[62] = 1845047420;
        iArr[63] = -1187019951;
        iArr[64] = 528889566;
        iArr[65] = -884963853;
        iArr[66] = 1657660329;
        iArr[67] = -1240772476;
        iArr[68] = 836185885;
        iArr[69] = -451830736;
        iArr[70] = 1285356138;
        iArr[71] = -1738913465;
        iArr[72] = 1126434136;
        iArr[73] = -1746749835;
        iArr[74] = 1047515183;
        iArr[75] = -357997822;
        iArr[76] = 1836391579;
        iArr[77] = -1179406410;
        iArr[78] = 272550380;
        iArr[79] = -990348607;
        iArr[80] = 1912922879;
        iArr[81] = -1497214510;
        iArr[82] = 256849800;
        iArr[83] = -611744603;
        iArr[84] = 1549138748;
        iArr[85] = -2003613679;
        iArr[86] = 555626059;
        iArr[87] = -170353306;
        iArr[88] = 782684537;
        iArr[89] = -94346668;
        iArr[90] = 1408041998;
        iArr[91] = -2027178205;
        iArr[92] = 16238778;
        iArr[93] = -734954601;
        iArr[94] = 2109480397;
        iArr[95] = -1451577632;
        iArr[96] = 272969137;
        iArr[97] = -998007140;
        iArr[98] = 1829697734;
        iArr[99] = -1178055701;
        iArr[100] = 1041511538;
        iArr[101] = -355301537;
        iArr[102] = 1130356997;
        iArr[103] = -1751559640;
        iArr[104] = 1290214967;
        iArr[105] = -1742623462;
        iArr[106] = 833407808;
        iArr[107] = -446007187;
        iArr[108] = 1656096756;
        iArr[109] = -1234127655;
        iArr[110] = 536728195;
        iArr[111] = -885300818;
        iArr[112] = 2110257552;
        iArr[ProxyTextView.INPUTTYPE_textPostalAddress] = -1459533123;
        iArr[114] = 9186535;
        iArr[115] = -733306934;
        iArr[116] = 1402396755;
        iArr[117] = -2024778882;
        iArr[118] = 786248996;
        iArr[119] = -98859511;
        iArr[120] = 560318998;
        iArr[121] = -173835973;
        iArr[122] = 1546526561;
        iArr[123] = -1998017460;
        iArr[124] = 255120341;
        iArr[125] = -604872456;
        iArr[126] = 1920927394;
        iArr[127] = -1497778801;
        iArr[128] = 1057779132;
        iArr[ProxyTextView.INPUTTYPE_textPassword] = -339026287;
        iArr[130] = 1111996619;
        iArr[131] = -1769927706;
        iArr[132] = 291337343;
        iArr[133] = -979646638;
        iArr[134] = 1813422344;
        iArr[135] = -1194323419;
        iArr[136] = 1672371770;
        iArr[137] = -1217860329;
        iArr[138] = 518359885;
        iArr[139] = -903661472;
        iArr[140] = 1308575737;
        iArr[141] = -1724255020;
        iArr[142] = 817140366;
        iArr[143] = -462282333;
        iArr[144] = 1385085341;
        iArr[ProxyTextView.INPUTTYPE_textVisiblePassword] = -2042099024;
        iArr[146] = 801467626;
        iArr[147] = -83632185;
        iArr[148] = 2095030366;
        iArr[149] = -1474751629;
        iArr[150] = 26506537;
        iArr[151] = -715995644;
        iArr[152] = 237799963;
        iArr[153] = -622184138;
        iArr[154] = 1936154476;
        iArr[155] = -1482560447;
        iArr[156] = 545100760;
        iArr[157] = -189062923;
        iArr[158] = 1563838127;
        iArr[159] = -1980697214;
        iArr[160] = 818902739;
        iArr[ProxyTextView.INPUTTYPE_textWebEditText] = -469121538;
        iArr[162] = 1300538276;
        iArr[163] = -1723723639;
        iArr[164] = 513699600;
        iArr[165] = -900146115;
        iArr[166] = 1674951271;
        iArr[167] = -1223489206;
        iArr[168] = 1819100501;
        iArr[169] = -1196689800;
        iArr[170] = 287739938;
        iArr[171] = -975166705;
        iArr[172] = 1111252118;
        iArr[173] = -1761939525;
        iArr[174] = 1064798689;
        iArr[175] = -340706612;
        iArr[176] = 1565369074;
        iArr[ProxyTextView.INPUTTYPE_textFilter] = -1987374625;
        iArr[178] = 537294725;
        iArr[179] = -188693336;
        iArr[180] = 1931262769;
        iArr[181] = -1478883300;
        iArr[182] = 240610886;
        iArr[183] = -627974805;
        iArr[184] = 32477556;
        iArr[185] = -718724519;
        iArr[186] = 2091140099;
        iArr[187] = -1469909202;
        iArr[188] = 801015991;
        iArr[189] = -76006502;
        iArr[190] = 1391812032;
        iArr[191] = -2043416851;
        iArr[192] = 545938274;
        iArr[ProxyTextView.INPUTTYPE_textPhonetic] = -196286385;
        iArr[194] = 1572965909;
        iArr[195] = -1996014280;
        iArr[196] = 249250465;
        iArr[197] = -635571828;
        iArr[198] = 1938855894;
        iArr[199] = -1487526661;
        iArr[200] = 2083023076;
        iArr[201] = -1460741175;
        iArr[202] = 23313811;
        iArr[203] = -710603074;
        iArr[204] = 1383690535;
        iArr[205] = -2034253302;
        iArr[206] = 791848016;
        iArr[207] = -67889283;
        iArr[208] = 1292406595;
        iArr[ProxyTextView.INPUTTYPE_textWebEmailAddress] = -1714537362;
        iArr[210] = 809720372;
        iArr[211] = -460986087;
        iArr[212] = 1666815616;
        iArr[213] = -1214306899;
        iArr[214] = 504513527;
        iArr[215] = -892014374;
        iArr[216] = 296402117;
        iArr[217] = -982773784;
        iArr[218] = 1826711986;
        iArr[219] = -1205347681;
        iArr[220] = 1073456390;
        iArr[221] = -348318165;
        iArr[222] = 1118859377;
        iArr[223] = -1770601636;
        iArr[224] = 793329677;
        iArr[ProxyTextView.INPUTTYPE_textWebPassword] = -74452192;
        iArr[226] = 1375901050;
        iArr[227] = -2033965481;
        iArr[228] = 18373070;
        iArr[229] = -706811165;
        iArr[230] = 2085850297;
        iArr[231] = -1466613868;
        iArr[232] = 1944810379;
        iArr[233] = -1490173786;
        iArr[234] = 245409532;
        iArr[235] = -630843951;
        iArr[236] = 1572497992;
        iArr[237] = -1988306587;
        iArr[238] = 552714047;
        iArr[239] = -197719022;
        iArr[240] = 1120637996;
        iArr[241] = -1777522943;
        iArr[242] = 1065369947;
        iArr[243] = -347671946;
        iArr[244] = 1822068207;
        iArr[245] = -1201914174;
        iArr[246] = 298932376;
        iArr[247] = -988288075;
        iArr[248] = 510240682;
        iArr[249] = -894495609;
        iArr[250] = 1663202013;
        iArr[251] = -1209744912;
        iArr[252] = 809025129;
        iArr[253] = -453112508;
        iArr[254] = 1299409694;
        iArr[255] = -1716135885;
        v5 = iArr;
        iArr = new int[256];
        iArr[1] = 315025679;
        iArr[2] = 630051358;
        iArr[3] = 927677201;
        iArr[4] = 1260102716;
        iArr[5] = 1507675443;
        iArr[6] = 1855354402;
        iArr[7] = 2085658413;
        iArr[8] = 1123154773;
        iArr[9] = 1345786458;
        iArr[10] = 1736190283;
        iArr[11] = 1975173188;
        iArr[12] = 166354793;
        iArr[13] = 455915110;
        iArr[14] = 744983927;
        iArr[15] = 1050764408;
        iArr[16] = 1361397127;
        iArr[17] = 1138994312;
        iArr[18] = 1957205913;
        iArr[19] = 1718517398;
        iArr[20] = 440328635;
        iArr[21] = 150472884;
        iArr[22] = 1068708773;
        iArr[23] = 762698410;
        iArr[24] = 332709586;
        iArr[25] = 17979357;
        iArr[26] = 911830220;
        iArr[27] = 614434243;
        iArr[28] = 1489967854;
        iArr[29] = 1242166241;
        iArr[30] = 2101528816;
        iArr[31] = 1870930431;
        iArr[32] = 1988900899;
        iArr[33] = 1682624812;
        iArr[34] = 1392634429;
        iArr[35] = 1103561522;
        iArr[36] = 1033346079;
        iArr[37] = 793867536;
        iArr[38] = 404377089;
        iArr[39] = 182232846;
        iArr[40] = 880657270;
        iArr[41] = 649800313;
        iArr[42] = 300945768;
        iArr[43] = 53934183;
        iArr[44] = 2137417546;
        iArr[45] = 1839238725;
        iArr[46] = 1525396820;
        iArr[47] = 1210932315;
        iArr[48] = 665419172;
        iArr[49] = 896505003;
        iArr[50] = 35958714;
        iArr[51] = 283264693;
        iArr[52] = 1823660440;
        iArr[53] = 2121543831;
        iArr[54] = 1228868486;
        iArr[55] = 1543103113;
        iArr[56] = 1700300529;
        iArr[57] = 2006872062;
        iArr[58] = 1087722735;
        iArr[59] = 1377025504;
        iArr[60] = 776151757;
        iArr[61] = 1015401410;
        iArr[62] = 198111443;
        iArr[63] = 419961308;
        iArr[64] = 970900331;
        iArr[65] = 723004004;
        iArr[66] = 475206005;
        iArr[67] = 244709498;
        iArr[68] = 1925539671;
        iArr[69] = 1610845784;
        iArr[70] = 1464382793;
        iArr[71] = 1166957638;
        iArr[72] = 2066692158;
        iArr[73] = 1776931121;
        iArr[74] = 1587735072;
        iArr[75] = 1281622831;
        iArr[76] = 808754178;
        iArr[77] = 586315021;
        iArr[78] = 364465692;
        iArr[79] = 125806355;
        iArr[80] = 1761314540;
        iArr[81] = 2050846691;
        iArr[82] = 1299600626;
        iArr[83] = 1605418493;
        iArr[84] = 601891536;
        iArr[85] = 824626143;
        iArr[86] = 107868366;
        iArr[87] = 346757569;
        iArr[88] = 705330617;
        iArr[89] = 952931510;
        iArr[90] = 260550567;
        iArr[91] = 490817192;
        iArr[92] = 1628559749;
        iArr[93] = 1943482506;
        iArr[94] = 1151077275;
        iArr[95] = 1448796820;
        iArr[96] = 1330838344;
        iArr[97] = 1569985095;
        iArr[98] = 1793010006;
        iArr[99] = 2014953561;
        iArr[100] = 71917428;
        iArr[101] = 378517115;
        iArr[102] = 566529386;
        iArr[103] = 855794789;
        iArr[104] = 228786205;
        iArr[105] = 526772498;
        iArr[106] = 674157059;
        iArr[107] = 988297996;
        iArr[108] = 1186505761;
        iArr[109] = 1417563438;
        iArr[110] = 1664448063;
        iArr[111] = 1911791408;
        iArr[112] = 511164111;
        iArr[ProxyTextView.INPUTTYPE_textPostalAddress] = 212948928;
        iArr[114] = 1006267601;
        iArr[115] = 691832286;
        iArr[116] = 1433148147;
        iArr[117] = 1202385916;
        iArr[118] = 1893845229;
        iArr[119] = 1646731746;
        iArr[120] = 1552303514;
        iArr[121] = 1312861333;
        iArr[122] = 2030802820;
        iArr[123] = 1808629387;
        iArr[124] = 396222886;
        iArr[125] = 89852073;
        iArr[126] = 839922616;
        iArr[127] = 550951607;
        iArr[128] = 1941800662;
        iArr[ProxyTextView.INPUTTYPE_textPassword] = 1635479513;
        iArr[130] = 1446008008;
        iArr[131] = 1157021127;
        iArr[132] = 950412010;
        iArr[133] = 710986725;
        iArr[134] = 489418996;
        iArr[135] = 267196923;
        iArr[136] = 827096451;
        iArr[137] = 596284556;
        iArr[138] = 348237725;
        iArr[139] = 101140114;
        iArr[140] = 2052577727;
        iArr[141] = 1754345648;
        iArr[142] = 1608125345;
        iArr[143] = 1293738670;
        iArr[144] = 580436817;
        iArr[ProxyTextView.INPUTTYPE_textVisiblePassword] = 811477598;
        iArr[146] = 118821199;
        iArr[147] = 366213184;
        iArr[148] = 1770219373;
        iArr[149] = 2068156002;
        iArr[150] = 1276032371;
        iArr[151] = 1590189180;
        iArr[152] = 1617508356;
        iArr[153] = 1924124939;
        iArr[154] = 1172630042;
        iArr[155] = 1461846805;
        iArr[156] = 728931384;
        iArr[157] = 968127799;
        iArr[158] = 251612710;
        iArr[159] = 473540393;
        iArr[160] = 87146229;
        iArr[ProxyTextView.INPUTTYPE_textWebEditText] = 402085882;
        iArr[162] = 549219563;
        iArr[163] = 846890468;
        iArr[164] = 1311382217;
        iArr[165] = 1559032774;
        iArr[166] = 1806158039;
        iArr[167] = 2036408792;
        iArr[168] = 1203783072;
        iArr[169] = 1426500783;
        iArr[170] = 1649252286;
        iArr[171] = 1888190129;
        iArr[172] = 215736732;
        iArr[173] = 505219219;
        iArr[174] = 693515138;
        iArr[175] = 999348877;
        iArr[176] = 1410661234;
        iArr[ProxyTextView.INPUTTYPE_textFilter] = 1188172413;
        iArr[178] = 1905863020;
        iArr[179] = 1667219555;
        iArr[180] = 521101134;
        iArr[181] = 231323201;
        iArr[182] = 981634384;
        iArr[183] = 675570783;
        iArr[184] = 384106535;
        iArr[185] = 69462312;
        iArr[186] = 862507577;
        iArr[187] = 565066550;
        iArr[188] = 1576969243;
        iArr[189] = 1329089812;
        iArr[190] = 2020832773;
        iArr[191] = 1790287626;
        iArr[192] = 1248019901;
        iArr[ProxyTextView.INPUTTYPE_textPhonetic] = 1487252658;
        iArr[194] = 1877907363;
        iArr[195] = 2099805868;
        iArr[196] = 24699265;
        iArr[197] = 331221134;
        iArr[198] = 620049311;
        iArr[199] = 909367952;
        iArr[200] = 143834856;
        iArr[201] = 441735143;
        iArr[202] = 757034230;
        iArr[203] = 1071220217;
        iArr[204] = 1133058772;
        iArr[205] = 1364194267;
        iArr[206] = 1711589578;
        iArr[207] = 1958879685;
        iArr[208] = 457572410;
        iArr[ProxyTextView.INPUTTYPE_textWebEmailAddress] = 159443253;
        iArr[210] = 1053544996;
        iArr[211] = 739064619;
        iArr[212] = 1348314118;
        iArr[213] = 1117474057;
        iArr[214] = 1976595992;
        iArr[215] = 1729535767;
        iArr[216] = 1505229679;
        iArr[217] = 1265701472;
        iArr[218] = 2084186481;
        iArr[219] = 1862058110;
        iArr[220] = 313286483;
        iArr[221] = 6993500;
        iArr[222] = 924945741;
        iArr[223] = 635921474;
        iArr[224] = 1022328222;
        iArr[ProxyTextView.INPUTTYPE_textWebPassword] = 774476945;
        iArr[226] = 425897856;
        iArr[227] = 195315343;
        iArr[228] = 2012535202;
        iArr[229] = 1697788077;
        iArr[230] = 1383664572;
        iArr[231] = 1086317235;
        iArr[232] = 2115929803;
        iArr[233] = 1826123716;
        iArr[234] = 1536382165;
        iArr[235] = 1230355930;
        iArr[236] = 889529079;
        iArr[237] = 667143160;
        iArr[238] = 277410025;
        iArr[239] = 38672870;
        iArr[240] = 1841969177;
        iArr[241] = 2131546390;
        iArr[242] = 1212672519;
        iArr[243] = 1518404360;
        iArr[244] = 651271205;
        iArr[245] = 873952554;
        iArr[246] = 56380987;
        iArr[247] = 295348020;
        iArr[248] = 792445772;
        iArr[249] = 1040001603;
        iArr[250] = 179704146;
        iArr[251] = 410056797;
        iArr[252] = 1679845232;
        iArr[253] = 1994821247;
        iArr[254] = 1101903214;
        iArr[255] = 1399544929;
        Zo = iArr;
    }
}
