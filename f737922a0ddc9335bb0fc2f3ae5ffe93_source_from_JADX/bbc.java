import java.util.Enumeration;

class bbc implements Enumeration {
    private Object DW;
    private aym j6;

    public bbc(byte[] bArr) {
        this.j6 = new aym(bArr, true);
        this.DW = j6();
    }

    public boolean hasMoreElements() {
        return this.DW != null;
    }

    public Object nextElement() {
        Object obj = this.DW;
        this.DW = j6();
        return obj;
    }

    private Object j6() {
        try {
            return this.j6.Hw();
        } catch (Throwable e) {
            throw new ayu("malformed DER construction: " + e, e);
        }
    }
}
