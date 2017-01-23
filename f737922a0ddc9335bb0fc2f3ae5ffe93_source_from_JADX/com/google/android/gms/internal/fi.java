package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class fi {
    private final Map<String, Queue<es<?>>> DW;
    private List<a> EQ;
    private final Set<es<?>> FH;
    private final PriorityBlockingQueue<es<?>> Hw;
    private final cl VH;
    private final aa Zo;
    private final gi gn;
    private AtomicInteger j6;
    private ac tp;
    private cq[] u7;
    private final PriorityBlockingQueue<es<?>> v5;

    public interface a<T> {
        void j6(es<T> esVar);
    }

    public fi(aa aaVar, cl clVar) {
        this(aaVar, clVar, 4);
    }

    public fi(aa aaVar, cl clVar, int i) {
        this(aaVar, clVar, i, new bt(new Handler(Looper.getMainLooper())));
    }

    public fi(aa aaVar, cl clVar, int i, gi giVar) {
        this.j6 = new AtomicInteger();
        this.DW = new HashMap();
        this.FH = new HashSet();
        this.Hw = new PriorityBlockingQueue();
        this.v5 = new PriorityBlockingQueue();
        this.EQ = new ArrayList();
        this.Zo = aaVar;
        this.VH = clVar;
        this.u7 = new cq[i];
        this.gn = giVar;
    }

    public void DW() {
        if (this.tp != null) {
            this.tp.j6();
        }
        for (int i = 0; i < this.u7.length; i++) {
            if (this.u7[i] != null) {
                this.u7[i].j6();
            }
        }
    }

    <T> void DW(es<T> esVar) {
        synchronized (this.FH) {
            this.FH.remove(esVar);
        }
        synchronized (this.EQ) {
            for (a j6 : this.EQ) {
                j6.j6(esVar);
            }
        }
        if (esVar.QX()) {
            synchronized (this.DW) {
                Queue queue = (Queue) this.DW.remove(esVar.Hw());
                if (queue != null) {
                    if (hq.DW) {
                        hq.j6("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.Hw.addAll(queue);
                }
            }
        }
    }

    public int FH() {
        return this.j6.incrementAndGet();
    }

    public <T> es<T> j6(es<T> esVar) {
        esVar.j6(this);
        synchronized (this.FH) {
            this.FH.add(esVar);
        }
        esVar.j6(FH());
        esVar.DW("add-to-queue");
        if (esVar.QX()) {
            synchronized (this.DW) {
                String Hw = esVar.Hw();
                if (this.DW.containsKey(Hw)) {
                    Queue queue = (Queue) this.DW.get(Hw);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(esVar);
                    this.DW.put(Hw, queue);
                    if (hq.DW) {
                        hq.j6("Request for cacheKey=%s is in flight, putting on hold.", Hw);
                    }
                } else {
                    this.DW.put(Hw, null);
                    this.Hw.add(esVar);
                }
            }
        } else {
            this.v5.add(esVar);
        }
        return esVar;
    }

    public void j6() {
        DW();
        this.tp = new ac(this.Hw, this.v5, this.Zo, this.gn);
        this.tp.start();
        for (int i = 0; i < this.u7.length; i++) {
            cq cqVar = new cq(this.v5, this.VH, this.Zo, this.gn);
            this.u7[i] = cqVar;
            cqVar.start();
        }
    }
}
