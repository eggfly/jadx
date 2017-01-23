import java.util.Enumeration;
import java.util.Vector;

public class azh extends azj {
    private Vector DW;

    public byte[] Hw() {
        return this.j6;
    }

    public Enumeration tp() {
        if (this.DW == null) {
            return EQ().elements();
        }
        return this.DW.elements();
    }

    private Vector EQ() {
        Vector vector = new Vector();
        for (int i = 0; i < this.j6.length; i += 1000) {
            int length;
            if (i + 1000 > this.j6.length) {
                length = this.j6.length;
            } else {
                length = i + 1000;
            }
            Object obj = new byte[(length - i)];
            System.arraycopy(this.j6, i, obj, 0, obj.length);
            vector.addElement(new bah(obj));
        }
        return vector;
    }
}
