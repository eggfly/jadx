package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.os.Message;
import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.p162a.p163a.p164a.C3662d;
import com.igexin.p158b.p159a.p167c.C3688a;
import java.net.Socket;

/* renamed from: com.igexin.b.a.b.a.a.e */
class C3672e implements C3662d {
    final /* synthetic */ C3671d f12386a;

    C3672e(C3671d c3671d) {
        this.f12386a = c3671d;
    }

    public void m15014a(C3667e c3667e) {
        this.f12387a.f12383o.sendEmptyMessage(3);
    }

    public void m15015a(Exception exception) {
        C3688a.m15097b(C3671d.f12369e + "|c ex = " + exception.toString());
        this.f12386a.m15011b();
    }

    public void m15016a(String str) {
        this.f12386a.f12383o.sendEmptyMessage(1);
    }

    public void m15017a(Socket socket) {
        Message obtain = Message.obtain();
        obtain.obj = socket;
        obtain.what = 2;
        this.f12386a.f12383o.sendMessage(obtain);
    }
}
