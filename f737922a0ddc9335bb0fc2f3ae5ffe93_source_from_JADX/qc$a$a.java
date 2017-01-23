import java.io.InterruptedIOException;
import java.io.OutputStream;

class qc$a$a extends OutputStream {
    final /* synthetic */ qc$a j6;

    private qc$a$a(qc$a qc_a) {
        this.j6 = qc_a;
    }

    public void write(int i) {
        synchronized (this.j6.Zo) {
            if (this.j6.gn) {
                throw new InterruptedIOException();
            }
            this.j6.FH[this.j6.Hw] = (byte) i;
            this.j6.Hw = (this.j6.Hw + 1) % this.j6.FH.length;
            if (this.j6.Hw == this.j6.v5) {
                byte[] bArr = new byte[(this.j6.FH.length * 2)];
                System.arraycopy(this.j6.FH, this.j6.v5, bArr, this.j6.v5, this.j6.FH.length - this.j6.v5);
                System.arraycopy(this.j6.FH, 0, bArr, this.j6.FH.length, this.j6.v5);
                this.j6.Hw = this.j6.FH.length + this.j6.v5;
                this.j6.FH = bArr;
            }
            this.j6.Zo.notify();
        }
    }

    public void close() {
        synchronized (this.j6.Zo) {
            this.j6.u7 = true;
            this.j6.Zo.notify();
        }
    }

    public void j6() {
        this.j6.interrupt();
        if (this.j6.VH != null) {
            this.j6.VH.close();
        }
    }
}
