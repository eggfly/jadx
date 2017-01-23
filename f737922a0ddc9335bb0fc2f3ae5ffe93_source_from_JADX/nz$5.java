import java.io.IOException;
import java.nio.channels.InterruptibleChannel;

class nz$5 implements Runnable {
    final /* synthetic */ nz DW;
    final /* synthetic */ InterruptibleChannel j6;

    nz$5(nz nzVar, InterruptibleChannel interruptibleChannel) {
        this.DW = nzVar;
        this.j6 = interruptibleChannel;
    }

    public void run() {
        try {
            this.j6.close();
        } catch (IOException e) {
        }
    }
}
