import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class awp$2 extends Thread {
    private final /* synthetic */ boolean DW;
    private final /* synthetic */ AtomicBoolean FH;
    private final /* synthetic */ Process j6;

    awp$2(Process process, boolean z, AtomicBoolean atomicBoolean) {
        this.j6 = process;
        this.DW = z;
        this.FH = atomicBoolean;
    }

    public void run() {
        InputStream errorStream = this.j6.getErrorStream();
        try {
            if (this.DW) {
                while (true) {
                    int read = errorStream.read();
                    if (read != -1) {
                        System.err.print((char) read);
                    }
                    try {
                        break;
                    } catch (IOException e) {
                        if (this.DW) {
                            e.printStackTrace(System.err);
                        }
                        this.FH.set(true);
                        return;
                    }
                }
                errorStream.close();
            }
            do {
            } while (errorStream.read() != -1);
            break;
            errorStream.close();
        } catch (IOException e2) {
            if (this.DW) {
                e2.printStackTrace(System.err);
            }
            this.FH.set(true);
        }
    }
}
