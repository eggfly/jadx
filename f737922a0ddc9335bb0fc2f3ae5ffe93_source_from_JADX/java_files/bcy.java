import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class bcy extends ayp implements ayg {
    ayv j6;

    public bcy(ayv ayv) {
        if ((ayv instanceof bar) || (ayv instanceof bab)) {
            this.j6 = ayv;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public bcy(Date date) {
        TimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int parseInt = Integer.parseInt(str.substring(0, 4));
        if (parseInt < 1950 || parseInt > 2049) {
            this.j6 = new bab(str);
        } else {
            this.j6 = new bar(str.substring(2));
        }
    }

    public static bcy j6(Object obj) {
        if (obj == null || (obj instanceof bcy)) {
            return (bcy) obj;
        }
        if (obj instanceof bar) {
            return new bcy((bar) obj);
        }
        if (obj instanceof bab) {
            return new bcy((bab) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public String FH() {
        if (this.j6 instanceof bar) {
            return ((bar) this.j6).tp();
        }
        return ((bab) this.j6).FH();
    }

    public Date Hw() {
        try {
            if (this.j6 instanceof bar) {
                return ((bar) this.j6).Hw();
            }
            return ((bab) this.j6).Hw();
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    public ayv w_() {
        return this.j6;
    }

    public String toString() {
        return FH();
    }
}
