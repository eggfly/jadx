package com.igexin.sdk.p186a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: com.igexin.sdk.a.b */
public class C3940b {
    private String f13241a;

    public C3940b(Context context) {
        if (context != null) {
            context.getFilesDir();
            this.f13241a = "/data/data/" + context.getPackageName() + "/files/" + "init.pid";
        }
    }

    public void m16221a() {
        if (!m16222b() && this.f13241a != null) {
            try {
                new File(this.f13241a).createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public boolean m16222b() {
        return this.f13241a != null ? new File(this.f13241a).exists() : false;
    }
}
