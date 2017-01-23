import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class bbr extends ayp implements ayg {
    ayv j6;

    public bbr(Date date) {
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

    public ayv w_() {
        return this.j6;
    }
}
