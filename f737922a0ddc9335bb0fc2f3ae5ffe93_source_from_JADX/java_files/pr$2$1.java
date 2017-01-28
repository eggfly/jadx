import com.aide.common.b;
import com.aide.engine.SourceEntity;
import com.aide.ui.activities.a;
import com.aide.ui.e;

class pr$2$1 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ int FH;
    final /* synthetic */ int Hw;
    final /* synthetic */ SourceEntity j6;
    final /* synthetic */ pr$2 v5;

    pr$2$1(pr$2 pr_2, SourceEntity sourceEntity, String str, int i, int i2) {
        this.v5 = pr_2;
        this.j6 = sourceEntity;
        this.DW = str;
        this.FH = i;
        this.Hw = i2;
    }

    public void run() {
        e.u7().J0();
        if (this.v5.j6.FH) {
            String QX = this.j6.QX();
            e.u7().sh().QX();
            b.j6(e.u7(), QX, a.EQ().toString());
        } else if (this.v5.j6.Hw || this.j6.Hw() || this.j6.J0() == null) {
            this.v5.j6.Hw();
            e.XL().j6(this.DW, this.FH, this.Hw, this.v5.j6.v5);
        } else {
            e.rN().j6(new qg(this.DW, this.v5.j6.VH, this.v5.j6.gn, this.v5.j6.u7, this.v5.j6.tp));
            e.u7().j6(new qg(this.j6.J0(), this.j6.u7(), this.j6.tp(), this.j6.u7(), this.j6.EQ()));
        }
    }
}
