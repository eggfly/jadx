public class bck extends ayp {
    private ayy j6;

    private bck(ayy ayy) {
        this.j6 = ayy;
    }

    public static bck j6(Object obj) {
        if (obj instanceof bck) {
            return (bck) obj;
        }
        if (obj != null) {
            return new bck(ayy.j6(obj));
        }
        return null;
    }

    public boolean FH() {
        return this.j6.Hw() > 1;
    }

    public bcj Hw() {
        if (this.j6.Hw() == 0) {
            return null;
        }
        return bcj.j6(this.j6.j6(0));
    }

    public bcj[] v5() {
        bcj[] bcjArr = new bcj[this.j6.Hw()];
        for (int i = 0; i != bcjArr.length; i++) {
            bcjArr[i] = bcj.j6(this.j6.j6(i));
        }
        return bcjArr;
    }

    public ayv w_() {
        return this.j6;
    }
}
