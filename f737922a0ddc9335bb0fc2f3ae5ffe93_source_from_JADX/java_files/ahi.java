import java.util.ArrayList;
import java.util.Iterator;

public class ahi {
    private int DW;
    private ahh FH;
    private ArrayList<ahj> Hw;
    private int j6;

    public ahi() {
        this.j6 = 0;
        this.DW = 0;
        this.FH = new ahh();
        this.Hw = new ArrayList();
    }

    public void j6() {
        this.j6 = 10000;
        this.DW = 0;
    }

    public void j6(int i) {
        this.j6 = i;
    }

    public void DW(int i) {
        this.DW = i;
    }

    public void j6(int i, String str) {
        this.DW++;
        int i2 = (this.DW * 100) / this.j6;
        Iterator it = this.Hw.iterator();
        while (it.hasNext()) {
            ahj ahj = (ahj) it.next();
            this.FH.j6(str);
            this.FH.j6(i2);
            this.FH.DW(i);
            ahj.j6(this.FH);
        }
    }
}
