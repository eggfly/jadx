package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.fz;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class p {
    private static volatile p j6;
    private final Context DW;
    private final List<q> FH;
    private final k Hw;
    private UncaughtExceptionHandler VH;
    private volatile fu Zo;
    private final a v5;

    class 1 implements Runnable {
        final /* synthetic */ p DW;
        final /* synthetic */ l j6;

        1(p pVar, l lVar) {
            this.DW = pVar;
            this.j6 = lVar;
        }

        public void run() {
            this.j6.gn().j6(this.j6);
            for (q j6 : this.DW.FH) {
                j6.j6(this.j6);
            }
            this.DW.DW(this.j6);
        }
    }

    private class a extends ThreadPoolExecutor {
        final /* synthetic */ p j6;

        class 1 extends FutureTask<T> {
            final /* synthetic */ a j6;

            1(a aVar, Runnable runnable, Object obj) {
                this.j6 = aVar;
                super(runnable, obj);
            }

            protected void setException(Throwable th) {
                UncaughtExceptionHandler DW = this.j6.j6.VH;
                if (DW != null) {
                    DW.uncaughtException(Thread.currentThread(), th);
                } else if (Log.isLoggable("GAv4", 6)) {
                    String valueOf = String.valueOf(th);
                    Log.e("GAv4", new StringBuilder(String.valueOf(valueOf).length() + 37).append("MeasurementExecutor: job failed with ").append(valueOf).toString());
                }
                super.setException(th);
            }
        }

        public a(p pVar) {
            this.j6 = pVar;
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }

        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new 1(this, runnable, t);
        }
    }

    private static class b implements ThreadFactory {
        private static final AtomicInteger j6;

        static {
            j6 = new AtomicInteger();
        }

        private b() {
        }

        public Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + j6.incrementAndGet());
        }
    }

    private static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    p(Context context) {
        Object applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.b.j6(applicationContext);
        this.DW = applicationContext;
        this.v5 = new a(this);
        this.FH = new CopyOnWriteArrayList();
        this.Hw = new k();
    }

    private void DW(l lVar) {
        com.google.android.gms.common.internal.b.FH("deliver should be called from worker thread");
        com.google.android.gms.common.internal.b.DW(lVar.Zo(), "Measurement must be submitted");
        List<r> FH = lVar.FH();
        if (!FH.isEmpty()) {
            Set hashSet = new HashSet();
            for (r rVar : FH) {
                Uri j6 = rVar.j6();
                if (!hashSet.contains(j6)) {
                    hashSet.add(j6);
                    rVar.j6(lVar);
                }
            }
        }
    }

    public static void Hw() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public static p j6(Context context) {
        com.google.android.gms.common.internal.b.j6((Object) context);
        if (j6 == null) {
            synchronized (p.class) {
                if (j6 == null) {
                    j6 = new p(context);
                }
            }
        }
        return j6;
    }

    public fz DW() {
        DisplayMetrics displayMetrics = this.DW.getResources().getDisplayMetrics();
        fz fzVar = new fz();
        fzVar.j6(com.google.android.gms.analytics.internal.p.j6(Locale.getDefault()));
        fzVar.DW(displayMetrics.widthPixels);
        fzVar.FH(displayMetrics.heightPixels);
        return fzVar;
    }

    public Context FH() {
        return this.DW;
    }

    public fu j6() {
        if (this.Zo == null) {
            synchronized (this) {
                if (this.Zo == null) {
                    fu fuVar = new fu();
                    PackageManager packageManager = this.DW.getPackageManager();
                    String packageName = this.DW.getPackageName();
                    fuVar.FH(packageName);
                    fuVar.Hw(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.DW.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        String str2 = "GAv4";
                        String str3 = "Error retrieving package info: appName set to ";
                        String valueOf = String.valueOf(packageName);
                        Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                    fuVar.j6(packageName);
                    fuVar.DW(str);
                    this.Zo = fuVar;
                }
            }
        }
        return this.Zo;
    }

    public <V> Future<V> j6(Callable<V> callable) {
        com.google.android.gms.common.internal.b.j6((Object) callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.v5.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    void j6(l lVar) {
        if (lVar.tp()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (lVar.Zo()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            l j6 = lVar.j6();
            j6.VH();
            this.v5.execute(new 1(this, j6));
        }
    }

    public void j6(Runnable runnable) {
        com.google.android.gms.common.internal.b.j6((Object) runnable);
        this.v5.submit(runnable);
    }

    public void j6(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.VH = uncaughtExceptionHandler;
    }
}
