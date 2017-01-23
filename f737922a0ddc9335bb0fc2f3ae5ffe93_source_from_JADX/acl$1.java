import java.util.ArrayList;

class acl$1 implements aci$a {
    final /* synthetic */ acl j6;

    acl$1(acl acl) {
        this.j6 = acl;
    }

    public void j6(abz abz) {
        j6((aci) abz);
    }

    public void j6(acb acb) {
        j6((aci) acb);
    }

    public void DW(abz abz) {
        j6((aci) abz);
    }

    private void j6(aci aci) {
        zw VH = aci.VH();
        if (VH != null) {
            zq u7 = VH.u7();
            ArrayList arrayList = (ArrayList) this.j6.FH.get(u7);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.j6.FH.put(u7, arrayList);
            }
            arrayList.add(VH);
        }
        if (aci instanceof abz) {
            if (aci.v5().j6() == 56) {
                this.j6.Hw.add((abz) aci);
            } else if (aca.DW().j6(aci.Zo().Zo(), aci.DW())) {
                this.j6.v5.add((abz) aci);
            }
        } else if (aci instanceof acb) {
            this.j6.Zo.add((acb) aci);
        }
    }
}
