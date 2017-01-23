package com.jcraft.jsch;

public class Packet {
    private static Random FH;
    byte[] DW;
    Buffer j6;

    static {
        FH = null;
    }

    static void j6(Random random) {
        FH = random;
    }

    public Packet(Buffer buffer) {
        this.DW = new byte[4];
        this.j6 = buffer;
    }

    public void j6() {
        this.j6.FH = 5;
    }

    void j6(int i) {
        int i2 = this.j6.FH;
        int i3 = (-i2) & (i - 1);
        if (i3 < i) {
            i3 += i;
        }
        i2 = (i2 + i3) - 4;
        this.DW[0] = (byte) (i2 >>> 24);
        this.DW[1] = (byte) (i2 >>> 16);
        this.DW[2] = (byte) (i2 >>> 8);
        this.DW[3] = (byte) i2;
        System.arraycopy(this.DW, 0, this.j6.DW, 0, 4);
        this.j6.DW[4] = (byte) i3;
        synchronized (FH) {
            FH.j6(this.j6.DW, this.j6.FH, i3);
        }
        this.j6.DW(i3);
    }

    int j6(int i, int i2, int i3) {
        int i4 = (i + 5) + 9;
        int i5 = (-i4) & (i2 - 1);
        if (i5 < i2) {
            i5 += i2;
        }
        i5 = ((i5 + i4) + i3) + 32;
        if (this.j6.DW.length < (((this.j6.FH + i5) - 5) - 9) - i) {
            Object obj = new byte[((((this.j6.FH + i5) - 5) - 9) - i)];
            System.arraycopy(this.j6.DW, 0, obj, 0, this.j6.DW.length);
            this.j6.DW = obj;
        }
        System.arraycopy(this.j6.DW, (i + 5) + 9, this.j6.DW, i5, ((this.j6.FH - 5) - 9) - i);
        this.j6.FH = 10;
        this.j6.j6(i);
        this.j6.FH = (i + 5) + 9;
        return i5;
    }

    void j6(byte b, int i, int i2, int i3) {
        System.arraycopy(this.j6.DW, i2, this.j6.DW, 14, i3);
        this.j6.DW[5] = b;
        this.j6.FH = 6;
        this.j6.j6(i);
        this.j6.j6(i3);
        this.j6.FH = (i3 + 5) + 9;
    }

    Buffer DW() {
        return this.j6;
    }
}
