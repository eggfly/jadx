import android.widget.Toast;
import com.aide.ui.e;

class pb$2$1 implements Runnable {
    final /* synthetic */ pb$2 j6;

    pb$2$1(pb$2 pb_2) {
        this.j6 = pb_2;
    }

    public void run() {
        if (e.gn() != null) {
            Toast.makeText(e.gn(), "Out-of-memory exception in code analysis process. Make sure your VM heap size is high enough.", 1).show();
        }
    }
}
