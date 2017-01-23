import android.app.Activity;
import android.view.ViewGroup;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class iq {
    private List<ir> DW;
    private Activity FH;
    private it Hw;
    private boolean Zo;
    private HashMap<it$a, is> j6;
    private int v5;

    public iq() {
        this.v5 = 0;
    }

    public boolean j6() {
        return (!e.Mr().Hw() || Zo()) && !e.VH();
    }

    private boolean Zo() {
        return Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
    }

    public void DW() {
        this.j6 = new HashMap();
        this.DW = new ArrayList();
        this.FH = e.tp();
    }

    public void j6(ViewGroup viewGroup) {
        if (!j6()) {
        }
    }

    public void j6(it itVar) {
        this.Hw = itVar;
        if (j6()) {
            this.Zo = true;
            e.Mr().j6(this.FH, itVar.j6(), "run_command_" + itVar.DW().toString(), false, true);
        }
    }

    public boolean FH() {
        return this.Zo;
    }

    public void Hw() {
        this.Zo = false;
    }

    public boolean v5() {
        if (!j6()) {
            return false;
        }
        for (it$a it_a : this.j6.keySet()) {
            if (((is) this.j6.get(it_a)).j6()) {
                return true;
            }
        }
        return false;
    }

    public void j6(boolean z) {
        if (j6()) {
            for (ir irVar : this.DW) {
                if (z) {
                    irVar.j6(true);
                    irVar.j6();
                } else {
                    irVar.DW();
                }
            }
        }
    }
}
