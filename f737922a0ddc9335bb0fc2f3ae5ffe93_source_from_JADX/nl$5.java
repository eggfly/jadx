import com.aide.ui.e;
import java.math.BigInteger;
import java.util.Date;

class nl$5 implements Runnable {
    final /* synthetic */ String DW;
    final /* synthetic */ String EQ;
    final /* synthetic */ String FH;
    final /* synthetic */ String Hw;
    final /* synthetic */ String J0;
    final /* synthetic */ nl J8;
    final /* synthetic */ BigInteger VH;
    final /* synthetic */ Date Zo;
    final /* synthetic */ String gn;
    final /* synthetic */ String j6;
    final /* synthetic */ String tp;
    final /* synthetic */ String u7;
    final /* synthetic */ Date v5;
    final /* synthetic */ String we;

    nl$5(nl nlVar, String str, String str2, String str3, String str4, Date date, Date date2, BigInteger bigInteger, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.J8 = nlVar;
        this.j6 = str;
        this.DW = str2;
        this.FH = str3;
        this.Hw = str4;
        this.v5 = date;
        this.Zo = date2;
        this.VH = bigInteger;
        this.gn = str5;
        this.u7 = str6;
        this.tp = str7;
        this.EQ = str8;
        this.we = str9;
        this.J0 = str10;
    }

    public void run() {
        e.j6(new nl$5$1(this, e.SI().j6(this.j6, this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH, this.gn, this.u7, this.tp, this.EQ, this.we, this.J0)));
    }
}
