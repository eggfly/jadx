package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import com.umeng.message.MsgConstant;

public class ac {
    private static ac f15005a;
    private Context f15006b;
    private int f15007c;

    private ac(Context context) {
        this.f15007c = 0;
        this.f15006b = context.getApplicationContext();
    }

    public static ac m18115a(Context context) {
        if (f15005a == null) {
            f15005a = new ac(context);
        }
        return f15005a;
    }

    public boolean m18116a() {
        return "@SHIP.TO.2A2FE0D7@".contains("xmsf") || "@SHIP.TO.2A2FE0D7@".contains(MsgConstant.MESSAGE_SYSTEM_SOURCE_XIAOMI) || "@SHIP.TO.2A2FE0D7@".contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int m18117b() {
        if (this.f15007c != 0) {
            return this.f15007c;
        }
        if (VERSION.SDK_INT >= 17) {
            this.f15007c = Global.getInt(this.f15006b.getContentResolver(), "device_provisioned", 0);
            return this.f15007c;
        }
        this.f15007c = Secure.getInt(this.f15006b.getContentResolver(), "device_provisioned", 0);
        return this.f15007c;
    }

    @SuppressLint({"NewApi"})
    public Uri m18118c() {
        return VERSION.SDK_INT >= 17 ? Global.getUriFor("device_provisioned") : Secure.getUriFor("device_provisioned");
    }
}
