import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class bed implements bdq {
    private final Hashtable j6;

    public bed() {
        this.j6 = new Hashtable();
    }

    protected Hashtable DW(Map map) {
        Hashtable hashtable = (Hashtable) this.j6.clone();
        if (!hashtable.containsKey(bbk.j6)) {
            ayh ayh = (bag) map.get("contentType");
            if (ayh != null) {
                bbi bbi = new bbi(bbk.j6, new ban(ayh));
                hashtable.put(bbi.FH(), bbi);
            }
        }
        if (!hashtable.containsKey(bbk.FH)) {
            bbi = new bbi(bbk.FH, new ban(new bbr(new Date())));
            hashtable.put(bbi.FH(), bbi);
        }
        if (!hashtable.containsKey(bbk.DW)) {
            bbi = new bbi(bbk.DW, new ban(new bah((byte[]) map.get("digest"))));
            hashtable.put(bbi.FH(), bbi);
        }
        return hashtable;
    }

    public bbj j6(Map map) {
        return new bbj(DW(map));
    }
}
