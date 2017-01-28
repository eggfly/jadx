import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.aide.common.e;
import com.aide.engine.service.b.a;

class pb$1 implements ServiceConnection {
    final /* synthetic */ pb j6;

    pb$1(pb pbVar) {
        this.j6 = pbVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e.DW("Engine service connected to UI");
        this.j6.j6 = a.j6(iBinder);
        this.j6.FH();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        e.DW("Engine service disconnected from UI");
        this.j6.j6 = null;
        if (!this.j6.FH) {
            e.DW("Trying to restart engine service");
            this.j6.DW();
        }
    }
}
