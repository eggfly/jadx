package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.C0349g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class be extends ContextWrapper {
    private static final ArrayList<WeakReference<be>> f1979a;
    private Resources f1980b;
    private final Theme f1981c;

    static {
        f1979a = new ArrayList();
    }

    private be(Context context) {
        super(context);
        if (bj.m2567a()) {
            this.f1981c = getResources().newTheme();
            this.f1981c.setTo(context.getTheme());
            return;
        }
        this.f1981c = null;
    }

    public static Context m2498a(Context context) {
        if (!m2499b(context)) {
            return context;
        }
        Context context2;
        int size = f1979a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f1979a.get(i);
            context2 = weakReference != null ? (be) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new be(context);
        f1979a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m2499b(Context context) {
        return ((context instanceof be) || (context.getResources() instanceof bg) || (context.getResources() instanceof bj)) ? false : !C0349g.m868k() || VERSION.SDK_INT <= 20;
    }

    public Resources getResources() {
        if (this.f1980b == null) {
            this.f1980b = this.f1981c == null ? new bg(this, super.getResources()) : new bj(this, super.getResources());
        }
        return this.f1980b;
    }

    public Theme getTheme() {
        return this.f1981c == null ? super.getTheme() : this.f1981c;
    }

    public void setTheme(int i) {
        if (this.f1981c == null) {
            super.setTheme(i);
        } else {
            this.f1981c.applyStyle(i, true);
        }
    }
}
