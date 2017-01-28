import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class pf$5 implements ServiceConnection {
    final /* synthetic */ pf j6;

    pf$5(pf pfVar) {
        this.j6 = pfVar;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.j6.VH("service disconnected.");
        this.j6.gn = false;
        synchronized (this.j6.J0) {
            this.j6.u7 = null;
            this.j6.a8 = false;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.j6.VH("service connected.");
        synchronized (this.j6.J0) {
            this.j6.u7 = adu$a.j6(iBinder);
            this.j6.a8 = true;
            this.j6.J0.notifyAll();
        }
        this.j6.FH();
    }
}
