import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class aa$c$1 implements ac$a {
    final /* synthetic */ aa$c DW;
    final /* synthetic */ aa j6;

    aa$c$1(aa$c aa_c, aa aaVar) {
        this.DW = aa_c;
        this.j6 = aaVar;
    }

    public boolean j6(int i, int i2, Bundle bundle) {
        return this.j6.j6(i, i2, bundle);
    }

    public List<Object> j6(String str, int i) {
        List j6 = this.j6.j6(str, i);
        List<Object> arrayList = new ArrayList();
        int size = j6.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((v) j6.get(i2)).j6());
        }
        return arrayList;
    }

    public Object j6(int i) {
        v j6 = this.j6.j6(i);
        if (j6 == null) {
            return null;
        }
        return j6.j6();
    }

    public Object DW(int i) {
        v DW = this.j6.DW(i);
        if (DW == null) {
            return null;
        }
        return DW.j6();
    }
}
