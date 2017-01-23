package com.igexin.download;

import java.util.Set;

/* renamed from: com.igexin.download.i */
class C3709i {
    private final String f12515a;
    private final Set f12516b;
    private int f12517c;
    private int f12518d;
    private final char[] f12519e;

    public C3709i(String str, Set set) {
        this.f12517c = 0;
        this.f12518d = 0;
        this.f12515a = str;
        this.f12516b = set;
        this.f12519e = new char[this.f12515a.length()];
        this.f12515a.getChars(0, this.f12519e.length, this.f12519e, 0);
        m15208b();
    }

    private static final boolean m15205a(char c) {
        return c == '_' || ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    private static final boolean m15206b(char c) {
        return c == '_' || ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')));
    }

    public int m15207a() {
        return this.f12518d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15208b() {
        /*
        r8 = this;
        r7 = 6;
        r6 = 4;
        r5 = 39;
        r4 = 5;
        r3 = 61;
        r0 = r8.f12519e;
    L_0x0009:
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x001d;
    L_0x000e:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 32;
        if (r1 != r2) goto L_0x001d;
    L_0x0016:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        goto L_0x0009;
    L_0x001d:
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 != r2) goto L_0x0027;
    L_0x0022:
        r0 = 9;
        r8.f12518d = r0;
    L_0x0026:
        return;
    L_0x0027:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 40;
        if (r1 != r2) goto L_0x0039;
    L_0x002f:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        r0 = 1;
        r8.f12518d = r0;
        goto L_0x0026;
    L_0x0039:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 41;
        if (r1 != r2) goto L_0x004b;
    L_0x0041:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        r0 = 2;
        r8.f12518d = r0;
        goto L_0x0026;
    L_0x004b:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 63;
        if (r1 != r2) goto L_0x005c;
    L_0x0053:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        r8.f12518d = r7;
        goto L_0x0026;
    L_0x005c:
        r1 = r8.f12517c;
        r1 = r0[r1];
        if (r1 != r3) goto L_0x007c;
    L_0x0062:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        r8.f12518d = r4;
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x0026;
    L_0x006f:
        r1 = r8.f12517c;
        r0 = r0[r1];
        if (r0 != r3) goto L_0x0026;
    L_0x0075:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        goto L_0x0026;
    L_0x007c:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 62;
        if (r1 != r2) goto L_0x009e;
    L_0x0084:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        r8.f12518d = r4;
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x0026;
    L_0x0091:
        r1 = r8.f12517c;
        r0 = r0[r1];
        if (r0 != r3) goto L_0x0026;
    L_0x0097:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        goto L_0x0026;
    L_0x009e:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 60;
        if (r1 != r2) goto L_0x00c9;
    L_0x00a6:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        r8.f12518d = r4;
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x0026;
    L_0x00b3:
        r1 = r8.f12517c;
        r1 = r0[r1];
        if (r1 == r3) goto L_0x00c1;
    L_0x00b9:
        r1 = r8.f12517c;
        r0 = r0[r1];
        r1 = 62;
        if (r0 != r1) goto L_0x0026;
    L_0x00c1:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        goto L_0x0026;
    L_0x00c9:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r2 = 33;
        if (r1 != r2) goto L_0x00f4;
    L_0x00d1:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        r8.f12518d = r4;
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x00ec;
    L_0x00de:
        r1 = r8.f12517c;
        r0 = r0[r1];
        if (r0 != r3) goto L_0x00ec;
    L_0x00e4:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        goto L_0x0026;
    L_0x00ec:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Unexpected character after !";
        r0.<init>(r1);
        throw r0;
    L_0x00f4:
        r1 = r8.f12517c;
        r1 = r0[r1];
        r1 = com.igexin.download.C3709i.m15205a(r1);
        if (r1 == 0) goto L_0x016e;
    L_0x00fe:
        r1 = r8.f12517c;
        r2 = r8.f12517c;
        r2 = r2 + 1;
        r8.f12517c = r2;
    L_0x0106:
        r2 = r8.f12517c;
        r3 = r0.length;
        if (r2 >= r3) goto L_0x011c;
    L_0x010b:
        r2 = r8.f12517c;
        r2 = r0[r2];
        r2 = com.igexin.download.C3709i.m15206b(r2);
        if (r2 == 0) goto L_0x011c;
    L_0x0115:
        r2 = r8.f12517c;
        r2 = r2 + 1;
        r8.f12517c = r2;
        goto L_0x0106;
    L_0x011c:
        r0 = r8.f12515a;
        r2 = r8.f12517c;
        r0 = r0.substring(r1, r2);
        r2 = r8.f12517c;
        r1 = r2 - r1;
        if (r1 > r6) goto L_0x015a;
    L_0x012a:
        r1 = "IS";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0137;
    L_0x0132:
        r0 = 7;
        r8.f12518d = r0;
        goto L_0x0026;
    L_0x0137:
        r1 = "OR";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x0147;
    L_0x013f:
        r1 = "AND";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x014c;
    L_0x0147:
        r0 = 3;
        r8.f12518d = r0;
        goto L_0x0026;
    L_0x014c:
        r1 = "NULL";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x015a;
    L_0x0154:
        r0 = 8;
        r8.f12518d = r0;
        goto L_0x0026;
    L_0x015a:
        r1 = r8.f12516b;
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x0166;
    L_0x0162:
        r8.f12518d = r6;
        goto L_0x0026;
    L_0x0166:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "unrecognized column or keyword";
        r0.<init>(r1);
        throw r0;
    L_0x016e:
        r1 = r8.f12517c;
        r1 = r0[r1];
        if (r1 != r5) goto L_0x01b8;
    L_0x0174:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
    L_0x017a:
        r1 = r8.f12517c;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x01a1;
    L_0x017f:
        r1 = r8.f12517c;
        r1 = r0[r1];
        if (r1 != r5) goto L_0x019a;
    L_0x0185:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r2 = r0.length;
        if (r1 >= r2) goto L_0x01a1;
    L_0x018c:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r1 = r0[r1];
        if (r1 != r5) goto L_0x01a1;
    L_0x0194:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
    L_0x019a:
        r1 = r8.f12517c;
        r1 = r1 + 1;
        r8.f12517c = r1;
        goto L_0x017a;
    L_0x01a1:
        r1 = r8.f12517c;
        r0 = r0.length;
        if (r1 != r0) goto L_0x01ae;
    L_0x01a6:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "unterminated string";
        r0.<init>(r1);
        throw r0;
    L_0x01ae:
        r0 = r8.f12517c;
        r0 = r0 + 1;
        r8.f12517c = r0;
        r8.f12518d = r7;
        goto L_0x0026;
    L_0x01b8:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "illegal character";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.download.i.b():void");
    }
}
