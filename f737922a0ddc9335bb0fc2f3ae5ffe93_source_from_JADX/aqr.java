import java.util.Date;

public abstract class aqr extends aqt {
    final int j6;

    public static final aqt j6(Date date) {
        return j6(date.getTime());
    }

    public static final aqt j6(long j) {
        return new aqr$a(j);
    }

    aqr(long j) {
        this.j6 = (int) (j / 1000);
    }

    public aqt j6() {
        return this;
    }

    public boolean DW() {
        return false;
    }
}
