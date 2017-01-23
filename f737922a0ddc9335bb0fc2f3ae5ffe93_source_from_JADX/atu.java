import java.net.HttpURLConnection;

abstract class atu {
    static final atu j6;

    abstract void DW(HttpURLConnection httpURLConnection);

    abstract void j6(String str, String str2);

    atu() {
    }

    static {
        j6 = new atu$c();
    }

    static atu j6(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("WWW-Authenticate");
        if (headerField == null || headerField.length() == 0) {
            return j6;
        }
        int indexOf = headerField.indexOf(32);
        if (indexOf < 0) {
            return j6;
        }
        String substring = headerField.substring(0, indexOf);
        if ("Basic".equalsIgnoreCase(substring)) {
            return new atu$a();
        }
        if ("Digest".equalsIgnoreCase(substring)) {
            return new atu$b(headerField.substring(indexOf + 1));
        }
        return j6;
    }

    boolean j6(avn avn, atn atn) {
        String DW;
        String str;
        if (atn != null) {
            atm$e atm_e = new atm$e();
            atm$c atm_c = new atm$c();
            if (!atn.j6(atm_e, atm_c)) {
                return false;
            }
            if (!atn.j6(avn, atm_e, atm_c)) {
                return false;
            }
            DW = atm_e.DW();
            str = new String(atm_c.FH());
            atm_c.DW();
        } else {
            DW = avn.v5();
            str = avn.Zo();
        }
        if (DW == null) {
            return false;
        }
        j6(DW, str);
        return true;
    }
}
