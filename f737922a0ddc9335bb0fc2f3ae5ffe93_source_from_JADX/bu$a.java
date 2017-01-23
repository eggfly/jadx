import java.util.Vector;

class bu$a {
    public final int DW;
    public final int FH;
    public final int Hw;
    public final String VH;
    public final int Zo;
    public Vector<bu$c> gn;
    public final int j6;
    final /* synthetic */ bu u7;
    public final int v5;

    public bu$a(bu buVar, int i, int i2, int i3, int i4, String str, int i5, int i6) {
        this.u7 = buVar;
        this.j6 = i5;
        this.DW = i6;
        this.FH = i;
        this.Hw = i2;
        this.v5 = i3;
        this.Zo = i4;
        this.VH = str;
    }

    public bu$a(bu buVar, ee eeVar) {
        this.u7 = buVar;
        this.j6 = eeVar.readInt();
        this.DW = eeVar.readInt();
        this.FH = eeVar.readInt();
        this.Hw = eeVar.readInt();
        this.v5 = eeVar.readInt();
        this.Zo = eeVar.readInt();
        this.VH = eeVar.readUTF();
        int readInt = eeVar.readInt();
        if (readInt > 0) {
            this.gn = new Vector(readInt);
            for (int i = 0; i < readInt; i++) {
                this.gn.addElement(new bu$c(buVar, eeVar));
            }
        }
    }

    protected void j6(ef efVar) {
        efVar.writeInt(this.j6);
        efVar.writeInt(this.DW);
        efVar.writeInt(this.FH);
        efVar.writeInt(this.Hw);
        efVar.writeInt(this.v5);
        efVar.writeInt(this.Zo);
        efVar.writeUTF(this.VH);
        if (this.gn == null) {
            efVar.writeInt(0);
            return;
        }
        efVar.writeInt(this.gn.size());
        for (int i = 0; i < this.gn.size(); i++) {
            ((bu$c) this.gn.elementAt(i)).j6(efVar);
        }
    }
}
