import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ani$c {
    final Map<Object, Object> DW;
    final ani$c FH;
    final List<ani$a> j6;

    ani$c(List<ani$a> list, ani$c ani_c) {
        this.j6 = list;
        this.DW = new ConcurrentHashMap(16, 0.75f, 1);
        this.FH = ani_c;
    }
}
