package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.C0350h.C0381b;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.C0427f.C0426a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import anet.channel.util.ErrorConstant;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.app.j */
class C0384j extends C0382i {
    private static C0409s f968r;
    private int f969s;
    private boolean f970t;
    private boolean f971u;

    /* renamed from: android.support.v7.app.j.a */
    class C0383a extends C0381b {
        final /* synthetic */ C0384j f967b;

        C0383a(C0384j c0384j, Callback callback) {
            this.f967b = c0384j;
            super(c0384j, callback);
        }

        final ActionMode m1069a(ActionMode.Callback callback) {
            Object c0426a = new C0426a(this.f967b.a, callback);
            C0413b a = this.f967b.m952a((C0345a) c0426a);
            return a != null ? c0426a.m1262b(a) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f967b.m1077o() ? m1069a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    C0384j(Context context, Window window, C0374f c0374f) {
        super(context, window, c0374f);
        this.f969s = -100;
        this.f971u = true;
    }

    private boolean m1070e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private C0409s m1071t() {
        if (f968r == null) {
            f968r = new C0409s(this.a.getApplicationContext());
        }
        return f968r;
    }

    Callback m1072a(Callback callback) {
        return new C0383a(this, callback);
    }

    public void m1073a(Bundle bundle) {
        super.m957a(bundle);
        if (bundle != null && this.f969s == -100) {
            this.f969s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void m1074c(Bundle bundle) {
        super.m901c(bundle);
        if (this.f969s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f969s);
        }
    }

    int m1075d(int i) {
        switch (i) {
            case ErrorConstant.ERROR_UNKNOWN /*-100*/:
                return -1;
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return m1071t().m1140a() ? 2 : 1;
            default:
                return i;
        }
    }

    public boolean m1076i() {
        this.f970t = true;
        int d = m1075d(this.f969s == -100 ? C0349g.m867j() : this.f969s);
        return d != -1 ? m1070e(d) : false;
    }

    public boolean m1077o() {
        return this.f971u;
    }
}
