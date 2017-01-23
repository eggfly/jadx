package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.C4454a;

/* renamed from: org.apache.thrift.meta_data.b */
public class C4601b implements Serializable {
    private static Map<Class<? extends C4454a>, Map<?, C4601b>> f16450d;
    public final String f16451a;
    public final byte f16452b;
    public final C4599c f16453c;

    static {
        f16450d = new HashMap();
    }

    public C4601b(String str, byte b, C4599c c4599c) {
        this.f16451a = str;
        this.f16452b = b;
        this.f16453c = c4599c;
    }

    public static void m19301a(Class<? extends C4454a> cls, Map<?, C4601b> map) {
        f16450d.put(cls, map);
    }
}
