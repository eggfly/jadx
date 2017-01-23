import java.util.ArrayList;

public class ack implements Runnable {
    private int DW;
    private final int FH;
    private int Hw;
    private final ArrayList<zq> Zo;
    private final acj j6;
    private final zw[][] v5;

    public ack(acj acj) {
        int i = 0;
        this.FH = acj.VH();
        this.j6 = acj;
        this.DW = this.FH;
        this.Hw = 0;
        this.v5 = new zw[acj.tp().size()][];
        this.Zo = new ArrayList();
        zw[] zwVarArr = new zw[this.FH];
        while (i < this.FH) {
            zwVarArr[i] = zw.j6(i, abl.u7);
            i++;
        }
        this.v5[acj.FH()] = zwVarArr;
    }

    public ack(acj acj, int i) {
        this(acj);
        this.Hw = i;
    }

    public void run() {
        this.j6.j6(new ack$1(this));
        this.j6.v5(this.DW);
        this.j6.J0();
    }

    private static zw[] DW(zw[] zwVarArr) {
        Object obj = new zw[zwVarArr.length];
        System.arraycopy(zwVarArr, 0, obj, 0, zwVarArr.length);
        return obj;
    }

    private zq j6(int i) {
        if (i < this.Zo.size()) {
            return (zq) this.Zo.get(i);
        }
        return null;
    }

    private void j6(zw zwVar) {
        int VH = zwVar.VH();
        zq u7 = zwVar.u7();
        this.Zo.ensureCapacity(VH + 1);
        while (this.Zo.size() <= VH) {
            this.Zo.add(null);
        }
        this.Zo.set(VH, u7);
    }

    private boolean DW(int i) {
        return i < this.Hw;
    }

    private boolean FH(int i) {
        return i < this.FH;
    }

    private static boolean DW(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
