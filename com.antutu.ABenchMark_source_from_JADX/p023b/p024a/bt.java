package p023b.p024a;

import java.util.BitSet;

/* renamed from: b.a.bt */
public final class bt extends bi {
    public static BitSet m3621a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] m3622b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) (bArr[length] | (1 << (i2 % 8)));
            }
        }
        return bArr;
    }

    public void m3623a(BitSet bitSet, int i) {
        for (byte a : bt.m3622b(bitSet, i)) {
            m3582a(a);
        }
    }

    public BitSet m3624b(int i) {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = m3608q();
        }
        return bt.m3621a(bArr);
    }

    public Class<? extends bu> m3625y() {
        return bx.class;
    }
}
