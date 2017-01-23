public abstract class aax extends aay {
    private final long j6;

    aax(long j) {
        this.j6 = j;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.j6 == ((aax) obj).j6;
    }

    public final int hashCode() {
        return ((int) this.j6) ^ ((int) (this.j6 >> 32));
    }

    protected int DW(aah aah) {
        long j = ((aax) aah).j6;
        if (this.j6 < j) {
            return -1;
        }
        if (this.j6 > j) {
            return 1;
        }
        return 0;
    }

    public final boolean VH() {
        return true;
    }

    public final boolean u7() {
        return ((long) ((int) this.j6)) == this.j6;
    }

    public final int tp() {
        return (int) this.j6;
    }

    public final long EQ() {
        return this.j6;
    }
}
