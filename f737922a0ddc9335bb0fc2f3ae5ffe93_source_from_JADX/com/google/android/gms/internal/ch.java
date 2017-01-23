package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@eh
public class ch implements Iterable<cg> {
    private final List<cg> j6;

    public ch() {
        this.j6 = new LinkedList();
    }

    private cg FH(fj fjVar) {
        Iterator it = f.EQ().iterator();
        while (it.hasNext()) {
            cg cgVar = (cg) it.next();
            if (cgVar.j6 == fjVar) {
                return cgVar;
            }
        }
        return null;
    }

    public void DW(cg cgVar) {
        this.j6.remove(cgVar);
    }

    public boolean DW(fj fjVar) {
        return FH(fjVar) != null;
    }

    public Iterator<cg> iterator() {
        return this.j6.iterator();
    }

    public void j6(cg cgVar) {
        this.j6.add(cgVar);
    }

    public boolean j6(fj fjVar) {
        cg FH = FH(fjVar);
        if (FH == null) {
            return false;
        }
        FH.DW.DW();
        return true;
    }
}
