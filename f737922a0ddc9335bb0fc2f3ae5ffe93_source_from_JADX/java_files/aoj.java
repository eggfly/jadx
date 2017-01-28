import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class aoj {
    private static final aoj j6;
    private final ConcurrentHashMap<aoj$b, Reference<aoh>> DW;
    private final aoj$c[] FH;

    static {
        j6 = new aoj();
    }

    public static aoh j6(aoj$b aoj_b) {
        return j6(aoj_b, true);
    }

    public static aoh j6(aoj$b aoj_b, boolean z) {
        return j6.DW(aoj_b, z);
    }

    private aoj() {
        this.DW = new ConcurrentHashMap();
        this.FH = new aoj$c[4];
        for (int i = 0; i < this.FH.length; i++) {
            this.FH[i] = new aoj$c();
        }
    }

    private aoh DW(aoj$b aoj_b, boolean z) {
        Reference reference = (Reference) this.DW.get(aoj_b);
        aoh aoh = reference != null ? (aoh) reference.get() : null;
        if (aoh == null) {
            synchronized (DW(aoj_b)) {
                reference = (Reference) this.DW.get(aoj_b);
                if (reference != null) {
                    aoh = (aoh) reference.get();
                } else {
                    aoh = null;
                }
                if (aoh == null) {
                    aoh = aoj_b.j6(z);
                    this.DW.put(aoj_b, new SoftReference(aoh));
                }
            }
        }
        aoh.u7();
        return aoh;
    }

    private aoj$c DW(aoj$b aoj_b) {
        return this.FH[(aoj_b.hashCode() >>> 1) % this.FH.length];
    }
}
