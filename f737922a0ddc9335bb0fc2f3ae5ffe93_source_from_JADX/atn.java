import java.util.List;

public abstract class atn {
    private static volatile atn j6;

    public abstract boolean j6();

    public abstract boolean j6(avn avn, atm... atmArr);

    public abstract boolean j6(atm... atmArr);

    public static atn DW() {
        return j6;
    }

    public boolean j6(avn avn, List<atm> list) {
        return j6(avn, (atm[]) list.toArray(new atm[list.size()]));
    }

    public void j6(avn avn) {
    }
}
