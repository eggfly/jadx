package p023b.p024a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: b.a.bc */
public class bc implements Serializable {
    private static Map<Class<? extends aw>, Map<? extends Object, bc>> f2739d;
    public final String f2740a;
    public final byte f2741b;
    public final bd f2742c;

    static {
        f2739d = new HashMap();
    }

    public bc(String str, byte b, bd bdVar) {
        this.f2740a = str;
        this.f2741b = b;
        this.f2742c = bdVar;
    }

    public static void m3489a(Class<? extends aw> cls, Map<? extends Object, bc> map) {
        f2739d.put(cls, map);
    }
}
