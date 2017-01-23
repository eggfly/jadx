package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.appcompat.C0417R;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.d */
public class C0424d extends ContextWrapper {
    private int f1063a;
    private Theme f1064b;
    private LayoutInflater f1065c;

    public C0424d(Context context, int i) {
        super(context);
        this.f1063a = i;
    }

    public C0424d(Context context, Theme theme) {
        super(context);
        this.f1064b = theme;
    }

    private void m1240a() {
        boolean z = this.f1064b == null;
        if (z) {
            this.f1064b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1064b.setTo(theme);
            }
        }
        m1241a(this.f1064b, this.f1063a, z);
    }

    protected void m1241a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1065c == null) {
            this.f1065c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1065c;
    }

    public Theme getTheme() {
        if (this.f1064b != null) {
            return this.f1064b;
        }
        if (this.f1063a == 0) {
            this.f1063a = C0417R.style.Theme_AppCompat_Light;
        }
        m1240a();
        return this.f1064b;
    }

    public int getThemeResId() {
        return this.f1063a;
    }

    public void setTheme(int i) {
        if (this.f1063a != i) {
            this.f1063a = i;
            m1240a();
        }
    }
}
