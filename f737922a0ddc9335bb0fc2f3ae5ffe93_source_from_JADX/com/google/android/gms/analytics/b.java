package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.d.c;
import com.google.android.gms.analytics.internal.f;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class b implements UncaughtExceptionHandler {
    private final g DW;
    private final Context FH;
    private a Hw;
    private final UncaughtExceptionHandler j6;
    private c v5;

    public b(g gVar, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (gVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.j6 = uncaughtExceptionHandler;
            this.DW = gVar;
            this.Hw = new f(context, new ArrayList());
            this.FH = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            f.DW(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    UncaughtExceptionHandler DW() {
        return this.j6;
    }

    c j6() {
        if (this.v5 == null) {
            this.v5 = c.j6(this.FH);
        }
        return this.v5;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.Hw != null) {
            str = this.Hw.j6(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        f.DW(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.DW.j6(new c().j6(str).j6(true).j6());
        c j6 = j6();
        j6.u7();
        j6.tp();
        if (this.j6 != null) {
            f.DW("Passing exception to the original handler");
            this.j6.uncaughtException(thread, th);
        }
    }
}
