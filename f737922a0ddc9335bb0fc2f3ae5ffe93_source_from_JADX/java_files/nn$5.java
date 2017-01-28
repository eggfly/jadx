import com.aide.ui.e;

class nn$5 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ String FH;
    final /* synthetic */ pn$a Hw;
    final /* synthetic */ String j6;
    final /* synthetic */ nn v5;

    nn$5(nn nnVar, String str, String str2, String str3, pn$a pn_a) {
        this.v5 = nnVar;
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = pn_a;
    }

    public void run() {
        e.j6(new nn$5$1(this, e.vy().j6(this.j6, this.DW, this.FH, "", this.Hw), e.vy().FH(this.j6, this.DW)));
    }
}
