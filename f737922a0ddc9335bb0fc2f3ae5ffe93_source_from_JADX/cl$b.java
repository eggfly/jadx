import java.util.Stack;

class cl$b {
    private Stack<cj> DW;
    private Stack<cj> FH;
    final /* synthetic */ cl j6;

    private cl$b(cl clVar) {
        this.j6 = clVar;
        this.DW = new Stack();
        this.FH = new Stack();
    }

    public void j6() {
        this.DW = new Stack();
        this.FH = new Stack();
    }

    public cj DW() {
        if (this.DW.isEmpty()) {
            cj cjVar = new cj(this.j6.VH);
            this.FH.push(cjVar);
            return cjVar;
        }
        cjVar = (cj) this.DW.pop();
        this.FH.push(cjVar);
        return cjVar;
    }

    public void j6(cj cjVar) {
        if (this.FH.contains(cjVar)) {
            this.FH.removeElement(cjVar);
            this.DW.push(cjVar);
        }
    }

    public void FH() {
        for (int i = 0; i < this.FH.size(); i++) {
            this.DW.addElement(this.FH.elementAt(i));
        }
        this.FH.setSize(0);
    }
}
