import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jgit.JGitText;

public abstract class axj extends OutputStream {
    private int DW;
    private OutputStream FH;
    private ArrayList<axj$a> j6;

    protected abstract OutputStream j6();

    protected axj(int i) {
        this.DW = i;
        v5();
    }

    public void write(int i) {
        if (this.FH != null) {
            this.FH.write(i);
            return;
        }
        axj$a gn = gn();
        if (gn.j6()) {
            if (u7()) {
                this.FH.write(i);
                return;
            } else {
                gn = new axj$a();
                this.j6.add(gn);
            }
        }
        byte[] bArr = gn.j6;
        int i2 = gn.DW;
        gn.DW = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.FH == null) {
            while (i2 > 0) {
                axj$a gn = gn();
                if (gn.j6()) {
                    if (u7()) {
                        break;
                    }
                    gn = new axj$a();
                    this.j6.add(gn);
                }
                int min = Math.min(gn.j6.length - gn.DW, i2);
                System.arraycopy(bArr, i, gn.j6, gn.DW, min);
                gn.DW += min;
                i2 -= min;
                i += min;
            }
        }
        if (i2 > 0) {
            this.FH.write(bArr, i, i2);
        }
    }

    public void j6(InputStream inputStream) {
        int read;
        if (this.j6 != null) {
            while (true) {
                axj$a gn = gn();
                if (gn.j6()) {
                    if (u7()) {
                        break;
                    }
                    gn = new axj$a();
                    this.j6.add(gn);
                }
                read = inputStream.read(gn.j6, gn.DW, gn.j6.length - gn.DW);
                if (read >= 1) {
                    gn.DW = read + gn.DW;
                } else {
                    return;
                }
            }
        }
        byte[] bArr = new byte[8192];
        while (true) {
            read = inputStream.read(bArr);
            if (read > 0) {
                this.FH.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public long DW() {
        return VH();
    }

    private long VH() {
        return ((long) gn().DW) + ((((long) this.j6.size()) - 1) * 8192);
    }

    public byte[] FH() {
        long DW = DW();
        if (2147483647L < DW) {
            throw new OutOfMemoryError(JGitText.j6().lengthExceedsMaximumArraySize);
        }
        Object obj = new byte[((int) DW)];
        Iterator it = this.j6.iterator();
        int i = 0;
        while (it.hasNext()) {
            axj$a axj_a = (axj$a) it.next();
            System.arraycopy(axj_a.j6, 0, obj, i, axj_a.DW);
            i = axj_a.DW + i;
        }
        return obj;
    }

    public void j6(OutputStream outputStream, aob aob) {
        if (aob == null) {
            aob = anp.j6;
        }
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            axj$a axj_a = (axj$a) it.next();
            outputStream.write(axj_a.j6, 0, axj_a.DW);
            aob.j6(axj_a.DW / 1024);
        }
    }

    public InputStream Hw() {
        return new axj$b(this);
    }

    public void v5() {
        if (this.FH != null) {
            Zo();
        }
        if (this.DW < 8192) {
            this.j6 = new ArrayList(1);
            this.j6.add(new axj$a(this.DW));
            return;
        }
        this.j6 = new ArrayList(this.DW / 8192);
        this.j6.add(new axj$a());
    }

    private axj$a gn() {
        return (axj$a) this.j6.get(this.j6.size() - 1);
    }

    private boolean u7() {
        if (VH() < ((long) this.DW)) {
            return false;
        }
        tp();
        return true;
    }

    private void tp() {
        this.FH = j6();
        axj$a axj_a = (axj$a) this.j6.remove(this.j6.size() - 1);
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            axj$a axj_a2 = (axj$a) it.next();
            this.FH.write(axj_a2.j6, 0, axj_a2.DW);
        }
        this.j6 = null;
        this.FH = new axp(this.FH, 8192);
        this.FH.write(axj_a.j6, 0, axj_a.DW);
    }

    public void close() {
        if (this.FH != null) {
            try {
                this.FH.close();
            } finally {
                this.FH = null;
            }
        }
    }

    public void Zo() {
        this.j6 = null;
        if (this.FH != null) {
            try {
                this.FH.close();
            } catch (IOException e) {
            } finally {
                this.FH = null;
            }
        }
    }
}
