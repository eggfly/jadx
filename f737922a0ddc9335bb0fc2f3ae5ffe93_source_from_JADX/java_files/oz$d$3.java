import com.aide.common.m;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

class oz$d$3 implements Runnable {
    final /* synthetic */ oz$d DW;
    final /* synthetic */ ExecutionException j6;

    oz$d$3(oz$d oz_d, ExecutionException executionException) {
        this.DW = oz_d;
        this.j6 = executionException;
    }

    public void run() {
        if (this.DW.j6.Hw == this.DW) {
            this.DW.j6.u7();
            this.DW.j6.Hw = null;
            if (!(this.j6.getCause() instanceof UnknownHostException) || this.j6.getCause().getMessage().contains(" ")) {
                m.j6(this.DW.DW, "Download error", this.j6.getCause());
            } else {
                m.j6(this.DW.DW, "Download error", "Host not found: " + this.j6.getCause().getMessage());
            }
        }
    }
}
