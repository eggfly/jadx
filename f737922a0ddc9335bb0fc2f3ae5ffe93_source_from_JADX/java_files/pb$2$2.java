import android.widget.Toast;
import com.aide.ui.e;

class pb$2$2 implements Runnable {
    final /* synthetic */ pb$2 j6;

    pb$2$2(pb$2 pb_2) {
        this.j6 = pb_2;
    }

    public void run() {
        if (e.gn() != null) {
            Toast.makeText(e.gn(), "Internal exception in the code analysis process.", 0).show();
        }
    }
}
