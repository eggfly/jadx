package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.m */
class C2001m implements OnClickListener {
    final /* synthetic */ SslErrorHandler f6978a;
    final /* synthetic */ C1998j f6979b;

    C2001m(C1998j c1998j, SslErrorHandler sslErrorHandler) {
        this.f6979b = c1998j;
        this.f6978a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6978a.proceed();
    }
}
