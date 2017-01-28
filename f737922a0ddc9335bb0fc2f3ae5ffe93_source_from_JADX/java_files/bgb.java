import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class bgb implements bgj {
    private Vector DW;
    private Hashtable j6;

    bgb(Hashtable hashtable, Vector vector) {
        this.j6 = hashtable;
        this.DW = vector;
    }

    public bgb() {
        this(new Hashtable(), new Vector());
    }

    public void j6(ayq ayq, ayh ayh) {
        if (this.j6.containsKey(ayq)) {
            this.j6.put(ayq, ayh);
            return;
        }
        this.j6.put(ayq, ayh);
        this.DW.addElement(ayq);
    }

    public ayh j6(bag bag) {
        return (ayh) this.j6.get(bag);
    }

    public Enumeration j6() {
        return this.DW.elements();
    }
}
