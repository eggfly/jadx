import com.aide.ui.e;
import java.io.IOException;

class kb$1$1 implements Runnable {
    final /* synthetic */ kb$1 j6;

    kb$1$1(kb$1 kb_1) {
        this.j6 = kb_1;
    }

    public void run() {
        try {
            String v5 = qh.v5(this.j6.j6);
            qh.j3(this.j6.j6);
            e.j6(new kb$1$1$1(this, v5));
        } catch (IOException e) {
            e.j6(new kb$1$1$2(this, e));
        }
    }
}
