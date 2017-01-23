package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.app.l */
public class C0375l extends Dialog implements C0374f {
    private C0349g f962a;

    public C0375l(Context context, int i) {
        super(context, C0375l.m1062a(context, i));
        m1063a().m873a(null);
        m1063a().m890i();
    }

    private static int m1062a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0417R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0349g m1063a() {
        if (this.f962a == null) {
            this.f962a = C0349g.m865a((Dialog) this, (C0374f) this);
        }
        return this.f962a;
    }

    public boolean m1064a(int i) {
        return m1063a().m884c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m1063a().m881b(view, layoutParams);
    }

    public View findViewById(int i) {
        return m1063a().m871a(i);
    }

    public void invalidateOptionsMenu() {
        m1063a().m886e();
    }

    protected void onCreate(Bundle bundle) {
        m1063a().m889h();
        super.onCreate(bundle);
        m1063a().m873a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m1063a().m882c();
    }

    public void onSupportActionModeFinished(C0413b c0413b) {
    }

    public void onSupportActionModeStarted(C0413b c0413b) {
    }

    public C0413b onWindowStartingSupportActionMode(C0345a c0345a) {
        return null;
    }

    public void setContentView(int i) {
        m1063a().m879b(i);
    }

    public void setContentView(View view) {
        m1063a().m875a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m1063a().m876a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m1063a().m877a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m1063a().m877a(charSequence);
    }
}
