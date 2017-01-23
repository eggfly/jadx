package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.n */
class C2002n implements OnClickListener {
    final /* synthetic */ SslErrorHandler f6980a;
    final /* synthetic */ C1998j f6981b;

    C2002n(C1998j c1998j, SslErrorHandler sslErrorHandler) {
        this.f6981b = c1998j;
        this.f6980a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6980a.cancel();
    }
}
