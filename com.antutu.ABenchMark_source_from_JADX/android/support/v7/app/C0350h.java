package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.C0358b.C0356a;
import android.support.v7.view.C0380i;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.C0430g;
import android.support.v7.view.menu.C0447f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.app.h */
abstract class C0350h extends C0349g {
    final Context f810a;
    final Window f811b;
    final Callback f812c;
    final Callback f813d;
    final C0374f f814e;
    C0355a f815f;
    MenuInflater f816g;
    boolean f817h;
    boolean f818i;
    boolean f819j;
    boolean f820k;
    boolean f821l;
    private CharSequence f822m;
    private boolean f823n;

    /* renamed from: android.support.v7.app.h.a */
    private class C0379a implements C0356a {
        final /* synthetic */ C0350h f964a;

        private C0379a(C0350h c0350h) {
            this.f964a = c0350h;
        }

        public void m1067a(int i) {
            C0355a a = this.f964a.m891a();
            if (a != null) {
                a.m992a(i);
            }
        }
    }

    /* renamed from: android.support.v7.app.h.b */
    class C0381b extends C0380i {
        final /* synthetic */ C0350h f966a;

        C0381b(C0350h c0350h, Callback callback) {
            this.f966a = c0350h;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f966a.m896a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f966a.m895a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof C0447f)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f966a.m900b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f966a.m893a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0447f c0447f = menu instanceof C0447f ? (C0447f) menu : null;
            if (i == 0 && c0447f == null) {
                return false;
            }
            if (c0447f != null) {
                c0447f.m1412c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0447f == null) {
                return onPreparePanel;
            }
            c0447f.m1412c(false);
            return onPreparePanel;
        }
    }

    C0350h(Context context, Window window, C0374f c0374f) {
        this.f810a = context;
        this.f811b = window;
        this.f814e = c0374f;
        this.f812c = this.f811b.getCallback();
        if (this.f812c instanceof C0381b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f813d = m892a(this.f812c);
        this.f811b.setCallback(this.f813d);
    }

    public C0355a m891a() {
        m905l();
        return this.f815f;
    }

    Callback m892a(Callback callback) {
        return new C0381b(this, callback);
    }

    abstract void m893a(int i, Menu menu);

    public final void m894a(CharSequence charSequence) {
        this.f822m = charSequence;
        m899b(charSequence);
    }

    abstract boolean m895a(int i, KeyEvent keyEvent);

    abstract boolean m896a(KeyEvent keyEvent);

    abstract C0413b m897b(C0345a c0345a);

    public MenuInflater m898b() {
        if (this.f816g == null) {
            m905l();
            this.f816g = new C0430g(this.f815f != null ? this.f815f.m999c() : this.f810a);
        }
        return this.f816g;
    }

    abstract void m899b(CharSequence charSequence);

    abstract boolean m900b(int i, Menu menu);

    public void m901c(Bundle bundle) {
    }

    public void m902f() {
        this.f823n = true;
    }

    public final C0356a m903g() {
        return new C0379a();
    }

    public boolean m904i() {
        return false;
    }

    abstract void m905l();

    final C0355a m906m() {
        return this.f815f;
    }

    final Context m907n() {
        Context context = null;
        C0355a a = m891a();
        if (a != null) {
            context = a.m999c();
        }
        return context == null ? this.f810a : context;
    }

    public boolean m908o() {
        return false;
    }

    final boolean m909p() {
        return this.f823n;
    }

    final Callback m910q() {
        return this.f811b.getCallback();
    }

    final CharSequence m911r() {
        return this.f812c instanceof Activity ? ((Activity) this.f812c).getTitle() : this.f822m;
    }
}
