import com.aide.ui.e;
import com.aide.ui.trainer.c.c;

class pt$1 implements Runnable {
    final /* synthetic */ pt j6;

    pt$1(pt ptVar) {
        this.j6 = ptVar;
    }

    public void run() {
        if (e.VH()) {
            boolean DW = e.lg().DW();
            for (c cVar : this.j6.tp.FH()) {
                if (cVar.Ws()) {
                    e.lg().j6(DW, cVar.gn(), cVar.EQ(), cVar.tp(), cVar.u7(), cVar.VH());
                }
            }
        }
    }
}
