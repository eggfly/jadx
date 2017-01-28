public final class ado {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j6(acx r7, char[] r8) {
        /*
        r1 = 0;
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = r1;
    L_0x0004:
        r2 = r7.Zo();
        r2 = r2 & 255;
        r3 = (char) r2;
        if (r3 != 0) goto L_0x0013;
    L_0x000d:
        r2 = new java.lang.String;
        r2.<init>(r8, r1, r0);
        return r2;
    L_0x0013:
        r8[r0] = r3;
        if (r3 >= r6) goto L_0x001a;
    L_0x0017:
        r0 = r0 + 1;
        goto L_0x0004;
    L_0x001a:
        r2 = r3 & 224;
        r4 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        if (r2 != r4) goto L_0x0041;
    L_0x0020:
        r2 = r7.Zo();
        r4 = r2 & 255;
        r2 = r4 & 192;
        if (r2 == r6) goto L_0x0033;
    L_0x002a:
        r0 = new java.io.UTFDataFormatException;
        r1 = "bad second byte";
        r0.<init>(r1);
        throw r0;
    L_0x0033:
        r2 = r0 + 1;
        r3 = r3 & 31;
        r3 = r3 << 6;
        r4 = r4 & 63;
        r3 = r3 | r4;
        r3 = (char) r3;
        r8[r0] = r3;
        r0 = r2;
        goto L_0x0004;
    L_0x0041:
        r2 = r3 & 240;
        r4 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        if (r2 != r4) goto L_0x0077;
    L_0x0047:
        r2 = r7.Zo();
        r4 = r2 & 255;
        r2 = r7.Zo();
        r5 = r2 & 255;
        r2 = r4 & 192;
        if (r2 != r6) goto L_0x005b;
    L_0x0057:
        r2 = r5 & 192;
        if (r2 == r6) goto L_0x0064;
    L_0x005b:
        r0 = new java.io.UTFDataFormatException;
        r1 = "bad second or third byte";
        r0.<init>(r1);
        throw r0;
    L_0x0064:
        r2 = r0 + 1;
        r3 = r3 & 15;
        r3 = r3 << 12;
        r4 = r4 & 63;
        r4 = r4 << 6;
        r3 = r3 | r4;
        r4 = r5 & 63;
        r3 = r3 | r4;
        r3 = (char) r3;
        r8[r0] = r3;
        r0 = r2;
        goto L_0x0004;
    L_0x0077:
        r0 = new java.io.UTFDataFormatException;
        r1 = "bad byte";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ado.j6(acx, char[]):java.lang.String");
    }
}
