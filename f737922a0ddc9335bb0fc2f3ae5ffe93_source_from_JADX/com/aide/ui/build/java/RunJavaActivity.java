package com.aide.ui.build.java;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.aide.ui.R;
import com.aide.ui.build.OutputConsoleActivity;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class RunJavaActivity extends OutputConsoleActivity {
    private Class<?> FH;

    class 1 implements Runnable {
        final /* synthetic */ Object DW;
        final /* synthetic */ RunJavaActivity FH;
        final /* synthetic */ Method j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.FH.FH();
            }
        }

        1(RunJavaActivity runJavaActivity, Method method, Object obj) {
            this.FH = runJavaActivity;
            this.j6 = method;
            this.DW = obj;
        }

        public void run() {
            try {
                this.j6.invoke(null, new Object[]{this.DW});
            } catch (Throwable th) {
                if (th.getCause() != null) {
                    th.getCause().printStackTrace();
                } else {
                    th.printStackTrace();
                }
            }
            this.FH.DW.post(new 1(this));
        }
    }

    public static void j6(Activity activity, boolean z, String str, String str2, boolean z2) {
        j6(activity, RunJavaActivity.class, z, str, str2, z2, 0);
    }

    protected static void j6(Activity activity, Class<?> cls, boolean z, String str, String str2, boolean z2, int i) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("EXTRA_DEX", str);
        intent.putExtra("EXTRA_CLASS", str2);
        intent.putExtra("EXTRA_DEBUG", z2);
        OutputConsoleActivity.j6(activity, z, i, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        if (this.FH != null) {
            try {
                this.FH.getDeclaredMethod("disconnectDebugger", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    protected int DW() {
        return R.drawable.ic_launcher_java;
    }

    protected void j6() {
        String string = getIntent().getExtras().getString("EXTRA_DEX");
        String string2 = getIntent().getExtras().getString("EXTRA_CLASS");
        boolean booleanExtra = getIntent().getBooleanExtra("EXTRA_DEBUG", false);
        File dir = getDir("outdex", 0);
        for (File delete : dir.listFiles()) {
            delete.delete();
        }
        ClassLoader dexClassLoader = new DexClassLoader(string, dir.getPath(), null, ClassLoader.getSystemClassLoader());
        if (booleanExtra) {
            this.FH = dexClassLoader.loadClass("adrt/ADRT");
            this.FH.getDeclaredMethod("connectDebugger", new Class[]{Context.class, String.class, Boolean.TYPE, Boolean.TYPE}).invoke(null, new Object[]{getApplicationContext(), getPackageName(), Boolean.valueOf(false), Boolean.valueOf(false)});
        }
        Object obj = new String[0];
        Method declaredMethod = dexClassLoader.loadClass(string2).getDeclaredMethod("main", new Class[]{String[].class});
        System.setOut(this.j6.getPrintStream());
        System.setErr(this.j6.getPrintStream());
        System.setIn(this.j6.getInputStream());
        new Thread(new 1(this, declaredMethod, obj)).start();
    }
}
