public class ail {
    private final aij DW;
    private final aio FH;
    private final String Hw;
    private final att j6;

    ail(att att, String str, aij aij) {
        this.j6 = att;
        this.Hw = str;
        this.DW = aij;
        this.FH = null;
    }

    ail(att att, String str, aio aio) {
        this.j6 = att;
        this.Hw = str;
        this.DW = null;
        this.FH = aio;
    }

    public aij j6() {
        return this.DW;
    }

    public boolean DW() {
        if (this.DW != null) {
            return this.DW.j6().j6();
        }
        if (this.FH != null) {
            return this.FH.j6().j6();
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.j6 != null) {
            stringBuilder.append(this.j6.toString());
        } else {
            stringBuilder.append("No fetch result");
        }
        stringBuilder.append("\n");
        if (this.DW != null) {
            stringBuilder.append(this.DW.toString());
        } else if (this.FH != null) {
            stringBuilder.append(this.FH.toString());
        } else {
            stringBuilder.append("No update result");
        }
        return stringBuilder.toString();
    }
}
