package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.file.C4300c;
import com.xiaomi.push.log.C4371b.C4368b;
import com.xiaomi.push.log.C4371b.C4370c;
import java.io.File;
import java.util.Date;

/* renamed from: com.xiaomi.push.log.c */
class C4372c extends C4368b {
    File f14889a;
    final /* synthetic */ int f14890b;
    final /* synthetic */ Date f14891c;
    final /* synthetic */ Date f14892d;
    final /* synthetic */ String f14893e;
    final /* synthetic */ String f14894f;
    final /* synthetic */ boolean f14895g;
    final /* synthetic */ C4371b f14896h;

    C4372c(C4371b c4371b, int i, Date date, Date date2, String str, String str2, boolean z) {
        this.f14896h = c4371b;
        this.f14890b = i;
        this.f14891c = date;
        this.f14892d = date2;
        this.f14893e = str;
        this.f14894f = str2;
        this.f14895g = z;
        super(c4371b);
    }

    public void m17967b() {
        if (C4300c.m17641d()) {
            try {
                File file = new File(this.f14896h.f14888b.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    C4367a c4367a = new C4367a();
                    c4367a.m17947a(this.f14890b);
                    this.f14889a = c4367a.m17946a(this.f14896h.f14888b, this.f14891c, this.f14892d, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    public void m17968c() {
        if (this.f14889a != null && this.f14889a.exists()) {
            this.f14896h.f14887a.add(new C4370c(this.f14896h, this.f14893e, this.f14894f, this.f14889a, this.f14895g));
        }
        this.f14896h.m17958a(0);
    }
}
