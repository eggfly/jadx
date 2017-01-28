class aqm extends apv {
    private final apv j6;

    aqm(apv apv) {
        this.j6 = apv;
    }

    void j6(apm apm) {
        this.j6.j6(apm);
    }

    int DW() {
        return this.j6.DW() & -5;
    }

    aqc j6() {
        Object obj = null;
        aqc j6 = this.j6.j6();
        if (j6 == null) {
            return null;
        }
        aqc[] aqcArr = j6.u7;
        int length = aqcArr.length;
        for (int i = 0; i < length; i++) {
            aqc aqc = aqcArr[i];
            aqc j62 = j6(aqc);
            if (aqc != j62) {
                aqcArr[i] = j62;
                obj = 1;
            }
        }
        if (obj != null) {
            j6.u7 = j6(aqcArr);
        }
        return j6;
    }

    private aqc j6(aqc aqc) {
        while (true) {
            aqc[] aqcArr = aqc.u7;
            if (aqcArr.length > 1 || (aqc.we & 4) != 0 || (aqc.we & 8) == 0) {
                return aqc;
            }
            if (aqcArr.length == 0) {
                return null;
            }
            aqc = aqcArr[0];
        }
    }

    private aqc[] j6(aqc[] aqcArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < aqcArr.length; i++) {
            aqc aqc = aqcArr[i];
            if (aqc != null) {
                if ((aqc.we & 16) != 0) {
                    aqcArr[i] = null;
                } else {
                    aqc.we |= 16;
                    i3++;
                }
            }
        }
        if (i3 == aqcArr.length) {
            i = aqcArr.length;
            while (i2 < i) {
                aqc aqc2 = aqcArr[i2];
                aqc2.we &= -17;
                i2++;
            }
            return aqcArr;
        }
        aqc[] aqcArr2 = new aqc[i3];
        int length = aqcArr.length;
        int i4 = 0;
        while (i4 < length) {
            aqc aqc3 = aqcArr[i4];
            if (aqc3 != null) {
                i = i2 + 1;
                aqcArr2[i2] = aqc3;
                aqc3.we &= -17;
            } else {
                i = i2;
            }
            i4++;
            i2 = i;
        }
        return aqcArr2;
    }
}
