package com.aide.common;

import java.io.OutputStream;

public class n extends OutputStream {
    private byte[] DW;
    private int FH;
    private String j6;

    public n(String str) {
        this.DW = new byte[1000];
        this.j6 = str;
    }

    public void write(int i) {
        if (this.FH >= this.DW.length) {
            j6(this.FH + 1);
        }
        byte[] bArr = this.DW;
        int i2 = this.FH;
        this.FH = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.FH + i2 >= this.DW.length) {
            j6(this.FH + i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.DW[this.FH + i3] = bArr[i + i3];
        }
        this.FH += i2;
    }

    private void j6(int i) {
        Object obj = new byte[Math.max(this.DW.length * 2, i)];
        System.arraycopy(this.DW, 0, obj, 0, this.DW.length);
        this.DW = obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
        r6 = this;
        r1 = 0;
        r0 = new java.io.File;
        r2 = r6.j6;
        r0.<init>(r2);
        r0 = r0.getParentFile();
        r0.mkdirs();
        r0 = new java.io.File;
        r2 = r6.j6;
        r0.<init>(r2);
        r0 = r0.exists();
        if (r0 == 0) goto L_0x004c;
    L_0x001c:
        r0 = new java.io.File;
        r2 = r6.j6;
        r0.<init>(r2);
        r2 = r0.length();
        r0 = r6.FH;
        r4 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x002e:
        r3 = new java.io.FileInputStream;
        r0 = r6.j6;
        r3.<init>(r0);
        r0 = r1;
    L_0x0036:
        r4 = r3.read();
        r2 = -1;
        if (r4 == r2) goto L_0x0060;
    L_0x003d:
        r5 = r6.DW;
        r2 = r0 + 1;
        r0 = r5[r0];
        if (r4 == r0) goto L_0x005e;
    L_0x0045:
        r0 = 1;
    L_0x0046:
        r3.close();
        if (r0 != 0) goto L_0x004c;
    L_0x004b:
        return;
    L_0x004c:
        r0 = new java.io.FileOutputStream;
        r2 = r6.j6;
        r0.<init>(r2);
        r2 = r6.DW;
        r3 = r6.FH;
        r0.write(r2, r1, r3);
        r0.close();
        goto L_0x004b;
    L_0x005e:
        r0 = r2;
        goto L_0x0036;
    L_0x0060:
        r0 = r1;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aide.common.n.close():void");
    }
}
