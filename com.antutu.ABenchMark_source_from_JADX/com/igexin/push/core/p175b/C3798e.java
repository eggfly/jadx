package com.igexin.push.core.p175b;

import android.content.ContentValues;
import com.igexin.push.p173b.C3721d;

/* renamed from: com.igexin.push.core.b.e */
class C3798e extends C3721d {
    final /* synthetic */ long f12745a;
    final /* synthetic */ C3796c f12746b;

    C3798e(C3796c c3796c, ContentValues contentValues, long j) {
        this.f12746b = c3796c;
        this.f12745a = j;
        super(contentValues);
    }

    public void m15622a() {
        this.c.delete("ral", "id=?", new String[]{String.valueOf(this.f12745a)});
    }
}
