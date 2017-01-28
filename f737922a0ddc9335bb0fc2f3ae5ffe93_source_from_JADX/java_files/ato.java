import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ato implements UIKeyboardInteractive, UserInfo {
    private final atn DW;
    private String FH;
    private String Hw;
    private final avn j6;

    public ato(Session session, atn atn) {
        this.j6 = j6(session);
        this.DW = atn;
    }

    private static avn j6(Session session) {
        return new avn().DW("ssh").Hw(session.gn()).j6(session.VH()).j6(session.u7());
    }

    public String DW() {
        return this.FH;
    }

    public String j6() {
        return this.Hw;
    }

    public boolean DW(String str) {
        atm$d v5 = v5(str);
        if (this.DW.j6(this.j6, v5)) {
            this.Hw = v5.DW();
            return true;
        }
        this.Hw = null;
        return false;
    }

    public boolean j6(String str) {
        atm$c atm_c = new atm$c(str);
        if (this.DW.j6(this.j6, atm_c)) {
            this.FH = new String(atm_c.FH());
            return true;
        }
        this.FH = null;
        return false;
    }

    private atm$d v5(String str) {
        return new atm$d(str, true);
    }

    public boolean FH(String str) {
        atm$f atm_f = new atm$f(str);
        if (this.DW.j6(this.j6, atm_f) && atm_f.DW()) {
            return true;
        }
        return false;
    }

    public void Hw(String str) {
        this.DW.j6(this.j6, new atm$b(str));
    }

    public String[] j6(String str, String str2, String str3, String[] strArr, boolean[] zArr) {
        int i = 0;
        atm$d[] atm_dArr = new atm$d[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            atm_dArr[i2] = new atm$d(strArr[i2], !zArr[i2]);
        }
        List arrayList = new ArrayList();
        if (str3 != null && str3.length() > 0) {
            arrayList.add(new atm$b(str3));
        }
        arrayList.addAll(Arrays.asList(atm_dArr));
        if (!this.DW.j6(this.j6, arrayList)) {
            return null;
        }
        String[] strArr2 = new String[atm_dArr.length];
        while (i < atm_dArr.length) {
            strArr2[i] = atm_dArr[i].DW();
            i++;
        }
        return strArr2;
    }
}
