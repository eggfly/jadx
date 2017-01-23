import java.util.ArrayList;

public final class zn extends zo {
    private final aah DW;
    private final ArrayList<aah> j6;

    public zn(zz zzVar, aac aac, zx zxVar, ArrayList<aah> arrayList, aah aah) {
        super(zzVar, aac, null, zxVar);
        if (zzVar.Hw() != 1) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        this.j6 = arrayList;
        this.DW = aah;
    }

    public abn DW() {
        return abk.j6;
    }

    public ArrayList<aah> FH() {
        return this.j6;
    }

    public aah v5() {
        return this.DW;
    }

    public void j6(zo$b zo_b) {
        zo_b.j6(this);
    }

    public zo j6(abl abl) {
        throw new UnsupportedOperationException("unsupported");
    }

    public zo j6(zw zwVar, zx zxVar) {
        return new zn(Zo(), VH(), zxVar, this.j6, this.DW);
    }
}
