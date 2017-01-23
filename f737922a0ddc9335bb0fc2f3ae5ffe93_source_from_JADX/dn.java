public class dn {
    private int DW;
    private byte[] j6;

    public dn() {
        this.j6 = null;
        this.DW = 0;
    }

    public void j6() {
        this.DW = 0;
    }

    public void j6(byte b) {
        if (this.j6 == null) {
            this.j6 = new byte[10];
        } else if (this.DW >= this.j6.length) {
            Object obj = new byte[((this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        byte[] bArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        bArr[i] = b;
    }

    public byte j6(int i) {
        if (this.j6 != null && i < this.j6.length && i < this.DW) {
            return this.j6[i];
        }
        return (byte) -1;
    }

    public int DW() {
        return this.DW;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.DW; i++) {
            str = str + this.j6[i] + ", ";
        }
        return str + "}";
    }
}
