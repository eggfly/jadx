import com.aide.ui.h;

class pt$2 implements Runnable {
    final /* synthetic */ pt j6;

    pt$2(pt ptVar) {
        this.j6 = ptVar;
    }

    public void run() {
        this.j6.cn();
        if (h.QX()) {
            this.j6.u7.j6(this.j6.gW().j6(), this.j6.yS().we() + " " + this.j6.gW().EQ());
        }
        if (h.XL()) {
            this.j6.FH.play(this.j6.VH, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        this.j6.VH(this.j6.yS());
        this.j6.vJ();
        this.j6.Sf();
    }
}
