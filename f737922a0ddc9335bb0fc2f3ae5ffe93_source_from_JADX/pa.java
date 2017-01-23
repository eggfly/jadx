import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat.Builder;
import com.aide.ui.MainActivity;
import com.aide.ui.R;
import com.aide.ui.build.a.a;
import com.aide.ui.e;

public class pa implements a, pc$a {
    private static int j6;
    private int DW;
    private String FH;
    private String Hw;
    private int v5;

    static {
        j6 = 10;
    }

    public void DW() {
        e.aM().j6((pc$a) this);
        e.U2().j6((a) this);
    }

    public void FH() {
        ((NotificationManager) e.gn().getSystemService("notification")).cancel(j6);
    }

    public void DW(String str) {
        Hw();
    }

    public void Mr() {
        Hw();
    }

    public void i_() {
        Hw();
    }

    private void Hw() {
        if (!e.VH()) {
            String FH;
            int i;
            int FH2 = e.aM().FH();
            int Zo = e.aM().Zo();
            int v5 = e.aM().v5();
            if (Zo == 0) {
                v5 = 100;
            } else {
                v5 = (v5 * 100) / Zo;
            }
            int i2 = (v5 / 10) * 10;
            boolean Hw = e.aM().Hw();
            if (e.U2().DW()) {
                FH = e.U2().FH();
                i = 17301633;
            } else if (FH2 == 0) {
                FH = e.j6((int) R.f.view_no_errors, new Object[0]);
                i = R.drawable.project_no_errors_stat;
            } else {
                if (FH2 == 1) {
                    FH = e.j6((int) R.f.view_one_error, new Object[0]);
                } else {
                    FH = e.j6((int) R.f.view_errors, FH2 + "");
                }
                i = R.drawable.project_errors_stat;
            }
            String str = "";
            if (!Hw || (Zo <= 10 && !e.U2().DW())) {
                if (e.a8().u7() != null) {
                    str = e.j6((int) R.f.view_project, qh.Zo(e.a8().u7()));
                }
            } else {
                str = e.j6((int) R.f.view_percentage_done, i2 + "");
            }
            j6(i, FH, str, FH2);
        }
    }

    private void j6(int i, String str, String str2, int i2) {
        if (i != this.DW || !str.equals(this.FH) || !str2.equals(this.Hw) || i2 != this.v5) {
            this.DW = i;
            this.Hw = str2;
            this.FH = str;
            this.v5 = i2;
            long currentTimeMillis = System.currentTimeMillis();
            Builder j6 = new Builder(e.gn()).j6(currentTimeMillis).j6(i).j6((CharSequence) str).DW((CharSequence) str2).j6(MainActivity.v5(e.gn()));
            if (i2 > 0) {
                j6.DW(i2);
            }
            ((NotificationManager) e.gn().getSystemService("notification")).notify(j6, j6.j6());
        }
    }
}
