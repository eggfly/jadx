public class ayq extends bag {
    public ayq(String str) {
        super(str);
    }

    ayq(byte[] bArr) {
        super(bArr);
    }

    public ayq DW(String str) {
        return new ayq(FH() + "." + str);
    }
}
