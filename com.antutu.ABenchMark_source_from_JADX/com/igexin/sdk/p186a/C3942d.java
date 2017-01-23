package com.igexin.sdk.p186a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: com.igexin.sdk.a.d */
public class C3942d {
    private String f13243a;
    private String f13244b;
    private Context f13245c;

    public C3942d(Context context) {
        if (context != null) {
            this.f13245c = context;
            context.getFilesDir();
            this.f13243a = "/data/data/" + context.getPackageName() + "/files/" + "run.pid";
            this.f13244b = "/data/data/" + context.getPackageName() + "/files/" + "stop.lock";
        }
    }

    public void m16226a() {
        if (!m16228c() && this.f13243a != null) {
            try {
                new File(this.f13243a).createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public void m16227b() {
        if (m16228c() && this.f13243a != null) {
            new File(this.f13243a).delete();
        }
    }

    public boolean m16228c() {
        File file = null;
        File file2 = this.f13243a != null ? new File(this.f13243a) : null;
        if (this.f13244b != null) {
            file = new File(this.f13244b);
        }
        if (file2 != null && file2.exists()) {
            if (file != null && file.exists()) {
                file.delete();
            }
            return true;
        } else if (file == null || !file.exists() || !file.renameTo(new File(this.f13243a))) {
            return false;
        } else {
            new C3941c(this.f13245c).m16223a();
            return true;
        }
    }
}
