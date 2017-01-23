import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ang$a implements Runnable {
    private final int DW;
    private volatile boolean FH;
    private Future<?> Hw;
    private int VH;
    private int Zo;
    private final String j6;
    private boolean v5;

    ang$a(String str, int i) {
        this.j6 = str;
        this.DW = i;
        this.FH = true;
    }

    void j6(long j, TimeUnit timeUnit) {
        this.FH = false;
        this.Hw = ang.DW.schedule(this, j, timeUnit);
    }

    public void run() {
        this.FH = true;
    }

    void j6(ang ang, int i) {
        this.Zo += i;
        if (this.DW != 0) {
            int i2 = (this.Zo * 100) / this.DW;
            if (this.FH) {
                ang.j6(this.j6, this.Zo, this.DW, i2);
                this.v5 = true;
                j6();
                this.VH = i2;
            } else if (i2 != this.VH) {
                ang.j6(this.j6, this.Zo, this.DW, i2);
                this.v5 = true;
                this.VH = i2;
            }
        } else if (this.FH) {
            ang.DW(this.j6, this.Zo);
            this.v5 = true;
            j6();
        }
    }

    private void j6() {
        this.FH = false;
        this.Hw = ang.DW.schedule(this, 1, TimeUnit.SECONDS);
    }

    void j6(ang ang) {
        if (this.v5) {
            if (this.DW == 0) {
                ang.FH(this.j6, this.Zo);
            } else {
                ang.DW(this.j6, this.Zo, this.DW, (this.Zo * 100) / this.DW);
            }
        }
        if (this.Hw != null) {
            this.Hw.cancel(false);
        }
    }
}
