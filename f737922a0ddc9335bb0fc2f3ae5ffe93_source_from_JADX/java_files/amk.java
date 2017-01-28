import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class amk {
    private final ConcurrentMap<Class<? extends amo>, CopyOnWriteArrayList<amj>> j6;

    public amk() {
        this.j6 = new ConcurrentHashMap();
    }

    public amj j6(amg amg) {
        return j6(amg.class, amg);
    }

    public <T extends amo> amj j6(Class<T> cls, T t) {
        amj amj = new amj(this, cls, t);
        j6(amj);
        return amj;
    }

    public void j6(amn amn) {
        List<amj> list = (List) this.j6.get(amn.j6());
        if (list != null) {
            for (amj amj : list) {
                amn.j6(amj.DW);
            }
        }
    }

    private void j6(amj amj) {
        List list = (List) this.j6.get(amj.j6);
        if (list == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            list = (List) this.j6.putIfAbsent(amj.j6, copyOnWriteArrayList);
            if (list == null) {
                list = copyOnWriteArrayList;
            }
        }
        list.add(amj);
    }
}
