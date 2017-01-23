package com.baidu.mobads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;

/* renamed from: com.baidu.mobads.o */
class C2003o implements OnKeyListener {
    final /* synthetic */ SslErrorHandler f6982a;
    final /* synthetic */ C1998j f6983b;

    C2003o(C1998j c1998j, SslErrorHandler sslErrorHandler) {
        this.f6983b = c1998j;
        this.f6982a = sslErrorHandler;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        this.f6982a.cancel();
        dialogInterface.dismiss();
        return true;
    }
}
