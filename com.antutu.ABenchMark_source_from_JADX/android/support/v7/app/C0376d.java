package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.C0372c.C0369a;
import android.support.v7.appcompat.C0417R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.app.d */
public class C0376d extends C0375l implements DialogInterface {
    private C0372c f963a;

    /* renamed from: android.support.v7.app.d.a */
    public static class C0373a {
        private final C0369a f960a;
        private int f961b;

        public C0373a(Context context) {
            this(context, C0376d.m1065a(context, 0));
        }

        public C0373a(Context context, int i) {
            this.f960a = new C0369a(new ContextThemeWrapper(context, C0376d.m1065a(context, i)));
            this.f961b = i;
        }

        public Context m1055a() {
            return this.f960a.f893a;
        }

        public C0373a m1056a(OnKeyListener onKeyListener) {
            this.f960a.f910r = onKeyListener;
            return this;
        }

        public C0373a m1057a(Drawable drawable) {
            this.f960a.f896d = drawable;
            return this;
        }

        public C0373a m1058a(View view) {
            this.f960a.f899g = view;
            return this;
        }

        public C0373a m1059a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f960a.f912t = listAdapter;
            this.f960a.f913u = onClickListener;
            return this;
        }

        public C0373a m1060a(CharSequence charSequence) {
            this.f960a.f898f = charSequence;
            return this;
        }

        public C0376d m1061b() {
            C0376d c0376d = new C0376d(this.f960a.f893a, this.f961b, false);
            this.f960a.m1013a(c0376d.f963a);
            c0376d.setCancelable(this.f960a.f907o);
            if (this.f960a.f907o) {
                c0376d.setCanceledOnTouchOutside(true);
            }
            c0376d.setOnCancelListener(this.f960a.f908p);
            c0376d.setOnDismissListener(this.f960a.f909q);
            if (this.f960a.f910r != null) {
                c0376d.setOnKeyListener(this.f960a.f910r);
            }
            return c0376d;
        }
    }

    C0376d(Context context, int i, boolean z) {
        super(context, C0376d.m1065a(context, i));
        this.f963a = new C0372c(getContext(), this, getWindow());
    }

    static int m1065a(Context context, int i) {
        if (i >= ViewCompat.MEASURED_STATE_TOO_SMALL) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0417R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f963a.m1042a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f963a.m1048a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f963a.m1052b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f963a.m1047a(charSequence);
    }
}
