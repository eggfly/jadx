package com.taobao.accs.p193d;

import android.content.SharedPreferences.Editor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p193d.C4091a.C4090a;
import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.d.b */
class C4092b extends Thread {
    final /* synthetic */ String f13652a;
    final /* synthetic */ String f13653b;
    final /* synthetic */ C4091a f13654c;

    C4092b(C4091a c4091a, String str, String str2) {
        this.f13654c = c4091a;
        this.f13652a = str;
        this.f13653b = str2;
    }

    public void run() {
        C4090a c4090a = new C4090a(this.f13652a, this.f13653b, null, C4091a.class.getClassLoader());
        ALog.m16901d("ACCSClassLoader", "dexOpt done", new Object[0]);
        this.f13654c.f13650c = false;
        if (c4090a != null) {
            Editor edit = this.f13654c.f13651d.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putBoolean(Constants.SP_KEY_UPDATE_DONE, true);
            edit.apply();
        }
    }
}
