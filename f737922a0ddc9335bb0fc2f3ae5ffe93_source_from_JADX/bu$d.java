import java.util.Vector;

class bu$d {
    public Vector<bu$a> DW;
    final /* synthetic */ bu FH;
    public Vector<bu$a> j6;

    public bu$d(bu buVar) {
        this.FH = buVar;
        this.j6 = new Vector();
        this.DW = new Vector();
    }

    public bu$d(bu buVar, ee eeVar) {
        int i;
        int i2 = 0;
        this.FH = buVar;
        int readInt = eeVar.readInt();
        this.j6 = new Vector(readInt);
        for (i = 0; i < readInt; i++) {
            this.j6.addElement(new bu$a(buVar, eeVar));
        }
        i = eeVar.readInt();
        this.DW = new Vector(i);
        while (i2 < i) {
            this.DW.addElement(new bu$a(buVar, eeVar));
            i2++;
        }
    }

    protected void j6(ef efVar) {
        int i = 0;
        efVar.writeInt(this.j6.size());
        for (int i2 = 0; i2 < this.j6.size(); i2++) {
            ((bu$a) this.j6.elementAt(i2)).j6(efVar);
        }
        efVar.writeInt(this.DW.size());
        while (i < this.DW.size()) {
            ((bu$a) this.DW.elementAt(i)).j6(efVar);
            i++;
        }
    }
}
