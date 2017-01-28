import java.util.Stack;

public class pg {
    private Stack<qg> DW;
    private boolean FH;
    private Stack<qg> j6;

    public pg() {
        this.j6 = new Stack();
        this.DW = new Stack();
        this.FH = true;
    }

    public boolean j6() {
        return this.FH;
    }

    public void j6(boolean z) {
        this.FH = z;
    }

    public void j6(qg qgVar) {
        j6(qgVar, false);
    }

    public void j6(qg qgVar, boolean z) {
        if (this.FH && qgVar.j6 != null) {
            if (z || this.j6.empty() || !((qg) this.j6.peek()).j6(qgVar)) {
                this.DW.clear();
            } else {
                this.j6.pop();
            }
            this.j6.add(qgVar);
        }
    }

    public boolean DW() {
        return !this.DW.isEmpty();
    }

    public boolean FH() {
        return this.j6.size() >= 2;
    }

    public qg Hw() {
        while (!this.DW.isEmpty()) {
            qg qgVar = (qg) this.DW.pop();
            if (qh.VH(qgVar.j6)) {
                this.j6.add(qgVar);
                return qgVar;
            }
        }
        return null;
    }

    public qg v5() {
        while (this.j6.size() >= 2) {
            qg qgVar = (qg) this.j6.pop();
            qg qgVar2 = (qg) this.j6.peek();
            if (qh.VH(qgVar2.j6)) {
                this.DW.push(qgVar);
                return qgVar2;
            }
        }
        return null;
    }

    public void Zo() {
        this.j6.clear();
        this.DW.clear();
    }
}
