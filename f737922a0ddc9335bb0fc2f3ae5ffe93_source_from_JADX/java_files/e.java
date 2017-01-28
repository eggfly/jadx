import android.os.Build.VERSION;

public final class e {
    private e$a DW;
    private Object FH;
    private boolean Hw;
    private boolean j6;

    public boolean j6() {
        boolean z;
        synchronized (this) {
            z = this.j6;
        }
        return z;
    }

    public void DW() {
        if (j6()) {
            throw new g();
        }
    }

    public void FH() {
        synchronized (this) {
            if (this.j6) {
                return;
            }
            this.j6 = true;
            this.Hw = true;
            e$a e_a = this.DW;
            Object obj = this.FH;
            if (e_a != null) {
                try {
                    e_a.j6();
                } catch (Throwable th) {
                    synchronized (this) {
                    }
                    this.Hw = false;
                    notifyAll();
                }
            }
            if (obj != null) {
                f.j6(obj);
            }
            synchronized (this) {
                this.Hw = false;
                notifyAll();
            }
        }
    }

    public Object Hw() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.FH == null) {
                this.FH = f.j6();
                if (this.j6) {
                    f.j6(this.FH);
                }
            }
            obj = this.FH;
        }
        return obj;
    }
}
