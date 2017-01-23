package com.igexin.p156a;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.igexin.a.i */
class C3655i implements FilenameFilter {
    final /* synthetic */ String f12322a;
    final /* synthetic */ C3654h f12323b;

    C3655i(C3654h c3654h, String str) {
        this.f12323b = c3654h;
        this.f12322a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f12322a);
    }
}
