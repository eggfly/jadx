import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class azj extends ayr {
    private ayr[] DW;

    private static byte[] j6(ayr[] ayrArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != ayrArr.length) {
            try {
                byteArrayOutputStream.write(((bah) ayrArr[i]).Hw());
                i++;
            } catch (ClassCastException e) {
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(ayrArr[i].getClass().getName())).append(" found in input should only contain DEROctetString").toString());
            } catch (IOException e2) {
                throw new IllegalArgumentException("exception converting octets " + e2.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public azj(byte[] bArr) {
        super(bArr);
    }

    public azj(ayr[] ayrArr) {
        super(j6(ayrArr));
        this.DW = ayrArr;
    }

    public byte[] Hw() {
        return this.j6;
    }

    public Enumeration tp() {
        if (this.DW == null) {
            return EQ().elements();
        }
        return new azj$1(this);
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

    boolean gn() {
        return true;
    }

    int u7() {
        Enumeration tp = tp();
        int i = 0;
        while (tp.hasMoreElements()) {
            i = ((ayh) tp.nextElement()).w_().u7() + i;
        }
        return (i + 2) + 2;
    }

    public void j6(ayt ayt) {
        ayt.DW(36);
        ayt.DW(128);
        Enumeration tp = tp();
        while (tp.hasMoreElements()) {
            ayt.j6((ayh) tp.nextElement());
        }
        ayt.DW(0);
        ayt.DW(0);
    }
}
