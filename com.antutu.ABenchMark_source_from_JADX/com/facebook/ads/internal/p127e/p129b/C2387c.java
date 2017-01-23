package com.facebook.ads.internal.p127e.p129b;

import com.facebook.ads.internal.p127e.p129b.p130a.C2375a;
import com.facebook.ads.internal.p127e.p129b.p130a.C2378c;
import java.io.File;

/* renamed from: com.facebook.ads.internal.e.b.c */
class C2387c {
    public final File f8278a;
    public final C2378c f8279b;
    public final C2375a f8280c;

    C2387c(File file, C2378c c2378c, C2375a c2375a) {
        this.f8278a = file;
        this.f8279b = c2378c;
        this.f8280c = c2375a;
    }

    File m9179a(String str) {
        return new File(this.f8278a, this.f8279b.m9159a(str));
    }
}
