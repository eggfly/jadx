public class bfs implements bel {
    private byte[] j6;

    public bfs(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public bfs(byte[] bArr, int i, int i2) {
        this.j6 = new byte[i2];
        System.arraycopy(bArr, i, this.j6, 0, i2);
    }

    public byte[] j6() {
        return this.j6;
    }
}
