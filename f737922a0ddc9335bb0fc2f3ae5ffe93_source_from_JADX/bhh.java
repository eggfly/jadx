import java.util.ArrayList;
import java.util.Collection;

public class bhh implements bhj {
    private Collection j6;

    public bhh(Collection collection) {
        this.j6 = new ArrayList(collection);
    }

    public Collection j6(bhi bhi) {
        if (bhi == null) {
            return new ArrayList(this.j6);
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.j6) {
            if (bhi.j6(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
