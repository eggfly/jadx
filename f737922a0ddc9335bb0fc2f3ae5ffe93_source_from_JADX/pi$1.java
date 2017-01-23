import android.os.IBinder;
import com.aide.analytics.a;
import com.aide.licensing.d;
import com.aide.ui.e;

class pi$1 implements d {
    final /* synthetic */ pi j6;

    pi$1(pi piVar) {
        this.j6 = piVar;
    }

    public IBinder asBinder() {
        return null;
    }

    public void j6() {
        a.DW("Licensed verification failed");
        e.u7().XL();
    }

    public void j6(String str, String str2) {
    }
}
