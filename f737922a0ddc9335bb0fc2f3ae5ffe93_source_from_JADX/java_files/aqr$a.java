import java.util.Date;

class aqr$a extends aqr {
    aqr$a(long j) {
        super(j);
    }

    public boolean j6(aql aql, aqc aqc) {
        if (aqc.gn() >= this.j6) {
            return true;
        }
        throw alv.j6;
    }

    public String toString() {
        return super.toString() + "(" + new Date(((long) this.j6) * 1000) + ")";
    }
}
