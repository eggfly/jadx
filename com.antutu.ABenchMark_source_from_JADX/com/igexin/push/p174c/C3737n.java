package com.igexin.push.p174c;

import java.util.Comparator;
import java.util.Map.Entry;

/* renamed from: com.igexin.push.c.n */
class C3737n implements Comparator {
    final /* synthetic */ C3734m f12612a;

    C3737n(C3734m c3734m) {
        this.f12612a = c3734m;
    }

    public int m15346a(Entry entry, Entry entry2) {
        return (int) (((C3731j) entry.getValue()).m15297e() - ((C3731j) entry2.getValue()).m15297e());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15346a((Entry) obj, (Entry) obj2);
    }
}
