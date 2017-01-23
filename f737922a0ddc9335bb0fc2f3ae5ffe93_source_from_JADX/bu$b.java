import java.util.Vector;

class bu$b {
    final /* synthetic */ bu DW;
    public Vector<bu$a> j6;

    public bu$b(bu buVar) {
        this.DW = buVar;
        this.j6 = new Vector();
    }

    public bu$b(bu buVar, ee eeVar) {
        this.DW = buVar;
        int readInt = eeVar.readInt();
        this.j6 = new Vector(readInt);
        for (int i = 0; i < readInt; i++) {
            this.j6.addElement(new bu$a(buVar, eeVar));
        }
    }

    protected void j6(ef efVar) {
        efVar.writeInt(this.j6.size());
        for (int i = 0; i < this.j6.size(); i++) {
            ((bu$a) this.j6.elementAt(i)).j6(efVar);
        }
    }
}
