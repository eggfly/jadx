public class bdl {
    private bct DW;
    private bcr j6;

    private static bcr j6(byte[] bArr) {
        try {
            return bcr.j6(ayv.j6(bArr));
        } catch (Throwable e) {
            throw new bdk("malformed data: " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new bdk("malformed data: " + e2.getMessage(), e2);
        }
    }

    public bdl(byte[] bArr) {
        this(j6(bArr));
    }

    public bdl(bcr bcr) {
        this.j6 = bcr;
        this.DW = bcr.FH().v5();
    }

    public bcr j6() {
        return this.j6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bdl)) {
            return false;
        }
        return this.j6.equals(((bdl) obj).j6);
    }

    public int hashCode() {
        return this.j6.hashCode();
    }
}
