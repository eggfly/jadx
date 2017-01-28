public class fh implements bc {
    private fl DW;
    private cc j6;

    public fh(cc ccVar, fl flVar) {
        this.j6 = ccVar;
        this.DW = flVar;
    }

    public void j6(bv bvVar, cm cmVar) {
        for (int i = 0; i < cmVar.u7; i++) {
            if (cmVar.j6[i] == 80) {
                try {
                    int i2 = cmVar.DW[i];
                    int parseLong;
                    if (cmVar.DW(i2) == 9) {
                        if (cmVar.VH[cmVar.FH(i2)] == '#') {
                            parseLong = (int) Long.parseLong(cmVar.Hw(i2).substring(1), 16);
                            this.j6.sG.j6(bvVar, this.DW, cmVar.FH[i], cmVar.v5[i], cmVar.Hw[i], cmVar.Zo[i], parseLong);
                        }
                    } else if (cmVar.DW(i2) == 7) {
                        if (cmVar.VH[cmVar.FH(i2)] == '#') {
                            parseLong = -16777216 | ((int) Long.parseLong(cmVar.Hw(i2).substring(1), 16));
                            this.j6.sG.j6(bvVar, this.DW, cmVar.FH[i], cmVar.v5[i], cmVar.Hw[i], cmVar.Zo[i], parseLong);
                        }
                    } else if (cmVar.DW(i2) == 4 && cmVar.VH[cmVar.FH(i2)] == '#') {
                        String Hw = cmVar.Hw(i2);
                        int parseInt = Integer.parseInt(Hw.substring(1, 2), 16);
                        int parseInt2 = Integer.parseInt(Hw.substring(2, 3), 16);
                        i2 = Integer.parseInt(Hw.substring(3, 4), 16);
                        parseLong = (((((parseInt << 16) | ((parseInt << 20) | -16777216)) | (parseInt2 << 12)) | (parseInt2 << 8)) | (i2 << 4)) | (i2 << 0);
                        this.j6.sG.j6(bvVar, this.DW, cmVar.FH[i], cmVar.v5[i], cmVar.Hw[i], cmVar.Zo[i], parseLong);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public co j6(cj cjVar, int i, int i2, String str) {
        return null;
    }

    public void j6(cj cjVar) {
    }

    public void j6(cj cjVar, ec ecVar) {
    }

    public void j6(cj cjVar, int i) {
    }

    public void DW(cj cjVar, int i) {
    }

    public void FH(cj cjVar, int i) {
    }

    public void DW(cj cjVar) {
    }

    public void FH(cj cjVar) {
    }
}
