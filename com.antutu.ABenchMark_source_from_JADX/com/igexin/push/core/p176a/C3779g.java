package com.igexin.push.core.p176a;

import com.igexin.push.core.bean.C3834n;
import java.util.Comparator;

/* renamed from: com.igexin.push.core.a.g */
class C3779g implements Comparator {
    final /* synthetic */ C3777e f12706a;

    C3779g(C3777e c3777e) {
        this.f12706a = c3777e;
    }

    public int m15580a(C3834n c3834n, C3834n c3834n2) {
        return !c3834n.m15785d().equals(c3834n2.m15785d()) ? c3834n.m15785d().compareTo(c3834n2.m15785d()) : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15580a((C3834n) obj, (C3834n) obj2);
    }
}
