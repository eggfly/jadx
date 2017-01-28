import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.aide.licensing.IAideLicensingService.a;

class oa$1 implements ServiceConnection {
    final /* synthetic */ oa j6;

    oa$1(oa oaVar) {
        this.j6 = oaVar;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        io.FH("Licensing service unexpectedly disconnected.");
        this.j6.FH = false;
        this.j6.j6 = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.j6.DW("Licensing service connected.");
        this.j6.j6 = a.j6(iBinder);
        this.j6.FH = false;
        this.j6.VH();
    }
}
