import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class bar extends ayv {
    private byte[] j6;

    public bar(String str) {
        this.j6 = bhl.FH(str);
        try {
            FH();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    bar(byte[] bArr) {
        this.j6 = bArr;
    }

    public Date FH() {
        return new SimpleDateFormat("yyMMddHHmmssz").parse(v5());
    }

    public Date Hw() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(tp());
    }

    public String v5() {
        String DW = bhl.DW(this.j6);
        if (DW.indexOf(45) >= 0 || DW.indexOf(43) >= 0) {
            int indexOf = DW.indexOf(45);
            if (indexOf < 0) {
                indexOf = DW.indexOf(43);
            }
            if (indexOf == DW.length() - 3) {
                DW = new StringBuilder(String.valueOf(DW)).append("00").toString();
            }
            if (indexOf == 10) {
                return DW.substring(0, 10) + "00GMT" + DW.substring(10, 13) + ":" + DW.substring(13, 15);
            }
            return DW.substring(0, 12) + "GMT" + DW.substring(12, 15) + ":" + DW.substring(15, 17);
        } else if (DW.length() == 11) {
            return DW.substring(0, 10) + "00GMT+00:00";
        } else {
            return DW.substring(0, 12) + "GMT+00:00";
        }
    }

    public String tp() {
        String v5 = v5();
        if (v5.charAt(0) < '5') {
            return "20" + v5;
        }
        return "19" + v5;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        int length = this.j6.length;
        return length + (bbg.j6(length) + 1);
    }

    void j6(ayt ayt) {
        ayt.DW(23);
        int length = this.j6.length;
        ayt.j6(length);
        for (int i = 0; i != length; i++) {
            ayt.DW(this.j6[i]);
        }
    }

    boolean j6(ayv ayv) {
        if (ayv instanceof bar) {
            return bhf.j6(this.j6, ((bar) ayv).j6);
        }
        return false;
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }

    public String toString() {
        return bhl.DW(this.j6);
    }
}
