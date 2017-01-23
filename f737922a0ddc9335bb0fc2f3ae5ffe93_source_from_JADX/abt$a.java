import java.util.ArrayList;
import java.util.BitSet;

class abt$a {
    abt$b DW;
    ArrayList<abt$a> FH;
    ArrayList<abt$a> Hw;
    BitSet j6;
    boolean v5;

    abt$a(int i, int i2, abt$b abt_b) {
        this.j6 = new BitSet(i2);
        this.j6.set(i);
        this.DW = abt_b;
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = false;
    }
}
