import android.app.Activity;
import com.aide.ui.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class oz$b implements Callable<Void> {
    private Activity DW;
    private Runnable FH;
    private List<iw$g> Hw;
    final /* synthetic */ oz j6;
    private List<iw$m> v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    public oz$b(oz ozVar, Activity activity, List<iw$g> list, List<iw$m> list2, Runnable runnable) {
        this.j6 = ozVar;
        this.DW = activity;
        this.FH = runnable;
        this.Hw = list;
        this.v5 = list2;
    }

    public Void j6() {
        List<iw$m> arrayList = new ArrayList();
        for (iw$m iw_m : this.v5) {
            if (!arrayList.contains(iw_m)) {
                arrayList.add(iw_m);
            }
        }
        boolean z = false;
        int i = 0;
        for (iw$g iw_g : this.Hw) {
            oz ozVar = this.j6;
            String str = iw_g.j6 + ":" + iw_g.DW;
            int i2 = i + 1;
            ozVar.j6(str, (i * 100) / this.Hw.size(), 0);
            for (iw$m iw_m2 : arrayList) {
                try {
                    String j6 = pk.j6(iw_m2, iw_g);
                    String DW = pk.DW(iw_m2, iw_g);
                    this.j6.j6(j6, DW, false);
                    if (new File(DW).exists()) {
                        j6 = ((ja) new ja().J0(DW)).FH(iw_g.Hw);
                        if (j6 != null) {
                            DW = pk.j6(iw_m2, iw_g, j6, ".pom");
                            String DW2 = pk.DW(iw_m2, iw_g, j6, ".pom");
                            String j62 = pk.j6(iw_m2, iw_g, j6, ".aar");
                            String DW3 = pk.DW(iw_m2, iw_g, j6, ".aar");
                            String j63 = pk.j6(iw_m2, iw_g, j6, ".jar");
                            String DW4 = pk.DW(iw_m2, iw_g, j6, ".jar");
                            if ((!new File(DW4).exists() && !new File(DW3).exists()) || !new File(DW2).exists()) {
                                this.j6.j6(DW, DW2, true);
                                try {
                                    this.j6.j6(j62, DW3, true);
                                } catch (IOException e) {
                                }
                                try {
                                    this.j6.j6(j63, DW4, true);
                                } catch (IOException e2) {
                                }
                                if ((new File(DW4).exists() || new File(DW3).exists()) && new File(DW2).exists()) {
                                    i = i2;
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } catch (IOException e3) {
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            i = i2;
        }
        e.j6(new oz$b$1(this, z));
        return null;
    }
}
