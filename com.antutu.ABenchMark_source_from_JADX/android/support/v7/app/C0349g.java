package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.C0358b.C0356a;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.app.g */
public abstract class C0349g {
    private static int f808a;
    private static boolean f809b;

    static {
        f808a = -1;
        f809b = false;
    }

    C0349g() {
    }

    public static C0349g m864a(Activity activity, C0374f c0374f) {
        return C0349g.m866a(activity, activity.getWindow(), c0374f);
    }

    public static C0349g m865a(Dialog dialog, C0374f c0374f) {
        return C0349g.m866a(dialog.getContext(), dialog.getWindow(), c0374f);
    }

    private static C0349g m866a(Context context, Window window, C0374f c0374f) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? new C0386k(context, window, c0374f) : i >= 14 ? new C0384j(context, window, c0374f) : i >= 11 ? new C0382i(context, window, c0374f) : new AppCompatDelegateImplV7(context, window, c0374f);
    }

    public static int m867j() {
        return f808a;
    }

    public static boolean m868k() {
        return f809b;
    }

    public abstract C0355a m869a();

    public abstract C0413b m870a(C0345a c0345a);

    public abstract View m871a(int i);

    public abstract void m872a(Configuration configuration);

    public abstract void m873a(Bundle bundle);

    public abstract void m874a(Toolbar toolbar);

    public abstract void m875a(View view);

    public abstract void m876a(View view, LayoutParams layoutParams);

    public abstract void m877a(CharSequence charSequence);

    public abstract MenuInflater m878b();

    public abstract void m879b(int i);

    public abstract void m880b(Bundle bundle);

    public abstract void m881b(View view, LayoutParams layoutParams);

    public abstract void m882c();

    public abstract void m883c(Bundle bundle);

    public abstract boolean m884c(int i);

    public abstract void m885d();

    public abstract void m886e();

    public abstract void m887f();

    public abstract C0356a m888g();

    public abstract void m889h();

    public abstract boolean m890i();
}
