import android.content.SharedPreferences.Editor;
import com.aide.ui.e;

class pi$2 implements Runnable {
    final /* synthetic */ pi j6;

    pi$2(pi piVar) {
        this.j6 = piVar;
    }

    public void run() {
        Editor edit = e.gn().getSharedPreferences("InAppBillingSettings", 0).edit();
        edit.putBoolean("WasPrimeAtSomePoint", true);
        edit.commit();
        this.j6.rN();
    }
}
