import java.io.FileNotFoundException;

class ajq$d extends ajq {
    private final awd DW;
    private String FH;
    private awd Hw;
    private final awc j6;

    ajq$d(awd awd) {
        this.j6 = new awc(null);
        this.DW = awd;
    }

    public long j6(String str, ans ans) {
        j6(str);
        return this.Hw.QX();
    }

    public anx DW(String str, ans ans) {
        j6(str);
        return new ajq$d$1(this);
    }

    private void j6(String str) {
        if (!str.equals(this.FH)) {
            this.DW.VH();
            this.j6.u7();
            this.j6.j6(this.DW);
            this.j6.j6(awi.j6(str));
            this.FH = str;
            if (this.j6.EQ()) {
                this.Hw = (awd) this.j6.j6(0, awd.class);
                if (this.Hw == null) {
                    throw new FileNotFoundException(str);
                }
                return;
            }
            throw new FileNotFoundException(str);
        }
    }
}
