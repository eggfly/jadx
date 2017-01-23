package com.taobao.accs.p190a;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4137c;
import java.io.File;

/* renamed from: com.taobao.accs.a.c */
final class C4075c implements Runnable {
    final /* synthetic */ Context f13570a;
    final /* synthetic */ byte[] f13571b;
    final /* synthetic */ String f13572c;

    C4075c(Context context, byte[] bArr, String str) {
        this.f13570a = context;
        this.f13571b = bArr;
        this.f13572c = str;
    }

    public void run() {
        try {
            if (C4073a.f13564b == null) {
                Context context = this.f13570a;
                C4073a.m16614a();
            }
            C4073a.f13564b.mkdirs();
            C4137c.m16918a(this.f13571b, new File(this.f13572c));
        } catch (Throwable th) {
            ALog.m16902e(C4073a.TAG, "saveBlackList", th, new Object[0]);
        }
    }
}
