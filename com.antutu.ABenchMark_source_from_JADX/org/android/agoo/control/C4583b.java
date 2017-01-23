package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService.ExtraInfo;

/* renamed from: org.android.agoo.control.b */
class C4583b implements Runnable {
    final /* synthetic */ byte[] f16416a;
    final /* synthetic */ String f16417b;
    final /* synthetic */ ExtraInfo f16418c;
    final /* synthetic */ AgooFactory f16419d;

    C4583b(AgooFactory agooFactory, byte[] bArr, String str, ExtraInfo extraInfo) {
        this.f16419d = agooFactory;
        this.f16416a = bArr;
        this.f16417b = str;
        this.f16418c = extraInfo;
    }

    public void run() {
        this.f16419d.msgReceiverPreHandler(this.f16416a, this.f16417b, this.f16418c, true);
    }
}
