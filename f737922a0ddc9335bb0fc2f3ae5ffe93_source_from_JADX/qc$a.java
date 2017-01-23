import java.io.IOException;
import java.io.OutputStream;

class qc$a extends Thread {
    private qc$a$a DW;
    private byte[] FH;
    private int Hw;
    private OutputStream VH;
    private Object Zo;
    private boolean gn;
    final /* synthetic */ qc j6;
    private boolean u7;
    private int v5;

    public qc$a(qc qcVar, OutputStream outputStream) {
        this.j6 = qcVar;
        super("Process In [" + qcVar.j6[0] + "]");
        this.DW = new qc$a$a();
        this.FH = new byte[256];
        this.Zo = new Object();
        this.VH = outputStream;
    }

    public qc$a$a j6() {
        return this.DW;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                synchronized (this.Zo) {
                    Object obj;
                    int i;
                    Object obj2;
                    if (this.Hw == this.v5 && !this.u7) {
                        this.Zo.wait();
                    }
                    if (this.Hw != this.v5) {
                        byte b = this.FH[this.v5];
                        this.v5 = (this.v5 + 1) % this.FH.length;
                        if (this.Hw == this.v5) {
                            obj = 1;
                            i = b;
                            obj2 = null;
                        } else {
                            obj = null;
                            byte b2 = b;
                            obj2 = null;
                        }
                    } else if (this.u7) {
                        int i2 = 1;
                        obj = null;
                        i = 0;
                    }
                    if (this.VH == null) {
                        continue;
                    } else if (obj2 != null) {
                        this.VH.close();
                        break;
                    } else {
                        this.VH.write(i);
                        if (obj != null) {
                            this.VH.flush();
                        }
                    }
                }
            } catch (IOException e) {
            } catch (InterruptedException e2) {
            } catch (Throwable th) {
            }
        }
        synchronized (this.Zo) {
            this.gn = true;
        }
    }
}
