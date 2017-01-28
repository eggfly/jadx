import java.util.ArrayList;
import java.util.List;

public class cn {
    private int DW;
    private List<cm> j6;

    public cn() {
        this.j6 = new ArrayList();
    }

    public void j6() {
        this.j6 = new ArrayList();
    }

    public cm DW() {
        if (this.DW == this.j6.size()) {
            this.j6.add(new cm());
        }
        List list = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        cm cmVar = (cm) list.get(i);
        cmVar.j6();
        return cmVar;
    }

    public void j6(cm cmVar) {
        if (this.DW != 0) {
            if (this.j6.get(this.DW - 1) != cmVar) {
                int indexOf = this.j6.indexOf(cmVar);
                if (indexOf < this.DW) {
                    this.j6.set(indexOf, this.j6.get(this.DW - 1));
                    this.j6.set(this.DW - 1, cmVar);
                }
            }
            this.DW--;
        }
    }

    public void FH() {
        this.DW = 0;
    }
}
