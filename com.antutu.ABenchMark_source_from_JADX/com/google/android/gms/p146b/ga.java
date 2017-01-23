package com.google.android.gms.p146b;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.android.agoo.common.AgooConstants;

@gb
/* renamed from: com.google.android.gms.b.ga */
public class ga implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler f11005a;
    private UncaughtExceptionHandler f11006b;
    private Context f11007c;
    private VersionInfoParcel f11008d;

    public ga(Context context, VersionInfoParcel versionInfoParcel, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.f11005a = uncaughtExceptionHandler;
        this.f11006b = uncaughtExceptionHandler2;
        this.f11007c = context;
        this.f11008d = versionInfoParcel;
    }

    public static ga m12802a(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!ga.m12803a(context)) {
            return null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        UncaughtExceptionHandler gaVar = new ga(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof ga)) {
            return (ga) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(gaVar);
            return gaVar;
        } catch (Throwable e) {
            C2972b.m11582c("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private static boolean m12803a(Context context) {
        return ((Boolean) aq.f10293g.m11794c()).booleanValue();
    }

    private Throwable m12804b(Throwable th) {
        if (((Boolean) aq.f10294h.m11794c()).booleanValue()) {
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
                if (m12807a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (m12809b(stackTraceElement.getClassName())) {
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

    String m12805a(Class cls, Throwable th, boolean z) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme(HttpConstant.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(AgooConstants.MESSAGE_ID, "gmob-apps-report-exception").appendQueryParameter(Constants.KEY_OS_VERSION, VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", C2968s.m11525e().m13064d()).appendQueryParameter("js", this.f11008d.f10081b).appendQueryParameter(ACTD.APPID_KEY, this.f11007c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, aq.m11813a())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    public void m12806a(Throwable th, boolean z) {
        if (ga.m12803a(this.f11007c)) {
            Throwable b = m12804b(th);
            if (b != null) {
                Class cls = th.getClass();
                List arrayList = new ArrayList();
                arrayList.add(m12805a(cls, b, z));
                C2968s.m11525e().m13038a(this.f11007c, this.f11008d.f10081b, arrayList, C2968s.m11528h().m12951h());
            }
        }
    }

    protected boolean m12807a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(gb.class);
        } catch (Throwable e) {
            C2972b.m11577a("Fail to check class type for class " + str, e);
            return z;
        }
    }

    protected boolean m12808a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m12807a(stackTraceElement.getClassName())) {
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

    protected boolean m12809b(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (m12808a(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                m12806a(th, true);
                return;
            }
            m12806a(th, false);
        }
        if (this.f11005a != null) {
            this.f11005a.uncaughtException(thread, th);
        } else if (this.f11006b != null) {
            this.f11006b.uncaughtException(thread, th);
        }
    }
}
