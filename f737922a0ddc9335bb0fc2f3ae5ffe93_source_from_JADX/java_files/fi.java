public class fi {
    private final cc j6;

    public fi(cc ccVar) {
        this.j6 = ccVar;
    }

    public void j6(cj cjVar, bv bvVar, bj bjVar, int i, int i2) {
        int j6 = j6(bvVar, i, i2);
        int i3;
        if (j6 > 0) {
            this.j6.lg.j6();
            for (fo foVar : fp.j6) {
                this.j6.lg.j6(foVar.j6 + ":");
            }
            this.j6.lg.j6(bvVar, bjVar, i, i2, j6, false, false);
            return;
        }
        String DW = DW(bvVar, i, i2);
        if (DW != null) {
            fo[] foVarArr = fp.j6;
            int length = foVarArr.length;
            i3 = 0;
            while (i3 < length) {
                fo foVar2 = foVarArr[i3];
                if (!foVar2.j6.equals(DW) || foVar2.DW == null) {
                    i3++;
                } else {
                    this.j6.lg.j6();
                    for (fo$d fo_d : foVar2.DW.j6) {
                        for (fo$a fo_a : fo_d.j6) {
                            if (fo_a.j6()) {
                                this.j6.lg.j6(fo_a.gn);
                            }
                        }
                    }
                    this.j6.lg.j6(bvVar, bjVar, i, i2, FH(bvVar, i, i2), false, false);
                    return;
                }
            }
        }
        this.j6.lg.j6(bvVar, i, i2);
    }

    private int j6(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int length = j6.length() - 1;
        while (length >= 0 && Character.isLetter(j6.charAt(length)) && j6.charAt(length) != '-') {
            length--;
        }
        int i3 = length + 2;
        while (length >= 0 && j6.charAt(length) != '{' && j6.charAt(length) != ';') {
            if (!Character.isWhitespace(j6.charAt(length))) {
                return -1;
            }
            length--;
        }
        return i3;
    }

    private String DW(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int i3 = 0;
        while (i3 < j6.length() && Character.isWhitespace(j6.charAt(i3))) {
            i3++;
        }
        if (i3 == 0) {
            return null;
        }
        int i4 = i3;
        while (i4 < j6.length() && j6.charAt(i4) != ':') {
            if (!Character.isLetter(j6.charAt(i4)) && j6.charAt(i4) != '-') {
                return null;
            }
            i4++;
        }
        return j6.substring(i3, i4);
    }

    private int FH(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int length = j6.length() - 1;
        while (length > 0 && !Character.isWhitespace(j6.charAt(length)) && j6.charAt(length) != ':') {
            length--;
        }
        if (length == 0) {
            return -1;
        }
        return length + 2;
    }
}
