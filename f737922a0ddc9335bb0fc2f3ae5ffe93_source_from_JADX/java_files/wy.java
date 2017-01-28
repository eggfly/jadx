public final class wy extends xb {
    public xd j6() {
        return xd.TYPE_HEADER_ITEM;
    }

    public int n_() {
        return 112;
    }

    public void j6(wq wqVar) {
    }

    public void j6(wq wqVar, acr acr) {
        int VH = wqVar.Zo().VH();
        xp Ws = wqVar.Ws();
        xp QX = wqVar.QX();
        int VH2 = Ws.VH();
        int VH3 = (QX.VH() + QX.o_()) - VH2;
        String j6 = wqVar.j6().j6();
        if (acr.j6()) {
            acr.j6(8, "magic: " + new abe(j6).u7());
            acr.j6(4, "checksum");
            acr.j6(20, "signature");
            acr.j6(4, "file_size:       " + add.j6(wqVar.DW()));
            acr.j6(4, "header_size:     " + add.j6(112));
            acr.j6(4, "endian_tag:      " + add.j6(305419896));
            acr.j6(4, "link_size:       0");
            acr.j6(4, "link_off:        0");
            acr.j6(4, "map_off:         " + add.j6(VH));
        }
        for (int i = 0; i < 8; i++) {
            acr.FH(j6.charAt(i));
        }
        acr.VH(24);
        acr.Hw(wqVar.DW());
        acr.Hw(112);
        acr.Hw(305419896);
        acr.VH(8);
        acr.Hw(VH);
        wqVar.VH().DW(acr);
        wqVar.tp().DW(acr);
        wqVar.EQ().DW(acr);
        wqVar.we().j6(acr);
        wqVar.J0().j6(acr);
        wqVar.gn().j6(acr);
        if (acr.j6()) {
            acr.j6(4, "data_size:       " + add.j6(VH3));
            acr.j6(4, "data_off:        " + add.j6(VH2));
        }
        acr.Hw(VH3);
        acr.Hw(VH2);
    }
}
