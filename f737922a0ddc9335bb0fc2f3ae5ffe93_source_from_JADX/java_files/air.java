import java.util.ArrayList;
import java.util.Collection;

public class air extends aie<Collection<String>> {
    private final Collection<String> DW;

    public /* synthetic */ Object call() {
        return j6();
    }

    public air(aoh aoh) {
        super(aoh);
        this.DW = new ArrayList();
    }

    public Collection<String> j6() {
        Zo();
        try {
            atd j6 = atd.j6(this.j6);
            if (!this.DW.isEmpty()) {
                j6.j6(awj.j6(this.DW));
            }
            aol VH = this.j6.VH();
            Collection arrayList = new ArrayList();
            while (j6.DW()) {
                if (j6.Zo() == null) {
                    String FH = j6.FH();
                    String EQ = j6.EQ();
                    String u7 = j6.u7();
                    if (EQ != null) {
                        VH.j6("submodule", FH, "url", EQ);
                    }
                    if (u7 != null) {
                        VH.j6("submodule", FH, "update", u7);
                    }
                    if (EQ != null || u7 != null) {
                        arrayList.add(FH);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                VH.v5();
            }
            return arrayList;
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new ajg(e2.getMessage(), e2);
        }
    }
}
