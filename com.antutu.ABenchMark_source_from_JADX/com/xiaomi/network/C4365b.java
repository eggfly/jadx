package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.network.b */
class C4365b extends Fallback {
    Fallback f14861i;
    final /* synthetic */ Fallback f14862j;
    final /* synthetic */ HostManager f14863k;

    C4365b(HostManager hostManager, String str, Fallback fallback) {
        this.f14863k = hostManager;
        this.f14862j = fallback;
        super(str);
        this.f14861i = this.f14862j;
        this.b = this.b;
        if (this.f14862j != null) {
            this.f = this.f14862j.f14845f;
        }
    }

    public synchronized ArrayList<String> m17935a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList();
        if (this.f14861i != null) {
            arrayList.addAll(this.f14861i.m17894a(true));
        }
        synchronized (HostManager.mReservedHosts) {
            ArrayList arrayList2 = (ArrayList) HostManager.mReservedHosts.get(this.b);
            if (arrayList2 != null) {
                ArrayList a;
                if (this.f14861i != null) {
                    a = this.f14861i.m17894a(false);
                } else {
                    ArrayList<String> arrayList3 = arrayList;
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (a.indexOf(str) == -1) {
                        arrayList.add(str);
                    }
                }
                arrayList.remove(this.b);
                arrayList.add(this.b);
            }
        }
        return arrayList;
    }

    public synchronized void m17936a(String str, AccessHistory accessHistory) {
        if (this.f14861i != null) {
            this.f14861i.m17901a(str, accessHistory);
        }
    }

    public boolean m17937b() {
        return false;
    }
}
