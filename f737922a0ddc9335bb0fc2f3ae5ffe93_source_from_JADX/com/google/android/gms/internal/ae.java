package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Iterator;
import java.util.List;

@eh
public class ae {
    private int DW;
    private List<ad> FH;
    private final Object j6;

    public boolean DW(ad adVar) {
        boolean z;
        synchronized (this.j6) {
            Iterator it = this.FH.iterator();
            while (it.hasNext()) {
                ad adVar2 = (ad) it.next();
                if (adVar != adVar2 && adVar2.DW().equals(adVar.DW())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void FH(ad adVar) {
        synchronized (this.j6) {
            if (this.FH.size() >= 10) {
                b.j6("Queue is full, current size = " + this.FH.size());
                this.FH.remove(0);
            }
            int i = this.DW;
            this.DW = i + 1;
            adVar.j6(i);
            this.FH.add(adVar);
        }
    }

    public boolean j6(ad adVar) {
        boolean z;
        synchronized (this.j6) {
            if (this.FH.contains(adVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
