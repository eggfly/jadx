import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

public class bge extends BasicPermission {
    private final int DW;
    private final String j6;

    public bge(String str, String str2) {
        super(str, str2);
        this.j6 = str2;
        this.DW = j6(str2);
    }

    private int j6(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(bhl.DW(str), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i |= 8;
            } else if (nextToken.equals("all")) {
                i |= 15;
            }
        }
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public String getActions() {
        return this.j6;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof bge) || !getName().equals(permission.getName())) {
            return false;
        }
        bge bge = (bge) permission;
        if ((this.DW & bge.DW) == bge.DW) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bge)) {
            return false;
        }
        bge bge = (bge) obj;
        if (this.DW == bge.DW && getName().equals(bge.getName())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getName().hashCode() + this.DW;
    }
}
