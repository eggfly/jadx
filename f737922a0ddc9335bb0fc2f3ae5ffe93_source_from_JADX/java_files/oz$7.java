import android.app.Activity;
import android.widget.Toast;
import com.aide.ui.build.android.m;
import com.aide.ui.e;
import java.io.IOException;

class oz$7 implements Runnable {
    final /* synthetic */ oz DW;
    final /* synthetic */ Activity j6;

    oz$7(oz ozVar, Activity activity) {
        this.DW = ozVar;
        this.j6 = activity;
    }

    public void run() {
        try {
            qh.j3(m.j6().getPath());
            Toast.makeText(e.gn(), "Uninstalled support for native code.", 0).show();
        } catch (IOException e) {
            com.aide.common.m.j6(this.j6, "Uninstallation failed", e.getCause());
        }
    }
}
