public final class rq extends rm {
    private final aai DW;
    private final acu j6;

    public rq(String str, acu acu, aai aai) {
        super(str);
        if (acu == null) {
            throw new NullPointerException("data == null");
        }
        this.j6 = acu;
        this.DW = aai;
    }

    public rq(String str, acu acu, int i, int i2, aai aai) {
        this(str, acu.j6(i, i + i2), aai);
    }

    public int j6() {
        return this.j6.j6() + 6;
    }
}
