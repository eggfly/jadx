package com.google.android.gms.tagmanager;

class ar extends Number implements Comparable<ar> {
    private long DW;
    private boolean FH;
    private double j6;

    private ar(long j) {
        this.DW = j;
        this.FH = true;
    }

    public static ar j6(long j) {
        return new ar(j);
    }

    public boolean DW() {
        return this.FH;
    }

    public long FH() {
        return DW() ? this.DW : (long) this.j6;
    }

    public int Hw() {
        return (int) longValue();
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ar) obj);
    }

    public double doubleValue() {
        return DW() ? (double) this.DW : this.j6;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ar) && j6((ar) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return Hw();
    }

    public int j6(ar arVar) {
        return (DW() && arVar.DW()) ? new Long(this.DW).compareTo(Long.valueOf(arVar.DW)) : Double.compare(doubleValue(), arVar.doubleValue());
    }

    public boolean j6() {
        return !DW();
    }

    public long longValue() {
        return FH();
    }

    public short shortValue() {
        return v5();
    }

    public String toString() {
        return DW() ? Long.toString(this.DW) : Double.toString(this.j6);
    }

    public short v5() {
        return (short) ((int) longValue());
    }
}
