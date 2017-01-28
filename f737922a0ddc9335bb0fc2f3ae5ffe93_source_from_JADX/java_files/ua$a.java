public class ua$a implements Comparable<ua$a> {
    private final int DW;
    private final abf j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ua$a) obj);
    }

    public ua$a(abf abf, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("handler < 0");
        } else if (abf == null) {
            throw new NullPointerException("exceptionType == null");
        } else {
            this.DW = i;
            this.j6 = abf;
        }
    }

    public int hashCode() {
        return (this.DW * 31) + this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ua$a) && j6((ua$a) obj) == 0) {
            return true;
        }
        return false;
    }

    public int j6(ua$a ua_a) {
        if (this.DW < ua_a.DW) {
            return -1;
        }
        if (this.DW > ua_a.DW) {
            return 1;
        }
        return this.j6.j6(ua_a.j6);
    }

    public abf j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }
}
