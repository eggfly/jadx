import java.util.Enumeration;

class qq$c<T> implements Enumeration<T> {
    private int DW;
    private qq$a<T> j6;

    qq$c(qq$a<T> qq_a_T, int i) {
        this.j6 = qq_a_T;
        this.DW = i;
    }

    public boolean hasMoreElements() {
        while (this.j6 != null) {
            if (this.DW == -1 || (this.j6.j6 <= this.DW && this.j6.DW >= this.DW)) {
                return true;
            }
            this.j6 = this.j6.Hw;
        }
        return false;
    }

    public T nextElement() {
        T Hw = this.j6.FH;
        this.j6 = this.j6.Hw;
        return Hw;
    }
}
