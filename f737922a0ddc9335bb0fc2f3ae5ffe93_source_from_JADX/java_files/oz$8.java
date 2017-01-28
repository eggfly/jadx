import android.app.Activity;
import com.aide.common.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class oz$8 implements Runnable {
    final /* synthetic */ List DW;
    final /* synthetic */ List FH;
    final /* synthetic */ Runnable Hw;
    final /* synthetic */ Activity j6;
    final /* synthetic */ oz v5;

    oz$8(oz ozVar, Activity activity, List list, List list2, Runnable runnable) {
        this.v5 = ozVar;
        this.j6 = activity;
        this.DW = list;
        this.FH = list2;
        this.Hw = runnable;
    }

    public void run() {
        if (this.v5.Hw != null) {
            m.j6(this.j6, new nq());
            return;
        }
        List arrayList = new ArrayList();
        Iterator it = new HashSet(this.DW).iterator();
        while (it.hasNext()) {
            arrayList.add((iw$g) it.next());
        }
        this.v5.Hw = new oz$d(this.v5, this.j6, new oz$b(this.v5, this.j6, arrayList, this.FH, this.Hw));
        this.v5.VH = "Downloading Maven Libraries";
        this.v5.FH.execute(this.v5.Hw);
        m.j6(this.j6, new nq());
    }
}
