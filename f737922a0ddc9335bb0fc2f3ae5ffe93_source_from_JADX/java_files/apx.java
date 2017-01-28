import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

class apx extends apv {
    private final apo DW;
    private int FH;
    private int Hw;
    private final aql j6;
    private int v5;

    apx(aql aql) {
        this.j6 = aql;
        this.DW = new apo();
    }

    void j6(apj apj) {
        while (true) {
            try {
                aqc j6 = apj.j6();
                if (j6 == null) {
                    break;
                }
                j6(j6);
            } finally {
                this.j6.DW(this.FH);
                this.Hw = this.FH | 16;
                this.v5 = (this.FH | 16) | 8;
            }
        }
    }

    private void j6(aqc aqc) {
        int QX = this.j6.QX();
        this.FH |= QX;
        if ((aqc.we & this.FH) != 0) {
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().staleRevFlagsOn, new Object[]{aqc.DW()}));
        }
        aqc.we = QX | aqc.we;
        this.DW.j6(aqc);
    }

    int DW() {
        return 0;
    }

    aqc j6() {
        while (true) {
            aqc j6 = this.DW.j6();
            if (j6 == null) {
                this.j6.DW.DW();
                return null;
            }
            Object obj;
            for (aqc aqc : j6.u7) {
                if ((aqc.we & 2) == 0) {
                    if ((aqc.we & 1) == 0) {
                        aqc.j6(this.j6);
                    }
                    aqc.we |= 2;
                    this.DW.j6(aqc);
                }
            }
            int i = j6.we & this.FH;
            if (i == this.FH) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i |= 8;
            }
            j6(j6, i);
            if ((j6.we & 8) == 0) {
                j6.we |= 16;
                if (obj != null) {
                    j6.we |= 8;
                    return j6;
                }
            } else if (this.DW.j6(8)) {
                return null;
            }
        }
    }

    private void j6(aqc aqc, int i) {
        do {
            aqc[] aqcArr = aqc.u7;
            if (aqcArr != null) {
                int length = aqcArr.length;
                if (length != 0) {
                    for (int i2 = 1; i2 < length; i2++) {
                        aqc aqc2 = aqcArr[i2];
                        if (!DW(aqc2, i)) {
                            j6(aqc2, i);
                        }
                    }
                    aqc = aqcArr[0];
                } else {
                    return;
                }
            }
            return;
        } while (!DW(aqc, i));
    }

    private boolean DW(aqc aqc, int i) {
        boolean z = (aqc.we & i) == i;
        aqc.we |= i;
        if ((aqc.we & this.v5) != this.Hw) {
            return z;
        }
        aqc.we &= -17;
        this.DW.j6(aqc);
        j6(aqc, this.FH | 8);
        return true;
    }
}
