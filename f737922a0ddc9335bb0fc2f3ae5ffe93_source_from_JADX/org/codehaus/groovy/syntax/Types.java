package org.codehaus.groovy.syntax;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Types {
    private static final Map<String, Integer> DW;
    private static final Set<String> FH;
    private static final Map<Integer, String> Hw;
    private static final Map<Integer, String> j6;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j6(int r5, int r6) {
        /*
        r2 = 70;
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r3 = 451; // 0x1c3 float:6.32E-43 double:2.23E-321;
        r1 = 0;
        r0 = 1;
        if (r6 != r5) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        switch(r6) {
            case 1000: goto L_0x000a;
            case 1001: goto L_0x0010;
            case 1002: goto L_0x0018;
            case 1003: goto L_0x001c;
            case 1100: goto L_0x0020;
            case 1101: goto L_0x0047;
            case 1102: goto L_0x0051;
            case 1103: goto L_0x006b;
            case 1104: goto L_0x0083;
            case 1105: goto L_0x008f;
            case 1106: goto L_0x009b;
            case 1107: goto L_0x0075;
            case 1200: goto L_0x00a5;
            case 1210: goto L_0x00ad;
            case 1220: goto L_0x00b2;
            case 1230: goto L_0x00ec;
            case 1235: goto L_0x00a8;
            case 1300: goto L_0x00f1;
            case 1301: goto L_0x00fc;
            case 1310: goto L_0x0106;
            case 1320: goto L_0x010d;
            case 1325: goto L_0x0117;
            case 1330: goto L_0x011c;
            case 1331: goto L_0x0127;
            case 1340: goto L_0x0137;
            case 1341: goto L_0x0146;
            case 1350: goto L_0x0151;
            case 1360: goto L_0x0156;
            case 1361: goto L_0x0161;
            case 1370: goto L_0x0166;
            case 1400: goto L_0x0171;
            case 1410: goto L_0x017c;
            case 1420: goto L_0x0133;
            case 1430: goto L_0x0142;
            case 1500: goto L_0x0187;
            case 1501: goto L_0x018c;
            case 1502: goto L_0x0191;
            case 1900: goto L_0x0219;
            case 1901: goto L_0x01f8;
            case 1902: goto L_0x0201;
            case 1903: goto L_0x0206;
            case 1904: goto L_0x020b;
            case 1905: goto L_0x0212;
            case 1910: goto L_0x022b;
            case 1911: goto L_0x0228;
            case 2000: goto L_0x0196;
            case 2001: goto L_0x01a2;
            case 2002: goto L_0x01ae;
            case 2003: goto L_0x01b3;
            case 2004: goto L_0x01b8;
            case 2005: goto L_0x01bc;
            case 2006: goto L_0x01c8;
            case 2007: goto L_0x01d1;
            case 2008: goto L_0x01e7;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = r1;
        goto L_0x000a;
    L_0x0010:
        if (r5 < 0) goto L_0x0016;
    L_0x0012:
        r2 = 830; // 0x33e float:1.163E-42 double:4.1E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0016:
        r0 = r1;
        goto L_0x000a;
    L_0x0018:
        switch(r5) {
            case -1: goto L_0x000a;
            case 5: goto L_0x000a;
            case 320: goto L_0x000a;
            default: goto L_0x001b;
        };
    L_0x001b:
        goto L_0x000e;
    L_0x001c:
        switch(r5) {
            case -1: goto L_0x000a;
            case 5: goto L_0x000a;
            case 20: goto L_0x000a;
            case 320: goto L_0x000a;
            default: goto L_0x001f;
        };
    L_0x001f:
        goto L_0x000e;
    L_0x0020:
        r2 = 100;
        if (r5 == r2) goto L_0x0044;
    L_0x0024:
        r2 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        if (r5 < r2) goto L_0x002c;
    L_0x0028:
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r5 <= r2) goto L_0x0044;
    L_0x002c:
        r2 = 166; // 0xa6 float:2.33E-43 double:8.2E-322;
        if (r5 < r2) goto L_0x0034;
    L_0x0030:
        r2 = 168; // 0xa8 float:2.35E-43 double:8.3E-322;
        if (r5 <= r2) goto L_0x0044;
    L_0x0034:
        r2 = 285; // 0x11d float:4.0E-43 double:1.41E-321;
        if (r5 < r2) goto L_0x003c;
    L_0x0038:
        r2 = 287; // 0x11f float:4.02E-43 double:1.42E-321;
        if (r5 <= r2) goto L_0x0044;
    L_0x003c:
        r2 = 350; // 0x15e float:4.9E-43 double:1.73E-321;
        if (r5 < r2) goto L_0x0045;
    L_0x0040:
        r2 = 352; // 0x160 float:4.93E-43 double:1.74E-321;
        if (r5 > r2) goto L_0x0045;
    L_0x0044:
        r1 = r0;
    L_0x0045:
        r0 = r1;
        goto L_0x000a;
    L_0x0047:
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r5 < r2) goto L_0x004f;
    L_0x004b:
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r5 <= r2) goto L_0x000a;
    L_0x004f:
        r0 = r1;
        goto L_0x000a;
    L_0x0051:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 < r2) goto L_0x0059;
    L_0x0055:
        r2 = 282; // 0x11a float:3.95E-43 double:1.393E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0059:
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        if (r5 < r2) goto L_0x0061;
    L_0x005d:
        r2 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        if (r5 <= r2) goto L_0x000a;
    L_0x0061:
        r2 = 340; // 0x154 float:4.76E-43 double:1.68E-321;
        if (r5 < r2) goto L_0x0069;
    L_0x0065:
        r2 = 342; // 0x156 float:4.79E-43 double:1.69E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0069:
        r0 = r1;
        goto L_0x000a;
    L_0x006b:
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        if (r5 < r2) goto L_0x0073;
    L_0x006f:
        r2 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        if (r5 <= r2) goto L_0x000a;
    L_0x0073:
        r0 = r1;
        goto L_0x000a;
    L_0x0075:
        r2 = 340; // 0x154 float:4.76E-43 double:1.68E-321;
        if (r5 < r2) goto L_0x007d;
    L_0x0079:
        r2 = 342; // 0x156 float:4.79E-43 double:1.69E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x007d:
        r2 = 97;
        if (r5 == r2) goto L_0x000a;
    L_0x0081:
        r0 = r1;
        goto L_0x000a;
    L_0x0083:
        r2 = 75;
        if (r5 == r2) goto L_0x008b;
    L_0x0087:
        r2 = 77;
        if (r5 != r2) goto L_0x008c;
    L_0x008b:
        r1 = r0;
    L_0x008c:
        r0 = r1;
        goto L_0x000a;
    L_0x008f:
        r2 = 90;
        if (r5 == r2) goto L_0x0097;
    L_0x0093:
        r2 = 94;
        if (r5 != r2) goto L_0x0098;
    L_0x0097:
        r1 = r0;
    L_0x0098:
        r0 = r1;
        goto L_0x000a;
    L_0x009b:
        if (r5 == r2) goto L_0x00a1;
    L_0x009d:
        r2 = 80;
        if (r5 != r2) goto L_0x00a2;
    L_0x00a1:
        r1 = r0;
    L_0x00a2:
        r0 = r1;
        goto L_0x000a;
    L_0x00a5:
        switch(r5) {
            case 201: goto L_0x000a;
            case 250: goto L_0x000a;
            case 260: goto L_0x000a;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        switch(r5) {
            case 97: goto L_0x000a;
            case 160: goto L_0x000a;
            case 251: goto L_0x000a;
            case 253: goto L_0x000a;
            case 261: goto L_0x000a;
            case 263: goto L_0x000a;
            case 815: goto L_0x000a;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        goto L_0x000e;
    L_0x00ad:
        switch(r5) {
            case 250: goto L_0x000a;
            case 252: goto L_0x000a;
            case 260: goto L_0x000a;
            case 262: goto L_0x000a;
            default: goto L_0x00b0;
        };
    L_0x00b0:
        goto L_0x000e;
    L_0x00b2:
        switch(r5) {
            case 70: goto L_0x000a;
            case 75: goto L_0x000a;
            case 77: goto L_0x000a;
            case 80: goto L_0x000a;
            case 90: goto L_0x000a;
            case 94: goto L_0x000a;
            case 162: goto L_0x000a;
            case 164: goto L_0x000a;
            case 280: goto L_0x000a;
            case 281: goto L_0x000a;
            case 282: goto L_0x000a;
            case 340: goto L_0x000a;
            case 341: goto L_0x000a;
            case 342: goto L_0x000a;
            case 544: goto L_0x000a;
            default: goto L_0x00b5;
        };
    L_0x00b5:
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r5 < r2) goto L_0x00bd;
    L_0x00b9:
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r5 <= r2) goto L_0x000a;
    L_0x00bd:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 < r2) goto L_0x00c5;
    L_0x00c1:
        r2 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x00c5:
        r2 = 100;
        if (r5 == r2) goto L_0x000a;
    L_0x00c9:
        r2 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        if (r5 < r2) goto L_0x00d1;
    L_0x00cd:
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x00d1:
        r2 = 166; // 0xa6 float:2.33E-43 double:8.2E-322;
        if (r5 < r2) goto L_0x00d9;
    L_0x00d5:
        r2 = 168; // 0xa8 float:2.35E-43 double:8.3E-322;
        if (r5 <= r2) goto L_0x000a;
    L_0x00d9:
        r2 = 285; // 0x11d float:4.0E-43 double:1.41E-321;
        if (r5 < r2) goto L_0x00e1;
    L_0x00dd:
        r2 = 287; // 0x11f float:4.02E-43 double:1.42E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x00e1:
        r2 = 350; // 0x15e float:4.9E-43 double:1.73E-321;
        if (r5 < r2) goto L_0x00e9;
    L_0x00e5:
        r2 = 352; // 0x160 float:4.93E-43 double:1.74E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x00e9:
        r0 = r1;
        goto L_0x000a;
    L_0x00ec:
        switch(r5) {
            case 200: goto L_0x000a;
            case 201: goto L_0x000a;
            case 206: goto L_0x000a;
            case 253: goto L_0x000a;
            case 263: goto L_0x000a;
            default: goto L_0x00ef;
        };
    L_0x00ef:
        goto L_0x000e;
    L_0x00f1:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r2) goto L_0x00f9;
    L_0x00f5:
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x00f9:
        r0 = r1;
        goto L_0x000a;
    L_0x00fc:
        r2 = 5;
        if (r5 < r2) goto L_0x0103;
    L_0x00ff:
        r2 = 340; // 0x154 float:4.76E-43 double:1.68E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0103:
        r0 = r1;
        goto L_0x000a;
    L_0x0106:
        if (r5 < r4) goto L_0x010a;
    L_0x0108:
        if (r5 <= r3) goto L_0x000a;
    L_0x010a:
        r0 = r1;
        goto L_0x000a;
    L_0x010d:
        r2 = 450; // 0x1c2 float:6.3E-43 double:2.223E-321;
        if (r5 == r2) goto L_0x0113;
    L_0x0111:
        if (r5 != r3) goto L_0x0114;
    L_0x0113:
        r1 = r0;
    L_0x0114:
        r0 = r1;
        goto L_0x000a;
    L_0x0117:
        switch(r5) {
            case 200: goto L_0x000a;
            case 201: goto L_0x000a;
            default: goto L_0x011a;
        };
    L_0x011a:
        goto L_0x000e;
    L_0x011c:
        r2 = 610; // 0x262 float:8.55E-43 double:3.014E-321;
        if (r5 < r2) goto L_0x0124;
    L_0x0120:
        r2 = 612; // 0x264 float:8.58E-43 double:3.024E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0124:
        r0 = r1;
        goto L_0x000a;
    L_0x0127:
        r2 = 610; // 0x262 float:8.55E-43 double:3.014E-321;
        if (r5 == r2) goto L_0x012f;
    L_0x012b:
        r2 = 611; // 0x263 float:8.56E-43 double:3.02E-321;
        if (r5 != r2) goto L_0x0130;
    L_0x012f:
        r1 = r0;
    L_0x0130:
        r0 = r1;
        goto L_0x000a;
    L_0x0133:
        r2 = 440; // 0x1b8 float:6.17E-43 double:2.174E-321;
        if (r5 == r2) goto L_0x000a;
    L_0x0137:
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r5 < r2) goto L_0x013f;
    L_0x013b:
        r2 = 608; // 0x260 float:8.52E-43 double:3.004E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x013f:
        r0 = r1;
        goto L_0x000a;
    L_0x0142:
        r2 = 440; // 0x1b8 float:6.17E-43 double:2.174E-321;
        if (r5 == r2) goto L_0x000a;
    L_0x0146:
        r2 = 601; // 0x259 float:8.42E-43 double:2.97E-321;
        if (r5 < r2) goto L_0x014e;
    L_0x014a:
        r2 = 608; // 0x260 float:8.52E-43 double:3.004E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x014e:
        r0 = r1;
        goto L_0x000a;
    L_0x0151:
        switch(r5) {
            case 570: goto L_0x000a;
            case 571: goto L_0x000a;
            case 572: goto L_0x000a;
            default: goto L_0x0154;
        };
    L_0x0154:
        goto L_0x000e;
    L_0x0156:
        r2 = 700; // 0x2bc float:9.81E-43 double:3.46E-321;
        if (r5 < r2) goto L_0x015e;
    L_0x015a:
        r2 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x015e:
        r0 = r1;
        goto L_0x000a;
    L_0x0161:
        switch(r5) {
            case 530: goto L_0x000a;
            case 531: goto L_0x000a;
            case 532: goto L_0x000a;
            case 533: goto L_0x000a;
            case 539: goto L_0x000a;
            case 545: goto L_0x000a;
            case 573: goto L_0x000a;
            default: goto L_0x0164;
        };
    L_0x0164:
        goto L_0x000e;
    L_0x0166:
        r2 = 800; // 0x320 float:1.121E-42 double:3.953E-321;
        if (r5 < r2) goto L_0x016e;
    L_0x016a:
        r2 = 830; // 0x33e float:1.163E-42 double:4.1E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x016e:
        r0 = r1;
        goto L_0x000a;
    L_0x0171:
        r2 = 531; // 0x213 float:7.44E-43 double:2.623E-321;
        if (r5 < r2) goto L_0x0179;
    L_0x0175:
        r2 = 533; // 0x215 float:7.47E-43 double:2.633E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0179:
        r0 = r1;
        goto L_0x000a;
    L_0x017c:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r2) goto L_0x0184;
    L_0x0180:
        r2 = 521; // 0x209 float:7.3E-43 double:2.574E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x0184:
        r0 = r1;
        goto L_0x000a;
    L_0x0187:
        switch(r5) {
            case 10: goto L_0x000a;
            case 20: goto L_0x000a;
            case 30: goto L_0x000a;
            case 40: goto L_0x000a;
            case 50: goto L_0x000a;
            case 60: goto L_0x000a;
            default: goto L_0x018a;
        };
    L_0x018a:
        goto L_0x000e;
    L_0x018c:
        switch(r5) {
            case 10: goto L_0x000a;
            case 30: goto L_0x000a;
            case 50: goto L_0x000a;
            default: goto L_0x018f;
        };
    L_0x018f:
        goto L_0x000e;
    L_0x0191:
        switch(r5) {
            case 20: goto L_0x000a;
            case 40: goto L_0x000a;
            case 60: goto L_0x000a;
            default: goto L_0x0194;
        };
    L_0x0194:
        goto L_0x000e;
    L_0x0196:
        r2 = 60;
        if (r5 == r2) goto L_0x019e;
    L_0x019a:
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r5 != r2) goto L_0x019f;
    L_0x019e:
        r1 = r0;
    L_0x019f:
        r0 = r1;
        goto L_0x000a;
    L_0x01a2:
        r2 = 40;
        if (r5 == r2) goto L_0x01aa;
    L_0x01a6:
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r5 != r2) goto L_0x01ab;
    L_0x01aa:
        r1 = r0;
    L_0x01ab:
        r0 = r1;
        goto L_0x000a;
    L_0x01ae:
        switch(r5) {
            case 10: goto L_0x000a;
            case 300: goto L_0x000a;
            case 540: goto L_0x000a;
            case 584: goto L_0x000a;
            default: goto L_0x01b1;
        };
    L_0x01b1:
        goto L_0x000e;
    L_0x01b3:
        switch(r5) {
            case 30: goto L_0x000a;
            case 70: goto L_0x000a;
            case 440: goto L_0x000a;
            default: goto L_0x01b6;
        };
    L_0x01b6:
        goto L_0x000e;
    L_0x01b8:
        r2 = 20;
        if (r5 == r2) goto L_0x000a;
    L_0x01bc:
        r2 = 577; // 0x241 float:8.09E-43 double:2.85E-321;
        if (r5 == r2) goto L_0x01c4;
    L_0x01c0:
        r2 = 578; // 0x242 float:8.1E-43 double:2.856E-321;
        if (r5 != r2) goto L_0x01c5;
    L_0x01c4:
        r1 = r0;
    L_0x01c5:
        r0 = r1;
        goto L_0x000a;
    L_0x01c8:
        if (r5 < r4) goto L_0x01cc;
    L_0x01ca:
        if (r5 <= r3) goto L_0x000a;
    L_0x01cc:
        switch(r5) {
            case 50: goto L_0x000a;
            case 546: goto L_0x000a;
            case 812: goto L_0x000a;
            case 901: goto L_0x000a;
            default: goto L_0x01cf;
        };
    L_0x01cf:
        goto L_0x000e;
    L_0x01d1:
        r2 = 1301; // 0x515 float:1.823E-42 double:6.43E-321;
        r2 = j6(r5, r2);
        if (r2 == 0) goto L_0x01df;
    L_0x01d9:
        switch(r5) {
            case 10: goto L_0x000a;
            case 30: goto L_0x000a;
            case 50: goto L_0x000a;
            case 97: goto L_0x000a;
            case 160: goto L_0x000a;
            case 200: goto L_0x000a;
            case 201: goto L_0x000a;
            case 250: goto L_0x000a;
            case 260: goto L_0x000a;
            default: goto L_0x01dc;
        };
    L_0x01dc:
        r0 = r1;
        goto L_0x000a;
    L_0x01df:
        switch(r5) {
            case 544: goto L_0x01e4;
            case 902: goto L_0x01e4;
            case 903: goto L_0x01e4;
            case 904: goto L_0x01e4;
            default: goto L_0x01e2;
        };
    L_0x01e2:
        goto L_0x000a;
    L_0x01e4:
        r0 = r1;
        goto L_0x000a;
    L_0x01e7:
        switch(r5) {
            case 50: goto L_0x01f5;
            case 200: goto L_0x01f5;
            case 201: goto L_0x01f5;
            case 251: goto L_0x01f5;
            case 253: goto L_0x01f5;
            case 261: goto L_0x01f5;
            case 263: goto L_0x01f5;
            default: goto L_0x01ea;
        };
    L_0x01ea:
        r2 = 1911; // 0x777 float:2.678E-42 double:9.44E-321;
        r2 = j6(r5, r2);
        if (r2 == 0) goto L_0x000a;
    L_0x01f2:
        r0 = r1;
        goto L_0x000a;
    L_0x01f5:
        r0 = r1;
        goto L_0x000a;
    L_0x01f8:
        if (r5 < r2) goto L_0x01fe;
    L_0x01fa:
        r2 = 282; // 0x11a float:3.95E-43 double:1.393E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x01fe:
        r0 = r1;
        goto L_0x000a;
    L_0x0201:
        switch(r5) {
            case 815: goto L_0x000a;
            case 816: goto L_0x0204;
            case 817: goto L_0x000a;
            case 818: goto L_0x0204;
            case 819: goto L_0x000a;
            default: goto L_0x0204;
        };
    L_0x0204:
        goto L_0x000e;
    L_0x0206:
        switch(r5) {
            case 542: goto L_0x000a;
            case 543: goto L_0x000a;
            case 544: goto L_0x000a;
            case 546: goto L_0x000a;
            case 610: goto L_0x000a;
            case 611: goto L_0x000a;
            case 612: goto L_0x000a;
            default: goto L_0x0209;
        };
    L_0x0209:
        goto L_0x000e;
    L_0x020b:
        if (r5 < r4) goto L_0x020f;
    L_0x020d:
        if (r5 <= r3) goto L_0x000a;
    L_0x020f:
        r0 = r1;
        goto L_0x000a;
    L_0x0212:
        r2 = 30;
        if (r5 == r2) goto L_0x000a;
    L_0x0216:
        r0 = r1;
        goto L_0x000a;
    L_0x0219:
        if (r5 < r2) goto L_0x021f;
    L_0x021b:
        r2 = 282; // 0x11a float:3.95E-43 double:1.393E-321;
        if (r5 <= r2) goto L_0x000a;
    L_0x021f:
        if (r5 < r4) goto L_0x0223;
    L_0x0221:
        if (r5 <= r3) goto L_0x000a;
    L_0x0223:
        switch(r5) {
            case 30: goto L_0x000a;
            case 542: goto L_0x000a;
            case 543: goto L_0x000a;
            case 544: goto L_0x000a;
            case 546: goto L_0x000a;
            case 610: goto L_0x000a;
            case 611: goto L_0x000a;
            case 612: goto L_0x000a;
            case 812: goto L_0x000a;
            case 815: goto L_0x000a;
            case 817: goto L_0x000a;
            case 819: goto L_0x000a;
            default: goto L_0x0226;
        };
    L_0x0226:
        goto L_0x000e;
    L_0x0228:
        switch(r5) {
            case 546: goto L_0x000a;
            case 810: goto L_0x000a;
            case 811: goto L_0x000a;
            case 812: goto L_0x000a;
            case 814: goto L_0x000a;
            case 817: goto L_0x000a;
            case 819: goto L_0x000a;
            case 830: goto L_0x000a;
            default: goto L_0x022b;
        };
    L_0x022b:
        if (r5 < r4) goto L_0x022f;
    L_0x022d:
        if (r5 <= r3) goto L_0x000a;
    L_0x022f:
        switch(r5) {
            case 542: goto L_0x000a;
            case 543: goto L_0x000a;
            case 610: goto L_0x000a;
            case 611: goto L_0x000a;
            case 612: goto L_0x000a;
            default: goto L_0x0232;
        };
    L_0x0232:
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.syntax.Types.j6(int, int):boolean");
    }

    static {
        j6 = new HashMap();
        DW = new HashMap();
        FH = new HashSet();
        DW("\n", 5);
        DW("{", 10);
        DW("}", 20);
        DW("[", 30);
        DW("]", 40);
        DW("(", 50);
        DW(")", 60);
        DW(".", 70);
        DW("..", 75);
        DW("...", 77);
        DW("->", 80);
        DW("=~", 90);
        DW("==~", 94);
        DW("~", 97);
        DW("=", 100);
        DW("!=", 120);
        DW("===", 121);
        DW("!==", 122);
        DW("==", 123);
        DW("<", 124);
        DW("<=", 125);
        DW(">", 126);
        DW(">=", 127);
        DW("<=>", 128);
        DW("!", 160);
        DW("||", 162);
        DW("&&", 164);
        DW("||=", 166);
        DW("&&=", 168);
        DW("+", 200);
        DW("-", 201);
        DW("*", 202);
        DW("/", 203);
        DW("\\", 204);
        DW("%", 205);
        DW("**", 206);
        DW("+=", 210);
        DW("-=", 211);
        DW("*=", 212);
        DW("/=", 213);
        DW("\\=", 214);
        DW("%=", 215);
        DW("**=", 216);
        DW("++", 250);
        DW("--", 260);
        DW("<<", 280);
        DW(">>", 281);
        DW(">>>", 282);
        DW("<<=", 285);
        DW(">>=", 286);
        DW(">>>=", 287);
        DW("&", 341);
        DW("^", 342);
        DW("|=", 350);
        DW("&=", 351);
        DW("^=", 352);
        DW(",", 300);
        DW(":", 310);
        DW(";", 320);
        DW("?", 330);
        DW("|", 340);
        DW("${}", 903);
        FH("abstract", 510);
        FH("as", 552);
        FH("assert", 585);
        FH("break", 574);
        FH("case", 577);
        FH("catch", 581);
        FH("class", 531);
        FH("const", 700);
        FH("continue", 575);
        FH("def", 530);
        FH("defmacro", 530);
        FH("default", 578);
        FH("do", 570);
        FH("else", 562);
        FH("extends", 541);
        FH("final", 511);
        FH("finally", 582);
        FH("for", 572);
        FH("goto", 701);
        FH("if", 561);
        FH("in", 573);
        FH("implements", 540);
        FH("import", 551);
        FH("instanceof", 544);
        FH("interface", 532);
        FH("mixin", 533);
        FH("native", 512);
        FH("new", 546);
        FH("package", 550);
        FH("private", 500);
        FH("property", 545);
        FH("protected", 501);
        FH("public", 502);
        FH("return", 560);
        FH("static", 521);
        FH("super", 543);
        FH("switch", 576);
        FH("synchronized", 520);
        FH("this", 542);
        FH("throw", 583);
        FH("throws", 584);
        FH("transient", 513);
        FH("try", 580);
        FH("volatile", 514);
        FH("while", 571);
        FH("true", 610);
        FH("false", 611);
        FH("null", 612);
        FH("void", 600);
        FH("boolean", 601);
        FH("byte", 602);
        FH("int", 604);
        FH("short", 603);
        FH("long", 605);
        FH("float", 606);
        FH("double", 607);
        FH("char", 608);
        Hw = new HashMap();
        for (String str : DW.keySet()) {
            j6(((Integer) DW.get(str)).intValue(), str);
        }
        j6(5, "<newline>");
        j6(251, "<prefix ++>");
        j6(252, "<postfix ++>");
        j6(261, "<prefix -->");
        j6(262, "<postfix -->");
        j6(253, "<positive>");
        j6(263, "<negative>");
        j6(400, "<string literal>");
        j6(440, "<identifier>");
        j6(450, "<integer>");
        j6(451, "<decimal>");
        j6(800, "<compilation unit>");
        j6(801, "<class>");
        j6(802, "<interface>");
        j6(803, "<mixin>");
        j6(804, "<method>");
        j6(814, "<method call>");
        j6(805, "<property>");
        j6(806, "<parameter>");
        j6(810, "<list>");
        j6(811, "<map>");
        j6(820, "<tuple>");
        j6(812, "<gstring>");
        j6(815, "<cast>");
        j6(816, "<block>");
        j6(817, "<closure>");
        j6(819, "<ternary>");
        j6(818, "<label>");
        j6(830, "<variable declaration>");
        j6(901, "<start of gstring tokens>");
        j6(902, "<end of gstring tokens>");
        j6(903, "<start of gstring expression>");
        j6(904, "<end of gstring expression>");
        j6(1100, "<assignment operator>");
        j6(1101, "<comparison operator>");
        j6(1102, "<math operator>");
        j6(1103, "<logical operator>");
        j6(1107, "<bitwise operator>");
        j6(1104, "<range operator>");
        j6(1105, "<regex comparison operator>");
        j6(1106, "<dereference operator>");
        j6(1200, "<prefix operator>");
        j6(1210, "<postfix operator>");
        j6(1220, "<infix operator>");
        j6(1300, "<keyword>");
        j6(1310, "<literal>");
        j6(1320, "<number>");
        j6(1330, "<named value>");
        j6(1331, "<truth value>");
        j6(1340, "<primitive type>");
        j6(1341, "<creatable primitive type>");
        j6(1350, "<loop>");
        j6(1360, "<reserved keyword>");
        j6(1370, "<synthetic>");
        j6(1400, "<type declaration>");
        j6(1410, "<declaration modifier>");
        j6(1420, "<type name>");
        j6(1430, "<creatable type name>");
        j6(1500, "<matched container>");
        j6(1501, "<left of matched container>");
        j6(1502, "<right of matched container>");
        j6(2005, "<valid in a switch body>");
    }

    public static int j6(String str, int i) {
        if (!DW.containsKey(str)) {
            return 0;
        }
        int intValue = ((Integer) DW.get(str)).intValue();
        if (i == 0 || j6(intValue, i)) {
            return intValue;
        }
        return 0;
    }

    public static int j6(String str) {
        return j6(str, 1301);
    }

    public static String j6(int i) {
        String str = "";
        if (j6.containsKey(Integer.valueOf(i))) {
            return (String) j6.get(Integer.valueOf(i));
        }
        return str;
    }

    private static void DW(String str, int i) {
        j6.put(Integer.valueOf(i), str);
        DW.put(str, Integer.valueOf(i));
    }

    private static void FH(String str, int i) {
        FH.add(str);
        DW(str, i);
    }

    public static String DW(int i) {
        if (Hw.containsKey(Integer.valueOf(i))) {
            return (String) Hw.get(Integer.valueOf(i));
        }
        return "<>";
    }

    private static void j6(int i, String str) {
        if (str.startsWith("<") && str.endsWith(">")) {
            Hw.put(Integer.valueOf(i), str);
        } else {
            Hw.put(Integer.valueOf(i), '\"' + str + '\"');
        }
    }
}
