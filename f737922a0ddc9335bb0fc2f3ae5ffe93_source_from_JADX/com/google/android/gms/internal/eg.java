package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@eh
public class eg implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler DW;
    private Context FH;
    private VersionInfoParcel Hw;
    private UncaughtExceptionHandler j6;

    public eg(Context context, VersionInfoParcel versionInfoParcel, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.j6 = uncaughtExceptionHandler;
        this.DW = uncaughtExceptionHandler2;
        this.FH = context;
        this.Hw = versionInfoParcel;
    }

    private Throwable DW(Throwable th) {
        if (((Boolean) aq.gn.FH()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (j6(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (DW(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    private static boolean j6(Context context) {
        return ((Boolean) aq.VH.FH()).booleanValue();
    }

    protected boolean DW(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    String j6(Class cls, Throwable th, boolean z) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", f.FH().FH()).appendQueryParameter("js", this.Hw.DW).appendQueryParameter("appid", this.FH.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", aq.j6())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    public void j6(Throwable th, boolean z) {
        if (j6(this.FH)) {
            Throwable DW = DW(th);
            if (DW != null) {
                Class cls = th.getClass();
                List arrayList = new ArrayList();
                arrayList.add(j6(cls, DW, z));
                f.FH().j6(arrayList, f.Zo().DW());
            }
        }
    }

    protected boolean j6(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) aq.u7.FH())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(eh.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            b.j6(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean j6(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (j6(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (j6(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                j6(th, true);
                return;
            }
            j6(th, false);
        }
        if (this.j6 != null) {
            this.j6.uncaughtException(thread, th);
        } else if (this.DW != null) {
            this.DW.uncaughtException(thread, th);
        }
    }
}
