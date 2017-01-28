import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class aa$b$1 implements ab$a {
    final /* synthetic */ aa$b DW;
    final /* synthetic */ aa j6;

    aa$b$1(aa$b aa_b, aa aaVar) {
        this.DW = aa_b;
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
}
