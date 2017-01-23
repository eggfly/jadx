package com.aide.uidesigner;

import com.aide.uidesigner.h.a;
import java.util.HashMap;
import java.util.Map;

public class c {
    private Map<Class<?>, Object> DW;
    public Object j6;

    public c(Object obj) {
        this.DW = new HashMap();
        this.j6 = obj;
    }

    public void j6(a aVar, Object obj) {
        if (obj != null) {
            try {
                Object obj2 = this.j6;
                if (aVar.FH != null) {
                    obj2 = this.DW.get(aVar.FH);
                    if (obj2 == null) {
                        obj2 = aVar.FH.getConstructor(new Class[]{Object.class}).newInstance(new Object[]{this.j6});
                        this.DW.put(aVar.FH, obj2);
                    }
                }
                Object obj3 = obj2;
                if (aVar.DW.endsWith("()")) {
                    Class cls = aVar.v5.XL;
                    if (cls == Enum.class) {
                        cls = aVar.Zo;
                    }
                    String substring = aVar.DW.substring(0, aVar.DW.length() - 2);
                    obj3.getClass().getMethod(substring, new Class[]{cls}).invoke(obj3, new Object[]{obj});
                    return;
                }
                obj3.getClass().getField(aVar.DW).set(obj3, obj);
            } catch (Throwable th) {
            }
        }
    }

    public boolean j6(a aVar) {
        return aVar.j6 != null && aVar.j6.isInstance(this.j6);
    }
}
