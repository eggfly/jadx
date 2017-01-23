package com.igexin.push.core.p175b;

import android.content.ContentValues;
import com.igexin.push.core.C3854f;
import com.igexin.push.p173b.C3721d;

/* renamed from: com.igexin.push.core.b.aa */
class aa extends C3721d {
    final /* synthetic */ ContentValues f12737a;
    final /* synthetic */ C3819z f12738b;

    aa(C3819z c3819z, ContentValues contentValues) {
        this.f12738b = c3819z;
        this.f12737a = contentValues;
    }

    public void m15606a() {
        C3854f.m15859a().m15881k().m15243a("st", this.f12737a);
        this.f12738b.f12780d = this.f12738b.f12780d + 1;
    }
}
