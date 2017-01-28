import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class ang implements aob {
    private static final ScheduledThreadPoolExecutor DW;
    static final Object j6;
    private long FH;
    private TimeUnit Hw;
    private ang$a v5;

    protected abstract void DW(String str, int i);

    protected abstract void DW(String str, int i, int i2, int i3);

    protected abstract void FH(String str, int i);

    protected abstract void j6(String str, int i, int i2, int i3);

    public ang() {
        this.Hw = TimeUnit.MILLISECONDS;
    }

    static {
        DW = new ScheduledThreadPoolExecutor(1, new ang$1());
        DW.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        DW.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        DW.prestartAllCoreThreads();
        DW.setThreadFactory(Executors.defaultThreadFactory());
        j6 = new ang$2();
    }

    public void j6(long j, TimeUnit timeUnit) {
        this.FH = j;
        this.Hw = timeUnit;
    }

    public void DW(int i) {
    }

    public void j6(String str, int i) {
        DW();
        this.v5 = new ang$a(str, i);
        if (this.FH != 0) {
            this.v5.j6(this.FH, this.Hw);
        }
    }

    public void j6(int i) {
        if (this.v5 != null) {
            this.v5.j6(this, i);
        }
    }

    public void DW() {
        if (this.v5 != null) {
            this.v5.j6(this);
            this.v5 = null;
        }
    }

    public boolean j6() {
        return false;
    }
}
