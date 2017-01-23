public class yu$a implements Comparable<yu$a> {
    public int DW;
    public int FH;
    public final short j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((yu$a) obj);
    }

    public yu$a(int i) {
        this.DW = 0;
        this.FH = -1;
        this.j6 = (short) i;
    }

    public boolean j6() {
        return this.DW > 0;
    }

    public int j6(yu$a yu_a) {
        if (this.FH != yu_a.FH) {
            return this.FH < yu_a.FH ? -1 : 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.j6), Integer.valueOf(this.FH), Integer.valueOf(this.DW)});
    }
}
