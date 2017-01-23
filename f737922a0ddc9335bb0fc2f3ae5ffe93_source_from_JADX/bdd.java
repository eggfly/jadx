import java.util.Hashtable;
import java.util.Vector;

public class bdd {
    private Vector DW;
    private Hashtable j6;

    public bdd() {
        this.j6 = new Hashtable();
        this.DW = new Vector();
    }

    public boolean j6() {
        return this.DW.isEmpty();
    }

    public bdc DW() {
        return new bdc(this.DW, this.j6);
    }
}
