package com.igexin.sdk.p186a;

import android.content.Context;
import com.igexin.p158b.p159a.p167c.C3688a;
import java.io.File;
import java.io.IOException;

/* renamed from: com.igexin.sdk.a.c */
public class C3941c {
    private String f13242a;

    public C3941c(Context context) {
        if (context != null) {
            context.getFilesDir();
            this.f13242a = "/data/data/" + context.getPackageName() + "/files/" + "push.pid";
        }
    }

    public void m16223a() {
        if (!m16225c() && this.f13242a != null) {
            try {
                new File(this.f13242a).createNewFile();
            } catch (IOException e) {
                C3688a.m15097b("SdkPushSwitch | switchOn, create file = " + this.f13242a + " exception, " + e.toString());
            }
        }
    }

    public void m16224b() {
        if (m16225c() && this.f13242a != null && !new File(this.f13242a).delete()) {
            C3688a.m15097b("SdkPushSwitch | switchOff, delete file = " + this.f13242a + " failed !!!!!!!!!!!!");
        }
    }

    public boolean m16225c() {
        return this.f13242a != null ? new File(this.f13242a).exists() : false;
    }
}
