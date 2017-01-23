import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;

public final class yu {
    public final yu$a DW;
    public final yu$a EQ;
    public final yu$a FH;
    public final yu$a Hw;
    public final yu$a J0;
    public final yu$a J8;
    public final int Mr;
    public final yu$a QX;
    public final byte[] U2;
    public final yu$a VH;
    public final yu$a Ws;
    public final yu$a XL;
    public final yu$a Zo;
    public int a8;
    public final yu$a aM;
    public int er;
    public final yu$a gn;
    public final List<yu$a> j3;
    public final yu$a j6;
    public final int lg;
    public final int rN;
    public final yu$a tp;
    public final yu$a u7;
    public final yu$a v5;
    public final yu$a we;
    public int yS;

    public yu() {
        this.j6 = new yu$a(0);
        this.DW = new yu$a(1);
        this.FH = new yu$a(2);
        this.Hw = new yu$a(3);
        this.v5 = new yu$a(4);
        this.Zo = new yu$a(5);
        this.VH = new yu$a(6);
        this.gn = new yu$a(4096);
        this.u7 = new yu$a(ProxyTextView.INPUTTYPE_textCapCharacters);
        this.tp = new yu$a(ProxyTextView.INPUTTYPE_numberSigned);
        this.EQ = new yu$a(4099);
        this.we = new yu$a(8192);
        this.J0 = new yu$a(ProxyTextView.INPUTTYPE_textCapWords);
        this.J8 = new yu$a(ProxyTextView.INPUTTYPE_numberDecimal);
        this.Ws = new yu$a(8195);
        this.QX = new yu$a(8196);
        this.XL = new yu$a(8197);
        this.aM = new yu$a(8198);
        this.j3 = new ArrayList();
        this.Mr = 0;
        this.U2 = new byte[20];
        this.lg = 0;
        this.rN = 0;
    }

    public void j6(yt$a yt_a) {
        try {
            yt_a.j6(tp.j6(13).getBytes("UTF-8"));
            yt_a.v5(0);
            yt_a.j6(this.U2);
            yt_a.v5(this.a8);
            yt_a.v5(112);
            yt_a.v5(305419896);
            yt_a.v5(0);
            yt_a.v5(0);
            yt_a.v5(this.gn.FH);
            yt_a.v5(this.DW.DW);
            yt_a.v5(this.DW.FH);
            yt_a.v5(this.FH.DW);
            yt_a.v5(this.FH.FH);
            yt_a.v5(this.Hw.DW);
            yt_a.v5(this.Hw.FH);
            yt_a.v5(this.v5.DW);
            yt_a.v5(this.v5.FH);
            yt_a.v5(this.Zo.DW);
            yt_a.v5(this.Zo.FH);
            yt_a.v5(this.VH.DW);
            yt_a.v5(this.VH.FH);
            yt_a.v5(this.er);
            yt_a.v5(this.yS);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void j6(yt$a yt_a, List<yu$a> list) {
        int i = 0;
        for (yu$a j6 : list) {
            int i2;
            if (j6.j6()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        yt_a.v5(i);
        for (yu$a j62 : list) {
            if (j62.j6()) {
                yt_a.j6(j62.j6);
                yt_a.j6((short) 0);
                yt_a.v5(j62.DW);
                yt_a.v5(j62.FH);
            }
        }
    }
}
