import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class bbj {
    private Hashtable j6;

    public bbj(Hashtable hashtable) {
        this.j6 = new Hashtable();
        this.j6 = j6(hashtable);
    }

    public ayi j6() {
        ayi ayi = new ayi();
        Enumeration elements = this.j6.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Vector) {
                Enumeration elements2 = ((Vector) nextElement).elements();
                while (elements2.hasMoreElements()) {
                    ayi.j6(bbi.j6(elements2.nextElement()));
                }
            } else {
                ayi.j6(bbi.j6(nextElement));
            }
        }
        return ayi;
    }

    private Hashtable j6(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }
}
