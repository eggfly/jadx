import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class awm {
    private static final byte[] DW;
    private static final byte[] j6;

    static {
        try {
            j6 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
            DW = new byte[128];
            Arrays.fill(DW, (byte) -3);
            for (int i = 0; i < 64; i++) {
                DW[j6[i]] = (byte) i;
            }
            DW[61] = (byte) -1;
            DW[9] = (byte) -2;
            DW[10] = (byte) -2;
            DW[13] = (byte) -2;
            DW[32] = (byte) -2;
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j6(byte[] r5, int r6, int r7, byte[] r8, int r9) {
        /*
        r4 = 61;
        r0 = 0;
        switch(r7) {
            case 1: goto L_0x001c;
            case 2: goto L_0x0013;
            case 3: goto L_0x000a;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r7) {
            case 1: goto L_0x0074;
            case 2: goto L_0x004f;
            case 3: goto L_0x0024;
            default: goto L_0x0009;
        };
    L_0x0009:
        return;
    L_0x000a:
        r1 = r6 + 2;
        r1 = r5[r1];
        r1 = r1 << 24;
        r1 = r1 >>> 24;
        r0 = r0 | r1;
    L_0x0013:
        r1 = r6 + 1;
        r1 = r5[r1];
        r1 = r1 << 24;
        r1 = r1 >>> 16;
        r0 = r0 | r1;
    L_0x001c:
        r1 = r5[r6];
        r1 = r1 << 24;
        r1 = r1 >>> 8;
        r0 = r0 | r1;
        goto L_0x0006;
    L_0x0024:
        r1 = j6;
        r2 = r0 >>> 18;
        r1 = r1[r2];
        r8[r9] = r1;
        r1 = r9 + 1;
        r2 = j6;
        r3 = r0 >>> 12;
        r3 = r3 & 63;
        r2 = r2[r3];
        r8[r1] = r2;
        r1 = r9 + 2;
        r2 = j6;
        r3 = r0 >>> 6;
        r3 = r3 & 63;
        r2 = r2[r3];
        r8[r1] = r2;
        r1 = r9 + 3;
        r2 = j6;
        r0 = r0 & 63;
        r0 = r2[r0];
        r8[r1] = r0;
        goto L_0x0009;
    L_0x004f:
        r1 = j6;
        r2 = r0 >>> 18;
        r1 = r1[r2];
        r8[r9] = r1;
        r1 = r9 + 1;
        r2 = j6;
        r3 = r0 >>> 12;
        r3 = r3 & 63;
        r2 = r2[r3];
        r8[r1] = r2;
        r1 = r9 + 2;
        r2 = j6;
        r0 = r0 >>> 6;
        r0 = r0 & 63;
        r0 = r2[r0];
        r8[r1] = r0;
        r0 = r9 + 3;
        r8[r0] = r4;
        goto L_0x0009;
    L_0x0074:
        r1 = j6;
        r2 = r0 >>> 18;
        r1 = r1[r2];
        r8[r9] = r1;
        r1 = r9 + 1;
        r2 = j6;
        r0 = r0 >>> 12;
        r0 = r0 & 63;
        r0 = r2[r0];
        r8[r1] = r0;
        r0 = r9 + 2;
        r8[r0] = r4;
        r0 = r9 + 3;
        r8[r0] = r4;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: awm.j6(byte[], int, int, byte[], int):void");
    }

    public static String j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public static String j6(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[((i2 % 3 > 0 ? 4 : 0) + ((i2 * 4) / 3))];
        int i3 = i2 - 2;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            j6(bArr, i5 + i, 3, bArr2, i4);
            i5 += 3;
            i4 += 4;
        }
        if (i5 < i2) {
            j6(bArr, i5 + i, i2 - i5, bArr2, i4);
            i5 = i4 + 4;
        } else {
            i5 = i4;
        }
        try {
            return new String(bArr2, 0, i5, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr2, 0, i5);
        }
    }
}
