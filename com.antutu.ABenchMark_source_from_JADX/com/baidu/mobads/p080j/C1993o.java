package com.baidu.mobads.p080j;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.taobao.accs.common.Constants;

/* renamed from: com.baidu.mobads.j.o */
class C1993o implements Runnable {
    final /* synthetic */ SharedPreferences f6967a;
    final /* synthetic */ String f6968b;
    final /* synthetic */ C1992n f6969c;

    C1993o(C1992n c1992n, SharedPreferences sharedPreferences, String str) {
        this.f6969c = c1992n;
        this.f6967a = sharedPreferences;
        this.f6968b = str;
    }

    public void run() {
        if (VERSION.SDK_INT >= 9) {
            this.f6967a.edit().putString(Constants.KEY_IMEI, this.f6968b).apply();
        } else {
            this.f6967a.edit().putString(Constants.KEY_IMEI, this.f6968b).commit();
        }
    }
}
