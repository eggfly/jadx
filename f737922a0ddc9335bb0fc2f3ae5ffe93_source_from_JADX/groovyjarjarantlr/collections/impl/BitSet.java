package groovyjarjarantlr.collections.impl;

import groovyjarjarantlr.CharFormatter;

public class BitSet implements Cloneable {
    protected long[] j6;

    public BitSet() {
        this(64);
    }

    public BitSet(long[] jArr) {
        this.j6 = jArr;
    }

    public BitSet(int i) {
        this.j6 = new long[(((i - 1) >> 6) + 1)];
    }

    public void j6(int i) {
        int tp = tp(i);
        if (tp >= this.j6.length) {
            FH(i);
        }
        long[] jArr = this.j6;
        jArr[tp] = jArr[tp] | VH(i);
    }

    private static final long VH(int i) {
        return 1 << (i & 63);
    }

    public void DW(int i) {
        int tp = tp(i);
        if (tp >= this.j6.length) {
            FH(i);
        }
        long[] jArr = this.j6;
        jArr[tp] = jArr[tp] & (VH(i) ^ -1);
    }

    public Object clone() {
        try {
            BitSet bitSet = (BitSet) super.clone();
            bitSet.j6 = new long[this.j6.length];
            System.arraycopy(this.j6, 0, bitSet.j6, 0, this.j6.length);
            return bitSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public int j6() {
        int i = 0;
        for (int length = this.j6.length - 1; length >= 0; length--) {
            long j = this.j6[length];
            if (j != 0) {
                for (int i2 = 63; i2 >= 0; i2--) {
                    if (((1 << i2) & j) != 0) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BitSet)) {
            return false;
        }
        BitSet bitSet = (BitSet) obj;
        int min = Math.min(this.j6.length, bitSet.j6.length);
        int i = min;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            } else if (this.j6[i2] != bitSet.j6[i2]) {
                return false;
            } else {
                i = i2;
            }
        }
        if (this.j6.length <= min) {
            if (bitSet.j6.length > min) {
                i = bitSet.j6.length;
                while (true) {
                    i2 = i - 1;
                    if (i <= min) {
                        break;
                    } else if (bitSet.j6[i2] != 0) {
                        return false;
                    } else {
                        i = i2;
                    }
                }
            }
        } else {
            i = this.j6.length;
            while (true) {
                i2 = i - 1;
                if (i <= min) {
                    break;
                } else if (this.j6[i2] != 0) {
                    return false;
                } else {
                    i = i2;
                }
            }
        }
        return true;
    }

    public void FH(int i) {
        Object obj = new long[Math.max(this.j6.length << 1, gn(i))];
        System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
        this.j6 = obj;
    }

    public boolean Hw(int i) {
        int tp = tp(i);
        if (tp < this.j6.length && (this.j6[tp] & VH(i)) != 0) {
            return true;
        }
        return false;
    }

    public boolean DW() {
        for (int length = this.j6.length - 1; length >= 0; length--) {
            if (this.j6[length] != 0) {
                return false;
            }
        }
        return true;
    }

    public void j6(int i, int i2) {
        FH(i2);
        while (i <= i2) {
            int tp = tp(i);
            long[] jArr = this.j6;
            jArr[tp] = jArr[tp] ^ VH(i);
            i++;
        }
    }

    private final int gn(int i) {
        return (i >> 6) + 1;
    }

    public static BitSet v5(int i) {
        BitSet bitSet = new BitSet(i + 1);
        bitSet.j6(i);
        return bitSet;
    }

    public void j6(BitSet bitSet) {
        if (bitSet.j6.length > this.j6.length) {
            u7(bitSet.j6.length);
        }
        for (int min = Math.min(this.j6.length, bitSet.j6.length) - 1; min >= 0; min--) {
            long[] jArr = this.j6;
            jArr[min] = jArr[min] | bitSet.j6[min];
        }
    }

    public void Zo(int i) {
        int tp = tp(i);
        if (tp >= this.j6.length) {
            FH(i);
        }
        long[] jArr = this.j6;
        jArr[tp] = jArr[tp] & (VH(i) ^ -1);
    }

    private void u7(int i) {
        Object obj = new long[i];
        System.arraycopy(this.j6, 0, obj, 0, Math.min(i, this.j6.length));
        this.j6 = obj;
    }

    public void DW(BitSet bitSet) {
        if (bitSet != null) {
            int i = 0;
            while (i < this.j6.length && i < bitSet.j6.length) {
                long[] jArr = this.j6;
                jArr[i] = jArr[i] & (bitSet.j6[i] ^ -1);
                i++;
            }
        }
    }

    public int[] FH() {
        int i = 0;
        int[] iArr = new int[j6()];
        int i2 = 0;
        while (i < (this.j6.length << 6)) {
            if (Hw(i)) {
                int i3 = i2 + 1;
                iArr[i2] = i;
                i2 = i3;
            }
            i++;
        }
        return iArr;
    }

    public String toString() {
        return j6(",");
    }

    public String j6(String str) {
        String str2 = "";
        for (int i = 0; i < (this.j6.length << 6); i++) {
            if (Hw(i)) {
                if (str2.length() > 0) {
                    str2 = new StringBuffer().append(str2).append(str).toString();
                }
                str2 = new StringBuffer().append(str2).append(i).toString();
            }
        }
        return str2;
    }

    public String j6(String str, CharFormatter charFormatter) {
        String str2 = "";
        for (int i = 0; i < (this.j6.length << 6); i++) {
            if (Hw(i)) {
                if (str2.length() > 0) {
                    str2 = new StringBuffer().append(str2).append(str).toString();
                }
                str2 = new StringBuffer().append(str2).append(charFormatter.j6(i)).toString();
            }
        }
        return str2;
    }

    public String j6(String str, Vector vector) {
        if (vector == null) {
            return j6(str);
        }
        String str2 = "";
        for (int i = 0; i < (this.j6.length << 6); i++) {
            if (Hw(i)) {
                if (str2.length() > 0) {
                    str2 = new StringBuffer().append(str2).append(str).toString();
                }
                if (i >= vector.DW()) {
                    str2 = new StringBuffer().append(str2).append("<bad element ").append(i).append(">").toString();
                } else if (vector.j6(i) == null) {
                    str2 = new StringBuffer().append(str2).append("<").append(i).append(">").toString();
                } else {
                    str2 = new StringBuffer().append(str2).append((String) vector.j6(i)).toString();
                }
            }
        }
        return str2;
    }

    private static final int tp(int i) {
        return i >> 6;
    }
}
